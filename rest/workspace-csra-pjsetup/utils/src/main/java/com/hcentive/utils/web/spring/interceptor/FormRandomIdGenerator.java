/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.spring.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

public class FormRandomIdGenerator implements RequestDataValueProcessor {

	@Override
	public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, String> hiddenFields = new HashMap<String, String>();
		hiddenFields.put("formUID", RandomStringUtils.randomNumeric(5));
		return hiddenFields;
	}

	@Override
	public String processAction(HttpServletRequest request, String action) {
		// TODO Auto-generated method stub
		return action;
	}

	@Override
	public String processFormFieldValue(HttpServletRequest request, String name, String value, String type) {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String processUrl(HttpServletRequest request, String url) {
		// TODO Auto-generated method stub
		return url;
	}

}
