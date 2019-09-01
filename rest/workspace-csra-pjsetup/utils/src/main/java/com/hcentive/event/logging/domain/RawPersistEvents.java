package com.hcentive.event.logging.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.hcentive.utils.orm.model.Persistent;

/**
 * The persistent class for the EVT_RAW_PERSIST_EVENTS database table. There are
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
 * There are a few different cases that need to be handled here
 * depending on the specific scenarios and the processing involved:
 * 
 * [statusCd and readyForProcessing should be set accordingly].
 * A) If the persistence event is a create, then we know entityPrevious
 * will be empty and entityCurrent would have a value.  Then statusCd would
 * be set appropriately to indicate that the record is ready and can 
 * no longer be modified via entity listener. (no jpql required here).
 * 
 * B) @PostLoad event would have the original entity, so the record
 * would be created in the raw events table.  Once this record is created (from A),
 * there are a few different outcomes that can happen:
 * 
 * a) Entity doesn't change, in which case entityCurrent would be blank
 * since there would be no persistence event emitted to invoke logic
 * to update that table.  The record would stay as is and the indicator
 * would be in a StatusCd=NEW status with READY_FOR_PROCESSING set to 'N'.
 *
 * [Update entityCurrent, statusCd and readyForProcessing]
 * b) The entity is modified, so modified persistence event is emitted, we
 * populate entityCurrent and set that statusCd=READY_FOR_PROCESSING and set
 * READY_FOR_PROCESSING flag to 'Y'.
 * 
 * c) The entity is deleted.  This case would have entityPrevious populated
 * but entityCurrent would be blank, but since we have a method invoked
 * for the persistence event, we can update that record by setting
 * statusCd=READY_FOR_PROCESSING and READY_FOR_PROCESSING flag to 'Y'.
 * 
 * We should be able to uniquely identify the record via session_id, created_by,
 * and entityType.  We will always be able to filter records that are not
 * ready via statusCd=NEW and READY_FOR_PROCESSING flag as 'N'.
 * 
 * @author Angelo Traikos
 */

/* Figure out the queries that will be needed in order to interact with
 * this table.  There will be two separate processes that will be communicating
 * with this:
 * 
 * The raw events capture component
 * The event detection logic.
 */

@Entity
@Table(name = "EVT_RAW_PERSIST_EVENTS")
@NamedQueries(value = {

		@NamedQuery(name = "rawPersistEvents.getPersistEventForModification", 
					query = "SELECT DISTINCT p " +
							"FROM RawPersistEvents p " +
							"WHERE p.sessionId=:sessionId AND " +
							"p.referenceId=:referenceId AND " +
							"p.entityType=:entityType " +
							"ORDER BY p.createdDate DESC"),
		
		@NamedQuery(name = "rawPersistEvents.getPersistEventsForProcessing", 
					query = "SELECT p " +
							"FROM RawPersistEvents p " +
							"WHERE p.readyForProcessing=:readyForProcessing AND " +
							"p.statusCd=:statusCd " +
							"ORDER BY p.createdDate ASC"),

		@NamedQuery(name = "rawPersistEvents.updateStatusForProcessing",
					query = "UPDATE RawPersistEvents " +
							"SET statusCd=:statusCd, " +
							"readyForProcessing=:readyForProcessing, " +
							"entityCurrent=:entityCurrent " +
							"WHERE sessionId=:sessionId AND " +
							"createdBy=:createdBy AND " +
							"entityType=:entityType")
})

public class RawPersistEvents extends Persistent {

	private static final long serialVersionUID = -6001836433878082827L;

	//ID: INTEGER
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//ACCOUNT_ID: VARCHAR
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	//SESSION_ID: VARCHAR
	@Column(name = "SESSION_ID")
	private String sessionId;
	
	//REFERENCE_ID: VARCHAR
	@Column(name = "REFERENCE_ID")
	private String referenceId;
	
	//REFERENCE_TYPE: VARCHAR
	@Enumerated(EnumType.STRING)
	@Column(name = "REFERENCE_TYPE")
	private EvtReferenceType referenceType;
	
	//ENTITY_PREVIOUS: BLOB
	//need to figure out java data type for blob
	@Basic(fetch=FetchType.LAZY)
	@Lob @Column(name = "ENTITY_PREVIOUS")
	private byte[] entityPrevious;
	
	//ENTITY_CURRENT: BLOB
	//need to figure out java data type for blob
	@Basic(fetch=FetchType.LAZY)
	@Lob @Column(name = "ENTITY_CURRENT")
	private byte[] entityCurrent;

	//ENTITY_TYPE: VARCHAR
	@Column(name = "ENTITY_TYPE")
	private String entityType;
	
	//STATUS_CD: VARCHAR
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_CD")
	private EvtStatusCd statusCd;
	
	//READY_FOR_PROCESSING: VARCHAR
	@Column(name = "READY_FOR_PROCESSING")
	private String readyForProcessing;
	
	//ACTUAL_RUN_DATE: TIMESTAMP
	@Temporal(TemporalType.DATE)
	@Column(name = "ACTUAL_RUN_DATE")
	private Date actualRunDate;

	//URL: VARCHAR(255)
	@Column(name = "URL")
	private String url;

	//HTTP_METHOD: VARCHAR(10)
	@Column(name = "HTTP_METHOD")
	private String httpMethod;

	//AJAX_REQUEST: VARCHAR(1)
	@Column(name = "AJAX_REQUEST")
	private String ajaxRequest;
	
	@Column(name = "ENRL_PLAN_ID")
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

	@Override
	public boolean equals(final Object other) {
		if (this == other) return true;
		if (!(other instanceof EventsTransaction)) return false;
		
		RawPersistEvents castOther = (RawPersistEvents) other;
		return new EqualsBuilder()
			.append(id, castOther.id)
			.append(accountId, castOther.accountId)
			.append(sessionId, castOther.sessionId)
			.append(referenceId, castOther.referenceId)
			.append(referenceType, castOther.referenceType)
			.append(entityPrevious, castOther.entityPrevious)
			.append(entityCurrent, castOther.entityCurrent)
			.append(entityType, castOther.entityType)
			.append(statusCd, castOther.statusCd)
			.append(readyForProcessing, castOther.readyForProcessing)
			.append(actualRunDate, castOther.actualRunDate)
			.append(url, castOther.url)
			.append(httpMethod, castOther.httpMethod)
			.append(ajaxRequest, castOther.ajaxRequest)
			.append(enrlPlanID, castOther.enrlPlanID)
			.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(1450207409, -1692382659)
			.append(id)
			.append(accountId)
			.append(sessionId)
			.append(referenceId)
			.append(referenceType)
			.append(entityPrevious)
			.append(entityCurrent)
			.append(entityType)
			.append(statusCd)
			.append(readyForProcessing)
			.append(actualRunDate)
			.append(url)
			.append(httpMethod)
			.append(ajaxRequest)
			.append(enrlPlanID)
			.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", id)
			.append("accountId", accountId)
			.append("sessionId", sessionId)
			.append("referenceId", referenceId)
			.append("referenceType", referenceType)
			.append("entityPrevious", entityPrevious)
			.append("entityCurrent", entityCurrent)
			.append("entityType", entityType)
			.append("statusCd", statusCd)
			.append("readyForProcessing", readyForProcessing)
			.append("actualRunDate", actualRunDate)
			.append("url", url)
			.append("httpMethod", httpMethod)
			.append("ajaxRequest", ajaxRequest)
			.append("enrlPlanID", enrlPlanID)
			.append("")
			.toString();
	}
}