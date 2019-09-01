package com.hcentive.eligibility.individual.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The Class VerificationTypeData.
 */
@Entity
@Table(name = "verification_type_data")
@NamedQueries(value = {
		@NamedQuery(name = "VerificationTypeData.getVerificationsTypes", query = "SELECT e from  VerificationTypeData e WHERE verificationType=:verificationType"),
		@NamedQuery(name = "VerificationTypeData.getVerificationsTypeById", query = "SELECT e from  VerificationTypeData e WHERE id=:verificationTypeId"),
		@NamedQuery(name = "VerificationTypeData.getAll", query = "SELECT e from  VerificationTypeData e")})
public class VerificationTypeData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "verification_type")
	private String verificationType;

	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.TRUE)
	@JoinTable(name = "verification_document_type_mpng", joinColumns = { @JoinColumn(name = "verification_type_data_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "document_type_data_id", referencedColumnName = "id") })
	private List<DocumentTypeData> documenttypedatas = new ArrayList<DocumentTypeData>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(String verificationType) {
		this.verificationType = verificationType;
	}

	/**
	 * @return the DocumentTypeDatas
	 */
	public List<DocumentTypeData> getDocumenttypedatas() {
		return documenttypedatas;
	}

}
