package com.hcentive.jobs.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "job_config")
@NamedQueries(value = { @NamedQuery(name = "jobConfiguration.FindByJobName", query = "SELECT j from JobConfiguration j WHERE jobName=:jobName") })
public class JobConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum JobType {
		REMINDER, ACTION
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "job_name")
	private String jobName;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "maximum_count")
	private Integer maximumCount;

	@Column(name = "job_type")
	@Enumerated(EnumType.ORDINAL)
	private JobType jobType;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jobConfiguration", orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<JobConfigData> jobConfigList;

	public Set<JobConfigData> getJobConfigList() {
		return jobConfigList;
	}

	public void setJobConfigList(Set<JobConfigData> jobConfigList) {
		this.jobConfigList = jobConfigList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getMaximumCount() {
		return maximumCount;
	}

	public void setMaximumCount(Integer maximumCount) {
		this.maximumCount = maximumCount;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
}
