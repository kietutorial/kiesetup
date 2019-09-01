package com.hcentive.shop.activity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ACTIVITY_MASTER")
public class ActivityMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name ="ACTIVITY_GROUP_NAME")
	@Enumerated(EnumType.STRING)
	private ActivityGroupNameEnum activityGroupName;
	
	@Column(name ="ACTIVITY_CODE_TXT")
	private String activityCode;
	
	@Column(name ="ACTIVITY_DESC")
	private String activityDescription;
	
	@Column(name ="ACTIVITY_MSG_KEY")
	private String activityMsgKey;
	
	@Column(name="VISIBILITY_STATUS_IND")
	private Boolean visibilityStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActivityGroupNameEnum getActivityGroupName() {
		return activityGroupName;
	}

	public void setActivityGroupName(ActivityGroupNameEnum activityGroupName) {
		this.activityGroupName = activityGroupName;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getActivityMsgKey() {
		return activityMsgKey;
	}

	public void setActivityMsgKey(String activityMsgKey) {
		this.activityMsgKey = activityMsgKey;
	}

	public Boolean getVisibilityStatus() {
		return visibilityStatus;
	}

	public void setVisibilityStatus(Boolean visibilityStatus) {
		this.visibilityStatus = visibilityStatus;
	}
	
		

}
