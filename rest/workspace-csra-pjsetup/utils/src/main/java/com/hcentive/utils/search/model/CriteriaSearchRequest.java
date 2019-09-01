/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.model;

/**
 * @author ashish.jaiswal
 */
public class CriteriaSearchRequest extends SearchRequest {

	private String criteriaId;

	public CriteriaSearchRequest() {
		super();
	}

	public String getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(String criteriaId) {
		this.criteriaId = criteriaId;
	}

}
