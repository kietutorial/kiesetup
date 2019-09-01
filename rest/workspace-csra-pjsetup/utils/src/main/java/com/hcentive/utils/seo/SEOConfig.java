/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.seo;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hcentive.utils.seo.PropertiesBasedSEOConfigLoader.SEOMetaData;

/**
 * @author ashish.jaiswal
 */
public class SEOConfig implements Serializable {

	public static final Log logger = LogFactory.getLog(SEOConfig.class);

	private static final long serialVersionUID = -1233855011603127621L;

	/**
	 * Key - Page Id Value - Complete SEO code for this pageId
	 */
	private Map<String, SEOMetaData> pageIdConfigMap;

	private String applicationId;

	public SEOConfig(String applicationId, Map<String, SEOMetaData> pageConfigMap) {
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
	public Map<String, SEOMetaData> getPageIdConfigMap() {
		return this.pageIdConfigMap;
	}

	/**
	 * @param pageId
	 * @return title html tags
	 */
	public String getTitle(String pageId, String pageInstanceId) {

		return pageIdConfigMap.get(getValidId(pageId, pageInstanceId)).getTitle();
	}

	/**
	 * @param pageId
	 * @return meta description html tags
	 */
	public String getDesc(String pageId, String pageInstanceId) {
		return pageIdConfigMap.get(getValidId(pageId, pageInstanceId)).getMetaDescription();

	}

	/**
	 * @param pageId
	 * @return meta keywords html tags
	 */
	public String getKeywords(String pageId, String pageInstanceId) {
		return pageIdConfigMap.get(getValidId(pageId, pageInstanceId)).getMetaKeywords();
	}

	/**
	 * @param pageId
	 * @param pageInstanceId
	 * @return id that exists in pageIdConfigMap
	 */
	private String getValidId(String pageId, String pageInstanceId) {
		if (pageInstanceId != null) {
			pageInstanceId = pageInstanceId + "." + pageId;

			if (pageIdConfigMap.get(pageInstanceId) != null) {
				return pageInstanceId;
			}
			logger.info(pageInstanceId + " not configured in seo configuration properties file");
		}

		if (pageId != null) {
			if (pageIdConfigMap.get(pageId) != null) {
				return pageId;
			}
			logger.info(pageId + " not configured in seo configuration properties file");
		}
		return applicationId + ".application";
	}
}
