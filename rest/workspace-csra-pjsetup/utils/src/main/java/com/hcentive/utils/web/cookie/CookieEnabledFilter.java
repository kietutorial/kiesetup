/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.cookie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hcentive.utils.web.CookieEnabledUtils;

@Component
public class CookieEnabledFilter extends OncePerRequestFilter {
	
	
	private static String appURL;

	private static String DEFAULT_CHECK_COOKIE_URL = "/checkCookie";

	private String checkCookieUrl;

	private List<String> urlsToIgnore;

	@Value("${app.url}")
	public void setAppURL(String url) {
		appURL = url;
	}

	@Override
	protected void initFilterBean() throws ServletException {

		if (!StringUtils.hasText(checkCookieUrl)) {
			checkCookieUrl = DEFAULT_CHECK_COOKIE_URL;
		}
		urlsToIgnore = new ArrayList<String>();
		urlsToIgnore.addAll(Arrays.asList("/css", "/js", "/images", "/ws"));
		urlsToIgnore.add(checkCookieUrl);

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Boolean cookieEnabledFlag = CookieEnabledUtils.getCookieEnabledFlagSet(request);
		if (!cookieEnabledFlag) {
			CookieEnabledUtils.saveRequest(request, response);
			CookieEnabledUtils.setCookieEnabledFlag(request, response,appURL);
			response.sendRedirect(request.getContextPath() + checkCookieUrl);

		} else {
			filterChain.doFilter(request, response);
		}

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String requestUrl = request.getRequestURI();
		for (String urlToIgnore : urlsToIgnore) {
			if (requestUrl.contains(urlToIgnore)) {
				return true;
			}
		}
		return false;
	}

	public void setCheckCookieUrl(String url) {
		this.checkCookieUrl = url;
	}

}
