/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.exception;

import java.util.Date;

/**
 * @author ashishjaiswal
 * 
 */
public class ServiceFailureException extends RuntimeException {

	private String name;
	private Date requestTime;
	private String customMessage;

	public ServiceFailureException(String name, Date requestTime, Throwable th) {
		super(th);
		this.name = name;
		this.requestTime = requestTime;
	}

	public ServiceFailureException(String name, Date requestTime, String customMessage, Throwable th) {
		super(th);
		this.name = name;
		this.requestTime = requestTime;
		this.customMessage = customMessage;
	}

	public String getName() {
		return name;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public String getShortMessage() {
		return this.getMessage();
	}

}
