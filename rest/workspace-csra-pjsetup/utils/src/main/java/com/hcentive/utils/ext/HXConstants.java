/*
 * New York Health eXchange - 2013
 */
//sgaylord- Modified for Shop Jan'13 merge
package com.hcentive.utils.ext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HXConstants {

	public final static String PDF_MIME_TYPE = "application/pdf";
	public final static String OVERRIDE_STATUS_TO_ACTIVE = "ACTIVE";
	public final static String OVERRIDE_STATUS_TO_INACTIVE = "INACTIVE";
	public final static String NYS_STATE_CODE = "NY";

	public final static String DELIMITER_DEFAULT_STRING = ",";

	public final static long JOB_WINDOW_MAX = 180;
	public final static String JOB_SSN_FREQUENCY = "90";
	public final static String JOB_CIT_FREQUENCY = "90";
	public final static String JOB_INC_FREQUENCY = "30,90";
	public final static String JOB_AMERICAN_INDIAN_FREQUENCY = "90";

	public final static List<Long> JOB_SSN_FREQUENCY_LIST = HXUtility.convertStringToListLong(JOB_SSN_FREQUENCY,
			DELIMITER_DEFAULT_STRING);
	public final static List<Long> JOB_CIT_FREQUENCY_LIST = HXUtility.convertStringToListLong(JOB_CIT_FREQUENCY,
			DELIMITER_DEFAULT_STRING);
	public final static List<Long> JOB_INC_FREQUENCY_LIST = HXUtility.convertStringToListLong(JOB_INC_FREQUENCY,
			DELIMITER_DEFAULT_STRING);
	public final static List<Long> JOB_AMERICAN_INDIAN_FREQUENCY_LIST = HXUtility.convertStringToListLong(
			JOB_AMERICAN_INDIAN_FREQUENCY, DELIMITER_DEFAULT_STRING);

	public final static String SSN_VERIFICATION_CODE_SUCCESS = "A";
	public final static String SSN_VERIFICATION_CODE_FAILURE_B = "B";
	public final static String SSN_VERIFICATION_CODE_FAILURE_C = "C";
	public final static String SSN_VERIFICATION_CODE_FAILURE_D = "D";
	public final static String SSN_VERIFICATION_CODE_FAILURE_E = "E";
	public final static String SSA_RESPONSECODE_DESC_SUCCESS = "Good Return, Transaction Completed";
	public final static String SSN_VERIFICATION_DESC_VERIFIED = "Verified; SSN, Name, and DOB are verified";
	public final static String SSA_RESPONSE_CODE_GOODRETURN = "0000";
	public final static String SSA_REQUEST_PREFIX = "A";
	public final static String GRANT_DATE_VERIFIED_CS = "Y";

	// Constants for Individual
	public final static String ADDRESS_RES_CODE = "1";
	public final static String ADDRESS_MAIL_CODE = "2";
	public final static String ADDRESS_ALT_CODE = "3";

	public final static String ADDRESS_RES_CODE_STANDARD = "4";
	public final static String ADDRESS_MAIL_CODE_STANDARD = "5";
	public final static String ADDRESS_ALT_CODE_STANDARD = "6";

	public final static String ADDRESS_PRIMARY_CODE = "7";
	public final static String ADDRESS_BILLING_CODE = "8";
	public final static String ID_PROOF_ADDRESS_CODE = "9";

	public final static String ADDRESS_LEG_CODE = "10";
	public final static String ADDRESS_LEG_CODE_STANDARD = "11";

	// Constants for SSN
	// Constant to identify code - person is not eligible for SSN
	public final static String NO_SSN_REASON_NOT_ELIGIBLE = "1";
	public final static String NO_SSN_REASON_NOT_PROVIDE = "5";
	public final static String NO_SSN_REASON_SSN_AAPLIED = "0";
	public final static String NO_SSN_FLG_TRUEFALSE_TRUE = "1";
	public final static String NO_SSN_FLG_TRUEFALSE_FALSE = "0";

	public final static String NO_SSN_NEED_T0_APPLY_FOR_ONE = "2";

	public final static String NO_SSN_IN_PROCESS_OF_APPLYING_FOR_SSN = "3";

	// Constant to identify code - person has selected citizenship status is us
	// citizen
	public final static String CITIZENSHIP_STATUS_US_CITIZEN = "0";
	public final static String CITIZENSHIP_STATUS_NATURALIZED_CITIZEN = "1";
	public final static String CITIZENSHIP_STATUS_IMMIGRANT_NON_CITIZEN = "2";
	public final static String CITIZENSHIP_STATUS_NON_IMMIGRANT_VISA_HOLDER = "3";
	public final static String CITIZENSHIP_STATUS_OTHER = "4";

	// Constant to identify code - person has clicked in Household pages
	public final static String HH_PREVIOUS_CLICK_INDICATOR_VALUE_YES = "Y";

	// Constants for Household Member DocumentTypeCategory
	public final static String CITIZENSHIP_DOC_CATEGORY = "citizenshipDocType";
	public final static String CITIZENSHIP_DOC_CATEGORY_NC = "citizenshipNCDocType";
	public final static String CITIZENSHIP_DOC_CATEGORY_IN = "citizenshipINDocType";
	public final static String CITIZENSHIP_DOC_CATEGORY_NV = "citizenshipNVDocType";
	public final static String CITIZENSHIP_DOC_CATEGORY_OT = "citizenshipOTDocType";
	public final static String CITIZENSHIP_DOCUMENT_TYPE = "citizenshipDocumentType";

	public final static String MEMBER_RACE_OTHER_CODE = "OT";
	public final static String MEMBER_ETHNICITY_OTHER_CODE = "OT";
	public final static String MEMBER_RACE_AIAN = "1";

	// Breadcrum navigation
	public final static String STEP_1 = "hxlabel.elig.nav.step1";
	public final static String STEP_2 = "hxlabel.elig.nav.step2";
	public final static String STEP_3 = "hxlabel.elig.nav.step3";
	public final static String STEP_4 = "hxlabel.elig.nav.step4";

	public final static String BASIC_INFO = "hxlabel.elig.nav.basicInfo";
	public final static String IDENTIFYING_INFO = "hxlabel.elig.nav.identifyingInfo";
	public final static String ADDITIONAL_INFO = "hxlabel.elig.nav.additionalInfo";
	public final static String DEFINE_RELATIONSHIP = "hxlabel.elig.nav.defineRelationship";

	public final static String MANAGE_ADDRESSES = "hxlabel.elig.nav.manageAddresses";
	public final static String HOUSEHOLD_SUMMARY = "hxlabel.elig.nav.householdSummary";

	// General naviation
	public final static String NAV_ACTION_EDIT_HOUSEHOLD = "editHousehold";
	public final static String NAV_ACTION_EDIT_ADDRESS = "editAddress";
	public final static String NAV_ACTION_EDIT_ANOTHER_MEMBER = "editAnotherMember";
	public final static String NAV_ACTION_EDIT_NEXT_MEMBER = "editNextMember";
	public final static String NAV_ACTION_EDIT_BASICINFO = "editBasicInfo";
	public final static String NAV_ACTION_BACK_MAILING_ADDRESS = "residenceAddress";// "mailingAddress";

	public final static int OOO_NUM_DAYS = 90;

	// CONSTANTS FOR ADDRESS STATUS
	public static final String ADDR_STATUS_ACTIVE = "1";
	public static final String ADDR_STATUS_INACTIVE = "0";
	public static final String ADDR_SELECTED_YESNO_YES = "1";
	public static final String ADDR_SELECTED_YESNO_NO = "0";
	public static final String ADDR_STANDARDIZED_YESNO_YES = "1";
	public static final String ADDR_STANDARDIZED_YESNO_NO = "0";

	public final static int DEFAULT_HH_SIZE = 1;
	public final static String HH_SECTION_FAMILY_DETAILS = "FamilyDetails";
	public final static String HH_SECTION_INCOME = "IncomeInfo";
	public final static String HH_SECTION_ELIGIBILITY_REVIEW = "EligibilityReview";
	public final static String HH_SECTION_ELIGIBILITY_RESULT = "EligibilityResult";
	public final static String HH_SECTION_MEC = "MEC";
	public final static String HH_SECTION_APPLICATIONSUMMARY = "Review";
	public final static String HH_SECTION_SPECIALRULES = "SpecialRules";
	public final static String HH_SECTION_APPEALS = "Appeals";
	public final static String HH_SECTION_COVERAGE_PREFERENCE = "CoveragePreference";

	// Start - forgot password
	public final static String USER_NAME = "username";
	public static final String INVALID_USER_NAME = "invalidusername";
	// End - forgot password

	// Start - forgot username
	public final static String EMAIL = "email";
	public final static String INVALID_EMAIL_NAME = "invalid email address";
	public final static int EMAIL_MIN_LENGTH = 7;
	public final static int EMAIL_MAX_LENGTH = 100;
	// End - forgot username

	// Start - Security Questions
	public final static String PAGE_ID_SECURITYQUESTIONS_INFO = "securityQuestions";
	public final static String SECRET_ANSWER_ONE = "secret_answer1";
	public final static String SECRET_ANSWER_TWO = "secret_answer2";
	public static final String INVALID_SECRETE_ANSWER = "invalidsecreteAnswer";
	// End - Security Questions

	// ***********************Lini***********************
	// CONSTANTS FOR USER PROFILE
	public final static String PAGE_ID_CONTACT_INFORMATION = "myProfile";
	public final static String PAGE_ID_ACCOUNT_CREATION = "register";
	public final static int PHONE_NUMBER_MIN_LENGTH = 0;
	public final static int PHONE_NUMBER_MAX_LENGTH = 10;
	public final static int PHONE_NUMBER_EXTENSION_MAX_LENGTH = 5;
	public final static int PHONE_NUMBER_ONE_MAX_LENGTH = 3;
	public final static int PHONE_NUMBER_TWO_MAX_LENGTH = 3;
	public final static int PHONE_NUMBER_THREE_MAX_LENGTH = 4;
	// ************************Lini***********************

	// ID PROOF TYPE
	public static final String SSN_ID_PROOF_TYPE = "SSN";
	public static final String MEMBER_ID_PROOF_TYPE = "MEMBERID";

	// Start - Create New Password
	public final static String PASSWORD = "password";
	public final static String CONFIRMPASSWORD = "confirmPassword";
	// End - Create New Password

	// Start - Contact Preferences
	public final static String PAGE_ID_CONTACT_PREFERENCES = "contactPrefs";
	public final static String ALERT_REQUIRED = "emailAlert";
	public final static String PHONE_CONTACT_REQUIRED = "prefPhoneContact";
	public final static String SMS_MOBILEPHONE_ALERT = "phone";
	// a constant for comparison against the value provided by the users
	// selection.
	public final static String CELL_PHONE = "Cell";
	public final static String PAPERLESS_ZERO = "0";
	public final static String PAPERLESS_ONE = "1";

	// End - Contact Preferences

	// PM Benefits Fields formats
	public final static String PLAN_BS_FORMAT_AMOUNT = "amount";
	public final static String PLAN_BS_FORMAT_NUMBER = "number";
	public final static String PLAN_BS_FORMAT_PERCENTAGE = "percentage";
	public final static String PLAN_BS_FORMAT_STRING = "string";
	public final static String PLAN_BS_FORMAT_BOOLEAN = "Boolean";
	public final static String PLAN_BS_FORMAT_NUMERIC = "Numeric";

	// PM Benefits Label Keys
	public final static String MAX_ANNUAL_COST_KEY = "maximumannualcost";
	public final static String OUT_OF_POCKET_INDIVIDUAL = "outofpocketIndividual";

	// CONSTANTS FOR Indicator YES and No
	public static final String INDICATOR_YES = "Y";
	public static final String INDICATOR_NO = "N";

	// CONSTANTS FOR FED Hub Verification Level
	public static final String FED_HUB_VERIFICATION_LEVEL_INDIVIDUAL = "INDIVIDUAL";
	public static final String FED_HUB_VERIFICATION_LEVEL_EMPLOYEE = "EMPLOYEE";
	public static final String FED_HUB_VERIFICATION_LEVEL_EMPLOYER = "EMPLOYER";
	public static final String FED_HUB_VERIFICATION_LEVEL_BROKER = "BROKER";

	// CONSTANTS FOR VERIFICATION SOURCE
	public static final String VERIFICATION_SOURCE_FED_HUB = "FED_HUB";
	public static final String VERIFICATION_SOURCE_SAVE = "Fed Data Hub SAVE interface";
	public static final String VERIFICATION_SOURCE_STATE_HUB = "STATE_HUB";
	public static final String VERIFICATION_SOURCE_DOCUMENT_COPY = "DOCUMENT_COPY";
	public static final String VERIFICATION_SOURCE_IN_PERSON = "IN_PERSON";
	
	// CONSTANTS FOR CS VERIFICATION LEVEL AND SOURCE
	public static final String CS_VERIFICATION_LEVEL_INDIVIDUAL = "CS_INDV";
	public static final String VERIFICATION_SOURCE_CS = "CS";

	public static String TOTAL_PREMIUM = "totalPremium";
	public static String EMPLOYEE_CONTRIBUTION = "employeeContribution";
	public static String EMPLOYER_CONTRIBUTION = "employerContribution";

	public static String ASCENDING = "ASC";
	public static String DESCENDING = "DESC";
	
	// CONSTANTS FOR BackOffice Notice Search
	public static final String NOTICE_RECIPIENT_EMPLOYEE = "EMPLOYEE";
	public static final String NOTICE_RECIPIENT_EMPLOYER = "EMPLOYER";
	public static final String NOTICE_RECIPIENT_BROKER = "BROKER";	
	public static final String NOTICE_STATUS_RELEASE = "RELEASED";
	public static final String NOTICE_STATUS_HOLD = "HOLD";
	public static final String NOTICE_RECIPIENT_ASSISTOR = "ASSISTOR";	

	/* SHOP Metals */
	public static String PLATINUM = "Platinum";
	public static String GOLD = "Gold";
	public static String SILVER = "Silver";
	public static String BRONZE = "Bronze";

	public static String LOW = "LOW";
	public static String HIGH = "HIGH";
	
	/* SHOP Cart Attributes */
	
	public static String TOTAL_CART_ITEMS = "totalCartItems";
	public static String TOTAL_QHP_CART_ITEMS = "totalQHPCartItems";
	public static String TOTAL_DENTAL_CART_ITEMS = "totalDentalCartItems";
	public static String TOTAL_PEDIATRIC_CART_ITEMS = "totalPediatricCartItems";

	/*-- SHOP CONSTANTS FOR PLAN CRITERIA PARAMS */
	public static String IN_ACTIVE_EXPIRED_TEMP_AND_SHELL = "In-Active(Expired)";
	public static String ENROLLMENT_SETUP_ID = "enrollmentSetupId";
	public static String ENROLLMENT_END_DATE = "ENROLLMENT_END_DATE";
	public static String EMPLOYEE_ID = "employeeId";
	public static String EMPLOYER = "employer";
	public static String ENROLLMENT_SETUP_CATEGORY = "enrollmentSetupCategory";
	public static String PLAN_DETAILS_IDS = "planDetailIds";
	public static String PLAN_UNIQUE_IDS = "planUniqueIds";
	public static String ISSUER_LIST = "issuers";
	public static String INCLUDE_ELIGIBILE_PLANS = "includePlanIdsAndEligbilePlan";
	public static String PRODUCT_CATEGORY = "productCategory";
	public static String EMPLOYEE_ZIP = "employeeZip";
	public static String INSTANT_QUOTES = "instantQuotes";
	public static String GET_QUOTES_FOR_REVIEW = "getQuotesForReview";
	public static String EMPLOYER_ADDED_RIDERS = "employerAddedRiders";
	public static String MAX_EMPLOYER_CONTRIBUTION = "maxEmployerContribution";
	public static String GET_DEFAULT_PLAN = "getDefaultPlan";
	public static String COVERAGE_TIERS = "coverageTiers";
	public static String ENROLLMENT_SETUP = "enrollmentSetup";
	public static String PLAN_INFO_LIST = "planInfoList";
	public static String PAGE_NUMBER = "pageNumber";
	public static String COUNTY_NAMES = "countyNames";
	public static String LEVEL_OF_COVERAGE = "levelOfCoverage";
	public static String SERVICE_TYPE = "serviceType";
	public static String RATING = "qualityRating";
	public static String SORT_ORDER = "sortOrder";
	public static String SORT_COLUMN = "sortColumn";
	public static String CONTRIBUTION = "contribution";
	public static String PRODUCT_CATEGORY_ID = "productCategoryId";
	public static String PLANS = "plans";
	public static String PLANS_UNIQUE_IDS = "planUniqueIds";
	public static String IS_DENTAL = "isDental";
	public static String SB_PLAN_SC = "pscList";
	public static String HEALTH_OPTIONS = "healthOptions";
	public static String STATE = "state";
	public static String DOCTOR_NPI = "doctornpi";
	public static String HOSPITAL_FPI = "hospitalfpi";
	public static String PSC = "psc";
	public static String PAGE_SIZE = "pageSize";
	public static String EMPLOYER_COUNTY = "employerCounty";
	public static String EMPLOYEE_COUNTY = "employeeCounties";
	public static String EMPLOYEE_COUNTY_STRING = "employeeCountyString";
	public static String EMPLOYEE_STATE = "employeeState";
	public static String EMPLOYER_CONTR_MIN = "employerContributionMin";
	public static String EMPLOYER_CONTR_MAX = "employerContributionMax";
	public static String EMPLOYEE_CONTR_MIN = "employeeContributionMin";
	public static String EMPLOYEE_CONTR_MAX = "employeeContributionMax";
	public static String TOTAL_PREMIUM_MIN = "totalPremiumMin";
	public static String TOTAL_PREMIUM_MAX = "totalPremiumMax";
	public static String INCLUDE_PLANIDS_AND_ELIGIBLE_PLANS = "includePlanIdsAndEligiblePlans";
	public static String CHILD_ONLY = "CHILD_ONLY";
	public static String CHILD_ONLY_DENTAL = "CHILD_ONLY_DENTAL";
	public static String INDIVIDUAL = "INDIVIDUAL";
	public static String POPULATE_SUBSCRIBER_LIST= "populateSubscriberList";
	public static String PLAN_TYPE="planType";
	public static String APPLY_FILTER = "applyFilter";
	public static String MODIFY_ENROLLMENT_FOR_RELOCATION = "modifyEnrollForRelocation";
	public static String EMPLOYER_OFFER_CHANGED_DURING_OEP = "Employer Offer Changed";
	
	
	// CONSTANTS FOR VERIFICATION STATUS
	// public static final String VERIFICATION_STATUS_FAILED = "FAILED";
	// public static final String VERIFICATION_STATUS_VERIFIED = "VERIFIED";
	// public static final String VERIFICATION_STATUS_UNVERIFIED = "UNVERIFIED";

	// CONSTANTS FOR Indicator YES and No
	public static final String FED_HUB_RESPONSE_OVERALL_SUCCESS = "HS000000";
	public static final String FED_HUB_RESPONSE_IND_TXN_SUCCESS = "0000";
	public static final String FED_HUB_RESPONSE_IND_NO_SSN_TXN_SUCCESS = "8888";
	
	public static final String FED_HUB_RESPONSE_IND_DOCCS_TXN_SUCCESS = "0000";
	public static final String FED_HUB_RESPONSE_IND_DOCCS_TXN_NO_MATCH = "0001";
	public static final String FED_HUB_RESPONSE_IND_DOCCS_TXN_FAILED = "9999";
	
	public static final String FED_HUB_RESPONSE_IND_TXN_FAILED = "9999";

	public static final int FED_HUB_MAXIMUM_FAILED_ATTEMPT_ALLOWED_IN_24_HRS = 3;
	public static final int FED_HUB_MAXIMUM_FAILED_ATTEMPT_ALLOWED = 5;

	// PLAN MANAGEMENT INTEGRATION
	public static final String DISPLAY_STRING_AMOUNT = " Copay";
	public static final String DISPLAY_STRING_PERCENT = " Coinsurance After Deductible";

	public static final String DISPLAY_STRING_YES = "Yes";
	public static final String DISPLAY_STRING_NO = "No";

	// Plan Selection

	public static final String ENROLLMENT_GROUP = "EnrollmentGroup";

	// Constants for page navigation integration logic

	public static final String PAGE_NAV_BTN_BACK = "Back";
	public static final String PAGE_NAV_BTN_NEXT = "Next";

	public static String REDIRECT = "redirect:";
	public static String FORWARD = "forward:";
	public static String GENDER = "gender";
	public static String SSN1 = "SSN1";
	public static String DOB_MM = "dobMM";
	public static String DOB_YY = "dobYYYY";
	public static String NO_SSN_RSN = "noSSNReason";
	public static String NO_SSN_RSN_ADDTNL = "noSsnAddtnlInd";
	public static String NO_SSN_RSN_ADDTNL_DRIVER_ID = "driverLicenseId";
	public static String NO_SSN_RSN_ADDTNL_NON_DRIVER_ID = "nonDriverId";
	public static String NO_SSN_RSN_ADDTNL_USER_CIN_NUMBER = "userCinNumber";
	public static String NO_SSN_RSN_ADDTNL_USER_HIXID = "userHixId";

	public static String NOT_ELG_FORSSNRSN = "notEligibleForSSNReason";

	public static final String UNDERSCORE = "_";
	public static final String DASH = "-";
	public static final String EMPTY_STRING = "";
	public static final String LEFT_SQUARE_BRACKET = "[";
	public static final String RIGHT_SQUARE_BRACKET = "]";
	public static final String PERIOD = ".";
	public static final String COLON = "'";
	public static final String NOT_APPLICABLE = "N/A";

	// Constants for Identity Proofing-SHOP
	public static int FLAG_IDENT_PROOFING;
	public static int IDENTSUCCESSIND = 1;
	public static final String IDPROOFING_GOOD = "GOOD";
	public static final String IDPROOFING_BAD = "BAD";
	public static final String IDPROOFING_MOREINFO = "MOREINFO";
	public static final String IDPROOFING_SUCCESS_IND = "Y";
	public static final String IDPROOFING_NOT_COMPLETED_IND = "N";
	public static final String RE_ID_PROOF_IND = "Y";
	public static final String RE_ID_PROOF_INACTIVE_IND = "N";
	public static final int RE_ID_PROOFING_DAYS_INTERVAL = 29;

	public static final String RIDP_SUCCESS = "HS000000";
	// Employee
	public static final String EMPLOYEE_STATUS_BAD = "BAD";
	public static final String EMPLOYEE_STATUS_GOOD = "Active";

	public static final int EMP_FIRST_NAME_MAX = 25, EMP_LAST_NAME_MAX = 40, EMP_CODE_MAX = 10, EMP_SALARY_MAX = 7,
			EMP_WORKING_HRS_MAX = 2, EMP_EMAIL_MAX = 50;
	public static final int EMP_FIRST_NAME_DB_MAX = 50, EMP_LAST_NAME_DB_MAX = 50, EMP_EMAIL_DB_MAX = 50, EMP_PHONE_DB_MAX = 15,
			EMP_CODE_DB_MAX = 50;

	public static final String BREADCRUM_NAV = "breadcrumNav";

	public static final String HH_MODEL_KEY = "householdDetail";
	public static final String HH_MODEL_JSON_KEY = "eligibilityJson";

	// Relationship constant
	public static final String RELATIONSHIP_SELF = "18";

	// R1B2 Income Page Ids 05_02_2013

	public final static String TAXFILIINGSTATUS_SINGLE = "0";
	public final static String TAXFILIINGSTATUS_MARRIED_FILING_JOINTLY = "1";
	public final static String TAXFILIINGSTATUS_MARRIED_FILING_SINGLE = "2";
	public final static String TAXFILIINGSTATUS_HEAD_OF_HOUSEHOLD = "3";
	public final static String TAXFILIINGSTATUS_QUAUIFYING_WIDOWER_WITH_DEPENDENTS = "4";
	public final static String TAXFILIINGSTATUS_DEPENDENT_FILING_TAX = "5";
	public final static String TAXFILIINGSTATUS_NOT_FILING_TAXES = "6";

	// R1B2 Income type of Tax Relationships 02-05-2013

	public static final String TAX_RELATIONSHIP_PRIMARY = "P";
	public static final String TAX_RELATIONSHIP_SPOUSE = "S";
	public static final String TAX_RELATIONSHIP_DEPENDENT = "D";

	// R1B2 income types
	public static final String INCOME_TYPE_JOB_INCOME = "JOB_INCOME";
	public static final String INCOME_TYPE_UIB = "UIB_INCOME";
	public static final String INCOME_TYPE_TITLE_II = "TITLE_II_INCOME";
	public static final String INCOME_TYPE_ADDITIONAL = "ADDITIONAL_INCOME";
	public static final String INCOME_TYPE_DEDUCTIONS = "DEDUCTIONS";

	public static final String SPACE = " ";

	// Member Composition
	public static final String MEMBER_HH_COMPOSITION_TYPE_SUBSIDIZED = "S";
	public static final String MEMBER_HH_COMPOSITION_TYPE_UNSUBSIDIZED = "U";

	// Student Status
	public static final String MEMBER_HH_FULLTIME_STUDENT_TRUE = "1";
	public static final String MEMBER_HH_FULLTIME_STUDENT_FALSE = "0";

	// R1B2 HouseholdRelationships
	public static final String REL_TYPE_SIBLING = "14";
	public static final String REL_TYPE_PARENT = "03,16";
	public static final String REL_TYPE_STEP_PARENT = "16";
	public static final String REL_TYPE_REAL_PARENT = "03";
	public static final String REL_TYPE_LDSS_PARENT = "03";
	public static final String REL_TYPE_SPOUSE = "01";
	public static final String REL_TYPE_WARD = "15";
	public static final String REL_TYPE_DOMESTIC_PARTNER = "28";
	public static final String REL_TYPE_CHILDREN = "09,10,15,17,19,24";
	//public static final String REL_TYPE_ELG_DETER_CHILDREN_IN_HH = "09,17,19";
	public static final String REL_TYPE_INSURABLE = "01,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,19,23,24,25";
	public static final String REL_TYPE_INSURABLE_NEW = "01,09,10,15,17,19,23,26,28";
	public static final String REL_TYPE_GRANDPARENT = "04";
	public static final String REL_TYPE_GRANDCHILD = "05";
	public static final String REL_TYPE_GUARDINA = "26";
	public static final String REL_TYPE_MOTHER_FATHER_INLAW = "13";
	public static final String REL_TYPE_UNCLE_AUNT = "06";
	public static final String REL_TYPE_NEPHEW_NIECE_REAL = "07";
	public static final String REL_TYPE_NEPHEW_NIECE = "07";
	public static final String REL_TYPE_COUSIN = "08";
	public static final String REL_TYPE_CARE_TAKERS = "14,04,06,07,08";
	public static final String REL_TYPE_CHILD_INSURABLE = "09,10,17,19";
	public static final String REL_TYPE_BIO_CHILD = "19";
	public static final String REL_TYPE_BIO_PARENT = "03";

	public static final String REL_TYPE_CHILDREN_NEW = "09,10,17,19";

	public static final int AGE_FOR_CHILD_IN_FULL_PAY = 21;

	/* USed to determine if a member is eligible for child plan */
	public static final int AGE_FOR_CHILD_IN_FULL_PAY_GROUP_COMPOSITION = 21;

	public static final int AGE_FOR_CHILD_NOT_ALLOWED_IN_FULL_PAY_GROUP_COMPOSITION = 29;
	
	// Added by Tejas
	public static final int AGE_FOR_CHILD_FOR_CHILD_COVERAGES = 19;
	public static final int AGE_FOR_CHILD_FOR_CHILD_COVERAGES_STUDENT = 20;

	// Used for Household Composition rules
	public static final String RELATION_TYPE_CHILD = "CHILD";
	public static final String RELATION_TYPE_PARENT = "PARENT";
	public static final String RELATION_TYPE_SIBLING = "SIBLING";
	public static final String RELATION_TYPE_SPOUSE = "SPOUSE";
	public static final String RELATION_TYPE_DOMESTIC_PARTNER = "Domestic Partner";
	public static final String RELATION_TYPE_SELF = "SELF";
	public static final String RELATION_TYPE_WARD = "WARD";
	public static final String RELATION_TYPE_GUARDIAN= "Guardian";

	public static final Integer HHCOMP_RULE_EXEC_SEC1_ACK = 1;
	public static final Integer HHCOMP_RULE_EXEC_STEP_FINAL = 5;

	public static final String INCOME_FREQ_HOURLY = "01";
	public static final String INCOME_FREQ_WEEKLY = "02";
	public static final String INCOME_FREQ_ONCE_EVERY_TWO_WEEKS = "03";
	public static final String INCOME_FREQ_MONTHLY = "04";
	public static final String INCOME_FREQ_QUARTERLY = "05";
	public static final String INCOME_FREQ_YEARLY = "06";
	public static final String INCOME_FREQ_TWICE_A_MONTHLY = "07";

	public static final String INCOME_FREQ_TWICE_A_MONTH = "6";

	public static final String INCOME_CONSISTENT_STEADY = "1";
	public static final String INCOME_CONSISTENT_INCONSISTENT = "2";

	public static final String SELF_EMPLOYED_INCOME = "1";
	public static final String SELF_EMPLOYED_EXPENSE = "2";

	public static final String VI_JOB_OTHER_REASON = "7";
	public static final String VI_TITLEII_OTHER_REASON = "12";
	public static final String VI_UIB_OTHER_REASON = "23";
	public static final String VI_LOST_A_JOB_REASON = "4";

	public static final String OTHER_INCOME_ADDITIONAL = "AD";
	public static final String OTHER_INCOME_DEDUCTION = "DD";
	public static final String FARM_INCOME_AD = "17";
	public static final String BUSINESS_INCOME_AD = "14";
	public static final String FOREIGN_EARNED_INCOME_EXCLUSION_AD = "22";

	public static final double HH_MAGI_LOWER_MULTIPLIER = 0.9;
	public static final double HH_MAGI_UPPER_MULTIPLIER = 1.1;

	public static final Double MEDICAID_AUTO_ENROLLMENT_PREMIUM = 0D;
	public static final int AUTO_ENROLLMENT_ADDITIONAL_INFO_MAX_SIZE = 24000;

	public static final double AMOUNT_DIFFERENCE_LIMIT = 0.01d;

	// Navigation for Tax Status
	public final static String NAV_ACTION_TAX_STATUS = "addMember";

	public static final String OTHER_INCOME_DEDUCTION_TYPE_CODE = "16";
	public static final String OTHER_ADDITIONAL_INCOME_TYPE_CODE = "24";

	public static final String HOW_ARE_YOU_LIVING_OPTION = "4";

	// sgaylord - SHOP Merge Jan'13 Code
	// Contact Info Type
	public static final String CONTACT_TYPE_SECONDARY = "S";

	// EmployeeExcelValidator
	public static final int MAX_HIRING_DATE = 45;

	public static final int EXT_DB_MAX = 10;
	public static final int ADDR_DB_MAX = 100;
	public static final int CITY_DB_MAX = 50;
	public static final int STATE_DB_MAX = 50;
	public static final int ZIP_DB_MAX = 20;
	// UIB Screen
	public final static String VERIFICATION_SOURCE_USER_CD = "SA";
	public static final String VERIFICATION_UIB_DS_CD = "UI";
	public static final String VERIFICATION_TITLEII_DS_CD = "CS";
	public static final String VERIFICATION_DTF_DS_CD = "WI";
	public final static String VERIFICATION_STATUS_CD_ACTIVE = "A";
	public final static String VERIFICATION_STATUS_CD_INACTIVE = "I";

	// Navigation for the Total Income Summary page
	public final static String NAV_ACTION_IDENTIFYING_INFO = "identifyingNav";
	public final static String NAV_ACTION_ADDITIONAL_INFO = "additionalNav";
	public final static String NAV_ACTION_IMMIGRATION_INFO = "immigrationNav";
	public final static String NAV_ACTION_TAX_STATUS_INCOME = "taxStatusIncomeNav";
	public static final String NAV_ACTION_JOB_INCOME = "jobIncomeNav";
	public static final String NAV_ACTION_UIB_INCOME = "uibIncomeNav";
	public static final String NAV_ACTION_TITLEII_INCOME = "titleIIIncomeNav";
	public static final String NAV_ACTION_DEDUCTION_INCOME = "deductionIncomeNav";
	public static final String NAV_ACTION_ADDITIONAL_INCOME = "additionalIncomeNav";
	public static final String NAV_ACTION_VERIFIED_INCOME_SUMMARY = "verifiedIncomeNav";
	public static final String NAV_ACTION_PUBLIC_MEC = "publicMECNav";
	public static final String NAV_ACTION_RELATIONSHIP_INFO = "relationshipNav";
	public static final String NAV_ACTION_ADDRESS__INFO = "addressInformationNav";
	public static final String NAV_ACTION_RETRO_INCOME = "retroIncomeNav";

	public static final String INCOME_TYPE_DEDUCTION = "DEDUCTION";
	public static final String INCOME_TYPE_ADDITIONAL_INCOME = "ADDITIONAL_INCOME";

	//
	public static final String MEMBER_INCOME_VERIFICATION_STATUS_ACTIVE = "1";
	public static final String MEMBER_INCOME_VERIFICATION_STATUS_INACTIVE = "2";

	public static final String DS_TYPE_IRS = "I";
	public static final String DS_TYPE_OTHER = "O";

	public static final int MAX_REQUEST_ID = 999999999;
	public static final int ZERO_REQUEST_ID = 0;
	public static final int ZERO_INDEX = 0;

	public static final String SYSTEM_USER = "SYSTEM";
	public static final String SKIP_ERROR_LIST_FOR_PLAN_STR = "HCHX_INVALID_AVAILABLE_FOR,HCHX_INVALID_COUNTYNAME,HCHX_INVALID_PRODUCT_CATEGORY";
	public static final List<String> SKIP_ERROR_LIST_FOR_PLAN = HXUtility.convertStringToListStr(SKIP_ERROR_LIST_FOR_PLAN_STR,
			DELIMITER_DEFAULT_STRING);

	public static final int MAX_OTHER_REASON_TEXT_LENGTH = 100;

	// Earned Income Constants
	public static final String EI_SELFEMPLOYED_GROSS_SALES = "1";
	public static final String EI_SELFEMPLOYED_RENTS_RECEIVED = "2";
	public static final String EI_SELFEMPLOYED_ROYALTIES_RECEIVED = "3";
	public static final String EI_SELFEMPLOYED_INVENTORY_PURCHASE = "4";
	public static final String EI_SELFEMPLOYED_INCOME = "1";
	public static final String EI_SELFEMPLOYED_EXPENSE = "2";
	public static final String EI_SELFEMPLOYED_OTHER_EXPENSES_BUSINESS = "41";
	public static final String EI_SELFEMPLOYED_OTHER_EXPENSES_FARM = "38";

	// Eligibility Determination constants
	public static final Integer RULE_EXEC_STEP_INIT = -1;
	public static final Integer RULE_EXEC_STEP_INIT_ACK = -11;
	public static final Integer RULE_EXEC_STEP_01 = 1;
	public static final Integer RULE_EXEC_STEP_01_ACK = 11;
	
	public static final Integer RULE_EXEC_STEP_SEC1_1_OLD_01 = 101;
	public static final Integer RULE_EXEC_STEP_SEC1_1_OLD_01_ACK = 1011;
	
	public static final Integer RULE_EXEC_STEP_SEC1_1_NEW_01 = 201;
	public static final Integer RULE_EXEC_STEP_SEC1_1_NEW_01_ACK = 2011;
	
	public static final Integer RULE_EXEC_STEP_02 = 2;
	public static final Integer RULE_EXEC_STEP_02_ACK = 22;
	public static final Integer RULE_EXEC_STEP_03 = 3;
	public static final Integer RULE_EXEC_STEP_03_ACK = 33;
	public static final Integer RULE_EXEC_STEP_SEC1_03 = 31;
	public static final Integer RULE_EXEC_STEP_SEC1_03_ACK = 331;
	
	
	//CR1140 - Introducing BHP program: Used before APTC_PP is retirement
	public static final Integer RULE_EXEC_STEP_SEC1_1_OLD_03 = 131;
	public static final Integer RULE_EXEC_STEP_SEC1_1_OLD_03_ACK = 1331;
	public static final Integer RULE_EXEC_STEP_SEC1_1_NEW_03 = 231;
	public static final Integer RULE_EXEC_STEP_SEC1_1_NEW_03_ACK = 2331;
	
	//CR 1234 introducing this as 4 series as 331 is already used for RULE_EXEC_STEP_SEC1_03_ACK
	public static final Integer RULE_EXEC_STEP_SEC1_1_03 = 431;
	public static final Integer RULE_EXEC_STEP_SEC1_1_03_ACK = 4331; 
	
	public static final Integer RULE_EXEC_STEP_SEC2_03 = 32;
	public static final Integer RULE_EXEC_STEP_SEC2_03_ACK = 332;
	public static final Integer RULE_EXEC_STEP_SEC3_03 = 33;
	public static final Integer RULE_EXEC_STEP_SEC3_03_ACK = 333;
	
	//CR1140 - Introducing BHP program: Used before APTC_PP is retirement
	public static final Integer RULE_EXEC_STEP_SEC2_1_OLD_03 = 132;
	public static final Integer RULE_EXEC_STEP_SEC2_1_OLD_03_ACK = 1332;
	
	public static final Integer RULE_EXEC_STEP_SEC3_1_OLD_03 = 133;
	public static final Integer RULE_EXEC_STEP_SEC3_1_OLD_03_ACK = 1333;
	
	//CR1140 - Introducing BHP program: Used after APTC_PP is retirement
	public static final Integer RULE_EXEC_STEP_SEC2_1_NEW_03 = 232;
	public static final Integer RULE_EXEC_STEP_SEC2_1_NEW_03_ACK = 2332;
	
	public static final Integer RULE_EXEC_STEP_SEC3_1_NEW_03 = 233;
	public static final Integer RULE_EXEC_STEP_SEC3_1_NEW_03_ACK = 2333;
	
	
	public static final Integer RULE_EXEC_STEP_04 = 4;
	public static final Integer RULE_EXEC_STEP_04_ACK = 44;
	
	//CR1140 - Introducing BHP program: Used after APTC_PP is retirement
	public static final Integer RULE_EXEC_STEP_SEC1_NEW_04 = 41;
	public static final Integer RULE_EXEC_STEP_SEC1_NEW_04_ACK = 441;
	
	public static final Integer RULE_EXEC_STEP_FINAL = 5;
	
	public static final Integer RULE_EXEC_STEP_POST_ELG = 6;
	public static final Integer RULE_EXEC_STEP_POST_ELG_ACK = 66;
	
	//CR 1307
	public static final Integer RULE_EXEC_STEP_POST_ELG_02 = 62;
	public static final Integer RULE_EXEC_STEP_POST_ELG_ACK_02 = 622;
	
	public static final Integer RULE_EXEC_STEP_POST_ELG_03 = 63;
	public static final Integer RULE_EXEC_STEP_POST_ELG_ACK_03 = 633;
	
	public static final Integer RULE_EXEC_STEP_POST_ELG_04 = 64;
	public static final Integer RULE_EXEC_STEP_POST_ELG_ACK_04 = 644;
	
	
	public static final Integer RULE_EXEC_STEP_POST_ELG_10_DAY = 7;
	public static final Integer RULE_EXEC_STEP_POST_ELG_10_DAY_ACK = 77;
	public static final Integer RULE_EXEC_STEP_OVERRIDE_ACK = -111;
	public static final Integer RULE_EXEC_STEP_OVERRIDE_COMPLETE = 111;
	public static final Integer RULE_EXEC_STEP_SEC1_05 = 51;
	public static final Integer RULE_EXEC_STEP_SEC1_05_ACK = 511;
	
	public static final Integer RULE_EXEC_STEP_SEC3_05 = 53;
	public static final Integer RULE_EXEC_STEP_SEC3_05_ACK = 531;
	
	public static final String INCOME_SERVICE_FAILED_RESP_CODE = "9999";

	public static final String SSN_DO_NOT_WANT_TO_PRD_RSN_01 = "Religious Objection";
	public static final String SSN_DO_NOT_WANT_TO_PRD_RSN_02 = "Other";

	public static final Long PRG_MEDICAID = 3l;
	public static final Long PRG_CHIP = 1l;
	public static final Long PRG_FAMILYPLANNING = 10l;
	public static final Long PRG_APTC = 9l;
	public static final Long PRG_QHP = 8l;
	public static final Long PRG_CSR = 11l;
	public static final Long PRG_APTC_PREM = 12l;
	public static final Long PRG_NONE = -1l;
	public static final Long PRG_EPP = 13l;

	public static final String ENROLLMENT_GROUP_TYPE_FAMILY = "FAMILY";
	public static final String ENROLLMENT_GROUP_TYPE_INDIVIDUAL = "INDIVIDUAL";

	/*
	 * public static final String ENROLLMENT_GROUP_TYPE_FAMILY = "FAMILY";
	 * public static final String ENROLLMENT_GROUP_TYPE_INDIVIDUAL =
	 * "INDIVIDUAL";
	 */

	public static final String P_MEC_EMPTY = "";
	public static final String P_MEC_A = "a";
	public static final String P_MEC_B = "b";
	public static final String P_MEC_C = "c";
	public static final String P_MEC_D = "d";
	public static final String P_MEC_E = "e";
	public static final String P_MEC_F = "f";
	public static final String P_MEC_G = "g";

	public static final String OUTSIDE_HH_PARENT_YES = "1";
	public static final String OUTSIDE_HH_PARENT_NO = "0";

	public static final Double MAXALLOWED = 10000000000000d;
    //enhancement 50822
	public static final String MARITAL_STATUS_SINGLE = "S";
	public static final String MARITAL_STATUS_MARRIED = "M";
	public static final String MARITAL_STATUS_WIDOWED = "W";
	public static final String MARITAL_STATUS_DIVORCED = "D";
	public static final String MARITAL_STATUS_SEPARATED = "P";

	public static String TIER_EMPLOYEE = "Employee";
	public static String TIER_FAMILY = "Employee+Family";
	public static String TIER_SPOUSE = "Employee+Spouse";
	public static String TIER_CHILD = "Employee+Child";
	public static String TIER_PEDIATRIC_CHILD = "Pediatric Child";
	public static String TIER_COVG_SPOUSE = "Employee+Spouse";

	public final static String PAGE_ID_BASIC_INFO = "ext/hx_basicinfo";
	public final static String PAGE_ID_RESIDENCY = "ext/hx_residency";
	public final static String PAGE_ID_ADDITIONAL_INFO = "ext/hx_additionalinfo";
	public final static String PAGE_ID_RELATIONSHIP_INFO = "ext/hx_relationship";
	public final static String PAGE_ID_RESIDENCE_ADDRESSES = "ext/hx_residenceaddresses";
	public final static String PAGE_ID_MAILINGADDRESS = "ext/hx_mailingaddress";
	public final static String PAGE_ID_HOUSEHOLD_SUMMARY = "ext/hx_summary";
	public final static String PAGE_ID_IDENTIFYING_INFO = "identifyingInfo";
	public final static String PAGE_ID_IDENTITY_NOT_FOUND = "identityNotFound";
	public final static String PAGE_ID_APPLICATIONSUMMARY = "ext/hx_applicationsummary";
	public final static String PAGE_ID_SIGNATURE = "ext/hx_signature";
	public final static String PAGE_ID_IDENTIFY_CARETAKERS = "ext/hx_identify_caretakers";
	public final static String PAGE_ID_COVERAGE_PREFERENCE = "ext/hx_coverageYearPreference";

	public final static String PAGE_ID_ENROLLMENT_GROUP = "ext/hx_enrollmentgroup";

	// Start - forgot password
	public final static String PAGE_ID_FORGOTPASSWORD_INFO = "hx_forgotPassword";

	// Start - forgot username
	public final static String PAGE_ID_FORGOTUSERNAME_INFO = "hx_forgotUsername";

	// Start - Create New Password
	public final static String PAGE_ID_RESETPASSWORD_INFO = "hx_resetPassword";

	// R1B2 Income Page Ids 29_01_2013
	public final static String PAGE_ID_TAX_STATUS = "ext/hx_taxStatus";
	public final static String PAGE_ID_TAX_RELATIONSHIP = "ext/hx_taxRelationships";
	public final static String PAGE_ID_TOTAL_INCOME_SUMMARY = "ext/hx_totalIncomeSummary";
	public final static String PAGE_ID_PREVIOUS_INCOME = "ext/hx_previousIncome";
	public final static String PAGE_ID_EARNED_INCOME = "ext/hx_earned_income_wip";
	public final static String PAGE_ID_UIB_INCOME = "ext/hx_uIBIncome";
	public final static String PAGE_ID_TITTLE_II_INCOME = "ext/hx_titleIIIncome";
	public final static String PAGE_ID_ADDITIONAL_INCOME = "ext/hx_additionalIncome";
	public final static String PAGE_ID_INCOME_DEDUCTIONS = "ext/hx_incomeDeductions";
	public final static String PAGE_ID_VERIFIED_INCOME_SUMMARY = "ext/hx_verifiedIncomeSummary";
	public final static String PAGE_ID_INCOME_LANDING = "ext/hx_income_landing";
	public static final String PAGE_ID_APPLICATION_SUMMARY = "ext/hx_applicationsummary";
	public final static String PAGE_ID_CURRENT_INCOME = "ext/hx_currentIncome";
	public final static String PAGE_ID_CURRENT_INCOME_APPLY = "ext/hx_currentIncomeApply";
	public final static String PAGE_ID_RETRO_INCOME = "ext/hx_retroIncome";
		
	// R1B2 Income type of Tax Relationships 02-05-2013
	public final static String PAGE_ID_MEC = "ext/hx_mec";

	// Start - Enrollment Plan Selection Page Ids
	public final static String PAGE_ID_PLAN_INTRODUCTION = "ext/hx_planSelectionIntro";
	public final static String PAGE_ID_PLAN_COVERAGE = "ext/hx_coverageConfiguration";
	public final static String PAGE_ID_PLAN_DASHBOARD = "ext/hx_planSelection_dashboard";
	public final static String PAGE_ID_PLAN_CONFIRMATION = "ext/hx_planSelection_confirmation";
	public final static String PAGE_ID_PLAN_ACKNOWLEDGMENT = "ext/hx_planSelection_acknowledgment";
	public final static String PAGE_ID_PLAN_SELECTION = "ext/hx_getQuotes";
	public final static String PAGE_ID_PLAN_COMPARISON = "ext/hx_comparePlans";
	public final static String PAGE_ID_PLAN_VIEW = "ext/hx_planDetails";

	public final static String PAGE_ID_SPECIALENROLLMENTPERIOD = "ext/hx_specialEnrollmentPeriod";
	public final static String PAGE_ID_PLAN_CANCELLATION_DASHBOARD = "ext/hx_planCancellationDashboard";

	public final static String PGM_AID_CATEGORY = "AidCategory";
	public final static String PGM_COVERAGE_CODE = "CoverageCode";
	
	public final static String RRE_MA_EXISTS = "rreMAExists";
	
	public final static String PGM_CHARGE_CODE = "ChargeCode";
	public final static String PGM_ELG_IND = "EligibilityRuleInd";
	public final static String ELG_DECISION_DATA = "ELG_DECISION_DATA";
	public final static String ALIESSA_TRAN_END_DATE = "AliessaTranEndDate";	
	public final static String INDV_AFFORDABILITY_EMP_SPONSMEC_IND = "IndAffEmpSpsMecInd";

	public final static String CERTIFICATE_OF_CITIZENSHIP = "00";
	public final static String DS2019 = "01";
	public final static String I_20 = "02";
	public final static String I_327 = "03";
	public final static String I_551 = "04";
	public final static String I_571 = "05";
	public final static String I_766 = "06";
	public final static String I_94 = "07";
	public final static String I_94_FOREIGN_PASSPORT = "08";
	public final static String MACHINE_READABLE_VISA = "09";
	public final static String NATURALIZATION_CERTIFICATE = "10";
	public final static String OTHER = "11";
	public final static String TEMPORARY_I_551_STAMP = "12";
	public final static String UNEXPIRED_FOREIGN_PASSPORT = "13";

	// LRR validation
	public static final int LRR_VALIDATION_MINOR_CHILD_AGE_LIMIT = 19;
	public static final int LRR_VALIDATION_UNCLE_AUNT_AGE_LIMIT = 18;

	public static String NOT_SUBMITTED = "NOT SUBMITTED";
	public static String SUBMITTED = "SUBMITTED";
	public static String REQUESTED = "REQUESTED";
	public static final String DOCUMENT_SOURCE = "AddEmployerDocumentForm";
	public static final String DOCUMENT_EIN_CATEGORY = "EINVerification";
	public static final String DOCUMENT_LSC_CATEGORY = "LSCReportingVerification";

	// CROSS TRACK VALIDATION CONSTANTS- gmekala/gopinath kuppuswamy

	// MEC Program Types Attribute Names
	public static final String IS_AGREE_MEDICAID = "IS_AGREE_MEDICAID";
	public static final String MEDICAID_NOLONGER_APPLY = "MEDICAID_NOLONGER_APPLY";
	public static final String IS_AGREE_CHIP = "IS_AGREE_CHIP";
	public static final String CHIP_NOLONGER_APPLY = "CHIP_NOLONGER_APPLY";
	public static final String IS_AGREE_REFUGEE = "IS_AGREE_REF_MEDICAID";
	public static final String REFUGEE_NOLONGER_APPLY = "REFUGEE_NOLONGER_APPLY";
	
	public static final String IS_AGREE_VHP = "IS_AGREE_VHP";

	public static final String IS_AGREE_MEDICARE = "IS_AGREE_MEDICARE";
	public static final String IS_CARETAKER_RELATIVE = "IS_CARETAKER_RELATIVE";

	public static final String IS_AGREE_TRICARE = "IS_AGREE_TRICARE";
	public static final String SEEKING_COVERAGE_REASON_TRICARE = "SEEKING_COVERAGE_REASON_TRICARE";
	public static final String TERMINATION_DATE_MM_TRICARE = "TERMINATION_DATE_MM_TRICARE";
	public static final String TERMINATION_DATE_DD_TRICARE = "TERMINATION_DATE_DD_TRICARE";
	public static final String TERMINATION_DATE_YYYY_TRICARE = "TERMINATION_DATE_YYYY_TRICARE";

	public static final String IS_AGREE_PEACE_CORPS = "IS_AGREE_PEACE_CORPS";
	public static final String SEEKING_COVERAGE_REASON_PEACE_CORPS = "SEEKING_COVERAGE_REASON_PEACE_CORPS";
	public static final String TERMINATION_DATE_MM_PEACE_CORPS = "TERMINATION_DATE_MM_PEACE_CORPS";
	public static final String TERMINATION_DATE_DD_PEACE_CORPS = "TERMINATION_DATE_DD_PEACE_CORPS";
	public static final String TERMINATION_DATE_YYYY_PEACE_CORPS = "TERMINATION_DATE_YYYY_PEACE_CORPS";

	public static final String IS_AGREE_AMERI_CORPS = "IS_AGREE_AMERI_CORPS";
	public static final String SEEKING_COVERAGE_REASON_AMERI_CORPS = "SEEKING_COVERAGE_REASON_AMERI_CORPS";
	public static final String TERMINATION_DATE_MM_AMERI_CORPS = "TERMINATION_DATE_MM_AMERI_CORPS";
	public static final String TERMINATION_DATE_DD_AMERI_CORPS = "TERMINATION_DATE_DD_AMERI_CORPS";
	public static final String TERMINATION_DATE_YYYY_AMERI_CORPS = "TERMINATION_DATE_YYYY_AMERI_CORPS";
	public static final String SEEKING_COVERAGE_REASON_CODE_02 = "02";

	public final static int CERTIFICATE_OF_CITIZENSHIP_INT = 0;
	public final static int DS2019_INT = 1;
	public final static int I_20_INT = 2;
	public final static int I_327_INT = 3;
	public final static int I_551_INT = 4;
	public final static int I_571_INT = 5;
	public final static int I_766_INT = 6;
	public final static int I_94_INT = 7;
	public final static int I_94_FOREIGN_PASSPORT_INT = 8;
	public final static int MACHINE_READABLE_VISA_INT = 9;
	public final static int NATURALIZATION_CERTIFICATE_INT = 10;
	public final static int OTHER_INT = 11;
	public final static int TEMPORARY_I_551_STAMP_INT = 12;
	public final static int UNEXPIRED_FOREIGN_PASSPORT_INT = 13;

	public static final String LAWFUL_PRESENCE_VERIFIED = "Y";
	public static final String LAWFUL_PRESENCE_NOT_VERIFIED = "N";
	public static final String LAWFUL_PRESENCE_PENDING = "P";
	
	public static final String QNC_VERIFIED_Y = "Y";
	public static final String QNC_VERIFIED_N = "N";
	public static final String QNC_VERIFIED_P = "P";
	
	public static final String FIVE_YR_BAR_APPLIES_Y = "Y";
	public static final String FIVE_YR_BAR_APPLIES_N = "N";
	public static final String FIVE_YR_BAR_APPLIES_P = "P";
	public static final String FIVE_YR_BAR_APPLIES_X = "X";
	
	public static final String FED_DATA_DUMMY = "D";

	public static final String HIX_LAWFUL_PRESENCE_VERIFIED = "Y";
	public static final String HIX_LAWFUL_PRESENCE_NOT_VERIFIED = "N";
	public static final String HIX_LAWFUL_PRESENCE_PENDING = "P";

	public static final String RESIDUAL_PRUCOL_OVERRIDE_YES = "Y";
	public static final String RESIDUAL_PRUCOL_OVERRIDE_NO = "N";

	public static final String VLP_MESSAGE_UNABLE_TO_VERIFY = "Unable to verify through SAVE interface";
	public static final String VLP_MESSAGE_SERVICE_CALL_EXCEPTION = "Service Failure Exception, VLP SAVE";
	public static final String PERSON_NOT_FOUND="PERSON_NOT_FOUND";
	public static final int SSN_FAILURE_CODE = 1;
	public static final int SSA_CITIZENSHIP_FAILURE_CODE = 2;
	public static final int SSA_INCARCERATION_FAILURE_CODE = 3;
	public static final int SSA_REQUEST_FAILURE_CODE = 4;
	public static final String SSA_INCARCERATION_DOCCS_SOURCE = "DOCCS";
	public static final String SSA_INCARCERATION_PUBS_SOURCE = "PUPS";

	public static final int VLP_EXCEPTION = 1;
	public static final int VLP_NODATA = 2;
	public static final int VLP_REVERIFICATION = 3;
	public static final int VLP_MISSING_REQUIREVAL = 4;

	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String PENDING = "P";
	public static final String PROCESSED = "P";

	public static final String NONCITCOACODE_1 = "1", NONCITCOACODE_2 = "2", NONCITCOACODE_3 = "3", NONCITCOACODE_4 = "4",
			NONCITCOACODE_5 = "5", NONCITCOACODE_6 = "6", NONCITCOACODE_7 = "7";
	public static final String NONCITCOACODE_H = "H", NONCITCOACODE_K = "K", NONCITCOACODE_N = "N", NONCITCOACODE_R = "R",
			NONCITCOACODE_S = "S", NONCITCOACODE_U = "U", NONCITCOACODE_V = "V";
	
	//Defect 45275
	//Added more COA codes for 48456
	public static final String REFUGEE_OR_ASYLEE_COACODE = "4-A,4-C,4-D,4-F,6,6A3,AM1,AM2,AM3,AM6,AM7,AM8,AS1,AS2,AS3,AS6,AS7,AS8,C7P,CC,CH,CH6,CP,CU6,CU7,CU8,CU9,CUP,IC6,IC7,K9,LB1,LB2,LB6,LB7,RE,RE1,RE2,RE3,RE4,RE5,R86,RE6,RE7,RE8,RE9,REF,S13,SI,SI1,SI2,SI6,SI7,SI8,SM0,SM1,SM2,SM3,SM4,SM5,SM6,SM7,SM8,SM9,SMO,SQ1,SQ2,SQ3,SQ6,SQ7,SQ8,SQ9,ST0,ST6,ST7,ST8,ST9,T1,T2,T3,T4,T5,T-3";
	
	public static final String VERIFIED = "VERIFIED";
	public static final String BIRTH_VERIFICATION_IND_CODE = "1";
	public static final String SSN_VERIFICATION_CODE_CIN = "8";
	public static final String NO_SSN_CODE_CIN = "N";

	public static final String NY_HX = "NY-HX";
	public static final String HIX_5YEAR_BAR_MET_Y = "Y";
	public static final String HIX_5YEAR_BAR_MET_N = "N";
	public static final String HIX_5YEAR_BAR_MET_P = "P";

	public static final String QUALIFIED_NONCITIZEN_INDICATOR_Y = "Y";
	public static final String QUALIFIED_NONCITIZEN_INDICATOR_N = "N";
	public static final String QUALIFIED_NONCITIZEN_INDICATOR_P = "P";

	public static final String HIX_QUALIFIED_NONCITIZEN_INDICATOR_Y = "Y";
	public static final String HIX_QUALIFIED_NONCITIZEN_INDICATOR_N = "N";
	public static final String HIX_QUALIFIED_NONCITIZEN_INDICATOR_P = "P";
	// Added as part of CR 1234
	public static final String HIX_PRUCOL_INDICATOR_Y = "Y";
	public static final String HIX_PRUCOL_INDICATOR_N = "N";

	public static final String MEDICAID = "MEDICAID";
	public static final String APTC_PREMIUM = "APTC_PREMIUM";
	public static final String EPP = "EPP";
	public static final String EPP_Aliessa = "EPP Aliessa";
	public static final String CHIP = "CHIP";
	public static final String REF_MEDICAID = "Refugee Medicaid";
	public static final String VHP = "Veterans";
	public static final String MEDICARE = "Medicare";
	public static final String TRICARE = "Tricare";
	public static final String PEACE_CORPS = "Peace Corps";
	public static final String AMERI_CORPS = "AmeriCorps";
	//Enhancement 45370 :Adding EPP Constant for  EP Program
	public static final String EP = "EPP";
	public static final String APPLICATION_GROUP_COVERAGE_TIER = "appGrpCoverageTier";
	public static final String APTC_TOTAL_SUBSIDY = "aptc_total_subsidy";
	public static final String FPL_CONSTANT = "SELECTED_APP_GROUP_FPL";

	public static final String STR_ZERO = "0";
	public static final String STR_ONE = "1";

	public static final String NYHX_WS_INBOUND_CANCEL_STATUS = "CANCEL";
	public static final String NYHX_WS_INBOUND_CONFIRM_STATUS = "CONFIRM";
	public static final String NYHX_WS_INBOUND_TERM_STATUS = "TERM";
	public static final String NYHX_WS_INBOUND_EFFECTUATE_STATUS = "EFFECTUATE";
	public static final String NYHX_WS_INBOUND_REINSTATE_STATUS = "REINSTATE";
	public static final String NYHX_WS_CANCEL_ENROLLMENT = "CANCEL_ENROLLMENT";
	public static final String NYHX_WS_TERMINATE_ENROLLMENT = "TERMINATE_ENROLLMENT";
	public static final String NYHX_WS_CANCEL_DEPENDENT = "CANCEL_DEPENDENT";
	public static final String NYHX_WS_TERMINATE_DEPENDENT = "TERMINATE_DEPENDENT";

	// Inbound 834 and 9999 response codes
	public static final String NYHX_WS_ENRL_ACK_RESPONSE_CODE_SUCCESS = "0000";
	public static final String NYHX_WS_ENRL_ACK_RESPONSE_CODE_INVALID_TXN = "0001";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_SUCCESS = "0000";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_TXN = "0001";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_PLANID_RECEIVED = "0003";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_NYHXSUSBCRIBERID_RECEIVED = "0004";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_NYHXMEMBERID_RECEIVED = "0005";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_TRANSACTION_MEMBERCOUNT_MISMATCH = "0006";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CANCEL_STATUS_RECEIVED = "0007";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CANCEL_INTERNAL_ERROR = "0008";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CANCEL_INVALID = "0009";
	public static final String NYHX_WS_RESPONSE_CODE_EXCEPTION = "9999";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_CONFIRM_STATUS_RECEIVED = "0010";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CANCEL_RECEIVED_AFTER_EFFECTUATION = "0011";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_TERM_RECEIVED_BEFORE_EFFECTUATION = "0012";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_TERM_STATUS_RECEIVED = "0013";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_PLAN_DATA_MATCHING_ISSUE = "0014";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_STATUS_RECEIVED = "0015";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CANCEL_STATUS_NOT_RECEIVED_FOR_MEMBERS = "0016";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_ISSUER_MEMBERID_NOT_RECEIVED = "0017";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CANCEL_RECEIVED_AFTER_CONFIRMATION_OR_EFFECTUATION = "0018";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CANCEL_OR_TERMINATE_REASON_NOT_RECEIVED = "0019";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CANCEL_PREVIOUSLY_RECEIVED = "0020";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_ONE_OR_MORE_MEMBERS_NOT_PART_OF_INBOUND = "0060";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_TERM_PREVIOUSLY_RECEIVED = "0061";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_EFFECTUATE_STATUS_RECEIVED = "0062";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_CONFIRM_PREVIOUSLY_RECEIVED = "0063";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_EFFECTUATE_PREVIOUSLY_RECEIVED = "0064";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_COVERAGEBEGINDATE_RECEIVED = "0065";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_INVALID_PLANCODE_RECEIVED = "0066";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_NO_POLICY_FOUND_FOR_SUBSCRIBER_PLAN_COVERAGE_BEGIN_DATE = "0067";
	public static final String NYHX_WS_ENRL_834_RESPONSE_CODE_COVERAGE_START_OVERRIDEN_PREVIOUSLY_FOR_MEMEBERS = "0069";

	

	// 834 Terminate Member
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_SUCCESS = "0000";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_ISSUERTRANACTIONID_RECEIVED = "0021";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_NYHXSUBSCRIBERID_RECEIVED = "0022";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_PLANCODE_RECEIVED = "0023";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_ISSUERSUSBCRIBERID_RECEIVED = "0024";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_ISSUERPOLICYNUMBER_RECEIVED = "0025";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_LASTPREMIUMPAIDDATE_RECEIVED = "0026";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_NYHXMEMBERID_RECEIVED = "0027";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_ISSUERMEMBERID_RECEIVED = "0028";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_ISSUERSTATUS_RECEIVED = "0029";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_REASONFORTERMINATION_RECEIVED = "0030";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_COVERAGEBEGINDATE_RECEIVED = "0031";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_COVERAGEENDDATE_RECEIVED = "0032";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_COVERAGE_BEGIN_DATE_MISMATCH = "0033";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_PLN_RECORDS_NOT_FOUND = "0034";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_TRANSACTION_MEMBERCOUNT_MISMATCH = "0035";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_PLN_ALREADY_DISENROLLED = "0036";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_CURRENT_DATE_LESS_THAN_USER_COVERAGE_START_DATE = "0037";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_NO_POLICY_FOUND_FOR_SUBSCRIBER_PLAN_COVERAGE_BEGIN_DATE = "0038";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_COVERAGE_END_DATE_PRECEDES_BEGIN_DATE = "0039";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_TERM_CANNOT_BE_APPLIED_TO_CANCELLED_POLICY = "0040";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_DUPLICATE_UPDATE_REQUEST = "0041";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_TERM = "0042";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_FUTURE_COV_END_DATE_IS_FOUND = "0043";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_SHOP_INVALID_TERM = "0044";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_ISSUERSTATUS_RECEIVED = "TERM";
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_TRANSACTION_MORE_MEMBERCOUNT = "0045";
	// cr1140 2015-06-02 KK: Unsupported EPP program for TERM or CANCEL: not allowing to term or cancel EPP with non-zero premium amt.
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_TERM_OR_CANCEL_EPP_PROGRAM = "0046";
	
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_CAUSING_COVERAGE_OVERLAP = "0047";
	
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_TERM_OR_CANCEL_SNP_PROGRAM = "0048";
	
	//Defect 80159
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_TERM_END_DATE = "0049";
	
	public static final String NYHX_WS_TERMINATE_MEMBER_ENRL_834_RESPONSE_CODE_FAILED_TO_POST_ENRLMNTMESG = "9944";

	// Outbound 834
	public static final String NYHX_OUTBOUND_834_ENRL_TERMINATION_CODE = "TERMINATED";
	public static final String NYHX_OUTBOUND_834_ENRL_CANCELLATION_CODE = "CANCELLED";
	
	// 834 Issuer Reinstate - response codes
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_SUCCESS = "0000";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_NYHXSUSBCRIBERID_RECEIVED = "0501";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_PLANCODE_RECEIVED = "0502";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_STATUS_RECEIVED = "0503";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_COVERAGEBEGINDATE_RECEIVED = "0504";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_NO_SUBMITTED_NONPAYMENT_TERM_CANCEL = "0505";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_TRANSACTION_MEMBERCOUNT_MISMATCH = "0506";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_NYHXMEMBERID_RECEIVED = "0507";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_NON_PAYMENT_TXN_NOT_FOUND = "0508";
	
	
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_REINSTATEMENT_IS_NOT_ALLOWED = "0509";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_PLAN_IS_NOT_VALID = "0510";
	
	//CR554
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_ACTIVE_COVERAGE = "0511";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_ACCOUNT_RESEQUENCE = "0512";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_ACCOUNT_DONOT_HAVE_RESEQUENCE_OR_DETERMINATION_ELIGIBILITY = "0513";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_COUNT_CHANGE = "0514";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_INELIGIBLE_FOR_QHP_PROGRAM = "0515";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_SUBSCRIBER_NOTELIGIBLE_FOR_QHP = "0516";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_PROGRAM_FOR_REINSTATEMENT= "0517";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_NEW_CHP_MEMBER_ADDED_IN_CURRENT_ELIIBILITY= "0518";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_INELIGIBLE_FOR_EPP_INCURRENT_ELIGIBILITY= "0519";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_SUBSCRIBER_INELIGIBLE_FOR_CHP_PROGRAM = "0520";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_SUBSCRIBER_CHP_TYPE_CHANGED = "0521";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_INELIGIBLE_FOR_CHP_PROGRAM = "0522";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_INELIGIBLE_FOR_ALL_PROGRAMS = "0523";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_INVALID_REINSTATE_COVERAGE_YEAR = "0524";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_MEMBER_SUBSCRIBER_CHP_COUNTY_CHANGED = "0525";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_MEMBER_DENTAL_REINSTATE_WITHOUT_MEDICAL_COVERAGE = "0526";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_PARTIAL_COVERAGE_EXISTS = "0527";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_MEMBER_EPP_ALIESSA_IN_CURRENT_ELIGIBILITY= "0528";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_PLAN_IS_NOT_SUPPORTED_IN_COUNTY = "0529";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_REINSTATEMENT_REQUEST_RECEIVED_AFTER_ELIGIBILITY_ENDED = "0530";
	
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_ACCOUNT_ALREADY_RENEWED = "0531";
	
	public static final String RECEIVED_MEMBER_HAVING_ACTIVE_COVERAGE = "Received member having active coverage";
	public static final String RECEIVED_MEMBER_ACCOUNT_RESEQUENCE = "Received member's account is in Resequence";
	public static final String RECEIVED_MEMBER_ACCOUNT_DONOT_HAVE_RESEQUENCE_OR_DETERMINATION_ELIGIBILITY = "Received member current eligibility is not resequenced or determined";
	public static final String RECEIVED_MEMBER_COUNT_CHANGE = "Received member not present in determined eligibility";
	public static final String RECEIVED_MEMBER_INELIGIBLE_FOR_QHP_PROGRAM = "Received member ineligible for QHP Program";
	public static final String RECEIVED_MEMBER_SUBSCRIBER_INELIGIBLE_FOR_QHP_PROGRAM = "Received member's subscriber ineligible for QHP Program";
	public static final String RECEIVED_MEMBER_INVALID_PROGRAM_FOR_REINSTATEMENT = "Received member having invalid program for reinstatement";
	public static final String RECEIVED_MEMBER_NEW_CHP_MEMBER_ADDED_IN_CURRENT_ELIIBILITY = "Received member account has new CHP eligible member";
	public static final String RECEIVED_MEMBER_INELIGIBLE_FOR_EPP_INCURRENT_ELIGIBILITY = "Received member ineligible for EPP in current eligibility";
	public static final String RECEIVED_MEMBER_SUBSCRIBER_INELIGIBLE_FOR_CHP_PROGRAM = "Received  member's subscriber ineligible for CHP Program";
	public static final String RECEIVED_MEMBER_SUBSCRIBER_CHP_TYPE_CHANGED = "Received  member's subsidized CHP type changed";
	public static final String RECEIVED_MEMBER_INELIGIBLE_FOR_CHP_PROGRAM = "Received member ineligible for CHP Program";
	public static final String RECEIVED_MEMBER_INELIGIBLE_FOR_ALL_PROGRAMS = "Received member ineligible for all program";
	public static final String RECEIVED_MEMBER_INVALID_REINSTATE_COVERAGE_YEAR = "Received member reinstatement request invalid for coverage year";
	public static final String RECEIVED_MEMBER_SUBSCRIBER_CHP_COUNTY_CHANGED = "Received member subscriber County change for CHP Program";
	public static final String RECEIVED_MEMBER_DENTAL_REINSTATE_WITHOUT_MEDICAL_COVERAGE = "Received Dental coverage re-instatement request for member without medical coverage";
	public static final String RESPONSE_CODE_NON_PAYMENT_TXN_NOT_FOUND ="Non-payment TERM/CANCEL policy not found.";
	public static final String RESPONSE_CODE_REINSTATEMENT_IS_NOT_ALLOWED ="Reinstatement is not allowed.";
	public static final String RESPONSE_CODE_PLAN_IS_NOT_VALID ="Invalid Plan.";
	public static final String RECEIVED_MEMBER_HAVING_PARTIAL_COVERAGE = "Received member had partial coverage after non payment term";
	public static final String RECEIVED_MEMBER_EPP_ALIESSA_IN_CURRENT_ELIGIBILITY = "EP eligibility changed from non-aliessa to aliessa";
	public static final String RESPONSE_CODE_PLAN_IS_NOT_SUPPORTED_COUNTY ="Plan is not supported in the member's county";
	public static final String RECEIVED_MEMBER_ACCOUNT_ALREADY_RENEWED = "Received member's account is already renewed";
	public static final String RESPONSE_CODE_REINSTATEMENT_REQUEST_RECEIVED_AFTER_ELIGIBILITY_ENDED = "Reinstatement request received after eligibility ended.";
	public static final String RESPONSE_EXCEPTION = "Application Exception";
	
	
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_CODE_NO_PREV_ENROLLMENT = "9997";
	

	public static final String HIX_RESTRICTED_FLAG = "Y";

	public static final int ALIENNUMBERLENGTH = 9;
	public static final int CITIZENSHIPNUMBERMAXLENGTH = 12;
	public static final int CITIZENSHIPNUMBERMINLENGTH = 7;
	public static final int DOCUMENTSEVISIDNUMBERLENGTH = 10;
	public static final int I94NUMBERLENGTH = 11;
	public static final int PASSPORTNUMBERMINLENGTH = 6;
	public static final int PASSPORTNUMBERMAXLENGTH = 12;
	public static final int RECEIPTNUMBERLENGTH = 13;
	public static final int VISANUMBERLENGTH = 8;
	public static final int NATURALIZATIONNUMBERMAXLENGTH = 12;
	public static final int NATURALIZATIONNUMBERMINLENGTH = 7;
	public static final int DOCUMENTDESCMINLENGTH = 1;
	public static final int DOCUMENTDESCMAXLENGTH = 35;

	public static final Integer INT_ZERO = 0;
	public static final Integer INT_ONE = 1;
	public static final Integer FPL_FULLPAY = 400;
	public static final String CHIP_PREMIUM_NOT_FOUND_MSG = "Full Pay CHIP Premium";
	public static final String BLANK = "";
	public static final String IDPROOFING_FAULT = "FAULT";
	public static final String BACK_OFFICE_ID_PROOFING = "BACK_OFFICE_ID_PROOFING";

	// ALFRESCO Document upload- default buffer size
	public final static int DEFAULT_BUFFER_SIZE = 1024 * 1024 * 3;

	// Constants for Special Rules
	public static final int CHILD_MIN_AGE = 60;
	public static final int NB_CHILD_MAX_AGE = 365;
	public static final int CHILD_MAX_AGE = 18;
	public static final int AGE_RETIREMENT = 62;
	//CR1193 (Child min age should be 75 )
	public static final int AP_CHILD_MIN_AGE = 90;

	// R2B4 Special Rules Page Ids 06_15_2013
	public final static String PAGE_ID_ABSENT_PARENT = "ext/hx_absentparent";
	public final static String PAGE_ID_OTHER_BENEFITS = "ext/hx_sr_other";
	public final static String PAGE_ID_INSURANCE_BENEFITS_CHILD_COVERAGES = "ext/hx_insurancebenefitschildcoverages";
	public final static String PAGE_ID_INSURANCE_BENEFITS_CHILD = "ext/hx_insurancebenefitschild";
	public final static String PAGE_ID_INSURANCE_BENEFITS_ADULT_COVERAGES = "ext/hx_insurancebenefitsadultcoverages";
	public final static String PAGE_ID_INSURANCE_BENEFITS_ADULT = "ext/hx_insurancebenefitsadult";
	public static final String PAGE_ID_INCARCERATION = "ext/hx_sr_incarceration";
	public static final String PAGE_ID_RESIDENCYTEST = "ext/hx_residencytest";
	public static final String PAGE_ID_DASHBOARD_MAIN = "hx_dashboard_main";
	public static final String PAGE_ID_INCARCERATION_NOTFOUND = "ext/hx_sr_incarcerationQuestion";

	public static final String REL_TYPE_PARENT_ABSENT = "03";

	public static final Long NONESI_MEC_SERVICE_MAX_HIT_COUNT = 1l;
	// Eligibility Determination constants

	public final static double LIVING_WITH_PARENT_19_20_FPL = 133d;
	public final static int ELG_DEP_CHILD_AGE_MIN = 18;
	public final static int ELG_DEP_CHILD_AGE_MAX = 20;
	public final static int ELG_INT_TWENTY_ONE = 21;
	public static final String POINTER_DATE = "12/31/2013";

	public static final String DISABLED_SERVICES_WAIVER = "1";
	public static final String DISABLED_SERVICES_PERSON_HOME_CARE = "2";

	public static final String CIN_UPSTATE_IND = "01";
	public static final String CIN_DOWNSTATE_IND = "02";
	public static final String CIN_UPSTATE_AND_DOWNSTATE_IND = "03";
	public static final String CIN_UP_DOWN_STATE_IND_NONE = "04";

	// No Employer Coverage Reason Code
	public static final String NO_EMPLOYER_REASON_CD_00 = "00";
	public static final String NO_EMPLOYER_REASON_CD_01 = "01";
	public static final String NO_EMPLOYER_REASON_CD_02 = "02";
	public static final String NO_EMPLOYER_REASON_CD_03 = "03";
	public static final String NO_EMPLOYER_REASON_CD_04 = "04";
	public static final String NO_EMPLOYER_REASON_CD_05 = "05";

	// Lost Coverage reason code
	public static final String LOST_COVERAGE_REASON_CD_NONE = "11";
	public static final String LOST_COVERAGE_REASON_CD_CHILD_COV_COST = "07";
	// Health Coverage Type Adult
	public static final String HEALTH_COVREAGE_TYPE_ADULT_COVERAGE_UNDER_ESH = "0";
	public static final String HEALTH_COVREAGE_TYPE_ADULT_COBRA = "1";
	public static final String HEALTH_COVREAGE_TYPE_ADULT_RETIREE = "2";

	// Health Coverage Type Child
	public static final String HEALTH_COVREAGE_TYPE_CHILD_COVERAGE_UNDER_ESH = "0";
	public static final String HEALTH_COVREAGE_TYPE_CHILD_COBRA = "1";
	public static final String HEALTH_COVREAGE_TYPE_CHILD_RETIREE = "2";
	
	//CR1346:"None of the above Coverage" option in ESI screen
	public static final String HEALTH_COVREAGE_TYPE_CHILD_NONE = "15";

	// Appeals
	public final static String PAGE_ID_APPEAL_INTRODUCTION = "hx_appealIntro";
	public final static String PAGE_ID_APPEAL_DETERMINATION = "hx_appealDetermination";
	public final static String PAGE_ID_APPEAL_ACKNOWLEDGE = "hx_appealAcknowledge";
	public final static String PAGE_ID_APPEAL_CONFIRM = "hx_appealConfirm";

	public final static String APPL_REASON_OTHER_CODE = "OT";
	public final static String APPL_SPECIAL_OTHER_CODE = "OT";

	public final static int MARKET_IND_INDV = 0;
	public final static int MARKET_IND_SHOP = 1;
	public final static int MARKET_IND_BOTH = 2;
	public final static String APPL_LANGUAGE_OTHER_CODE = "OTHER";

	// Special Rules
	public final static String COVERAGECODE_VAL = "15";
	public final static long TOTAL_CALCULATED_AMT = 10000000000000L;
	public final static long COVERAGE_COST = 100000L;
	public final static int COVERAGE_COST_FIELD_LENGTH = 8;
	public final static int IDNUMBER_LENGTH = 30;
	public final static int POLICYNUMBER_FIELD_LENGTH = 15;
	public final static int MAX_ALLOWED_AGE = 120;
	public final static int MIN_ABSENT_PARENT_AGE = 10;
	public final static String ZERO = "0";
	public final static String ONE = "1";
	public final static String NONCITCOACD = "A-1, A-2, A-3, A1, A2, A3, B-1, B-2, B1, B2, BE, C-1, C-2, C-3, C-4, C1, C2, C3, C4, C4?, D-1, D-2, D1, D2, E-1, E-2, E1, E2, E2C, E3, F-1, F-2, F1, F2, F3, G-1, G-2, G-3, G-4, G-5, G1, G2, G3, G4, G5, GB, GR, GT, H-3, H-4, H1, H1A, H1B, HSC, H1C, H2, H2A, H2B, H2R, HR, H3, H3A, H3B, H4, I, I1, J-1, J-2, J1, J2, L-1, L-2, L1, L1A, L1B, L2, M1, M2, M3, N-1, N-2, N-3, N-4, N-5, N-6, N-7, N1, N1?, N2, N3, N4, N5, N6, N7, 0-1, 0-2, 0-3, 01, 02, 03, 3, O1, O1A, O1B, O2, O3, OFM, OFO, P-1, P-2, P-3, P-4, P1, P1A, P1B, P1S, P2, P2S, P3, P3S, P4, Q1, Q1M, Q2, Q2M, Q3, Q3M, R1, R2, R2M, S3, S4, S8, S9, TD, TN, TN1, TN2";

	// Basic Info
	public final static String ON = "on";
	public final static String FIVE = "5";

	public final static String THREE_STATE_YES = "1";
	public final static String THREE_STATE_NO = "1";
	public final static String THREE_STATE_DONOTKNOW = "1";

	// Batch and Re-sequence
	public final static int BATCH_CHUNK_COUNT = 100;

	public static final int MAXLENGTH_YEARSWORKING = 3;
	public static final int MINLENGTH_YEARSWORKING = 1;

	// Re-sequence Additional Info Exception length
	// This is VARCHAR(5000) in Database but keeping well within range as some
	// special characters may need more than one byte.
	public static final int RESEQ_ADD_INFO_LENGTH = 32000;

	// Batch and Re-sequence
	public final static int RESEQUENCE_CHUNK_COUNT = 100;

	// Income service status codes
	public static final String FED_RESP_SUCCESS = "0000";
	public static final String DTF_RESP_SUCCESS = "0000";
	public static final String UIB_RESP_SUCCESS = "0000";

	// dental
	public static final String DENTAL_ONLY = "dentalOnly";
	public static final String DENTAL = "DENTAL";
	public static final String MEDICAL = "MEDICAL";
	public static final String QHP = "QHP";

	// Plan selection dashboard medical and dental indicators
	public static final String NYHX_PLAN_SELECTION_INDICATOR_NO_SELECTION = "NO_SELECTION";
	public static final String NYHX_PLAN_SELECTION_INDICATOR_HEALTH_DENTAL = "HEALTH_DENTAL";
	public static final String NYHX_PLAN_SELECTION_INDICATOR_HEALTH_DENTAL_COMBINED = "HEALTH_DENTAL_COMBINED";
	public static final String NYHX_PLAN_SELECTION_INDICATOR_HEALTH_ONLY = "HEALTH_ONLY";
	public static final String NYHX_PLAN_SELECTION_INDICATOR_DENTAL_ONLY = "DENTAL_ONLY";
	// Immigratiom
	public static final int ELGSTMTCD_INSTITUTR_ADDITIONAL_VTERIFICATION = 5;
	public static final int IAPPLICATIONPENDING_TEMPORARY_EMPLOYMET_AUTHORIZED = 7;

	public final static String PRUCOLNONCITCOACD = "FSM, K1, K2, K3, K3M, K4, K4M, MIS, N-8, N-9, N8, N9, S5, S6, S7, TPS, U1, U2, U3, U4, U5, V-1, V-2, V-3, V1, V1M, V2, V2M, V3";
	
	// Added as part of the CR 1234 and Enhancement 50063.
	public final static String PRUCOLNONCITPENCOACD = "PEN";
	public final static String PRUCOLNONCITEXPEDITEDCOACD = "ER,EP,EF";
	public static final String ALIEN_EXPIRATION_DAYS="30";
	public static final String IMMG_ELG_STATMNT_CODE_TEN="10";
	public static final String IMMG_ELG_STATMNT_CODE_ONE_EIGHT_EIGHT="188";
	
	// In PLan selection enrollment mandatory exemption values for medicaid
	public static final String NYHX_PLAN_SELECTION_MANDATORY_EXEMPTION_FOR_MEDICAID_VALUES = "22,23,24,25,38,39,44,45,46,47,48,49,50,51,60,62,63,64,64,66,67,68,69,70,71,72,73,74,75,76,77,78,81,84,85,86,91,93,95,98";
	// In plan selection NYC County code
	public static final String NYHX_PLAN_SELECTION_NYC_COUNTY_CODE_VALUES = "36085,36081,36061,36047,36005";
	
	// EPP CR 1140
	public static String DENTAL_PLAN_APPLICABLE_PROGRAM = "DENTAL_PLAN_APPLICABLE_PROGRAM";
		
	
	// In plan selection cart selection constants
	public static final String NYHX_PLAN_SELECTION_CART_SELECTION_INTERMEDIATE_STATE = "IntermediateState";
	public static final String NYHX_PLAN_SELECTION_CART_SELECTION_CONFIRM_PLAN_STATE = "ConfirmSelectedPlans";
	public static final String NYHX_PLAN_SELECTION_CART_SELECTION_FINAL_PLAN_STATE = "FinalState";

	public static final String NYHX_PLAN_DISENROLLMENT_INTERMEDIATE_STATE = "IntermediateDisenrollState";

	public static final String EMPLOYEE_TOKEN = "isEmployee";

	public static String NYHX_PLAN_SELECTION_MATCHED_PROGRAM = "MATCHED_PROGRAM";

	public static String NYHX_NON_SEP_MATCHED_PROGRAM = "NON_SEP_MATCHED_PROGRAM";

	// LDSS Referral related constants
	public static final String RACE_BLACK_AFRICAN_AMERICAN = "3";
	public static final String RACE_ASIAN_INDIAN = "2";
	public static final String RACE_OTHER_ASIAN = "10";
	public static final String RACE_NORTH_HAWAIIAN = "9";
	public static final String RACE_OTHER_PACAFIC_ISLANDER = "11";
	public static final String RACE_WHITE = "14";

	public static final String LDSS_LANG_ENGLISH = "E";
	public static final String LDSS_LANG_SPANISH = "S";

	public static final String NOTICES_ENGLISH_SUFFIX="_EN";
	public static final String LDSS_DEMOGRAPHICS_UNDOMICILED = "Undomiciled";
	public static final String LDSS_DEMOGRAPHICS_DEFAULT_HOUSENO = "999";

	public static final String LDSS_HDR_SUBMITTER_ID = "0040";
	public static final String LDSS_HDR_PROVIDER_ID = "99998883";
	public static final String LDSS_HDR_SUBMISSION_TYPE = "H";
	public static final String LDSS_DATA_REC_SUBMISSION_TYPE = "N";
	public static final String LDSS_HHCOMP_REC_SUBMISSION_TYPE = "M";
	public static final String LDSS_TRAILER_REC_SUBMISSION_TYPE = "T";

	public static final String LDSS_COUNTY_CODE_DOWNSTATE = "66";

	public static final String PHONE_TYPE_HOME = "Home";
	public static final String PHONE_TYPE_CELL = "Cell";

	public static final String INDICATOR_UPSTATE = "01";
	public static final String INDICATOR_DOWNSTATE = "02";

	public static final String BATCH_ARG_UPDOWNSTATEIND_UPSTATE = "Upstate";
	public static final String BATCH_ARG_UPDOWNSTATEIND_DOWNSTATE = "Downstate";
	public static final String BATCH_ARG_UPDOWNSTATEIND_BOTH = "Both";

	public static final int APTC_SERVICE_FAULT_TEXT_MAX_LENGTH = 100;
	public static final String APTC_SERVICE_BAD_RESPONSE = "HS009000";

	public static final String ERR_MSG_INSURABLE_REL_NOT_FOUND = " does not have satisfiable criteria [Household/Tax relationship] with ";

	public static enum APPLICATION {
		EMPLOYEE, EMPLOYER, INDIVIDUAL, CSR, AGENT
	};

	public static enum EnrollmentPeriodStatusEnum {
		ACTIVE, DEACTIVE;
	}

	public static final int NYHX_PLAN_SELECTION_GROUP_SIZE_FOR_SBSIZD_CHIP_OUT_OF_PCKT_PAY = 3;

	public final static String MEC_ACTIVE_STATUS = "ACTIVE";

	public final static int CHIP_AGE_LIMIT = 19;
	public final static int PRE_MEDICAID_AGE_LIMIT = 64;
	public final static int MEDICAID_AGE_LIMIT = 65;
	
	public final static int MEDICAID_AUTO_ENROLLMENT_DAYS = 10;
	
	
	public static final int PLAN_OPTIONS_KID_AGE_UPTO_29 = 29;
	public static final int PLAN_OPTIONS_KID_AGE_UPTO_19 = 19;
	public static final int PLAN_OPTIONS_KID_AGE_UPTO_26 = 26;
	public static final int PLAN_OPTIONS_CATASTOPHIC_SPOUSE_AGE_UPTO_29 = 29;
	public static final int PLAN_OPTIONS_EP_MEDICAID_AGE_UPTO_65 = 65;
	public static final int PLAN_OPTIONS_APTC_AGE_UPTO_65 = 65;
	public static final String ENROLLMENT_PLAN_SEL_INTRO_STD_PAGE_URL = "/prescreen/ext/hx_planSelectionIntro";
	public static final String ENROLLMENT_PLAN_SEL_INTRO_PAGE_WITH_RESEQ = "/prescreen/ext/hx_planSelectionIntroReSeq";
	public static final String ENROLLMENT_PLAN_SEL_INTRO_PAGE_WO_NEXT_BTN = "/prescreen/ext/hx_planSelectionIntroNoPlan";
	public static final String ENROLLMENT_PLAN_SEL_INTRO_PAGE_WO_NEXT_BTN_LOSSMEC_DUETO_59 = "/prescreen/ext/hx_planSelectionIntroNoPlanInSEPLossOfMECDueToCoverageEndCode59";
	public static final String ENROLLMENT_PLAN_SEL_INTRO_WITH_PEND = "/prescreen/ext/hx_planSelectionIntroWithPend";
	public static final String ENROLLMENT_PLAN_SEL_INTRO_WITH_ALL_MEMBERS_PEND = "/prescreen/ext/hx_planSelectionIntroWithAllMembersPend";
	public static final String ENROLLMENT_PLAN_SEL_INTRO_WITH_INELIGIBILITY = "/prescreen/ext/hx_planSelectionIntroWithIneligibility";
	public static final String ENROLLMENT_PLAN_SEL_INTRO_PAGE_WITH_NO_OEP_OR_SEP = "/prescreen/ext/hx_planSelectionIntroNoOEPORSEP";
	public static final String ENROLLMENT_PLAN_SPECIAL_ENROLLMENT_PERIOD_PAGE = "/deligibility/ext/hx_specialEnrollmentPeriod";
	public static final String SPENDDOWN_PAGE_URL  = "/prescreen/ext/hx_spendDown";
	public static final String AUTO_DISENROLL_MEMBER_PAGE_URL = "/prescreen/ext/hx_autoDisenrollMemberDetails";
	//CR#1327- Added for New born auto enroll
	public static final String AUTO_ENROLL_NEW_BORN_MEMBER_PAGE_URL = "/prescreen/ext/hx_autoEnrollNewBornMemberDetails";
	public static final String ACTIVE_COVERAGE_YEAR_PREFERENCE_PAGE_URL ="/deligibility/ext/hx_prospectiveCoverageYearPreference";
	// EPP CR 1140
	public static final String AUTO_ENROLL_MEMBER_PAGE_URL = "/prescreen/ext/hx_autoEnrollMemberDetails";
	public static final String ENROLLMENT_PLAN_SEL_INTRO_PAGE_WO_NEXT_BTN_PAST_ELG = "/prescreen/ext/hx_planSelectionIntroPastElg";

	public static final String GENDER_MALE = "M";
	public static final String GENDER_FEMALE = "F";

	public static final int CATASTROPHIC_AGE_LIMIT_LE29 = 29;

	public static final int HX_HEALTH_PLANS_COMPATIBLE = 1;
	public static final int HX_DENTAL_PLANS_COMPATIBLE = 2;
	public static final int HX_PLANS_INCOMPATIBLE = 0;

	public static String PRESCREEN_ID_PROOF_TYPE = "PRESCREEN_ID";

	// Job Names
	public static final String BATCH_WORKITEM_STATUS_INPROGRESS = "INPROGRESS";
	public static final String JOB_NAME_RESEQUENCE = "JOB_RESEQUENCE";
	public static final String JOB_NAME_OTDANEWBORN = "JOB_OTDANEWBORN";
	public static final String JOB_NAME_VLPRESOLVEDCASES = "JOB_VLPRESOLVEDCASE";
	public static final String JOB_NAME_AUTO_ENROLLMENT = "JOB_NAME_AUTO_ENROLLMENT";
	public static final String JOB_NAME_INCARCERATION = "JOB_INCARCERATION";
	public static final String JOB_NAME_INCARCERATION_REPORT = "JOB_INCARCERATION_REPORT";	
	public static final String JOB_NAME_NYS_DOCCS_SUSPEND = "JOB_NAME_NYS_DOCCS_SUSPEND";	
	public static final String JOB_NAME_CS_BNC = "JOB_CS_BNC";
	public static final String JOB_NAME_CS_RAW_EVENTS = "JOB_CS_RAW_EVENTS";
	public static final String JOB_NAME_CS_PAPER_NOTICES = "JOB_CS_PAPER_NOTICES";
	public static final String JOB_NAME_ELG_CHANGE = "JOB_ELG_CHANGE";
	public static final String JOB_NAME_SYSTEM_EVENT_GEN = "JOB_SYSTEM_EVENT_GEN";
	public static final String JOB_NAME_SYSTEM_EVENT_PROCESSOR = "JOB_NAME_SYSTEM_EVENT_PROCESSOR";
	public static final String JOB_ELG_RENEWAL = "JOB_ELG_RENEWAL";
	//CR#1269-start
	public static final String JOB_ELG_RENEWAL_LOADER = "JOB_ELG_RENEWAL_LOADER";
	//CR#1269-End
	public static final String JOB_SHOP_MEMBER_DISENROLL = "JOB_SHOP_MEMBER_DISENROLL";
	public static final String JOB_ELG_RENEWAL_ADMIN_WATCHER = "JOB_ELG_RENEWAL_ADMIN_WATCHER";
	public static final String JOB_ELG_RENEWAL_MANUAL_WATCHER = "JOB_ELG_RENEWAL_MANUAL_WATCHER";
	public static final String JOB_ENRL_1095_DATA_ADJUSTMENT = "JOB_ENRL_1095_DATA_ADJUSTMENT";
	public static final String JOB_ENROLLMENT_PLAN_COVERAGE_PROVIDER="JOB_ENROLLMENT_PLAN_COVERAGE_PROVIDER";
	public static final String JOB_UTIL = "JOB_UTIL";
	public static final String JOB_NON_DETERMINISTIC_CLOCK_WATCHER =  "JOB_NON_DETERMINISTIC_CLOCK_WATCHER";
	public static final String JOB_NON_DET_DECEASED_CLOCK = "JOB_NON_DET_DECEASED_CLOCK";
	public static final String JOB_NON_DET_MA_DEEMED_NB_13MON_AGEOUT_CLOCK = "JOB_NON_DET_MA_DEEMED_NB_13MON_AGEOUT_CLOCK";
	public static final String JOB_NAME_RETRO = "JOB_RETRO";
	public static final String JOB_NAME_CINCLEARANCE = "JOB_CINCLEARANCE";
	public static final String JOB_ELG_RENEWAL_SYSGEN = "JOB_ELG_RENEWAL_SYSGEN";
	public static final String JOB_NAME_EXPIRE_SHELL_ACCOUNT = "JOB_NAME_EXPIRE_SHELL_ACCOUNT";
	public static final String MEDICAID_EQUIVALENT_CODE_FOR_CIN = "MA";
	public static final String APTC_PREMIUM_EQUIVALENT_CODE_FOR_CIN = "PP";
	//Enhancement 45370:  Adding constants for equivalent code for EP Program 
	//TODO : Verifying the value of EPP code for CIN. Is this is same as Medicad.
	public static final String EP_EQUIVALENT_CODE_FOR_CIN = "MA";
	public static final String CIN_CLEARANCE_CODE_IN_PROGRESS = "IN_PROGRESS";
	public static final String CIN_CLEARANCE_CODE_SUBMITTED = "SUBMITTED";
	public static final String CIN_CLEARANCE_CODE_OBSELETE = "OBSOLETE";
	public static final String CIN_CLEARANCE_CODE_DETERMINED = "DETERMINED";

	public static final String VALID_MEC_INS_START_DATE = "02/01/2014";

	public final static String MEDICAID_EXEMPTION_CODES = "22,23,24,25,38,39,44,45,46,47,48,49,50,51,60,62,63,64,64,66,67,68,69,70,71,72,73,74,75,76,77,78,81,84,85,86,90,91,93,95,98";
	public final static List<String> MEDICAID_EXEMPTION_CODE_LIST = HXUtility.convertStringToListStr(MEDICAID_EXEMPTION_CODES, ",");

	public final static String MEDICAID_RATE_CODE_2201 = "2201";
	public final static String MEDICAID_RATE_CODE_2205 = "2205";
	public final static String MEDICAID_RATE_CODE_2200 = "2200";

	public final static int MEDICAID_CO_PAY_EXEMPTION_AGE_LIMIT = 21;
	public final static int MEDICAID_CO_PAY_EXEMPTION_PREG_PAST_DUE_MONTH_LIMIT = 2;
	public final static String MEDICAID_CO_PAY_EXEMPTION_RRE_CODE = "35";

	public final static String MEDICAID_MMC_DATE_NOT_TO_BE_PROCESSED = "09/09/2999";

	public static final String COBRA_CLASS = "COBRA_INTERNAL";

	public static final int COBRA_PERIOD = 75;

	public static final String COBRA_REASON_CODES[] = { "RETIREMENT", "TERMINATED", "LAID OFF", "NO LONGER FULL-TIME" };

	public static final int ASSURANCE_LEVEL_2 = 2;
	
	public static final int ASSURANCE_LEVEL_1 = 1;

	public static final int ASSURANCE_LEVEL_3 = 3;
	public static final String DEV_ENVIRONMENT = "-dev";

	public static final String CASE_TYPE_CODE_MEDICAID = "20";
	public static final String CASE_TYPE_CODE_APTC_PP = "24";
	//Enhancement 45370:  Adding constants for equivalent code for EP Program 
	public static final String CASE_TYPE_CODE_EP = "26";
	
	/* LSC EVENTS CONSTANTS */
	public final static String LSC_MARRIAGE = "Marriage";
	public final static String LSC_MARRIAGE_NAME_CHANGE = "Marriage Name Change When Spouse not Exists";  
	public final static String LSC_DIVORCE = "Divorce/Legal Separation";
	public final static String LSC_BIRTH = "Birth";
	public final static String LSC_ADOPTION = "Adoption";
	public final static String LSC_ENROLLMENT_ERROR = "Enrollment Error";
	public final static String LSC_MATERIAL_BREACH_OF_CONTRACT = "Material Breach of Contract";
	public final static String LSC_RELOCATION = "Relocation";
	public final static String LSC_AMERICAN_INDIAN_ALASKAN_NATIVE = "American Indian/Alaskan Native";
	public final static String LSC_SEPARATION_FROM_SERVICE = "Separation from Service";
	public final static String LSC_BENEFITS_COVERAGE_ELIMINATION = "Benefits/Coverage Elimination";
	public final static String LSC_LEGAL_ORDERS = "Legal Orders";
	public final static String LSC_DEATH = "Death";
	public final static String LSC_DEPENDENT_STATUS_CHANGE = "Remove Enrolled Dependent(s)";// ANY_CHANGE
	public final static String LSC_LOSS_OF_MEDICAID_CHIP_COVERAGE = "Loss of Medicaid/CHIP Coverage"; // ADD_MEMBER
	public final static String LSC_LOSS_OF_ISURANCE_FOR_QUALIFIED_INDV = "Loss of Health Insurance for Qualified Dependent"; // ADD_MEMBER
	public final static String LSC_ERROR_CHANGE_START_DATE = "Override Coverage Start Date";
	public final static String LSC_REPORTED_REASON="LSC REPORTED";
	public final static String LSC_CANCELLED_REASON="LSC CANCELLED";
	public final static String LSC_AGEOUT_DISENROLLMENT="Age Out Member Disenrollment";

	public static final String NEWBORN_FLAG_1 = "1";
	public static final String NEWBORN_FLAG_2 = "2";
	public static final String NEWBORN_FLAG_3 = "3";
	public static final String NEWBORN_FLAG_4 = "4";
	public static final String NEWBORN_DATE_FORMAT = "yyyyMMdd";
	public static final String NEWBORN_MOTHER_MATCH_FOUND = "78";

	public static final String NB_ADD_MEMBER_REASON = "2";
	public static final String ADD_MEMBER_EVENT = "ADD";
	public static final String APPLICANT = "Applicant";
	public static final String HEALTH_OPTIONS_EDIT = "HealthOptions";
	public static final String ADD_DENTAL_OPTIONS = "AddDentalOptions";
	public static final String REMOVE_DENTAL_OPTIONS = "RemoveDentalOptions";
	public static final String BENEFITS_EDIT = "Benefits";
	public static final String DATES_EDIT = "Dates";
	public static final String NOTICE_FOR_NOTIFY = "N0001";
	public static final String NOTICE_FOR_CONTRI_RETRO = "N0002";
	public static final String NOTICE_FOR_CONTRI_EDIT = "N0003";
	public static final String NOTICE_FOR_AUTHORISE = "N0004";

	public static final Double CHIP_FULL_PAY_FPL = 1000d;

	public static final int DAY_VAL = 15;

	public static final String UNBORN_ENROLL_CANCEL_STATUS = "CANCEL_ENROLLMENT";

	public static final String EVENT_ELG_RESULT_PREV_PROG_ID = "eventPrevProgId";
	public static final String EVENT_ELG_RESULT_CURRENT_PROG_ID = "eventCurrentProgId";
	public static final String USERPROFILE_ACTIVE_STATUS = "0";
	public static final String USERPROFILE_INACTIVE_STATUS = "1";

	public static final String USERPROFILE_ACTIVE_NOTICE_SUPPRESS_IND = "1";
	public static final String USERPROFILE_INACTIVE_NOTICE_SUPPRESS_IND = "0";

	public static final String NEW_APPLICATION_EVENT = "NEW_APPLICATION_EVENT";
	public static final String MEMBER_DATA_CHANGE_EVENT = "MEMBER_CHANGE_EVENT";
	public static final Long NEW_APPLICATION_EVENT_ID = -100L;

	public static final String EVENT_MEDICAID_PREV_AID_CATEGORY = "eventPrevAidCategory";
	public static final String EVENT_MEDICAID_CURR_AID_CATEGORY = "eventCurrAidCategory";
	
	public static final String EVENT_EPP_PREV_AID_CATEGORY = "eventPrevAidCategory";
	public static final String EVENT_EPP_CURR_AID_CATEGORY = "eventCurrAidCategory";

	public static final String EVENT_MEDICAID_PREV_COVERAGE_CODE = "eventPrevCoverageCode";
	public static final String EVENT_MEDICAID_CURR_COVERAGE_CODE = "eventCurrCoverageCode";
	public static final String NO_DOCUMENT_TYPE = "NO_DOC";
	public static final String NO_DOCUMENT = "No Document";

	public static final String EVENT_MEDICAID_PREV_CHARGE_CODE = "eventPrevChargeCode";
	public static final String EVENT_MEDICAID_CURR_CHARGE_CODE = "eventCurrChargeCode";

	public static final String EVENT_ADD_REASON_CODE = "eventAddReasonCode";
	public static final String EVENT_UPDATE_REASON_CODE = "eventUpdateReasonCode";
	public static final String EVENT_DISENROLL_REASON_CODE = "eventDisenrollReasonCode";
	public static final String HH_INCOME_CHANGED_YES = "1";
	public static final String HH_INCOME_CHANGED_NO = "0";

	public static final String EVENT_RETRO_START_DATE = "eventRetroStartDate";
	public static final String EVENT_RETRO_END_DATE = "eventRetroEndDate";
	public static final String EVENT_RETRO_MONTH = "eventRetroMonth";
	public static final Integer SUPER_USER_LSC_PERIOD = 10;

	public static final String FC_CASE_TYPE_CD_01 = "11,12,16,17";
	public static final String FC_CASE_TYPE_CD_02 = "22";
	public static final String FC_CASE_TYPE_CD_03 = "13,20,40";

	public static final List<String> FC_CASE_TYPE_CD_01_L = HXUtility.convertStringToListStr(FC_CASE_TYPE_CD_01,
			DELIMITER_DEFAULT_STRING);
	public static final List<String> FC_CASE_TYPE_CD_02_L = HXUtility.convertStringToListStr(FC_CASE_TYPE_CD_02,
			DELIMITER_DEFAULT_STRING);
	public static final List<String> FC_CASE_TYPE_CD_03_L = HXUtility.convertStringToListStr(FC_CASE_TYPE_CD_03,
			DELIMITER_DEFAULT_STRING);

	public static final String FC_CLOSE_REASON_CD_01 = "01";
	public static final String FC_CLOSE_REASON_CD_02 = "02";
	public static final String FC_CLOSE_REASON_CD_03 = "03";

	public static final String ENROLLMENT_ACCOUNT_LOCK_STATUS_1 = "IN_PROGRESS_1";
	public static final String ENROLLMENT_ACCOUNT_LOCK_STATUS_2 = "IN_PROGRESS_2";

	public static final String ELIGIBILITY_ACCOUNT_LOCK_STATUS_1 = "IN_PROGRESS_1";
	public static final String ELIGIBILITY_ACCOUNT_LOCK_STATUS_2 = "IN_PROGRESS_2";

	/**
	 * Clock Names for different kind of verifications to run clocks selectively
	 */
	public static final String CLOCK_SSA = "SSN_90,CITIZENSHIP_90,INCARCERATION_1,INCARCERATION_10,INCARCERATION_90,INCARCERATION_30";
	public static final String CLOCK_MEC = "MEC_MCR_45,MEC_MEDAB_45,MEC_PEACE_45,MEC_PEACE_TERMIN_1,MEC_TRI_45,MEC_TRI_TERMIN_1,MEC_VET_45,MEC_MCR_90,MEC_VET_90,MEC_MEDAB_90,MEC_TRI_90,MEC_PEACE_90,MEC_AMERI_90";
	public static final String CLOCK_INCOME = "MEDICAID_INCOME_15,CHIP_INCOME_60,APTC_INCOME_90,FAMILYPLANNING_INCOME_90,EPP_INCOME_90";	
	public static final String CLOCK_INCOME_TPL = "MEDICAID_INCOME_TPL_15";
	public static final String CLOCK_RETRO_INCOME = "RETRO_MON1_INCOME_15,RETRO_MON2_INCOME_15,RETRO_MON3_INCOME_15";
	public static final String CLOCK_IMMIG = "IMMIGRATION_90";
	public static final String CLOCK_IMMIG_VET = "IMMIGRATION_VETERAN_90";
	public static final String CLOCK_STATE_RES = "STATE_RESIDENCY_90";
	public static final String CLOCK_AIAN = "AMERICAN_INDIAN_90";
	public static final String CLOCK_SR_ABS_PRNT = "SR_ABSENT_PARENT_90";
	public static final String CLOCK_SR_CHILD_SCHL_ENRL = "RESI_SPL_RULE_CHILD_SCHL_ENRL_90";
	public static final String CLOCK_SR_HOME_OWNER = "RESI_SPL_RULE_HOME_OWNERSHIP_90";
	public static final String CLOCK_SR_HOME_RENTAL = "RESI_SPL_RULE_HOME_RENTAL_90";
	public static final String CLOCK_SR_LGL_PERMRES = "RESI_SPL_RULE_LGL_PERMRESI_90";
	public static final String CLOCK_SR_WORK_DOCS = "RESI_SPL_RULE_WORK_DOCS_90";
	public static final String CLOCK_SSN = "SSN_90";
	public static final String CLOCK_CITIZENSHIP_DISCREPANCY = "CITIZENSHIP_DISCREPANCY_90";
	public static final String CLOCK_MEDICAID_CURRENT_INCOME = "MEDICAID_CURRENT_INCOME_15";
	public static final String CLOCK_CHIP_CURRENT_INCOME = "CHIP_CURRENT_INCOME_60";

	public static final char PHONE_STATUS_ACTIVE = '1';
	public static final char PHONE_PRIMARY_CONTACT = '1';

	public static final String BASE_JOB_WORKER_NAME = "BASE_JOB_WORKER";
	public static final String RENEWED_COVERAGE = "Prospective Coverage";
	public static final String ACTIVE_COVERAGE = "Current Coverage";
	public static final String PAST_COVERAGE = "Past Coverage";
	public static final String IN_ACTIVE_COVERAGE = "Inactive Coverage";

	public static final Long ELIGIBILITY_ID_NONE = -1L;

	public static String RENEWAL_CLONABLE = "1";
	public static String RENEWAL_CLONED = "0";

	public static final String HX_PROCESSING_SUCCESS = "SUCCESS";
	public static final String HX_PROCESSING_FAILURE = "FAILURE";
	public static final String APPLICATION_STATUS_SUCCESS = "SUCCESS";

	public final static int SHOP_QHP_AGE_OUT = 25;
	public final static int SHOP_QHP_AGE_OUT_RIDER = 29;
	public final static int SHOP_CHILD_ONLY_AGE_OUT = 18;
	public final static int SHOP_NOTICE_AGE_OUT_DAYS = 45;
	public final static Long AGE_OUT_EVENT_ID = 17L;
	
	public final static String SOFT_TOKEN_EMAIL_SUBJECT = "NY State of Health - User Verification Code";
	public final static String NOTIFY_EMPLOYEE_EMAIL_SUBJECT = "NY State of Health - Your employer-sponsored health coverage";
	
	public final static String ENTER_SECURITY_TOKEN = "Enter Security Token";
	public final static String GENERATE_NEW_TOKEN = "Generate New Token ";
	
	public final static String ENTER_TOKEN_NUMBER = "Enter Token Number";
	public final static String REGENERATE_TOKEN_BUTTON = "Regenerate Token Button";
	
	public final static String EMPLOYEE_COBRA_EVENT = "EmployeeCOBRAEnrollment";
	public final static String DEPENDENT_COBRA_EVENT = "DependentCOBRAEnrollment";
	public final static String PROXY_CREATED_EMPLOYEE_EVENT = "EmployeeRenewalWithNoNYGOVID";
	public final static String LINKED_EMPLOYEE_EVENT = "EmployeeRenewalWithNYGOVID";

	public static final int APPEAL_NOTES_STATUS_DELETED = 2;
	public static final int NOTES_STATUS_VALID = 1;

	// Constants used for disable employee portal controls if end effective date
	// have passed the current date
	public static final String DISABLE_CHANGES_IN_CIRCUMSTANCE_CONTROLS = "disableChangesInCircumstanceControls";
	public static final int ADDED_DAYS = 90;
	public static final int EMP_MAX_LSC_ADDED_DAYS = 60;
	
	public static final String DISABLE_EMPLOYEE_PORTAL_CONTROLS = "disableEmployeePortalControls";

	public static final String OVERRIDE_STATUS_ACTIVE = "1";
	public static final String OVERRIDE_STATUS_OBSOLETE = "0";

	public static final String STATUS_VALID = "1";
	public static final String STATUS_INVALID = "0";

	public static final long DATE_ATTRIBUTE_NO_CHANGE = 0;
	public static final long DATE_ATTRIBUTE_PLAN_PREMIUM_CHANGED = 1;
	public static final long DATE_ATTRIBUTE_GROUP_CONFIGURATION_CHANGED_OR_RENEWAL = 2;
	public static final long DATE_ATTRIBUTE_SUBSIDY_CHANGED_IN_CURRENT_PLAN = 3;
	public static final long DATE_ATTRIBUTE_SUBSIDY_CHANGED_DUE_TO_COMPATIBILITY = 4;
	public static final long DATE_ATTRIBUTE_COVERAGE_START_DATE_CHANGED = 5;
	public static final long DATE_ATTRIBUTE_AID_CATEGORY_CHANGED = 6;
	public static final long DATE_ATTRIBUTE_CHARGE_CODE_CHANGED = 7;
	public static final long DATE_ATTRIBUTE_COVERAGE_CODE_CHANGED = 8;
	public static final long DATE_ATTRIBUTE_RATE_CODE_CHANGED = 9;
	public static final long DATE_ATTRIBUTE_SUBSIDY_DATE_CHANGED_IN_CURRENT_PLAN = 10;
	public static final long DATE_ATTRIBUTE_CSR_VARIANT_CODE_CHANGED = 11;
	public static final long DATE_ATTRIBUTE_VARIANT_CODE_CHANGED = 12;
	public static final long DATE_ATTRIBUTE_RESPONSIBILITY_AMT_CHANGED_POLICY_LEVEL = 13;
	public static final long DATE_ATTRIBUTE_GROUP_CONFIGURATION_CHANGED = 14;
	
	public static final String SHOP_RELATION_TYPE_SELF = "Self";
	public static final String SHOP_RELATION_TYPE_SPOUSE = "Spouse";
	public static final String SHOP_RELATION_TYPE_DOMESTIC_PARTNER = "Domestic Partner";
	public static final String SHOP_RELATION_TYPE_CHILD = "Child";
	public static final String TERMED_FROM_PREV_YEAR="DIS_TERM_PRV_YR";
	public static final String CANCEL_RENEWAL="CANCEL_RENEWAL";
	
	public static final String LDSS_TRANSLATION_TYPE_SIMPLE = "SM";
	public static final String LDSS_TRANSLATION_TYPE_STRAIGHT = "ST";
	public static final String LDSS_TRANSLATION_TYPE_COMPLEX = "CX";

	public static final String LDSS_TRANS_STEP_1_NO_DATA_FOUND = "LDSS_TRANS_STEP_1_NO_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_2_NO_DATA_FOUND = "LDSS_TRANS_STEP_2_NO_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_3_NO_DATA_FOUND = "LDSS_TRANS_STEP_3_NO_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_1_SM_DATA_FOUND = "LDSS_TRANS_STEP_1_SM_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_2_ST_DATA_FOUND = "LDSS_TRANS_STEP_2_ST_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_3_CX_DATA_FOUND = "LDSS_TRANS_STEP_3_CX_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_1_ST_DATA_FOUND = "LDSS_TRANS_STEP_1_ST_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_1_CX_DATA_FOUND = "LDSS_TRANS_STEP_1_CX_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_2_CX_DATA_FOUND = "LDSS_TRANS_STEP_2_CX_DATA_FOUND";
	public static final String LDSS_TRANS_STEP_2_CX_NO_DATA_FOUND = "LDSS_TRANS_STEP_2_CX_NO_DATA_FOUND";

	/**
	 * Added for R6 LDSS changes - starts
	 */
	public final static String ACI_CODE_FOR_A = "A";
	public final static String ACI_CODE_FOR_C = "C";
	public final static String ACI_CODE_FOR_D = "D";
	public final static String ACI_CODE_FOR_E = "E";
	public final static String ACI_CODE_FOR_G = "G";
	public final static String ACI_CODE_FOR_H = "H";
	public final static String ACI_CODE_FOR_J = "J";
	public final static String ACI_CODE_FOR_K = "K";
	public final static String ACI_CODE_FOR_O = "O";
	public final static String ACI_CODE_FOR_P = "P";
	public final static String ACI_CODE_FOR_R = "R";
	
	public final static String ACI_CODE_FOR_F = "F";
	public final static String ACI_CODE_FOR_M = "M";
	public final static String ACI_CODE_FOR_S = "S";
	public final static String ACI_CODE_FOR_T = "T";
	public final static String ACI_CODE_FOR_V = "V";
	public final static String ACI_CODE_FOR_B = "B";
	public final static String ACI_CODE_FOR_N = "N";
	public final static String ACI_CODE_FOR_Z = "Z";
	
	public final static String HXWMD = "HXWMD";
	public final static String HXNMD = "HXNMD";
	public final static String HXNTX = "HXNTX";
	
	public final static String ALIEN_NUMBER_PREFIX = "A";
	public final static String LDSS_REL_TRANS_SELF = "01";
	public final static String LDSS_ACI_TRANS_I551 = "I-551";
	public final static String LDSS_ACI_TRANS_I94  = "I-94";
	public final static String LDSS_ACI_TRANS_I766 = "I-766";
	public final static String LDSS_HUMAN_TRAFFICKING = "A000999999";
	
	public static final String IN_PROGRESS = "IN_PROGRESS";
	public static final String DISENROLL = "disenroll";
	public static final String REINSTATE = "reinstate";
	public static final String TERM_TYPE_FM_NON_PAYMENT = "FM_NON_PAYMENT";
	public static final String TERM_REQUESTED = "TERM_REQ"; 
	public static final String TERM_TYPE_EMPLOYER_NON_RENEWAL = "EMPLOYER_NON_RENEWAL";
	public static final String TERM_TYPE_FM_NON_PAYMENT_REASON = "FM Payment Not Received";
	public static final String TERM_REINSTATED_FMTERM_OVER_TERM = "Term Reinstated FMS Term Over Term";
	public static final String TERM_TYPE_EMPLOYER_NON_RENEWAL_REASON = "DIS_NOT_RENEWED";
	public static final String TERM_TYPE_EMPLOYER_TERM_PRV_YEAR = "Terminated from previous year";
	public static final String TERM_TYPE_EMPLOYER_TERM_PRV_YEAR_REASON = "DIS_TERM_PRV_YR";	
	public static final String REINSTATE_TYPE_RE_TERM = "Term over Term";
	public static final String TERM_TYPE_FOR_REACTIVE_APP = "I do not want to offer insurance coverage through the exchange";
	public static final String PRESUMPTIVE_COVERAGE_CODE="13";
	public static final String MMC_COVERAGE_CODE="30";
	public static final String FFS_COVERAGE_CODE="01";
	public static final String EMERGENCE_COVERAGE_CODE="07";
	public static final String COVERAGE_CODE_18="18";
	public static final String COVERAGE_CODE_26="26";
	public static final String COVERAGE_CODE_27="27";
	
	public static final String FIELD_NAME = "FIELD_NAME";
	public static final String RELOCATION_EMPLOYEE_COUNTY = "Employee Relocation Reported";
	public static final String RETRO_MONTH_STATUS_ACTIVE = "ACTIVE";
	public static final String RETRO_MONTH_STATUS_OBSOLETE = "OBSOLETE";
	public final static String RETRO_CONSUMED = "IsConsumed";
	public final static String NO_INCOME_STR = "No Income";
	public final static String RETRO_POST_OVERRIDE = "retroPostOverride";
	
	public final static String MEDICAID_DECEASED_CLCOK = "MEDICAID_DECEASED";
	public final static String CHIP_DECEASED_CLCOK = "CHIP_DECEASED";
	public final static String APTC_DECEASED_CLCOK = "APTC_DECEASED";
	public final static String QHP_DECEASED_CLCOK = "QHP_DECEASED";
	public final static String EPP_DECEASED_CLCOK = "EPP_DECEASED";
	
	public static final String SPACECHAR="";
	public static final String AUTOMATION="AUTMAT";
	public static final String NO_AUTOMATION="NORMAL";
	public static final String RETRO="RETRO";
	
	public static final String CHANGE_IN_EMPLOYEE_HOURS="Change in Employee Hours";
	public static final String MODIFIED_LOSS_OF_COVERAGE_DATE="Modified Loss of Coverage Date via Roster";
	public static final String REACTIVATE="Reactivate";
	public static final String GROUP_REACTIVATED="Group Reactivated";
	public static final String REACTIVATE_REASON_CODE="03";	
	public static final String DISCONTINUED_COUNTIES="DISCONTINUED_COUNTIES";	
	public static final String DISCONTINUED_ISSUERS="DISCONTINUED_ISSUERS";
	public static final String IS_PREVIOUS_ENROLLED = "IS_PREVIOUS_ENROLLED";
	public static final String ENROLLED_PLAN_IDS = "ENROLLED_PLAN_IDS";
	public static final String IS_COBRA_ENROLLED = "IS_COBRA_ENROLLED";
	
	//CR1140 - Start Change EPP Back Office Override Eligibility - Added by DDas.
	public static final String VALID_EP_COVERAGE_STRT_DT = "12/31/2015";
		
	public static final String REPROCESS_ELIGIBILITY = "REPROCESS ELIGIBILITY";
	
	public static final String COBRA_CLASS_CODE="COB";
	public static final String RETIREE_CLASS_CODE="RETR";
	public static final List<String> SPECIAL_CLASS_CODES= Arrays.asList(COBRA_CLASS_CODE,RETIREE_CLASS_CODE);
	
	public static final Long PRODUCT_CATEGORY_MEDICAL = 1L;
	public static final Long PRODUCT_CATEGORY_MEDICAID = 2L;
	public static final Long PRODUCT_CATEGORY_CHIP = 3L;
	public static final Long PRODUCT_CATEGORY_CATASTROPHIC = 4L;
	public static final Long PRODUCT_CATEGORY_EPP = 5L;
	public static final Long PRODUCT_CATEGORY_SNP = 6L;

	public static final String FTECalculator = "Full-time Equivalent (FTE) Employee Calculator";
	public static final String EMPLOYER_HR_ALERT_NAME = "Employee(s) Health Republic termination";
	public static final String EMPLOYEE_HR_ALERT_NAME = "Health Republic termination";
	
	public static final String RETIREE_CLASS_Name = "Retiree";
	public static final String RE_ID_PROOFING_ALERT_NAME = "Identifying Information";
	public static final String COMMON_LAW_ATTESTATION_INDICATOR_YES="Y";
	public static final String COMMON_LAW_ATTESTATION_INDICATOR_NO="N";
	public static final String ALERT_INACTIVE_IND = "N";
	public static final String ALERT_ACTIVE_IND = "Y";
	
	public static final String MEDICAID_EXCLUSION_CD = "90";
	public static final String EPP_EXEMPT_RRE_CD = "N1,N2,N3,N4,N5,N6,N7,23,25,30,35,39,44,45,46,47,48,49,50,51,60,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,"+
			                                       "80,81,83,84,85,86,87,88,89,90,93,94,95,96";
	
	// Enhancement 50655
	public static final String PERSONALCARE_EXEMPT_RRE_CD = "B7";
	public static final String BO_AID_CATEGORY="B0";
	public static final String B1_AID_CATEGORY="B1";
	public static final String B2_AID_CATEGORY="B2";
	public static final String B3_AID_CATEGORY="B3";
	public static final String B4_AID_CATEGORY="B4";
	public static final String B5_AID_CATEGORY="B5";
	
	public static final String NO_MONTHLY_PREMIUM_CATEGORY="NOMONTHLY";
	public static final String ZERO_MONTHLY_PREMIUM_CATEGORY="ZEROMONTHLY";
	public static final String TWENTY_MONTHLY_PREMIUM_CATEGORY="TWENTYMONTHLY";
	
	
	public static final String NO_MONTHLY_PREMIUM_IND="0";
	public static final String ZERO_MONTHLY_PREMIUM_IND="1";
	public static final String TWENTY_MONTHLY_PREMIUM_IND="2";
	
	
	
	public static final String RECOMMEND_PLAN="Recommended Plan";
	
	//CR1140 MEC service changes - Added by chandra	
	public static final String IS_AGREE_BHPC = "IS_AGREE_BHPC";
	public static final String BHPC_NOLONGER_APPLY = "BHPC_NOLONGER_APPLY";
	public static final String BHPC = "BHPC";

	// Flip batch job constants
	public static final String ELG_MED_ALEISSIA_TO_EPP="ELG_MED_ALEISSIA_TO_EPP";

	public static final Integer FTE_50 = 50;
	
	public static final Integer FTE_100 = 100;
	

	public static String NOT_OFFERED = "NOT OFFERED";

	public static String ESSENTIAL_PROGRAM = "EP";
	
	public static String OEP_YEAR_PREFERANCE_YES = "1";
	public static String OEP_YEAR_PREFERANCE_NO = "0";
	
	
	/* This property is added for storing ISO Date format for CR 1182 by sbhanda */
	public final static String ISO_DATE_FORMAT = "MM/dd/yyyy";
	
	public static final String ARTIFACT_TYPE = "artifactType";
	public static final String ELG_ARTIFACT_TYPE = "eligibility";	
	public static final String RETRO_AEQ_PROCESS_FAILED = "retroFFSAddFailed";
	public static final String ERROR_403_PAGE = "/WEB-INF/content/error-docs/403.jsp";
	public static final String ERROR_403_EMPLOYER = "/WEB-INF/content/error-docs/403_Employer.jsp";
	public static final String ERROR_403_BROKER = "/WEB-INF/content/error-pages/403_Broker.jsp";

	//WMS

	public static final String VERIFICATION_SOURCE_WMS = "WMS";
	public static final String WMS_TYPE_TEMP_ACCOUNT = "Temp Account";
	public static final String WMS_TYPE_SHELL_ACCOUNT = "Shell Account";
	public static final String WMS_HOST_SYSTEM_UPSTATE = "U";
	public static final String WMS_HOST_SYSTEM_DOWNSTATE = "D";
	public static final String WMS_SSA_SERVICE_VERIFIED_INVALID_WMS_SSN = "SSA response is SUCCESS and WMS member does not have positively validated SSN indicator";
	public static final String WMS_SSA_SERVICE_VERIFIED_VALID_WMS_SSN = "SSA response is SUCCESS and WMS member has positively validated SSN indicator";
	public static final String WMS_SSA_SERVICE_VERIFIED_VALID_WMS_SSN_WMS_MEMBER_CHANGED = "SSA response is SUCCESS and WMS member has positively validated SSN indicator but WMS case member has the data ";
	public static final String WMS_SSA_SERVICE_FAILED_VALID_WMS_SSN = "SSA response is FAILED and WMS member has positively validated  SSN indicator";
	public static final String WMS_SSA_SERVICE_FAILED_INVALID_WMS_SSN = "SSA response is FAILED and WMS member has Invalid SSN SSN indicator";
	public static final String WMS_SSA_SERVICE_FAILED_VALID_WMS_SSN_WMS_MEMBER_CHANGED = "SSA response is FAILED and WMS member has positively validated  SSN indicator but WMS case member has changed the data ";


	public static final String WMS_SSA_SERVICE_VERIFIED_INVALID_WMS_CITI = "SSA response is SUCCESS and WMS member does not have positively validated CITIZENSHIP indicator";
	public static final String WMS_SSA_SERVICE_VERIFIED_VALID_WMS_CITI = "SSA response is SUCCESS and WMS member has positively validated CITIZENSHIP indicator";
	public static final String WMS_SSA_SERVICE_FAILED_VALID_WMS_CITI = "SSA response is FAILED and WMS member has positively validated  CITIZENSHIP indicator";
	public static final String WMS_SSA_SERVICE_FAILED_INVALID_WMS_CITI = "SSA response is FAILED and WMS member has Invalid CITIZENSHIP indicator";
	public static final String WMS_SSA_SERVICE_VERIFIED_VALID_WMS_CITI_WMS_MEMBER_CHANGED = "SSA response is SUCCESS and WMS member has positively validated CITIZENSHIP indicator but WMS case member has the data ";
	public static final String WMS_SSA_SERVICE_FAILED_VALID_WMS_CITI_WMS_MEMBER_CHANGED = "SSA response is FAILED and WMS member has positively validated  CITIZENSHIP indicator but WMS case member has changed the data ";

	/* This property Added for Storing Reid Proofing Reson type */
	public static final String REID_PROOF_DUPLICATE = "Duplicate Record";
	public static final String REID_PROOF_ASSURANCE_LEVEL_IND = "User Assurance Level indicator is not 1 or 2";
	public final static String REID_PROOF_ERROR = "Error Processing Record";
	public final static String REID_PROOF_VALID_USER ="UserProfile Type is not EMPLOYER/BROKER/NAVIGATOR/APPLICATIONCOUNSELOR";

	public static final int MA_DEEMED_NB_AGEOUT_MONTHS = 12;

	public static final String WMS_UNBORN_GENDER= "U";

	public static final String CBIC_SOURCE_1="CBIC1";
	public static final String CBIC_SOURCE_2="CBIC2";

	public static final String CC1_SOURCE="CC1";
	public static final String CC2_SOURCE="CC2";

	public static final String HBED = "HBED";
	public static final String ID_PROFF_SRC_WMS = "WMS";
	
	public static final String ISSUER_TERM_RSN_CD_NOT_PRG_ELIGIBLE="26";
	
	public static final String ISSUER_TERM_ADD_MAINTENANCE_NOT_PRG_ELIGIBLE="NEP";
	
	// Back Office Enrolllement history CR 1200 drop 2 added by vmishra33
	public static final String  SNP_ISSUER_TERMINATION="Issuer Requested SNP Termination";

	public static final String INCOMEMODE_NOINCOME = "NOINCOME";
	public static final String INCOMEMODE_STANDARDINCOME = "STANDARDINCOME";
	public static final String INCOMEMODE_DATASOURCEINCOME = "DATASOURCEINCOME";
	
	//CR 1186
	public static final String FFS = "FFS";
	public static final String MMC = "MMC";
	public static final String APTC = "APTC";
	public static final String FFS_QHP = "FFS_QHP";
	public static final String MMC_QHP = "MMC_QHP";
	public static final String EOCM = "EOCM"; //END OF CURRENT MONTH (COVERAGE INDICATOR)
	public static final String EONM = "EONM"; //END OF NEXT MONTH (COVERAGE INDICATOR)
	public static final String EO45D = "EO45D"; //45 DAYS INDICATOR (COVERAGE INDICATOR)
	public static final String EOCD = "EOCD"; //END OF CURRENT DAY (COVERAGE INDICATOR)
	
	public static final String DOCCS_NONE = "DOCCS_NONE"; // STORE DOCCS DATE IND AND FOLLOW EXISTING DATE DETERMINATION LOGIC
	public static final String DOCCS_EOCM = "DOCCS_EOCM"; // IF INELIG - END OF CURRENT MONTH
	public static final String DOCCS_EOCD = "DOCCS_EOCD"; // IF INELIG - END OF CURRENT DAY
	
	public static final String MCE = "MCE";
	//CR1308
	public static final String SNP = "SNP";
	//CR254
	public static final String CHIP_FULL_PAY ="FULL_PAY";
	public static final String CHIP_MIXED = "MIXED";
	public static final String CHIP_TYPE_CHANGE_DISENROLL = "CHIP_TYPE_CHANGE_DISENROLL";
	public static final String CHIP_TYPE_CHANGE_ADD = "CHIP_TYPE_CHANGE_ADD";
	public static final String  CHIP_TYPE_CHANGE ="CHIP_TYPE_CHANGE_";
	public static final String  CHIP_TYPE_AUTO_ENROLL ="CHIP_TYPE_AUTO_ENROLL";
	public static final String  QHP_29_AGEOUT_AUTO_ENROLL ="QHP_29_AGEOUT_AUTO_ENROLL";
	
	//CR1172
	public static final String DAI_SELECTED_IND = "daiSelectedInd";
	public static final String DAI_EFFECTIVE_DATE = "daiEffectiveDate";
	public static final String DAI_LARGE_PRINT ="V1";
	public static final String DAI_AUDIO_CD ="V2";
	public static final String DAI_DATA_CD ="V3";
	public static final String DAI_BRAILLE_YES ="V4";
	public static final String DAI_BRAILLE_NO = "V0";
	public static final String DAI_BRAILLE_TEMP_CODE ="V5";
	
	public static final String DAI_LARGE_PRINT_TXT ="Large Print";
	public static final String DAI_AUDIO_CD_TXT ="Audio CD";
	public static final String DAI_DATA_CD_TXT ="Data CD";
	public static final String DAI_BRAILLE_TXT ="Braille";
	public static final String DAI_STANDARD_TXT ="Standard";
	
	

	//CR#544
	public static final String NON_PAYMENT_COV_END_RSN_CODE ="59";
	public static final String SHOP_OTHER_BILL_TYPE="Other [Third Party Payee]";
	public static final String ADDRESS_OTHER_BILLING_CODE = "12";
	
	public static final String OTDA_NB_ERROR_EMAIL_EVENT = "WMSOpsCenterEmail";
	public static final String OTDA_NB_ERROR_EMAIL_SUBJECT = "Newborn Batch Process - Error Occurred";
	public static final String OTDA_NB_ERROR_EMAIL_FROM = "no-reply@nyexchange.org"; 
	public static final String OTDA_NB_ERROR_EMAIL_NAME1 = "Newborn batch process";
	
	
	public static final String DEPENDENT_DUE_TO_LEGAL_ORDER = "DEPENDENT DUE TO LEGAL ORDER";
	public static final String MEC_USER_RESPONSE_ATTR="IS_AGREE_";
	public static final String SUBSCRIBER_AGEOUT ="SUBSCRIBER_AGEOUT";
	public static final String  CHIP_TYPE_UNAVAILABLE ="CHIP_TYPE_UNAVAILABLE";

	
	//CR577
	public static final String COMPR_COV_N_IND ="N";
	public static final String COMPR_COV_Y_IND ="Y";
	public static final String CSR_OVR_IND ="N";
	public static final String TRRE_DESCR_IND ="Y";
	public static final boolean TPHI_DESCR_IND =false;
	public static final String MEDICARE_EXISTS_N_IND="N";
	public static final String MEDICARE_EXISTS_Y_IND="Y";
	public static final String COMP_COV_OVERRIDE_EXISTS_Y_IND="Y";
	public static final String COMP_COV_OVERRIDE_EXISTS_N_IND="N";
	public static final String NO_MEDICARE_LEFT_OVERRIDE_N_IND="N";
	public static final String NO_MEDICARE_LEFT_OVERRIDE_Y_IND="Y";
	//CR 555
	public static final String OVERRIDE_REJ_REASON_CODE_PREFIX="{}";
	public static final String DEFAULT_DISENROLL_TRAN_ACTION_REASON_CODE="DEFAULT_REASON";
	public static final String REASON_AND_PRIORITY_SEPERATOR=":";
	
	public static final String TRAN_ACTION_REASON_SOURCE="SYSTEM";
	public static final int 	TRAN_ACTION_DEFAULT_REASON_CODE_PRIORITY_NUM=1;
	public static final int    TRAN_ACTION_EDI_SEND_INDICATOR=1;		
	public static final String NEWBORN_ALREADY_EXIST = "Newborn already exists in household";	
	
	
	//CR-555 EventDescription of EventName 'ENROLLMENT_DELETE' is stored in EVT_EVENTS_MASTER table
	public static final String  ENROLLMENT_DELETE_EVENT_DESC="Enrollment Deleted";
	public static final String  ISSUER_NONPAYMENT_EVENT_DESC="Plan Initiated Termination";	
	public static final String  ISSUER_TRIGGERED_SNP_DISENROLLMENT_DESC = "Issuer Triggered SNP Disenrollment";
	
	//CR1150
	public static final String SEP_PROCESS="SEP_PROCESS";
    public final static String SEP_CSR_OVERRIDE= "SEP_CSR_OVERRIDE";
    public final static String SEP_MOVE_TO_NYS= "Permanent move";
	//CR1132
	public static final String INTERNATIONAL_RESIDENCE_ADDRESS  = "INTERNATIONAL_RESIDENCE_ADDRESS";
	//CR1269 
	public static final String JOB_ELG_RENEWAL_PROCESSOR = "JOB_ELG_RENEWAL_PROCESSOR";
	public static final String  TRAN_ACTION_REASON_IS_NULL_OR_EMPTY="<warning>No reason code assigned</warning>";
	public static final Integer    REASON_PRIORITY_NBR=1;
	public static String DEFAULT_SHOP_DISENROLLMENT_REASON = "Enrollment Error";
	public static String SHOP = "SHOP";
	public static final String  EVT_TRAN_DELIMITER=":";
	public static String DIS_OFFER_EXP = "DIS_OFFER_EXP";
	
	public static final String USER_ENTERED_ADDR_FLAG = "U";
	public static final String SUGGESTED_ENTERED_ADDR_FLAG = "S";
	public static final String CLEANSE_ENTERED_ADDR_FLAG = "C";
	
	//CR#1269
	public final static String INCARCERATED_END_DATE = "12/31/2999";
	public final static String VERIFIED_MAGI_DTF_RENEWAL = "Ver_magi_dtf_ren";
	
	// Defect 67077 KK 2016-10-12: Utility to Early dis-enrollment on all active plans after annual manual renewal completed.
	public static final String JOB_NAME_EARLY_DISENROLLMENT_ANNUAL_MANUAL_RENEWAL = "JOB_EARLY_DISENROLL_DURING_ANNUAL_RENEWAL";
	
	//CR 1381		
		public static final String NO_INCOME_NO_ERROR_CODE="NO_INCOME_NO_ERROR_CODE";
		public static final String NO_INCOME_ERROR_CODE="NO_INCOME_ERROR_CODE";
		public static final String INCOME_ERROR_CODE="INCOME_ERROR_CODE";
		public static final String REQUEST_ID="REQUEST_ID";
		public static final String IS_FTR="IS_FTR";

	//1269
		public static final String SUSIDY_ELIGIBILITY_EXPIRE="Subsidized Eligibility Expiration";
		public static final String FULL_PAY_ELIGIBILITY_EXPIRE="Full Pay Eligibility Expiration";
		public static final String TWENTY_ONE_AGE_OUT="Twenty One Year Age Out";
		public static final String FIVE_YEAR_BAR_EXPIRE="Five Year Bar Expiration";
		public static final String AUTO_ENROLL_PLAN_HIOS="AUTO_ENROLL_PLAN_HIOS";
		public static final String AUTO_ENROLL_COVERAGE_START_DATE="AUTO_ENROLL_COVERAGE_START_DATE";
		public static final String AUTO_ENROLL_COVERAGE_END_DATE="AUTO_ENROLL_COVERAGE_END_DATE";
		public static final String REASON_CODE="REASON_CODE";
		
	//1606
		public static final String FORCED_RENEWAL_ELIGIBILITY_EXPIRE="Forced renewal due to expired eligibility";
		
	public static final String COMPRESS_STRATEGY_HUFFMAN ="HUFFMANONLY";
	public static final String COMPRESS_STRATEGY_BESTSPEED ="BESTSPEED";
	public static final String COMPRESS_STRATEGY_BESTCOMPRESSION ="BESTCOMPRESSION";
	public static final String COMPRESS_STRATEGY_FILTERED ="FILTERED";
	public static final String COMPRESS_STRATEGY_DEFAULTSTRATEGY ="DEFAULTSTRATEGY";
	public static final String COMPRESS_STRATEGY_DEFLATED ="DEFLATED";
	
	public static final String COVERAGE_ENDDATE_LESS_THAN_STARTDATE ="Member Eligbility Coverage end date is less than coverage begin date.";
	
	
	//CR 1165
	public static final String SHOP_RECERTIFIED = "Small Business Marketplace";
	public static final String IND_RECERTIFIED = "Individual Marketplace";
	public static final String SHOP_IND_RECERTIFIED = "Individual and Small Business Marketplaces(s)";
	
	public static final String ADDRESS_VALIDATION_ENABLED = "Enabled";
	public static final String ADDRESS_VALIDATION_DISABLED = "Disabled";
	public static final String MMC_ADD_EVENT_ABANDONED_REASON ="MMC ADD Event Abandoned since FFS is Terminated";
    public final static  String [] TERM_REASONS= {"LSC_DEATH", "TERM_EMPL_DEATH" } ;
    //Added for CR#1489:Start:VG
    public static final String NO_MATCH = "NO_MATCH";
	public static final String DIRECT_CIN_MATCH = "DIRECT_CIN_MATCH";
	public static final String DEMOG_MATCH_STEP1 = "DEMOG_MATCH_STEP1";
	public static final String DEMOG_MATCH_STEP2 = "DEMOG_MATCH_STEP2";
	public static final String DEMOG_MATCH_STEP3 = "DEMOG_MATCH_STEP3";
	public static final String MULTIPLE_MATCH = "MULTIPLE_MATCH";
	//Added for CR#1489:End:VG
    public static final String HIOS_STATE_CODE = "NY";
    //Added for CR1310
    public static final String NO_ACTIVE_EMPLOYEE_ENROLLMENTS="No Active employee enrollments";
    public static final String NO_ACTIVE_EMPLOYEE_ENROLLMENTS_FROM_PROSPECTIVE="No Active employee enrollments from Prospective";
    public static final String TERM_FROM_BATCH = "TERM_REQ_FROM_BATCH";
    public static final String CARD_REQUESTED="CARD_REQUESTED";
    public static final String CARD_NOT_REQUESTED="CARD_NOT_REQUESTED";
    
  //CR 1227
    public final static String ISSUER_ONLY = "I";
    public final static String EMEDNY_ONLY = "E"; 
    public final static String NONE = "X";
    
 //CR 1416
    
    public final static String NEW_APP_PERMENANT_MOVE_TO_NYS="NEW_APP_PERMENANT_MOVE_TO_NYS";
    public final static String NEW_MEM_MOVE_TO_NYS="NEW_MEM_MOVE_TO_NYS";
    public final static String NEW_APP_MARRIAGE_OR_DOMESTIC_PARTNERSHIP="NEW_APP_MARRIAGE_OR_DOMESTIC_PARTNERSHIP";
    public final static String NEW_MEM_MARRIAGE_OR_DOMESTIC_PARTNERSHIP="NEW_MEM_MARRIAGE_OR_DOMESTIC_PARTNERSHIP";
    public final static String frmraddressLine1="frmraddressLine1";
    public final static String frmraddressLine2="frmraddressLine2";
    
    public final static String frmrcity="frmrcity";
    public final static String frmrstate="frmrstate";
    public final static String frmrcounty="frmrcounty";
    public final static String frmrcountry="frmrcountry";
    public final static String frmrzip="frmrzip";
    public final static String frmrczip="frmrczip";
    public final static String curraddressLine1="curraddressLine1";
    public final static String curraddressLine2="curraddressLine2";
    public final static String currcity="currcity";
    public final static String currcounty="currcounty";
    public final static String currzip="currzip";
    public final static String state= "state";
    public final static String city="city";
    public final static String county="county"; 
    
    //CR 1415
    //List of reasons for which T15 notice has to be suppressed 
  	// 1. PLAN_DISENROLL_DUE_TO_EP_ALIESSA_ELIGIBLE (Individual Disenrolled from Non-Aliessa EP due to Aliessa eligibility and auto enrolled with same issuer), 
  	// 2. PLAN_DISENROLL_DUE_TO_EP_NONALIESSA_ELIGIBLE (Individual Disenrolled from Aliessa EP due to Non-Aliessa eligibility and auto enrolled with same issuer)
  	// 3. DENTAL_PLAN_DISENROLL_DUE_TO_EPP_ALIESSA_ELIGIBLE (Individual Disenrolled SAD - Aliessa Elig Receives Dental Benefit)
  	// 4. PLAN_DISENROLL_DUE_TO_EP_CIN_CHANGE (Individual Disenrolled from EP due to CIN change)
  	public static List<String> REASONS_TO_SUPPRESS_T15_FOR_EP_DISENROLLMENTS = new ArrayList<String>() {{ add("PLAN_DISENROLL_DUE_TO_EP_ALIESSA_ELIGIBLE");
  																			  add("PLAN_DISENROLL_DUE_TO_EP_NONALIESSA_ELIGIBLE");
  																			  add("DENTAL_PLAN_DISENROLL_DUE_TO_EPP_ALIESSA_ELIGIBLE");
  																			  add("EPP_NON_STANDARD_TO_STANDARD_PLAN_SWITCH");
  																			  add("PLAN_DISENROLL_DUE_TO_EP_VARIANT_CHANGE");
  																			  add("EPP_PLAN_DISENROLL_DUE_TO_EP_VARIANT_CHANGE"); }};
  	
// def 71568																		  
  	public final static String SELFEMPLOYED_INCOMESUBTYPE = "04|07|09";
  //CR 1405
  	public static final int COMPLETED_EDIT_EFFECTIVE_MONTHS_ALLOWED = 3;
  	public static final int COMPLETED_EDIT_EFFECTIVE_START_DATE_MONTHS_ALLOWED = -1;
  	
  	public static final int COMPLETED_EDIT_SETTINGS_MONTHS_ALLOWED = 3;
  	public static final int COMPLETED_EDIT_SETTINGS_EFFECTIVE_START_DATE_MONTHS_ALLOWED = -1;
  	
  	//cr1361
  	public static final String JOB_ELG_NYSHIP = "JOB_ELG_NYSHIP";
  	public static final String SUNDAY ="SUNDAY";
  	public static final String MONDAY ="MONDAY";
  	public static final String TUESDAY ="TUESDAY";
  	public static final String WEDNESDAY ="WEDNESDAY";
  	public static final String THURSDAY ="THURSDAY";
  	public static final String FRIDAY ="FRIDAY";
  	public static final String SATURDAY ="SATURDAY";
  	public static final String END_OF_CURRENT_MONTH ="EOM";
  	public static final String DAY_OF_MONTH ="DAY_23";
	
	public static final String NYSHIP = "NYSHIP";
	public static final String RENEWAL_ENDDATE = "-12-31";
	


	//CR1455
	public static final String CLOCK_IMMG_GRANTDATE = "IMMG_GRANTDATE_90";
	public static final String FIVE_YR_BAR_MET_Y = "Y";

	//CR-1420
	public static final String ORGAN_DONOR_ACCOUNT_INFO = "organDonorAccountInfo";
	public static final String ELIGIBILITY_RESULTS_PAGE = "prescreen/ext/hx_eligibilityresult";
	
	public final static String NYSHIP_MATCH_STATUS_ACTIVE = "ACTIVE";

  	public static String SHA_MESSAGE_DIGEST = "SHA-256";
  	//Defect 74119
  	public static final String JOB_ENRL_1095_MONTHLY_DATA_CORRECTION = "JOB_ENRL_1095_MONTHLY_DATA_CORRECTION";
   	public final static String ELG_STS_PENDING="PENDING";
 	public final static String LIF="LIF";

    // CR1413
	public final static String DOCCS_SUSPEND_FILE_IND = "addToDOCCSSuspendFileInd";
	public static final String FALSE ="false";
	public static final String TRUE ="true";
	public static final boolean BOLFALSE =false;
	public static final boolean BOLTRUE =true;
	
	// Constants for CR 1398
	public static final String INPATIENT = "26_INPATIENT";
	public static final String INCAR_07 = "07_INCR";
	public static final String PRE_07 = "07_PRERELEASE";
	public static final String INCAR_01 = "01_INCR";
	public static final String PRE_01 = "01_PRERELEASE";
	public final static String INC_SUSPEND_IND = "IncSuspendInd";
	public static final String PREFIX_IN_PROGRESS = "I";	
	public static final String MANIFEST_FILE_NAME = "manifestText.csv";
	public static final String SEARCH_CRITERIA_FILE_NAME = "searchCriteria.txt";
	public static final String DOCUMENT = "Document";
	
	/**
	 * CR 1398 - Constants for prev and current doccs type
	 */
	public static final String EVENT_MEDICAID_PREV_DOCCS_TYPE = "eventPrevDoccsType";
	public static final String EVENT_MEDICAID_CURR_DOCCS_TYPE = "eventCurrDoccsType";
	
	//CR1231-Renewal msg for employer n employee overview screen
	public static final String AUTO_RENEWAL_MSG = "Eligible for Auto Renewal";
	public static final String MANUAL_RENEWAL_MSG = "Manual Renewal Action Required";
	public static final String AFTER_EMPLOYER_RENEWAL_COMPLETED_MSG = "Enrollment Offer Complete";
	public static final String AFTER_EMPLOYEE_RENEWAL_COMPLETED_MSG = "Enrollment Complete";
	public static final String LDSS_UC_REF_CDS = "HXNMD,HXWMD,HXNTX";		
	public static final String LDSS_APP_REF_CDS = "HXSUR,HXLTC,HXDAB,HXFOS,HXRET";
	
	//Defect 77053
 	public static final String VLP_AUTOTRIGGER_STEP_TWO_YES = "Y";
	public static final String VLP_AUTOTRIGGER_STEP_TWO_NO = "N";
	public static final String VLP_AUTOTRIGGER_STEP_THREE_FLAG_YES = "Y";
	public static final String VLP_AUTOTRIGGER_STEP_THREE_FLAG_NO = "N";
	public static final String OVERRIDE_FLAG = "Y";
	public static final String CLOSE_CASE_FLAG = "Y";
	public static final String CUSTOMER_SERVICE_FLAG = "Y";
	public static final String Unathorize_Reason_Code ="2";
	
	//CR 1449 - BO 
	public static String USER_PROF_STS_IND = "0";
}