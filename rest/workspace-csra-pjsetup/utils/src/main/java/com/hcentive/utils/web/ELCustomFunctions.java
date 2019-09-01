/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web;

/*
 * Class defines custom expression language functions. The functions are defined in customFunctions.tld which can be used in jsp. Following is the sample case
 * 
 * <%@ taglib uri="com.hcentive.utils.customElFunctions" prefix="cfunc"%>
 * 
 * ${cfunc:indexInList(item, list)}
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;

public class ELCustomFunctions {

	/*
	 * 
	 */
	public static Integer indexInList(Object item, List<Object> items) {
		return items.indexOf(item);
	}

	public static Integer indexInMapKeys(Object item, Map<Object, Object> items) {
		Set<Object> keySet = items.keySet();
		Iterator<Object> iter = keySet.iterator();
		Integer count = 0;
		while (iter.hasNext()) {
			Object key = iter.next();
			if (key.equals(item)) {
				return count;
			}
			count++;
		}
		return -1;
	}

	public static Integer indexInMapValues(Object item, Map<Object, Object> items) {
		Collection<Object> values = items.values();
		Iterator<Object> iter = values.iterator();
		Integer count = 0;
		while (iter.hasNext()) {
			Object value = iter.next();
			if (value.equals(item)) {
				return count;
			}
			count++;
		}
		return -1;
	}

	public static String randomNumber(Integer length) {
		return RandomStringUtils.randomNumeric(length);

	}

}
