/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.demographics.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Just note that if
 * 
 * <pre>
 * allowedCoverageStartDates == null
 * </pre>
 * 
 * all dates are allowed
 * 
 * @author Chetan
 */
public class DemographicRules {

	private List<String> counties = new ArrayList<String>();
	private String stateCode;
	// private AgeRules ars;
	private int[] allowedCoverageStartDates;
	private Integer maxCoveragestartDate;
	private String zip;
	private String carrierCode;
	private String city;
	private String state;
	private Boolean plansPresent;
	private Boolean appointmentPresent;
	private Integer maxDependents;
	private String currentDate;

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/*
	 * public AgeRules getArs() { return ars; }
	 * 
	 * public void setArs(AgeRules ars) { this.ars = ars; }
	 */

	public int[] getAllowedCoverageStartDates() {
		return allowedCoverageStartDates;
	}

	public void setAllowedCoverageStartDates(int[] allowedCoverageStartDates) {
		this.allowedCoverageStartDates = allowedCoverageStartDates;
	}

	public Integer getMaxCoveragestartDate() {
		return maxCoveragestartDate;
	}

	public void setMaxCoveragestartDate(Integer maxCoveragestartDate) {
		this.maxCoveragestartDate = maxCoveragestartDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DemographicRules [allowedCoverageStartDates=");
		builder.append(Arrays.toString(allowedCoverageStartDates));
		// builder.append(", ars=");
		// builder.append(ars);
		builder.append(", carrierCode=");
		builder.append(carrierCode);
		builder.append(", counties=");
		builder.append(counties);
		builder.append(", maxCoveragestartDate=");
		builder.append(maxCoveragestartDate);
		builder.append(", stateCode=");
		builder.append(stateCode);
		builder.append(", zip=");
		builder.append(zip);
		builder.append("]");
		return builder.toString();
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public List<String> getCounties() {
		return counties;
	}

	public void setCounties(List<String> counties) {
		this.counties = counties;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getPlansPresent() {
		return plansPresent;
	}

	public void setPlansPresent(Boolean plansPresent) {
		this.plansPresent = plansPresent;
	}

	public Boolean getAppointmentPresent() {
		return appointmentPresent;
	}

	public void setAppointmentPresent(Boolean appointmentPresent) {
		this.appointmentPresent = appointmentPresent;
	}

	public Integer getMaxDependents() {
		return maxDependents;
	}

	public void setMaxDependents(Integer maxDependents) {
		this.maxDependents = maxDependents;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
}
