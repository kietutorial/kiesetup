/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.eligibility.individual.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The Class VerificationData.
 */
@Entity
@Table(name = "verification_data")
@NamedQueries(value = {
		@NamedQuery(name = "VerificationData.getDocCategoriesForVerificationType", query = "select distinct(documentCategory) from VerificationData where verificationType= :verificationType"),
		@NamedQuery(name = "VerificationData.getDocTypesForDocCategory", query = "select distinct(documentType) from VerificationData where documentCategory= :documentCategory"),
		@NamedQuery(name = "VerificationData.getAllDocCategories", query = "select distinct(documentCategory) from VerificationData") })
public class VerificationData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "verification_type")
	private String verificationType;

	@Column(name = "document_category")
	private String documentCategory;

	@Column(name = "document_type")
	private String documentType;

	/** The app type. */
	@Transient
	private String appType;

	/** The data field. */
	@Transient
	private String dataField;

	/** The member level validation. */
	@Transient
	private boolean memberLevelValidation;

	/**
	 * Gets the app type.
	 * 
	 * @return the app type
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * Sets the app type.
	 * 
	 * @param appType
	 *            the new app type
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * Gets the data field.
	 * 
	 * @return the data field
	 */
	public String getDataField() {
		return dataField;
	}

	/**
	 * Sets the data field.
	 * 
	 * @param dataField
	 *            the new data field
	 */
	public void setDataField(String dataField) {
		this.dataField = dataField;
	}

	/**
	 * Checks if is member level validation.
	 * 
	 * @return true, if is member level validation
	 */
	public boolean isMemberLevelValidation() {
		return memberLevelValidation;
	}

	/**
	 * Sets the member level validation.
	 * 
	 * @param memberLevelValidation
	 *            the new member level validation
	 */
	public void setMemberLevelValidation(boolean memberLevelValidation) {
		this.memberLevelValidation = memberLevelValidation;
	}

	public String getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(String verificationType) {
		this.verificationType = verificationType;
	}

	public String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
