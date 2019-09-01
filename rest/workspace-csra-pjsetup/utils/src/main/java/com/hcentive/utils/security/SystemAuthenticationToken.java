/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

public class SystemAuthenticationToken extends AbstractAuthenticationToken {

	public SystemAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		if (authorities != null && authorities.size() == 1) {
			for (GrantedAuthority a : authorities) {
				if (a != null && StringUtils.hasText(a.getAuthority()) && "ROLE_SYSTEM".equals(a.getAuthority())) {
					this.setAuthenticated(true);
				}
			}
		}
	}

	@Override
	public Object getCredentials() {
		return "";
	}

	@Override
	public Object getPrincipal() {
		return "";
	}

}
