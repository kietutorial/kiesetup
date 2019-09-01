/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.demographics.domain;

import java.io.Serializable;

public class ZipCodesPK implements Serializable {

	private String code;

	private String county;

	public ZipCodesPK() {
	}

	public ZipCodesPK(String code, String county) {
		super();
		this.code = code;
		this.county = county;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

}
