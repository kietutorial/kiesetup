/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.picklistprovider;

import java.util.Locale;
import java.util.Map;

import com.hcentive.utils.picklistprovider.ext.PickListProviderExt;

/**
 * @author ashish.jaiswal
 * 
 */
public interface PickListProvider extends PickListProviderExt {

	public Map<String, String> getPickList(String name);

	public Map<String, String> getPickList(String name, Locale locale);

}
