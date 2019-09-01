/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.web.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.hcentive.utils.utils.Springi18nUtils;

/**
 * @author ashishjaiswal
 * 
 */
public abstract class AbstractUserController extends BaseController {
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private AuthenticationEventPublisher authEventPublisher;
	// private UserDetailsService userDetailsService;
	@Autowired
	private RememberMeServices rememberMeServices;
	@Autowired
	private AuthenticationManager authenticationManager;

	protected void login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		Authentication authRequest = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authResult = authenticationManager.authenticate(authRequest);
		SecurityContextHolder.getContext().setAuthentication(authResult);
		if (rememberMeServices != null) {
			rememberMeServices.loginSuccess(request, response, authResult);
		}
	}

	protected void autoLogin(String userName, String password, HttpServletRequest request, HttpServletResponse response) {
		Authentication authRequest = new UsernamePasswordAuthenticationToken(userName, password);
		Authentication authResult = authenticationManager.authenticate(authRequest);
		SecurityContextHolder.getContext().setAuthentication(authResult);
		if (rememberMeServices != null) {
			rememberMeServices.loginSuccess(request, response, authResult);
		}
		authEventPublisher.publishAuthenticationSuccess(authResult);
	}

	protected void redirectOriginal(String defaultTargetURL, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		authenticationSuccessHandler.onAuthenticationSuccess(request, response, SecurityContextHolder.getContext()
				.getAuthentication());
		// SavedRequest savedRequest = requestCache.getRequest(request,
		// response);
		// String targetUrl = savedRequest!= null ?
		// savedRequest.getRedirectUrl() : null;
		// if(StringUtils.isEmpty(targetUrl)){
		// targetUrl = defaultTargetURL;
		// }
		// requestCache.removeRequest(request, response);
		// redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public void setRememberMeServices(RememberMeServices rememberMeServices) {
		this.rememberMeServices = rememberMeServices;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler authenticationSuccessHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}

	public void setAuthEventPublisher(AuthenticationEventPublisher authEventPublisher) {
		this.authEventPublisher = authEventPublisher;
	}

}
