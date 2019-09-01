package com.hcentive.shop.event.domain;

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
@Table(name="EMPLOYER_EVENT_HIST")
public class EmployerEventHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "employer_id")
	private Long employerId;
	
	@Column(name = "employer_event_id")
	private Long employerEventId;
	
	@Column(name = "current_value")
	private String currentValue;
	
	@Column(name = "new_value")
	private String newValue;
	
	@Column(name = "action_status")
	@Enumerated(EnumType.STRING)
	private ActionStatus actionStatus;

	public static enum ActionStatus {
		CREATED,
		UPDATED,
		DELETED
	}

	
	public Long getId() {
		return id;
	}

	public Long getEmployerId() {
		return employerId;
	}

	public Long getEmployerEventId() {
		return employerEventId;
	}

	public String getCurrentValue() {
		return currentValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public ActionStatus getActionStatus() {
		return actionStatus;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public void setEmployerEventId(Long employerEventId) {
		this.employerEventId = employerEventId;
	}

	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public void setActionStatus(ActionStatus actionStatus) {
		this.actionStatus = actionStatus;
	}
}
