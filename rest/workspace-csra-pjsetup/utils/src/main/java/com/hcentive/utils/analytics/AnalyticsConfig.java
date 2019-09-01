/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.analytics;

import java.io.Serializable;
import java.util.Map;

/**
 * @author ashish.jaiswal
 * 
 */
public class AnalyticsConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1233855011603127621L;

	/**
	 * Key - Page Id Value - Complete Analytics code for this pageId
	 */
	private Map<String, String> pageIdConfigMap;

	private String applicationId;

	public AnalyticsConfig(String applicationId, Map<String, String> pageConfigMap) {
		this.pageIdConfigMap = pageConfigMap;
		this.applicationId = applicationId;
	}

	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * @param applicationId
	 *            the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * @return the pageIdConfigMap
	 */
	public Map<String, String> getPageIdConfigMap() {
		return this.pageIdConfigMap;
	}

}
