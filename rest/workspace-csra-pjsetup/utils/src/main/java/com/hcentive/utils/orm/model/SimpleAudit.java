/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.orm.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
/**
 * @author ashish.jaiswal
 * 
 */
public class SimpleAudit {

	@PrePersist
	public void auditCreate(AbstractPersistent persistent) {
		setCreatedDate(persistent);
		setUpdatedDate(persistent);
		String loggedInUserName = getLoggedInUsername();
		if (StringUtils.hasText(loggedInUserName)) {
			persistent.setCreatedBy(loggedInUserName);
			persistent.setUpdatedBy(loggedInUserName);
		} else {
			setCreatedBy(persistent);
			setUpdatedBy(persistent);
		}
	}

	@PreUpdate
	public void auditUpdate(AbstractPersistent persistent) {
		setUpdatedDate(persistent);
		String loggedInUserName = getLoggedInUsername();
		if (StringUtils.hasText(loggedInUserName)) {
			persistent.setUpdatedBy(loggedInUserName);
		} else {			
			setUpdatedBy(persistent);
		}
	}

	private String getLoggedInUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof UserDetails) {
			String principal=((UserDetails) auth.getPrincipal()).getUsername();
			String userName=null;
			if(null!=principal){
				userName=getLoggedInUserName(principal);
				if(null!=userName){
					return userName;
				}else{
					return ((UserDetails) auth.getPrincipal()).getUsername();	
				}
			}
		}
		return null;
	}
	
	private String getLoggedInUserName(String principal){
		String userName=null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> granteds = authentication.getAuthorities();
		for (GrantedAuthority authority : granteds) {
			if("ROLE_SIEBEL".equalsIgnoreCase(authority.getAuthority())){
				userName=principal+"_SIEBEL";
				break;
			}else if("ROLE_NONSIEBEL".equalsIgnoreCase(authority.getAuthority())){
				userName=principal+"_NONSIEBEL";
				break;
			}
		}
		return userName;
	}
	
	private void setUpdatedBy(AbstractPersistent persistent) {
		if(StringUtils.hasText(persistent.getUpdatedBy())
				&& persistent.overrideUpdatedBy()){
			// Use existing Created By
		}else{
			persistent.setUpdatedBy("SYSTEM");
		}
	}

	private void setCreatedBy(AbstractPersistent persistent) {
		if(StringUtils.hasText(persistent.getCreatedBy())
				&& persistent.overrideCreatedBy()){
			// Use existing Created By
		}else{
			persistent.setCreatedBy("SYSTEM");
		}
	}

	private void setUpdatedDate(AbstractPersistent persistent) {
		if(null != persistent.getUpdatedDate()
				&& persistent.overrideUpdatedDate()){
			// Use existing Created By
		}else{
			persistent.setUpdatedDate(new Date());
		}
	}

	private void setCreatedDate(AbstractPersistent persistent) {
		if(null != persistent.getCreatedDate()
				&& persistent.overrideCreatedDate()){
			// Use existing Created By
		}else{
			persistent.setCreatedDate(new Date());
		}
	}	
}
