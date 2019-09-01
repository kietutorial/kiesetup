/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.picklistprovider;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Assert;

/**
 * @author ashish.jaiswal
 * 
 */
public abstract class PickListProviderChain implements PickListProvider {

	protected static Map<String, String> emptyMap = new HashMap<String, String>();

	protected List<PickListProvider> pickListProviders;

	public void setpickListProviders(List<PickListProvider> pickListProviders) {
		Assert.assertNotNull("keyListProviders cannot be null for KeyListProviderChain", pickListProviders);
		this.pickListProviders = pickListProviders;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.utils.utils.KeyListProvider#getList(java.lang.String)
	 */
	public Map<String, String> getPickList(String key) {

		for (PickListProvider plp : pickListProviders) {
			Map<String, String> pickList = plp.getPickList(key);
			if (pickList != null && pickList.size() > 0) {
				return pickList;
			}
		}
		return emptyMap;
	}

	public Map<String, String> getPickList(String key, Locale locale) {

		for (PickListProvider plp : pickListProviders) {
			Map<String, String> pickList = plp.getPickList(key, locale);
			if (pickList != null && pickList.size() > 0) {
				return pickList;
			}
		}
		return emptyMap;
	}

}
