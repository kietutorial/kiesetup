/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.security;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author ashishjaiswal
 * 
 */
public interface AccessPermissionsMappingsManager {
	public Set<GrantedAuthority> getAccessPermissions(String configAttribute);
}
