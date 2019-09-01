package com.hcentive.shop.dto;

import com.hcentive.utils.ext.HXUtility;

public class EmployeeEnrollmentDTO {

	public EmployeeEnrollmentDTO(Object[] resultArray) {
		this.setEmployeeId(HXUtility.processLong(resultArray[0]));
		this.setFirstName(HXUtility.processStr(resultArray[1]));
		this.setLastName(HXUtility.processStr(resultArray[2]));
		this.setEmployeeName( getFirstName() + " " + getLastName() );
		this.setEmployeeCode(HXUtility.processStr(resultArray[3]));
		this.setEmployeeStatus(HXUtility.processStr(resultArray[4]));
		this.setEnrollmentStatus(HXUtility.processStr(resultArray[5]));
		this.setEnrollmentStartDate(HXUtility.processStr(resultArray[6]));
		this.setEnrollmentEndDate(HXUtility.processStr(resultArray[7]));
		this.setEffectiveDate(HXUtility.processStr(resultArray[8]));
		this.setEndEffectiveDate(HXUtility.processStr(resultArray[9]));
		this.setDisabled(HXUtility.processBoolean(resultArray[10]));
	}
	
	public EmployeeEnrollmentDTO(Object[] resultArray, boolean isClassMove) {
		this.setEmployeeId(HXUtility.processLong(resultArray[0]));
		this.setFirstName(HXUtility.processStr(resultArray[1]));
		this.setLastName(HXUtility.processStr(resultArray[2]));
		this.setEmployeeName( getFirstName() + " " + getLastName() );
		this.setEmployeeCode(HXUtility.processStr(resultArray[3]));
		this.setEmployeeStatus(HXUtility.processStr(resultArray[4]));
		this.setEnrollmentStatus(HXUtility.processStr(resultArray[5]));
		this.setDisabled(HXUtility.processBoolean(resultArray[6]));
	}
	private long employeeId;
	private String firstName;
	private String lastName;
	private String employeeName;
	private String employeeCode;
	private String employeeStatus;
	private String enrollmentStartDate;
	private String enrollmentEndDate;
	private String effectiveDate;
	private String endEffectiveDate;
	private String enrollmentStatus;
	private long classId;
	private boolean disabled;
	
	public long getEmployeeId() {
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public String getEnrollmentStartDate() {
		return enrollmentStartDate;
	}
	public String getEnrollmentEndDate() {
		return enrollmentEndDate;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public String getEndEffectiveDate() {
		return endEffectiveDate;
	}
	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}
	
	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public long getClassId() {
		return classId;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public void setEnrollmentStartDate(String enrollmentStartDate) {
		this.enrollmentStartDate = enrollmentStartDate;
	}
	public void setEnrollmentEndDate(String enrollmentEndDate) {
		this.enrollmentEndDate = enrollmentEndDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public void setEndEffectiveDate(String endEffectiveDate) {
		this.endEffectiveDate = endEffectiveDate;
	}
	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}
	
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}
