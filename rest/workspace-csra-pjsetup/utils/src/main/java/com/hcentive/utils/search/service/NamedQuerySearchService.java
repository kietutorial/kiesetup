/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchCriteria;
import com.hcentive.utils.search.model.SearchRequest;
import com.hcentive.utils.search.model.SearchResponse;
import com.hcentive.utils.search.model.SearchResult;
import com.hcentive.utils.search.model.SizeCriteria;
import com.hcentive.utils.search.model.SortCriteria;
import com.hcentive.utils.search.model.SortCriterion;

/**
 * Perform the search on database using namedQueries. NamedQueries should be
 * defined to use parameters from SearchRequest as queryParameters.
 * 
 * @author ashish.jaiswal
 */
public class NamedQuerySearchService implements SearchService {

	private static final Logger logger = LoggerFactory.getLogger(NamedQuerySearchService.class);

	protected static String ORDER_BY_KEY = "orderby";

	protected static String WHERE_CLAUSE_KEY = "whereClause";

	protected static String SYSTEM_WHERE_CLAUSE_KEY = "systemWhereClause";

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	protected String countQuerySuffix = "FoundRows";

	@Override
	@Transactional
	public SearchResponse search(SearchRequest searchInput) throws HCException {
		validateSearchInput(searchInput);
		final QuerySearchRequest namedQueryInput = extractNamedQueryInput(searchInput);
		logger.info("Named Query Input is " + namedQueryInput);
		return executeQuery(namedQueryInput);
	}

	protected void validateSearchInput(SearchRequest searchInput) throws HCException {
		if (!(searchInput instanceof QuerySearchRequest)) {
			throw new HCException(new MessageCode(
					"SearchRequest is not supported by this Service. Please use QuerySearchRequest or implement your own service."));
		}
		String queryId = ((QuerySearchRequest) searchInput).getQueryId();
		if (StringUtils.isEmpty(queryId)) {
			throw new HCException(new MessageCode("Query Id not provided."));
		} else if (queryId.endsWith(countQuerySuffix)) {
			logger.warn(
					"Executing a count query explicitly. Please use SearchRequest.getSizeCriteria().setGetFoundRowsCount(true) instead.",
					new IllegalArgumentException());
		}

		Iterator<SortCriterion> itr = searchInput.getSortCriteria().getSortCriteria().iterator();
		while (itr.hasNext()) {
			if (StringUtils.isBlank(itr.next().getName())) {
				itr.remove(); // Removing all OrderBy options where column name
								// is null or blank
			}
		}
		if (searchInput.getSortCriteria().getSortCriteria().size() == 0) {
			searchInput.getSortCriteria().getSortCriteria().add(new SortCriterion());
		}

		if (searchInput.getSizeCriteria().getResultSize() != null) {
			searchInput.getSizeCriteria().setDoFullExtract(false); // Result
																	// Size
																	// added so
																	// is not a
																	// full
																	// extract
		} else {
			searchInput.getSizeCriteria().setOffset(null); // Result Size not
															// provided so
															// offset should
															// also be null
		}

		if (searchInput.getSizeCriteria().isDoFullExtract()) {
			searchInput.getSizeCriteria().setGetFoundRowsCount(false); // Is a
																		// full
																		// extract
																		// so no
																		// need
																		// to
																		// fetch
																		// found
																		// rows
																		// using
																		// a
																		// seperate
																		// query.
																		// Can
																		// do
																		// results.size()
			searchInput.getSizeCriteria().setOffset(null); // Is a full extract
															// so no need for an
															// offset
			searchInput.getSizeCriteria().setResultSize(null); // Is a full
																// extract so no
																// need for a
																// result size
		}
	}

	protected SearchResponse executeQuery(final QuerySearchRequest namedQueryInput) throws HCException {

		Map<String, Object> searchParams = getSearchParameters(namedQueryInput);
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession(false);

			List<Object> list = sqlSession.selectList(namedQueryInput.getQueryId(), searchParams);
			SearchResult<?> result = new SearchResult<Object>(list);

			// No need to get Total resultSize in case pagination is not opted
			// for
			if (namedQueryInput.getSizeCriteria().isDoFullExtract()) {
				return new SearchResponse(namedQueryInput, result, result.getSize());
			}

			long rowsAvailable = result.getSize();
			if (namedQueryInput.getSizeCriteria().getGetFoundRowsCount()) {
				Long rowAvailableWrapper = (Long) sqlSession.selectOne(namedQueryInput.getQueryId() + countQuerySuffix,
						searchParams);
				if (rowAvailableWrapper != null) {
					rowsAvailable = rowAvailableWrapper;
				} else {
					rowsAvailable = 0;
				}
			}
			return new SearchResponse(namedQueryInput, result, rowsAvailable);
		} catch (Exception e) {
			throw new HCException(new MessageCode(e.getMessage()), e);
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	protected QuerySearchRequest extractNamedQueryInput(SearchRequest searchRequest) {
		final QuerySearchRequest namedQueryInput = (QuerySearchRequest) searchRequest;

		// Build orderby clause
		buildOrderByClause(namedQueryInput);

		SearchCriteria model = namedQueryInput.getSearchCriteria();
		SizeCriteria sizeCriteria = searchRequest.getSizeCriteria();
		if (!sizeCriteria.isDoFullExtract()) {
			model.put("length", sizeCriteria.getResultSize());
			model.put("start", sizeCriteria.getOffset());
			model.put("end", sizeCriteria.getOffset() + sizeCriteria.getResultSize());
			model.put("getFoundRowsCount", namedQueryInput.getSizeCriteria().getGetFoundRowsCount());
		}
		return namedQueryInput;
	}

	protected void buildOrderByClause(QuerySearchRequest searchRequest) {
		SortCriteria sc = searchRequest.getSortCriteria();
		String orderby = "1 ASC";
		if (sc != null && sc.size() != 0 && sc.getSortCriteria() != null) {
			StringBuilder orderByStringBuilder = new StringBuilder();
			for (SortCriterion s : sc.getSortCriteria()) {
				if (StringUtils.isNotEmpty(s.getName())) {
					orderByStringBuilder.append(s.getName()).append(s.isAscendingOrder() ? " ASC " : " DESC ").append(", ");
				}
			}
			if (orderByStringBuilder.length() > 0) {
				orderByStringBuilder.setLength(orderByStringBuilder.length() - 2);
				orderby = orderByStringBuilder.toString();
			}
		}
		SearchCriteria model = searchRequest.getSearchCriteria();
		model.put(ORDER_BY_KEY, orderby);
	}

	/**
	 * Build both the where Clause sent by the client and also the system where
	 * clause if populated by other sources such as security interceptors
	 * 
	 * @param searchInput
	 */
	private Map<String, Object> getSearchParameters(QuerySearchRequest searchInput) {
		Map<String, Object> sc = new HashMap<String, Object>();
		sc.putAll(searchInput.getSearchCriteria());

		if (null != searchInput.getSystemCriteria()) {
			sc.putAll(searchInput.getSystemCriteria());
		}
		return sc;
	}

	/*
	 * private List<Object> getResultsList(Object queryResult) { List<Object>
	 * resultList = null; if (queryResult instanceof Collection) { resultList =
	 * new ArrayList<Object>((Collection<?>) queryResult); } else if
	 * (queryResult.getClass().isArray()) { resultList =
	 * Arrays.asList((Object[]) queryResult); } else { resultList = new
	 * ArrayList<Object>(); resultList.add(queryResult); } return resultList; }
	 */

	public void setCountQuerySuffix(String countQuerySuffix) {
		this.countQuerySuffix = countQuerySuffix;
	}
}
