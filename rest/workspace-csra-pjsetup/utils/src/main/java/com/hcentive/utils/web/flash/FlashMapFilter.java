/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web.flash;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * The Class FlashMapFilter.
 */
public class FlashMapFilter extends OncePerRequestFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Map<String, ?> flash = (Map<String, ?>) session.getAttribute(FlashMap.FLASH_MAP_ATTRIBUTE);
			if (flash != null) {
				for (Map.Entry<String, ?> entry : flash.entrySet()) {
					Object currentValue = request.getAttribute(entry.getKey());
					if (currentValue == null) {
						request.setAttribute(entry.getKey(), entry.getValue());
					}
				}
				session.removeAttribute(FlashMap.FLASH_MAP_ATTRIBUTE);
			}
		}
		filterChain.doFilter(request, response);
	}
}
