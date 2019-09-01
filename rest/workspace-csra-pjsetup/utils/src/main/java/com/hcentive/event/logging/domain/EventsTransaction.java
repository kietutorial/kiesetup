package com.hcentive.event.logging.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.orm.model.Persistent;

/**
 * The persistent class for the EVT_EVENTS_ENTITY_MASTER database table. There are
 * four common fields used in many different tables in the database. These
 * fields are:
 * <ul>
 * <li>CREATED_BY
 * <li>CREATED_DATE
 * <li>UPDATED_BY
 * <li>UPDATED_DATE
 * </ul>
 * 
 * There is already an entity-like class that takes care of the appropriate
 * mapping and getters/setters for tables which include these fields, which is
 * the com.hcentive.utils.orm.model.Persistent class.
 * 
 * This persistent class extends com.hcentive.utils.orm.model.Persistent for
 * this functionality.
 * 
 * @author Angelo Traikos
 */

@Entity
@Table(name = "EVT_EVENTS_TRANSACTION")
@NamedQueries(value = {

		@NamedQuery(name = "getEventsTransactionByAccountId", 
					query = "SELECT DISTINCT e FROM EventsTransaction e WHERE e.accountId=:accountId"),

		@NamedQuery(name = "getEventsTransactionBySessionId", 
					query = "SELECT DISTINCT e FROM EventsTransaction e WHERE e.sessionId=:sessionId"),
					
		@NamedQuery(name = "getEventsTransactionByReferenceId", 
					query = "SELECT DISTINCT e FROM EventsTransaction e WHERE e.referenceId=:referenceId")
})

public class EventsTransaction extends Persistent {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//EVENT_ENTITY_NAME VARCHAR(50) NOT NULL,  --> fk
	@Enumerated(EnumType.STRING)
	@Column(name = "EVENT_ENTITY_NAME")
	private EvtEventEntityName eventEntityName;

	//BASE_EVENT_NAME VARCHAR(50) NOT NULL, --> fk
	@Enumerated(EnumType.STRING)
	@Column(name = "BASE_EVENT_NAME")
	private EvtBaseEventName baseEventName;

	//EVENT_NAME VARCHAR(50) NOT NULL, --> fk
	@Enumerated(EnumType.STRING)
	@Column(name = "EVENT_NAME")
	private EvtEventName eventName;

 	//ACCOUNT_ID VARCHAR(14),	
	@Column(name = "ACCOUNT_ID")
	private String accountId;

	//REFERENCE_ID VARCHAR(100),
	@Column(name = "REFERENCE_ID")
	private String referenceId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "REFERENCE_TYPE")
	private EvtReferenceType referenceType;

	//SESSION_ID VARCHAR(100),
	@Column(name = "SESSION_ID")
	private String sessionId;

	//NOTES VARCHAR(4000),	
	@Column(name = "NOTES")
	private String notes;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "event_date")
	private Date eventDate;
	
	@Column(name = "INITIATED_BY")
	private String initiatedBy;
	
	@Column(name = "EVENT_DESCRIPTION",columnDefinition="VARCHAR2(500) default ' '") 
	private String eventDescription;

	@Column(name = "REASON_CODE")
	private String enrlPlanTranActionReasonCode;

	// CR 1398,1413,1594
	@Column(name = "DOCCS_RELEASE_CODE")
	private String doccsReleaseCode;

	public EventsTransaction () {
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
		this.accountId = (accountId == null ? null : accountId.trim());
	}

	public String getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = (referenceId == null ? null : referenceId.trim());
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
	
	public EvtReferenceType getReferenceType() {
		return referenceType;
	}
	
	public void setReferenceType(EvtReferenceType referenceType) {
		this.referenceType = referenceType;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (this == other) return true;
		if (!(other instanceof EventsTransaction)) return false;
		
		EventsTransaction castOther = (EventsTransaction) other;
		return new EqualsBuilder()
			.append(eventEntityName, castOther.eventEntityName)
			.append(baseEventName, castOther.baseEventName)
			.append(eventName, castOther.eventName)
			.append(accountId, castOther.accountId)
			.append(referenceId, castOther.referenceId)
			.append(referenceType, castOther.referenceType)
			.append(sessionId, castOther.sessionId)
			.append(notes, castOther.notes)
			.append(eventDescription, castOther.eventDescription)
			.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(1450207409, -1692382659)
			.append(eventEntityName)
			.append(baseEventName)
			.append(eventName)
			.append(accountId)
			.append(referenceId)
			.append(referenceType)
			.append(sessionId)
			.append(notes)
			.append(eventDescription)
			.toHashCode();
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
			.append("eventDescription", eventDescription)
			.toString();
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		if(eventDescription != null){
			this.eventDescription = eventDescription;
		}else{
			this.eventDescription = " ";
		}
	}

	public String getEnrlPlanTranActionReasonCode() {
		return enrlPlanTranActionReasonCode;
	}

	public void setEnrlPlanTranActionReasonCode(String enrlPlanTranActionReasonCode) {
		if(HXUtility.isEmpty(enrlPlanTranActionReasonCode)) {
			this.enrlPlanTranActionReasonCode = " ";
		}else{
			this.enrlPlanTranActionReasonCode = enrlPlanTranActionReasonCode;
		}
	}

	/** 
	 * This Method is used to get Doccs Release Code
	 * CR 1398,1413,1594
	 * @return doccsReleaseCode
	 */
	public String getDoccsReleaseCode() {
		return doccsReleaseCode;
	}
	
	/**
	 * This Method is used to set Doccs Release Code
	 * CR 1398,1413,1594
	 * @param doccsReleaseCode
	 */
	public void setDoccsReleaseCode(String doccsReleaseCode) {
		this.doccsReleaseCode = doccsReleaseCode;
	}

}