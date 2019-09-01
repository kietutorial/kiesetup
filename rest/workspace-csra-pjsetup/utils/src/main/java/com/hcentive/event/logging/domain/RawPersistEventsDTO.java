package com.hcentive.event.logging.domain;

import java.util.Date;

import com.hcentive.job.ext.BaseJobDTO;

/* Figure out the queries that will be needed in order to interact with
 * this table.  There will be two separate processes that will be communicating
 * with this:
 * 
 * The raw events capture component
 * The event detection logic.
 */

public class RawPersistEventsDTO extends BaseJobDTO{
	
	private Long id;
	private String accountId;
	private String sessionId;
	private String referenceId;
	private EvtReferenceType referenceType;
	private byte[] entityPrevious;
	private byte[] entityCurrent;
	private String entityType;
	private EvtStatusCd statusCd;
	private String readyForProcessing;
	private Date actualRunDate;
	private String createdBy;
	private Date createdDate;
	private String url;
	private String httpMethod;
	private String ajaxRequest;
	//CR555
	private int enrlPlanID;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public EvtReferenceType getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(EvtReferenceType referenceType) {
		this.referenceType = referenceType;
	}

	public byte[] getEntityPrevious() {
		return entityPrevious;
	}

	public void setEntityPrevious(byte[] entityPrevious) {
		this.entityPrevious = entityPrevious;
	}

	public byte[] getEntityCurrent() {
		return entityCurrent;
	}

	public void setEntityCurrent(byte[] entityCurrent) {
		this.entityCurrent = entityCurrent;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public EvtStatusCd getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(EvtStatusCd statusCd) {
		this.statusCd = statusCd;
	}

	public String getReadyForProcessing() {
		return readyForProcessing;
	}

	public void setReadyForProcessing(String readyForProcessing) {
		this.readyForProcessing = readyForProcessing;
	}

	public Date getActualRunDate() {
		return actualRunDate;
	}

	public void setActualRunDate(Date actualRunDate) {
		this.actualRunDate = actualRunDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getAjaxRequest() {
		return ajaxRequest;
	}

	public void setAjaxRequest(String ajaxRequest) {
		this.ajaxRequest = ajaxRequest;
	}

	public int getEnrlPlanID() {
		return enrlPlanID;
	}

	public void setEnrlPlanID(int enrlPlanID) {
		this.enrlPlanID = enrlPlanID;
	}

	
	
}