package com.hcentive.shop.activity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITY_TXN_DTL")
public class ActivityTransactionDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ACTIVITY_TXN_ID")
	private Long activityTransactionId;
	
	@Column(name ="FIELD_NAME_TXT")
	private String fieldName;
	
	@Column(name ="OLD_VALUE_TXT")
	private String oldValue;
	
	@Column(name ="NEW_VALUE_TXT")
	private String newValue;
	
	@Column(name ="VISIBILITY_STATUS_IND")
	private Boolean visibilityStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ACTIVITY_TXN_ID", insertable = false, updatable = false)
	private ActivityTransaction activityTransaction;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public Boolean getVisibilityStatus() {
		return visibilityStatus;
	}

	public void setVisibilityStatus(Boolean visibilityStatus) {
		this.visibilityStatus = visibilityStatus;
	}

	public ActivityTransaction getActivityTransaction() {
		return activityTransaction;
	}

	public void setActivityTransaction(ActivityTransaction activityTransaction) {
		this.activityTransaction = activityTransaction;
	}

	public Long getActivityTransactionId() {
		return activityTransactionId;
	}

	public void setActivityTransactionId(Long activityTransactionId) {
		this.activityTransactionId = activityTransactionId;
	}

}
