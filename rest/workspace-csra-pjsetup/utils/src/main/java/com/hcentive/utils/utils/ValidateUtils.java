/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.beans.PropertyEditor;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import com.hcentive.utils.demographics.DemographicService;
import com.hcentive.utils.demographics.domain.DemographicRules;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.picklistprovider.PickListProvider;

public abstract class ValidateUtils {

	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[-A-Za-z0-9.-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String NAME_PATTERN = "^[a-zA-Z. \\-']*+$";
	private static final String EMP_CODE_PATTERN = "^[a-zA-Z0-9]+$";
	public static final String NAME_PATTERN_15 = "^(?!.{15,})[a-zA-Z. \\-']+$"; // before
																				// the
																				// regex
																				// is
																				// matched,
																				// we
																				// check
																				// the
																				// string
																				// does
																				// not
																				// have
																				// 21
																				// or
																				// more
																				// characters.
	public static final String PHONE_PATTERN_MASKED = "^\\([0-9]{3}\\)[\\s]?[0-9]{3}-[0-9]{4}$";

	private static final String PHONE_PATTERN1 = "^[0-9]{3}$";
	private static final String PHONE_PATTERN2 = "^[0-9]{3}$";
	private static final String PHONE_PATTERN3 = "^[0-9]{4}$";
	private static final String PHONE_EXTENSION = "^[0-9]{1,5}$";
	public static final String PHONE_PATTERN = "^[0-9]{10}$";

	public static final String NUMERIC = "^[0-9]+$";

	public static final String SSN_PATTERN_HYPHENATED = "^\\d{3}-\\d{2}-\\d{4}$";

	public static final String SSN_PATTERN = "^\\d{9}$";

	public static final String ZIP_PATTERN = "^\\d{5}$";

	public static final String ALPHANUMERIC_SPACE_SPECIALCHARS = "^[a-zA-Z., \\-']+$";

	public static final String ALPHANUMERIC_SPACE_SPECIALCHARS_OPTIONAL = "^[a-zA-Z0-9., \\-']*$";

	public static final String ALPHANUMERIC_SPACE_SPECIALCHARS_MANDATORY = "^[a-zA-Z0-9., \\-']+$";

	public static final String ALPHANUMERIC_SPACE = "^[a-zA-Z0-9\\s]*+$";

	public static final String ALPHANUMERIC = "^[a-zA-Z0-9]*$";

	public static final String ALPHANUMERIC_MANDATORY = "^[a-zA-Z0-9]+$";

	public static final String ALPHANUMERIC_OPTIONAL = "^[a-zA-Z0-9]*$";

	public static final String ALPHA_OPTIONAL = "^[a-zA-Z]*$";

	public static final String ALPHA_MANDATORY = "^[a-zA-Z]+$";

	public static final String PASSWORD_PATTERN = "(?!.*[\\s])+^.*(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$";

	public static final String HOUR_PATTERN24 = "([01]?[0-9]|2[0-3])[0-5][0-9]";

	public static final String URL_PATTERN = "^((http|https)://)?[a-zA-Z]{0,3}\\.?[a-zA-Z0-9\\-]+\\.[a-zA-Z]+$";

	@Autowired
	private PickListProvider pickListProvider;

	@Autowired
	private DemographicService demographicService;

	@Autowired
	private ValidatorFactory validator;

	public static boolean validatePattern(String pattern, String arg) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(arg);
		return m.find();
	}

	public static boolean validateDob(Date dob) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dob);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		if (cal.compareTo(cal2) < 0) {
			return true;
		}
		return false;
	}

	public static boolean validateAlpha(String arg) {
		return validatePattern(NAME_PATTERN, arg);
	}

	public static boolean validateEmpCode(String arg) {
		return validatePattern(EMP_CODE_PATTERN, arg);
	}

	public static boolean validateName(String arg) {
		return validatePattern(NAME_PATTERN_15, arg);
	}

	public static boolean validateEmail(String arg) {
		return validatePattern(EMAIL_PATTERN, arg);
	}

	public static boolean validatePhone(String arg) {
		if (arg.indexOf("(") != -1 || arg.indexOf(")") != -1 || arg.indexOf("-") != -1) {
			return validatePattern(PHONE_PATTERN_MASKED, arg);
		}
		return validatePattern(PHONE_PATTERN, arg);

	}

	public static boolean validatePhone1(String arg) {
		return validatePattern(PHONE_PATTERN1, arg);
	}

	public static boolean validatePhone2(String arg) {
		return validatePattern(PHONE_PATTERN2, arg);
	}

	public static boolean validatePhone3(String arg) {
		return validatePattern(PHONE_PATTERN3, arg);
	}

	public static boolean validatePhoneExtension(String arg) {
		return validatePattern(PHONE_EXTENSION, arg);
	}

	public static boolean validateSSN(String arg) {
		if (arg.indexOf("-") != -1) {
			return validatePattern(SSN_PATTERN_HYPHENATED, arg);
		}
		return validatePattern(SSN_PATTERN, arg);
	}

	public static boolean checkESignature(String firstName, String middleName, String lastName, String esignature) {

		final String fName = StringUtils.hasText(firstName) ? firstName : "";
		final String lName = StringUtils.hasText(lastName) ? lastName : "";

		if ((fName + " " + lName).equals(esignature)) {
			return true;
		} else if (StringUtils.hasText(middleName) && (fName + " " + middleName + " " + lName).equals(esignature)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateFromPickList(String pickListCode, String value) {
		Map<String, String> pickList = pickListProvider.getPickList(pickListCode);
		Collection<String> keySet = pickList.keySet();
		return keySet.contains(value);
	}

	public String validateZipCountyState(String zip, String county, String state) throws HCException {
		if (StringUtils.hasText(zip)) {
			List<String> countyList = demographicService.getCountiesByZip(zip);
			if ((countyList == null || countyList.isEmpty())) {
				return "zip";
			}
			if ((StringUtils.hasText(county) && !countyList.contains(county))) {
				return "county";
			}
			DemographicRules demographicRules = demographicService.getDemographicRules(zip, county);
			String stateCode = demographicRules.getStateCode();
			if (!StringUtils.hasText(stateCode) || (StringUtils.hasText(state) && !stateCode.equalsIgnoreCase(state))) {
				return "state";
			}

		}
		return null;
	}

	/**
	 * The method is used to validate Constraints defined on the object using
	 * annotation It adds the errors from constraint validation to the passed
	 * Errors object It is used when the constraint can not be validated using
	 * the @Validated annotation in the controller
	 * 
	 * @param errors
	 * @param obj
	 * @param name
	 * @param groups
	 */
	public void addGroupValidationErrors(Errors errors, Object obj, String name, Object... groups) {
		Validator springValidatorAdapter = new SpringValidatorAdapter(validator.getValidator());
		DataBinder binder = new DataBinder(obj, name);
		binder.setValidator(springValidatorAdapter);
		binder.validate(groups);
		BindingResult bindingResult = binder.getBindingResult();
		errors.addAllErrors(bindingResult);
	}

	/**
	 * Used when custom validator is not defined for the object and only
	 * constraints defined using annotations have to be validated
	 * 
	 * @param obj
	 * @param name
	 * @param groups
	 * @return
	 */
	public BindingResult validateGroupConstraints(Object obj, String name, Object... groups) {
		Validator springValidatorAdapter = new SpringValidatorAdapter(validator.getValidator());
		DataBinder binder = new DataBinder(obj, name);
		binder.setValidator(springValidatorAdapter);
		binder.validate(groups);
		return binder.getBindingResult();
	}

	/**
	 * Used to validate an Object using both a custom validator & the annotation
	 * constraints
	 * 
	 * @param customValidator
	 * @param obj
	 * @param name
	 * @param groups
	 * @return
	 */
	public BindingResult validateCustomAndGroupConstraints(Validator customValidator, Object obj, String name, Object... groups) {
		DataBinder binder = new DataBinder(obj, name);
		binder.setValidator(customValidator);
		binder.validate();
		BindingResult result = binder.getBindingResult();

		binder = new DataBinder(obj, name);
		Validator springValidatorAdapter = new SpringValidatorAdapter(validator.getValidator());
		binder.setValidator(springValidatorAdapter);
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.validate(groups);
		BindingResult constraintResult = binder.getBindingResult();
		result.addAllErrors(constraintResult);
		return result;
	}
}
