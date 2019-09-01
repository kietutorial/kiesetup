/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.exception;

/**
 * @author ashish.jaiswal
 * 
 */
public class HCRuntimeException extends RuntimeException {

	protected MessageCode messageCode;
	protected String[] args;

	public HCRuntimeException(MessageCode messageCode, Throwable th) {
		super(messageCode.toString(), th);
		this.messageCode = messageCode;
	}

	public HCRuntimeException(MessageCode messageCode, Throwable th, String... args) {
		super(messageCode.toString(), th);
		this.messageCode = messageCode;
		this.args = args;
	}

	public HCRuntimeException(MessageCode messageCode) {
		super(messageCode.toString());
		this.messageCode = messageCode;
	}

	public HCRuntimeException(MessageCode messageCode, String... args) {
		super(messageCode.getDefaultMessage());
		this.args = args;
		this.messageCode = messageCode;
	}

	public MessageCode getMessageCode() {
		return messageCode;
	}

	public String[] getArgs() {
		return args;
	}
}
