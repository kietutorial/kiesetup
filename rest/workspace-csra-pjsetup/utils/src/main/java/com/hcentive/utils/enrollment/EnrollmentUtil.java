package com.hcentive.utils.enrollment;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcentive.utils.ext.HXUtility;

// TODO: Auto-generated Javadoc
/**
 * The Class EnrollmentUtil.
 *
 * @author allwins
 */
public class EnrollmentUtil {

	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(EnrollmentUtil.class);
	
	/**
	 * retroactive-period => [  effective_date <= current_date <= retroactive_end_date ].
	 *
	 * @param currentDate the current date
	 * @param effectiveDate the effective date
	 * @param retroactiveEndDate the retroactive end date
	 * @return true, if is valid retroactive period
	 */
	public static boolean isValidRetroactivePeriod(  Date currentDate, Date effectiveDate, Date retroactiveEndDate ){
		if( (DateUtils.isSameDay(currentDate, effectiveDate ) || effectiveDate.before ( currentDate )) //  effective_date <= current_date
				&& ( DateUtils.isSameDay(currentDate, retroactiveEndDate ) || currentDate.before( retroactiveEndDate )) // current_date <= retroactive_end_date
			){ 
			logger.debug("In Retroactive Period");
			return true;
		}
		return false;
	}
	
	/**
	 * edit-enrollment-period => [  enrollment_end_date < current_date < effective_date ].
	 *
	 * @param currentDate the current date
	 * @param enrollmentEndDate the enrollment end date
	 * @param effectiveDate the effective date
	 * @return true, if is valid edit enrollment period
	 */
	public static boolean isValidEditEnrollmentPeriod( Date currentDate, Date enrollmentEndDate, Date effectiveDate ){
		if( enrollmentEndDate.before ( currentDate ) // enrollment_end_date < current_date
				&& currentDate.before( effectiveDate ) // current_date < effective_date
			){
			logger.debug("In Edit-Enrollment Period");
			return true;
		}
		return false;
	}
	
	/**
	 * open-enrollment-period => [  enrollment_start_date <= current_date <= enrollment_end_date ].
	 *
	 * @param currentDate the current date
	 * @param enrollmentStartDate the enrollment start date
	 * @param enrollmentEndDate the enrollment end date
	 * @return true, if is valid open enrollment period
	 */
	public static boolean isValidOpenEnrollmentPeriod( Date currentDate, Date enrollmentStartDate, Date enrollmentEndDate ){
		if( !HXUtility.isNull(enrollmentStartDate) && !HXUtility.isNull(enrollmentEndDate) && !HXUtility.isNull(currentDate) &&
				(DateUtils.isSameDay(currentDate, enrollmentStartDate ) || enrollmentStartDate.before ( currentDate )) //  enrollment_start_date <= current_date
				&& ( DateUtils.isSameDay(currentDate, enrollmentEndDate ) || currentDate.before( enrollmentEndDate )) // current_date <= enrollment_end_date
			){ 
			logger.debug("In Open-Enrollment Period");
			return true;
		}
		return false;
	}
	
	/**
	 * valid-period => [  start_date <= current_date <= end_date ].
	 *
	 * @param currentDate the current date
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return true, if is valid period
	 */
	public static boolean isValidPeriod( Date currentDate, Date startDate, Date endDate ){
		if( (DateUtils.isSameDay(currentDate, startDate ) || startDate.before ( currentDate )) //  startDate <= current_date
				&& ( DateUtils.isSameDay(currentDate, endDate ) || currentDate.before( endDate )) // current_date <= endDate
			){ 
			logger.debug("In Valid Period");
			return true;
		}
		return false;
	}
	
	/**
	 * after-period => [  date1 > date2 ].
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 */
	public static boolean afterPeriod( Date date1, Date date2 ){
		if( date1 != null && date2 != null && date1.after ( date2 )) // date1 > date2 
		{ 
			logger.debug("In After Date");
			return true;
		}
		return false;
	}
	/**
	 * same-period => [  date1 == date2 ].
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 */
	public static boolean samePeriod( Date date1, Date date2 ){
		if( date1 != null && date2 != null && DateUtils.isSameDay(date1, date2)) // date1 == date2
		{ 
			logger.debug("In After Date");
			return true;
		}
		if( date1 == null && date2 == null ){
			return true;
		}
		return false;
	}
	
	/**
	 * after-period => [  date1 > date2 && !(date1 == date2) ].
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 */
	public static boolean afterPeriodAndNotSameDay( Date date1, Date date2 ){
		if( date1 != null && date2 != null && date1.after ( date2 ) && !DateUtils.isSameDay(date1, date2)) // date1 > date2 && !(date1 == date2)
		{ 
			logger.debug("In After Date");
			return true;
		}
		return false;
	}
	/**
	 * after-period => [  date1 > date2 ].
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 */
	public static boolean afterSamePeriod( Date date1, Date date2 ){
		if( date1 != null && date2 != null && ( DateUtils.isSameDay(date1, date2 ) || date1.after ( date2 ) )) // date1 >= date2 
		{ 
			logger.debug("In After Date");
			return true;
		}
		return false;
	}
	
	/**
	 * before-period => [  date1 <= date2 ].
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 */
	public static boolean beforePeriod( Date date1, Date date2 ){
		if( DateUtils.isSameDay(date1, date2 ) || date1.before ( date2 )) //  date1 <= date2
		{ 
			logger.debug("In Before Period");
			return true;
		}
		return false;
	}
	/**
	 * before-period => [  date1 < date2 ].
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 */
	public static boolean beforeNotSameDayPeriod( Date date1, Date date2 ){
		if( !DateUtils.isSameDay(date1, date2 ) && date1.before ( date2 )) //  date1 < date2
		{ 
			logger.debug("In Before Period");
			return true;
		}
		return false;
	}

	/**
	 * Checks current date is within given number  of days in show.enrollment.renewal.alert.within.days property.
	 * 
	 * @param currentDate
	 *            the current date
	 * @param effectiveDate
	 *            the effective date
	 * @return true, if is showEnrollmentRenewalAlertWithinDays days
	 */
	public static boolean isShowEnrollmentRenewalAlertWithinDays(Date currentDate, Date effectiveDate, int showEnrollmentRenewalAlertWithinDays) {
		Date endEffectiveDate = HXUtility.coverageEndEffectiveDateForGivenDate(effectiveDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(endEffectiveDate);
		cal.add(Calendar.DATE, ((showEnrollmentRenewalAlertWithinDays>0?showEnrollmentRenewalAlertWithinDays-1:0) * -1)); // Subtract
																		// showEnrollmentRenewalAlertWithinDays
																		// days
																		// from
																		// end
																		// effective
		// date
		Date _showEnrollmentRenewalAlertWithinDays = new Date(cal.getTimeInMillis()); // _showEnrollmentRenewalAlertWithinDays
		// is
		// showEnrollmentRenewalAlertWithinDays
		// days
		// less
		// than
		// end
		// effective
		// Date
		if (EnrollmentUtil.afterPeriod(currentDate, _showEnrollmentRenewalAlertWithinDays)) { // currentDate
			// >
			// _showEnrollmentRenewalAlertWithinDays
			return true;
		}
		return false;
	}
	/**
	 * returns TRUE, if indicator is 0
	 * 
	 * @param renewalIndicator
	 * @return
	 */
	public static boolean isProcessedEligibility ( String renewalIndicator ){
		return NumberUtils.toInt(renewalIndicator,1) == 0;
	}
	/**
	 * returns TRUE, if indicator is 1
	 * 
	 * @param renewalIndicator
	 * @return
	 */
	public static boolean isRenewedEligibility ( String renewalIndicator ){
		return NumberUtils.toInt(renewalIndicator,0) == 1;
	}
	/**
	 * returns TRUE, if indicator is null or 1
	 * 
	 * @param renewalIndicator
	 * @return
	 */
	public static boolean toBeRenewedEligibility ( String renewalIndicator ){
		return NumberUtils.toInt(renewalIndicator,1) == 1;
	}
	
	/**
	 * returns TRUE, if integerValue is 1
	 * 
	 * @param integerValue
	 * @return
	 */
	public static boolean isTrue ( Integer integerValue ){
		if( integerValue == null ) return false;
		return BooleanUtils.toBooleanObject(integerValue) ;
	}
	
	/**
	 * returns TRUE, if indicator is matched to passed indicator
	 * 
	 * @param renewalIndicator
	 * @return
	 */
	public static boolean isTrue ( Integer integerValue, int toBeMatchedIndicator ){
		if( integerValue == null ) return false;
		return NumberUtils.toInt(integerValue.toString(),0) == toBeMatchedIndicator;
	}
	
	public static boolean isValidNonRenewedOpenEnrollmentPeriod(String renewalInd, Date currentDate, Date enrollmentStartDate, Date enrollmentEndDate){
		if(renewalInd == null){
			return isValidOpenEnrollmentPeriod(currentDate, enrollmentStartDate, enrollmentEndDate);
		}
		
		return false;
	}
		
	/**
	 * is RetroActive End date is End of Edit Period => [  employee_enrollment_end_date == effective_date -1 ].
	 *
	 * @param createdDate the offered date
	 * @param enrollmentEndDate the enrollment end date
	 * @param effectiveDate the effective date
	 * @return true, if is valid offered in edit period
	*/
	  
	public static boolean isRetroActiveEndDateIsEndofEditPeriod(Date employeeRetroactiveEndDate,Date effectiveDate)	{
		if (HXUtility.isNull(employeeRetroactiveEndDate)|| HXUtility.isNull(effectiveDate))
			return false;
		Date editPeriodEndDate = DateUtils.addDays( effectiveDate, -1);
		return HXUtility.compareDate(HXUtility.getDateWithOutTime(editPeriodEndDate), HXUtility.getDateWithOutTime(employeeRetroactiveEndDate));
	}	
}
