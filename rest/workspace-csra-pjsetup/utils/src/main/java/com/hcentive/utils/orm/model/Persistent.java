/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.orm.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

import com.hcentive.shop.activity.domain.ActivityMasterEnum;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @author ashish.jaiswal
 * 
 */
@MappedSuperclass
@EntityListeners(SimpleAudit.class)
@Audited
public class Persistent extends AbstractPersistent implements Serializable {
	private static final long serialVersionUID = 8115919829211280558L;

	@Column(name = "created_by")
	private String createdBy;

	/**
	 * PLATFORM-7557(This is to make sure that default date is inserted by
	 * oracle/mysql)
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", insertable = false, updatable = false)
	private Date createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;

	@XStreamOmitField 
	@Transient
	private Map<String,Object> entityChangeMap;
	
	@Transient
	private ActivityMasterEnum activityMasterType;
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Map<String, Object> getEntityChangeMap() {
		return entityChangeMap;
	}

	public void setEntityChangeMap(Map<String, Object> entityChangeMap) {
		this.entityChangeMap = entityChangeMap;
	}

	public ActivityMasterEnum getActivityMasterType() {
		return activityMasterType;
	}

	public void setActivityMasterType(ActivityMasterEnum activityMasterType) {
		this.activityMasterType = activityMasterType;
	}

	// Method to create a complete copy of object.
	// Cloned objects clean up is required if new object needs to be persisted.
	public Object deepClone() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(this);

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}
	
}