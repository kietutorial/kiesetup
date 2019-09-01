/**
* Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class WebUtils.
 * 
 * @author vaibhavgupta
 */

public class WebUtils {

	private static Logger logger = LoggerFactory.getLogger(WebUtils.class);

	/**
	 * Append params.
	 * 
	 * @param url
	 *            the url
	 * @param params
	 *            the params
	 * @return the string
	 */
	public static String appendParams(String url, Map<String, String> params) {
		StringBuffer urlBuffer = new StringBuffer(url);
		for (String key : params.keySet()) {
			if (urlBuffer.indexOf("?") == -1) {
				urlBuffer.append("?" + key + "=" + params.get(key));
			} else if (urlBuffer.indexOf("&" + key + "=") == -1 && urlBuffer.indexOf("?" + key + "=") == -1) {
				int hashIndex = urlBuffer.indexOf("#");
				if (hashIndex != -1) {
					urlBuffer.insert(hashIndex, "&" + key + "=" + params.get(key));
				} else {
					urlBuffer.append("&" + key + "=" + params.get(key));
				}
			}
		}

		return urlBuffer.toString();
	}

	/**
	 * Derive param.
	 * 
	 * @param paramName
	 *            the param name
	 * @param params
	 *            the params
	 * @return the string
	 */
	public static String deriveParam(String paramName, Map<String, Object> params) {
		Object obj = params.get(paramName);
		if (obj == null) {
			return null;
		}
		if (obj instanceof String[]) {
			String[] obj1 = (String[]) obj;
			return obj1[0];
		}
		if (obj instanceof String) {
			return (String) obj;
		}
		return null;
	}

	/**
	 * Derive param array.
	 * 
	 * @param paramName
	 *            the param name
	 * @param params
	 *            the params
	 * @return the string[]
	 */
	public static String[] deriveParamArray(String paramName, Map<String, Object> params) {
		Object obj = params.get(paramName);
		if (obj == null) {
			return null;
		}
		if (obj instanceof String[]) {
			String[] obj1 = (String[]) obj;
			return obj1;
		}
		if (obj instanceof String) {

			String[] objArray = { (String) obj };
			return objArray;
		}
		return null;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the args
	 */
	public static void main(String[] args) {
		Map<String, String> params = new LinkedHashMap<String, String>();
		params.put("aid", "23");
		params.put("aid1", "34");
		logger.info(appendParams("www.vaibhav.com?bid=34&cid=34", params));
	}

	/**
	 * This utility returns map value against a key if we are unsure if the key
	 * is in lower/upper or mixed case.
	 */
	public static <T> T getMapValueForKey(Map<String, T> map, String key) {
		T value = null;
		if (null != key && !"".equals(key.trim())
				&& (map.containsKey(key.trim().toLowerCase()) || map.containsKey(key.trim().toUpperCase()))) {
			value = null != map.get(key.trim().toLowerCase()) ? map.get(key.trim().toLowerCase()) : null != map.get(key.trim()
					.toUpperCase()) ? map.get(key.trim().toUpperCase()) : null != map.get(key.trim()) ? map.get(key.trim()) : null;
		}
		return value;
	}

	public static Number getNumericValueForBoolean(Object obj) {
		if (null != obj) {
			if (obj instanceof Boolean) {
				Boolean bool = (Boolean) obj;
				return bool == true ? 1 : 0;
			}
			return (Number) obj;
		}
		return 0;
	}

	/**
	 * @param mapValueForKey
	 * @return
	 */
	public static Date getDateAfterClassResoving(Object mapValueForKey) {
		if (mapValueForKey == null) {
			return null;
		}
		/*
		 * if (mapValueForKey instanceof Timestamp) { return getDate((
		 * mapValueForKey).toString()); } else {
		 */
		return getDate(mapValueForKey.toString());
		// }
	}

	private static Date getDate(String dateStr) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			return formatter.parse(dateStr);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * @param searchUsers
	 * @return
	 */
	public static List<Map<String, Object>> convertKeysToLower(List<Map<String, Object>> searchUsers) {
		List<Map<String, Object>> list = null;
		if (searchUsers != null) {
			list = new ArrayList<Map<String, Object>>(searchUsers.size());
			for (Map<String, Object> obj : searchUsers) {
				list.add(convertKeysToLower(obj));
			}
		}
		return list;
	}

	public static Map<String, Object> convertKeysToLower(Map<String, Object> entry) {
		Map<String, Object> obj = null;
		if (entry != null) {
			obj = new HashMap<String, Object>(entry.size());
			Iterator<Entry<String, Object>> itr = entry.entrySet().iterator();
			while (itr.hasNext()) {
				Entry<String, Object> e = itr.next();
				obj.put(e.getKey().toLowerCase(), e.getValue());
			}
		}
		return obj;
	}

	public static String getFormattedDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateString = new StringBuffer("");
		dateString.append(new SimpleDateFormat("MMMM").format(calendar.getTime()));
		dateString.append(" ");
		dateString.append(calendar.get(Calendar.DATE));
		dateString.append(",");
		dateString.append(" ");
		dateString.append(calendar.get(Calendar.YEAR));
		return dateString.toString();
	}

	public static String getFormattedDate(Date date, Locale locale) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateString = new StringBuffer("");
		dateString.append(new SimpleDateFormat("MMMM", locale).format(calendar.getTime()));
		dateString.append(" ");
		dateString.append(calendar.get(Calendar.DATE));
		dateString.append(",");
		dateString.append(" ");
		dateString.append(calendar.get(Calendar.YEAR));
		return dateString.toString();
	}

}
