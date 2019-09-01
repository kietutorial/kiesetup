/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.notification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcentive.utils.orm.model.Persistent;

@Entity
@Table(name = "audit_mail_log")
public class AuditMailLog extends Persistent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name = "mail_to")
	private String mailTo;

	@Column(name = "mail_cc")
	private String mailCc;

	@Column(name = "subject")
	private String subject;

	@Column(name = "mail_body")
	private String mailBody;

	@Column(name = "success_flag")
	private Integer successFlag;

	@Column(name = "error_message")
	private String errorMessage;

	@Column(name = "event")
	private String event;

	@Column(name = "number_of_attempt", insertable = false)
	private Integer numberOfAttempt;

	@Column(name = "reference_id")
	private Long referenceId;

	@Column(name = "reference_table_name")
	private String referenceTableName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailCc() {
		return mailCc;
	}

	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public Integer getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(Integer successFlag) {
		this.successFlag = successFlag;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Integer getNumberOfAttempt() {
		return numberOfAttempt;
	}

	public void setNumberOfAttempt(Integer numberOfAttempt) {
		this.numberOfAttempt = numberOfAttempt;
	}

	public Long getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public String getReferenceTableName() {
		return this.referenceTableName;
	}

	public void setReferenceTableName(String referenceTableName) {
		this.referenceTableName = referenceTableName;
	}
}
