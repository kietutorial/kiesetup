package com.hcentive.utils.web.csrf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import com.hcentive.utils.Constants;
import com.hcentive.utils.web.WebUtils;

/**
 * A <code>RequestDataValueProcessor</code> that pushes a hidden field with a
 * CSRF token into forms. This process implements the
 * {@link #getExtraHiddenFields(HttpServletRequest)} method to push the CSRF
 * token obtained from {@link CSRFTokenManager}. To register this processor to
 * automatically process all Spring based forms register it as a Spring bean
 * named 'requestDataValueProcessor' as shown below:
 * 
 */
public class CSRFRequestDataValueProcessor implements RequestDataValueProcessor {

	@Override
	public String processAction(HttpServletRequest request, String action) {
		return action;
	}

	@Override
	public String processFormFieldValue(HttpServletRequest request, String name, String value, String type) {
		return value;
	}

	@Override
	public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
		Map<String, String> hiddenFields = request.getAttribute(Constants.HIDDEN_FIELDS_MAP) != null ? (Map<String, String>) request
				.getAttribute(Constants.HIDDEN_FIELDS_MAP) : new HashMap<String, String>();
		hiddenFields.put("formUID", RandomStringUtils.randomNumeric(5));
		hiddenFields.put(CSRFTokenManager.CSRF_PARAM_NAME, CSRFTokenManager.getTokenForSession(request.getSession()));
		return hiddenFields;
	}

	@Override
	public String processUrl(HttpServletRequest request, String url) {
		if (request.getAttribute(Constants.URL_PARAMS_MAP) != null) {
			Map<String, String> urlParams = (Map<String, String>) request.getAttribute(Constants.URL_PARAMS_MAP);
			for (Map.Entry<String, String> entry : urlParams.entrySet()) {
				if (!url.contains("&" + entry.getKey()) && !url.contains("?" + entry.getKey())) {
					Map<String, String> paramMap = new HashMap<String, String>();
					paramMap.put(entry.getKey(), entry.getValue());
					url = WebUtils.appendParams(url, paramMap);
				}
			}
		}
		return url;
	}
}
