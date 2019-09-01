/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.cache;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

/**
 * A simple in-memory cache which can be used for POC or testing purpose.
 * 
 * @author ashish.jaiswal
 */
public class SimpleInMemoryCache implements Cache, Serializable {

	/** The cache store. */
	protected Map<String, Object> cacheStore;

	/**
	 * Instantiates a new simple in memory cache.
	 */
	public SimpleInMemoryCache() {
		cacheStore = new Hashtable<String, Object>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.cache.Cache#get(java.lang.String)
	 */
	public Object get(String key) {
		return cacheStore.get(key);
	}

	public void put(String key, Object value) {
		cacheStore.put(key, value);
	}

	public void remove(String key) {
		cacheStore.remove(key);
	}

	public Map<String, Object> get(String[] keys) {
		Map<String, Object> result = new Hashtable<String, Object>();
		for (String key : keys) {
			result.put(key, get(key));
		}
		return result;
	}

	public void put(String key, Object value, Integer timeToLiveSeconds) {
		// SimpleInMemoryCache does not supports expiry
		// ignore the expiry attribute for this type of cache
		cacheStore.put(key, value);
	}

}
