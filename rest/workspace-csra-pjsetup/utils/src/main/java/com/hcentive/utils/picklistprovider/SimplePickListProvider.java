/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.picklistprovider;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.springframework.util.StringUtils;

import com.hcentive.utils.utils.Springi18nUtils;

/**
 * @author ashish.jaiswal
 * 
 */
public abstract class SimplePickListProvider implements PickListProvider {

	protected Map<String, Map<String, String>> mapOfKeyList;

	public SimplePickListProvider(Map<String, Map<String, String>> mapOfKeyList) {
		Assert.assertNotNull("keyList map cannot be null for SimpleKeyListProvider", mapOfKeyList);

		this.mapOfKeyList = mapOfKeyList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hcentive.utils.keylistprovider.KeyListProvider#getList(java.lang.
	 * String )
	 */
	public Map<String, String> getPickList(String key) {
		Locale locale = null;
		return getPickList(key, locale);
	}

	@Override
	public Map<String, String> getPickList(String key, Locale locale) {
		Map<String, String> newMap = new LinkedHashMap<String, String>();
		Map<String, String> rawMap = mapOfKeyList.get(key);
		if (rawMap == null)
			return newMap;
		Collection<String> keys = rawMap.keySet();
		for (String k : keys) {
			String value = Springi18nUtils.getMessage(rawMap.get(k), null, locale);
			if (!StringUtils.hasText(value))
				value = rawMap.get(k);
			newMap.put(k, value);
		}

		return newMap;
	}

}
