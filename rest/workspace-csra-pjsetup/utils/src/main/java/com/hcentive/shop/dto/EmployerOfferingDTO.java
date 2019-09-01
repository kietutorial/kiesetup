package com.hcentive.shop.dto;

import java.util.Date;
import java.util.List;

import com.hcentive.utils.ext.HXUtility;

public class EmployerOfferingDTO {
	
	public EmployerOfferingDTO(Object[] resultArray) {
		this.setEmployerId(HXUtility.processLong(resultArray[0]));
		this.setEmployerEligibilityId(HXUtility.processLong(resultArray[1]));
		this.setEligibilityStatus(HXUtility.processStr(resultArray[2]));
		this.setEnrollmentSetupId(HXUtility.processLong(resultArray[3]));
		this.setEffectiveDate( HXUtility.processDate(resultArray[4]) );
		this.setEndEffectiveDate(  HXUtility.processDate(resultArray[5]) );
		this.setEnrollmentStartDate( HXUtility.processDate(resultArray[6]) );
		this.setEnrollmentEndDate(  HXUtility.processDate(resultArray[7]) );
		this.setRetroEndDate( HXUtility.processDate(resultArray[8]) );
		
		this.setClassId(HXUtility.processLong(resultArray[9]));
		this.setClassName(HXUtility.processStr(resultArray[10]));
		this.setOfferStatus(HXUtility.processStr(resultArray[11]));
		this.setNewHireWaitingPeriod(HXUtility.processStr(resultArray[12]));
		
		this.setTotalEmployees(HXUtility.processInteger(resultArray[13]));
		this.setEnrolledEmployees(HXUtility.processInteger(resultArray[14]));
		this.setNotOfferedEmployees(HXUtility.processInteger(resultArray[15]));
		this.setTotalQhpPlans(HXUtility.processInteger(resultArray[16]));
		this.setTotalDentalPlans(HXUtility.processInteger(resultArray[17]));
		this.setTotalPlans(HXUtility.processInteger(resultArray[18]));
		
		this.setMetals(HXUtility.processStr(resultArray[19]));
		this.setCoverageTier(HXUtility.processStr(resultArray[20]));
		this.setIncompleteOffer(HXUtility.processBoolean(resultArray[21]));
		this.setShowDentalOffer(HXUtility.processBoolean(resultArray[22]));
		this.setShowRenewalOEP(HXUtility.processBoolean(resultArray[23]));
		this.setShowRenewalAlert(HXUtility.processBoolean(resultArray[24]));
		this.setModifyEmployerOffer(HXUtility.processBoolean(resultArray[25]));
		this.setModifyOfferForRelocation(HXUtility.processBoolean(resultArray[26]));
		this.setShowMoveEmployees(HXUtility.processBoolean(resultArray[27]));
		this.setShowDeleteClass(HXUtility.processBoolean(resultArray[28]));
	}
	
	private long employerId;
	private long employerEligibilityId;
	private String eligibilityStatus;
	private long enrollmentSetupId;
	private Date effectiveDate;
	private Date endEffectiveDate;
	private Date enrollmentStartDate;
	private Date enrollmentEndDate;
	private Date retroEndDate;
	
	private long classId;
	private String className;
	private String offerStatus;
	private String newHireWaitingPeriod;
	
	private int totalEmployees;
	private int enrolledEmployees;
	private int notOfferedEmployees;
	private int totalPlans;
	private int totalQhpPlans;
	private int totalDentalPlans;
	private String metals;
	private String coverageTier;
	private boolean isIncompleteOffer;
	private boolean isModifyEmployerOffer;
	private boolean isModifyOfferForRelocation;
	//private boolean isNewHireOfferInProgress;
	
	private long toClassId;
	
	private boolean showAddClass;
	private boolean showDeleteClass;
	private boolean showEditOffer;
	private boolean showViewOffer;
	private boolean showRenewalOEP;
	
	private boolean showDentalOffer;
	private boolean showRenewalAlert;
	
	//private List<EmployeeEnrollmentVO> employeeEnrollments = null;
	private List<EmployerContributionDTO> qhpContributions = null;
	//private List<EmployerContributionDTO> dentalContributions = null;
	
	private boolean showMoveEmployees;
	
	public boolean isShowMoveEmployees() {
		return showMoveEmployees;
	}

	public void setShowMoveEmployees(boolean showMoveEmployees) {
		this.showMoveEmployees = showMoveEmployees;
	}

	public long getEmployerId() {
		return employerId;
	}

	public long getEmployerEligibilityId() {
		return employerEligibilityId;
	}

	public String getEligibilityStatus() {
		return eligibilityStatus;
	}

	public long getEnrollmentSetupId() {
		return enrollmentSetupId;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public Date getEndEffectiveDate() {
		return endEffectiveDate;
	}

	public long getClassId() {
		return classId;
	}

	public String getClassName() {
		return className;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public Date getEnrollmentStartDate() {
		return enrollmentStartDate;
	}

	public Date getEnrollmentEndDate() {
		return enrollmentEndDate;
	}

	public Date getRetroEndDate() {
		return retroEndDate;
	}

	public String getNewHireWaitingPeriod() {
		return newHireWaitingPeriod;
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public int getEnrolledEmployees() {
		return enrolledEmployees;
	}

	public int getNotOfferedEmployees() {
		return notOfferedEmployees;
	}

	public int getTotalPlans() {
		return totalPlans;
	}

	public int getTotalQhpPlans() {
		return totalQhpPlans;
	}

	public int getTotalDentalPlans() {
		return totalDentalPlans;
	}

	public String getMetals() {
		return metals;
	}

	public String getCoverageTier() {
		return coverageTier;
	}

	public boolean isIncompleteOffer() {
		return isIncompleteOffer;
	}

	public long getToClassId() {
		return toClassId;
	}

	public boolean isShowAddClass() {
		return showAddClass;
	}

	public boolean isShowDeleteClass() {
		return showDeleteClass;
	}

	public boolean isShowEditOffer() {
		return showEditOffer;
	}

	public boolean isShowViewOffer() {
		return showViewOffer;
	}

	public boolean isShowRenewalOEP() {
		return showRenewalOEP;
	}

	public boolean isShowDentalOffer() {
		return showDentalOffer;
	}

	public boolean isModifyOfferForRelocation() {
		return isModifyOfferForRelocation;
	}

	public boolean isModifyEmployerOffer() {
		return isModifyEmployerOffer;
	}

	public boolean isShowRenewalAlert() {
		return showRenewalAlert;
	}

	public void setEmployerId(long employerId) {
		this.employerId = employerId;
	}

	public void setEmployerEligibilityId(long employerEligibilityId) {
		this.employerEligibilityId = employerEligibilityId;
	}

	public void setEligibilityStatus(String eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}

	public void setEnrollmentSetupId(long enrollmentSetupId) {
		this.enrollmentSetupId = enrollmentSetupId;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public void setEndEffectiveDate(Date endEffectiveDate) {
		this.endEffectiveDate = endEffectiveDate;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public void setNewHireWaitingPeriod(String newHireWaitingPeriod) {
		this.newHireWaitingPeriod = newHireWaitingPeriod;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public void setEnrolledEmployees(int enrolledEmployees) {
		this.enrolledEmployees = enrolledEmployees;
	}

	public void setNotOfferedEmployees(int notOfferedEmployees) {
		this.notOfferedEmployees = notOfferedEmployees;
	}

	public void setTotalPlans(int totalPlans) {
		this.totalPlans = totalPlans;
	}

	public void setTotalQhpPlans(int totalQhpPlans) {
		this.totalQhpPlans = totalQhpPlans;
	}

	public void setTotalDentalPlans(int totalDentalPlans) {
		this.totalDentalPlans = totalDentalPlans;
	}

	public void setMetals(String metals) {
		this.metals = metals;
	}

	public void setIncompleteOffer(boolean isIncompleteOffer) {
		this.isIncompleteOffer = isIncompleteOffer;
	}

	public void setToClassId(long toClassId) {
		this.toClassId = toClassId;
	}

	public void setShowAddClass(boolean showAddClass) {
		this.showAddClass = showAddClass;
	}

	public void setShowDeleteClass(boolean showDeleteClass) {
		this.showDeleteClass = showDeleteClass;
	}

	public void setShowEditOffer(boolean showEditOffer) {
		this.showEditOffer = showEditOffer;
	}

	public void setShowViewOffer(boolean showViewOffer) {
		this.showViewOffer = showViewOffer;
	}

	public void setShowRenewalOEP(boolean showRenewalOEP) {
		this.showRenewalOEP = showRenewalOEP;
	}

	public void setShowDentalOffer(boolean showDentalOffer) {
		this.showDentalOffer = showDentalOffer;
	}

	public List<EmployerContributionDTO> getQhpContributions() {
		return qhpContributions;
	}

	public void setQhpContributions(List<EmployerContributionDTO> qhpContributions) {
		this.qhpContributions = qhpContributions;
	}

	public void setCoverageTier(String coverageTier) {
		this.coverageTier = coverageTier;
	}

	public void setModifyOfferForRelocation(boolean isModifyOfferForRelocation) {
		this.isModifyOfferForRelocation = isModifyOfferForRelocation;
	}

	public void setModifyEmployerOffer(boolean isModifyEmployerOffer) {
		this.isModifyEmployerOffer = isModifyEmployerOffer;
	}

	public void setShowRenewalAlert(boolean showRenewalAlert) {
		this.showRenewalAlert = showRenewalAlert;
	}

	public void setEnrollmentStartDate(Date enrollmentStartDate) {
		this.enrollmentStartDate = enrollmentStartDate;
	}

	public void setEnrollmentEndDate(Date enrollmentEndDate) {
		this.enrollmentEndDate = enrollmentEndDate;
	}

	public void setRetroEndDate(Date retroEndDate) {
		this.retroEndDate = retroEndDate;
	}

	
}
