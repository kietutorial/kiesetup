/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification.template;

import java.util.Map;

/**
 * This Interface specifies the contract for processing data using an underlying
 * templating strategy.
 * 
 * @author ashish.jaiswal@hcentive.com
 */
public interface TemplateProcessor {

	/**
	 * Process by interpolating the dataModel with the template identified by
	 * the templateURL.
	 * 
	 * @param dataModel
	 *            the data to be interpolated
	 * @param templateName
	 *            Name of the template
	 */
	public String process(String templateName, Map<String, Object> dataModel) throws Exception;

	public String process(String templateName, String templateString, Map<String, Object> dataModel) throws Exception;

	// public String getTemplateExtension();
}
