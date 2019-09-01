package com.hcentive.jobs.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_config_data")
public class JobConfigData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Column(name = "job_config_id")
	// private Long jobIdConfig;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "job_config_id")
	private JobConfiguration jobConfiguration;

	@Column(name = "job_config_param_name")
	private String jobConfigParamName;

	@Column(name = "job_config_param_value")
	private String jobConfigParamValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JobConfiguration getJobConfiguration() {
		return jobConfiguration;
	}

	public void setJobConfiguration(JobConfiguration jobConfiguration) {
		this.jobConfiguration = jobConfiguration;
	}

	public String getJobConfigParamName() {
		return jobConfigParamName;
	}

	public void setJobConfigParamName(String jobConfigParamName) {
		this.jobConfigParamName = jobConfigParamName;
	}

	public String getJobConfigParamValue() {
		return jobConfigParamValue;
	}

	public void setJobConfigParamValue(String jobConfigParamValue) {
		this.jobConfigParamValue = jobConfigParamValue;
	}
}
