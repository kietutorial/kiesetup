/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.xss.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.MDC;

public class LogbackClientRemoteAddressStoreFilter implements Filter {

	// private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// this.filterConfig = filterConfig;
	}

	@Override
	public void destroy() {
		// this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		MDC.put("clientRemoteAddress", request.getRemoteAddr());
		MDC.put("clientRemotehost", request.getRemoteHost());
		MDC.put("serverAddress", request.getLocalAddr());
		chain.doFilter(request, response);
	}
}
