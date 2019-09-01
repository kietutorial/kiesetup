/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.eligibility.individual.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.hcentive.utils.orm.model.Persistent;

@Audited
@Entity
@Table(name = "enrollment_period_config")
@NamedQueries(value = {
		@NamedQuery(name = "enrollmentPeriod.getOpenEnrollmentPeriod", query = "SELECT e from  EnrollmentPeriod e WHERE type=:type and status=:status"),
		@NamedQuery(name = "enrollmentPeriod.getActiveEnrollmentPeriod", query = "SELECT e from  EnrollmentPeriod e WHERE type=:type and CURRENT_DATE >= startDate and endEffectiveDate >= CURRENT_DATE"),
		@NamedQuery(name = "enrollmentPeriod.checkEnrollmentPeriod", query = "SELECT e from  EnrollmentPeriod e WHERE type=:type and CURRENT_DATE >= startDate and CURRENT_DATE <= endDate "),
		@NamedQuery(name = "enrollmentPeriod.getLatestXEnrollmentPeriod", query = "SELECT e from  EnrollmentPeriod e WHERE type=:type order by planYear desc "),
		@NamedQuery(name = "enrollmentPeriod.getOEPID", query = "SELECT e.id from  EnrollmentPeriod e WHERE planYear=:planYear"),
		@NamedQuery(name = "enrollmentPeriod.getOEPIDByPlanYearAndType", query = "SELECT e.id from  EnrollmentPeriod e WHERE planYear=:planYear and type=:type"),
		@NamedQuery(name = "enrollmentPeriod.getActiveLSCEnrollmentPeriod", query = "select e from EnrollmentPeriod e where CURRENT_DATE > endDate and CURRENT_DATE <= endEffectiveDate"),
		@NamedQuery(name = "enrollmentPeriod.getAllEnrollmentPeriod", query = "select e from EnrollmentPeriod e"),
		@NamedQuery(name = "enrollmentPeriod.getAllEnrollmentPeriodFor", query = "select e from EnrollmentPeriod e where type=:type"),
		@NamedQuery(name = "enrollmentPeriod.getNextActiveEnrollmentPeriod", query = "select e from EnrollmentPeriod e WHERE startDate = (select min(startDate) FROM EnrollmentPeriod WHERE startDate >= CURRENT_DATE AND type=:type) AND type=:type"),
		@NamedQuery(name = "enrollmentPeriod.getEffectiveDate", query = "select effectiveDate from EnrollmentPeriod e where id=(select max(id) from EnrollmentPeriod)") })
public class EnrollmentPeriod extends Persistent implements Comparable<EnrollmentPeriod> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "effective_date")
	private Date effectiveDate;

	@Column(name = "end_effective_date")
	private Date endEffectiveDate;

	@Column(name = "type")
	private String type;

	@Column(name = "status")
	private String status;

	@Column(name = "plan_year")
	private String planYear;

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEndEffectiveDate() {
		return endEffectiveDate;
	}

	public void setEndEffectiveDate(Date endEffectiveDate) {
		this.endEffectiveDate = endEffectiveDate;
	}

	public String getDescription() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		return dateFormat.format(endEffectiveDate);
	}

	@Override
	public int compareTo(EnrollmentPeriod enrollmentPeriod) {

		if (enrollmentPeriod == null) {
			return 1;
		}
		if (this.planYear == null && enrollmentPeriod.getPlanYear() == null) {
			return 0;
		}
		if (this.planYear == null && enrollmentPeriod.getPlanYear() != null) {
			return -1;
		}
		if (this.planYear != null && enrollmentPeriod.getPlanYear() == null) {
			return 1;
		}
		int year1 = Integer.parseInt(this.planYear);
		int year2 = Integer.parseInt(enrollmentPeriod.getPlanYear());
		if (year1 < year2) {
			return -1;
		} else if (year1 > year2) {
			return 1;
		} else {
			return 0;
		}
	}
}
