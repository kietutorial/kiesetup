/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.security.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author ashishjaiswal
 * 
 */
public class PasswordChangeFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(PasswordChangeFilter.class);

	protected final String ERRORS_KEY = "errors";
	protected String changePasswordKey = "user.must.change.password";

	private String changePasswordUrl = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws ServletException {
		Assert.notNull(changePasswordUrl, "changePasswordUrl must be set.");
		Assert.notNull(changePasswordKey, "changePasswordKey must be set.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		String requestURL = request.getRequestURL().toString();

		logger.debug("changepasswordfilter URL: " + request.getRequestURL());
		logger.debug("changepasswordfilter URI: " + request.getRequestURI());

		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (obj instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) obj;
			if (!userDetails.isCredentialsNonExpired()) {
				// send user to change password page
				logger.debug("credentials expired - sending to changepassword page.");

				int pos = requestURL.indexOf(changePasswordUrl);
				if (pos == -1) {
					saveError(request, changePasswordKey);
					sendRedirect(request, response, changePasswordUrl);
					return;
				}
			}
		} else {
			// do nothing in case user is not logged-in
		}
		chain.doFilter(request, response);
	}

	/**
	 * The URL to the Change Password page. It must begin with a slash and
	 * should be relative from the application's contextPath root (ex:
	 * /change-password).
	 * 
	 * @param changePasswordUrl
	 *            the changePasswordUrl to set
	 */
	public void setChangePasswordUrl(String changePasswordUrl) {
		this.changePasswordUrl = changePasswordUrl;
	}

	/**
	 * Allow subclasses to modify the redirection message.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param url
	 *            the URL to redirect to
	 * 
	 * @throws IOException
	 *             in the event of any failure
	 */
	protected void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		if (!url.startsWith("http://") && !url.startsWith("https://")) {
			url = request.getContextPath() + url;
		}
		response.sendRedirect(response.encodeRedirectURL(url));
	}

	protected void saveError(HttpServletRequest request, String msg) {
		@SuppressWarnings("unchecked")
		Set<String> errors = (Set<String>) request.getSession().getAttribute(ERRORS_KEY);

		if (errors == null) {
			errors = new HashSet<String>();
		}
		errors.add(msg);
		request.getSession().setAttribute(ERRORS_KEY, errors);
	}

	/**
	 * The message bundle key that will hold the "You must change your password"
	 * error message. The default key name is <b>user.must.change.password</b>.
	 * 
	 * @param changePasswordKey
	 *            the changePasswordKey to set
	 */
	public void setChangePasswordKey(String changePasswordKey) {
		this.changePasswordKey = changePasswordKey;
	}
}
