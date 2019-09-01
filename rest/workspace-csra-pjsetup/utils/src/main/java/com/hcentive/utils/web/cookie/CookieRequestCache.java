/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.PortResolver;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class CookieRequestCache implements RequestCache {

	static final String SAVED_REQUEST = "COOKIE_SAVED_REQUEST";

	protected final Log logger = LogFactory.getLog(this.getClass());

	private PortResolver portResolver = new PortResolverImpl();

	@Override
	public HttpServletRequest getMatchingRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SavedRequest getRequest(HttpServletRequest currentRequest, HttpServletResponse response) {
		HttpSession session = currentRequest.getSession(false);
		if (session != null) {
			return (DefaultSavedRequest) session.getAttribute(SAVED_REQUEST);
		}
		return null;
	}

	@Override
	public void removeRequest(HttpServletRequest currentRequest, HttpServletResponse response) {
		HttpSession session = currentRequest.getSession(false);
		if (session != null) {
			logger.debug("Removing DefaultSavedRequest from session if present");
			session.removeAttribute(SAVED_REQUEST);
		}

	}

	@Override
	public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
		DefaultSavedRequest savedRequest = new DefaultSavedRequest(request, portResolver);
		request.getSession().setAttribute(SAVED_REQUEST, savedRequest);
		logger.debug("DefaultSavedRequest added to Session: " + savedRequest);
	}

}
