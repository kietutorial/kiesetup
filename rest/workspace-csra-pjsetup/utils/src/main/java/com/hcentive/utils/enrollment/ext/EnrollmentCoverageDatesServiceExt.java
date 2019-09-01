package com.hcentive.utils.enrollment.ext;

import java.util.Date;

/**
 * Interface EnrollmentCoverageDatesServiceExt is been deprecated. Application
 * should be using {@link #DateDeterminationLogicService}
 * 
 */
@Deprecated
public interface EnrollmentCoverageDatesServiceExt {

	/**
	 * Gets the default user coverage start date.
	 * 
	 * @return the default user coverage start date
	 * @throws Exception
	 *             the exception
	 */
	public Date getDefaultUserCoverageStartDate() throws Exception;

	/**
	 * Gets the default user coverage end date.
	 * 
	 * @param programId
	 *            the program id
	 * @return the default user coverage end date
	 * @throws Exception
	 *             the exception
	 */
	public Date getDefaultUserCoverageEndDate(Long programId) throws Exception;

	/**
	 * getDefaultUserCoverageStartDateForMedicaidFFS
	 * 
	 * @return
	 * @throws Exception
	 */
	public Date getDefaultUserCoverageStartDateForMedicaidFFS() throws Exception;

	/**
	 * getDefaultUserCoverageEndDateForMedicaid
	 * 
	 * @param coverageForGapPeriodOnly
	 * @param mmcCoverageStartDate
	 * @return
	 * @throws Exception
	 */
	public Date getDefaultUserCoverageEndDateForMedicaid(boolean coverageForGapPeriodOnly, Date mmcCoverageStartDate)
			throws Exception;

	/**
	 * getEnrollmentPeriodPlanYearFirstDate()
	 * 
	 * @return
	 * @throws Exception
	 */
	public Date getEnrollmentPeriodPlanYearFirstDate() throws Exception;

}