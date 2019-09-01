/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.analytics;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class AnalyticsCodeGenerator {

	private AnalyticsConfigLoader analyticsConfigLoader;

	public AnalyticsCodeGenerator(AnalyticsConfigLoader analyticsConfigLoader) {
		this.analyticsConfigLoader = analyticsConfigLoader;
	}

	/**
	 * @param pageId
	 * @param attMap
	 * @return Analytics code specific to pageId
	 * @throws Exception
	 */
	public String getAnalyticsCode(String applicationId, String pageId, Map<String, Object> attMap) throws Exception {
		return getAnalyticsCode(applicationId, pageId, attMap, false);
	}

	/**
	 * @param pageId
	 * @param attMap
	 * @return Analytics code specific to pageId in a secure page( https)
	 * @throws Exception
	 */
	public String getAnalyticsCodeSecure(String applicationId, String pageId, Map<String, Object> attMap) throws Exception {
		return getAnalyticsCode(applicationId, pageId, attMap, true);
	}

	/**
	 * @param applicationId
	 * @param pageId
	 * @param attMap
	 * @param isPageSecure
	 * @return
	 * @throws Exception
	 */
	private String getAnalyticsCode(String applicationId, String pageId, Map<String, Object> attMap, boolean isPageSecure)
			throws Exception {

		if (applicationId == null || pageId == null) {
			throw new IllegalArgumentException("applicationId and pageId should not be null");
		}
		AnalyticsConfig configBean = analyticsConfigLoader.getAnalyticsConfig(applicationId);

		String rawValue = configBean.getPageIdConfigMap().get(pageId);

		// Analytics js code to be pasted in the beginning
		String preAnalyticsCode = (isPageSecure ? configBean.getPageIdConfigMap().get(
				applicationId + ".application.preanalyticscode.secure") : configBean.getPageIdConfigMap().get(
				applicationId + ".application.preanalyticscode"));

		String mainAnalyticsCode = "";
		if (StringUtils.isNotEmpty(rawValue)) {
			// No Analytics Code defined for pageid
			mainAnalyticsCode = processValue(pageId, rawValue, attMap);
		} else {

		}

		// Analytics js code to be pasted in the end
		String postAnalyticsCode = (isPageSecure ? configBean.getPageIdConfigMap().get(
				applicationId + ".application.postanalyticscode.secure") : configBean.getPageIdConfigMap().get(
				applicationId + ".application.postanalyticscode"));

		return preAnalyticsCode + mainAnalyticsCode + postAnalyticsCode;

	}

	/**
	 * @param key
	 * @param rawValue
	 * @param attributesMap
	 * @return output string using freemarker template engine
	 * @throws Exception
	 */
	private String processValue(String key, String rawValue, Map<String, Object> attributesMap) throws Exception {
		Configuration configuration = new Configuration();
		Template t = new Template(key, new StringReader(rawValue), configuration);
		Writer out = new StringWriter();
		t.process(attributesMap, out);
		return out.toString();
	}

}
