/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.listener;

import java.util.List;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.hcentive.utils.security.SystemAuthenticationToken;

public abstract class AbstractApplicationListener<E extends ApplicationEvent> implements ApplicationListener<E> {

	/** System authentication object. */
	private static Authentication authentication;

	/**
	 * Initializing the Authentication object
	 */
	static {
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_SYSTEM");
		SystemAuthenticationToken systemAuthenticationToken = new SystemAuthenticationToken(authorities);
		authentication = systemAuthenticationToken;
	}

	/**
	 * Overriding the default callback method on event occurrence and setting
	 * SYSTEM authentication object, and calling onEvent function which will be
	 * implemented by the sub classes
	 */
	@Override
	public final void onApplicationEvent(E event) {
		SecurityContextHolder.getContext().setAuthentication(authentication);
		onEvent(event);
	}

	/**
	 * Callback method on event occurrence
	 * 
	 * @param event
	 */
	public abstract void onEvent(E event);

}
