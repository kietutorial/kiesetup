/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web;

import java.net.URL;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.savedrequest.SavedRequest;
import com.hcentive.utils.web.cookie.CookieRequestCache;

public class CookieEnabledUtils {

	
	private static final Logger logger = LoggerFactory.getLogger(CookieEnabledUtils.class);

	private static final String COOKIE_ENABLED_FLAG = "cookieEnabled";

	public static void setCookieEnabledFlag(HttpServletRequest request, HttpServletResponse response,String appURL) {
		Cookie cookie = new Cookie(COOKIE_ENABLED_FLAG, "true");
		cookie.setPath("/");
		if (!StringUtils.isBlank(appURL)) {
			try {
				URL url = new URL(appURL);
				if ("HTTPS".equalsIgnoreCase(url.getProtocol())) {
					cookie.setSecure(true);
					logger.info("Enabled secure cookie");
				}

			} catch(Exception urlexp) {
				urlexp.printStackTrace();
				logger.error(urlexp.getMessage());
			}
		}
		response.addCookie(cookie);
	}

	public static boolean getCookieEnabledFlagSet(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(COOKIE_ENABLED_FLAG)) {
					return cookie.getValue().equals("true");
				}
			}
		}
		return false;

	}

	public static void saveRequest(HttpServletRequest request, HttpServletResponse response) {
		CookieRequestCache cache = new CookieRequestCache();
		cache.saveRequest(request, response);
	}

	public static SavedRequest getSavedRequest(HttpServletRequest request, HttpServletResponse response) {
		CookieRequestCache cache = new CookieRequestCache();
		SavedRequest savedRequest = cache.getRequest(request, response);
		cache.removeRequest(request, response);
		return savedRequest;
	}

}
