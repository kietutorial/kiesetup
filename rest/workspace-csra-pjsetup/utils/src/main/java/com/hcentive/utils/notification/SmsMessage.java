/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification;

import java.util.Map;

/**
 * @author ashishjaiswal
 * 
 */
public class SmsMessage extends Message {

	private String mobile;
	private String shortMessage;

	public SmsMessage(String mobile, Map<String, Object> data) {
		super(data);
		this.mobile = mobile;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getShortMessage() {
		return shortMessage;
	}

	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}
}
