package com.hcentive.jobs.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "notification_status")
@NamedQueries(value = {
		@NamedQuery(name = "notificationStatus.FindByJobConfigIdAndUserProfile", query = "SELECT notificationStat from NotificationStatus notificationStat "
				+ "WHERE jobIdConfig=:jobIdConfig and userProfileID=:userProfileID and eventType=:eventType and eventID=:eventID"),
		@NamedQuery(name = "notificationStatus.FindByJobConfigIdAndEvent", query = "SELECT notificationStat from NotificationStatus notificationStat "
				+ "WHERE jobIdConfig=:jobIdConfig and  eventType=:eventType and eventID=:eventID") })
//
public class NotificationStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4317849157379542200L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "job_config_id")
	private Long jobIdConfig;

	@Column(name = "user_profile_id")
	private Long userProfileID;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "event_id")
	private Long eventID;

	@Column(name = "last_execution_time", insertable = false, updatable = false)
	private Date lastExecutionTime;

	@Column(name = "execution_count")
	private Integer executionCount;

	public Long getJobIdConfig() {
		return jobIdConfig;
	}

	public void setJobIdConfig(Long jobIdConfig) {
		this.jobIdConfig = jobIdConfig;
	}

	public Long getUserProfileID() {
		return userProfileID;
	}

	public void setUserProfileID(Long userProfileID) {
		this.userProfileID = userProfileID;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public Integer getExecutionCount() {
		return executionCount;
	}

	public void setExecutionCount(Integer executionCount) {
		this.executionCount = executionCount;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the lastExecutionTime
	 */
	public Date getLastExecutionTime() {
		return lastExecutionTime;
	}

	/**
	 * @param lastExecutionTime
	 *            the lastExecutionTime to set
	 */
	public void setLastExecutionTime(Date lastExecutionTime) {
		this.lastExecutionTime = lastExecutionTime;
	}

}
