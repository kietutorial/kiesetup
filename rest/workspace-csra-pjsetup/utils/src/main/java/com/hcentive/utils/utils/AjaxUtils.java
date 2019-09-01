/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class AjaxUtils {

	public static boolean isAjaxRequest(String requestedWith) {
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}

	public static boolean isAjaxUploadRequest(HttpServletRequest request) {
		return request.getParameter("ajaxUpload") != null;
	}

	public static String serializeJson(Object object, Map<Class<?>, Class<?>> classMaps) throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		mapper.setDateFormat(formatter);
		if (classMaps != null) {
			Set<Entry<Class<?>, Class<?>>> entrySet = classMaps.entrySet();
			for (Entry<Class<?>, Class<?>> item : entrySet) {
				mapper.getSerializationConfig().addMixInAnnotations(item.getKey(), item.getValue());
			}
		}
		String str = mapper.writeValueAsString(object);
		return str;
	}

	private AjaxUtils() {
	}
}
