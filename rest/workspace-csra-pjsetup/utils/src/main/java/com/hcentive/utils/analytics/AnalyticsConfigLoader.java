/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.analytics;

/**
 * The Interface AnalyticsConfigDAO.
 * 
 * @author ashish.jaiswal
 */
public interface AnalyticsConfigLoader {

	/**
	 * Gets the Analytics config.
	 * 
	 * @param applicationId
	 *            the application id
	 * 
	 * @return the Analytics config
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public AnalyticsConfig getAnalyticsConfig(String applicationId) throws Exception;
}
