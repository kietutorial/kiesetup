package com.hcentive.cs.override;

import java.util.Date;

import com.hcentive.event.logging.domain.EvtReferenceType;
import com.hcentive.event.logging.domain.NotesTypes;

public class AccountNotesBean {	
	
	public AccountNotesBean() {
	}
	
	private Long id;
	
	private NotesTypes notesTypes;
	
	private String accountId;
 	
 
	private String appealId;

	private String referenceId;
	
	
	private Integer origNotesId;
	
	
	private EvtReferenceType referenceType;

	
	private String notes;
	
	private String nyHxId;

	

	private Integer status;
	
	private Date createdDate;
	
	private String createdBy;

	private String updatedBy;

	private Date updatedDate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public NotesTypes getNotesTypes() {
		return notesTypes;
	}


	public void setNotesTypes(NotesTypes notesTypes) {
		this.notesTypes = notesTypes;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getAppealId() {
		return appealId;
	}


	public void setAppealId(String appealId) {
		this.appealId = appealId;
	}


	public String getReferenceId() {
		return referenceId;
	}


	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}


	public Integer getOrigNotesId() {
		return origNotesId;
	}


	public void setOrigNotesId(Integer origNotesId) {
		this.origNotesId = origNotesId;
	}


	public EvtReferenceType getReferenceType() {
		return referenceType;
	}


	public void setReferenceType(EvtReferenceType referenceType) {
		this.referenceType = referenceType;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	

	
	public String getNyHxId() {
		return nyHxId;
	}


	public void setNyHxId(String nyHxId) {
		this.nyHxId = nyHxId;
	}
}
