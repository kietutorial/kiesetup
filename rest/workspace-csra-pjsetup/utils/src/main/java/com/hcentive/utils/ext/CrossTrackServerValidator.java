package com.hcentive.utils.ext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.hcentive.utils.demographics.DemographicService;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.utils.ValidateUtils;

/**
 * The Class CrossTrackServerValidator.
 * 
 * @author Gopinath Kuppuswamy, gmekala
 */
public class CrossTrackServerValidator {
	private static Logger logger = LoggerFactory.getLogger(CrossTrackServerValidator.class);

	/** The Constant EMAIL_PATTERN. */
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[-A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/** The Constant USER_NAME_PATTERN. */
	private static final String USER_NAME_PATTERN = "^[a-zA-Z0-9-_]{6,20}$";

	/** The Constant PASSWORD_PATTERN. */
	private static final String PASSWORD_PATTERN = "((?!.*[\\W\\_])+^.*(?=.{8,16})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$)";

	/** The Constant SECURITY_QUESTION_ANSWER_PATTERN. */
	// private static final String SECURITY_ANSWER = "^[a-zA-Z0-9\\s-_]+$";
	private static final String SECURITY_ANSWER = "^[a-zA-Z]+$";

	/** The Constant NAME_PATTERN. */
	//public static final String NAME_PATTERN = "[a-zA-Z -,.']+"; //laetst 
	//private static final String NAME_PATTERN = "^(?=.*[a-zA-Z.,-])[^~|\\*\\^]*[^\\x27]*[\\x00-\\x1F]*[\\x7f]*$";
	//private static final String NAME_PATTERN = "^[a-zA-Z]+[a-zA-Z-\\x27]*?[a-zA-Z-\\x27]+$"; //X27
	private static final String NAME_PATTERN = "^[A-Za-z\\s,.'-]+$";
	//public static final String NAME_PATTERN = "^[A-Za-z]+[A-Za-z'\\-]*( [A-Za-z '\\-]+)*$";
	/** The Constant ADDRESS_LINE_1_OR_2_PATTERN. */
	//private static final String ADDRESS_LINE_1_OR_2_PATTERN = "^[a-zA-Z0-9\\s]+$";
	//private static final String ADDRESS_LINE_1_OR_2_PATTERN = "^[^\\s][@!#%&\\s]*([a-zA-Z0-9 ])+[@!#%&\\s]*[^\\s]$";
	//private static final String ADDRESS_LINE_1_OR_2_PATTERN = "^(?=.*[a-zA-Z0-9])[^~|]*[^\\x2A]*[^\\x94][^\\x00-\\u1F]*[^\\x7F]*$";
	private static final String ADDRESS_LINE_1_OR_2_PATTERN = "^(?=.*[a-zA-Z\\d])[^~|\\*\\^]*[\\x00-\\x1F]*[\\x7f]*$";
	
	/** The Constant CITY_PATTERN. */
	private static final String APT_PATTERN = "^[A-Za-z0-9]*$";
	
	/** The Constant CITY_PATTERN. */
	private static final String CITY_PATTERN = "^[a-zA-Z0-9](?:[a-zA-Z0-9 ]*[a-zA-Z0-9])?$";
	//private static final String CITY_PATTERN ="^[A-Za-z]+[A-Za-z ]*[A-Za-z]+$";
	
	/** The Constant ZIP_PATTERN. */
	private static final String ZIP_PATTERN = "^\\d{5}$";

	/** The Constant DATE_PATTERN. */
	private static final String DATE_PATTERN = "^(\\d{1,2})(\\/|-)(\\d{1,2})(\\/|-)(\\d{4})$";
	
	/** The Constant RECEIPT_NUMBER_PATTERN. */
	private static final String RECEIPT_NUMBER_PATTERN = "^[A-Za-z]{3}[0-9]{10}$";

	/** The Constant ALPHANUMERIC_PATTERN. */
	private static final String ALPHANUMERIC_PATTERN = "^[A-Za-z0-9]*$";
	
	/** The Constant POLICY_NUMBER_PATTERN. */
	private static final String POLICY_NUMBER_PATTERN = "^[A-Za-z]{3}[0-9]{9}$";
	
	private static final String EMPLOYER_NAME_PATTERN = "^[A-Za-z0-9\\s,.'-]+$";
	
	/** The Constant DRIVERID_PATTERN. */
	private static final String DRIVERID_PATTERN = "^\\d{9}$";
	
	/** The Constant CIN_PATTERN. */
	private static final String CIN_PATTERN = "^[A-Z]{2}[0-9]{5}[A-Z]{1}$";	
	
	/** The Constant HIX_PATTERN. */
	private static final String HIX_PATTERN = "^[A-Z]{2}[0-9]{10}$";	
	
	/** The demographic service. */
	@Autowired
	private static DemographicService demographicService;
	
	/**
	 * This function is used to validate the employer name
	 * 
	 * @param firstName
	 *            the first name
	 * @return true, if successful
	 */
	public static boolean validateEmployerName(String employerName) {

		boolean isValid = true;
		
		employerName = StringUtils.replace(employerName, "&#x27;", "'");
		
		if (!ValidateUtils.validatePattern(EMPLOYER_NAME_PATTERN, employerName)) {
			isValid = false;
		}
		
		return isValid;

	}
	
	/**
	 * Checks if is empty.
	 * 
	 * @param str
	 *            the str
	 * @return true, if is empty
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().equals(""))
			return true;
		else
			return false;
	}

	/**
	 * This function is used to validate the first name
	 * 
	 * @param firstName
	 *            the first name
	 * @return true, if successful
	 */
	public static boolean validateFirstName(String firstName) {

		boolean isValid = true;
		
		firstName = StringUtils.replace(firstName, "&#x27;", "'");
		
		if (!ValidateUtils.validatePattern(NAME_PATTERN, firstName)) {
			isValid = false;
		}
		
		return isValid;

	}

	/**
	 * This function is used to validate the middle name
	 * 
	 * @param middleName
	 * @return
	 */
	public static boolean validateMiddleName(String middleName) {

		boolean isValid = true;
		
		middleName = StringUtils.replace(middleName, "&#x27;", "'");

		if (!ValidateUtils.validatePattern(NAME_PATTERN, middleName)) {
			isValid = false;
		}

		return isValid;

	}

	/**
	 * This function is used to validate the last name
	 * 
	 * @param lastName
	 *            the last name
	 * @return true, if successful
	 */
	public static boolean validateLastName(String lastName) {

		boolean isValid = true;
		
		lastName = StringUtils.replace(lastName, "&#x27;", "'");

		if (!ValidateUtils.validatePattern(NAME_PATTERN, lastName)) {
			isValid = false;
		}

		return isValid;

	}

	/**
	 * This function is used to validate the address line1.
	 * 
	 * @param addressLine1
	 *            the address line1
	 * @return true, if successful
	 */
	public static boolean validateAddressLine1(String addressLine1) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(ADDRESS_LINE_1_OR_2_PATTERN, addressLine1)) {
			isValid = false;
		}

		return isValid;

	}

	/**
	 * This function is used to validate the address line2.
	 * 
	 * @param addressLine2
	 *            the address line2
	 * @return true, if successful
	 */
	public static boolean validateAddressLine2(String addressLine2) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(ADDRESS_LINE_1_OR_2_PATTERN, addressLine2)) {
			isValid = false;
		}

		return isValid;

	}
	
	/**
	 * This function is used to validate the city.
	 * 
	 * @param city
	 *            the city
	 * @return true, if successful
	 */
	public static boolean validateAptSuite(String aptSuite) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(APT_PATTERN, aptSuite)) {
			isValid = false;
		}

		return isValid;

	}

	/**
	 * This function is used to validate the city.
	 * 
	 * @param city
	 *            the city
	 * @return true, if successful
	 */
	public static boolean validateCity(String city) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(CITY_PATTERN, city)) {
			isValid = false;
		}

		return isValid;

	}

	/**
	 * This function is used to validate the zip code.
	 * 
	 * @param zipCode
	 *            the zip code
	 * @return true, if successful
	 */
	public static boolean validateZipCode(String zipCode) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(ZIP_PATTERN, zipCode)) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the county.
	 * 
	 * @param county
	 *            the county
	 * @return true, if successful
	 */
	public static boolean validateCounty(String zip, String county) {
		boolean isValid = true;

		List<String> countyList = null;
		try {
			countyList = demographicService.getCountiesByZip(zip);
		} catch (HCException e) {
			// TODO Auto-generated catch block
			logger.error("EXCEPTION", e);
			//e.printStackTrace();
		}
		if (!countyList.contains(county)) {

			isValid = false;
		}

		return isValid;

	}

	/**
	 * This function is used to validate the state.
	 * 
	 * @param state
	 *            the state
	 * @return true, if successful
	 */
	public static boolean validateState(String state) {
		boolean isValid = true;

		if (isEmpty(state)) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the phone number1.
	 * 
	 * @param phoneNumber
	 *            the phone number
	 * @return true, if successful
	 */
	public static boolean validatePhoneNumberField1(String phoneNumber1) {
		boolean isValid = true;

		if (!ValidateUtils.validatePhone1(phoneNumber1)) {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * This function is used to validate the phone number2
	 * 
	 * @param phoneNumber2
	 * @return
	 */
	public static boolean validatePhoneNumberField2(String phoneNumber2) {
		boolean isValid = true;

		if (!ValidateUtils.validatePhone2(phoneNumber2)) {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * This function is used to validate the phone number3
	 * 
	 * @param phoneNumber3
	 * @return
	 */
	public static boolean validatePhoneNumberField3(String phoneNumber3) {
		boolean isValid = true;

		if (!ValidateUtils.validatePhone3(phoneNumber3)) {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * This function is used to validate the phone extension.
	 * 
	 * @param phoneExtension
	 *            the phone extension
	 * @return true, if successful
	 */
	public static boolean validatePhoneExtension(String phoneExtension) {
		boolean isValid = true;

		if (!ValidateUtils.validatePhoneExtension(phoneExtension)) {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * This function is used to validate the phone type.
	 * 
	 * @param phoneType
	 *            the phone type
	 * @return true, if successful
	 */
	public static boolean validatePhoneType(String phoneType) {
		boolean isValid = true;

		if (isEmpty(phoneType)) {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * This function is used to validate the ssn.
	 * 
	 * @param ssn
	 *            the ssn
	 * @return true, if successful
	 */
	public static boolean validateSSN(String ssn) {
		boolean isValid = true;

		if (!SSNValidator.isSsnValid(ssn)) {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * This function is used to validate the date.
	 * 
	 * @param date
	 *            the date
	 * @return true, if successful
	 */
	public static boolean validateDate(String date) {
		boolean isValid = true;

		if (!HXUtility.isValidDate(date)) {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * This function is used to validate the date.
	 * 
	 * @param mm
	 * @param dd
	 * @param yyyy
	 * @return
	 */
	public static boolean validateDateMMDDYYYY(String mm, String dd, String yyyy) {
		boolean isValid = true;

		if (!HXUtility.isValidDate(mm, dd, yyyy)) {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * This function is used to validate the email.
	 * 
	 * @param email
	 *            the email
	 * @param confirmEmail
	 *            the confirm email
	 * @return true, if successful
	 */
	public static boolean validateEmail(String email, String confirmEmail) {
		boolean isValid = true;

		if (StringUtils.hasLength(email)) {
			if (!ValidateUtils.validatePattern(EMAIL_PATTERN, email)) {
				isValid = false;
			} else if (StringUtils.hasLength(confirmEmail) && !email.equals(confirmEmail)) {
				isValid = false;
			}

		}

		return isValid;
	}

	/**
	 * This function is used to validate the username.
	 * 
	 * @param userName
	 *            the user name
	 * @return true, if successful
	 */
	public static boolean validateUsername(String userName) {
		boolean isValid = true;
		if (StringUtils.hasLength(userName)) {
			if (!ValidateUtils.validatePattern(USER_NAME_PATTERN, userName)) {
				isValid = false;
			}
		}

		return isValid;
	}

	/**
	 * Validate password.
	 * 
	 * @param password
	 *            the password
	 * @param confirmPassword
	 *            the confirm password
	 * @return true, if successful
	 */
	public static boolean validatePassword(String password, String confirmPassword, String userName) {
		boolean isValid = true;

		if (StringUtils.hasLength(password) && StringUtils.hasLength(confirmPassword)) {
			if (!ValidateUtils.validatePattern(PASSWORD_PATTERN, password)) {
				isValid = false;
			} else if (StringUtils.hasLength(confirmPassword) && !confirmPassword.equals(password)) {
				isValid = false;
			}
		} else if (StringUtils.hasLength(password)) {
			if (!ValidateUtils.validatePattern(PASSWORD_PATTERN, password)) {
				isValid = false;
			} else if ((password.equalsIgnoreCase(userName) || password.contains(userName.substring(0, 3)))) {
				isValid = false;
			} else if (password.length() > HXErrMsgConstants.RESET_PASSWORD_MAX_LENGTH) {
				isValid = false;
			}

		} else if (StringUtils.hasLength(confirmPassword)) {
			if (!ValidateUtils.validatePattern(PASSWORD_PATTERN, confirmPassword)) {
				isValid = false;
			} else if (confirmPassword.length() > HXErrMsgConstants.RESET_PASSWORD_MAX_LENGTH) {
				isValid = false;
			}
		}

		return isValid;
	}


	public static boolean validatePasswordOrConfirmPasswordAlone(String password) {
		boolean isValid = true;
		if (StringUtils.hasText(password) && !ValidateUtils.validatePattern(PASSWORD_PATTERN, password)) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean validateUserNamePasswordMatch(String password, String userName) {
		boolean isValid = true;
		if ((password.equalsIgnoreCase(userName) || password.contains(userName.substring(0, 3)))) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean validatePasswordOrConfirmPasswordLength(String password) {
		boolean isValid = true;
		if (password.length() > HXErrMsgConstants.RESET_PASSWORD_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean validatePasswordMatch(String password, String confirmPassword) {
		boolean isValid = true;
		if (StringUtils.hasLength(confirmPassword) && !confirmPassword.equals(password)) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the AddressLine and city.
	 * 
	 * @param addressLine1
	 * @return
	 */
	public static boolean validateAddressLineAndCity_MinLength(String addressLine1) {
		boolean isValid = true;
		if (!addressLine1.isEmpty()) {
			if (addressLine1.length() < 2) {
				isValid = false;
			}

		}

		return isValid;

	}

	/**
	 * This function is used to validate first name length
	 * 
	 * @param firstName
	 * @return
	 */
	public static boolean validateFirstNameLength(String firstName) {
		boolean isValid = true;
		if (!isEmpty(firstName) && firstName.length() > HXErrMsgConstants.FIRST_NAME_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * This function is used to validate first name length
	 * 
	 * @param firstName
	 * @return
	 */
	public static boolean validateFirstNameLengthOther(String firstName) {
		boolean isValid = true;
		if (!isEmpty(firstName) && firstName.length() > HXErrMsgConstants.FIRST_NAME_MAX_LENGTH_OTHER) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate middle name length
	 * 
	 * @param middleName
	 * @return boolean
	 */
	public static boolean validateMiddleNameLength(String middleName) {
		boolean isValid = true;
		if (!isEmpty(middleName) && middleName.length() > HXErrMsgConstants.MIDDLE_NAME_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate last name length
	 * 
	 * @param lastName
	 * @return
	 */
	public static boolean validateLastNameLength(String lastName) {
		boolean isValid = true;
		if (!isEmpty(lastName) && lastName.length() > HXErrMsgConstants.LAST_NAME_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the phone number length
	 * 
	 * @param phoneNumberLeangth
	 * @return
	 */
	public static boolean validatePhoneNumberLength(int phoneNumberLeangth) {
		boolean isValid = true;
		if (phoneNumberLeangth > HXConstants.PHONE_NUMBER_MIN_LENGTH && phoneNumberLeangth < HXConstants.PHONE_NUMBER_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the phone number extension length
	 * 
	 * @param phoneNumberExtnLength
	 * @return
	 */
	public static boolean validatePhoneNumberExtnLength(int phoneNumberExtnLength) {
		boolean isValid = true;
		if (phoneNumberExtnLength > HXConstants.PHONE_NUMBER_EXTENSION_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the additional phone number1 length
	 * 
	 * @param addlPhoneNumOneLength
	 * @return
	 */
	public static boolean validateAddlPhoneNumOneLength(int addlPhoneNumOneLength) {
		boolean isValid = true;
		if (addlPhoneNumOneLength != HXConstants.PHONE_NUMBER_ONE_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the additional phone number2 length
	 * 
	 * @param addlPhoneNumTwoLength
	 * @return
	 */
	public static boolean validateAddlPhoneNumTwoLength(int addlPhoneNumTwoLength) {
		boolean isValid = true;
		if (addlPhoneNumTwoLength != HXConstants.PHONE_NUMBER_TWO_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the additional phone number3 length
	 * 
	 * @param addlPhoneNumThreeLength
	 * @return
	 */
	public static boolean validateAddlPhoneNumThreeLength(int addlPhoneNumThreeLength) {
		boolean isValid = true;
		if (addlPhoneNumThreeLength != HXConstants.PHONE_NUMBER_THREE_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the address line length
	 * 
	 * @param addressLineOneLen
	 * @return
	 */
	public static boolean validateAddressLineLength(int addressLineOneLen) {
		boolean isValid = true;
		if (addressLineOneLen > HXErrMsgConstants.STREET_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * This function is used to validate the apt or suite line length
	 * 
	 * @param aptSuiteLen
	 * @return
	 */
	public static boolean validateAptSuiteLength(int aptSuiteLen) {
		boolean isValid = true;
		if (aptSuiteLen > HXErrMsgConstants.APT_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate city length
	 * 
	 * @param cityLen
	 * @return
	 */
	public static boolean validateCityLength(int cityLen) {
		boolean isValid = true;
		if ((cityLen > HXErrMsgConstants.CITY_MAX_LENGTH) || (cityLen < HXErrMsgConstants.CITY_MIN_LENGTH)) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the zip length
	 * 
	 * @param zipLen
	 * @return
	 */
	public static boolean validateZipLength(int zipLen) {
		boolean isValid = true;
		if (zipLen != HXErrMsgConstants.ZIP_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the state length
	 * 
	 * @param stateLength
	 * @return
	 */
	public static boolean validateStateLength(int stateLength) {
		boolean isValid = true;
		if (stateLength != HXErrMsgConstants.STATE_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the date format
	 * 
	 * @param date
	 * @return
	 */
	public static boolean validateDateFormat(String date) {
		boolean isValid = true;
		if (!ValidateUtils.validatePattern(DATE_PATTERN, date)) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * To determine is this a valid Date String or not.
	 * 
	 * @param date
	 *            Date String in MM/DD/YYYY.
	 * 
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
			logger.error(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * This function is used to validate the primary phone number.
	 * 
	 * @param phNumber1
	 * @param phNumber2
	 * @param phNumber3
	 * @return
	 */
	public static boolean phoneNumberValiditityChk(String phNumber1, String phNumber2, String phNumber3) {
		boolean isValid = true;
		if (!isEmpty(phNumber1) || !isEmpty(phNumber2) || !isEmpty(phNumber3)) {
			if (!HXUtility.isNumeric(phNumber1) || phNumber1.trim().length() != 3) {
				isValid = false;
			} else if (!HXUtility.isNumeric(phNumber2) || phNumber2.trim().length() != 3) {
				isValid = false;
			} else if (!HXUtility.isNumeric(phNumber3) || phNumber3.trim().length() != 4) {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * This function is used to validate the county length
	 * 
	 * @param county
	 * @return
	 */
	public static boolean validateCountyLength(String county) {
		boolean isValid = true;
		if (!isEmpty(county) && county.length() != HXErrMsgConstants.COUNTY_CODE_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the zip
	 * 
	 * @param zip
	 * @return
	 */
	public static boolean isZipNumeric(String zip) {
		boolean isValid = true;
		if (!HXUtility.isNumeric(zip)) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the user name length
	 * 
	 * @param username
	 * @return
	 */
	public static boolean validateUserNameLength(String username) {
		boolean isValid = true;
		if (username.length() < HXErrMsgConstants.USER_NAME_MIN_LENGTH
				|| username.length() > HXErrMsgConstants.USER_NAME_MAX_LENGTH) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the email address
	 * 
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email) {
		boolean isValid = true;

		if (StringUtils.hasText(email)) {
			if (!ValidateUtils.validatePattern(EMAIL_PATTERN, email)) {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * This function is used to validate the security question answer.
	 * 
	 * @param securityQuestionAnswer
	 * @return
	 */
	public static boolean validateSecurityQuestionAnswer(String securityQuestionAnswer) {
		boolean isValid = true;

		if (!isEmpty(securityQuestionAnswer)) {
			if (!ValidateUtils.validatePattern(SECURITY_ANSWER, securityQuestionAnswer)) {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * This function is used to validate the security question answer length.
	 * 
	 * @param securityQuestionAnswer
	 * @return
	 */
	public static boolean validateSecurityQuestionAnswerLength(String securityQuestionAnswer) {
		boolean isValid = true;

		if (!isEmpty(securityQuestionAnswer)) {
			if (securityQuestionAnswer.length() < HXErrMsgConstants.SECRET_ANSWER_MIN_LENGTH
					|| securityQuestionAnswer.length() > HXErrMsgConstants.SECRET_ANSWER_MAX_LENGTH) {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * This function is used to validate the same security question answers.
	 * 
	 * @param answerOne
	 * @param answerTwo
	 * @return
	 */
	public static boolean validateSameSecurityQuestionAnswers(String answerOne, String answerTwo) {
		boolean isValid = true;

		if (answerOne != null && answerTwo != null && answerOne.equals(answerTwo)) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This function is used to validate the last password change time.
	 * 
	 * @param lastPasswordChangeTime
	 * @return
	 */
	public static boolean validateLastPasswordChangeTime(Date lastPasswordChangeTime) {
		boolean isValid = true;
		if (lastPasswordChangeTime != null && !isLastPasswordChangeTime(lastPasswordChangeTime)) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * To determine is the Date difference is atleast 2 days or not.
	 * 
	 * @param date
	 *            Date lastPasswordChangeTime
	 * 
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

			if (diffDays > 2) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.error(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}

	/**
	 * This function is used to validate the Receipt Number
	 * 
	 * @param receipt number
	 * @return
	 */
	public static boolean isValidReceiptNumber(String value) {
		boolean isValid = true;
		if (!ValidateUtils.validatePattern(RECEIPT_NUMBER_PATTERN, value)) {
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * This function is used to validate the AlphaNumeric Number
	 * 
	 * @param receipt number
	 * @return
	 */
	public static boolean isValidAlphaNumericNumber(String value) {
		boolean isValid = true;
		if (!ValidateUtils.validatePattern(ALPHANUMERIC_PATTERN, value)) {
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * This function is used to validate the Policy Number
	 * 
	 * @param policy  number
	 * @return
	 */
	public static boolean isValidPolicyNumber(String value) {
		boolean isValid = true;
		if (!ValidateUtils.validatePattern(POLICY_NUMBER_PATTERN, value)) {
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * To determine is whether Date String is current date or not.
	 * 
	 * @param date
	 *            Date String in MM/DD/YYYY.
	 * 
	 * @return boolean true or false status
	 */
	public static boolean isCurrentDateOrFutureDate(String mm, String dd, String yyyy) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();

			cal1.setTime(dateFormat.parse(mm + "/" + dd + "/" + yyyy));
			cal2.setTime(dateFormat.parse(dateFormat.format(cal2.getTime())));

			if (cal1.equals(cal2) || cal1.after(cal2)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.error(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
	}
	
	
	public static boolean isWithInSixMonths(String mm, String dd, String yyyy) 
    {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(dateFormat.parse(mm + "/" + dd + "/" + yyyy));
	        int year1 = cal1.get(Calendar.YEAR);
	        int month1 = cal1.get(Calendar.MONTH);
	
	        Calendar cal2 = Calendar.getInstance();
			int year2 = cal2.get(Calendar.YEAR);
	        int month2 = cal2.get(Calendar.MONTH);
	        
	        if (!isFutureDate(mm, dd, yyyy) && (((year2 * 12 + month2) - (year1 * 12 + month1)) <= 6) ) {
	            return true;
	        }
	        return false;
		} catch (Exception e) {
			logger.error(HXLogMsgConstants.LOG_ERROR_CO_UTILITY_FUNCTION_FAILED, e.getMessage());
			return false;
		}
    }
	
	public static int getAgeinDays(Date dob) {
					
			return Days.daysBetween(new DateMidnight(dob.getTime()), new DateMidnight(Calendar.getInstance().getTime())).getDays() ;
	}
	
	
	public static int getAgeinDaysOnRunDate(Date dob, Date effectiveDate) {
		// Create a calendar object with today's date
		Calendar today = Calendar.getInstance();
		today.setTime(effectiveDate);
		
		return Days.daysBetween(new DateMidnight(dob.getTime()), new DateMidnight(today.getTime())).getDays() ;
	}
	
	
	/**
	 * This function is used to validate the ITIN.
	 * 
	 * @param itin
	 *            the itin
	 * @return true, if successful
	 */
	public static boolean validateITIN(String itin) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(ValidateUtils.SSN_PATTERN, itin)) {
			isValid = false;
		}

		return isValid;
	}
	
	
	/**
	 * This function is used to validate the Numeric Driver id
	 * 
	 * @param zipCode
	 *            the zip code
	 * @return true, if successful
	 */
	public static boolean validateDriverId(String driverId) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(DRIVERID_PATTERN, driverId)) {
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * This function is used to validate the CIN NUMBER
	 * 
	 * @param zipCode
	 *            the zip code
	 * @return true, if successful
	 */
	public static boolean validateCinNumber(String cinNumber) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(CIN_PATTERN, cinNumber)) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean validateHixId(String hixid) {
		boolean isValid = true;

		if (!ValidateUtils.validatePattern(HIX_PATTERN, hixid)) {
			isValid = false;
		}
		return isValid;
	}
	
	public static void main(String args[]) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dt = df.parse("07/02/2013");
		System.out.println( getAgeinDays(dt) );		
	}
	
	public static boolean isDateWithinPastYrs(String yyyy, String noOfYrs) {
		int inputStartDtYear = 0;
		int numYrs = 0;
		
		Calendar today = Calendar.getInstance();
		int currentYear = today.get(Calendar.YEAR);
		
		if(!HXUtility.isNull(yyyy)){
			inputStartDtYear = Integer.parseInt(yyyy);
		}
		
		if(!HXUtility.isNull(noOfYrs)){
			numYrs = Integer.parseInt(noOfYrs);
		}
		
		int age = currentYear - inputStartDtYear;
        
		if (age > numYrs) {
			return false;
		}
		return true;
	}
	
	public static boolean isDateWithinFutureYrs(String yyyy, String noOfYrs) {
		int inputEndDtYear = 0;
		int numYrs = 0;
		
		Calendar today = Calendar.getInstance();
		int currentYear = today.get(Calendar.YEAR);
		
		if(!HXUtility.isNull(yyyy)){
			inputEndDtYear = Integer.parseInt(yyyy);
		}
		
		if(!HXUtility.isNull(noOfYrs)){
			numYrs = Integer.parseInt(noOfYrs);
		}
		
		int age = inputEndDtYear - currentYear;
        
		if (age > numYrs) {
			return false;
		}
		return true;
	}
}
