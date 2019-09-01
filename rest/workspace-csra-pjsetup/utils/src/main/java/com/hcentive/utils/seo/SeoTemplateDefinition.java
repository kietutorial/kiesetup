/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.seo;

import java.util.List;
import java.util.Map;

public interface SeoTemplateDefinition {

	// to be deprecated
	public abstract List<Map<String, String>> defineRequestMap(String templateId);

	public abstract String defineFileName(String templateId, Map<String, String> requestMap);

	public String getTemplateURI();

	public String getTemplateId();

	// incremental parameters
	public abstract List<Map<String, String>> defineNextRequestMap(String templateId);
}
