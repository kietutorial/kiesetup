package com.hcentive.jobs.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_audit")
public class JobAudit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "job_instance_id")
	private Integer jobInstance;

	@Column(name = "user_profile_id")
	private Long userProfileID;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "event_id")
	private Long eventID;

	@Column(name = "execution_count")
	private Integer executionCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getJobInstance() {
		return jobInstance;
	}

	public void setJobInstance(Integer jobInstance) {
		this.jobInstance = jobInstance;
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
}
