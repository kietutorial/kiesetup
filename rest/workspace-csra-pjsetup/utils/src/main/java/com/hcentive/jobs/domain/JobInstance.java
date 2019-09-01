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
@Table(name = "job_instance")
@NamedQueries(value = { @NamedQuery(name = "jobInstance.FindByJobConfigId", query = "SELECT j from JobInstance j WHERE jobIdConfig=:jobIdConfig") })
public class JobInstance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "job_config_id")
	private Long jobIdConfig;

	@Column(name = "last_excution_time")
	private Date lastExecutionTime;

	@Column(name = "current_count")
	private Integer currentCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobIdConfig() {
		return jobIdConfig;
	}

	public void setJobIdConfig(Long jobIdConfig) {
		this.jobIdConfig = jobIdConfig;
	}

	public Date getLastExecutionTime() {
		return lastExecutionTime;
	}

	public void setLastExecutionTime(Date lastExecutionTime) {
		this.lastExecutionTime = lastExecutionTime;
	}

	public Integer getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
}
