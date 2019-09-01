/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web;

import org.apache.commons.jxpath.JXPathContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JXPathUtils {

	private static Logger logger = LoggerFactory.getLogger(JXPathUtils.class);

	public static Object retriveValue(Object object, String xPath) {
		try {
			JXPathContext context = JXPathContext.newContext(object);
			context.setLenient(true);
			return context.getValue(xPath);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return null;
	}
}
