/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author ashishjaiswal
 */
public class SimpleAccessPermissionsMappingsManager implements InitializingBean, AccessPermissionsMappingsManager {

	Map<String, Set<String>> mapOfConfigAttributes = new HashMap<String, Set<String>>();
	Map<String, Set<GrantedAuthority>> mapOfAccessPermissions = new HashMap<String, Set<GrantedAuthority>>();

	public void setMapOfConfigAttributes(Map<String, Set<String>> mapOfPermissions) {
		this.mapOfConfigAttributes = mapOfPermissions;
	}

	@Override
	public Set<GrantedAuthority> getAccessPermissions(String configAttribute) {
		return mapOfAccessPermissions.get(configAttribute);
	}

	protected void initMap() {
		for (String keyConfigAttribute : mapOfConfigAttributes.keySet()) {
			Set<GrantedAuthority> accessPermissions = mapOfAccessPermissions.get(keyConfigAttribute);
			if (accessPermissions == null) {
				accessPermissions = new HashSet<GrantedAuthority>();
				mapOfAccessPermissions.put(keyConfigAttribute, accessPermissions);
			}
			for (String mappedAttribute : mapOfConfigAttributes.get(keyConfigAttribute)) {
				accessPermissions.add(new SimpleGrantedAuthority(mappedAttribute));
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initMap();
	}
}
