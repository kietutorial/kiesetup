/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification.template;

import java.io.IOException;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTemplateManager {

	public Template getTemplate(String templateName) throws IOException {
		/*
		 * String templateContent = (String)
		 * sqlMapClientTemplate.queryForObject("meta.getContentForTemplateName",
		 * templateName);
		 */
		return createTemplate(templateName, null);
	}

	public Template createTemplate(String templateName, String templateContent) throws IOException {
		StringTemplateLoader stringLoader = new StringTemplateLoader();
		stringLoader.putTemplate(templateName, templateContent);

		Configuration cfg = new Configuration();
		cfg.setTemplateLoader(stringLoader);
		return cfg.getTemplate(templateName);
	}

	/*
	 * public void updateTemplate(String templateName, String templateContent) {
	 * // update the content in database, create a new template update the cache
	 * Map<String, String> map = new HashMap<String, String>();
	 * map.put("templateName", templateName); map.put("templateContent",
	 * templateContent); //
	 * sqlMapClientTemplate.update("meta.updateContentForTemplateName", map); }
	 */
}
