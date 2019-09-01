/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.seo;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author ashish.jaiswal
 */
public class PropertiesBasedSEOConfigLoader implements Serializable, SEOConfigLoader {

	public static final Log logger = LogFactory.getLog(PropertiesBasedSEOConfigLoader.class);

	private Properties seoProperties;

	private SEOConfig seoConfig;

	/**
	 * @param configFile
	 *            the configFile to set
	 * @throws IOException
	 */
	public void setConfigFile(String configFile) throws IOException {
		if (configFile == null) {
			throw new RuntimeException("SEO Config resource is required to initialize SEO Configloader");
		}
		seoProperties = new Properties();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFile);
		if (logger.isInfoEnabled()) {
			logger.info("SEO configFile loaded successfully");
		}
		try {
			seoProperties.load(is);
		} finally {
			if (is != null) {
				is.close();
			}
		}
		init();
	}

	public void init() {

		String applicationId = null;

		// Get applicationId
		for (Object key : seoProperties.keySet()) {
			if (((String) key).matches(".*\\.application.*")) {
				applicationId = (String) key;
				applicationId = applicationId.replaceAll("\\.application.*", "");
				break;
			}
		}

		// Build pageIdMap
		Map<String, SEOMetaData> pageIdMap = new HashMap<String, SEOMetaData>();
		for (Object key : seoProperties.keySet()) {
			String propKey = key.toString();
			if (propKey.trim().matches(".*title$")) {
				String[] propKeyTokens = propKey.split("\\.title$");
				SEOMetaData seoMetaData = new SEOMetaData();
				seoMetaData.setTitle(seoProperties.getProperty(propKeyTokens[0] + ".title"));
				seoMetaData.setMetaDescription(seoProperties.getProperty(propKeyTokens[0] + ".meta.desc"));
				seoMetaData.setMetaKeywords(seoProperties.getProperty(propKeyTokens[0] + ".meta.keywords"));
				pageIdMap.put(propKeyTokens[0], seoMetaData);
			}
		}
		seoConfig = new SEOConfig(applicationId, pageIdMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hcentive.utils.seo.SEOConfigLoader#getSEOConfig(java.lang.String)
	 */
	@Override
	public SEOConfig getSEOConfig(String applicationId) throws Exception {
		if (!seoConfig.getApplicationId().equalsIgnoreCase(applicationId)) {
			throw new IllegalArgumentException("No SEO properties defined for Application: " + applicationId);
		}
		return seoConfig;
	}

	class SEOMetaData implements Serializable {

		private String title;
		private String metaKeywords;
		private String metaDescription;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getMetaKeywords() {
			return metaKeywords;
		}

		public void setMetaKeywords(String metaKeywords) {
			this.metaKeywords = metaKeywords;
		}

		public String getMetaDescription() {
			return metaDescription;
		}

		public void setMetaDescription(String metaDescription) {
			this.metaDescription = metaDescription;
		}
	}
}
