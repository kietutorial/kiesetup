/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.security.acl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.core.Authentication;

/**
 * Implementation of
 * {@link org.springframework.security.access.AccessDecisionManager} that grants
 * access if all <code>non-'ROLE_*' AccessDecisionVoter</code> return an
 * affirmative response and any <code>'ROLE_*' AccessDecisionVoter</code> also
 * grants the response.
 * 
 * @author Sumit Taneja
 */
public class SelectiveBased extends AbstractAccessDecisionManager {

	private String rolePrefix = "ROLE_";

	private String permissionPrefix = "PERM_";

	@SuppressWarnings("rawtypes")
	public SelectiveBased(List<AccessDecisionVoter> decisionVoters) {
		super(decisionVoters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#decide(org.
	 * springframework.security.core.Authentication, java.lang.Object,
	 * java.util.Collection)
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> attributes)
			throws AccessDeniedException {

		int grant = 0;
		int deny = 0;

		List<ConfigAttribute> singleAttributeList = new ArrayList<ConfigAttribute>(1);
		singleAttributeList.add(null);

		for (ConfigAttribute attribute : attributes) {
			boolean isMandatory = isAttributeMandatory(attribute);

			singleAttributeList.set(0, attribute);
			for (AccessDecisionVoter voter : getDecisionVoters()) {
				int result = voter.vote(authentication, object, singleAttributeList);

				if (logger.isDebugEnabled()) {
					logger.debug("Voter: " + voter + ", returned: " + result);
				}

				switch (result) {
				case AccessDecisionVoter.ACCESS_GRANTED:
					if (!isMandatory) {
						grant++;
					}
					break;

				case AccessDecisionVoter.ACCESS_DENIED:
					if (isMandatory) {
						throw new AccessDeniedException(messages.getMessage("AbstractAccessDecisionManager.accessDenied",
								"Access is denied"));
					}
					deny++;
					break;
				}
			}
		}

		// To get this far, there were no deny votes by mandatory attributes
		if (grant > 0) {
			return;
		}

		// To get this far, there were no grant votes by non-mandatory
		// attributes
		if (deny > 0) {
			return;
			//throw new AccessDeniedException(messages.getMessage("AbstractAccessDecisionManager.accessDenied", "Access is denied"));
		}

		// To get this far, every non-mandatory AccessDecisionVoter abstained
		checkAllowIfAllAbstainDecisions();
	}

	private boolean isAttributeMandatory(ConfigAttribute attribute) {
		return attribute.getAttribute() == null
				|| !(attribute.getAttribute().startsWith(rolePrefix) || attribute.getAttribute().startsWith(permissionPrefix));
	}
}
