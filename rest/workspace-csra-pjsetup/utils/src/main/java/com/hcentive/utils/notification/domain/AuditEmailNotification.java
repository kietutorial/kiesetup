/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcentive.utils.orm.model.Persistent;

@Entity
@Table(name = "audit_email_notification")
public class AuditEmailNotification extends Persistent {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "to_email")
	private String toEmail;

	@Column(name = "cc_email")
	private String ccEmail;

	@Column(name = "bcc_email")
	private String bccEmail;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "status")
	private String status;

	@Column(name = "params")
	private String params;

	/*
	 * @Column(name="reason_of_failure") private String reasonOfFailure;
	 * 
	 * @Column(name="number_of_reattempts") private Integer numberOfReattempts;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getCcEmail() {
		return ccEmail;
	}

	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}

	public String getBccEmail() {
		return bccEmail;
	}

	public void setBccEmail(String bccEmail) {
		this.bccEmail = bccEmail;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	/*
	 * public String getReasonOfFailure() { return reasonOfFailure; }
	 * 
	 * public void setReasonOfFailure(String reasonOfFailure) {
	 * this.reasonOfFailure = reasonOfFailure; }
	 * 
	 * public Integer getNumberOfReattempts() { return numberOfReattempts; }
	 * 
	 * public void setNumberOfReattempts(Integer numberOfReattempts) {
	 * this.numberOfReattempts = numberOfReattempts; }
	 */

	public String[] getCCEmails() {
		if (getCcEmail() != null) {
			return getCcEmail().split(",");
		}
		return null;
	}

	public String[] getBCCEmails() {
		if (getBccEmail() != null) {
			return getBccEmail().split(",");
		}
		return null;
	}

}
