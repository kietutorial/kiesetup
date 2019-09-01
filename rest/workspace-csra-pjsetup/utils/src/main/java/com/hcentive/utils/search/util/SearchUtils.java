/*******************************************************************************
 * --------------------------------------------
 *  Copyright (c) 2012 hCentive Inc. All Right Reserved.
 * --------------------------------------------
 ******************************************************************************/
package com.hcentive.utils.search.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SortCriteria;
import com.hcentive.utils.search.model.SortCriterion;

/**
 * @author Sumit Taneja
 */
public class SearchUtils {

	public static QuerySearchRequest populateSearchRequest(String queryId, Map<String, Object> queryParams) {
		String[] sortColumns = { null };
		String[] sortOrders = { null };
		return populateSearchRequest(queryId, queryParams, sortColumns, sortOrders, null, null, false, false);
	}

	public static QuerySearchRequest populateSearchRequest(String queryId, Map<String, Object> queryParams, String sortColumn,
			String sortOrder, Integer offset, Integer size, boolean doFullExtract, boolean getFoundRowsCount) {
		String[] sortColumns = { sortColumn };
		String[] sortOrders = { sortOrder };
		return populateSearchRequest(queryId, queryParams, sortColumns, sortOrders, offset, size, doFullExtract, getFoundRowsCount);
	}

	public static QuerySearchRequest populateSearchRequest(String queryId, Map<String, Object> queryParams, String[] sortColumns,
			String[] sortOrders, Integer offset, Integer size, boolean doFullExtract, boolean getFoundRowsCount) {
		QuerySearchRequest searchRequest = new QuerySearchRequest();
		searchRequest.setQueryId(queryId);

		if (queryParams != null) {
			searchRequest.getSearchCriteria().putAll(queryParams);
		}

		populateSortCriteria(sortColumns, sortOrders, searchRequest);

		if (size != null) {
			if (offset != null) {
				searchRequest.getSizeCriteria().setOffset(offset.longValue());
			}
			searchRequest.getSizeCriteria().setResultSize(size.longValue());
			searchRequest.getSizeCriteria().setDoFullExtract(doFullExtract);
			searchRequest.getSizeCriteria().setGetFoundRowsCount(getFoundRowsCount);
		}
		return searchRequest;
	}

	private static void populateSortCriteria(String[] sortColumnsIndexes, String[] sortColumnsOrders,
			QuerySearchRequest searchRequest) {
		List<SortCriterion> sortCriterionList = new ArrayList<SortCriterion>();
		for (int i = 0; i < sortColumnsIndexes.length; i++) {
			String sortColumnIndex = sortColumnsIndexes[i];
			if (sortColumnIndex != null) {
				SortCriterion sortCriterion = new SortCriterion();
				sortCriterion.setName(sortColumnIndex);
				sortCriterion.setAscendingOrder(!StringUtils.hasText(sortColumnsOrders[i])
						|| SortCriterion.SORT_ORDER_ASC.equalsIgnoreCase(sortColumnsOrders[i]));
				sortCriterionList.add(sortCriterion);
			}

		}
		if (!sortCriterionList.isEmpty()) {
			SortCriteria sortCriteria = new SortCriteria(sortCriterionList);
			searchRequest.setSortCriteria(sortCriteria);
		}

	}
}
