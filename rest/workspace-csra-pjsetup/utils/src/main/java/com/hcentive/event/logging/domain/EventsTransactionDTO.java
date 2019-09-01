package com.hcentive.event.logging.domain;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * This class is a Data Transfer Object for the 
 * EVT_EVENTS_TRANSACTION database table.
 *
 * @author Angelo Traikos
 */

public class EventsTransactionDTO {

	private Long id;
	private EvtEventEntityName eventEntityName;
	private EvtBaseEventName baseEventName;
	private EvtEventName eventName;
	private String accountId;
	private String referenceId;
	private EvtReferenceType referenceType;
	private String sessionId;
	private String notes;
	private Date eventDate;
	private String initiatedBy;
	private String eventDescription;
	//CR555
	private String enrlPlanTranActionReasonCode;

	

	public EventsTransactionDTO () {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EvtEventEntityName getEventEntityName() {
		return eventEntityName;
	}

	public void setEventEntityName(EvtEventEntityName eventEntityName) {
		this.eventEntityName = eventEntityName;
	}

	public EvtBaseEventName getBaseEventName() {
		return baseEventName;
	}

	public void setBaseEventName(EvtBaseEventName baseEventName) {
		this.baseEventName = baseEventName;
	}

	public EvtEventName getEventName() {
		return eventName;
	}

	public void setEventName(EvtEventName eventName) {
		this.eventName = eventName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getReferenceId() {
		return this.referenceId;
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

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("eventEntityName", eventEntityName)
			.append("baseEventName", baseEventName)
			.append("eventName", eventName)
			.append("accountId", accountId)
			.append("referenceId", referenceId)
			.append("referenceType", referenceType)
			.append("sessionId", sessionId)
			.append("notes", notes)
			.append("initiatedBy", initiatedBy)
			.append("eventDescription", eventDescription)
			.toString();
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
// added as part of CR 522 - to add this field in the event transaction table.
	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
			this.eventDescription = eventDescription;
	}

	public String getEnrlPlanTranActionReasonCode() {
		return enrlPlanTranActionReasonCode;
	}

	public void setEnrlPlanTranActionReasonCode(String enrlPlanTranActionReasonCode) {
		this.enrlPlanTranActionReasonCode = enrlPlanTranActionReasonCode;
	}
}
