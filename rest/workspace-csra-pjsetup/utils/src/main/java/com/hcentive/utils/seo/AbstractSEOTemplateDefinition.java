/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.seo;

import java.util.List;
import java.util.Map;

public abstract class AbstractSEOTemplateDefinition implements SeoTemplateDefinition {

	private boolean allResults = false;

	@Override
	public List<Map<String, String>> defineNextRequestMap(String templateId) {
		if (!allResults) {
			allResults = true;
			return defineRequestMap(templateId);
		}
		return null;
	}
}
