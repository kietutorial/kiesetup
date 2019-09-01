/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

public class DataTableUtils {

	public static Map<String, Object> convertDataTableParamsToQueryParams(HttpServletRequest request) {
		Map<String, Object> queryParams = new HashMap<String, Object>();

		String sortColumnNames = WebUtils.findParameterValue(request, "sColumns");
		String sortColumns[] = null;
		if (sortColumnNames != null && !sortColumnNames.isEmpty()) {
			sortColumns = sortColumnNames.split(",");
		}
		String sortColumn = WebUtils.findParameterValue(request, "iSortCol_0");
		if (StringUtils.hasText(sortColumn)) {
			if (sortColumns != null) {
				queryParams.put("sortColumnName", sortColumns[Integer.parseInt(sortColumn)]);
			}
			queryParams.put("sortColumn", Integer.parseInt(sortColumn) + 1);
		}

		String sortDirection = WebUtils.findParameterValue(request, "sSortDir_0");
		if (StringUtils.hasText(sortDirection)) {
			queryParams.put("sortOrder", sortDirection);
		}

		String start = WebUtils.findParameterValue(request, "iDisplayStart");
		if (StringUtils.hasText(start)) {
			queryParams.put("start", Integer.parseInt(start));
		}

		String length = WebUtils.findParameterValue(request, "iDisplayLength");
		if (StringUtils.hasText(length)) {
			queryParams.put("length", Integer.parseInt(length));
		}
		if (StringUtils.hasText(start) && StringUtils.hasText(length)) {
			queryParams.put("end", Integer.parseInt(start) + Integer.parseInt(length));
		}
		return queryParams;
	}
}
