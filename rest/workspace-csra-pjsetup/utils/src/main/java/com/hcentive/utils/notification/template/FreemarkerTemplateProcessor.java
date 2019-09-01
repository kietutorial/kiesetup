/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification.template;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

import com.hcentive.utils.Constants;
import com.hcentive.utils.ftl.service.FreeMarkerTemplateLookupService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerTemplateProcessor implements TemplateProcessor {

	private static Logger logger = LoggerFactory.getLogger(FreemarkerTemplateProcessor.class);

	/*
	 * @Autowired private SearchService searchService;
	 * 
	 * @Value("${database}") private String database;
	 */

	// private static final String filenameExtension = "ftl";

	private Configuration configuration = null;

	private FreemarkerTemplateManager templateManager;

	/*
	 * private DMSService dmsService;
	 * 
	 * private String templateBaseFolder;
	 */

	private Map<String, Object> defaultDataMap = new HashMap<String, Object>();

	@Autowired
	private FreeMarkerTemplateLookupService freeMarkerTemplateLookupService;

	/*
	 * @Override public String getTemplateExtension() { return
	 * filenameExtension; }
	 */

	@Override
	public String process(String templateName, Map<String, Object> dataModel) throws Exception {
		String stateCode = (String) dataModel.get(Constants.STATECODE);
		Long issuerCode = null;
		if (dataModel.get(Constants.ISSUERID) != null) {
			issuerCode = (Long) dataModel.get(Constants.ISSUERID);
		}
		Template template = getTemplate(templateName, stateCode, issuerCode);
		return processTemplate(template, dataModel);
	}

	private Template getTemplate(String templateName, String stateCode, Long issuerCode) throws Exception {
		return templateManager.createTemplate(templateName,
				this.freeMarkerTemplateLookupService.doFreeMarkerTemplateLookUp(templateName, stateCode, issuerCode));
	}

	/*
	 * private Template getTemplate(String templateName) throws Exception { //
	 * template = configuration.getTemplate(templateName + "." +
	 * filenameExtension); InputStream is =
	 * dmsService.getDocument(templateBaseFolder +
	 * System.getProperty("file.separator") + templateName); return
	 * templateManager.createTemplate(templateName,
	 * UtilityFunctions.getStringFromInputStream(is)); }
	 */

	@Override
	public String process(String templateName, String templateString, Map<String, Object> dataModel) throws Exception {
		Template template = templateManager.createTemplate(templateName, templateString);
		return processTemplate(template, dataModel);
	}

	private String processTemplate(Template template, Map<String, Object> dataModel) throws Exception {
		Writer out = new StringWriter();
		Map<String, Object> placeHolderValues = new HashMap<String, Object>(defaultDataMap);
		if (dataModel != null) {
			placeHolderValues.putAll(dataModel);
		}
		template.process(placeHolderValues, out);
		return out.toString();
	}

	/**
	 * This method sets the free marker factory configuration like caching
	 * settings etc. which will be used while performing the operations on the
	 * ftl template.
	 * 
	 * @param cfgFactory
	 */
	public void setConfiguration(FreeMarkerConfigurationFactory cfgFactory) {
		try {
			configuration = cfgFactory.createConfiguration();
			configuration.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));
		} catch (IOException e) {
			logger.error("Unable to Initialize Notification Message Generator", e);
		} catch (TemplateException e) {
			logger.error("Unable to Initialize Notification Message Generator", e);
		}
	}

	public void setDefaultDataMap(Map<String, Object> defaultDataMap) {
		this.defaultDataMap = defaultDataMap;
	}

	public void setTemplateManager(FreemarkerTemplateManager templateManager) {
		this.templateManager = templateManager;
	}

	/*
	 * public void setDmsService(DMSService dmsService) { this.dmsService =
	 * dmsService; }
	 * 
	 * public void setTemplateBaseFolder(String templateBaseFolder) {
	 * this.templateBaseFolder = templateBaseFolder; }
	 */
}
