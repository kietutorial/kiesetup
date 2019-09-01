package com.hcentive.utils.picklistprovider.ext;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.hcentive.utils.picklist.domain.Picklist;
import com.hcentive.utils.picklistprovider.SimplePickListProvider;

public class SimplePickListProviderExt extends SimplePickListProvider {
	
	public SimplePickListProviderExt(Map<String, Map<String, String>> mapOfKeyList){
		super(mapOfKeyList);
	}

	public List<Picklist> getPickListAsObjects(String name)
	{
		Locale locale = null;
		return getPickListAsObjects(name, locale);
	}
	
	public List<Picklist> getPickListAsObjects(String name, Locale locale) 
	{
		return null;
	}

	public Map<String, String> getPickList(String name, String subName) {
		Locale locale = null;
		return getPickList(name, subName, locale);
	}

	public Map<String, String> getPickList(String name, String subName, Locale locale) {
		return null;
	}

	
	
}
