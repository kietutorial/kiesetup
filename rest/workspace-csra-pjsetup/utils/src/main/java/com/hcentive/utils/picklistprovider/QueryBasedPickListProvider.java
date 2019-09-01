/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.picklistprovider;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;

import com.hcentive.utils.orm.dao.GenericDAO;
import com.hcentive.utils.picklist.domain.Picklist;

/**
 * @author ashish.jaiswal
 */
public abstract class QueryBasedPickListProvider implements PickListProvider {

	private static Logger logger = LoggerFactory.getLogger(QueryBasedPickListProvider.class);

	@Autowired
	@SuppressWarnings("rawtypes")
	protected GenericDAO genericDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hcentive.utils.keylistprovider.PickListProvider#getPickList(java.lang
	 * .String )
	 */
	@Override
	@Cacheable(value = "picklistCacheWithLocale") 
	public Map<String, String> getPickList(String name) {
		Locale locale = null;
		return getPickList(name, locale);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Cacheable(value = "picklistCacheWithLocale") 
	public Map<String, String> getPickList(String name, Locale locale) {
		logger.debug("Inside getPickList()----PicklistName-----------> "+name);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("picklistName", name);

		String queryName = null;
		if (locale != null && StringUtils.hasText(locale.getLanguage())) {
			paramMap.put("locale", locale.getLanguage());
			queryName = "picklist.getPicklistsByPicklistNameAndLocale";
		} else {
			queryName = "picklist.getPicklistsByPicklistNameAndDefaultLocale";
		}

		List<Picklist> picklists = null;
		picklists = genericDAO.findByNamedQuery(queryName, paramMap);
		if (picklists == null || picklists.size() == 0) {
			return null;
		}
		Map<String, String> result = new LinkedHashMap<String, String>();
		for (Picklist picklist : picklists) {
			result.put(picklist.getName(), picklist.getValue());
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

}
