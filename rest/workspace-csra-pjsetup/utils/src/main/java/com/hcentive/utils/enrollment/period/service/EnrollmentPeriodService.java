package com.hcentive.utils.enrollment.period.service;

import java.sql.Date;
import java.util.List;

import com.hcentive.eligibility.individual.domain.EnrollmentPeriod;

public interface EnrollmentPeriodService {

	boolean isInOEP(String type);

	EnrollmentPeriod getActiveOEP(String type) throws Exception;

	EnrollmentPeriod getOpenEnrollmentPeriod(String type, String status) throws Exception;

	public List<EnrollmentPeriod> getEnrollmentPeriodList(String type);

	public List<EnrollmentPeriod> getLatestXEnrollmentPeriod(String type, int n);

	public EnrollmentPeriod getEnrollemntPeriodforOepId(Long opeId);

	public EnrollmentPeriod getNextActiveEnrollmentPeriod(String type);

	public List<String> getPlanYearsForEnrollment(String type);

	public List<EnrollmentPeriod> getCurrentAndNextYearErollmentPeriodFor(String isFor);

	public Date getEffectiveDate();

}
