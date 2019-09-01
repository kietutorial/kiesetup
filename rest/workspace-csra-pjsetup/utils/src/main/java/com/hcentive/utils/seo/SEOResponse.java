/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.seo;

import java.util.List;
import java.util.Map;

/**
 * @author ashish.jaiswal
 */
public class SEOResponse {

	Map<String, List<?>> resultMap;

	String pageMetaData;

	String analyticsData;

	public SEOResponse(String pageMetaData, String analyticsData, Map<String, List<?>> resultMap) {
		this.resultMap = resultMap;
		this.pageMetaData = pageMetaData;
		this.analyticsData = analyticsData;
	}

	/**
	 * @return the resultMap
	 */
	public Map<String, List<?>> getResultMap() {
		return resultMap;
	}

	/**
	 * @return the pageMetaData
	 */
	public String getPageMetaData() {
		return pageMetaData;
	}

	/**
	 * @return the analyticsData
	 */
	public String getAnalyticsData() {
		return analyticsData;
	}

	/**
	 * @param resultMap
	 *            the resultMap to set
	 */
	public void setResultMap(Map<String, List<?>> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * @param pageMetaData
	 *            the pageMetaData to set
	 */
	public void setPageMetaData(String pageMetaData) {
		this.pageMetaData = pageMetaData;
	}

	/**
	 * @param analyticsData
	 *            the analyticsData to set
	 */
	public void setAnalyticsData(String analyticsData) {
		this.analyticsData = analyticsData;
	}
}
