/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.cache;

import java.util.Map;

public interface Cache {

	public void put(String key, Object value);

	public void put(String key, Object value, Integer timeToLiveSeconds);

	public Object get(String key);

	public void remove(String key);

	public Map<String, Object> get(String[] keys);
}
