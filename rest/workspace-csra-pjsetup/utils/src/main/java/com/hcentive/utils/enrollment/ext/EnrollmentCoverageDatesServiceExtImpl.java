package com.hcentive.utils.enrollment.ext;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hcentive.eligibility.individual.domain.EnrollmentPeriod;
import com.hcentive.utils.enrollment.period.service.EnrollmentPeriodService;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.ext.HXConstants;
import com.hcentive.utils.ext.HXLogMsgConstants;
import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.orm.dao.GenericDAO;

/**
 * Class EnrollmentCoverageDatesServiceExtImpl is been deprecated.
 * Application should be using {@link #DateDeterminationLogicServiceImpl}
 */

/**
 * Task # 12398 : Medicaid Dates (For FFS and MMC)
 * 
 */

@Deprecated
public class EnrollmentCoverageDatesServiceExtImpl implements EnrollmentCoverageDatesServiceExt {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(EnrollmentCoverageDatesServiceExt.class);

	@Value("${app.indv.coverage.cutoff.Month}")
	protected String coverageCutOffMonth;

	@Value("${app.indv.coverage.cutoff.DayOfMonth}")
	protected String coverageCutOffDayOfMonth;

	/** The generic dao. */
	@SuppressWarnings("rawtypes")
	private GenericDAO genericDAO;

	/** The enrollment period service. */
	@Autowired
	protected EnrollmentPeriodService enrollmentPeriodService;

	/**
	 * Gets the generic dao.
	 * 
	 * @return the generic dao
	 */
	@SuppressWarnings("rawtypes")
	public GenericDAO getGenericDAO() {
		return genericDAO;
	}

	/**
	 * Sets the generic dao.
	 * 
	 * @param genericDAO
	 *            the new generic dao
	 */
	@SuppressWarnings("rawtypes")
	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

	/**
	 * Gets the enrollment period plan year.
	 * 
	 * @return the enrollment period plan year
	 * @throws Exception
	 *             the exception
	 */
	private String getEnrollmentPeriodPlanYear() throws Exception {
		EnrollmentPeriod enrollmentPeriod = enrollmentPeriodService.getOpenEnrollmentPeriod(
				HXConstants.APPLICATION.INDIVIDUAL.toString(),
				String.valueOf(HXConstants.EnrollmentPeriodStatusEnum.ACTIVE.ordinal()));
		if (enrollmentPeriod != null) {
			return enrollmentPeriod.getPlanYear();
		}
		return null;
	}

	/**
	 * Gets the enrollment period plan year.
	 * 
	 * @return the enrollment period plan year
	 * @throws Exception
	 *             the exception
	 */
	public Date getEnrollmentPeriodPlanYearFirstDate() throws Exception {
		EnrollmentPeriod enrollmentPeriod = enrollmentPeriodService.getOpenEnrollmentPeriod(
				HXConstants.APPLICATION.INDIVIDUAL.toString(),
				String.valueOf(HXConstants.EnrollmentPeriodStatusEnum.ACTIVE.ordinal()));
		if (enrollmentPeriod != null) {
			return HXUtility.convertStringToDate("01/01/" + enrollmentPeriod.getPlanYear());
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.individual.hix.enrollment.util.ext.
	 * EnrollmentCoverageDatesServiceExt
	 * #setUserCoverageStartDate(java.lang.Long)
	 */
	@Override
	public Date getDefaultUserCoverageStartDate() throws Exception {
		String planYear = getEnrollmentPeriodPlanYear();
		Date userCoverageStartDate = null;

		if (HXUtility.isEmpty(planYear)) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EE_ENROLLMENT_PERIOD_YEAR_BLANK));
		}

		int year = Integer.parseInt(planYear);

		String cutOffDate = coverageCutOffMonth + "/" + coverageCutOffDayOfMonth + "/" + (year - 1);
		Date coverageCutOffDate = HXUtility.convertStringToDate(cutOffDate);
		Date todaysDate = new Date();

		boolean isTodaysDateGreaterThanCoverageCutoffDate = HXUtility.isEndDateGreaterThanStartDate(coverageCutOffDate, todaysDate);

		if (!isTodaysDateGreaterThanCoverageCutoffDate) {
			userCoverageStartDate = HXUtility.firstDayOfNextYear(year - 1);
		} else {
			if (HXUtility.isCurrentDateSameAsOrBefore15th()) {
				userCoverageStartDate = HXUtility.firstDayOfNextMonth(year);
			} else {
				userCoverageStartDate = HXUtility.firstDayOfNextToNextMonth(year);
			}
		}

		return userCoverageStartDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcentive.individual.hix.enrollment.util.ext.
	 * EnrollmentCoverageDatesServiceExt#setUserCoverageEndDate(java.lang.Long)
	 */
	@Override
	public Date getDefaultUserCoverageEndDate(Long programId) throws Exception {
		String planYear = getEnrollmentPeriodPlanYear();
		Date userCoverageEndDate = null;

		if (HXUtility.isEmpty(planYear)) {
			throw new HCException(new MessageCode(HXLogMsgConstants.LOG_ERROR_EE_ENROLLMENT_PERIOD_YEAR_BLANK));
		}

		int year = Integer.parseInt(planYear);

		String cutOffDate = coverageCutOffMonth + "/" + coverageCutOffDayOfMonth + "/" + (year - 1);
		Date coverageCutOffDate = HXUtility.convertStringToDate(cutOffDate);
		Date todaysDate = new Date();

		boolean isTodaysDateGreaterThanCoverageCutoffDate = HXUtility.isEndDateGreaterThanStartDate(coverageCutOffDate, todaysDate);

		if (!isTodaysDateGreaterThanCoverageCutoffDate) {
			userCoverageEndDate = HXUtility.lastDayOfCurrentCoverageYear(year);
		} else {
			if (programId != null && (programId.equals(HXConstants.PRG_CHIP) || programId.equals(HXConstants.PRG_MEDICAID))) {
				if (HXUtility.isCurrentDateSameAsOrBefore15th()) {
					Date userCoverageStartDate = HXUtility.firstDayOfNextMonth(year);
					userCoverageEndDate = getNextCoverageEndDateForMAORCHIP(userCoverageStartDate);
				} else {
					Date userCoverageStartDate = HXUtility.firstDayOfNextToNextMonth(year);
					userCoverageEndDate = getNextCoverageEndDateForMAORCHIP(userCoverageStartDate);
				}
			} else {
				userCoverageEndDate = HXUtility.lastDayOfCurrentCoverageYear(year);
			}
		}
		return userCoverageEndDate;
	}

	/**
	 * Gets the next coverage end date for maorchip.
	 * 
	 * @param coverageStartDate
	 *            the coverage start date
	 * @return the next coverage end date for maorchip
	 */
	private static Date getNextCoverageEndDateForMAORCHIP(Date coverageStartDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(coverageStartDate);
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	@Override
	public Date getDefaultUserCoverageStartDateForMedicaidFFS() throws Exception {
		Date currentDate = HXUtility.getCurrentDateWithoutTimestamp();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}

	@Override
	public Date getDefaultUserCoverageEndDateForMedicaid(boolean forFFS, Date mmcCoverageStartDate) throws Exception {
		Date coverageEndDate = null;
		if (forFFS & mmcCoverageStartDate != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(mmcCoverageStartDate);
			cal.add(Calendar.DATE, -1);
			coverageEndDate = new Date(cal.getTimeInMillis());
		} else {
			Date ffsStartDate = getDefaultUserCoverageStartDateForMedicaidFFS();
			Calendar cal = Calendar.getInstance();
			cal.setTime(ffsStartDate);
			cal.add(Calendar.YEAR, 1);
			cal.add(Calendar.MONTH, -1);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			coverageEndDate = new Date(cal.getTimeInMillis());
		}
		return coverageEndDate;
	}

}
