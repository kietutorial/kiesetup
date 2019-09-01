package com.hcentive.utils.ext; 

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HxDateUtils {

	private static Logger logger = LoggerFactory.getLogger(HxDateUtils.class);
	
	public static XMLGregorianCalendar convertDateIntoXMLGregorianCalendar(Date dt) throws Exception {
		if (dt == null)
			return null;
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(dt);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (Exception e) {
			throw e;
		}
	}

	public static Date convertXMLGregorianCalendarIntoDate(XMLGregorianCalendar xmlDt) throws Exception {
		if (xmlDt == null)
			return null;
		try {
			return xmlDt.toGregorianCalendar().getTime();
		} catch (Exception e) {
			throw e;
		}
	}

	public static java.util.Date formatStringToDate(String strDate) {

		Date dtFrmtdDate = null;
		String strDtFormat = "";
		String tempStrDate = strDate;

		String strDt = "";
		if (strDate != null && !strDate.equals("")) {
			if (strDate.contains(":")) {
				int colonInd = strDate.indexOf(" ");
				strDate = strDate.substring(0, colonInd);
			}

		}
		if (strDate.matches("^\\d{1,2}\\d{1,2}\\d{4}")) {
			strDtFormat = "MMddyyyy";
		} else if (strDate.matches("^\\d{1,2}[.]\\d{1,2}[.]\\d{4}$")) {
			strDtFormat = "MM.dd.yyyy";
		} else if (strDate.matches("^\\d{1,2}[-]\\d{1,2}[-]\\d{4}$")) {
			strDtFormat = "MM-dd-yyyy";
		} else if (strDate.matches("^\\d{1,2}[/]\\d{1,2}[/]\\d{4}$")) {
			strDtFormat = "MM/dd/yyyy";
		}

		if (tempStrDate.contains(":")) {
			strDtFormat = strDtFormat + " kk:mm";
		}
		// }

		DateFormat df = new SimpleDateFormat(strDtFormat);
		df.setLenient(false);

		try {
			dtFrmtdDate = (Date) df.parse(tempStrDate);
		} catch (ParseException pe) {
			// caught date parsing error
			logger.error("EXCEPTION", pe);
			//pe.printStackTrace();
		}

		return (dtFrmtdDate);
	}

	/**
	 * @param date
	 *            MMDDYYYY DATE VALIDATION It can validate the following dates:
	 *            07/20/2011
	 */
	public static boolean isValidDOB(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		Date todaysDate = cal.getTime();
		Date testDate = null;

		try {
			testDate = sdf.parse(date);
		} catch (ParseException e) {
			// System.out.println("The date you have provided is in an invalid date format ");
			return false;
		}

		if (!sdf.format(testDate).equals(date)) {
			// System.out.println("The date you have provided is in an invalid date format ");
			return false;
		}

		// DOB can't be future date
		if (testDate.after(todaysDate)) {
			return false;
		}

		return true;
	}

	// This method is used to compute the age.
	public static int computeAge(String sDate) {
		// Initial variables.
		Date dbDate = null;
		int ILLEGAL_DATE = -2;
		long MILLI_SECONDS_YEAR = 31558464000L;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Parse sDate.
		try {
			dbDate = (Date) dateFormat.parse(sDate);
		} catch (ParseException e) {
			// Log.e("MyApplication","Can not compute age from date:"+sDate,e);
			return ILLEGAL_DATE; // Const = -2
		} // Compute age.
		long timeDiff = System.currentTimeMillis() - dbDate.getTime();
		int age = (int) (timeDiff / MILLI_SECONDS_YEAR);
		// MILLI_SECONDS_YEAR = 31558464000L;
		return age;
	}

	public static Date getCurrentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return new Date(dateFormat.format(System.currentTimeMillis()));
	}
	
	public static Calendar convertDateToCalendar(Date inDate) {
		
		Calendar calDate = null;
		if(inDate != null) {
			calDate = Calendar.getInstance();
			calDate.setTime(inDate);
		}		
		return calDate;
		
	}
	
	public static Date addTodate(Date refDate, int dateType, int value) {
		Calendar calDate = convertDateToCalendar(refDate);
		if(Calendar.MONTH == dateType) {
			calDate.add(Calendar.MONTH, value);
		} else if(Calendar.DATE == dateType) {
			calDate.add(Calendar.DATE, value);
		} else {
			calDate.add(Calendar.YEAR, value);
		}
		return calDate.getTime();
	}
	
	public static Date moveDatetoEndOfMonth(Date refDate) {
		Calendar calDate = convertDateToCalendar(refDate);
		calDate.add(Calendar.MONTH, 1);  
		calDate.set(Calendar.DAY_OF_MONTH, 1);  
		calDate.add(Calendar.DATE, -1);
		return calDate.getTime();
	}
	
	public static Date moveDatetoStartOfMonth(Date refDate) {
		Calendar calDate = convertDateToCalendar(refDate);
		calDate.set(Calendar.DAY_OF_MONTH, 1);
		return calDate.getTime();
	}
	
	public static boolean isDateBetween(Date refDate, Date startDate, Date endDate) {
		
		Calendar refCalDate = convertDateToCalendar(refDate);
		Calendar startCalDate = convertDateToCalendar(startDate);
		Calendar endCalDate = convertDateToCalendar(endDate);
		
		if((refCalDate.equals(startCalDate) || refCalDate.after(startCalDate)) &&
				(refCalDate.equals(endCalDate) || refCalDate.before(endCalDate))) {
			return true;
		}
		return false;
	}
	
       public static boolean isRefDateBetweenWindow(Date refDate, Date windowStart, Date windowEnd) {
		
		Calendar insuranceStartDate = Calendar.getInstance();
		insuranceStartDate.set(Calendar.DAY_OF_MONTH, 10);
		insuranceStartDate.set(Calendar.MONTH, Calendar.JANUARY);
		insuranceStartDate.set(Calendar.YEAR, 1900);
				
		Calendar insuranceEndDate = Calendar.getInstance();
		insuranceEndDate.set(Calendar.DAY_OF_MONTH, 25);
		insuranceEndDate.set(Calendar.MONTH, Calendar.DECEMBER);
		insuranceEndDate.set(Calendar.YEAR, 2099);
		
		logger.debug("insStartDate : " + insuranceStartDate.getTime());
		logger.debug("insEndDate : " + insuranceEndDate.getTime());
		
		if(windowStart != null) {
			insuranceStartDate = HxDateUtils.convertDateToCalendar(windowStart);
		}
		
		if(windowEnd != null) {
			insuranceEndDate = HxDateUtils.convertDateToCalendar(windowEnd);
		}
		
		Calendar referenceDate = HxDateUtils.convertDateToCalendar(refDate);
		
		boolean decision = HxDateUtils.isDateBetween(referenceDate.getTime(), insuranceStartDate.getTime(), insuranceEndDate.getTime());
		
		logger.debug("DECISION : " + decision);
		
		return decision;
	}
	
	public static boolean isDateBefore(Date refDate, Date startDate) {
		
		Calendar refCalDate = convertDateToCalendar(refDate);
		Calendar startCalDate = convertDateToCalendar(startDate);
		
		if(refCalDate.before(startCalDate)) {
			return true;
		}
		return false;
	}

	/* CR 1132 Start */
	public static boolean isDateLastofTheMonth(Date refDate) {

		Calendar refCalDate = convertDateToCalendar(refDate);

		if (refCalDate.get(Calendar.DATE) == refCalDate.getActualMaximum(Calendar.DATE)) {
			return true;
		}
		return false;
	}

	public static boolean isDateLastofTheCurrentMonth(Date refDate) {

		Calendar refCalDate = convertDateToCalendar(refDate);
		Date CurrentDate = new Date();
		Calendar CurrentCalendarDate = convertDateToCalendar(CurrentDate);
		CurrentCalendarDate.add(Calendar.MONTH, 1);
		CurrentCalendarDate.set(Calendar.DAY_OF_MONTH, 1);
		CurrentCalendarDate.add(Calendar.DATE, -1);

		if (refCalDate.equals(CurrentCalendarDate)) {
			return true;
		}
		return false;
	}

	public static Date getLastDayofTheMonth(Date refDate) throws Exception {
		if (refDate == null)
			return null;
		try {
			Calendar refCalDate = convertDateToCalendar(refDate);
			refCalDate.set(Calendar.DATE, refCalDate.getActualMaximum(Calendar.DATE));

			Date lastDayOfMonth = refCalDate.getTime();
			return lastDayOfMonth;
		} catch (Exception e) {
			throw e;
		}
	}

	public static Date getFirstDayofTheNextMonth(Date refDate) throws Exception {
		if (refDate == null)
			return null;
		try {
			Calendar refCalDate = convertDateToCalendar(refDate);

			refCalDate.add(Calendar.MONTH, 1);
			refCalDate.set(Calendar.DAY_OF_MONTH, 1);
			Date FirstDayofTheNextMonth = refCalDate.getTime();
			return FirstDayofTheNextMonth;
		} catch (Exception e) {
			throw e;
		}
	}

	/* CR 1132 End */
	public static int getAgeInDays(Date dob) {
		DateTime dateOfBirth = new DateTime(dob.getTime());
		DateTime currentDate = new DateTime();
		Days noOfDays = Days.daysBetween(dateOfBirth, currentDate);
		return noOfDays.getDays();
	}
	
	public static int getAgeInDaysFromRefDate(Date dob, Date refDate) {
		DateTime dateOfBirth = new DateTime(dob.getTime());
		DateTime currentDate = new DateTime(refDate.getTime());
		Days noOfDays = Days.daysBetween(dateOfBirth, currentDate);
		return noOfDays.getDays();
	}
	
	public static int finDateDifferenceInMonths(Date startDate, Date endDate) {
		DateTime startCalDate = new DateTime(startDate.getTime());
		DateTime endCalDate = new DateTime(endDate.getTime());
		Months noOfMonths = Months.monthsBetween(startCalDate, endCalDate);
		return noOfMonths.getMonths();
	}
	
	public static int findDateDiffInDays(Date startDate, Date endDate) {
		DateTime startCalDate = new DateTime(HxDateUtils.getDateWithoutTime(startDate).getTime());
		DateTime endCalDate = new DateTime(HxDateUtils.getDateWithoutTime(endDate).getTime());
		System.out.println(startCalDate);
		System.out.println(endCalDate);
		Days noOfDays = Days.daysBetween(startCalDate, endCalDate);
		return noOfDays.getDays();
	}
	
	/*public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.setTime(HXUtility.convertStringToDateFormat("2016/05/20"));
		System.out.println(isDateWithInTenDayNoticePeriod(c.getTime(), 10));
	}*/
	
	public static boolean isDateWithinWindow(Date refDate, Date windowStart, Date windowEnd) {
		
		Calendar mecInsuranceStartDate = Calendar.getInstance();
		mecInsuranceStartDate.set(Calendar.DAY_OF_MONTH, 10);
		mecInsuranceStartDate.set(Calendar.MONTH, Calendar.JANUARY);
		mecInsuranceStartDate.set(Calendar.YEAR, 1900);
				
		Calendar mecInsuranceEndDate = Calendar.getInstance();
		mecInsuranceEndDate.set(Calendar.DAY_OF_MONTH, 25);
		mecInsuranceEndDate.set(Calendar.MONTH, Calendar.DECEMBER);
		mecInsuranceEndDate.set(Calendar.YEAR, 2099);
		
		logger.debug("insStartDate : " + mecInsuranceStartDate.getTime());
		logger.debug("insEndDate : " + mecInsuranceEndDate.getTime());
		
		if(windowStart != null) {
			mecInsuranceStartDate = HxDateUtils.convertDateToCalendar(windowStart);
		}
		
		if(windowEnd != null) {
			mecInsuranceEndDate = HxDateUtils.convertDateToCalendar(windowEnd);
		}
		
		Calendar referenceDate = HxDateUtils.convertDateToCalendar(refDate);
		
		boolean decision = HxDateUtils.isDateBetween(referenceDate.getTime(), mecInsuranceStartDate.getTime(), mecInsuranceEndDate.getTime());
		
		logger.debug("DECISION : " + decision);
		
		return decision;
	}
	
	public static boolean isMonth1GreaterOrEqualToMonth2ByCalendar(Date date1, Date date2) {
		
		Calendar calMonth1 = Calendar.getInstance();
		calMonth1.setTime(date1);
		
		Calendar calMonth2 = Calendar.getInstance();
		calMonth2.setTime(date2);
		
		if(calMonth1.get(Calendar.YEAR) >= calMonth2.get(Calendar.YEAR)) {
			if(calMonth1.get(Calendar.MONTH) >= calMonth2.get(Calendar.MONTH)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMonth1GreaterToMonth2ByCalendar(Date date1, Date date2) {
		
		Calendar calMonth1 = Calendar.getInstance();
		calMonth1.setTime(date1);
		
		Calendar calMonth2 = Calendar.getInstance();
		calMonth2.setTime(date2);
		
		if(calMonth1.get(Calendar.YEAR) > calMonth2.get(Calendar.YEAR) 
				|| calMonth1.get(Calendar.MONTH) > calMonth2.get(Calendar.MONTH)) {
			return true;
		}
		return false;
	}
	public static boolean isDateAfter(Date refDate, Date pointerDate) {
		Calendar refCalDate = HxDateUtils.convertDateToCalendar(refDate);
		Calendar pointerCalDate = HxDateUtils.convertDateToCalendar(pointerDate);
		
		if(refCalDate.after(pointerCalDate)) {
			return true;
		}
		return false;
	}


	public static Date formatInputDate(Date inputDate, String dateFormat) {
		String dateInputStr = HXUtility.convertDateToString(inputDate, dateFormat);

		return HXUtility.convertStringToDate(dateInputStr, dateFormat);
	}
	
	public static boolean isDateEqualWithoutTimeStamp(Date date1, Date date2) {
		
		Calendar calDate1 = removeTimeStampData(convertDateToCalendar(date1));
		Calendar calDate2 = removeTimeStampData(convertDateToCalendar(date2));
		
		if(calDate1.equals(calDate2)) return true;
		
		return false;
		
	}

	public static Calendar removeTimeStampData(Calendar calDate) {
		calDate.set(Calendar.HOUR_OF_DAY, 0);
		calDate.set(Calendar.MINUTE, 0);
		calDate.set(Calendar.SECOND, 0);
		calDate.set(Calendar.MILLISECOND, 0);
		return calDate;
	}
	
	public static int getRemainingDays(Date date) {
		Calendar tmpDob = Calendar.getInstance();
		
		tmpDob.setTime(date);
		
		tmpDob.set(Calendar.HOUR_OF_DAY, 0);
		
		tmpDob.clear(Calendar.HOUR);
		tmpDob.clear(Calendar.MINUTE);
		tmpDob.clear(Calendar.SECOND);
		tmpDob.clear(Calendar.MILLISECOND);

		DateTime dtDOB = new DateTime(tmpDob);
		DateTime dtcurrentDt = new DateTime(HXUtility.getCurrentDate());

		Days d = Days.daysBetween(dtcurrentDt,dtDOB);
		
		int daysDiff = d.getDays();
		return daysDiff;
	}
	/**
	 * Utility API added as part of CR1132.
	 *  
	 *  If date is null return false
	 *  If date is on or before 15 then return false
	 *	Calculate last date of the month for given date
	 *  Calculate number of days between reference date and end of month date
	 *  if the difference days is > 10 then return true else return false.
	 *   
	 * @param Date to check if is before 11 days of same month end
	 * @return True is 11 days of same month end, False if not
	 */
	public static boolean isDateWithInTenDayNoticePeriod(Date refDate, int tendayNoticePeriodDays){
		boolean result = false;
		if(null == refDate){
			return result;
		}
		if(logger.isDebugEnabled()){
			logger.debug("Input date::"+refDate.toString());
		}
		Calendar refCal = Calendar.getInstance();
		refCal.setTime(refDate);
		if(refCal.get(Calendar.DAY_OF_MONTH) <= 15){
			if(logger.isDebugEnabled()){
				logger.debug("result for Input date::"+refDate.toString()+" is::"+result);
			}
			return result;
		}
		Date endOfMonth = moveDatetoEndOfMonth(refDate);
		
		
		Calendar monthEndCal = Calendar.getInstance();
		monthEndCal.setTime(endOfMonth);
		
		int numberOfDays = monthEndCal.get(Calendar.DAY_OF_MONTH) - refCal.get(Calendar.DAY_OF_MONTH); 
		if(logger.isDebugEnabled()){
			logger.debug("numberOfDays for Input date::"+refDate.toString()+" is::"+numberOfDays);
		}
		result = numberOfDays >= tendayNoticePeriodDays;
		if(logger.isDebugEnabled()){
			logger.debug("result for Input date::"+refDate.toString()+" is::"+result);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param refDate
	 * @param pointerDate
	 * @return List of dates from refDate to PointerDate dates including them
	 */
	
	public static List<Date> getFirstDayOfMonthBetweenTwoDates(Date refDate, Date pointerDate) {
		
		List<Date> dateList = new ArrayList<Date>();
		
		Calendar refDateCal = Calendar.getInstance();
		refDateCal.setTime(refDate);
		
		Calendar pointerDateCal = Calendar.getInstance();
		pointerDateCal.setTime(pointerDate);

		while (pointerDateCal.after(refDateCal)) {
			dateList.add(refDateCal.getTime());
			refDateCal.add(Calendar.MONTH, 1);
		}
		return dateList;
	}
	
	public static Date getDateWithoutTime(Date refDate) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(refDate);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		return cal1.getTime();
	}
	
	public static void main(String[] args) {
				
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.MONTH, Calendar.MARCH);
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		//cal1.set(Calendar.HOUR_OF_DAY, 0);
		//cal1.set(Calendar.MINUTE, 0);
		//cal1.set(Calendar.SECOND, 0);
		//cal1.set(Calendar.MILLISECOND, 0);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.MONTH, Calendar.APRIL);
		cal2.set(Calendar.DAY_OF_MONTH, 1);
		//cal2.set(Calendar.HOUR_OF_DAY, 0);
		//cal2.set(Calendar.MINUTE, 0);
		//cal2.set(Calendar.SECOND, 0);
		//cal2.set(Calendar.MILLISECOND, 0);
		
		System.out.println(cal1.getTime() + " - " + cal2.getTime() + " " + HxDateUtils.findDateDiffInDays(cal1.getTime(), cal2.getTime()));
		
	}
}
