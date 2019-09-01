package com.hcentive.eligibility.individual.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class VerificationData.
 */
@Entity
@Table(name = "document_type_data")
public class DocumentTypeData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "document_type")
	private String documentType;
	
	@Column(name = "document_category")
	private String documentCategory;


	@Column(name = "DOCUMENT_VALIDITY_PERIOD")
	private String documentValidityPeriod;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	public String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}

	public String getDocumentValidityPeriod() {
		return documentValidityPeriod;
	}

	public void setDocumentValidityPeriod(String documentValidityPeriod) {
		this.documentValidityPeriod = documentValidityPeriod;
	}

}
