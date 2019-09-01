/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.cache;

import java.util.HashMap;
import java.util.Map;

import net.sf.ehcache.Element;

/**
 * @author ashishjaiswal
 * 
 */
public class EHCache implements Cache {

	private net.sf.ehcache.Cache ehCache;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.cache.Cache#put(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void put(String key, Object value) {
		ehCache.put(new Element(key, value));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.cache.Cache#put(java.lang.String,
	 * java.lang.Object, java.util.Date)
	 */
	@Override
	public void put(String key, Object value, Integer timeToLiveSeconds) {
		ehCache.put(new Element(key, value, false, timeToLiveSeconds, timeToLiveSeconds));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.cache.Cache#get(java.lang.String)
	 */
	@Override
	public Object get(String key) {
		Element elm = ehCache.get(key);
		if (elm == null) {
			return null;
		}
		return elm.getObjectValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.cache.Cache#remove(java.lang.String)
	 */
	@Override
	public void remove(String key) {
		ehCache.remove(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.cache.Cache#get(java.lang.String[])
	 */
	@Override
	public Map<String, Object> get(String[] keys) {
		Map<String, Object> result = new HashMap<String, Object>();
		for (String key : keys) {
			result.put(key, get(key));
		}
		return result;
	}

	public void setEhCache(net.sf.ehcache.Cache ehCache) {
		this.ehCache = ehCache;
	}

}
