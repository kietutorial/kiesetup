package com.hcentive.shop.activity.utils;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings({ "serial", "rawtypes" })
public class ActivityLog implements Serializable, Comparable{

	private long   id;
	private String userAccountId;
	private Long employerId;
	private Long employerEligibilityId;
	private Long employeeId;
	private Long enrollmentId;
	private String activityCode;
	private String activityDescription;
	private String activityDetail;
	private String activityBy;
	private Date   activityDate;
	private String planEffectiveDate; //Used to differentiate the plan year
	private String refNo;
	private Long brokerId;
	
	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	public long getId() {
		return id;
	}

	public String getUserAccountId() {
		return userAccountId;
	}

	public Long getEmployerId() {
		return employerId;
	}

	public Long getEmployerEligibilityId() {
		return employerEligibilityId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public String getActivityDetail() {
		return activityDetail;
	}

	public String getActivityBy() {
		return activityBy;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public void setEmployerEligibilityId(Long employerEligibilityId) {
		this.employerEligibilityId = employerEligibilityId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public void setActivityDetail(String activityDetail) {
		this.activityDetail = activityDetail;
	}

	public void setActivityBy(String activityBy) {
		this.activityBy = activityBy;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getPlanEffectiveDate() {
		return planEffectiveDate;
	}

	public void setPlanEffectiveDate(String planEffectiveDate) {
		this.planEffectiveDate = planEffectiveDate;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	@Override
	public int compareTo(Object activityObj) {
		return this.activityDate.compareTo(((ActivityLog)activityObj).activityDate);
	}

}
