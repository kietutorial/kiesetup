/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.search.service;

import java.util.Collection;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchCriteria;
import com.hcentive.utils.search.model.SearchRequest;
import com.hcentive.utils.security.AccessPermissionsMappingsManager;

/**
 * @author ashish.jaiswal
 */
public abstract class SearchSecurityInterceptor {

	private AccessPermissionsMappingsManager accessPersmissionMappingsManager;

	public Object authorize(ProceedingJoinPoint pjp) throws Throwable {
		Object[] requestArgs = pjp.getArgs();
		SearchRequest searchRequest = (SearchRequest) requestArgs[0];

		// check if user is allowed access on this query
		if (!isUserAllowed(searchRequest)) {
			throw new AccessDeniedException("You are not authorized to perform this operation");
		}

		// add system defined criteria in this request
		SearchCriteria systemCriteria = searchRequest.getSystemCriteria();
		if (systemCriteria == null) {
			systemCriteria = new SearchCriteria();
		}
		SearchCriteria addonSystemCriteria = defineSystemCriteria(searchRequest);
		if (addonSystemCriteria != null) {
			systemCriteria.putAll(addonSystemCriteria);
		}
		searchRequest.setSystemCriteria(systemCriteria);
		return pjp.proceed();
	}

	protected boolean isUserAllowed(SearchRequest searchRequest) {
		Authentication auth = getAuthentication();

		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> allowedAuths = (Collection<GrantedAuthority>) auth.getAuthorities();

		QuerySearchRequest querySearchRequest = (QuerySearchRequest) searchRequest;
		String queryId = querySearchRequest.getQueryId();
		Set<GrantedAuthority> requiredAuths = accessPersmissionMappingsManager.getAccessPermissions(queryId);
		if (requiredAuths == null) {
			return true;
		}

		for (GrantedAuthority a : requiredAuths) {
			if (allowedAuths.contains(a)) {
				return true;
			}
		}
		return false;
	}

	protected abstract SearchCriteria defineSystemCriteria(SearchRequest searchRequest);

	public void setAccessPersmissionMappingsManager(AccessPermissionsMappingsManager accessPersmissionMappingsManager) {
		this.accessPersmissionMappingsManager = accessPersmissionMappingsManager;
	}

	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
