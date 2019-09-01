package com.hcentive.utils.orm.model;

import java.util.Date;

import javax.persistence.Transient;

public abstract class AbstractPersistent {

	@Transient
	private Boolean overrideCreatedBy = Boolean.FALSE;

	@Transient
	private Boolean overrideCreatedDate = Boolean.FALSE;

	@Transient
	private Boolean overrideUpdatedBy = Boolean.FALSE;

	@Transient
	private Boolean overrideUpdatedDate = Boolean.FALSE;

	public Boolean overrideCreatedBy() {
		return overrideCreatedBy;
	}

	public void setOverrideCreatedBy(Boolean overrideCreatedBy) {
		this.overrideCreatedBy = overrideCreatedBy;
	}

	public Boolean overrideCreatedDate() {
		return overrideCreatedDate;
	}

	public void setOverrideCreatedDate(Boolean overrideCreatedDate) {
		this.overrideCreatedDate = overrideCreatedDate;
	}

	public Boolean overrideUpdatedBy() {
		return overrideUpdatedBy;
	}

	public void setOverrideUpdatedBy(Boolean overrideUpdatedBy) {
		this.overrideUpdatedBy = overrideUpdatedBy;
	}

	public Boolean overrideUpdatedDate() {
		return overrideUpdatedDate;
	}

	public void setOverrideUpdatedDate(Boolean overrideUpdatedDate) {
		this.overrideUpdatedDate = overrideUpdatedDate;
	}

	public abstract Date getCreatedDate();

	public abstract Date getUpdatedDate();

	public abstract void setCreatedDate(Date createdDate);

	public abstract void setUpdatedDate(Date updatedDate);

	public abstract String getCreatedBy();
 
	public abstract void setCreatedBy(String createdBy);

	public abstract String getUpdatedBy();

	public abstract void setUpdatedBy(String updatedBy);
	
}