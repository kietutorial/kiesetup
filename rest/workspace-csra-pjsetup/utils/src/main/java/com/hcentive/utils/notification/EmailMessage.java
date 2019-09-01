/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.notification;

import java.io.InputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ashishjaiswal
 */
public class EmailMessage extends Message {

	private static Logger logger = LoggerFactory.getLogger(EmailMessage.class);

	public static final String ATTACHMENTS_KEY = "attachments";

	private String[] toEmails;
	private String[] ccEmails;
	private String[] bccEmails;
	private String fromName;

	private String subject;
	private String body;
	private Map<String, InputStream> attachments;

	public EmailMessage(String to, Map<String, Object> data) {
		super(data);
		this.toEmails = new String[] { to };
		setAttachmentsFromData(data);
	}

	public EmailMessage(String to, Map<String, Object> data, String fromName) {
		super(data);
		this.toEmails = new String[] { to };
		this.fromName = fromName;
		setAttachmentsFromData(data);
	}

	public String[] getToEmails() {
		return toEmails;
	}

	public void setToEmails(String[] toEmails) {
		this.toEmails = toEmails;
	}

	public String[] getCcEmails() {
		return ccEmails;
	}

	public void setCcEmails(String[] ccEmails) {
		this.ccEmails = ccEmails;
	}

	public String[] getBccEmails() {
		return bccEmails;
	}

	public void setBccEmails(String[] bccEmails) {
		this.bccEmails = bccEmails;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Map<String, InputStream> getAttachments() {
		return attachments;
	}

	public void setAttachments(Map<String, InputStream> attachments) {
		this.attachments = attachments;
	}

	@SuppressWarnings("unchecked")
	private void setAttachmentsFromData(Map<String, Object> data) {
		if (data != null && data.containsKey(ATTACHMENTS_KEY)) {
			try {
				attachments = (Map<String, InputStream>) data.get(ATTACHMENTS_KEY);
			} catch (Exception e) {
				logger.error("Error setting attachments to EmailMessage. Please use Map<AttchmentName, InputStream>", e);
			}
			data.remove(ATTACHMENTS_KEY);
		}
	}
}
