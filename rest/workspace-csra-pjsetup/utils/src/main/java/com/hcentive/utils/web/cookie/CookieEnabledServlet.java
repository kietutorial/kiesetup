/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.hcentive.utils.web.CookieEnabledUtils;

public class CookieEnabledServlet extends HttpServlet {

	private static String COOKIE_DISABLED_URL;

	@Override
	public void init() throws ServletException {
		CookieEnabledServlet.COOKIE_DISABLED_URL = getServletConfig().getInitParameter("cookieDisabledUrl");
		if (!StringUtils.hasText(CookieEnabledServlet.COOKIE_DISABLED_URL)) {
			throw new ServletException("Cookie disabled url is required param");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Boolean cookieEnabled = CookieEnabledUtils.getCookieEnabledFlagSet(req);
		if (cookieEnabled) {
			SavedRequest savedRequest = CookieEnabledUtils.getSavedRequest(req, resp);
			String targetUrl = savedRequest.getRedirectUrl();
			resp.sendRedirect(targetUrl);
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(CookieEnabledServlet.COOKIE_DISABLED_URL);
			dispatcher.forward(req, resp);
		}
	}
}
