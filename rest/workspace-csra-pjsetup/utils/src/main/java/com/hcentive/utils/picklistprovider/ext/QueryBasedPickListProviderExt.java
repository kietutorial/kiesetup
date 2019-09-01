package com.hcentive.utils.picklistprovider.ext;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;

import com.hcentive.utils.picklist.domain.Picklist;
import com.hcentive.utils.picklistprovider.QueryBasedPickListProvider;

public class QueryBasedPickListProviderExt extends QueryBasedPickListProvider {

	private static Logger logger = LoggerFactory.getLogger(QueryBasedPickListProviderExt.class);

	public List<Picklist> getPickListAsObjects(String name) {
		Locale locale = null;
		return getPickListAsObjects(name, locale);
	}
	
	@Cacheable(value = "picklistCache") 
	public List<Picklist> getPickListAsObjects(String name, Locale locale) {
		List<Picklist> picklists = null;

		String queryName = null;

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("picklistName", name);
		if (locale != null && StringUtils.hasText(locale.getLanguage())) {
			paramMap.put("locale", locale.getLanguage());
			queryName = "picklist.getOrderedPicklistsByPicklistNameAndLocale";
		} else {
			queryName = "picklist.getOrderedPicklistsByPicklistNameAndDefaultLocale";
		}

		try {
			picklists = genericDAO.findByNamedQuery(queryName, paramMap);
		} catch (Exception e) {
			logger.info("Unable to get list from database for name: " + name, e.getMessage());
			return null;
		}
		if (picklists == null || picklists.size() == 0) {
			return null;
		}
		return picklists;
	}

	
	public Map<String, String> getPickList(String name, String subName) {
		// TODO Auto-generated method stub
		Locale locale = null;
		return getPickList(name, subName, locale);
	}

	@Cacheable(value = "picklistCacheWithLocale") 
	public Map<String, String> getPickList(String name, String subName, Locale locale) {
		List<Picklist> picklists = null;
		String queryName = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("picklistName", name);
		paramMap.put("picklistSubName", subName);
		if (locale != null && StringUtils.hasText(locale.getLanguage())) {
			paramMap.put("locale", locale.getLanguage());
			queryName = "picklist.getOrderedPicklistsByPicklistNameSubNameAndLocale";
		} else {
			queryName = "picklist.getOrderedPicklistsByPicklistNameSubNameAndDefaultLocale";
		}

		try {
			picklists = genericDAO.findByNamedQuery(queryName, paramMap);
		} catch (Exception e) {
			logger.info("Unable to get list from database for name: " + name, e.getMessage());
			return null;
		}
		if (picklists == null || picklists.size() == 0) {
			return null;
		}
		Map<String, String> result = new LinkedHashMap<String, String>();
		for (Picklist picklist : picklists) {
			result.put(picklist.getName(), picklist.getValue());
		}
		return result;
	}	
}
