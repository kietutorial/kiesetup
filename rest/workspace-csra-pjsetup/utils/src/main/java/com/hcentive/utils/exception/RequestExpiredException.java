/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.exception;

/**
 * @author ashishjaiswal
 * 
 */
public class RequestExpiredException extends HCException {

	public static final MessageCode REQUEST_EXPIRED_ERROR = new MessageCode("REQUEST_EXPIRED_ERROR",
			"You accessed this page directly or your session may have been expired");

	public RequestExpiredException(MessageCode messageCode) {
		super(messageCode);
	}

	public RequestExpiredException(MessageCode messageCode, String... args) {
		super(messageCode, args);
	}

	public RequestExpiredException(MessageCode messageCode, Throwable th, String... args) {
		super(messageCode, th, args);
	}

	public RequestExpiredException(MessageCode messageCode, Throwable th) {
		super(messageCode, th);
	}

}
