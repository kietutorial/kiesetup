/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.service;

import java.util.List;
import java.util.Map;

/**
 * @author ashish.jaiswal
 */
public interface ComponentConfig {

	public Object getComponentService(String componentId);

	public List<SimpleComponent> getSubComponentsRequestMap(String compositeCompId, Map<String, Object> compositeRequestParamsMap);
}
