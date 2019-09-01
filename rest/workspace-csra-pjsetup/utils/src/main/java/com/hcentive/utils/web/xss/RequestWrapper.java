/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.xss;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestWrapper extends HttpServletRequestWrapper {

	private static Logger logger = LoggerFactory.getLogger(RequestWrapper.class);
	
	private boolean mapEncoded = false;

	private Map<String, String> escapeMap = new HashMap<String, String>();
	{
		escapeMap.put("<", "&lt;");
		escapeMap.put(">", "&gt;");
		escapeMap.put("\"", "&quot;");
		//escapeMap.put("'", "&#x27;");
	}

	public RequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		return encodeArray(values);
	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		return encodeString(value);
	}

	@Override
	public Map<String, Object> getParameterMap() {
		@SuppressWarnings("unchecked")
		Map<String, Object> paramValues = super.getParameterMap();
		if (!mapEncoded) {
			try {
				Set<Entry<String, Object>> entrySet = paramValues.entrySet();
				for (Entry<String, Object> entry : entrySet) {
					Object value = entry.getValue();

					if (value != null) {
						if (value instanceof String[]) {
							value = encodeArray((String[]) value);
						} else {
							value = encodeString((String) value);
						}
						entry.setValue(value);
					}
				}
			} catch (Exception ex) {
				// ignore if not able to encode it
				logger.error("EXCEPTION", ex);
			}
			mapEncoded = true;
		}
		return paramValues;
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	private String cleanXSS(String value) {
		Set<String> escapeMapKeys = escapeMap.keySet();
		for (String key : escapeMapKeys) {
			value = value.replaceAll(key, escapeMap.get(key));
		}

		// value = value.replace("\"","&#34;");
		//
		// value = value.replaceAll("'", "&#39;");
		// value = value.replaceAll("eval\\((.*)\\)", "");
		// value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
		// "\"\"");
		// value = value.replaceAll("script", "");
		return value;
	}

	private String[] encodeArray(String[] values) {
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
	}

	private String encodeString(String value) {
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}
}
