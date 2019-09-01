package com.hcentive.utils.search.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.hcentive.utils.search.datatable.model.DatatableSearchRequest;
import com.hcentive.utils.search.datatable.model.DatatableSearchResponse;
import com.hcentive.utils.search.model.CriteriaSearchRequest;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchResponse;

public class DataTableSearchUtils {

	private static final Pattern ARRAY_REGEX = Pattern.compile("^\\[(.*)\\]$");

	public static QuerySearchRequest getSearchRequest(String queryId, DatatableSearchRequest dataTableSearchRequest) {
		return getSearchRequest(queryId, dataTableSearchRequest, null);

	}

	public static QuerySearchRequest getSearchRequest(String queryId, DatatableSearchRequest dataTableSearchRequest,
			Map<String, Object> additionalParams) {

		Map<String, Object> queryParams = new HashMap<String, Object>();
		String[] sColumns = dataTableSearchRequest.getsColumnsArray();
		Integer totalColumns = dataTableSearchRequest.getiColumns();
		Map<Integer, String> searchColumns = dataTableSearchRequest.getsSearchMap();
		Map<Integer, Boolean> bRegexColumns = dataTableSearchRequest.getbRegexMap();
		for (int i = 0; i < totalColumns; i++) {
			String searchValue = searchColumns.get(i);
			if (StringUtils.hasLength(searchValue)) {
				boolean isRegex = bRegexColumns.get(i);
				Matcher matcher = ARRAY_REGEX.matcher(searchValue);
				if (matcher.find()) {
					String bracketsRemovedString = matcher.group(1);
					if (StringUtils.hasLength(bracketsRemovedString)) {
						if (isRegex) {
							bracketsRemovedString = "%" + bracketsRemovedString.replace(",", "%,%") + "%";
						}
						String[] searchValues = bracketsRemovedString.split(",");
						queryParams.put(sColumns[i], searchValues);
					}
				} else {
					if (isRegex) {
						searchValue = "%" + searchValue + "%";
					}
					queryParams.put(sColumns[i], searchValue);
				}
			}
		}
		if (additionalParams != null) {
			queryParams.putAll(additionalParams);
		}
		Integer numberOfColumnsToSort = dataTableSearchRequest.getiSortingCols();
		String[] sortColumns = new String[numberOfColumnsToSort];
		String[] sortColumnOrders = new String[numberOfColumnsToSort];
		Map<Integer, Integer> iSortColumns = dataTableSearchRequest.getiSortColMap();
		Map<Integer, String> sSortDirection = dataTableSearchRequest.getsSortDirMap();
		if (dataTableSearchRequest.isUserColumnNameForSorting()) {
			for (int i = 0; i < numberOfColumnsToSort; i++) {
				sortColumns[i] = sColumns[iSortColumns.get(i)];
				sortColumnOrders[i] = sSortDirection.get(i);
			}
		} else {
			for (int i = 0; i < numberOfColumnsToSort; i++) {
				sortColumns[i] = (Integer.valueOf(iSortColumns.get(i) + 1)).toString();
				sortColumnOrders[i] = sSortDirection.get(i);
			}
		}

		return SearchUtils.populateSearchRequest(queryId, queryParams, sortColumns, sortColumnOrders,
				dataTableSearchRequest.getiDisplayStart(), dataTableSearchRequest.getiDisplayLength(), false, true);

	}

	public static CriteriaSearchRequest getCriteriaSearchRequest(String queryId, DatatableSearchRequest dataTableSearchRequest) {
		return getCriteriaSearchRequest(queryId, dataTableSearchRequest, null);
	}

	public static CriteriaSearchRequest getCriteriaSearchRequest(String criteriaId, DatatableSearchRequest dataTableSearchRequest,
			Map<String, Object> additionalParams) {

		Map<String, Object> queryParams = new HashMap<String, Object>();
		String[] sColumns = dataTableSearchRequest.getsColumnsArray();
		Integer totalColumns = 0;
		Map<Integer, String> searchColumns = dataTableSearchRequest.getsSearchMap();
		Map<Integer, Boolean> bRegexColumns = dataTableSearchRequest.getbRegexMap();
		for (int i = 0; i < totalColumns; i++) {
			String searchValue = searchColumns.get(i);
			if (StringUtils.hasLength(searchValue)) {
				boolean isRegex = bRegexColumns.get(i);
				Matcher matcher = ARRAY_REGEX.matcher(searchValue);
				if (matcher.find()) {
					String bracketsRemovedString = matcher.group(1);
					if (StringUtils.hasLength(bracketsRemovedString)) {
						if (isRegex) {
							bracketsRemovedString = "%" + bracketsRemovedString.replace(",", "%,%") + "%";
						}
						String[] searchValues = bracketsRemovedString.split(",");
						queryParams.put(sColumns[i], searchValues);
					}
				} else {
					if (isRegex) {
						searchValue = "%" + searchValue + "%";
					}
					queryParams.put(sColumns[i], searchValue);
				}
			}
		}
		if (additionalParams != null) {
			queryParams.putAll(additionalParams);
		}
		Integer numberOfColumnsToSort = 0;
		String[] sortColumns = new String[numberOfColumnsToSort];
		String[] sortColumnOrders = new String[numberOfColumnsToSort];
		Map<Integer, Integer> iSortColumns = dataTableSearchRequest.getiSortColMap();
		Map<Integer, String> sSortDirection = dataTableSearchRequest.getsSortDirMap();
		if (dataTableSearchRequest.isUserColumnNameForSorting()) {
			for (int i = 0; i < numberOfColumnsToSort; i++) {
				sortColumns[i] = sColumns[iSortColumns.get(i)];
				sortColumnOrders[i] = sSortDirection.get(i);
			}
		} else {
			for (int i = 0; i < numberOfColumnsToSort; i++) {
				sortColumns[i] = (Integer.valueOf(iSortColumns.get(i) + 1)).toString();
				sortColumnOrders[i] = sSortDirection.get(i);
			}
		}

		return CriteriaSearchUtils.populateCriteriaSearchRequest(criteriaId, queryParams, sortColumns, sortColumnOrders,
				dataTableSearchRequest.getiDisplayStart(), dataTableSearchRequest.getiDisplayLength(), false, true);

	}

	public static DatatableSearchResponse getDatatableSearchResponse(SearchResponse searchResponse) {
		DatatableSearchResponse dataTableSearchResponse = new DatatableSearchResponse();
		dataTableSearchResponse.setAaData(searchResponse.getResults());
		dataTableSearchResponse.setiTotalDisplayRecords(searchResponse.getRowsAvailable());
		dataTableSearchResponse.setiTotalRecords(searchResponse.getRowsAvailable());
		return dataTableSearchResponse;
	}

	public static DatatableSearchRequest getDatatableSearchRequestFromRequest(HttpServletRequest request) {
		DatatableSearchRequest datatableSearchRequest = new DatatableSearchRequest();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(datatableSearchRequest);
		binder.bind(request);
		Integer columns = datatableSearchRequest.getiColumns();
		bindField("bRegex", columns, request, binder);
		bindField("bSearchable", columns, request, binder);
		bindField("bSortable", columns, request, binder);
		bindField("sSearch", columns, request, binder);
		Integer sortColsCount = datatableSearchRequest.getiSortingCols();
		bindField("iSortCol", sortColsCount, request, binder);
		bindField("sSortDir", sortColsCount, request, binder);
		if (StringUtils.hasText(datatableSearchRequest.getsColumns())) {
			datatableSearchRequest.setsColumnsArray(StringUtils.commaDelimitedListToStringArray(datatableSearchRequest
					.getsColumns()));
		}
		return datatableSearchRequest;
	}

	private static void bindField(String field, Integer count, HttpServletRequest request, ServletRequestDataBinder binder) {
		Map<Integer, String> fieldMap = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < count; i++) {
			String fieldRequestValue = request.getParameter(field + "_" + i);
			fieldMap.put(i, fieldRequestValue);
		}
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue(field + "Map", fieldMap);
		binder.bind(propertyValues);
	}

	public static void main(String[] args) {
		String searchValue = "[]";
		Matcher matcher = ARRAY_REGEX.matcher(searchValue);
		if (matcher.find()) {

			System.out.println("Matched " + matcher.group(1));
		}
	}
}
