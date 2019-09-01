package com.hcentive.shop.activity.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.hcentive.utils.orm.model.Persistent;


@Entity
@Table(name="ACTIVITY_TXN")
@SqlResultSetMappings (
		value = {
			@SqlResultSetMapping(name="effectiveDates",
				columns = {
					@ColumnResult(name = "employer_eligibility_id"),
					@ColumnResult(name = "effective_date")
				})
			}
		)
@NamedNativeQueries(value = {
		@NamedNativeQuery(
			name = "activityTransaction.findEffectiveDatesForEmployer",
			query = "select distinct ee.id as employer_eligibility_id, TO_CHAR(es.effective_date,'MM/dd/yyyy') as effective_date from employer_eligibility ee, employer_enrollment_setup es where ee.coverage_setup_id = es.id and ee.employer_id=:employerId",
			resultSetMapping = "effectiveDates"),
		@NamedNativeQuery(
			name = "activityTransaction.findEffectiveDatesForEmployee",
			query = "select employer_eligibility_id, to_char(effective_date,'MM/dd/yyyy') as effective_date from employer_enrollment_setup where id in "
					+ "( select enrollment_setup_id from employee_enrl_setup_status where employee_id in (select distinct upem1.employee_id from user_profile_employee_mpng upem1, "
					+ "user_profile_employee_mpng upem2 where upem1.user_profile_id = upem2.user_profile_id and upem2.employee_id = :employeeId))",
					 resultSetMapping = "effectiveDates"),
		@NamedNativeQuery(name = "activityTransaction.findOldActivityForEmployee", query = "SELECT ACT FROM ACTIVITY_TXN ACT WHERE ACTD.ACTIVITY_TXN_ID=ACT.ID"
				+ "AND ACT.EMPLOYEE_ID=:employeeId"
				+ "AND ACT.ACTIVITY_MASTER_ID=:activityMasterId"
				+ "AND ACTD.FIELD_NAME_TXT='ACTION_DATE' AND ACTD.VISIBILITY_STATUS_IND='1'"
				+ "ORDER BY ACT.CREATED_DATE DESC FETCH FIRST 1 ROWS ONLY WITH UR", resultClass = ActivityTransaction.class) })
@NamedQueries(value = {
		//Fetch by EmployerId
		@NamedQuery(name = "activityTransaction.findByEmployerId", query = "select at from ActivityTransaction at where at.employerId = :employerId and at.employeeId is null "
			+ "and at.visibilityStatus = '1' and at.activityMaster.visibilityStatus = '1' ORDER BY at.id, at.activityDate"),
		//Fetch by EligibilityId
		@NamedQuery(name = "activityTransaction.findByEmployerEligibilityId", query = "select at from ActivityTransaction at where at.employerEligibilityId = :employerEligibilityId and at.employeeId is null "
				+ "and at.visibilityStatus = '1' and at.activityMaster.visibilityStatus = '1' ORDER BY at.id"),
		//Fetch by Employee Id
		@NamedQuery(name = "activityTransaction.findByEmployeeId", query = "select at from ActivityTransaction at where at.employeeId = :employeeId and at.visibilityStatus = '1' and at.activityMaster.visibilityStatus = '1' ORDER BY at.id"),
		//Fetch All activities by Employee Id
		@NamedQuery(name = "activityTransaction.findAllByEmployeeId", query = "select at from ActivityTransaction at where at.employeeId in "
				+ "( select distinct upem1.employeeId from UserProfileEmployerEmployeeMapping upem1, UserProfileEmployerEmployeeMapping upem2 where upem1.userProfileId = upem2.userProfileId and upem2.employeeId = :employeeId) "
				+ "and at.visibilityStatus = '1' and at.activityMaster.visibilityStatus = '1' ORDER BY at.id"),
		@NamedQuery(name = "employee.findAccountByEmployeeId", query = "select u.accountId from UserProfileEmployerEmployeeMapping upem, UserProfile u where u.id = upem.userProfileId and upem.employeeId=:employeeId"),
		//Fetch by BrokerId
		@NamedQuery(name = "activityTransaction.findByBrokerId", query = "select at from ActivityTransaction at where at.brokerId = :brokerId and at.visibilityStatus = '1' and at.activityMaster.visibilityStatus = '1' ORDER BY at.id")
})

public class ActivityTransaction extends Persistent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name ="ACTIVITY_MASTER_ID")
	private Long activityMasterId;
	
	@Column(name ="USER_TYPE_TXT")
	private String userType;
	
	@Column(name ="USER_ACCOUNT_ID")
	private String userAccountId;
	
	@Column(name ="EMPLOYER_ID")
	private Long employerId;
	
	@Column(name ="EMPLOYER_ELIGIBILITY_ID")
	private Long employerEligibilityId;
	
	@Column(name ="EMPLOYEE_ID")
	private Long employeeId;
	
	@Column(name ="ENROLLMENT_ID")
	private Long enrollmentId;
	
	@Column(name ="ACTIVITY_SRC_TXT")
	@Enumerated(EnumType.STRING)
	private ActivitySourceEnum activitySource;
	
	@Column(name ="VISIBILITY_STATUS_IND")
	private Boolean visibilityStatus;
	
		
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACTIVITY_MASTER_ID", insertable = false, updatable = false)
	private ActivityMaster activityMaster;
	
	@OneToMany(mappedBy = "activityTransaction", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ActivityTransactionDetail> activityTransactionDetails = new HashSet<ActivityTransactionDetail>();

	@Column(name ="ACTIVITY_DATE")
	private Date activityDate;
	
	@Column(name ="BROKER_ID")
	private Long brokerId;

	@Column(name ="PLAN_EFFECTIVE_DATE")
	private Date planEffectiveDate;
	
	
	public Date getPlanEffectiveDate() {
		return planEffectiveDate;
	}


	public void setPlanEffectiveDate(Date planEffectiveDate) {
		this.planEffectiveDate = planEffectiveDate;
	}


	public Long getBrokerId() {
		return brokerId;
	}


	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getActivityMasterId() {
		return activityMasterId;
	}


	public void setActivityMasterId(Long activityMasterId) {
		this.activityMasterId = activityMasterId;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getUserAccountId() {
		return userAccountId;
	}


	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}


	public Long getEmployerId() {
		return employerId;
	}


	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}


	public Long getEmployerEligibilityId() {
		return employerEligibilityId;
	}


	public void setEmployerEligibilityId(Long employerEligibilityId) {
		this.employerEligibilityId = employerEligibilityId;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public Long getEnrollmentId() {
		return enrollmentId;
	}


	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}


	public ActivitySourceEnum getActivitySource() {
		return activitySource;
	}


	public void setActivitySource(ActivitySourceEnum activitySource) {
		this.activitySource = activitySource;
	}


	public Boolean getVisibilityStatus() {
		return visibilityStatus;
	}


	public void setVisibilityStatus(Boolean visibilityStatus) {
		this.visibilityStatus = visibilityStatus;
	}


	public ActivityMaster getActivityMaster() {
		return activityMaster;
	}


	public void setActivityMaster(ActivityMaster activityMaster) {
		this.activityMaster = activityMaster;
	}


	public Set<ActivityTransactionDetail> getActivityTransactionDetails() {
		return activityTransactionDetails;
	}


	public void setActivityTransactionDetails(
			Set<ActivityTransactionDetail> activityTransactionDetails) {
		this.activityTransactionDetails.clear();
		this.activityTransactionDetails.addAll(activityTransactionDetails);
	}


	public Date getActivityDate() {
		return activityDate;
	}


	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

}
