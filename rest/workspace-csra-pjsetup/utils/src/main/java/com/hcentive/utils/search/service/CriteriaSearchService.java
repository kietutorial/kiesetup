package com.hcentive.utils.search.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.search.model.CriteriaSearchRequest;
import com.hcentive.utils.search.model.SearchCriteria;
import com.hcentive.utils.search.model.SearchRequest;
import com.hcentive.utils.search.model.SearchResponse;
import com.hcentive.utils.search.model.SearchResult;
import com.hcentive.utils.search.model.SizeCriteria;
import com.hcentive.utils.search.model.SortCriteria;
import com.hcentive.utils.search.model.SortCriterion;

public class CriteriaSearchService implements SearchService, ApplicationContextAware {

	private static final Logger logger = LoggerFactory.getLogger(CriteriaSearchService.class);

	protected static String SORT_ORDER = "sortOrder";

	protected static String SORT_COLUMN = "sortColumn";

	protected String countQuerySuffix = "FoundRows";

	private ApplicationContext applicationContext;

	@PersistenceContext (unitName="DEFAULT")
	private EntityManager entityManager;

	@Override
	@Transactional
	public SearchResponse search(SearchRequest searchInput) throws HCException {
		validateSearchInput(searchInput);
		final CriteriaSearchRequest namedQueryInput = extractNamedQueryInput(searchInput);
		logger.info("Named Query Input is " + namedQueryInput);
		return executeQuery(namedQueryInput);
	}

	protected void validateSearchInput(SearchRequest searchInput) throws HCException {
		if (!(searchInput instanceof CriteriaSearchRequest)) {
			throw new HCException(new MessageCode(
					"SearchRequest is not supported by this Service. Please use QuerySearchRequest or implement your own service."));
		}
		String criteriaId = ((CriteriaSearchRequest) searchInput).getCriteriaId();
		if (StringUtils.isEmpty(criteriaId)) {
			throw new HCException(new MessageCode("Criteria Id not provided."));
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

	protected SearchResponse executeQuery(final CriteriaSearchRequest namedQueryInput) throws HCException {

		Map<String, Object> searchParams = getSearchParameters(namedQueryInput);
		CriteriaService criteriaService = (CriteriaService) applicationContext.getBean(namedQueryInput.getCriteriaId());
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		Metamodel metamodel = entityManager.getMetamodel();
		CriteriaQuery criteriaQuery = criteriaService.buildCriteria(criteriaBuilder, metamodel, searchParams);
		Query query = entityManager.createQuery(criteriaQuery);
		List<Object> list = query.getResultList();
		SearchResult<?> result = new SearchResult<Object>(list);
		int rowsAvailable = 0;
		
		// No need to get Total resultSize in case pagination is not opted for
		if (namedQueryInput.getSizeCriteria().isDoFullExtract() && !namedQueryInput.getSizeCriteria().getGetFoundRowsCount()) {
			return new SearchResponse(namedQueryInput, result, result.getSize());
		} else if (!namedQueryInput.getSizeCriteria().isDoFullExtract()) {
			query.setFirstResult(namedQueryInput.getSizeCriteria().getOffset().intValue());
			query.setMaxResults(namedQueryInput.getSizeCriteria().getMaxResultsToRetrive().intValue());
			rowsAvailable = Integer.valueOf(""+result.getSize());
			list = query.getResultList();
			result = new SearchResult<Object>(list);
			return new SearchResponse(namedQueryInput, result, rowsAvailable);
		}
		
		if (namedQueryInput.getSizeCriteria().getGetFoundRowsCount()) {
			rowsAvailable = list.size();
		}
		return new SearchResponse(namedQueryInput, result, rowsAvailable);

	}

	protected CriteriaSearchRequest extractNamedQueryInput(SearchRequest searchRequest) {
		final CriteriaSearchRequest criteriaSearchRequest = (CriteriaSearchRequest) searchRequest;

		// Build orderby clause
		buildOrderByClause(criteriaSearchRequest);

		SearchCriteria model = criteriaSearchRequest.getSearchCriteria();
		SizeCriteria sizeCriteria = searchRequest.getSizeCriteria();
		if (!sizeCriteria.isDoFullExtract()) {
			model.put("length", sizeCriteria.getResultSize());
			model.put("start", sizeCriteria.getOffset());
			model.put("end", sizeCriteria.getOffset() + sizeCriteria.getResultSize());
			model.put("getFoundRowsCount", criteriaSearchRequest.getSizeCriteria().getGetFoundRowsCount());
		}
		return criteriaSearchRequest;
	}

	protected void buildOrderByClause(CriteriaSearchRequest searchRequest) {
		SortCriteria sc = searchRequest.getSortCriteria();
		SearchCriteria model = searchRequest.getSearchCriteria();
		if (sc != null && sc.size() != 0 && sc.getSortCriteria() != null) {

			// considering there would be only 1 SortCriterion per request
			for (SortCriterion s : sc.getSortCriteria()) {
				if (StringUtils.isNotEmpty(s.getName())) {
					model.put(SORT_ORDER, s.isAscendingOrder() ? " ASC " : " DESC ");
					model.put(SORT_COLUMN, s.getName());
				}
			}

		}
	}

	/**
	 * Build both the where Clause sent by the client and also the system where
	 * clause if populated by other sources such as security interceptors
	 * 
	 * @param searchInput
	 */
	private Map<String, Object> getSearchParameters(CriteriaSearchRequest searchInput) {
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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
