/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.analytics;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author ashish.jaiswal
 * 
 */
public class PropertiesBasedAnalyticsConfigLoader implements AnalyticsConfigLoader {
	public static final Log logger = LogFactory.getLog(PropertiesBasedAnalyticsConfigLoader.class);

	private Properties analyticsProperties;

	private AnalyticsConfig analyticsConfig;

	private String trackerId = null;

	private static final String TRACKER_KEY = "trackerId";

	/**
	 * @param configFile
	 *            the configFile to set
	 * @throws IOException
	 */
	public void setConfigFile(String configFile) throws IOException {
		if (configFile == null) {
			throw new RuntimeException("Analytics Config resource is required to initialize Analytics Configloader");
		}
		analyticsProperties = new Properties();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFile);
		if (logger.isInfoEnabled()) {
			logger.info("Analytics configFile loaded successfully");
		}
		try {
			analyticsProperties.load(is);
		} finally {
			if (is != null) {
				is.close();
			}
		}

		// initialize the analyticsconfig object
		init();
	}

	public void init() {

		String applicationId = null;

		// Get applicationId
		for (Object key : analyticsProperties.keySet()) {
			if (((String) key).matches(".*\\.application.*")) {
				applicationId = ((String) key).replaceAll("\\.application.*", "").trim();
				break;
			}
		}

		// Check for existence of mandatory properties
		if (StringUtils.isEmpty(analyticsProperties.getProperty(applicationId + ".application.preanalyticscode"))
				&& StringUtils.isEmpty(analyticsProperties.getProperty(applicationId + ".application.postanalyticscode"))) {
			throw new IllegalStateException(applicationId + ".application.preanalyticscode and/or " + applicationId
					+ ".application.postanalyticscode property is not set.This property is mandatory.");
		}

		// resolve trackerId
		if (StringUtils.isEmpty(trackerId)) {
			logger.info("TrackerId not availble in web config, going for default value.");
			trackerId = analyticsProperties.getProperty(TRACKER_KEY);
			if (StringUtils.isEmpty(trackerId))
				throw new IllegalStateException("trackerId property is not set.This property is mandatory.");
		}

		// replace the tracker id in value of preanalyticscode & it's secure key
		String replaceToken = "\"" + trackerId + "\"";
		String valuePreAnalyticCodeSecure = analyticsProperties.getProperty(applicationId + ".application.preanalyticscode.secure")
				.replaceAll(Pattern.quote("${trackerId}"), replaceToken);
		String valuePreAnalyticCode = analyticsProperties.getProperty(applicationId + ".application.preanalyticscode").replaceAll(
				Pattern.quote("${trackerId}"), replaceToken);

		// update the new values for respective keys
		analyticsProperties.setProperty(applicationId + ".application.preanalyticscode", valuePreAnalyticCode);
		analyticsProperties.setProperty(applicationId + ".application.preanalyticscode.secure", valuePreAnalyticCodeSecure);

		logger.info("new value for " + applicationId + ".application.preanalyticscode : " + valuePreAnalyticCode);

		// Build pageIdMap
		Map<String, String> pageIdMap = new HashMap<String, String>();
		for (Object key : analyticsProperties.keySet()) {
			String value = analyticsProperties.getProperty((String) key).trim();
			pageIdMap.put((String) key, value);
		}

		analyticsConfig = new AnalyticsConfig(applicationId, pageIdMap);
	}

	public AnalyticsConfig getAnalyticsConfig(String applicationId) throws Exception {

		if (!analyticsConfig.getApplicationId().equalsIgnoreCase(applicationId)) {
			throw new IllegalArgumentException("No Analytics properties defined for Application: " + applicationId);
		}

		return analyticsConfig;
	}

	public void setTrackerId(String trackerId) {
		this.trackerId = trackerId;
	}

	public static void main(String[] aa) {

		String a = "lilko${trackerId}";
		a = a.replaceAll(Pattern.quote("${trackerId}"), "\"55\"");
		System.out.println(a);
	}

}
