/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.service;

import java.util.Map;

/**
 * @author ashish.jaiswal
 */
public class SimpleComponent {

	private String id;

	private String name;

	private Map<String, Object> params;

	public SimpleComponent(String id, Map<String, Object> params) {
		this.id = id;
		this.params = params;
	}

	public SimpleComponent(String id, Map<String, Object> params, String name) {
		this.id = id;
		this.params = params;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Map<String, Object> getParams() {
		return params;
	}
}
