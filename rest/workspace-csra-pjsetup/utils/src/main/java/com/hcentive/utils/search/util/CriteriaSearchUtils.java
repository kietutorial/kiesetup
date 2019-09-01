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

import com.hcentive.utils.search.model.CriteriaSearchRequest;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SortCriteria;
import com.hcentive.utils.search.model.SortCriterion;

/**
 * @author Sidharth Sharma
 */
public class CriteriaSearchUtils {

	public static CriteriaSearchRequest populateCriteriaSearchRequest(String criteriaId, Map<String, Object> queryParams) {
		String[] sortColumns = { null };
		String[] sortOrders = { null };
		return populateCriteriaSearchRequest(criteriaId, queryParams, sortColumns, sortOrders, null, null, false, false);
	}

	public static CriteriaSearchRequest populateCriteriaSearchRequest(String criteriaId, Map<String, Object> queryParams,
			String sortColumn, String sortOrder, Integer offset, Integer size, boolean doFullExtract, boolean getFoundRowsCount) {
		String[] sortColumns = { sortColumn };
		String[] sortOrders = { sortOrder };
		return populateCriteriaSearchRequest(criteriaId, queryParams, sortColumns, sortOrders, offset, size, doFullExtract,
				getFoundRowsCount);
	}

	public static CriteriaSearchRequest populateCriteriaSearchRequest(String criteriaId, Map<String, Object> queryParams,
			String[] sortColumns, String[] sortOrders, Integer offset, Integer size, boolean doFullExtract,
			boolean getFoundRowsCount) {
		CriteriaSearchRequest criteriaSearchRequest = new CriteriaSearchRequest();
		criteriaSearchRequest.setCriteriaId(criteriaId);

		if (queryParams != null) {
			criteriaSearchRequest.getSearchCriteria().putAll(queryParams);
		}

		populateSortCriteria(sortColumns, sortOrders, criteriaSearchRequest);

		if (size != null) {
			if (offset != null) {
				criteriaSearchRequest.getSizeCriteria().setOffset(offset.longValue());
			}
			criteriaSearchRequest.getSizeCriteria().setResultSize(size.longValue());
			criteriaSearchRequest.getSizeCriteria().setMaxResultsToRetrive(size.longValue());
			criteriaSearchRequest.getSizeCriteria().setDoFullExtract(doFullExtract);
			criteriaSearchRequest.getSizeCriteria().setGetFoundRowsCount(getFoundRowsCount);
		}
		return criteriaSearchRequest;
	}

	private static void populateSortCriteria(String[] sortColumnsIndexes, String[] sortColumnsOrders,
			CriteriaSearchRequest searchRequest) {
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
