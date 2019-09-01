package com.hcentive.utils.picklistprovider.ext;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

import com.hcentive.utils.picklist.domain.Picklist;
import com.hcentive.utils.picklistprovider.PickListProvider;
import com.hcentive.utils.picklistprovider.PickListProviderChain;

public class PickListProviderChainExt extends PickListProviderChain {
	protected static List<Picklist> emptyList = new ArrayList<Picklist>();

 
	public List<Picklist> getPickListAsObjects(String name)
	{
		for (PickListProvider plp : pickListProviders) {
			List<Picklist> pickList = plp.getPickListAsObjects(name);
			if (pickList != null && pickList.size() > 0) {
				return pickList;
			}
		}
		return emptyList;
	}
	
 
	public List<Picklist> getPickListAsObjects(String name, Locale locale) 
	{
		for (PickListProvider plp : pickListProviders) {
			List<Picklist> pickList = plp.getPickListAsObjects(name, locale);
			if (pickList != null && pickList.size() > 0) {
				return pickList;
			}
		}
		return emptyList;
	}

 
	public Map<String, String> getPickList(String name, String subName) {
		for (PickListProvider plp : pickListProviders) {
			Map<String, String> pickList = plp.getPickList(name, subName);
			if (pickList != null && pickList.size() > 0) {
				return pickList;
			}
		}
		return emptyMap;
	}

	
	public Map<String, String> getPickList(String name, String subName, Locale locale) {
		for (PickListProvider plp : pickListProviders) {
			Map<String, String> pickList = plp.getPickList(name, subName, locale);
			if (pickList != null && pickList.size() > 0) {
				return pickList;
			}
		}
		return emptyMap;
	}

	
}
