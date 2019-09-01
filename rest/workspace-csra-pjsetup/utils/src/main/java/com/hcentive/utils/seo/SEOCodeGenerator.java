/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.seo;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SEOCodeGenerator {

	private SEOConfigLoader seoConfigLoader;

	public SEOCodeGenerator(SEOConfigLoader seoConfigLoader) {
		this.seoConfigLoader = seoConfigLoader;
	}

	/**
	 * @param pageId
	 * @param attMap
	 * @return SEO code specific to a pageId or pageInstanceId
	 * @throws Exception
	 */
	public String getSEOCode(String applicationId, String pageId, String pageInstanceId, Map<String, Object> attMap)
			throws Exception {
		if (applicationId == null) {
			throw new IllegalArgumentException("applicationId should not be null");
		}

		SEOConfig configBean = seoConfigLoader.getSEOConfig(applicationId);
		StringBuilder sb = new StringBuilder();
		sb.append(createTitle(configBean.getTitle(pageId, pageInstanceId)));
		sb.append(createDescription(configBean.getDesc(pageId, pageInstanceId)));
		sb.append(createKeywords(configBean.getKeywords(pageId, pageInstanceId)));

		// process varValue with request attributes
		return processValue(pageId, sb.toString(), attMap);

	}

	private String createKeywords(String keywords) {
		StringBuilder sb = new StringBuilder();
		return sb.append("<meta name=\"keywords\" content=\"").append(keywords).append("\"/>").toString();
	}

	private String createDescription(String desc) {
		StringBuilder sb = new StringBuilder();
		return sb.append("<meta name=\"description\" content=\"").append(desc).append("\"/>").toString();
	}

	private String createTitle(String title) {
		StringBuilder sb = new StringBuilder();
		return sb.append("<title>").append(title).append("</title>").toString();
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
		// The data source where the template files come from.
		// Specify how templates will see the data-model.
		Template t = new Template(key, new StringReader(rawValue), configuration);
		Writer out = new StringWriter();
		t.process(attributesMap, out);
		return out.toString();
	}

}
