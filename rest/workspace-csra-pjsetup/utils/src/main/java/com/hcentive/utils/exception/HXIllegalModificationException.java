/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.exception;

import java.util.Locale;

import com.hcentive.utils.utils.Springi18nUtils;

/**
 * @author ajay mishra
 * 
 */
public class HXIllegalModificationException extends Exception {

	protected String artifactType;
	protected MessageCode messageCode;
	protected String[] args;

	public HXIllegalModificationException(MessageCode messageCode, Throwable th) {
		super(messageCode.toString(), th);
		this.messageCode = messageCode;
	}

	public HXIllegalModificationException(MessageCode messageCode, Throwable th, String... args) {
		super(messageCode.toString(), th);
		this.messageCode = messageCode;
		this.args = args;
	}

	public HXIllegalModificationException(MessageCode messageCode) {
		super(messageCode.toString());
		this.messageCode = messageCode;
	}

	public HXIllegalModificationException(MessageCode messageCode, String... args) {
		super(messageCode.toString());
		this.messageCode = messageCode;
		this.args = args;
	}

	public MessageCode getMessageCode() {
		return messageCode;
	}

	public String[] getArgs() {
		return args;
	}

	public String getI18nMessage(Locale locale) {
		return Springi18nUtils.getMessage(messageCode.getName(), this.args, messageCode.getDefaultMessage(), locale);
	}
	
	public String toString(){
		return getI18nMessage(null);
	}

	public String getArtifactType() {
		return artifactType;
	}

	public void setArtifactType(String artifactType) {
		this.artifactType = artifactType;
	}
}
