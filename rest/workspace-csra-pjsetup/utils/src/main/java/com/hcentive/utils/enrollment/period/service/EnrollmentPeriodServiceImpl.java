package com.hcentive.utils.enrollment.period.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcentive.eligibility.individual.domain.EnrollmentPeriod;
import com.hcentive.utils.orm.dao.GenericDAO;

public class EnrollmentPeriodServiceImpl implements EnrollmentPeriodService {

	private static final Logger log = LoggerFactory.getLogger(EnrollmentPeriodServiceImpl.class);

	@SuppressWarnings("rawtypes")
	private GenericDAO genericDAO;

	@Override
	public boolean isInOEP(String type) {
		EnrollmentPeriod enrollmentPeriod = null;
		try {
			enrollmentPeriod = getOpenEnrollmentPeriod(type, "0");
		} catch (Exception e) {
			log.error("Error Occured in fetching Active OEP",e);
		}
		if (enrollmentPeriod != null) {
			return true;
		}

		return false;
	}

	@Override
	public EnrollmentPeriod getActiveOEP(String type) throws Exception {
		@SuppressWarnings("unchecked")
		List<EnrollmentPeriod> enrollmentPeriods = genericDAO.findByNamedQuery("enrollmentPeriod.getActiveEnrollmentPeriod",
				new String[] { "type" }, type);
		if (!enrollmentPeriods.isEmpty()) {
			return enrollmentPeriods.get(enrollmentPeriods.size() - 1);
		}
		return null;
	}

	@Override
	public EnrollmentPeriod getOpenEnrollmentPeriod(String type, String status) throws Exception {
		@SuppressWarnings("unchecked")
		List<EnrollmentPeriod> enrollmentPeriod = genericDAO.findByNamedQuery("enrollmentPeriod.getOpenEnrollmentPeriod",
				new String[] { "type", "status" }, type, status);
		if (!enrollmentPeriod.isEmpty()) {
			return enrollmentPeriod.get(enrollmentPeriod.size() - 1);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EnrollmentPeriod> getEnrollmentPeriodList(String type) {
		return genericDAO.findByNamedQuery("enrollmentPeriod.getLatestXEnrollmentPeriod", new String[] { "type" }, type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EnrollmentPeriod> getLatestXEnrollmentPeriod(String type, int n) {
		// select * from enrollment_period order by planyear desc limit 3;
		return genericDAO.findPaginatedByNamedQuery("enrollmentPeriod.getLatestXEnrollmentPeriod", 0, n, new String[] { "type" },
				type);
	}

	@Override
	@SuppressWarnings("unchecked")
	public EnrollmentPeriod getEnrollemntPeriodforOepId(Long opeId) {
		return (EnrollmentPeriod) genericDAO.get(EnrollmentPeriod.class, opeId);
	}

	@Override
	public EnrollmentPeriod getNextActiveEnrollmentPeriod(String type) {
		return (EnrollmentPeriod) genericDAO.findObjectByNamedQuery("enrollmentPeriod.getNextActiveEnrollmentPeriod",
				new String[] { "type" }, type);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getPlanYearsForEnrollment(String type) {

		List<String> planYears = new ArrayList<String>();
		List<EnrollmentPeriod> enrollmentPeriods = genericDAO.findByNamedQuery("enrollmentPeriod.getActiveEnrollmentPeriod",
				new String[] { "type" }, type);
		for (EnrollmentPeriod enrollmentPeriod : enrollmentPeriods) {
			planYears.add(enrollmentPeriod.getPlanYear());
		}
		return planYears;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EnrollmentPeriod> getCurrentAndNextYearErollmentPeriodFor(String isFor) {

		List<EnrollmentPeriod> enrollmentPeriods = genericDAO.findByNamedQuery("enrollmentPeriod.getAllEnrollmentPeriodFor",
				new String[] { "type" }, isFor);
		List<EnrollmentPeriod> result = new ArrayList<EnrollmentPeriod>();
		GregorianCalendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);

		if (enrollmentPeriods != null && !enrollmentPeriods.isEmpty()) {
			for (EnrollmentPeriod enrollmentPeriod : enrollmentPeriods) {
				int enrollmentYear = Integer.parseInt(enrollmentPeriod.getPlanYear());
				if (enrollmentYear == year) {
					// enrollment period for present year
					result.add(enrollmentPeriod);
				} else if (enrollmentYear == year + 1) {
					// enrollment period for next year
					result.add(enrollmentPeriod);
				}
			}
			Collections.sort(result);
			return result;
		}
		return enrollmentPeriods;
	}

	@Override
	public Date getEffectiveDate() {

		Timestamp st = (Timestamp) genericDAO.findObjectByNamedQuery("enrollmentPeriod.getEffectiveDate", null);
		// java.util.Date date = new java.util.Date(st.getTime());
		java.sql.Date date = new java.sql.Date(st.getTime());

		return date;

	}

	@SuppressWarnings("rawtypes")
	public GenericDAO getGenericDAO() {
		return genericDAO;
	}

	@SuppressWarnings("rawtypes")
	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

}
