/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.action;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.hcentive.utils.picklistprovider.PickListProvider;
import com.hcentive.utils.utils.ConversionUtils;
import com.hcentive.utils.utils.Springi18nUtils;

public class BaseController {

	private static Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected PickListProvider pickListProvider;

	protected String[] pickListNames;

	public void initPicklists(HttpServletRequest request) {
		if (pickListProvider == null || pickListNames == null || pickListNames.length == 0) {
			return;
		}
		for (String id : pickListNames) {
			initPicklist(id, request);
		}
	}

	protected void initPicklist(String id, HttpServletRequest request) {
		copyObjectToRequest(id + "List", getLocalizedPicklist(id, request), request);
	}

	protected void copyObjectToRequest(String name, Object object, HttpServletRequest request) {
		request.setAttribute(name, object);
	}

	protected Map<String, String> getLocalizedPicklist(String id, HttpServletRequest request) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);
		Map<String, String> picklist = pickListProvider.getPickList(id, locale);

		Map<String, String> lclPL = new LinkedHashMap<String, String>();
		if (picklist != null && picklist.size() != 0) {
			for (String key : picklist.keySet()) {
				lclPL.put(key, picklist.get(key));
			}
		} else {
			// no locale specific picklist found, using default locale
			picklist = pickListProvider.getPickList(id);
			if (picklist != null && picklist.size() != 0) {
				for (String key : picklist.keySet()) {
					lclPL.put(key, picklist.get(key));
				}
			}
		}
		return lclPL;
	}

	protected Date deriveDob(String dob) {
		if (dob != null) {
			try {
				return ConversionUtils.convertFromString(dob);
			} catch (Exception e) {
				logException(logger, e);
				return null;
			}
		}
		return null;
	}

	public PickListProvider getPickListProvider() {
		return pickListProvider;
	}

	public void setPickListProvider(PickListProvider pickListProvider) {
		this.pickListProvider = pickListProvider;
	}

	public String[] getPickListNames() {
		return pickListNames;
	}

	public void setPickListNames(String[] pickListNames) {
		this.pickListNames = pickListNames;
	}

	protected void logException(org.slf4j.Logger logger, Exception e) {
		logger.error("Exception", e);
	}

	protected void addBindingResultsInList(BindingResult bindingResult, Collection<String> errors, Locale locale) {
		List<ObjectError> objectErrors = bindingResult.getAllErrors();
		for (ObjectError objectError : objectErrors) {
			String defaultMessage = objectError.getDefaultMessage(), customMessage = defaultMessage;
			for (String errorCode : objectError.getCodes()) {
				customMessage = Springi18nUtils.getMessage(errorCode, objectError.getArguments(), defaultMessage, locale);
				if (!defaultMessage.equals(customMessage))
					break;
			}
			errors.add(customMessage);
		}
	}
	
	/** Dummy prepare method; all implementing sub classes must override to prepare request for controller***/
	public void prepare(HttpServletRequest request) throws Exception {
		
	} 
}
