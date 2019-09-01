/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.seo;

/**
 * The Interface SEOConfigDAO.
 * 
 * @author ashish.jaiswal
 */
public interface SEOConfigLoader {

	/**
	 * Gets the seo config.
	 * 
	 * @param applicationId
	 *            the application id
	 * 
	 * @return the SEO config
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public SEOConfig getSEOConfig(String applicationId) throws Exception;
}
