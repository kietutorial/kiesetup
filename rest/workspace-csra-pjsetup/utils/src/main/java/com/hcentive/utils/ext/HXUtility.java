package com.hcentive.utils.ext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.hcentive.utils.Constants;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.HCRuntimeException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.utils.ConversionUtils;
import com.hcentive.utils.utils.UtilityFunctions;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentCollectionConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentMapConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedMapConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernatePersistentSortedSetConverter;
import com.thoughtworks.xstream.hibernate.converter.HibernateProxyConverter;
import com.thoughtworks.xstream.hibernate.mapper.HibernateMapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class HXUtility.
 */
public class HXUtility extends UtilityFunctions {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(HXUtility.class);

	/** The Constant ALPHA_PATTERN. */
	private static final String ALPHA_PATTERN = "[a-zA-Z]+";
	
	/** The Constant ALPHA_NUMERIC_PATTERN. */
	private static final String ALPHA_NUMERIC_PATTERN = "[a-zA-Z0-9]+";

	/** The Constant ALPHA_NUMERIC_PATTERN. */
	public static final String MASKED_SSN_PATTERN = "[*0-9]+";

	/** The Constant NAME_PATTERN. */
	private static final String NAME_PATTERN = "[A-Za-z ,.'-]+";

	/** The Constant PATTERN. */
	private static final String PATTERN = "[A-Za-z\\s,&.'-_]+";

	/** The Constant DECIMALNUMBER_CONSIDERNEGATIVE. */
	private static final String DECIMALNUMBER_CONSIDERNEGATIVE = "-?(\\d+)?(\\.\\d+)?";

	/** The Constant DECIMALNUMBER_IGNORENEGATIVE. */
	private static final String DECIMALNUMBER_IGNORENEGATIVE = "(\\d+)?(\\.\\d+)?";

	/** The Constant INTEGERNUMBER_CONSIDERNEGATIVE. */
	private static final String INTEGERNUMBER_CONSIDERNEGATIVE = "(\\d+)?";

	/** The Constant DOUBLE_PATTERN. */
	private static final String DOUBLE_PATTERN = "\\d*(\\.\\d{0,2})?$";

	/** The Constant DATEFORMATTER. */
	public final static SimpleDateFormat DATEFORMATTER = new SimpleDateFormat("MM/dd/yyyy");

	/** The Constant DATEFORMATTERDD. */
	public final static SimpleDateFormat DATEFORMATTERDD = new SimpleDateFormat("dd");

	/** The Constant DATEFORMATTERMM. */
	public final static SimpleDateFormat DATEFORMATTERMM = new SimpleDateFormat("MM");

	/** The Constant DATEFORMATTERYYYY. */
	public final static SimpleDateFormat DATEFORMATTERYYYY = new SimpleDateFormat("yyyy");

	/** The Constant DATEFORMATTERMMDDYYYYHHMMSS. */
	public final static SimpleDateFormat DATEFORMATTERMMDDYYYYHHMMSS = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	/** The Constant DATEFORMATTERMMDDYYYYHHMMSS. */
	public final static SimpleDateFormat DATEFORMATTERMMDDYYYYHHMMSSA = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");

	/** The Constant LONGMONTHDAYDATEPATTERN. */
	public final static String LONGMONTHDAYDATEPATTERN = "MMMM dd'&#44;' yyyy";

	/** The Constant LONGMONTHDAYDATEPATTERN_ES. */
	public final static String LONGMONTHDAYDATEPATTERN_ES = "d' de 'MMMM' de 'yyyy";
	
	/** The Constant SHORTMONTHDAYDATEPATTERN. */
	public final static String SHORTMONTHDAYDATEPATTERN = "MMMM'&#44;' yyyy";

	/** The Constant SHORTMONTHDAYDATEPATTERN_ES. */
	public final static String SHORTMONTHDAYDATEPATTERN_ES = " MMMM 'de' yyyy"; 
	/** The program id mapper. */
	private static Map<Long, String> programIdMapper = new HashMap<Long, String>();

	/** The program id mapper. */
	private static Map<Long, String> nonSEPProgramIdMapper = new HashMap<Long, String>();

	/** EPP CR 1140 The Dental Plan Applicable program id mapper. */
	private static Map<Long, String> dentalPlanApplicableProgramIdMapper = new HashMap<Long, String>();

	/** The Constant MONTH_NAMES. */
	private static final String[] MONTH_NAMES = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	
	/** The Constant SHORTMONTHDATEPATTERN_ES. */
	public final static String MONTHPATTERN_ES = " MMMM 'de'"; 

	/** The Constant PlanCodeCharToLongMap. */
	public static final HashMap<String, String> PlanCodeCharToLongMap = new HashMap() {
		{
			put("0", "-");
			put("1", "C");
			put("2", "M");
			put("3", "N");
			put("4", "P");
			put("5", "Y");
			put("6", "H");
		}
	};

	/** The Constant PlanCodeLongToCharMap. */
	public static final HashMap<String, String> PlanCodeLongToCharMap = new HashMap() {
		{
			put("-", "0");
			put("C", "1");
			put("M", "2");
			put("N", "3");
			put("P", "4");
			put("Y", "5");
			put("H", "6");
		}
	};

	/** The Constant PlanCodeCharToLongPositions. */
	private static final int[] PlanCodeCharToLongPositions = new int[] { 6, 7, 15 };

	/** The Constant subsidizedProgramList. */
	private final static List<Long> subsidizedProgramList = new ArrayList<Long>() {
		{
			add(HXConstants.PRG_APTC);
			add(HXConstants.PRG_APTC_PREM);
			add(HXConstants.PRG_CSR);
		}
	};

	/** The Constant All subsidizedProgramList. */
	private final static List<Long> allSubsidizedProgramList = new ArrayList<Long>() {
		{
			add(HXConstants.PRG_APTC);
			add(HXConstants.PRG_APTC_PREM);
			add(HXConstants.PRG_CSR);
			add(HXConstants.PRG_CHIP);
			add(HXConstants.PRG_EPP);
		}
	};

	public static List<Long> getAllsubsidizedprogramlist() {
		return allSubsidizedProgramList;
	}

	static {
		programIdMapper.put(HXConstants.PRG_APTC, HXConstants.NYHX_PLAN_SELECTION_MATCHED_PROGRAM);
		programIdMapper.put(HXConstants.PRG_APTC_PREM, HXConstants.NYHX_PLAN_SELECTION_MATCHED_PROGRAM);
		programIdMapper.put(HXConstants.PRG_CSR, HXConstants.NYHX_PLAN_SELECTION_MATCHED_PROGRAM);
		programIdMapper.put(HXConstants.PRG_QHP, HXConstants.NYHX_PLAN_SELECTION_MATCHED_PROGRAM);
	}

	static {
		nonSEPProgramIdMapper.put(HXConstants.PRG_MEDICAID, HXConstants.NYHX_NON_SEP_MATCHED_PROGRAM);
		nonSEPProgramIdMapper.put(HXConstants.PRG_CHIP, HXConstants.NYHX_NON_SEP_MATCHED_PROGRAM);
		nonSEPProgramIdMapper.put(HXConstants.PRG_EPP, HXConstants.NYHX_NON_SEP_MATCHED_PROGRAM);
	}

	// EPP CR 1140 Dental Plan Applicable Programs
	static {
		dentalPlanApplicableProgramIdMapper.put(HXConstants.PRG_APTC, HXConstants.DENTAL_PLAN_APPLICABLE_PROGRAM);
		dentalPlanApplicableProgramIdMapper.put(HXConstants.PRG_APTC_PREM, HXConstants.DENTAL_PLAN_APPLICABLE_PROGRAM);
		dentalPlanApplicableProgramIdMapper.put(HXConstants.PRG_CSR, HXConstants.DENTAL_PLAN_APPLICABLE_PROGRAM);
		dentalPlanApplicableProgramIdMapper.put(HXConstants.PRG_QHP, HXConstants.DENTAL_PLAN_APPLICABLE_PROGRAM);
		dentalPlanApplicableProgramIdMapper.put(HXConstants.PRG_EPP, HXConstants.DENTAL_PLAN_APPLICABLE_PROGRAM);
	}
	
	@SuppressWarnings("serial")
	public static Map<String, Map<String,String>> xstreamExceptions = new HashMap<String, Map<String,String>>(){
		{
			put ("com.hcentive.eligibility.prescreening.domain.ext.MemberProgramComposition",new HashMap<String,String>(){
				{
					put ("VerifiedMAGI","verifiedMAGI");
				}		
			});
		}		
	};


	public static boolean allowProgramToShowAddMember(Long programId) {
		List<Long> allowprograms = new ArrayList<Long>();
		allowprograms.addAll(subsidizedProgramList);
		allowprograms.add(HXConstants.PRG_QHP);
		allowprograms.add(HXConstants.PRG_CHIP);

		return allowprograms.contains(programId);
	}

	/**
	 * evaluation for QHP, APTC, APTC PREMIUM, CSC program.
	 * 
	 * @param previousApplicationGroupProgramId
	 *            the previous application group program id
	 * @param newApplicationGroupProgramId
	 *            the new application group program id
	 * @return boolean
	 */
	public static boolean evaluateProgramChangeForPlanPopulationFromPreviousEnrollment(Long previousApplicationGroupProgramId,
			Long newApplicationGroupProgramId) {

		if (programIdMapper.get(previousApplicationGroupProgramId) != null
				&& programIdMapper.get(previousApplicationGroupProgramId).equals(HXConstants.NYHX_PLAN_SELECTION_MATCHED_PROGRAM)
				&& programIdMapper.get(newApplicationGroupProgramId) != null
				&& programIdMapper.get(newApplicationGroupProgramId).equals(HXConstants.NYHX_PLAN_SELECTION_MATCHED_PROGRAM)) {
			return true;
		}

		return false;
	}

	/**
	 * EPP CR 1140 evaluate if the program is applicable to select dental plan
	 * 
	 * @param programId
	 * @return boolean
	 */
	public static boolean isDentalPlanApplicableProgram(Long programId) {
		if (dentalPlanApplicableProgramIdMapper.get(programId) != null
				&& dentalPlanApplicableProgramIdMapper.get(programId).equals(HXConstants.DENTAL_PLAN_APPLICABLE_PROGRAM)) {
			return true;
		}
		return false;
	}

	/**
	 * EPP CR 1140 evaluate if the program is applicable to Non SEP Program
	 * 
	 * @param programId
	 * @return boolean
	 */
	public static boolean isNonSEPApplicableProgram(Long programId) {
		if (nonSEPProgramIdMapper.get(programId) != null
				&& nonSEPProgramIdMapper.get(programId).equals(HXConstants.NYHX_NON_SEP_MATCHED_PROGRAM)) {
			return true;
		}
		return false;
	}

	/**
	 * QHP, APTC, APTC PREMIUM, CSC program are considered to be equatable
	 * programs in plan selection So for any of the above mentioned program id
	 * return set of all equatable program ids.
	 * 
	 * @param programId
	 *            the program id
	 * @return Set
	 */
	public static Set<Long> qualifyingProgramSetForMatchedProgram(Long programId) {

		if (programIdMapper.get(programId) != null
				&& programIdMapper.get(programId).equals(HXConstants.NYHX_PLAN_SELECTION_MATCHED_PROGRAM)) {
			return programIdMapper.keySet();
		}

		return null;
	}

	/**
	 * QHP, APTC, CSC program are considered to be equatable programs in plan
	 * selection. return set of all equatable program ids
	 * 
	 * @return the sets the
	 */
	public static Set<Long> qualifyingProgramSetForMatchedProgram() {
		return programIdMapper.keySet();
	}

	/**
	 * To determine is this a valid Date or not.
	 * 
	 * @param date
	 *            the date
	 * @return boolean true or false status
	 */
	public static String convertDateToString(Date date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			return dateFormat.format(date);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	/**
	 * To determine is this a valid Date or not.
	 * 
	 * @param string
	 *            the string
	 * @return boolean true or false status
	 */
	public static Date convertStringToDate(String string) {
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			return dateFormat.parse(string);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	public static Date convertStrgToDate(String string) {
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			dateFormat.setLenient(false);
			return dateFormat.parse(string);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}
	
	

	
	

	
	public static Date convertStrngToDate(String string) {
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			return dateFormat.parse(string);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	/**
	 * To pass the generic date and convert. This date is already validated
	 * earlier , hence SimpleDateFormat is not restricting to a particular
	 * format.
	 * 
	 * @param string
	 *            of Date
	 * @return java.uti.Date
	 */
	public static Date convertStringToDateFormat(String string) {
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			dateFormat.setLenient(false);
			return dateFormat.parse(string);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	/**
	 * Convert date to string.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @return String
	 */
	public static String convertDateToString(Date date, String format) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.setLenient(false);
			return dateFormat.format(date);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	/**
	 * To determine is this a valid Date or not.
	 * 
	 * @param mm
	 *            Month String
	 * @param dd
	 *            Day of Month String
	 * @param yyyy
	 *            Year String
	 * @return boolean true or false status
	 */
	public static boolean isValidDate(String mm, String dd, String yyyy) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			dateFormat.parse(mm + "/" + dd + "/" + yyyy);
			return true;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * Function to determine whether a date is within last 24 hrs or not.
	 * 
	 * @param dateTime
	 *            the date time
	 * @return boolean true or false status
	 */
	public static boolean isWithinLast24Hrs(Date dateTime) {
		try {
			Date currentDateTime = getCurrentDateTime();
			long diffInMs = (currentDateTime.getTime() - dateTime.getTime());
			if (diffInMs >= 0L) {
				if (diffInMs < (24L * 60L * 60L * 1000L)) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * To determine is this a valid Date String or not.
	 * 
	 * @param date
	 *            Date String in MM/DD/YYYY.
	 * 
	 * @return boolean true or false status
	 */
	public static boolean isValidDate(String date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			dateFormat.parse(date);
			return true;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	public static boolean isDOBValid(String string) {

		if (!isDateValid(string)) {
			return false;
		}

		if (isDateFuture(string)) {
			return false;
		}

		return true;
	}

	public static boolean isDateValid(String date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			dateFormat.setLenient(false);
			dateFormat.parse(date);
			return true;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	@Deprecated 
	public static boolean isDateFuture(String date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			dateFormat.setLenient(false);

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();

			cal1.setTime(dateFormat.parse(date));
			cal2.setTime(dateFormat.parse(dateFormat.format(cal2.getTime())));

			if (cal1.after(cal2)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	 
	public static boolean isDateFuture(String date,Date currentDate) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			dateFormat.setLenient(false);

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();

			cal1.setTime(dateFormat.parse(date));
			cal2.setTime(dateFormat.parse(dateFormat.format(currentDate.getTime())));

			if (cal1.after(cal2)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}
	/**
	 * Checks if is valid hire date.
	 * 
	 * @param date
	 *            the date
	 * @return true, if is valid hire date
	 */
	public static boolean isValidHireDate(String date) {
		try {
			/*String[] joinArray = date.split("/");
			if (joinArray != null && joinArray[2] != null) {
				if (joinArray[2].length() < 4) {
					return false;
				}
			}*/
			if (HXUtility.isEmpty(date) || !(date.length() ==10 || date.length()==8))
				return false;
			
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			if (date.length()==8)
				dateFormat = new SimpleDateFormat("MM/dd/yy");
			dateFormat.setLenient(false);
			dateFormat.parse(date);
			return true;

		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * To determine is this a valid Date String or not.
	 * 
	 * @param mm
	 *            the mm
	 * @param dd
	 *            the dd
	 * @param yyyy
	 *            the yyyy
	 * @return boolean true or false status
	 */
	public static boolean isFutureDate(String mm, String dd, String yyyy) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();

			cal1.setTime(dateFormat.parse(mm + "/" + dd + "/" + yyyy));
			cal2.setTime(dateFormat.parse(dateFormat.format(cal2.getTime())));

			if (cal1.after(cal2)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * To determine is this Past Date.
	 * 
	 * 
	 * @return boolean true or false status
	 */
	public static boolean isPastDate(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			dateFormat.setLenient(false);

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();

			cal1.setTime(dateFormat.parse(date));
			cal2.setTime(dateFormat.parse(dateFormat.format(cal2.getTime())));

			if (cal1.before(cal2)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * This returns if parameter String (With trimmed spaces) is empty/null or
	 * not.
	 * 
	 * @param str
	 *            String to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().equals(""))
			return true;
		else
			return false;
	}

	/**
	 * This returns if parameter List is empty/null or not.
	 * 
	 * @param list
	 *            List to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean isEmpty(List list) {
		if (list == null || list.size() == 0)
			return true;
		else
			return false;
	}

	/**
	 * This returns if parameter Set is empty/null or not.
	 * 
	 * @param set
	 *            Set to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean isEmpty(Set set) {
		if (set == null || set.size() == 0)
			return true;
		else
			return false;
	}

	/**
	 * This returns if parameter Map is empty/null or not.
	 * 
	 * @param map
	 *            Map to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean isEmpty(Map map) {
		if (map == null || map.size() == 0)
			return true;
		else
			return false;
	}

	/**
	 * This returns if parameter Map is empty/null or not.
	 * 
	 * @param collection
	 *            the collection
	 * @return boolean true or false status
	 */
	public static boolean isEmpty(Collection collection) {
		if (collection == null || collection.size() == 0)
			return true;
		else
			return false;
	}

	/**
	 * This returns if text has only alpha characters.
	 * 
	 * @param text
	 *            Text to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean hasAlphaTextOnly(String text) {
		if (text != null && Pattern.matches(ALPHA_PATTERN, text))
			return true;
		else
			return false;
	}

	/**
	 * This returns if parameter String (With trimmed spaces) has text or not.
	 * 
	 * @param str
	 *            String to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean hasText(String str) {
		if (str == null || str.trim().equals(""))
			return false;
		else
			return true;
	}

	/**
	 * This returns if text has only characters defined in the pattern.
	 * 
	 * @param String
	 *            text - Text to be evaluated
	 * @param String
	 *            pattern - pattern to be followed
	 * @return boolean true or false status
	 */
	public static boolean matches(String text, String pattern) {
		if (text != null && Pattern.matches(pattern, text))
			return true;
		else
			return false;
	}

	/**
	 * This returns if text has only alpha characters.
	 * 
	 * @param text
	 *            Text to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean matchesNamePattern(String text) {
		if (text != null && Pattern.matches(NAME_PATTERN, text))
			return true;
		else
			return false;
	}

	/**
	 * This returns if text has alpha characters or alpha chars with special
	 * characters.
	 * 
	 * @param text
	 *            Text to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean matchesPattern(String text) {
		if (text != null && Pattern.matches(PATTERN, text))
			return true;
		else
			return false;
	}

	/**
	 * This returns if text has Double value.
	 * 
	 * @param text
	 *            Text to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean matchesDoublePattern(String text) {
		if (text != null && Pattern.matches(DOUBLE_PATTERN, text))
			return true;
		else
			return false;
	}

	/**
	 * Returns a standard true or false value based on input string For Example
	 * : Yes/No - True/False Y/N - True/False True/False - True/False T/F -
	 * True/False 1/0 - True/False <Blank String> - False <Any Other String> -
	 * False.
	 * 
	 * @param param
	 *            String to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean getBooleanValue(String param) {
		boolean retVal = false;
		if (isEmpty(param))
			return retVal;

		param = param.trim();
		if (param.equalsIgnoreCase("YES") || param.equalsIgnoreCase("Y") || param.equalsIgnoreCase("on"))
			return true;

		if (param.equalsIgnoreCase("TRUE") || param.equalsIgnoreCase("T"))
			return true;

		if (param.equalsIgnoreCase("1"))
			return true;

		return retVal;
	}

	/**
	 * Returns a standard true or false value based on input string For Example
	 * : Yes/No - True/False Y/N - True/False True/False - True/False T/F -
	 * True/False 1/0 - True/False <Blank String> - False <Any Other String> -
	 * False.
	 * 
	 * @param param
	 *            String to be evaluated
	 * @return boolean true or false status
	 */
	public static String getZeroOneStringValue(boolean param) {
		if (param) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * This returns SSN in a formatted display.
	 * 
	 * @param ssn
	 *            the ssn
	 * @return text The formatted SSN
	 */
	public static String getSSNforDisplay(String ssn) {
		if (!StringUtils.hasText(ssn) && ssn.length() != 9) {
			return null;
		}
		StringBuffer displaySSN = new StringBuffer();
		displaySSN.append("***-**-");
		displaySSN.append(ssn.substring(5));
		return displaySSN.toString();
	}

	/**
	 * This returns SSN in a formatted display with no masking<br>
	 * DONOT USE THIS METHOD FOR PUBLIC FACING WEB SITES USE THIS METHOD ONLY
	 * FOR INTERNAL HX SYSTEMS.
	 * 
	 * @param ssn
	 *            the ssn
	 * @return text The formatted SSN
	 */
	public static String getSSNforDisplayNoMasking(String ssn) {
		if (!HXUtility.isEmpty(ssn) && ssn.length() == 9) {
			StringBuffer displaySSN = new StringBuffer();
			displaySSN.append(ssn.substring(0, 3));
			displaySSN.append("-");
			displaySSN.append(ssn.substring(3, 5));
			displaySSN.append("-");
			displaySSN.append(ssn.substring(5));
			return displaySSN.toString();
		}
		return null;
	}

	/**
	 * This method validates if the input date is less by <numOfDays> than the
	 * current date. If the <inclusive> is true then it will validate if input
	 * date is less or equal by <numOfDays> than the current date.
	 * 
	 * @param mm
	 *            the mm
	 * @param dd
	 *            String
	 * @param yyyy
	 *            String
	 * @param numOfDays
	 *            String
	 * @param inclusiveToday
	 *            the inclusive today
	 * @return boolean
	 */
	public static boolean isDateLessByNumberOfDays(String mm, String dd, String yyyy, int numOfDays, boolean inclusiveToday) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();

			cal1.setTime(dateFormat.parse(mm + "/" + dd + "/" + yyyy));
			cal2.setTime(dateFormat.parse(dateFormat.format(cal2.getTime())));
			if (inclusiveToday) {
				cal2.add(Calendar.DAY_OF_MONTH, numOfDays);
			} else {
				cal2.add(Calendar.DAY_OF_MONTH, numOfDays + 1);
			}
			System.out.println("Diff = " + (cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR)));
			if (cal1.before(cal2)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * This method validates if the input date is in the past.
	 * 
	 * @param mm
	 *            String
	 * @param dd
	 *            String
	 * @param yyyy
	 *            String
	 * @return boolean
	 */
	public static boolean isPastDate(String mm, String dd, String yyyy) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

			dateFormat.setLenient(false);

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();

			cal1.setTime(dateFormat.parse(mm + "/" + dd + "/" + yyyy));
			cal2.setTime(dateFormat.parse(dateFormat.format(cal2.getTime())));

			if (cal1.before(cal2)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * This method will return true if the <inputData> String contains only
	 * numbers otherwise false.
	 * 
	 * @param inputData
	 *            String
	 * @return boolean
	 */
	public static boolean isNumeric(String inputData) {
		return org.apache.commons.lang.StringUtils.isNumeric(inputData);
	}

	/**
	 * To determine is the Date difference is atleast 15 days or not.
	 * 
	 * @param lastPasswordChangeTime
	 *            the last password change time
	 * @return boolean true or false status
	 */
	public static boolean isLastPasswordChangeTime(Date lastPasswordChangeTime) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);

			Calendar todayCal = Calendar.getInstance(); // today's date
			todayCal.setTime(dateFormat.parse(dateFormat.format(todayCal.getTime())));

			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(dateFormat.parse(dateFormat.format(lastPasswordChangeTime)));

			long milis1 = todayCal.getTimeInMillis();
			long milis2 = cal2.getTimeInMillis();

			// Calculate difference in milliseconds
			long diff = milis1 - milis2;

			// Calculate difference in days
			long diffDays = diff / (24 * 60 * 60 * 1000);

			if (diffDays > 15) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * To convert given date from String to java.util.Date format
	 * 
	 * @param strDate
	 *            the str date
	 * @return Date
	 */
	public static Date formatStringToDate(String strDate) {

		Date dtFrmtdDate = null;
		String strDtFormat = "";
		String tempStrDate = strDate;

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

		DateFormat df = new SimpleDateFormat(strDtFormat);
		df.setLenient(false);

		try {
			dtFrmtdDate = (Date) df.parse(tempStrDate);
		} catch (ParseException pe) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, pe.getMessage());
			// caught date parsing error
			// pe.printStackTrace();
		}

		return (dtFrmtdDate);
	}

	/**
	 * To validate date of birth.
	 * 
	 * @param mm
	 *            the mm
	 * @param dd
	 *            the dd
	 * @param yyyy
	 *            the yyyy
	 * @return boolean
	 */
	public static boolean isValidDOB(String mm, String dd, String yyyy) {

		if (!isValidDate(mm, dd, yyyy)) {
			return false;
		}

		if (isFutureDate(mm, dd, yyyy)) {
			return false;
		}

		return true;
	}

	/**
	 * To calculate age based on given date.
	 * 
	 * @param sDate
	 *            the s date
	 * @return int
	 */
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
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return ILLEGAL_DATE; // Const = -2
		}
		// Compute age.
		long timeDiff = System.currentTimeMillis() - dbDate.getTime();
		int age = (int) (timeDiff / MILLI_SECONDS_YEAR);
		return age;
	}

	/**
	 * To convert Date Into XMLGregorianCalendar.
	 * 
	 * @param dt
	 *            the dt
	 * @return XMLGregorianCalendar
	 * @throws Exception
	 *             the exception
	 */
	public static XMLGregorianCalendar convertDateIntoXMLGregorianCalendar(Date dt) throws Exception {
		if (dt == null)
			return null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(dt);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(dateString);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			throw e;
		}
	}

	/**
	 * To convert XMLGregorianCalendar Into Date.
	 * 
	 * @param xmlDt
	 *            the xml dt
	 * @return Date
	 * @throws Exception
	 *             the exception
	 */
	public static Date convertXMLGregorianCalendarIntoDate(XMLGregorianCalendar xmlDt) throws Exception {
		if (xmlDt == null)
			return null;
		try {
			return xmlDt.toGregorianCalendar().getTime();
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			throw e;
		}
	}

	/**
	 * getKeyForErrorMessage function will generate index based String which can
	 * be used as an id attribute for error Message div indexed for members.
	 * 
	 * @param index
	 *            int index of member in householdDetail
	 * @param text
	 *            String field name or <path> for field
	 * @return the HH member error key
	 */
	public static String getHHMemberErrorKey(int index, String text) {
		StringBuffer buf = new StringBuffer(HXErrMsgConstants.MEMBERS);
		buf.append(index);
		buf.append(text);
		return buf.toString();
	}

	/**
	 * getMemberErrorKey function will generate index based String which can be
	 * used as an id attribute for error Message div indexed for members.
	 * 
	 * @param index
	 *            the index
	 * @param text
	 *            the text
	 * @return String
	 */
	public static String getMemberErrorKey(int index, String text) {
		StringBuffer buf = new StringBuffer(HXConstants.UNDERSCORE);
		buf.append(index);
		buf.append(text);
		return buf.toString();
	}

	/**
	 * Get Month from a Date Object. Range from 1-12
	 * 
	 * @param dt
	 *            the dt
	 * @return the month
	 */
	public static int getMonth(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int month = cal.get(Calendar.MONTH);
		return month + 1;
	}

	/**
	 * Added for Defect 50674 rkalkir Get Month Name from a Date Object.
	 * 
	 * @param dt
	 *            the dt
	 * @return the monthName
	 */
	public static String getMonthName(Date dt) {
		Format formatter = new SimpleDateFormat("MMMM");
		String monthName = formatter.format(dt);
		return monthName;
	}

	/**
	 * Added for Defect 50674 rkalkir Get Month Name from a Month Number.
	 * 
	 * @param dt
	 *            the dt
	 * @return the monthName
	 */
	public static String getRenwalMonthName(String monthNo) {
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM");
		String monthName = "";
		try {
			monthName = monthDisplay.format(monthParse.parse(monthNo));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monthName;
	}

	/**
	 * Get Day of month from a Date Object.
	 * 
	 * @param dt
	 *            the dt
	 * @return the day
	 */
	public static int getDay(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	/**
	 * Get Day of month from a Date Object.
	 * 
	 * @param dt
	 *            the dt
	 * @return the day
	 */
	public static int getDayOfWeek(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	/**
	 * To be used to generate UUID which is currently being used in 834
	 * interface as Transaction Id.
	 * 
	 * @return String UUID
	 */

	public static String getUniqueTransactionId() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Get Year from a Date Object.
	 * 
	 * @param dt
	 *            the dt
	 * @return the year
	 */
	public static int getYear(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String args[]) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		}

	public static double subtractionOnDoubleType(double firstAmount, double secondAmount) {
		Double d = 0d;
		if (!HXUtility.isEmpty(firstAmount) && !HXUtility.isEmpty(secondAmount)) {
			BigDecimal b1 = new BigDecimal(Double.toString(firstAmount));
			BigDecimal b2 = new BigDecimal(Double.toString(secondAmount));
			BigDecimal b3 = b1.subtract(b2);
			d = b3.doubleValue();
		}
		return d;
	}
	
	public static double addOnDoubleType(double firstAmount, double secondAmount) {
		Double d = 0d;
		if (!HXUtility.isEmpty(firstAmount) && !HXUtility.isEmpty(secondAmount)) {
			BigDecimal b1 = new BigDecimal(Double.toString(firstAmount));
			BigDecimal b2 = new BigDecimal(Double.toString(secondAmount));
			BigDecimal b3 = b1.add(b2);
			d = b3.doubleValue();
		}
		return d;
	}
	
	/**
	 * getMemberErrorDivIds function will generate index based String which can
	 * be used as an id attribute for error Message div indexed for members for
	 * residence addresses screen.
	 * 
	 * @param index
	 *            int index of member in householdDetail
	 * @param text
	 *            String field name or <path> for field
	 * @return the member error div ids
	 */
	public static String getMemberErrorDivIds(int index, String text) {
		StringBuffer buf = new StringBuffer(HXErrMsgConstants.MEMBERS);
		buf.append("");
		buf.append(index);
		buf.append("_");
		buf.append(text);
		return buf.toString();
	}

	/**
	 * Returns "1" for True Returns "0" for False.
	 * 
	 * @param value
	 *            the value
	 * @return String Value "0" / "1"
	 */
	public static String getBooleanNumberInString(boolean value) {
		if (value) {
			return "1";
		}
		return "0";
	}

	/**
	 * Calculate income.
	 * 
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @param freqCode
	 *            the freq code
	 * @param amount
	 *            the amount
	 * @return the double
	 */
	public static Double calculateIncome(Date from, Date to, String freqCode, Double amount) {
		Double calculatedIncome = 0.0d;
		if (amount == null) {
			return calculatedIncome;
		}
		Calendar calTo = Calendar.getInstance();
		calTo.setTime(to);
		Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(from);
		int numberOfDays = (int) ((to.getTime() - from.getTime()) / (1000 * 60 * 60 * 24)) + 1;

		if (HXConstants.INCOME_FREQ_HOURLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = ((amount * 40) / 7) * numberOfDays;
		} else if (HXConstants.INCOME_FREQ_WEEKLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = ((amount) / 7) * numberOfDays;
		} else if (HXConstants.INCOME_FREQ_MONTHLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * ((numberOfDays * 12) / 365);
		} else if (HXConstants.INCOME_FREQ_QUARTERLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * ((numberOfDays * 4) / 365);
		} else if (HXConstants.INCOME_FREQ_ONCE_EVERY_TWO_WEEKS.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * ((numberOfDays * 26) / 365);
		} else if (HXConstants.INCOME_FREQ_YEARLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * (numberOfDays / 365);
		} else if (HXConstants.INCOME_FREQ_TWICE_A_MONTHLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = (amount * 2) * ((numberOfDays * 12) / 365);
		} else {

		}
		return calculatedIncome;
	}

	/**
	 * Calculate income.
	 * 
	 * @param freqCode
	 *            the freq code
	 * @param amount
	 *            the amount
	 * @return the double
	 */
	public static Double calculateIncome(String freqCode, Double amount) {
		Double calculatedIncome = 0.0d;

		if (amount == null) {
			return calculatedIncome;
		}

		if (HXConstants.INCOME_FREQ_HOURLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * (40 * 4.333333 * 12);
		} else if (HXConstants.INCOME_FREQ_WEEKLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * (4.333333 * 12);
		} else if (HXConstants.INCOME_FREQ_MONTHLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * 12;
		} else if (HXConstants.INCOME_FREQ_QUARTERLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * 4;
		} else if (HXConstants.INCOME_FREQ_YEARLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * 1;
		} else if (HXConstants.INCOME_FREQ_ONCE_EVERY_TWO_WEEKS.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * (2.166667 * 12);
		} else if (HXConstants.INCOME_FREQ_TWICE_A_MONTHLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * 2 * 12;
		} else {

		}
		return calculatedIncome;
	}

	/**
	 * Calculate income hourly.
	 * 
	 * @param freqCode
	 *            the freq code
	 * @param amount
	 *            the amount
	 * @param numberOfHoursPerWeek
	 *            the number of hours per week
	 * @return the double
	 */
	public static Double calculateIncomeHourly(String freqCode, Double amount, Integer numberOfHoursPerWeek) {
		Double calculatedIncome = 0.0d;

		if ((amount == null) || (numberOfHoursPerWeek == null)) {
			return calculatedIncome;
		}

		if (HXConstants.INCOME_FREQ_HOURLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = amount * (numberOfHoursPerWeek * 4.333333 * 12);
		}
		return calculatedIncome;
	}

	/**
	 * Calculate income.
	 * 
	 * @param numberofweeksormonths
	 *            the numberofweeksormonths
	 * @param amount
	 *            the amount
	 * @return the double
	 */
	public static Double calculateIncome(String numberofweeksormonths, String amount) {
		Double calculatedIncome = 0.0d;
		if (amount == null) {
			return calculatedIncome;
		}

		calculatedIncome = Double.parseDouble(numberofweeksormonths) * Double.parseDouble(amount);

		return calculatedIncome;
	}

	/**
	 * Checks if is not true.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is not true
	 */
	public static boolean isNotTrue(Boolean value) {
		if (value == null || !value.booleanValue()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is true.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is true
	 */
	public static boolean isTrue(Boolean value) {
		if (value != null && value.booleanValue()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is true.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is true
	 */
	public static boolean isTrue(String value) {
		if (hasText(value) && getBooleanValue(value)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is false.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is false
	 */
	public static boolean isFalse(String value) {
		if (hasText(value) && !getBooleanValue(value)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is false.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is false
	 */
	public static boolean isFalse(Boolean value) {
		if (value != null && !value.booleanValue()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is not false.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is not false
	 */
	public static boolean isNotFalse(Boolean value) {
		if (value == null || value.booleanValue()) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the formatted currency.
	 * 
	 * @param value
	 *            the value
	 * @return the formatted currency
	 */
	public static String getFormattedCurrency(Double value) {
		String result = "";
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		if (value == null) {
			result = nf.format(0);
		} else {
			result = nf.format(value);
		}
		return result;
	}

	/**
	 * Gets the formatted currency considering negative value.
	 * 
	 * @param value
	 *            the value
	 * @return the formatted currency
	 */
	public static String getFormattedCurrencyWithNegative(Double value) {
		String result = "";
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance();
		String symbol = formatter.getCurrency().getSymbol();
		formatter.setNegativePrefix(symbol + "-");
		formatter.setNegativeSuffix("");
		if (value == null) {
			result = formatter.format(0);
		} else {
			result = formatter.format(value);
		}
		return result;
	}

	/**
	 * Format amount.
	 * 
	 * @param value
	 *            the value
	 * @return the double
	 */
	public static Double formatAmount(Double value) {
		Double result = 0d;
		DecimalFormat format = new DecimalFormat("#.##");
		String formattedAmount = format.format(value);
		try {
			result = Double.parseDouble(formattedAmount);
		} catch (NumberFormatException e) {
			logger.error("EXCEPTION", e.getMessage());
		}
		return result;
	}

	/**
	 * Format amount as string.
	 * 
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String formatAmountAsString(Double value) {
		DecimalFormat format = new DecimalFormat("0.00");
		String formattedAmount = format.format(value);
		return formattedAmount;
	}

	/**
	 * Get the income field with indexing.
	 * 
	 * @param index
	 *            the index
	 * @param text
	 *            the text
	 * @param prefix
	 *            the prefix
	 * @return the indexed field
	 */
	public static String getIndexedField(int index, String text, String prefix) {
		StringBuffer buf = new StringBuffer(prefix);
		buf.append(HXConstants.LEFT_SQUARE_BRACKET);
		buf.append(index);
		buf.append(HXConstants.RIGHT_SQUARE_BRACKET);
		buf.append(HXConstants.PERIOD);
		buf.append(text);
		return buf.toString();
	}

	/**
	 * Get the income field with indexing.
	 * 
	 * @param index
	 *            the index
	 * @param text
	 *            the text
	 * @param prefix
	 *            the prefix
	 * @param suffix
	 *            the suffix
	 * @return the full indexed field
	 */
	public static String getFullIndexedField(int index, String text, String prefix, String suffix) {
		StringBuffer buf = new StringBuffer(prefix);
		buf.append(HXConstants.LEFT_SQUARE_BRACKET);
		buf.append(index);
		buf.append(HXConstants.RIGHT_SQUARE_BRACKET);
		buf.append(HXConstants.PERIOD);
		buf.append(text);
		buf.append(HXConstants.LEFT_SQUARE_BRACKET);
		buf.append(index);
		buf.append(HXConstants.RIGHT_SQUARE_BRACKET);
		buf.append(HXConstants.PERIOD);
		buf.append(suffix);
		return buf.toString();
	}

	/**
	 * Prepend the error key with correct index.
	 * 
	 * @param index
	 *            the index
	 * @param text
	 *            the text
	 * @param prefix
	 *            the prefix
	 * @return the indexed error key
	 */
	public static String getIndexedErrorKey(int index, String text, String prefix) {
		StringBuffer buf = new StringBuffer(prefix);
		buf.append(index);
		buf.append(text);
		return buf.toString();
	}

	/**
	 * Prepend the error key with correct index.
	 * 
	 * @param memberIndex
	 *            the member index
	 * @param index
	 *            the index
	 * @param text
	 *            the text
	 * @param prefix
	 *            the prefix
	 * @return the full indexed error key
	 */
	public static String getFullIndexedErrorKey(int memberIndex, int index, String text, String prefix) {
		StringBuffer buf = new StringBuffer(prefix);
		buf.append(memberIndex);
		buf.append(index);
		buf.append(text);
		return buf.toString();
	}

	/**
	 * Returns Date object for current date and time.
	 * 
	 * @return Date object for current date and time.
	 */
	public static Date getCurrentDateTime() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * Returns Date object for current date.
	 * 
	 * @return Date object for current date
	 */
	public static Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.clear(Calendar.HOUR);
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.SECOND);
		calendar.clear(Calendar.MILLISECOND);
		return calendar.getTime();
	}

	/**
	 * Returns Date object for current date.
	 * 
	 * @return Date object for current date
	 */
	public static Calendar getCurrentDateAsCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.clear(Calendar.HOUR);
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.SECOND);
		calendar.clear(Calendar.MILLISECOND);
		return calendar;
	}

	/**
	 * Convert a Delimited String to an ArrayList.
	 * 
	 * @param delimitedString
	 *            If it is null or empty, system will return an empty ArrayList
	 * @param delimmiter
	 *            if null, system will consider comma(",") as a delimiter
	 * @return delimited String's ArrayList<String>
	 */
	public static List<String> convertStringToListStr(String delimitedString, String delimmiter) {

		if (HXUtility.isEmpty(delimitedString))
			return new ArrayList<String>();

		if (HXUtility.isEmpty(delimmiter))
			delimmiter = HXConstants.DELIMITER_DEFAULT_STRING;

		List<String> list = new ArrayList<String>();
		for (String s : delimitedString.split(delimmiter)) {
			list.add(s.trim());
		}
		return list;
	}

	/**
	 * Convert a Delimited Number Strings to an ArrayList.
	 * 
	 * @param delimitedString
	 *            If it is null or empty, system will return an empty ArrayList
	 * @param delimmiter
	 *            if null, system will consider comma(",") as a delimiter
	 * @return delimited String's ArrayList<String>
	 */
	public static List<Long> convertStringToListLong(String delimitedString, String delimmiter) {

		if (HXUtility.isEmpty(delimitedString))
			return new ArrayList<Long>();

		if (HXUtility.isEmpty(delimmiter))
			delimmiter = HXConstants.DELIMITER_DEFAULT_STRING;

		List<Long> list = new ArrayList<Long>();
		for (String s : delimitedString.split(delimmiter)) {
			list.add(Long.valueOf(s));
		}
		return list;
	}
	
	/**
	 * 2016-10-14 KK Added.
	 */
	public static List<Integer> convertStringToListInteger(String delimitedString, String delimmiter) {
		if (HXUtility.isEmpty(delimitedString))
			return new ArrayList<Integer>();

		if (HXUtility.isEmpty(delimmiter))
			delimmiter = HXConstants.DELIMITER_DEFAULT_STRING;

		List<Integer> list = new ArrayList<Integer>();
		
		for (String s : delimitedString.split(delimmiter)) {
			list.add(Integer.valueOf(s.trim()));
		}
		
		return list;
	}

	/**
	 * Convert a Delimited String to an ArrayList.
	 * 
	 * @param delimitedString
	 *            If it is null or empty, system will return an empty ArrayList
	 * @param delimmiter
	 *            if null, system will consider comma(",") as a delimiter
	 * @return delimited String's ArrayList<String>
	 */
	public static Set<String> convertStringToSetStr(String delimitedString, String delimmiter) {

		if (HXUtility.isEmpty(delimitedString))
			return new HashSet<String>();

		if (HXUtility.isEmpty(delimmiter))
			delimmiter = HXConstants.DELIMITER_DEFAULT_STRING;

		Set<String> set = new HashSet<String>();
		for (String s : delimitedString.split(delimmiter)) {
			set.add(s);
		}
		return set;
	}

	/**
	 * Function to add number of days in particular Date Object.
	 * 
	 * @param date
	 *            Date Object
	 * @param days
	 *            number of days
	 * @return the date
	 */
	public static Date addDays(Date date, long days) {
		Date date2 = new Date();
		long t1 = date.getTime();
		long t2 = days * 1000 * 60 * 60 * 24;
		long t3 = t1 + t2;
		date2.setTime(t3);
		return date2;
	}
	
	/**
	 * CR1132 Function to Remove number of days in particular Date Object.
	 * 
	 * @param date
	 *            Date Object
	 * @param days
	 *            number of days
	 * @return the date
	 */
	public static Date removeDays(Date date, long days) {
		Date date2 = new Date();
		long t1 = date.getTime();
		long t2 = days * 1000 * 60 * 60 * 24;
		long t3 = t1 - t2;
		date2.setTime(t3);
		return date2;
	}

	/**
	 * Function to look for difference between 2 dates and search for existance
	 * of that day in the list and return that appropriate day if it exists.
	 * Else it will return -1
	 * 
	 * @param startDateForEvaluation
	 *            Start Date For Evaluation
	 * @param endDateForEvaluation
	 *            End Date For Evaluation
	 * @param days
	 *            list of days to be evaluated
	 * @return -1 if difference in days does not exist in list (OR if either of
	 *         date is null), otherwise appropriate number of days will be
	 *         returned
	 */

	public static Long dateFallingInWhichDay(Date startDateForEvaluation, Date endDateForEvaluation, List<Long> days) {
		Long retVal = null;

		if (startDateForEvaluation == null || endDateForEvaluation == null || days == null || days.size() == 0) {
			return null;
		}

		long diffInMs = Math.abs(endDateForEvaluation.getTime() - startDateForEvaluation.getTime());
		long diffInDays = TimeUnit.DAYS.convert(diffInMs, TimeUnit.MILLISECONDS);

		for (Long day : days) {
			if (day != null && day == diffInDays) {
				retVal = day;
				break;
			}
		}
		return retVal;
	}

	/**
	 * To calculate age based on given date in MM, dd, yyyy.
	 * 
	 * @param MM
	 *            the mm
	 * @param dd
	 *            the dd
	 * @param yyyy
	 *            the yyyy
	 * @return the age
	 */
	public static int getAge(String MM, String dd, String yyyy) {
		return getAge(MM + "/" + dd + "/" + yyyy);
	}

	/**
	 * To calculate age based on given date.
	 * 
	 * @param date
	 *            the date
	 * @return the age
	 */
	public static int getAge(String date) {
		// Date dbDate = convertStringToDate( date );
		Date dbDate = null;
		int ILLEGAL_DATE = -2;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			dbDate = (Date) dateFormat.parse(date);
		} catch (ParseException e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return ILLEGAL_DATE; // Const = -2
		}
		return calculateAge(dbDate);
	}

	/**
	 * Calculate Age of given date of birth.
	 * 
	 * @param dob
	 *            the dob
	 * @return the int
	 */
	private static int calculateAge(Date dob) {
		// set DOB
		Calendar birthCal = Calendar.getInstance();
		birthCal.setTime(dob);

		// current time
		Calendar nowCal = Calendar.getInstance();
		int age = nowCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
		boolean isMonthGreater = birthCal.get(Calendar.MONTH) > nowCal.get(Calendar.MONTH);
		boolean isMonthSameButDayGreater = birthCal.get(Calendar.MONTH) == nowCal.get(Calendar.MONTH)
				&& birthCal.get(Calendar.DAY_OF_MONTH) > nowCal.get(Calendar.DAY_OF_MONTH);

		if (isMonthGreater || isMonthSameButDayGreater) {
			age--;
		}
		return age;
	}

	/**
	 * Date Difference (in Days) between 2 dates. ie. Start Date - End Date
	 * Currently supports TimeUnit.DAYS, TimeUnit.HOURS & TimeUnit.MINUTES
	 * 
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @param timeUnit
	 *            the time unit
	 * @return the date diff
	 */
	public static long getDateDiff(Date startDate, Date endDate, TimeUnit timeUnit) {
		long diffInMs = Math.abs(startDate.getTime() - endDate.getTime());

		if (timeUnit == TimeUnit.DAYS)
			return TimeUnit.DAYS.convert(diffInMs, TimeUnit.MILLISECONDS);
		else if (timeUnit == TimeUnit.HOURS)
			return TimeUnit.HOURS.convert(diffInMs, TimeUnit.MILLISECONDS);
		else if (timeUnit == TimeUnit.MINUTES)
			return TimeUnit.MINUTES.convert(diffInMs, TimeUnit.MILLISECONDS);
		else if (timeUnit == TimeUnit.MILLISECONDS)
			return diffInMs;
		else
			throw new HCRuntimeException(MessageCode.GENERIC_ERROR);
	}

	/**
	 * This returns if parameter Double is empty/null or not Double.
	 * 
	 * @param db
	 *            Double to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean isEmpty(Double db) {
		if (db == null || db.isNaN())
			return true;
		else
			return false;
	}

	/**
	 * This returns if parameter Boolean (With trimmed spaces) is empty/null or
	 * not.
	 * 
	 * @param bool
	 *            Boolean to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean isEmpty(Boolean bool) {
		if (bool == null || bool.equals(""))
			return true;
		else
			return false;
	}

	/**
	 * Checks if the string is a valid amount.
	 * 
	 * @param str
	 *            the str
	 * @param considerNegativeNumbers
	 *            the consider negative numbers
	 * @return true, if is numeric or decimal
	 */
	public static boolean isNumericOrDecimal(String str, boolean considerNegativeNumbers) {

		if (considerNegativeNumbers)
			return str.matches(DECIMALNUMBER_CONSIDERNEGATIVE);
		else
			return str.matches(DECIMALNUMBER_IGNORENEGATIVE);
	}

	/**
	 * Checks if the string is a valid amount.
	 * 
	 * @param str
	 *            the str
	 * @return true, if is numeric or decimal
	 */
	public static boolean isNumericOrDecimal(String str) {

		return isNumericOrDecimal(str, false);
	}

	/**
	 * Checks if the string is a valid amount considering Negative.
	 * 
	 * @param str
	 *            the str
	 * @return true, if is numeric or decimal
	 */
	public static boolean isNumericOrDecimalConsideringNegative(String str) {

		return isNumericOrDecimal(str, true);
	}

	/**
	 * Checks if the string is a valid Integer.
	 * 
	 * @param str
	 *            the str
	 * @return true, if is integer value
	 */
	public static boolean isIntegerValue(String str) {

		return str.matches(INTEGERNUMBER_CONSIDERNEGATIVE);
	}

	/**
	 * Validates if a given string is a valid month.
	 * 
	 * @param month
	 *            the month
	 * @return true, if is valid month
	 */
	public static boolean isValidMonth(String month) {
		boolean result = false;
		if (hasText(month) && isNumeric(month)) {
			try {
				int intMonth = Integer.parseInt(month);
				if (intMonth <= 12) {
					result = true;
				}
			} catch (NumberFormatException e) {
				logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			}
		}
		return result;
	}

	/**
	 * To determine is this a valid Date String or not.
	 * 
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @return boolean true or false status
	 */
	public static boolean isEndDateGreaterThanStartDate(Date startDate, Date endDate) {
		boolean result = false;
		try {
			if (endDate != null && startDate != null) {
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(endDate);
				cal2.setTime(startDate);
				if (cal1.compareTo(cal2) >= 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
		}
		return result;
	}

	
	/**
	 * To determine is this a valid Date String or not.
	 * 
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            Date Of Birth
	 * @return boolean true or false status
	 */
	public static boolean isDateOfBirthGreaterThanStartDate(Date startDate, Date dob)  throws HCException {
		boolean result = false;
		try {
			if (dob != null && startDate != null) {
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(dob);
				cal2.setTime(startDate);
				if (cal1.compareTo(cal2) > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			logger.debug("Error during date of birth comparison with cov start date ", e.getMessage());
		}
		return result;
	}

	
	/**
	 * To determine the equality of string considering null values.
	 * 
	 * @param left
	 *            the left
	 * @param right
	 *            the right
	 * @return the boolean
	 */
	public static Boolean isEquals(String left, String right) {
		if (!isEmpty(left) && !isEmpty(right)) {
			return left.equals(right);
		}
		return false;
	}

	/**
	 * To determine the equality of string checking empty string values and
	 * nulls.
	 * 
	 * @param left
	 *            the left
	 * @param right
	 *            the right
	 * @return the boolean
	 */
	public static Boolean isEqualsCheckEmpty(String left, String right) {
		if (null == left && null == right) {
			return true;
		} else if (null != left) {
			return left.equals(right);
		} else if (null != right) {
			return right.equals(left);
		}
		return false;
	}

	/**
	 * Round.
	 * 
	 * @param value
	 *            the value
	 * @param precision
	 *            the precision
	 * @param roundingMode
	 *            the rounding mode
	 * @return the big decimal
	 */
	public static BigDecimal round(BigDecimal value, int precision, RoundingMode roundingMode) {
		return value.setScale(precision, roundingMode);
	}

	/**
	 * Round.
	 * 
	 * @param value
	 *            the value
	 * @param precision
	 *            the precision
	 * @param roundingMode
	 *            the rounding mode
	 * @return the big decimal
	 */
	public static BigDecimal round(Double value, int precision, RoundingMode roundingMode) {
		if (value == null) {
			return null;
		} else {
			return (BigDecimal.valueOf(value)).setScale(precision, roundingMode);
		}
	}

	/**
	 * Utility method to get the user name of the logged in user.
	 * 
	 * @return String
	 */
	public static String getLoggedInUsername() {
		logger.debug("HXUtility.getLoggedInUsername() : Begin");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof UserDetails) {
			return ((User) auth.getPrincipal()).getUsername();
		}
		logger.debug("HXUtility.getLoggedInUsername() : End");
		return null;
	}

	/**
	 * Calculated age based on a reference date.
	 * 
	 * @param dob
	 *            the dob
	 * @param referenceDate
	 *            the reference date
	 * @return int as Age
	 */
	public static int getAgeBasedOnReferenceDate(Date dob, Date referenceDate) {
		String dobString = ConversionUtils.convertToString(dob);
		if (dobString == null || dobString.length() == 0) {
			return -1;// negative value to avoid probs.
		}
		int dobYear = Integer.parseInt(dobString.substring(6, 10));
		int dobMonth = Integer.parseInt(dobString.substring(0, 2));
		int dobDay = Integer.parseInt(dobString.substring(3, 5));

		String refDateString = ConversionUtils.convertToString(referenceDate);
		if (refDateString == null || dobString.length() == 0) {
			return -1;// negative value to avoid probs.
		}
		int refYear = Integer.parseInt(refDateString.substring(6, 10));
		int refMonth = Integer.parseInt(refDateString.substring(0, 2));
		int refDay = Integer.parseInt(refDateString.substring(3, 5));

		// Create a calendar object with the date of birth (month is zero based)
		Calendar dateOfBirth = new GregorianCalendar(dobYear, dobMonth - 1, dobDay);

		// Create a calendar object with referenceDate date
		Calendar refDate = new GregorianCalendar(refYear, refMonth - 1, refDay);

		// Get age based on year
		int age = refDate.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		// Add the tentative age to the date of birth to get this year's
		// birthday
		dateOfBirth.add(Calendar.YEAR, age);

		// If this year's birthday has not happened yet, subtract one from age
		if (refDate.before(dateOfBirth)) {
			age--;
		}
		return age;
	}

	// Age in Years
	/**
	 * Gets the age.
	 * 
	 * @param dob
	 *            the dob
	 * @return the age
	 */
	public static int getAge(Date dob) {
		String dobString = ConversionUtils.convertToString(dob);
		if (dobString == null || dobString.length() == 0) {
			return -1;// negative value to avoid probs.
		}
		int dobYear = Integer.parseInt(dobString.substring(6, 10));
		int dobMonth = Integer.parseInt(dobString.substring(0, 2));
		int dobDay = Integer.parseInt(dobString.substring(3, 5));

		// Create a calendar object with the date of birth (month is zero based)
		Calendar dateOfBirth = new GregorianCalendar(dobYear, dobMonth - 1, dobDay);

		// Create a calendar object with today's date
		Calendar today = Calendar.getInstance();

		// Get age based on year
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		// Add the tentative age to the date of birth to get this year's
		// birthday
		dateOfBirth.add(Calendar.YEAR, age);

		// If this year's birthday has not happened yet, subtract one from age
		if (today.before(dateOfBirth)) {
			age--;
		}
		return age;
	}

	/**
	 * Gets the age in months.
	 * 
	 * @param dob
	 *            the dob
	 * @return the age in months
	 */
	public static int getAgeInMonths(Date dob) {
		DateTime dtDOB = new DateTime(dob); // doomsday lol
		DateTime dtcurrentDt = new DateTime(getCurrentDateTime()); // doomsday
																	// lol
		Months d = Months.monthsBetween(dtDOB, dtcurrentDt);
		int monthsDiff = d.getMonths();
		return monthsDiff;
	}

	/**
	 * Gets the age in months with respect to the reference date.
	 * 
	 * @param dob
	 * @param accountDt
	 * @return the age in months
	 */
	public static int getAgeInMonths(Date dob, Date refDt) {
		DateTime dtDOB = new DateTime(dob);
		DateTime dtcurrentDt = new DateTime(refDt);
		Months d = Months.monthsBetween(dtDOB, dtcurrentDt);
		int monthsDiff = d.getMonths();
		return monthsDiff;

	}

	/**
	 * First day of current month.
	 * 
	 * @return the date
	 */
	public static Date firstDayOfCurrentMonth() {
		Calendar nowCal = Calendar.getInstance();
		int month = nowCal.get(Calendar.MONTH);
		int year = nowCal.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * First day of month for date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	public static Date firstDayOfMonthForDate(Date dt) {
		Calendar cal = HxDateUtils.convertDateToCalendar(dt);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}

	/**
	 * First day of next month.
	 * 
	 * @return the date
	 */
	public static Date firstDayOfNextMonth() {
		Calendar nowCal = Calendar.getInstance();
		int month = nowCal.get(Calendar.MONTH) + 1;
		int year = nowCal.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * First day of next month for the given date.
	 * 
	 * @param accountDt
	 * 
	 * @return the date
	 */
	public static Date firstDayOfNextMonth(Date accountDt) {

		if (accountDt == null) {
			return firstDayOfNextMonth();
		} else {
			return firstDayOfNextMonthForDate(accountDt);
		}
	}

	/**
	 * First day of next month for date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	public static Date firstDayOfNextMonthForDate(Date dt) {
		Calendar cal = HxDateUtils.convertDateToCalendar(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}

	/**
	 * First day of previous month for date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	public static Date firstDayOfPreviousMonthForDate(Date dt) {
		Calendar cal = HxDateUtils.convertDateToCalendar(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}

	/**
	 * First day of next month.
	 * 
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date firstDayOfNextMonth(int year) {
		Calendar nowCal = Calendar.getInstance();
		int month = nowCal.get(Calendar.MONTH) + 1;

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * First day of next to next month.
	 * 
	 * @return the date
	 */
	public static Date firstDayOfNextToNextMonth() {
		Calendar nowCal = Calendar.getInstance();
		int month = nowCal.get(Calendar.MONTH) + 1;
		int year = nowCal.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * First day of next to next month.
	 * 
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date firstDayOfNextToNextMonth(int year) {
		Calendar nowCal = Calendar.getInstance();
		int month = nowCal.get(Calendar.MONTH) + 1;

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * First day of next to next month for date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	public static Date firstDayOfNextToNextMonthForDate(Date dt) {
		Calendar cal = HxDateUtils.convertDateToCalendar(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 2);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}
	/**
	 * 30days from current date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	public static Date ThrirtyDaysFromCurrentDate(Date dt) {
		Calendar cal = HxDateUtils.convertDateToCalendar(dt);
		 cal.add(Calendar.DATE, 30);
		 Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}

	/**
	 * First day of next year.
	 * 
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date firstDayOfNextYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year + 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * First day of year.
	 * 
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date firstDayOfYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}
	
	
	/**
	 * First day of year.
	 * 
	 * @param Date
	 *            the year
	 * @return the date
	 */
	public static Date firstDayOfYear(Date refDate) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		int year = getYear(refDate);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}
	
	public static Date lastDayOfPreviousReferenceYear(Date refDate) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		int year = getYear(refDate);
		cal.set(Calendar.YEAR, year -1);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Last day of next year.
	 * 
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date lastDayOfNextYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year + 1);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Last day of current coverage year.
	 * 
	 * @param year
	 *            the year
	 * @return the date
	 */
	public static Date lastDayOfCurrentCoverageYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Last day of current month.
	 * 
	 * @return the date
	 */
	public static Date lastDayOfCurrentMonth() {
		Calendar nowCal = Calendar.getInstance();
		int month = nowCal.get(Calendar.MONTH);
		int year = nowCal.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DATE, -1);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Last day of current month considering given date.
	 * 
	 * @return the date
	 */
	public static Date lastDayOfCurrentMonth(Date date) {
		int month = getMonth(date);
		int year = getYear(date);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DATE, -1);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}
	
	/**
	 * Last day of current month considering given date.
	 * 
	 * @return the date
	 */
	public static Date lastDayOfPreviousMonth(Date date) {
		int month = getMonth(date);
		int year = getYear(date);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DATE, -1);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Last day of next month for date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date lastDayOfNextMonthForDate(Date date) {
		int month = getMonth(date);
		int year = getYear(date);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DATE, -1);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Last day of month.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date lastDayOfMonthForDate(Date date) {
		int month = getMonth(date);
		int year = getYear(date);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DATE, -1);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Returns the middle day such as Feb 16 or March 16 for the previous month
	 * 
	 * @param date
	 * @return
	 */
	public static Date middleDayForPreviousMonth(String date) {
		Date dateToConvert = convertStringToDateFormat(date);
		int month = getMonth(dateToConvert) - 1;
		int year = getYear(dateToConvert);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 16);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	public static Date middleDayForPreviousMonth(Date dateToConvert) {
		int month = getMonth(dateToConvert) - 1;
		int year = getYear(dateToConvert);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 16);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Returns the middle day such as Feb 15 or March 15 for the given month
	 * 
	 * @param date
	 * @return
	 */
	public static Date middleDayForCurrentMonth(String date) {
		Date dateToConvert = convertStringToDateFormat(date);
		int month = getMonth(dateToConvert);
		int year = getYear(dateToConvert);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 15);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	public static Date middleDayForCurrentMonth(Date dateToConvert) {
		int month = getMonth(dateToConvert);
		int year = getYear(dateToConvert);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 15);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Last day of month in next year for given date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date lastDayOfMonthInNextYearForDate(Date date) {
		int month = getMonth(date);
		int year = getYear(date);

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year + 1);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DATE, -1);

		Date dueDate = new Date(cal.getTimeInMillis());

		return dueDate;
	}

	/**
	 * Day before specified date.
	 * 
	 * @param userSpecifiedDate
	 *            the user specified date
	 * @return the date
	 */
	public static Date dayBeforeSpecifiedDate(Date userSpecifiedDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(userSpecifiedDate);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/*
	 * Converts XMLGregorianCalendar to java.util.Date in Java
	 */
	/**
	 * To date.
	 * 
	 * @param calendar
	 *            the calendar
	 * @return the date
	 */
	public static Date toDate(XMLGregorianCalendar calendar) {
		if (calendar == null) {
			return null;
		}
		return calendar.toGregorianCalendar().getTime();
	}

	/**
	 * Convert an object into XML using XStream.
	 * 
	 * @param object
	 *            the object
	 * @param classType
	 *            the class type
	 * @return the XML from object
	 */
	public static String getXMLFromObject(Object object, final Class classType) {
		XStream xstream = new XStream() {
			protected MapperWrapper wrapMapper(final MapperWrapper next) {
				return new HibernateMapper(next) {
					@Override
					public boolean shouldSerializeMember(Class definedIn, String fieldName) {
						if (fieldName.equalsIgnoreCase("entityChangeMap")) {
							return false;
						}
						return super.shouldSerializeMember(definedIn, fieldName);
					}
				};
			}
		};
		xstream.registerConverter(new HibernateProxyConverter());
		xstream.registerConverter(new HibernatePersistentCollectionConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentMapConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentSortedMapConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentSortedSetConverter(xstream.getMapper()));

		xstream.processAnnotations(classType);

		String xmlStr = null;
		try {
			xmlStr = xstream.toXML(object);
			// logger.debug(xmlStr);
		} catch (Exception e) {
			logger.error("EXCEPTION", e);
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		return xmlStr;
	}

	/**
	 * Convert an object into XML using XStream.
	 * 
	 * @param object
	 *            the object
	 * @param classType
	 *            the class type
	 * @return the XML from object
	 */
	public static String getXMLFromObject(Object object, final Class classType, final List<String> conditionalOmits) {
		XStream xstream = new XStream() {
			protected MapperWrapper wrapMapper(final MapperWrapper next) {
				return new HibernateMapper(next) {
					@Override
					public boolean shouldSerializeMember(Class definedIn, String fieldName) {
						for (String p : conditionalOmits) {
							if (fieldName.equalsIgnoreCase(p)) {
								return false;
							}
						}
						return super.shouldSerializeMember(definedIn, fieldName);
					}
				};
			}
		};
		xstream.registerConverter(new HibernateProxyConverter());
		xstream.registerConverter(new HibernatePersistentCollectionConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentMapConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentSortedMapConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentSortedSetConverter(xstream.getMapper()));

		xstream.processAnnotations(classType);

		String xmlStr = null;
		try {
			xmlStr = xstream.toXML(object);
			logger.debug(xmlStr);
		} catch (Exception e) {
			logger.error("EXCEPTION", e);
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		return xmlStr;
	}

	/**
	 * Convert an XML into object using XStream.
	 * 
	 * @param xmlStr
	 *            the xml str
	 * @param classType
	 *            the class type
	 * @return the object from xml
	 */
	public static Object getObjectFromXML(String xmlStr, final Class classType) {
		XStream xstream = new XStream() {
			protected MapperWrapper wrapMapper(final MapperWrapper next) {
				return new HibernateMapper(next) {
					@Override
					public boolean shouldSerializeMember(Class definedIn, String fieldName) {
						if (fieldName.equalsIgnoreCase("entityChangeMap")) {
							return false;
						}
						return super.shouldSerializeMember(definedIn, fieldName);
					}
					@Override
					public String realMember(Class type, String serialized) {
						String xstreamExceptionKey=type.getName();
						String fieldName = super.realMember(type, serialized);
			            if(xstreamExceptions.containsKey(xstreamExceptionKey) && xstreamExceptions.get(xstreamExceptionKey).containsKey(fieldName)){
			            	fieldName = xstreamExceptions.get(xstreamExceptionKey).get(fieldName);
			            }
			            return fieldName;
			        }

				};
			}
		};

		xstream.registerConverter(new HibernateProxyConverter());
		xstream.registerConverter(new HibernatePersistentCollectionConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentMapConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentSortedMapConverter(xstream.getMapper()));
		xstream.registerConverter(new HibernatePersistentSortedSetConverter(xstream.getMapper()));

		xstream.processAnnotations(classType);

		Object object = null;
		try {
			logger.debug(xmlStr);
			object = xstream.fromXML(xmlStr);
			logger.debug(object.toString());
		} catch (Exception e) {
			logger.error("EXCEPTION", e);
			// e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Throwable e) {
			logger.error("EXCEPTION", e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return object;
	}

	/**
	 * Compute date difference in months.
	 * 
	 * @param StartDate
	 *            the start date
	 * @param noOfMonths
	 *            the no of months
	 * @return the date
	 */
	public static Date computeDateDifferenceInMonths(Date StartDate, int noOfMonths) {
		Calendar c = Calendar.getInstance();
		c.setTime(StartDate);
		c.add(Calendar.MONTH, noOfMonths);
		return c.getTime();
	}

	/**
	 * Parses the double.
	 * 
	 * @param doubleStr
	 *            the double str
	 * @return the double
	 */
	public static Double parseDouble(String doubleStr) {
		Double doubleVal = Double.valueOf(0);
		if (StringUtils.hasText(doubleStr) && !org.apache.commons.lang.StringUtils.equals(doubleStr, "null")) {
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setDecimalSeparator('.');
			DecimalFormat format = new DecimalFormat(doubleStr.startsWith("$") ? "$#,#.#" : "#,#.#");
			format.setDecimalFormatSymbols(symbols);
			try {
				doubleVal = format.parse(doubleStr).doubleValue();
			} catch (ParseException e) {
				logger.error("EXCEPTION", e.getMessage());
				// e.printStackTrace();
			}
		}
		return doubleVal;
	}

	/**
	 * Trim the given string and also check for null strings.
	 * 
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String trim(String value) {
		if (!isEmpty(value)) {
			value = value.trim();
		} else {
			value = "";
		}
		return value;
	}

	/**
	 * Adds the days to date.
	 * 
	 * @param date
	 *            the date
	 * @param days
	 *            the days
	 * @return the date
	 */
	public static Date addDaysToDate(Date date, int days) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}
	
	
	
	
	
	public static String fetchCalculatedDate(Date date, int days) {
		if (date == null || days <= 0) return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		String  uiDate = new SimpleDateFormat("MM/dd/yyyy").format(cal.getTime());
		return uiDate;
	}

	/**
	 * Checks if is current date same as or before15th.
	 * 
	 * @return true, if is current date same as or before15th
	 */
	public static boolean isCurrentDateSameAsOrBefore15th() {
		int day = getDay(new Date());

		if (day <= 15) {
			return true;
		}

		return false;
	}

	/**
	 * Gets the eligibility start date.
	 * 
	 * @return the eligibility start date
	 */
	public static Date getEligibilityStartDate() {
		String dateStr = "01/01/2014";
		return convertStringToDate(dateStr);
	}

	/**
	 * Gets the eligibility end date.
	 * 
	 * @return the eligibility end date
	 */
	public static Date getEligibilityEndDate() {
		String dateStr = "12/31/2014";
		return convertStringToDate(dateStr);
	}

	/**
	 * Compare date.
	 * 
	 * @param profileDob
	 *            the profile dob
	 * @param dob
	 *            the dob
	 * @return the boolean
	 */
	public static Boolean compareDate(Date profileDob, Date dob) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		String profileDobStr = dateFormat.format(profileDob);
		String dobStr = dateFormat.format(dob);

		if (profileDobStr.equals(dobStr)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

	/**
	 * Method to get Amount based on percentage.
	 * 
	 * @param amount
	 *            the amount
	 * @param percentage
	 *            - This would be in decimal (for example, 75% should be passed
	 *            as 0.75)
	 * @return the amount based on percentage
	 */
	public static Double getAmountBasedOnPercentage(Double amount, Double percentage) {
		Double finalAmount = null;

		if (!HXUtility.isEmpty(amount) && !HXUtility.isEmpty(percentage)) {
			finalAmount = HXUtility.formatAmount(amount * percentage);
		}

		return finalAmount;
	}

	/**
	 * This method will validate that whether the token has been generated in
	 * the past one hour or not for a user.
	 * 
	 * @param tokenGenDate
	 *            the token gen date
	 * @return the boolean
	 */
	public static Boolean isTokenValid(Date tokenGenDate) {

		Boolean result = Boolean.FALSE;

		Calendar currentCalendar = Calendar.getInstance();

		Calendar tokenGeneratedCalendar = Calendar.getInstance();
		tokenGeneratedCalendar.setTime(tokenGenDate);

		System.out.println((((currentCalendar.getTimeInMillis() - tokenGeneratedCalendar.getTimeInMillis()) / (1000)) / 60));

		Long timeDiff = (((currentCalendar.getTimeInMillis() - tokenGeneratedCalendar.getTimeInMillis()) / (1000)) / 60);

		if (timeDiff > 60) {
			return result;
		} else {
			result = Boolean.TRUE;
			return result;
		}

	}

	/**
	 * Gets the subsidized program list.
	 * 
	 * @return the subsidized program list
	 */
	public static List<Long> getSubsidyReceivingProgramList() {
		return subsidizedProgramList;
	}

	/**
	 * Add months to date and return the final date object.
	 * 
	 * @param date
	 *            the date
	 * @param months
	 *            the months
	 * @return the date
	 */
	public static Date addMonthsToDate(Date date, int months) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	/**
	 * Checks if is date less than no of months.
	 * 
	 * @param date
	 *            the date
	 * @param months
	 *            the months
	 * @return true, if is date less than no of months
	 */
	public static boolean isDateLessThanNoOfMonths(Date date, int months) {
		Date resDate = addMonthsToDate(new Date(), months);

		if (isPastDate(resDate))
			return true;

		return false;
	}

	/**
	 * Checks if is null.
	 * 
	 * @param object
	 *            the object
	 * @return true, if is null
	 */
	public static boolean isNull(Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a standard Yes or No value based on input string For Example :
	 * 0/1 - N/Y.
	 * 
	 * @param param
	 *            String to be evaluated
	 * @return boolean true or false status
	 */
	public static String getStringValue(String param) {

		String retVal = "";
		if (param == null)
			return retVal;

		param = param.trim();
		if (param.equalsIgnoreCase("0"))
			return "NO";

		if (param.equalsIgnoreCase("1"))
			return "YES";

		return retVal;
	}

	/**
	 * Checks if is contains string.
	 * 
	 * @param matchStr
	 *            the match str
	 * @param inpArray
	 *            the inp array
	 * @return true, if is contains string
	 */
	public static boolean isContainsString(String matchStr, String[] inpArray) {
		if (isEmpty(matchStr) || inpArray == null || inpArray.length == 0)
			return false;

		for (String str : inpArray) {
			if (matchStr.equals(str)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * This will return maximum of 20K characters.
	 * 
	 * @param ex
	 *            the ex
	 * @return the stack trace
	 */
	public static String getStackTrace(Exception ex) {
		if (ex == null) {
			return null;
		}
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		String str = errors.toString();
		if (str.length() > 20480) {
			str = str.substring(0, 20480);
		}
		return str;
	}

	/**
	 * This will return maximum of 2500 characters.
	 * 
	 * @param ex
	 *            the ex
	 * @return the stack trace
	 */
	public static String getStackTrace(Exception ex, int length) {
		if (ex == null) {
			return null;
		}
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		String str = errors.toString();
		if (str.length() > length) {
			str = str.substring(0, length);
		}
		return str;
	}

	/**
	 * isCurrentTimeWithinWindow.
	 * 
	 * @param startTimeInHHMM
	 *            the start time in hhmm
	 * @param windowInHrs
	 *            the window in hrs
	 * @return true, if is current time within window
	 * @throws Exception
	 *             the exception
	 */
	public static boolean isCurrentTimeWithinWindow(String startTimeInHHMM, int windowInHrs) throws Exception {
		boolean retVal = true;
		retVal = isCurrentTimeWithinWindow(startTimeInHHMM, windowInHrs, true);
		if (!retVal) {
			retVal = isCurrentTimeWithinWindow(startTimeInHHMM, windowInHrs, true);
		}
		return retVal;
	}

	/**
	 * Checks if is current time within window.
	 * 
	 * @param startTimeInHHMM
	 *            the start time in hhmm
	 * @param windowInHrs
	 *            the window in hrs
	 * @param checkForPastDay
	 *            the check for past day
	 * @return true, if is current time within window
	 * @throws Exception
	 *             the exception
	 */
	private static boolean isCurrentTimeWithinWindow(String startTimeInHHMM, int windowInHrs, boolean checkForPastDay)
			throws Exception {
		boolean retVal = false;

		Date currentDateTime = getCurrentDateTime();
		long currentTimeInMs = currentDateTime.getTime();

		String strCurrentDate = convertDateToString(currentDateTime, "MM/dd/yyyy");
		String strCurrentDateTime = strCurrentDate + " " + startTimeInHHMM;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HHmm");

		Date windowStartDateTime = simpleDateFormat.parse(strCurrentDateTime);
		if (checkForPastDay) {
			windowStartDateTime = addDays(windowStartDateTime, -1);
		}
		long windowStartTimeInMs = windowStartDateTime.getTime();

		Date windowEndDateTime = new Date();
		long windowInMs = 1000 * 60 * 60 * windowInHrs;
		long windowEndTimeInMs = windowStartTimeInMs + windowInMs;
		windowEndDateTime.setTime(windowEndTimeInMs);
		if (windowStartTimeInMs < currentTimeInMs && currentTimeInMs < windowEndTimeInMs) {
			retVal = true;
		}

		return retVal;
	}

	/**
	 * Gets the string from exception.
	 * 
	 * @param exceptionToLog
	 *            the exception to log
	 * @param length
	 *            the length
	 * @return the string from exception
	 */
	public static StringBuilder getStringFromException(Exception exceptionToLog, int length) {
		StringBuilder sb = new StringBuilder();
		Throwable rootCause = exceptionToLog.getCause();
		if(!isNull(rootCause)){
			sb.append(rootCause.getMessage());
			StackTraceElement[] elements = rootCause.getStackTrace();
			for (int i = 0; i < elements.length; i++) {
				sb.append("\r\n");
				sb.append(elements[i].toString());
			}
		} else {
			sb.append(exceptionToLog.getMessage());
			StackTraceElement[] elements = exceptionToLog.getStackTrace();
			for (int i = 0; i < elements.length; i++) {
				sb.append("\r\n");
				sb.append(elements[i].toString());
			}
		}
		if (sb.length() > length) {
			sb.setLength(length);
		}
		return sb;
	}

	/**
	 * To determine is this a valid Date or not.
	 * 
	 * @param string
	 *            the string
	 * @param format
	 *            the format
	 * @return boolean true or false status
	 */
	public static Date convertStringToDate(String string, String format) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.setLenient(false);
			return dateFormat.parse(string);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	/**
	 * Gets the entity.
	 * 
	 * @param entityByteArray
	 *            the entity byte array
	 * @return the entity
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public static Object getEntity(byte[] entityByteArray) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(entityByteArray);
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}

	/**
	 * Checks if is equals.
	 * 
	 * @param d1
	 *            Date 1
	 * @param d2
	 *            Date 2
	 * @return TRUE if equals
	 */
	public static boolean isEquals(Date d1, Date d2) {
		if (d1 == null && d2 == null) {
			return true;
		} else if (d1 != null && d2 != null) {
			return DateUtils.isSameDay(d1, d2);
		} else if (d1 == null && d2 != null) {
			return false;
		} else if (d1 != null && d2 == null) {
			return false;
		}
		return false;
	}

	/**
	 * Gets the difference between particular date and current date in years.
	 * 
	 * @param date
	 *            the date
	 * @return the difference between particular date and current date in years
	 */
	public static int getDifferenceBetweenParticularDateAndCurrentDateInYears(Date date) {
		Calendar today = Calendar.getInstance();
		int curYear = today.get(Calendar.YEAR);
		int curMonth = today.get(Calendar.MONTH);
		int curDay = today.get(Calendar.DAY_OF_MONTH);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		int age = curYear - year;
		if (curMonth < month || (month == curMonth && curDay < day)) {
			age--;
		}
		return age;
	}

	/**
	 * Checks if is exists.
	 * 
	 * @param strList
	 *            the str list
	 * @param str
	 *            the str
	 * @return true, if is exists
	 */
	public static boolean isExists(List<String> strList, String str) {
		if (str == null)
			return false;
		for (String st : strList) {
			if (org.apache.commons.lang.StringUtils.equalsIgnoreCase(st, str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is exists.
	 * 
	 * @param strList1
	 *            the str list1
	 * @param strList2
	 *            the str list2
	 * @return true, if is exists
	 */
	public static boolean isExists(List<String> strList1, List<String> strList2) {
		for (String st : strList2) {
			if (strList1.contains(st)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is exists.
	 * 
	 * @param idsList
	 *            the ids list
	 * @param id
	 *            the id
	 * @return true, if is exists
	 */
	public static boolean isExists(List<Long> idsList, Long id) {
		for (Long objId : idsList) {
			if (objId.equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns Date object for current date.
	 * 
	 * @param inputDate
	 *            the input date
	 * @return Date object for current date
	 */
	public static Date getDateWithOutTime(Date inputDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(inputDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.clear(Calendar.HOUR);
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.SECOND);
		calendar.clear(Calendar.MILLISECOND);
		return calendar.getTime();
	}

	/**
	 * Convert plan code into long.
	 * 
	 * @param planCode
	 *            the plan code
	 * @return the long
	 * @throws Exception
	 *             the exception
	 */
	public static long convertPlanCodeIntoLong(String planCode) throws Exception {
		if (isEmpty(planCode)) {
			throw new Exception("Plan Code is empty.");
		}

		planCode = planCode.trim();

		if (planCode.length() != 14 && planCode.length() != 17) {
			throw new Exception("Plan Code can be of 14 or 17 characters long");
		}

		StringBuffer strBufferPlanCode = new StringBuffer(planCode);

		for (int planCodeCharToLongPosition : PlanCodeCharToLongPositions) {
			if (strBufferPlanCode.length() == 14 && planCodeCharToLongPosition == 15) {
				continue;
			}
			char chr = strBufferPlanCode.charAt(planCodeCharToLongPosition - 1);
			if (!PlanCodeLongToCharMap.containsKey(chr + "")) {
				throw new Exception("Invalid character '" + chr + "' at position " + planCodeCharToLongPosition);
			}

			strBufferPlanCode = strBufferPlanCode.replace(planCodeCharToLongPosition - 1, planCodeCharToLongPosition,
					PlanCodeLongToCharMap.get(chr + ""));
		}

		String newPlanCode = "1" + strBufferPlanCode;

		Pattern p = Pattern.compile("[a-zA-Z]");
		Matcher m = p.matcher(newPlanCode);
		if (m.find()) {
			throw new Exception("Plan Code was suppose to contains only -, C, M, N, P, Y characters on 6, 7, 15 position only");
		}

		return Long.parseLong(newPlanCode);
	}

	/**
	 * Convert long into plan code.
	 * 
	 * @param lPlanCode
	 *            the l plan code
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public static String convertLongIntoPlanCode(long lPlanCode) throws Exception {

		String strPlanCode = lPlanCode + "";

		if (isEmpty(strPlanCode)) {
			throw new Exception("Plan Code is empty.");
		}

		strPlanCode = strPlanCode.trim();

		if (strPlanCode.length() != 15 && strPlanCode.length() != 18) {
			throw new Exception("Plan Code (In Long DataType) can be of 15 or 18 characters long");
		}

		strPlanCode = strPlanCode.substring(1);

		StringBuffer strBufferPlanCode = new StringBuffer(strPlanCode);

		for (int planCodeCharToLongPosition : PlanCodeCharToLongPositions) {
			if (strPlanCode.length() == 14 && planCodeCharToLongPosition == 15) {
				continue;
			}
			char chr = strBufferPlanCode.charAt(planCodeCharToLongPosition - 1);
			if (!PlanCodeCharToLongMap.containsKey(chr + "")) {
				throw new Exception("Invalid character '" + chr + "' at position " + planCodeCharToLongPosition);
			}

			strBufferPlanCode = strBufferPlanCode.replace(planCodeCharToLongPosition - 1, planCodeCharToLongPosition,
					PlanCodeCharToLongMap.get(chr + ""));
		}
		return strBufferPlanCode.toString();
	}

	/**
	 * Gets the age in days.
	 * 
	 * @param dob
	 *            the dob
	 * @return the age in days
	 */
	public static int getAgeInDays(Date dob) {
		// DateTime dtDOB = new DateTime(dob); // doomsday lol
		// DateTime dtcurrentDt = new DateTime(getCurrentDateTime()); //
		// doomsday lol

		// Def#37489 2015-05-11 KK Issue with calc date: Dates comparison should
		// be just be based on the dates only (not with time) !!!
		Calendar tmpDob = Calendar.getInstance();

		tmpDob.setTime(dob);

		tmpDob.set(Calendar.HOUR_OF_DAY, 0);

		tmpDob.clear(Calendar.HOUR);
		tmpDob.clear(Calendar.MINUTE);
		tmpDob.clear(Calendar.SECOND);
		tmpDob.clear(Calendar.MILLISECOND);

		DateTime dtDOB = new DateTime(tmpDob); // doomsday lol
		DateTime dtcurrentDt = new DateTime(getCurrentDate());

		Days d = Days.daysBetween(dtDOB, dtcurrentDt);

		int daysDiff = d.getDays();
		return daysDiff;
	}

	/**
	 * Gets the age in days with respect to a reference date.
	 * 
	 * @param dob
	 * @param refDt
	 * @return the age in days
	 */
	public static int getAgeInDays(Date dob, Date refDt) {
		DateTime dtDOB = new DateTime(dob);
		DateTime dtcurrentDt = new DateTime(refDt);
		Days d = Days.daysBetween(dtDOB, dtcurrentDt);
		int daysDiff = d.getDays();
		return daysDiff;
	}

	/**
	 * Is Age Less than a year. eg: dob = 10/25/2015, refDt=10/24/2016 then
	 * return true dob = 10/25/2015, refDt=10/25/2016 then return false dob =
	 * 10/25/2015, refDt=10/26/2016 then return false
	 * 
	 * @param dob
	 * @param refDt
	 * @return
	 */
	public static boolean isAgeLessThanYear(Date dob, Date refDt) {
		Calendar calDOB = HxDateUtils.convertDateToCalendar(dob);
		Calendar calRefDt = HxDateUtils.convertDateToCalendar(refDt);

		calDOB.add(Calendar.YEAR, 1);

		if (calRefDt.before(calDOB)) {
			return true;
		}

		return false;
	}

	/**
	 * Checks if is newborn based on date.
	 * 
	 * @param dob
	 *            the dob
	 * @return true, if is newborn based on date
	 */
	public static boolean isNewbornBasedOnDate(Date dob) {
		if (dob == null) {
			return false;
		}
		boolean result = false;
		int days = getAgeInDays(dob);
		if (days <= HXConstants.CHILD_MIN_AGE) {
			result = true;
		}
		return result;
	}

	/**
	 * Gets the income frequency.
	 * 
	 * @param freqCode
	 *            the freq code
	 * @return the income frequency
	 */
	public static String getIncomeFrequency(String freqCode) {
		String calculatedIncome = null;
		if (HXConstants.INCOME_FREQ_HOURLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = "Hourly";
		} else if (HXConstants.INCOME_FREQ_WEEKLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = "Weekly";
		} else if (HXConstants.INCOME_FREQ_MONTHLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = "Monthly";
		} else if (HXConstants.INCOME_FREQ_QUARTERLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = "Quarterly";
		} else if (HXConstants.INCOME_FREQ_YEARLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = "Yearly";
		} else if (HXConstants.INCOME_FREQ_ONCE_EVERY_TWO_WEEKS.equalsIgnoreCase(freqCode)) {
			calculatedIncome = "Once Every Two Weeks";
		} else if (HXConstants.INCOME_FREQ_TWICE_A_MONTHLY.equalsIgnoreCase(freqCode)) {
			calculatedIncome = "Twice a Month";
		} else {

		}
		return calculatedIncome;
	}

	/**
	 * To get Coverage End Date on the basis of given date.
	 * 
	 * @param refDate
	 *            the ref date
	 * @return the coverage end date for given date
	 * @throws HCException
	 *             the HC exception
	 */
	public static Date getCoverageEndDateForGivenDate(Date refDate) throws HCException {
		Date endDate = null;
		if (HXUtility.getDay(refDate) > 15) {
			endDate = HXUtility.lastDayOfNextMonthForDate(refDate);
		} else {
			endDate = HXUtility.lastDayOfMonthForDate(refDate);
		}
		return endDate;
	}

	/**
	 * Adds an year to the given date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date coverageEndEffectiveDateForGivenDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 12); // End date is 12 months from given date
		cal.add(Calendar.DATE, -1);

		Date calculatedDate = new Date(cal.getTimeInMillis());
		return calculatedDate;
	}

	/**
	 * Last day of month for given date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date lastDayOfMonthForGivenDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	/**
	 * Checks if is valid integer or double.
	 * 
	 * @param val
	 *            the val
	 * @return true, if is valid integer or double
	 */
	public static boolean isValidIntegerOrDouble(String val) {
		if (!HXUtility.isEmpty(val) && HXUtility.isNumericOrDecimal(val) && ((Double.parseDouble(val) > 0)))
			return true;
		else
			return false;
	}

	/**
	 * This function is similar to above function isValidIntegerOrDouble but
	 * will return true if the amount is 0.00
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isValidIntegerOrDoubleEqZero(String val) {
		if (!HXUtility.isEmpty(val) && HXUtility.isNumericOrDecimal(val) && ((Double.parseDouble(val) >= 0)))
			return true;
		else
			return false;
	}

	/**
	 * Convert set to delimited string.
	 * 
	 * @param ids
	 *            the ids
	 * @param delimitStr
	 *            the delimit str
	 * @return the string
	 */
	public static String convertSetToDelimitedString(Set<Long> ids, String delimitStr) {
		if (ids == null) {
			return null;
		}

		StringBuffer buf = new StringBuffer();
		if (!HXUtility.isEmpty(ids)) {
			for (Long id : ids) {
				if (buf.length() > 0) {
					buf.append(delimitStr);
				}
				buf.append(id.toString());
			}
		}
		return buf.toString();
	}

	/**
	 * Convert list to delimited string.
	 * 
	 * @param ids
	 *            the ids
	 * @param delimitStr
	 *            the delimit str
	 * @return the string
	 */
	public static String convertListToDelimitedString(List<Long> ids, String delimitStr) {
		if (ids == null) {
			return null;
		}

		StringBuffer buf = new StringBuffer();
		if (!HXUtility.isEmpty(ids)) {
			for (Long id : ids) {
				if (buf.length() > 0) {
					buf.append(delimitStr);
				}
				buf.append(id.toString());
			}
		}
		return buf.toString();
	}

	/**
	 * converts List of Strings to DelimitedString
	 * 
	 * @param ids
	 * @param delimitStr
	 * @return
	 */
	public static String convertListOfStringsToDelimitedString(List<String> strList, String delimitStr) {
		if (strList == null) {
			return null;
		}

		StringBuffer buf = new StringBuffer();
		if (!HXUtility.isEmpty(strList)) {
			for (String str : strList) {
				if (buf.length() > 0) {
					buf.append(delimitStr);
				}
				buf.append(str);
			}
		}
		return buf.toString();
	}

	private static List<Date> numberofYers(Date subscriberCoverageEndDate, Date userSelectedCoverageEndDate) {
		List<Date> numberofYears = new ArrayList<Date>();

		Calendar cal = Calendar.getInstance();
		cal.setTime(subscriberCoverageEndDate);
		int subscriberCoverageEndDateYear = cal.get(Calendar.YEAR);

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(userSelectedCoverageEndDate);
		int userSelectedCoverageEndDateYear = cal1.get(Calendar.YEAR);

		int numberOfYears = userSelectedCoverageEndDateYear - subscriberCoverageEndDateYear;

		if (numberOfYears > 0) {
			for (int year = 0; year < numberOfYears; year++) {
				subscriberCoverageEndDate = HXUtility.lastDayOfYearForDate(subscriberCoverageEndDate);
				subscriberCoverageEndDate = HXUtility.addDays(subscriberCoverageEndDate, 1);
				numberofYears.add(subscriberCoverageEndDate);
			}
			numberofYears.add(userSelectedCoverageEndDate);
		} else {
			numberofYears.add(userSelectedCoverageEndDate);
		}
		return numberofYears;
	}

	/**
	 * Last day of month.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date lastDayOfYearForDate(Date date) {
		int year = getYear(date);
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year + 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DATE, -1);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}
	
	public static Date getInfinityDate() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, 9999);
		cal.set(Calendar.MONTH, 12);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.add(Calendar.DATE, 31);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}

	/**
	 * To determine is this a valid Date String or not.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return boolean true or false status
	 */
	public static boolean isDate2GreaterThanDate1(Date date1, Date date2) {
		boolean result = false;
		try {
			if (date2 != null && date1 != null) {
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(date2);
				cal2.setTime(date1);
				if (cal1.compareTo(cal2) > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * To determine is this a valid Date String or not.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return boolean true or false status
	 */
	public static boolean isDate2EqualToDate1(Date date1, Date date2) {
		boolean result = false;
		try {
			if (date2 != null && date1 != null) {
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(date2);
				cal2.setTime(date1);
				if (cal1.compareTo(cal2) == 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
		}
		return result;
	}

	/**
	 * To determine is this a valid Date String or not.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return boolean true or false status
	 */
	public static boolean isDate2GreaterThanOrEqualToDate1(Date date1, Date date2) {
		boolean result = false;
		try {
			if (date2 != null && date1 != null) {
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(date2);
				cal2.setTime(date1);
				if (cal1.compareTo(cal2) >= 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
		}
		return result;
	}
	
	
	public static boolean isDate2GreaterThanOrEqualToDate1AndDate1CanBeNull(Date date1, Date date2) {
		boolean result = false;
		try {
			
			if (date1 == null && date2!=null) {
				result = true;
			}
			if (date2 != null && date1 != null) {
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(date2);
				cal2.setTime(date1);
				if (cal1.compareTo(cal2) >= 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
		}
		return result;
	}

	/**
	 * Checks if is specific date between two dates.
	 * 
	 * @param date
	 *            the date
	 * @param dateStart
	 *            the date start
	 * @param dateEnd
	 *            the date end
	 * @return true, if is specific date between two dates
	 */
	public static boolean isSpecificDateBetweenTwoDates(Date date, Date dateStart, Date dateEnd) {
		if (date != null && dateStart != null && dateEnd != null) {
			if (date.after(dateStart) && date.before(dateEnd)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * Add number of days to given date.
	 * 
	 * @param date
	 *            the date
	 * @param days
	 *            the days
	 * @return String date MM/dd/yyyy
	 */
	public static String addNoOfDaysToDate(Date date, int days) {
		Date newDate = date;
		Calendar cal = Calendar.getInstance();
		cal.setTime(newDate);
		cal.add(Calendar.DATE, days < 0 ? 0 : days);
		return HXUtility.convertDateToString(new Date(cal.getTimeInMillis()));
	}

	/**
	 * Gets the current month.
	 * 
	 * @return the current month
	 */
	public static String getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		return MONTH_NAMES[cal.get(Calendar.MONTH)];
	}

	public static String getCurrentMonth(int month) {
		return MONTH_NAMES[month];
	}

	/**
	 * Gets the current month for date.
	 * 
	 * @param date
	 *            the date
	 * @return the current month for date
	 */
	public static String getCurrentMonthForDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return MONTH_NAMES[cal.get(Calendar.MONTH)];
	}

	/**
	 * Check if dateToTest is within the range of rangeStartDate and
	 * rangeEndDate.
	 * 
	 * @param dateToTest
	 *            the date to test
	 * @param rangeStartDate
	 *            the range start date
	 * @param rangeEndDate
	 *            the range end date
	 * @return String date MM/dd/yyyy
	 */
	public static boolean isDateWithinGivenRange(Date dateToTest, Date rangeStartDate, Date rangeEndDate) {
		return (!(dateToTest.before(rangeStartDate) || dateToTest.after(rangeEndDate)) || (dateToTest.equals(rangeStartDate) || dateToTest
				.equals(rangeEndDate)));
	}

	/**
	 * Checks if is date available in list.
	 * 
	 * @param effectiveStartDate
	 *            the effective start date
	 * @param eligibleEffectiveStartDateList
	 *            the eligible effective start date list
	 * @return true, if is date available in list
	 */
	public static boolean isDateAvailableInList(Date effectiveStartDate, List<String> eligibleEffectiveStartDateList) {
		if (eligibleEffectiveStartDateList == null || eligibleEffectiveStartDateList.size() == 0) {
			return false;
		}
		Date date = null;
		for (String strDate : eligibleEffectiveStartDateList) {
			date = HXUtility.convertStringToDate(strDate);
			if (date == null) {
				continue;
			}
			if (date.compareTo(effectiveStartDate) == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method returns 012010 by providing Date as input
	 * 
	 * @param month
	 * @return
	 */
	public static String getStringFromDate(Date month) {
		if (!isNull(month)) {
			StringBuffer sf = new StringBuffer();
			String monthStr = String.valueOf(HXUtility.getMonth(month));

			if (!HXUtility.isEmpty(monthStr) && monthStr.length() < 2) {
				sf.append(HXConstants.STR_ZERO);
			}
			sf.append(monthStr);
			sf.append(HXUtility.getYear(month));
			return sf.toString();
		} else {
			return null;
		}
	}

	/**
	 * This method returns January 2010 by providing 012010 as input
	 * 
	 * @param month
	 * @return
	 */
	public static String getStringFromDate(String month) {
		if (!HXUtility.isEmpty(month) && month.length() == 6) {
			String year = month.substring(2, 6);
			String monthDis = month.substring(0, 2);
			Date monDate = HXUtility.convertStringToDate(monthDis + "/" + "01/" + year);
			String sf = HXUtility.getCurrentMonthForDate(monDate) + HXConstants.SPACE + year;
			return sf;
		} else {
			return null;
		}
	}

	/**
	 * This method returns January 2010 by passing Date as input
	 * 
	 * @param month
	 * @return
	 */
	public static String getMonthYearStringFromDate(Date inpDate) {
		if (!isNull(inpDate)) {
			int year = getYear(inpDate);
			String monthDis = getCurrentMonthForDate(inpDate);
			return monthDis + HXConstants.SPACE + year;
		} else {
			return null;
		}
	}

	public static String getParamsWithQuotes(String inputStr) {
		StringBuffer resultStr = new StringBuffer();
		try {
			String[] tokenStr = inputStr.split(HXConstants.DELIMITER_DEFAULT_STRING);
			for (int i = 0; i < tokenStr.length; i++) {
				if (!isEmpty(tokenStr[i])) {
					resultStr.append(HXConstants.COLON);
					resultStr.append(tokenStr[i]);
					resultStr.append(HXConstants.COLON);
					if (i + 1 != tokenStr.length) {
						resultStr.append(HXConstants.DELIMITER_DEFAULT_STRING);
					}
				}
			}
		} catch (Exception exp) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, exp.getMessage());
		}
		return resultStr.toString();
	}

	public static String convertDateTimeToString(Date date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			dateFormat.setLenient(false);
			return dateFormat.format(date);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	/**
	 * This returns if text has only alpha numeric characters.
	 * 
	 * @param text
	 *            Text to be evaluated
	 * @return boolean true or false status
	 */
	public static boolean hasAlphaNumericTextOnly(String text) {
		if (text != null && Pattern.matches(ALPHA_NUMERIC_PATTERN, text))
			return true;
		else
			return false;
	}

	public static String findPreviousMonthYear(String monthYear) {
		String result = null;
		if (isEmpty(monthYear) || monthYear.length() != 6) {
			return result;
		}
		String month = monthYear.substring(0, 2);
		String year = monthYear.substring(2, monthYear.length());
		Date date = convertStringToDate(month + "/" + "01/" + year);
		date = addMonthsToDate(date, -1);
		return getStringFromDate(date);
	}

	public static Date convertMonthYearToDate(String monthYear) {
		if (isEmpty(monthYear) || monthYear.length() != 6) {
			return null;
		}
		String month = monthYear.substring(0, 2);
		String year = monthYear.substring(2, monthYear.length());
		return convertStringToDate(month + "/" + "01/" + year);
	}

	/**
	 * date1 > date2 => +Ve date1 < date2 => -Ve date1 = date2 => 0
	 * 
	 * null considered as less than compared value
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareTo(Date date1, Date date2) {
		if (date1 != null & date2 != null) {
			return date1.compareTo(date2);
		} else if (date1 == null & date2 == null) {
			return 0;
		} else if (date1 == null & date2 != null) {
			return -1;
		} else if (date1 != null & date2 == null) {
			return 1;
		}
		return 0;
	}

	/**
	 * time1 > time2 => +Ve time1 < time2 => -Ve time1 = time2 => 0
	 * 
	 * null considered as less than compared value
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareTo(Time time1, Time time2) {
		if (time1 != null & time2 != null) {
			return time1.compareTo(time2);
		} else if (time1 == null & time2 == null) {
			return 0;
		} else if (time1 == null & time2 != null) {
			return -1;
		} else if (time1 != null & time2 == null) {
			return 1;
		}
		return 0;
	}

	public static boolean isContainsString(String matchString, String actualString) {
		boolean isCodeExists = false;
		if (null != matchString && null != actualString) {
			List<String> codeLists = Arrays.asList(actualString.split(HXConstants.DELIMITER_DEFAULT_STRING));
			for (String code : codeLists) {
				if (matchString.equalsIgnoreCase(code))
					return true;
			}
		}
		return isCodeExists;
	}

	//added for defect 67112 
	//compare two strings delimited with comma
	public static boolean compareStringsWithDelimiter(String stringToCompare,
			String actualString, String delimiter ) {
		boolean isCodeExists = false;
		if (!HXUtility.isEmpty(stringToCompare)   &&  !HXUtility.isEmpty(actualString)) {
			List<String> actualLists = Arrays.asList(actualString
					.split(delimiter));
			List<String> comparingLists = Arrays.asList(stringToCompare
					.split(delimiter));			
			for (String actual : actualLists) {
				for (String comparing : comparingLists) {
					if (comparing.equalsIgnoreCase(actual))
						isCodeExists = true;
				}
			}
		}
		return isCodeExists;
	}
		
	public static boolean getBooleanValue(Boolean param) {
		boolean returnValue = (param != null) ? param.booleanValue() : false;
		return returnValue;
	}

	/**
	 * Created this method to set an infinite date.
	 * 
	 * @return
	 */

	public static Date setInfiniteDate() {

		Calendar cal = Calendar.getInstance();
		cal.set(2999, 11, 31);
		return cal.getTime();
	}

	/**
	 * Convert date to string.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @param Locale
	 *            the language preference selected by user i.e. english or
	 *            spanish
	 * @return String
	 */
	public static String convertDateToLongMonthDayPatterUsingLocale(Date date, String languagePreference) {
		try {
			Locale locale = new Locale(languagePreference, languagePreference.toUpperCase());
			DateFormat dateFormat = null;
			if (locale.getLanguage().equalsIgnoreCase("es")) {
				dateFormat = new SimpleDateFormat(LONGMONTHDAYDATEPATTERN_ES, locale);
			} else {
				dateFormat = new SimpleDateFormat(LONGMONTHDAYDATEPATTERN, locale);
			}
			dateFormat.setLenient(false);
			return dateFormat.format(date);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	public static Timestamp getCurrentTimeStamp() {

		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		return new Timestamp(now.getTime());

	}

	public static String replaceNumbersFromName(String name) {
		return name != null ? name.replaceAll("[^A-Za-z ]", "") : null;
	}

	/**
	 * Remove Numerics and Space from Name
	 * 
	 * @param name
	 */
	public static String removeNumericsAndSpaceFromName(String name) {

		return name != null ? name.replaceAll("[^A-Za-z]", "") : null;
	}
	
	/**
	 * First day of next month for date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	/*
	 * public static Date firstDayOfNextMonthForDate(Date dt) { Calendar cal =
	 * HxDateUtils.convertDateToCalendar(dt); cal.set(Calendar.MONTH,
	 * cal.get(Calendar.MONTH) + 1); cal.set(Calendar.DAY_OF_MONTH, 1); Date
	 * dueDate = new Date(cal.getTimeInMillis()); return dueDate; }
	 */

	/**
	 * Fifteenth day of next month for date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	public static Date fifteenthDayOfNextMonthForDate(Date dt) {
		Calendar cal = HxDateUtils.convertDateToCalendar(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}

	/**
	 * 16th day of next month for date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	public static Date dueDateforNBClock(Date dt) {
		Calendar cal = HxDateUtils.convertDateToCalendar(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DAY_OF_MONTH, 16);
		Date dueDate = new Date(cal.getTimeInMillis());
		return dueDate;
	}

	/**
	 * 16th day of next month for date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	public static Date notificationStartDate(Date date) {
		Calendar cal = HxDateUtils.convertDateToCalendar(date);
		cal.set(Calendar.DAY_OF_MONTH, 16);
		Date notificationStartDate = new Date(cal.getTimeInMillis());
		return notificationStartDate;
	}

	/**
	 * Last day of next month for date.
	 * 
	 * @param date
	 *            the date
	 * @return the date
	 */
	/*
	 * public static Date lastDayOfNextMonthForDate(Date date) { int month =
	 * getMonth(date); int year = getYear(date);
	 * 
	 * Calendar cal = Calendar.getInstance(); cal.clear();
	 * cal.set(Calendar.YEAR, year); cal.set(Calendar.MONTH, month + 1);
	 * cal.set(Calendar.DAY_OF_MONTH, 1); cal.add(Calendar.DATE, -1);
	 * 
	 * Date dueDate = new Date(cal.getTimeInMillis());
	 * 
	 * return dueDate; }
	 */

	/**
	 * Calculate Age of given date of birth, with resect to given referenceDate
	 * 
	 * @param dob
	 *            the dob , refDate
	 * @return the int
	 */
	public static int calculateAgeInMonths(Date dob, Date refDate) {
		// set DOB
		Calendar birthCal = Calendar.getInstance();
		birthCal.setTime(dob);

		// set refDate
		Calendar refCal = Calendar.getInstance();
		refCal.setTime(refDate);

		int age = refCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);

		int diffYear = refCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + refCal.get(Calendar.MONTH) - birthCal.get(Calendar.MONTH);

		return diffMonth;
	}

	/**
	 * Calculate Age of given date of birth, with resect to given referenceDate
	 * 
	 * @param dob
	 *            the dob , refDate
	 * @return the int
	 */
	public static int calculateAgeInYears(Date dob, Date refDate) {
		// set DOB
		int diffMonth = calculateAgeInMonths(dob, refDate);
		int noofYears = diffMonth / 12;
		return noofYears;
	}
	
	/**
	 * Calculate Age of given date of birth, with resect to given referenceDate
	 * 
	 * @param dob
	 *            the dob , refDate
	 * @return the int with extra months 
	 */
	public static int calculateAgeInYearsWithExtraMonths(Date dob, Date refDate) {
		// set DOB
		int diffMonth = calculateAgeInMonths(dob, refDate);
		int noofYears = diffMonth / 12;
		if(diffMonth % 12 > 0){
			noofYears ++;
		}
		return noofYears;
	}

	/**
	 * First day of previous two months for date.
	 * 
	 * @param dt
	 *            the dt
	 * @return the date
	 */
	public static Date firstDayOfPreviousTwoMonthsForDate(Date dt) {
		Calendar cal = HxDateUtils.convertDateToCalendar(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 2);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date dueDate = new Date(cal.getTimeInMillis());
		String dateString = convertDateToString(dueDate);
		return convertStringToDate(dateString);
	}

	/**
	 * Function to add number of days in particular Date Object.
	 * 
	 * @param date
	 *            Date Object
	 * @param days
	 *            number of days
	 * @return the date
	 */
	public static Date getDateByDays(Date date, int days) {
		Calendar cal = HxDateUtils.convertDateToCalendar(date);
		cal.set(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	public static Date getDateByDaysofPreviousMonth(Date date, int days) {
		Calendar cal = HxDateUtils.convertDateToCalendar(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		cal.set(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	/**
	 * To determine is this a valid Date or not.
	 * 
	 * @param string
	 *            the string
	 * @return boolean true or false status
	 */
	public static Date convertStringToDate(String string, DateFormat dateFormat) {
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			dateFormat.setLenient(false);
			return dateFormat.parse(string);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}

	public static Date getOneYearFromCurrentDate() {
		Calendar calDate = getCurrentDateAsCalendar();
		calDate.add(Calendar.YEAR, 1);
		calDate.add(Calendar.SECOND, -1);
		calDate.set(Calendar.HOUR_OF_DAY, 0);
		calDate.set(Calendar.MINUTE, 0);
		calDate.set(Calendar.SECOND, 0);
		calDate.set(Calendar.MILLISECOND, 0);
		return calDate.getTime();
	}

	/**
	 * This function returns true if the strings comparing are both empty or the
	 * string literals are equal
	 * 
	 * @return boolean
	 * @param str1
	 * @param str2
	 * **/
	public static boolean compareString(String str1, String str2) {
		if (HXUtility.isEmpty(str1) && HXUtility.isEmpty(str2))
			return true;
		return org.apache.commons.lang.StringUtils.equalsIgnoreCase(str1, str2);
	}

	public static Boolean isLastDayOfTheMonth(Date date) {

		Date CoverageEndDate = lastDayOfCurrentMonth(date);
		if (date.equals(CoverageEndDate)) {
			return true;
		}
		return false;
	}

	/*
	 * to consider "" && null as same
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		String string1 = "", string2 = "";
		if (!HXUtility.isEmpty(str1)) {
			string1 = str1.trim();
		}
		if (!HXUtility.isEmpty(str2)) {
			string2 = str2.trim();
		}

		return string1.equalsIgnoreCase(string2);
	}

	public static String generateRandonParticipationCode() {
		return getRandomValue(Constants.PC_GEN_MIN_VALUE, Constants.PC_GEN_MAX_VALUE, Constants.PARTICIPATION_CODE_MIN_LENGTH)
				.substring(2);
	}

	public static String getRandomValue(final float lowerBound, final float upperBound, final int decimalPlaces) {
		Random random = new Random();

		if (lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0) {
			throw new IllegalArgumentException("Put error message here");
		}

		final double dbl = ((random == null ? new Random() : random).nextDouble() //
				* (upperBound - lowerBound))
				+ lowerBound;
		return String.format("%." + decimalPlaces + "f", dbl);

	}

	public static String getNoticesAlternativeFormatType(String daiCode) {

		if (HXConstants.DAI_LARGE_PRINT.equals(daiCode)) {
			return HXConstants.DAI_LARGE_PRINT_TXT;
		} else if (HXConstants.DAI_DATA_CD.equals(daiCode)) {
			return HXConstants.DAI_DATA_CD_TXT;
		} else if (HXConstants.DAI_AUDIO_CD.equals(daiCode)) {
			return HXConstants.DAI_AUDIO_CD_TXT;
		} else if (HXConstants.DAI_BRAILLE_YES.equals(daiCode)) {
			return HXConstants.DAI_BRAILLE_TXT;
		} else if (HXConstants.DAI_BRAILLE_NO.equals(daiCode)) {
			return HXConstants.DAI_STANDARD_TXT;
		}
		return null;
	}

	public static Date toUtilDate(Calendar xdate) {

		if (xdate == null)
			return null;
		Date utilDate;
		utilDate = xdate.getTime();
		return utilDate;
	}

	// Defect 45133 rkalkir
	public static boolean isErrorcodeValidforBypassSSNError(String errorCode) {

		boolean bypassSSNErrorCode = false;

		if (HXErrMsgConstants.ERR_FED_HUB_SSN_NOT_VERIFIED_D.equals(errorCode)
				|| HXErrMsgConstants.ERR_FED_HUB_SSN_NOT_VERIFIED_E.equals(errorCode)
				|| HXErrMsgConstants.ERR_FED_HUB_INCR_NOT_VERIFIED_DUE_TO_SSN_FAILURE.equals(errorCode)
				|| HXErrMsgConstants.ERR_FED_HUB_CIT_NOT_VERIFIED_DUE_TO_SSN_FAILURE.equals(errorCode)) {

			bypassSSNErrorCode = true;
		}

		return bypassSSNErrorCode;

	}
	//  CR#1269- Start - added this method to convert SHORTMONTHDAYDATEPATTERN 
	public static String convertDateToShortMonthDayPatterUsingLocale(Date date, String languagePreference) {
		try {
			Locale locale = new Locale(languagePreference, languagePreference.toUpperCase());
			DateFormat dateFormat = null;
			if (locale.getLanguage().equalsIgnoreCase("es")) {
				dateFormat = new SimpleDateFormat(SHORTMONTHDAYDATEPATTERN_ES, locale);
			} else {
				dateFormat = new SimpleDateFormat(SHORTMONTHDAYDATEPATTERN, locale);
			}
			dateFormat.setLenient(false);
			return dateFormat.format(date);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}
	public static byte[] eventXmlCompress(String requestXml, final String compressionStrategy) {
		if (requestXml != null) {
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				GZIPOutputStream goutStream = new GZIPOutputStream(baos){
		            {
		            	if (!HXUtility.isEmpty(compressionStrategy)) {
							if (compressionStrategy.equalsIgnoreCase(HXConstants.COMPRESS_STRATEGY_HUFFMAN)) {
								this.def.setLevel(Deflater.HUFFMAN_ONLY);
							} else if (compressionStrategy.equalsIgnoreCase(HXConstants.COMPRESS_STRATEGY_BESTSPEED)) {
								this.def.setLevel(Deflater.BEST_SPEED);
							} else if (compressionStrategy.equalsIgnoreCase(HXConstants.COMPRESS_STRATEGY_BESTCOMPRESSION)) {
								this.def.setLevel(Deflater.BEST_COMPRESSION);
							} else if (compressionStrategy.equalsIgnoreCase(HXConstants.COMPRESS_STRATEGY_FILTERED)) {
								this.def.setLevel(Deflater.FILTERED);
							} else if (compressionStrategy.equalsIgnoreCase(HXConstants.COMPRESS_STRATEGY_DEFAULTSTRATEGY )) {
								this.def.setLevel(Deflater.DEFAULT_STRATEGY);
							} else if (compressionStrategy.equalsIgnoreCase(HXConstants.COMPRESS_STRATEGY_DEFLATED)) {
								this.def.setLevel(Deflater.DEFLATED);
							} else {
								this.def.setLevel(Deflater.HUFFMAN_ONLY);
							}
						} else {
							this.def.setLevel(Deflater.HUFFMAN_ONLY);
						}
		            	
		            }
		        };
				ObjectOutputStream oosCompressed = new ObjectOutputStream(goutStream);
				oosCompressed.writeObject(requestXml);
				
				oosCompressed.flush();
				oosCompressed.close();
				goutStream.finish();
				
				return baos.toByteArray();
			} catch (Exception ex) {
				logger.error("eventXmlCompress Method Error: "+ex.getMessage());
			}
		}
		return null;
	}
	
	public static String eventXmlDecompress(byte[] compressed)  {
		String eventReqXml = null;
		ObjectInputStream ois = null;
		try {
		
			ByteArrayInputStream is = new ByteArrayInputStream(compressed);
			GZIPInputStream gis = new GZIPInputStream(is);
			ois = new ObjectInputStream(gis);
			eventReqXml = new String((String) ois.readObject());
			
			gis.close();
			is.close();
			
		} catch (Exception ex) {
			logger.error("Event request XML Decompress Method Error: "+ex.getMessage());
		}
		return eventReqXml;
	}
	
	public static String eventXmlCheckSum(byte[] compressRequestXml) {
		StringBuffer checksumStringBuffer = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(HXConstants.SHA_MESSAGE_DIGEST);
			md.update(compressRequestXml);
			byte[] byteData = md.digest();
			if (byteData.length > 0) {
				for (byte b : byteData) {
					checksumStringBuffer.append(String.format("%02x", b & 0xff));
				}
			}
		} catch (Exception ex) {
			logger.error("Event request XML compression CheckSum error " + ex.getMessage());
		}
		
		return checksumStringBuffer.toString();
	}
	
	//Added for the CR 46 Address validation - AddressHistory
		public static String convertDateToStringForAddressHistory(Date date){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy hh:mm aaa");
				String formattedDate = sdf.format(date);
				return formattedDate;
			} catch (Exception e) {
				logger.error(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
				return null;
			}
		}  
	

//  CR#1269- End 
	public static Boolean isSameIssuer(String planHiosId, String planHiosId2){
		Boolean retVal = Boolean.FALSE;
		if(!isEmpty(planHiosId)&&!isEmpty(planHiosId2)){
			//Issuer id is first 5 digit of plan hios id.
			String temp1=planHiosId.substring(0,5);
			String temp2=planHiosId2.substring(0,5);				
			retVal=temp1.equals(temp2);
		}				
		return retVal;
	}		
		
		
		public static String convertStringToDateRetro(String string) {
			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			Date date;
			try {
				date = (Date)formatter.parse(string);
			} catch (ParseException e) {
				logger.error(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
				return null;
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR); 
			return formatedDate;
		}
		
	/**
	 * 
	 * @param strPlanHIOS
	 * @return
	 */
	public static boolean isSNPPlanHIOS(String strPlanHIOS) {
		boolean retVal = false;
		
		if (HXUtility.isEmpty(strPlanHIOS)) {
			return retVal;
		}
		
		if (strPlanHIOS.contains("SN")) {
			retVal = true;
		}
		return retVal;
	}
	
//  CR#1327- get month name in spanish  
	public static String getSpanishTranslationMonthUsingLocale(Date date, String languagePreference) {
		try {
			Locale locale = new Locale(languagePreference, languagePreference.toUpperCase());
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat(MONTHPATTERN_ES, locale);
			dateFormat.setLenient(false);
			return dateFormat.format(date);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}	
	
	// Method to create a complete copy of object.
	// Cloned objects clean up is required if new object needs to be persisted.
	public static Object deepClone(Object source) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(source);

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}
	
	/**
	 * This utility is to give the actual difference between two dates.
	 * 
	 * @param startDate
	 * @param endDate
	 * @param timeUnit
	 * @return
	 */
	public static long getActualDateDiff(Date startDate, Date endDate, TimeUnit timeUnit) {
		long diffInMs = startDate.getTime() - endDate.getTime();

		if (timeUnit == TimeUnit.DAYS)
			return TimeUnit.DAYS.convert(diffInMs, TimeUnit.MILLISECONDS);
		else if (timeUnit == TimeUnit.HOURS)
			return TimeUnit.HOURS.convert(diffInMs, TimeUnit.MILLISECONDS);
		else if (timeUnit == TimeUnit.MINUTES)
			return TimeUnit.MINUTES.convert(diffInMs, TimeUnit.MILLISECONDS);
		else if (timeUnit == TimeUnit.MILLISECONDS)
			return diffInMs;
		else
			throw new HCRuntimeException(MessageCode.GENERIC_ERROR);
	}

	
	/**
	 * 
	 * @param inpDate
	 * @return
	 */
	public static String getMonthYearNameFromDate(Date inpDate) {

		StringBuffer sb = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(inpDate);
		sb.append(new SimpleDateFormat("MMMMM").format(calendar.getTime()))
				.append(" ")
				.append(new SimpleDateFormat("yyyy").format(calendar.getTime()))
				.toString();

		return sb.toString();

	}
	
	//Added for Defect 64820 	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */

	public static boolean isSameMonth(Date date1, Date date2) {
		
		boolean sameMonth=false;
		
		if(date1 != null && date2 != null) {
		
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(date1);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(date2);  
			sameMonth = calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
		}
		return sameMonth;
	}

	//Added for Defect 64820 
	/**
	 * 
	 * @param string
	 * @return
	 */
	public static Date convertStringyyyyToDate(String string) {
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
			dateFormat.setLenient(false);
			return dateFormat.parse(string);
		} catch (Exception e) {
			logger.debug(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return null;
		}
	}
	
	//CR 1117
	public static String effectiveStartDateBefore15th( ) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		int dayOfMonth= calendar.get(Calendar.DAY_OF_MONTH);
		if( dayOfMonth <= 15 ){  //if current day is before 15th, allow immediate next month as effective date
			calendar.setTime(date );
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DATE,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			Date effstartDate = calendar.getTime();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			return format.format(effstartDate);
		}		
		return null;
	}
	/**
	 * Calculate effective date when the current date is after 15th.
	 * Used for Extend Enrollment button display in Employer Overview page 
	 * 
	 */
	public static String effectiveStartDateExtendEnrollment() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		int dayOfMonth= calendar.get(Calendar.DAY_OF_MONTH);
		calendar.setTime(date );
		if( dayOfMonth <= 15 ){  //if current day is before 15th, allow immediate next month as effective date
			calendar.add(Calendar.MONTH, 1);
		}else{
			calendar.add(Calendar.MONTH, 2);
		}
		calendar.set(Calendar.DATE,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date effstartDate = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		return format.format(effstartDate);
	}
	public static String processStr( Object obj ){
	   	return obj == null ? "" : org.apache.commons.lang.StringUtils.trimToEmpty( (String)obj );
	}
	public static String processDateStr( Object obj ){
	   	return obj == null ? "" : HXUtility.convertDateToString((Date) obj );
	}
	public static Date processDate( Object obj ){
	   	return obj == null ? null : (Date) obj;
	}
	public static Long processLong( Object obj ){
	   	return obj == null ? new Long(0) : new Long((Integer) obj);
	}
	public static Integer processInteger( Object obj ){
	   	return obj == null ? 0 : (Integer) obj;
	}
	public static boolean processBoolean( Object obj ){
	   	return obj == null ? false : BooleanUtils.toBoolean((String) obj);
	}
	//CR1117 END
	
	//CR1327
	public static int getWeekOfYear(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int weekOfMonth = cal.get(Calendar.WEEK_OF_YEAR);
		return weekOfMonth;
	}	
	
	public static Date getFifteenDayLogicEligibleDate(Date refDate) {
		Date result = null;
		if (refDate != null) {
			if (HXUtility.getDay(refDate) > 15) {
				return HXUtility.firstDayOfNextToNextMonthForDate(refDate);
			} else {
				return HXUtility.firstDayOfNextMonthForDate(refDate);
			}
		}
		return result;
	}
	public static String getFormattedCurrentDateAndTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Convets milliseconds to time in mm:ss:SSS format
	 * 
	 */
	public static String getTime( long timeInMillis ){
		long diffMilliSeconds = timeInMillis % 60;
		long diffSeconds = timeInMillis / 1000 % 60;
		long diffMinutes = timeInMillis / (60 * 1000) % 60;
		long diffHours = timeInMillis / (60 * 60 * 1000) % 24;
		//long diffDays = timeInMillis / (24 * 60 * 60 * 1000);
		return diffHours + ":" + diffMinutes + ":" + diffSeconds + ":" + diffMilliSeconds; 
	}
}
