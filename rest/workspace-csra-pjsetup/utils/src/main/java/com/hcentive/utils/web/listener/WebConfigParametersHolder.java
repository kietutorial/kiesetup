/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web.listener;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class WebConfigParameters.
 * 
 * @author ashish.jaiswal
 */
public class WebConfigParametersHolder {

	/** The application parameter map. */
	private Map<String, String> configParameterMap = new HashMap<String, String>();

	/**
	 * Gets the config parameter map.
	 * 
	 * @return the config parameter map
	 */
	public Map<String, String> getConfigParameterMap() {
		return configParameterMap;
	}

	/**
	 * Sets the config parameter map.
	 * 
	 * @param configParameterMap
	 *            the config parameter map
	 */
	public void setConfigParameterMap(Map<String, String> configParameterMap) {
		this.configParameterMap = configParameterMap;
	}

}
