package com.hcentive.utils.ext;


/**
 * File is being used to define all of the System Error logs, which are going to
 * be used only for logging purpose.
 * 
 */
public class HXLogMsgConstants {

	/* All Common Error Messages Code should be between 10001-19999 */
	/* All EE/Individual Error Messages Code should be between 20001-29999 */

	/*
	 * Constant Naming Convention : LOG_ERROR_XX / LOG_INFO_XX / LOG_WARN_XX.
	 * Here 2 Chars "XX" representing module Name i.e. "EE" stands for
	 * ELigibility & Enrollment
	 */

	public static final String LOG_ERROR_CO_UTILITY_FUNCTION_FAILED = "NYHX:10001 : Utility Function Failed. Exception detail : {} ";
	// Config Bean access errors
	public static final String LOG_ERROR_CONFIG_VALUE_NOT_FOUND = "NYHX:10002 : Config value not found for CONFIG VERSION {}, Key {}.";

	public static final String LOG_ERROR_ACCOUNT_RUN_CONFIG_FAILED = "NYHX:10003 : Error while trying to retrieve date from ACCOUNT_RUN_CONFIG. Exception detail : {} ";

	public static final String LOG_ERROR_EE_HH_VALIDATOR_INCORRECT_PAGEID = "NYHX:20001 : Incorrect page id {}";
	public static final String LOG_ERROR_EE_HH_VALIDATOR_INCORRECT_MEMBER_INDEX = "NYHX:20002 : Incorrect household member index {}";
	public static final String LOG_ERROR_EE_HH_VALIDATOR_NULL_MEMBER = "NYHX:20003 : Null household member for id {}";
	public static final String LOG_ERROR_EE_HHINCOME_SERVICE_INCORRECT_DOB = "NYHX:20004 : Incorrect Date of Birth {}";
	public static final String LOG_ERROR_EE_HHINCOME_UIB_INCORRECT_CLAIM_EFFECTIVE_DATE = "NYHX:20005 : Incorrect Claim Effective Date {}";
	public static final String LOG_ERROR_EE_HHINCOME_UIB_INCORRECT_BYE_DATE = "NYHX:20006 : Incorrect Benefit Year End Date {}";
	public static final String LOG_ERROR_EE_HHINCOME_INCOME_COMPOSITE_SERVICE_FAULT = "NYHX:20007 : Fault received from Income Composite Service {}";
	public static final String LOG_ERROR_EE_HHINCOME_INCOME_COMPOSITE_SERVICE_UNKNOWN = "NYHX:20008 : Some Unknown Error received from Income Composite Service {}";

	public static final String LOG_ERROR_EE_SSA_COMPOSITE_SERVICE_FAULT = "NYHX:20009 : Fault received from SSA Composite Service {}";
	public static final String LOG_ERROR_EE_SSA_COMPOSITE_SOAP_FAULT = "NYHX:20010 : SOAP Fault received from SSA Composite Service {}";
	public static final String LOG_ERROR_EE_SSA_COMPOSITE_EXCEPTION_FAULT = "NYHX:20011 : Exception while calling SSA Composite Service {}";
	public static final String LOG_ERROR_EE_SSA_COMPOSITE_ERROR_RESPONSE = "NYHX:20012 : Error Code received from SSA Composite Service Response {}";
	public static final String LOG_ERROR_EE_SSA_COMPOSITE_ERROR_INVALID_DOCCS_DATA_FORMAT = "NYHX:20112 : Error while mapping doccs data from SSA to object, Invalid xml structure {}";
	public static final String LOG_ERROR_EE_ERROR_INVALID_CUSTOM_DOCCS_DATA_FORMAT = "NYHX:20113 : Error while mapping custom(stubbed) doccs data to object, Invalid xml structure {}";

	public static final String LOG_ERROR_EE_ENROLLMENT_MESSAGE_INVALID_APPLICATION_ID = "NYHX:20013 : Invalid Application Id {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_MESSAGE_NO_PLANS = "NYHX:20014 : No Plans available for Member Id {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_MESSAGE_INVALID_PLANID = "NYHX:20015 : Invalid Plan Id {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_MESSAGE_INVALID_ISSUERID = "NYHX:20016 : Invalid Issuer Id {}";

	public static final String LOG_ERROR_EE_SSA_COMPOSITE_ERROR_RESPONSE_MISSING_REQUIRED = "NYHX:20017 : Required value is missing in the Response {}";

	public static final String LOG_ERROR_EE_HHINCOME_INCOME_APTC_SERVICE_FAULT = "NYHX:20017 : Fault received from Income APTC Service {}";
	public static final String LOG_ERROR_EE_HHINCOME_INCOME_APTC_SERVICE_UNKNOWN = "NYHX:20018 : Some Unknown Error received from Income APTC Service {}";

	public static final String LOG_ERROR_EE_MEC_SERVICE_FAULT = "NYHX:20019 : Fault received from MEC service{}";
	public static final String LOG_ERROR_EE_MEC_EXCEPTION_FAULT = "NYHX:20020 : Exception while calling MEC service {}";
	public static final String LOG_ERROR_EE_MEC_ELEMENT_FAULT = "NYHX:20021 :  Marshalling Exception from MEC Service {}";
	public static final String LOG_ERROR_EE_MEC_SOAP_FAULT = "NYHX:20022 :  SOAP Fault received from from MEC Service {}";
	public static final String LOG_ERROR_EE_VLP_SAVE_NYHXVERIFY_FAULT = "NYHX:20023 : NYHXVERIFY Fault received from VLP SAVE interface{}";
	public static final String LOG_ERROR_EE_VLP_SAVE = "Exception received from VLP SAVE interface{}";

	public static final String LOG_ERROR_EE_SOURCE_OR_TARGET_APP_NULL = "NYHX:20025 : Source or Target application is null.";
	public static final String LOG_ERROR_EE_APP_MEMBER_ID_IS_NULL = "NYHX:20026 : Application Member Id is NULL.";
	public static final String LOG_ERROR_EE_MEMBER_DOES_NOT_EXISTS = "NYHX:20027 : Member does not exists.";
	public static final String LOG_ERROR_EE_MEMBER_DOES_NOT_EXISTS_FOR_NYHXID = "NYHX:20028 : Member does not exists. Application Id {}, NYHX ID {}";
	public static final String LOG_ERROR_EE_APPLICATION_OBJECT_IS_NULL = "NYHX:20029 : Application is null.";
	public static final String LOG_ERROR_EE_NYHX_ID_IS_BLANK = "NYHX:20030 : NYHX ID is blank for Application Member id {}.";
	public static final String LOG_ERROR_EE_GROUP_NOT_EXISTS_FOR_NYHX_ID = "NYHX:20031 : Enrollment does not exists for application id {} and NYHX ID {}.";
	public static final String LOG_ERROR_EE_NYHX_IN_MULTI_GRP_FOR_SAME_APP = "NYHX:20032 : Multiple Application Groups for same NYHX within same application. Application id {} and NYHX ID {}.";
	public static final String LOG_ERROR_EE_NO_APP_GRP_FOR_NYHX_ID = "NYHX:20033 : Application Group does not exist for Application id {} and NYHX ID {}.";
	public static final String LOG_ERROR_EE_NO_SUBSCRIBER_FOUND_FOR_GROUP = "NYHX:20034 : No subscriber found for group Application Group id {}.";
	public static final String LOG_ERROR_EE_SUBSIDY_RECORD_DOES_NOT_EXIST = "NYHX:20035 : Application Plan Subsidy record does not exists. Application Id {}, NYHX ID {}";
	public static final String LOG_ERROR_EE_PROGRAM_ID_IS_INVALID = "NYHX:20036 : Program Id can not be NULL. Application Id {}, NYHX ID {}";
	// APTC Service

	public static final String LOG_ERROR_EE_APTC_SECOND_LOWEST_PLAN_COST_NOT_FOUND = "NYHX:20035 : Second Lowest Cost Silver Plan not found {}";
	public static final String LOG_ERROR_EE_APTC_SLPC_NULL_COUNTY = "NYHX:20036 : County is null for determining SLPC for member {}";

	// Eligibility Can not be modified
	public static final String LOG_ERROR_EE_NOT_MODIFIABLE = "NYHX:20037 : Eligibility can not be modified {}";

	public static final String LOG_ERROR_EE_HHINCOME_INCOME_COMPOSITE_BAD_DATA = "NYHX:20038 : Bad Data from Income Composite Service {}";
	public static final String LOG_ERROR_EE_BAD_INPUT_APTC_SERVICE = "NYHX:20038 : Bad Data Input APTC Service {}";
	public static final String LOG_ERROR_EE_APTC_NO_AMOUNT_SERVICE = "NYHX:20039 : No amount from APTC Service {}";

	public static final String LOG_ERROR_EE_INVALID_DATA = "NYHX:20040 : Invalid data in Eligibility application {}";

	// Unborn error messages
	public static final String LOG_ERROR_EE_UNBORN_MISSING_CHIPID = "NYHX:20041 : Missing chipid for mother {}";
	public static final String LOG_ERROR_EE_UNBORN_MISSING_CIN = "NYHX:20042 : Missing cin for mother {}";
	public static final String LOG_ERROR_EE_UNBORN_NO_CIN = "NYHX:20043 : Cannot generate CIN for unbron {}";

	public static final String LOG_ERROR_EE_BAD_COVERAGE_CODE = "NYHX:20044 : Invalid cooverage code for Medicaid {}";
	public static final String LOG_ERROR_EE_RUNNING_ELG_RULES = "NYHX:20045 : Got exception while running rules for {}";
	public static final String LOG_ERROR_EE_INVALID_DATE_FOR_ELG = "NYHX:20046 : Got null in setting eligibility Date {}";
	public static final String LOG_ERROR_EE_INVALID_RETRO_DATE_FOR_ELG = "NYHX:20047 : Got null in retro eligibility Date. Eligibility Id {} MemberId {}";
	public static final String LOG_ERROR_EE_INVALID_RETRO_MONTH_FOR_ELG = "NYHX:20047 : Got null in retro eligibility month. Eligibility Id {} MemberId {}";
	public static final String LOG_ERROR_EE_INVALID_DISENROLL_DATE = "NYHX:20048 : Disenroll date is null. MemberId {}";
	public static final String LOG_ERROR_EE_INVALID_AUTOENROLL_DATA = "NYHX:20049 : Incomplete data for auto enroll. MemberId {}";
	public static final String LOG_ERROR_EE_NULL_DSDATASOURCE = "NYHX:20050 : DS Data source needs to be set. eligibilityId {}";
	public static final String LOG_ERROR_EE_NULL_RRVRESPONSE = "NYHX:20051 : RRV Response is null. accountid {}";
	public static final String LOG_ERROR_EE_NULL_RENEWAL_MASTER = "NYHX:20052 : Renewal Master is null. accountid {}";
	public static final String LOG_ERROR_EE_MANUAL_RENEWAL_FOR_PROPOSED = "NYHX:20053 : Manual Renewal found for Proposed. accountid {}";
	public static final String LOG_ERROR_EE_INCOME_SOURCE_UNDETERMINABLE = "NYHX:20054 : Can not determine income source. accountid {}";
	public static final String LOG_ERROR_EE_MISSING_SSN = "NYHX:20055 : SSN is missing. accountid {}";

	// Error message for ReSequencer
	public static final String LOG_ERROR_RESEQ_HIXID_MISSING = "NYHX:30001 : NYHX ID is required to create Resequence Queue";
	public static final String LOG_ERROR_RESEQ_ARTFACTID_MISSING = "NYHX:30002 : ARTIFACAT ID is required to create Resequence Queue";
	public static final String LOG_ERROR_RESEQ_ARTFACTTYPE_MISSING = "NYHX:30003 : ARTIFACT TYPE is required to create Resequence Queue";
	public static final String LOG_ERROR_RESEQ_CATEGORYCD_MISSING = "NYHX:30005 : CATEGORY CODE is required to create Resequence Queue";
	public static final String LOG_ERROR_RESEQ_BATCH_MULTIPLE_INPROGRESS_ELIGIBILITY = "NYHX:30078 : Multiple InProgress eligibility found {}";
	public static final String LOG_ERROR_RESEQ_BATCH_EMPTY_LIST = "NYHX:30079 : Empty list found {}";
	public static final String LOG_ERROR_RESEQ_BATCH_INCORRECT_ELIGIBILITY = "NYHX:30080 : Eligibility cannot be processed through resequence batch {}";
	public static final String LOG_ERROR_RESEQ_BATCH_ELG_NO_PROCESS_MANUAL = "NYHX:30081 : Category code can not be processed when manual renewal is active {}";
	public static final String LOG_ERROR_RESEQ_BATCH_RETRO_FFS_PENDING = "NYHX:30082 : AEQ failure for Retro FFS";
	public static final String LOG_ERROR_RESEQ_BATCH_USER_NOSHOW_MANUAL="NYHX:30084 :Category code cannot be processed as eligibility run date is greater than renewal period end date"; //added as part of defect 75180

	// Error message for Re-verification Batch Process
	public static final String LOG_ERROR_BATCH_ELG_REDETERMINATION = "NYHX:30006: Error Occured during Eligibility Redermination Process for {}";
	public static final String LOG_ERROR_BATCH_ELG_REVERIFICATION = "NYHX:30007: Error Occured during Eligibility Reverification Process for member {}";
	public static final String LOG_ERROR_BATCH_CLOCKS_INPROGRESS = "NYHX:30008: Error Occured while marking clocks as INPROGRESS.";

	public static final String LOG_ERROR_BATCH_ELGIBILITY_GENERIC = "NYHX:30009: Error Occured while processing Eligibility Redermination or resequencing {}";
	public static final String LOG_ERROR_BATCH_HIXID = "NYHX:30010: Error Occured while getting HIX ID from User Profile {}";
	public static final String LOG_ERROR_BATCH_ELGIBILITY_RESEQ = "NYHX:30011: Error Occured while Resequencing Eligibility {}";

	public static final String LOG_ERROR_BATCH_VERIFICATION_AI = "NYHX:30012: Error occured during verification of American Indian Status for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_INCOME = "NYHX:30013: Error occured during verification of Income for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_MEC = "NYHX:30014: Error occured during verification of MEC for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_RESIDENCY = "NYHX:30015: Error occured during verification of Residency Status for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_SSN_CIT_INC = "NYHX:30016: Error occured during verification of SSN, Citizenship or Incarceration for member {}";
	public static final String LOG_ERROR_ELGIBILITY_RESEQ = "NYHX:30017: Error Occured while Resequencing Eligibility {}";
	public static final String LOG_ERROR_HIXID = "NYHX:30018: Error Occured while getting HIX ID from User Profile {}";
	public static final String LOG_ERROR_RESEQ_QUEUE = "NYHX:30019: Error Occured while putting eligibility {} to resequence queue.";
	public static final String LOG_ERROR_CIN_SERVICE = "NYHX:30020: Error Occured while calling CIN Service for eligibility {}";
	public static final String LOG_ERROR_ELG_DETERMINATION = "NYHX:30021: Error Occured during Eligibility Dermination for Eligibility {}";
	public static final String LOG_ERROR_NOTICE_SERVICE = "NYHX:30022: Error Occured while calling Notice Service for eligibility {}";
	public static final String LOG_ERROR_SIGN_SAVE_SERVICE = "NYHX:30023: Error Occured while submitting Signature page for eligibility {}";

	public static final String LOG_ERROR_EE_ENROLLMENT_PERIOD_YEAR_BLANK = "NYHX:30024 : Blank enrollment period year received.";
	public static final String LOG_ERROR_ELG_STATUS_DETERMINED = "NYHX:30025: Error Occured while updating eligibility status to DETERMINED";
	public static final String LOG_ERROR_BATCH_VERIFICATION_IMMIGRATION = "NYHX:30013: Error occured during verification of Immigration for member {}";

	public static final String LOG_ERROR_NYHX_PLAN_SELECTION_SUBSCRIBER_NOT_FOUND = "Enrollment group subscriber not found";
	public static final String LOG_ERROR_NYHX_PLAN_SELECTION_SUBSCRIBER_NOT_FOUND_DURING_SEP = "Enrollment group subscriber not found";
	public static final String LOG_ERROR_CHIPID_GENERATION = "NYHX:30026: Error occured while generating CHIP ID";

	public static final String LOG_ERROR_EE_ENROLLMENT_834_INTERFACE_FAILED = "NYHX:30030: Error while dispatching 834 transaction using 834 client. Enrollment Id {}.";

	// Error message for ProxyActivityLog
	public static final String LOG_ERROR_PROXYACTIVITY_PROFILEID_MISSING = "NYHX:30031 : profileId is required to query Proxy Activity Log";
	public static final String LOG_ERROR_PROXYACTIVITY_LOGINID_MISSING = "NYHX:30032 : loginId is required to query Proxy Activity Log";
	public static final String LOG_ERROR_PROXYACTIVITY_RESOURCEURL_MISSING = "NYHX:30033 : resourceUrl is required to query Proxy Activity Log";

	public static final String LOG_ERROR_NYHX_PRODUCT_CATEGORY_NOT_FOUND = "NYHX:30034 : Product Category not identified for program of enrollment {} and group {}";
	public static final String LOG_ERROR_EE_ENRL_COUNTY_IS_BLANK = "NYHX:30035 : County code not found for eligibility id {} and enrlMember id {}";
	public static final String LOG_ERROR_EE_MORE_THAN_ONE_COUNTY_FOR_SAME_CODE = "NYHX:30036 : More than one county found for same code {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_PROD_CATEGORY_NOT_FOUND = "NYHX:30037 : Product Category not found. Group Id : {}, Prog Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_COVERAGE_TIER_IS_BLANK = "NYHX:30038 : Enrollment Coverage Tier is blank.ENrollment Group Id - {}, Group Group Type - {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_PM_SUBSCRIBER_TYPE_IS_BLANK = "NYHX:30039 : Enrollment PM Subscriber is blank. Enrollment Group Id - {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_FPL_CANNOT_BE_NULL_FOR_CHIP = "NYHX:30040 : FPL Cannot be null for Chip. {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_PLAN_HAS_BEEN_RETURNED_AS_NULL = "NYHX:30041 : Plan object has been returns as null. For Plan Id {} ";
	public static final String LOG_ERROR_EE_ENRL_COUNTY_NAME_IS_BLANK = "NYHX:30042 : County Name is empty for county code {}";
	public static final String LOG_ERROR_EE_PLAN_SELECTION_NOT_INVALID_ARGUMENT = "NYHX:3043 : Invalid Argument. Argument Name : {}, Argument Value : {} ";
	public static final String LOG_ERROR_EE_ENRL_MORE_THAN_ONE_PLAN_FOR_SAME_HIOS_COUNTY_FPL = "NYHX:30044 : More than 2 Plan for same HIOS {}, County {} and FPL {}.";
	public static final String LOG_ERROR_EE_PROD_CATEGORY_NOT_FOUND = "NYHX:30045 : Product Category not found. Prog Id : {} ";
	public static final String LOG_ERROR_EE_ENRL_MORE_THAN_ONE_SUBMITTED_ENROLLMENT_EXISTS = "NYHX:30067 : More than one submitted enrollments exists. Ids are : ";
	public static final String LOG_ERROR_EE_ENRL_LOCK_MORE_IN_PROGRESS_ALREADYEXISTS_1 = "NYHX:30068 : 1 Step IN_PROGRESS enrollments already exists. Ids are : ";
	public static final String LOG_ERROR_EE_ENRL_LOCK_MORE_IN_PROGRESS_ALREADYEXISTS_2 = "NYHX:30069 : 2 Step IN_PROGRESS enrollments already exists. Ids are : ";
	public static final String LOG_ERROR_EE_ENRL_LOCK_USER_NOT_FOUND = "NYHX:30070 : User Profile is null. User Profile Id : {} ";
	public static final String LOG_ERROR_EE_ENRL_LOCK_ACCOUNT_ID_NOT_FOUND = "NYHX:30071 : Account Id is not available. User Profile Id : {} ";
	public static final String LOG_ERROR_EE_ENRL_LOCK_RECORD_NOT_FOUND = "NYHX:30072 : Enrollment Account Lock Record not exists. User Profile Id, Account Id : {} ";
	public static final String LOG_ERROR_EE_ENRL_LOCK_MORE_THAN_ONE_RECORD_FOUND = "NYHX:30073 : More than One Enrollment Account Lock Record exists. User Profile Id, Account Id : {} ";
	public static final String LOG_ERROR_EE_ELG_MEMBER_COUNTY_CODE_IS_BLANK = "NYHX:30035 : County code not found for eligibility id {} and eligibility member id {}";
	public static final String LOG_ERROR_EE_MORE_THAN_ONE_QUALITY_RECORDS_FOR_SAME_ISSUER = "NYHX:30036 : More than one quality records found for same issuer {}";

	public static final String LOG_ERROR_EE_ELG_LOCK_MORE_IN_PROGRESS_ALREADYEXISTS_1 = "NYHX:70000 : 1 Step IN_PROGRESS eligibilities already exists. Ids are : ";
	public static final String LOG_ERROR_EE_ELG_LOCK_MORE_IN_PROGRESS_ALREADYEXISTS_2 = "NYHX:70001 : 2 Step IN_PROGRESS eligibilities already exists. Ids are : ";
	public static final String LOG_ERROR_EE_ELG_LOCK_USER_NOT_FOUND = "NYHX:70002 : User Profile is null. User Profile Id : {} ";
	public static final String LOG_ERROR_EE_ELG_LOCK_ACCOUNT_ID_NOT_FOUND = "NYHX:70003 : Account Id is not available. User Profile Id : {} ";
	public static final String LOG_ERROR_EE_ELG_LOCK_RECORD_NOT_FOUND = "NYHX:70004 : Eligibility Account Lock Record not exists. User Profile Id, Account Id : {} ";
	public static final String LOG_ERROR_EE_ELG_LOCK_MORE_THAN_ONE_RECORD_FOUND = "NYHX:70005 : More than One Eligibility Account Lock Record exists. User Profile Id, Account Id : {} ";

	public static final String LOG_ERROR_EE_AUTO_ENRL_FAILED = "NYHX:30144 : Auto Enrollment Failed. Account Id  : {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_MEMBER_NOT_ELIGIBLE_FOR_MEDICAID = "NYHX:30145 : Auto Enrollment. Member Id is not eligible for Medicaid : Member Id {}, AEQ ID {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_NO_MEMBER_ELIGIBLE_FOR_MEDICAID = "NYHX:30146 : Auto Enrollment. No Member eligible for Medicaid. Eligibility Id {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_HXID_NOT_EXISTS_FOR_MEDICAID_GRP = "NYHX:30147 : Auto Enrollment. Member HX Ids does not exists in Application Group. : HX Ids {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_HXID_NOT_EXISTS_IN_MEMBERS = "NYHX:30148 : Auto Enrollment. Member HX Ids does not exists in Members. : HX Ids {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_NO_MA_PLAN_EXISTS_FOR_COUNTY = "NYHX:30149-A : Auto Enrollment. No Plan Exists for given County. : Member Id {}, County {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_NO_MA_PLAN_EXISTS_FOR_HIOS_AND_EFF_DT = "NYHX:30149-B : Auto Enrollment. No Plan Exists for given HIOS and Effective Date. : HIOS {}, Effective Dt {}, NYHXID {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_NO_MA_PLAN_EXISTS_FOR_ANY_CRITERIA_A = "NYHX:30150-A : Auto Enrollment. No Plan Exists for any criteria. : Member Id {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_NO_MA_PLAN_EXISTS_FOR_ANY_CRITERIA_B = "NYHX:30150-B : Auto Enrollment. No Plan Exists for any criteria. : Member Id {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_MMCWINDOW_ERROR = "NYHX:30151 : Error while evaluating MMC Batch Job Window. ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_MEMBER_LIST_EMPTY = "NYHX:30152 : Auto Enrollment Member List is Empty. User Id {}, Eligibility Id {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_MEMBER_NOT_ELIGIBLE_FOR_EPP = "NYHX:30268 : Auto Enrollment. Member Id is not eligible for EPP : Member Id {}, AEQ ID {} ";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT = "NYHX:30153: Error Occured during Auto Enrollment Process for Eligibility {}";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_STATUS_UPDATE_FAILED = "NYHX:30154: Error Occured during updating status update for AutoEnrollmentQueue Id {}";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_STATUS_DELETE_FAILED = "NYHX:30154-B: Error Occured during deleting  AutoEnrollmentQueue  {}";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_834_MSG_POST_FAILED = "NYHX:30155: Autoenrollment's 834 Message Posting is failed. Status Marked as failed in Auto Enrollment Queue. User Id {}, Eligibility Id {} ";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_INVALID_ACTIONS = "NYHX:30156: Invalid actions received for NYHX Id {}";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_NO_FFS_BUT_MMC_GOING_TO_ADD_A = "NYHX:30157-A: No Active FFS Exists but MMC was about to be enroll.AutoEnrollmentId  {}, Eligibility Id {} ";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_NO_FFS_BUT_MMC_GOING_TO_ADD_B = "NYHX:30157-B: No Active FFS Exists but MMC was about to be enroll.AutoEnrollmentId  {}, Eligibility Id {} ";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_MEMBER_IS_NULL = "NYHX:30158: Member is null from Eligibility. AutoEnrollmentId  {}, NYHX ID {} ";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_ENROLLMENT_OBJECT_IS_NULL = "NYHX:30159: Enrollment is null. NYHX ID {}, COUNTY NAME {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_FAILED = "NYHX:30160 : Consolidated Auto Enrollment Failed. Account Id  : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_UPDATE_MEMBER_NOT_IN_ENRL_GRP = "NYHX:30161 : Consolidated Auto Enrollment. Member to be updated does not exists in any of the group available in last submitted enrollment. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ACC_BLANK = "NYHX:30162 : Consolidated Auto Enrollment. Account Id is blank. Eligibility ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_USER_NOT_FOUND = "NYHX:30163 : Consolidated Auto Enrollment. User Id not found. Account Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ELIGIBILITY_NOT_FOUND = "NYHX:30164 : Consolidated Auto Enrollment. User Id not found. Account Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_FAILED_TO_CREATE_NEW_ENRL = "NYHX:30165 : Consolidated Auto Enrollment. Failed to create New Enrollment. Eligibility Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_FAILED_TO_CREATE_COPY_OF_ENRL = "NYHX:30166 : Consolidated Auto Enrollment. Failed to create copy of last submitted Enrollment. Eligibility Id : {}, Last submitted App Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_NO_MEMBER_IN_GROUP = "NYHX:30167 : Consolidated Auto Enrollment. No Member exists in Application Group. Account Id : {}, New App Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_PROG_ID_IS_NULL = "NYHX:30168 : Consolidated Auto Enrollment. Program Id is null for Auto enroll. Auto Enrollment Id : {}, NYHX Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ELIG_RESULT_IS_NULL = "NYHX:30169 : Consolidated Auto Enrollment. Eligibility Result is null. Application Id : {}, Elig Member Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ELIG_START_DT_IS_NULL = "NYHX:30170 : Consolidated Auto Enrollment. Eligibility Result is null. Application Id : {}, Elig Member Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_APP_MEMBER_NOT_EXISTS = "NYHX:30171 : Consolidated Auto Enrollment. Application Member does not exists. Application Id : {}, AUto Queue Id : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_COV_START_DATE_IS_BLANK = "NYHX:30172 : Consolidated Auto Enrollment. Coverage Start Date cannot be null for FFS New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_COV_END_DATE_IS_BLANK = "NYHX:30173 : Consolidated Auto Enrollment. Coverage End Date for Retro cannot be null for FFS New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_COV_CODE_IS_BLANK = "NYHX:30174 : Consolidated Auto Enrollment. Coverage Code cannot be null for FFS New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ABANDON_BCOZ_ELI_NOT_DETERMINED = "NYHX:30175 : Consolidated Auto Enrollment. Queue Abandon because eligibility is not determined.";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ABANDON_BCOZ_ELI_HAS_PENDING = "NYHX:30176 : Consolidated Auto Enrollment. Queue Abandon because eligibility has pending members.";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ABANDON_BCOZ_ANOTHER_QUEUE_EVENT_SUPERSEDE = "NYHX:30177 : Auto Enrollment Queue Aggregator. Queue Abandon because Another Queue Event Supersede. ID of Supersede Queue {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ABANDON_BCOZ_ANOTHER_QUEUE_EVENT_SUPERSEDE_RETRO = "NYHX:30178 : Auto Enrollment Queue Aggregator. Retro Queue Abandon because Another Queue Event Supersede. ID of Supersede Queue {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_RETRO_SUPPORTS_ONLY_ADD = "NYHX:30179 : Auto Enrollment Queue Aggregator. Retro Queue only supports Add action. Auto Enrollment Queue Id {}, Action {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_FFS_RETRO = "NYHX:30180 : Retro FFS Auto Auto Enrollment. Retro Queue only supports Add action. Auto Enrollment Queue Id {}, Action {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_MEDICAID_RETRO_NO_MEMBER_IN_CURRENT_APP = "NYHX:30181 : Retro FFS Auto Auto Enrollment. Application member does not exists in application. Auto Enrollment Queue Id {}, Application Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_MEDICAID_RETRO_NO_CIN = "NYHX:30182 : Retro Medicaid Auto Enrollment. Retro Auto Enrollment Queue does not have cin. Auto Enrollment Queue Id {}, Application Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_APP_MEMBER_NOTSAME_ELG_MEMBER = "NYHX:30183 : Retro FFS Auto Auto Enrollment. Application member is not same as Eligibility member. Eligibility Member Id {}, Application Member Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_AUTO_ENRL_APPPLAN_NOT_FOUND = "NYHX:30184 : Retro FFS Auto Auto Enrollment. Application for retro not found. Application Id {}, retroApplicationQueue Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_NO_MEMBER_IN_ELIG = "NYHX:30185 : Retro FFS Auto Auto Enrollment. Eligibility Member not found. Application ID {}, Eligibility ID {}, NYHX ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_MEMBER_NOT_IN_ELIGIBILITY = "NYHX:30186 : Member not found in Eligibility. NyhxMember Id {}, Eligibility Id {}.";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_AID_CATEG_IS_BLANK = "NYHX:30187 : Consolidated Auto Enrollment. Aid Categ cannot be null for FFS New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_AID_CATEG_FORMMC_IS_BLANK = "NYHX:30187 : Consolidated Auto Enrollment. Aid Categ cannot be null for MMC New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_MMC_COV_DATE_SHOULD_BE_30 = "NYHX:30188 : Consolidated Auto Enrollment. Coverage Code for MMC should be 30. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_MEDICAID_RETRO_CAN_BE_ADD_ONLY = "NYHX:30189 : Consolidated Auto Enrollment. Retro Medicaid can be add only. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ONLY_MEDICAID_CAN_BE_RETRO = "NYHX:30190 : Consolidated Auto Enrollment. Only Medicaid can be Retro enrolled. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_START_DATE_END_DATE_SAME = "NYHX:30190 : Consolidated Auto Enrollment. Start Date and End Date cannot be same. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_START_DATE_GREATER_THAN_END_DATE = "NYHX:30190 : Consolidated Auto Enrollment. Start Date cannot be greater than end date. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ADDITONALINFO_AUTOENROLLMENTQUEUE = "NYHX:30191 : Consolidated Auto Enrollment. Failed to create copy of last submitted Enrollment. Eligibility Id : {}, Last submitted App Id : {}";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_APP_PROGRAMID_NOT_PRESENT_APP_GRP = "NYHX:30192 : Consolidated Auto Enrollment. Unable to find program id in application group. Program Id : {}, App Group Id : {}, App Id : {}";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_NO_DISENROLL_REASON = "NYHX:30193 : Consolidated Auto Enrollment. No Disenrollment reason available for disenrollment queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ACC_BLANK_2 = "NYHX:30194 : Consolidated Auto Enrollment. Account Id is blank. Auto Enrollment ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_USER_PROFILE_NULL = "NYHX:30195 : Consolidated Auto Enrollment. User Profile is null. Auto Enrollment ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ELIG_NOT_FOUND = "NYHX:30196 : Consolidated Auto Enrollment. Eligibility Not found. Auto Enrollment ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ELIG_ID_SHOULDBE_NOT_NULL_FOR_NEW = "NYHX:30197 : Consolidated Auto Enrollment. Eligibility ID is null for New Enrollment Queue. Auto Enrollment ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ELIG_ID_SHOULDBE_NOT_NULL_FOR_RETRO = "NYHX:30197 : Consolidated Auto Enrollment. Eligibility ID is null for Retro Enrollment Queue. Auto Enrollment ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ELIG_ID_SHOULDBE_NOT_NULL_FOR_UPDATE = "NYHX:30198 : Consolidated Auto Enrollment. Eligibility ID is null for Update Enrollment Queue. Auto Enrollment ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_DISENROLL_WO_ELIG_ID_ALREADY_EXIST_FOR_MEMBER = "NYHX:30199 : Consolidated Auto Enrollment. Another Disenrollment Queue already exists for same member, same program and without elig id. Auto Enrollment ID : {}, Other Auto Enrollment Id which exists for processing {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_CANNOT_PROCESS_ELIG_NOELIG_QUEUES_TOGETHER = "NYHX:30199 : Consolidated Auto Enrollment. Cannot process Queues with eligibility and without eligibility together. ";
	public static final String LOG_ERROR_CONSOLIDATED_AUTO_ENRL_SKIP_MMC_PROCESSING = "NYHX:30193 : Consolidated Auto Enrollment. Exception while checking for Medicaid MMC Existence. Auto Queue Id : {}, Eligibility ID {},  NYHX ID {} ";
	public static final String LOG_ERROR_CONSOLIDATED_AUTO_ENRL_MORE_THAN_ONE_SUBMITTED_ENROLLMENT_EXISTS = "NYHX:30194 : More than one submitted enrollments exists. Ids are : ";
	public static final String LOG_ERROR_CONSOLIDATED_AUTO_ENRL_MMC_MEMBER_NOT_EXISTS = "NYHX:31195 : Member Does not exists in previous enrollment. AEQ Id {}, NYHX Id {}";
	public static final String LOG_ERROR_CONSOLIDATED_AUTO_ENRL_MMC_MEMBER_PLAN_NOT_EXISTS = "NYHX:31196 : Member MMC Plan Does not exists in previous enrollment. AEQ Id {}, NYHX Id {}";
	public static final String LOG_ERROR_CONSOLIDATED_AUTO_ENRL_MMC_PLAN_NOT_GETTING_TERM = "NYHX:31197 : Member MMC Plan is not getting terminated but cancel. AEQ Id {}, NYHX Id {}";
	public static final String LOG_ERROR_CONSOLIDATED_AUTO_ENRL_FFS_PLAN_CANNOT_BE_TERM_1 = "NYHX:31198 : Member FFS Plan cannot be terminated because MMC is going to be terminated. AEQ Id {}, NYHX Id {}";
	public static final String LOG_ERROR_CONSOLIDATED_AUTO_ENRL_FFS_PLAN_CANNOT_BE_TERM_2 = "NYHX:31199 : Member FFS Plan cannot be terminated because MMC is going to be terminated. AEQ Id {}, NYHX Id {}";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_IMMEDIATE_MMC_WITHOUT_PLAN = "NYHX:31200 : Immediate MMC processing request without and MMC Plan. AutoEnrollmentId  {}, Eligibility Id {} ";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_PLAN_WITHOUT_IMMEDIATE_MMC = "NYHX:31201 : No Immediate MMC processing request but HIOS available. AutoEnrollmentId  {}, Eligibility Id {} ";
	public static final String LOG_ERROR_CONSOLIDATED_AUTO_ENRL_CHIP_GRP_CREATION_ERROR = "NYHX:31202 : Consolidated Auto Enrollment. Exception during creation of CHIP group. Eligibility ID {},  User Profile ID {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_MEMBER_NOT_ELIGIBLE_FOR_CHIP = "NYHX:31203 : Auto Enrollment. Member Id is not eligible for CHIP : AEQ ID {} NYHX Id {} ";	
	public static final String LOG_ERROR_EE_AUTO_ENRL_MEMBER_NOT_ALLOWEED_FOR_FULLPAY_CHIP = "NYHX:31204 : Auto Enrollment. Member Id is not allowed for Full Pay CHIP : AEQ ID {} NYHX Id {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_AID_CATEG_FOR_CHIP_IS_BLANK = "NYHX:31205 : Consolidated Auto Enrollment. Aid Categ cannot be null for CHIP New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_BATCH_AUTO_ENROLLMENT_DIFF_HIOS_ID_FOR_CHIP_ADD = "NYHX:31206: Duplicate HIOS Id recieved for CHIP ADD event for the kid. AutoEnrollmentId  {}, NYHX ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_QHP_GROUP_EXISTS_INCORRECTLY = "NYHX:31207 : Consolidated Auto Enrollment. QHP Group Exists even post disenrollment. Account Id : {}, NYHX ID {}  ";
	//CR-1327
	public static final String LOG_ERROR_EE_AUTO_ENRL_MEMBER_NOT_ELIGIBLE_FOR_CHIP_MIXED_GROUPS = "NYHX:31208 : Auto Enrollment. Member Id is not allowed for CHIP Autoenrollment because of mixed groups : AEQ ID {} NYHX Id {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_MMC_RETRO_NO_PLAN = "NYHX:31210 : Retro MMC Auto Enrollment. Retro MMC Auto Enrollment Queue does not have Plan Hios to Auto Assign. Auto Enrollment Queue Id {}, Application Id {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_RETRO_MEDICAID_NO_REQ_DATA_ID_NO_MEMBER = "NYHX:31209 : Retro Medicaid Auto Enrollment. Retro Auto Enrollment Queue missing Req Data XML Id and no member exists in determined eligibility. Auto Enrollment Queue Id {}, Application Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_MEDICAID_RETRO_NO_PLAN = "NYHX:31211 : Retro Medicaid Auto Enrollment. Retro Medicaid Auto Enrollment Queue No Plan found while creating Application Plan. Auto Enrollment Queue Id {}, Plan Hios Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_MEDICAID_RETRO_NO_PLAN_2 = "NYHX:31212 : Retro Medicaid Auto Enrollment. Retro Medicaid Auto Enrollment Queue No Plan found while creating Application Transaction. Application Plan Id {}, Plan Hios Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_MEDICAID_RETRO_CUSTOM_DATA_ACCOUNT_DTO_NULL_AFTER_CONVERSION = "NYHX:31213 : Retro Medicaid Auto Enrollment. Retro Medicaid Auto Enrollment Queue Custom Data Account DTO null after conversion. AutoEnrollmentQueueId {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_MEDICAID_RETRO_CUSTOM_DATA_MEMBER_DTO_NULL_AFTER_CONVERSION = "NYHX:31214 : Retro Medicaid Auto Enrollment. Retro Medicaid Auto Enrollment Queue Custom Data Member DTO null after conversion. AutoEnrollmentQueueId {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_MEDICAID_RETRO_MULTIPLE_PLANS_FOUND = "NYHX:31215 : Retro Medicaid Auto Enrollment. More than one Plan found for Medicaid Retro Request . Application Plan Id {}, Plan Hios Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_RETRO_MEDICAID_NO_ADDRESS_REQ_DATA_AND_NO_MEMBER = "NYHX:31216 : Retro Medicaid Auto Enrollment. Retro Medicaid Auto Enrollment Queue missing Req Data Address DTO and No member for latest eligibility. Auto Enrollment Queue Id {}, Application Id {} ";	
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_INVALID_COMBINATION_CATEGORY_CD_AND_COVERAGE_CD = "NYHX:31217 : Consolidated Auto Enrollment. Retro Medicaid Queue has Invalid CATEGORY_CD and COVERAGE_CD combination. Auto Enrollment Queue Id : {}, CATEGORY_CD : {}, COVERAGE_CD : {} ";
	
	public static final String LOG_ERROR_EE_RENEWAL_END_DATE_IS_NULL = "NYHX:30194 : Renewal End Date is empty. Queue Id is : ";
	public static final String LOG_ERROR_EE_CHP_AUTO_ENROLL_END_DATE_IS_NULL = "NYHX:30202 : CHP Auto Enrollment End Date is empty. NYHX Id is : ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_MMC_MULTIPLE_PLANS_FOUND = "NYHX:31218 : More than one Plan found for MMC ADD with immediate indicator . Plan Hios Id {}, Effective Date {}, County {} ";
	//CR-1327 -Drop 2 
	public static final String LOG_ERROR_EE_AUTO_ENRL_REINSTATEMENT_IS_APPLICABLE_ONLY_FOR_CHIP_NEWBORN = "NYHX:31219 : Auto Enrollment. Reinstatement is allowed only for CHIP Newborn : AEQ ID {} NYHX Id {} ";
	public static final String LOG_ERROR_EE_AUTO_ENRL_REINSTATEMENT_COVERAGE_START_DATE_BEFORE_ELG_START_DATE = "NYHX:31220 : Auto Enrollment. Reinstatement coverage start date is before eligibility start date : AEQ ID {} NYHX Id {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_ELIG_ID_SHOULDBE_NOT_NULL_FOR_REINSTATE = "NYHX:31221 : Consolidated Auto Enrollment. Eligibility ID is null for Reinstatement Enrollment Queue. Auto Enrollment ID : {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_COV_START_DATE_IS_BLANK_FOR_REINSTATE = "NYHX:31222 : Consolidated Auto Enrollment. Coverage Start Date cannot be null for REINSATEMENT New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_COV_END_DATE_IS_BLANK_FOR_REINSTATE = "NYHX:31223 : Consolidated Auto Enrollment. Coverage end Date cannot be null for REINSATEMENT New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_PLAN_HIOS_FOR_AUTO_ASSIGN_IS_BLANK_FOR_REINSTATE = "NYHX:31224 : Consolidated Auto Enrollment. Plan HIOS for auto assign cannot be null for REINSATEMENT New Enrollment Queue. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_AUTO_REINSTATE_NOT_ELIGIBLE_FOR_CROSS_CHIP_GROUPS = "NYHX:31225 : Auto Enrollment. Member Id is not allowed for CHIP Reinstate Autoenrollment because of cross CHIP groups : AEQ ID {} NYHX Id {} ";
	public static final String LOG_ERROR_EE_AUTO_REINSTATE_NOT_ALLOWED_WITH_OUT_TERM_PLAN = "NYHX:31226 : Auto Enrollment. Member is not allowed for CHIP Reinstate Autoenrollment with out Termination plan";
	public static final String LOG_ERROR_EE_AUTO_REINSTATE_DUPLICATE_REQUEST= "NYHX:31227 : Auto Enrollment. Member  is not allowed for CHIP Reinstate Autoenrollment as respective plan already been reinstated";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_CHIP_RETRO_CAN_BE_ADD_ONLY = "NYHX:31228 : Consolidated Auto Enrollment. Retro Chip can be add only. Auto Queue Id : {}, Eligibility ID {} ";
	public static final String LOG_ERROR_EE_CONSOLIDATED_AUTO_ENRL_CHIP_RETRO_NO_PLAN = "NYHX:31229 : Retro CHIP Auto Enrollment. Retro CHIP Auto Enrollment Queue does not have Plan Hios to Auto Assign. Auto Enrollment Queue Id {}, Application Id {} ";
	
	
	public static final String LOG_ERROR_AEQ_UNIFIED_DOES_NOT_EXISTS = "NYHX:30500 : AEQ Unified does not exist. Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ELIG_STATUS_OR_VER_DIFF = "NYHX:30501 : AEQ Unified. Eligibility id is different from latest determined. Latest Elig ID {}";
	public static final String LOG_ERROR_AEQ_UNIFIED_MEMBER_NOT_ELIGIBLE_FOR_CHIP = "NYHX:30502 : AEQ Unified. Member is not eligible for CHIP : Member Id {}, AEQ ID {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_MEMBER_EXEMPT_BUT_MMC_ADD_IN_Q = "NYHX:30503 : AEQ Unified. Member is exempted from Mandatory enrollment. Member Id {}, AEQ ID {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_NO_ACTIVE_FFS_MMC_BUT_MMC_ADD_IN_Q = "NYHX:30504: AEQ Unified. No Active FFS or MMC Exists but MMC Add action in queue. AutoEnrollmentId  {}";
	public static final String LOG_ERROR_AEQ_UNIFIED_FFS_RETRO_BUT_NO_ADD = "NYHX:30505: AEQ Unified. FFS Retro Queue but action is not add. AEQ ID  {}";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MEMBER_NOT_HAVING_ACTIVE_PLAN = "NYHX:30506 : AEQ Unified. Member does not have any active plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MEMBER_NOT_HAVING_ACTIVE_QHP_PLAN = "NYHX:30507 : AEQ Unified. Member does not have any active QHP plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MEMBER_NOT_HAVING_ACTIVE_CHIP_PLAN = "NYHX:30508 : AEQ Unified. Member does not have any active CHIP plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MEMBER_NOT_HAVING_ACTIVE_EPP_PLAN = "NYHX:30509 : AEQ Unified. Member does not have any active EPP plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MEMBER_NOT_HAVING_ACTIVE_FFS_PLAN = "NYHX:30510 : AEQ Unified. Member does not have any active FFS plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MEMBER_NOT_HAVING_ACTIVE_MMC_PLAN = "NYHX:30511 : AEQ Unified. Member does not have any active MMC plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UPDATE_UPDATE_FFS_COV_CODE_BUT_NOT_13_07_TO_26 = "NYHX:30512 : AEQ Unified. This class will abandon FFS UPDATE request if previous coverage code is 13 or 07 and New Coverage code is 26. Application ID : {} , Member HX_ID : {} "; 
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_PLAN = "NYHX:30513 : AEQ Unified. Member does not have any active plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_QHP_PLAN = "NYHX:30514 : AEQ Unified. Member does not have any active QHP plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_EPP_PLAN = "NYHX:30515 : AEQ Unified. Member does not have any active EPP plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_APTC_PLAN = "NYHX:30516 : AEQ Unified. Member does not have any active APTC plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_CSR_PLAN = "NYHX:30517 : AEQ Unified. Member does not have any active APTC-CSR plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_APTC_PP_PLAN = "NYHX:30518 : AEQ Unified. Member does not have any active APTC-PP plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_CHIP_PLAN = "NYHX:30519 : AEQ Unified. Member does not have any active CHIP plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_FFS_PLAN = "NYHX:30520 : AEQ Unified. Member does not have any active MA-FFS plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_MEMBER_NOT_HAVING_ACTIVE_MMC_PLAN = "NYHX:30521 : AEQ Unified. Member does not have any active MA-MMC plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_Q_WO_ELIG_ID_PRESENT_WITH_OTHER_Q = "NYHX:30522 : AEQ Unified. DIsenrollment (Without Elig ID) cannot be processed, while other Queues are pending. Q ID : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DISENROLL_REASON_DESEASED_BUT_NO_DATE_OF_DEATH = "NYHX:30523 : AEQ Unified. DIsenrollment due to a Deaceased Member cannot be processed without Date of Death for the Member. ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_ONLY_FFS_CAN_BE_RETRO = "NYHX:30524 : AEQ Unified. Only FFS can be Retro enrolled. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_RETRO_NO_COV_ST_DT = "NYHX:30525 : AEQ Unified. No coverage start date for Add Retro. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_RETRO_NO_COV_END_DT = "NYHX:30526 : AEQ Unified. No coverage end date for Add Retro. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_RETRO_COV_END_DT_EQ_ST_DT = "NYHX:30527 : AEQ Unified. coverage start date and coverage end date are same for Retro Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_RETRO_COV_END_DT_LESS_THAN_ST_DT = "NYHX:30528 : AEQ Unified. coverage end date is lesser than coverage start date for Retro Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_COV_END_DT_LESS_THAN_ST_DT = "NYHX:30529 : AEQ Unified. coverage end date is lesser than coverage start date. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_COV_END_DT_IS_NULL = "NYHX:30614 : AEQ Unified. coverage end date is null. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_RETRO_NO_COV_CODE = "NYHX:30530 : AEQ Unified. No coverage Code for Add Retro. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_RETRO_NO_AID_CATEG = "NYHX:30531 : AEQ Unified. No Aid Category for Add Retro. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_MMC_COV_CODE_NOT_30 = "NYHX:30532 : AEQ Unified. Coverage Code is not 30 for MMC ADD. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_MA_NO_COV_ST_DT = "NYHX:30533 : AEQ Unified. No coverage start date for MA Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_EPP_NO_COV_ST_DT = "NYHX:30534 : AEQ Unified. No coverage start date for EPP Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_EPP_NO_COV_END_DT = "NYHX:30535 : AEQ Unified. No coverage end date for EPP Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_EPP_COV_END_DT_NOT_GT_THAN_ST_DT = "NYHX:30536 : AEQ Unified. Coverage End Date is NOT greater than Start Date for EPP Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_MA_NO_COV_End_DT = "NYHX:30537 : AEQ Unified. No coverage end date for MA Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_MA_COV_END_DT_EQ_ST_DT = "NYHX:30538 : AEQ Unified. coverage start date and coverage end date are same for MA Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_MA_COV_END_DT_LESS_THAN_ST_DT = "NYHX:30539 : AEQ Unified. coverage end date is lesser than coverage start date for MA Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_MA_NO_COV_CODE = "NYHX:30540 : AEQ Unified. No coverage Code for MA ADD. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_MA_NO_AID_CATEG = "NYHX:30541 : AEQ Unified. No Aid Category for MA Add. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EPP_INVALID_AID_CATEG = "NYHX:30542 : AEQ Unified. Invalid Aid Category for EPP, Should be one of [B0,B1,B2,B3,B4,B5]. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ADD_FFS_COV_CODE_30_BUT_ENRL_IN_MMC = "NYHX:30543 : AEQ Unified. Coverage Code 30 in Eligibility, FFS Add Event but person already enrolled in MMC. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MMC_COV_CODE_NOT_30 = "NYHX:30544 : AEQ Unified. Coverage Code is not 30 for MMC Update. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MA_NO_AID_CATEG = "NYHX:30545 : AEQ Unified. No Aid Category for MA Update. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_MA_NO_COV_CODE = "NYHX:30546 : AEQ Unified. No coverage Code for MA Update. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_APTCPP_NO_AID_CATEG = "NYHX:30547 : AEQ Unified. No Aid Category for APTCPP Update. Auto Queue Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ELIGIBILITY_NOT_FOUND = "NYHX:30548 : AEQ Unified. Eligibility not found. User Profile Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_DISENROLL_APP_CANNOT_BE_NULL = "NYHX:30549 : AEQ Unified. Application cannot be null. User Profile Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_DISENROLL_NO_GROUP_EXISTS = "NYHX:30550 : AEQ Unified. No group exists where person and program exists. AEQ Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_DISENROLL_MULTIPLE_GROUP_EXISTS = "NYHX:30551 : AEQ Unified. More than One group exists where person and program exists. AEQ Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_MAPPER_MEMBER_DOES_NOT_EXISTS_BY_ID = "NYHX:30552 : AEQ Unified. Member Does not exists by Id. Member Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_MAPPER_NYHX_ID_BLANK_FOR_MEMBER = "NYHX:30553 : AEQ Unified. NYHX ID blank for Member. Member Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_MAPPER_GENERIC_ERROR = "NYHX:30554 : AEQ Unified. Generic Error in aeqUnifiedServiceMapper. Reason :  ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_DISENROLL_ERROR_IN_COV_TIER_CALC = "NYHX:30555 : AEQ Unified. Generic Error in during calculating coverage tier. Reason :  ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_ERROR_WHILE_CALC_COV_TIER = "NYHX:30556 : AEQ Unified. Error while calculating coverage tier.";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_GRP_DTO_ERROR = "NYHX:30557 : AEQ Unified. Error while coverting application group into DTO. Group ID :  ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_PLAN_NOT_FOUND = "NYHX:30558 : AEQ Unified. Plan not found. ApplicationPlan Id, Plan Id  :  ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_SUBSCRIBER_NYHX_ID_IS_BLANK = "NYHX:30559 : AEQ Unified. Subscriber NYHX ID is blank for cleanup process. ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_COV_TIER_IS_NULL_2 = "NYHX:30560 : AEQ Unified. Coverage tier is blank.";
	public static final String LOG_ERROR_AEQ_UNIFIED_ELIGIBILITY_NOT_FOUND_2 = "NYHX:30561 : AEQ Unified. Eligibility not found. Eligibility Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_ELIGIBILITY_ID_IS_NULL = "NYHX:30562 : AEQ Unified. Eligibility ID is null ";
	public static final String LOG_ERROR_AEQ_UNIFIED_MULTIPLE_SUBSCRIBER_MENTIONED = "NYHX:30563 : AEQ Unified. Multiple subscriber mentioned in the group provided. Group Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_NO_SUBSCRIBER_PROVIDED = "NYHX:30564 : AEQ Unified. Multiple subscriber No subscriber mentioned in the group provided. Group Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_MA_GRP_HAS_ONE_PLUS_MEMBER = "NYHX:30565 : AEQ Unified. More than one member in MA group. Group Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_REL_NOT_PROVIDED_FOR_GRP_MEMBER = "NYHX:30566 : AEQ Unified. Relationship not provided for dependent in group. Group Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_MULTIPLE_SPOUSE_MEMBER_IN_A_GRP = "NYHX:30567 : AEQ Unified. More than one spouse for subscriber in a single group. Group Id : ";
	public static final String LOG_ERROR_UNIFIED_MULTIPLE_SPOUSE_MEMBER_IN_A_GRP = "If a spouse/domestic partner already exist in terminated plan, application will not allow to add another spouse/domestic partner on the same terminated plan.";
	public static final String LOG_ERROR_AEQ_UNIFIED_NO_PROG_ID_IN_GRP = "NYHX:30568 : AEQ Unified. Group Id is not available in group. Group Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_INVALID_INSURABLE_REL_FOR_QHP_GRP = "NYHX:30569 : AEQ Unified. Relationship is not insurable for one of the member. Member NYHX Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_INVALID_REL_FOR_CHIP_GRP = "NYHX:30570 : AEQ Unified. Relationship is not insurable for one of the member. Member NYHX Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_NEW_ENRL_ELIG_CANNOT_BE_NULL = "NYHX:30571 : AEQ Unified. Eligibility cannot be null. User Profile Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_UPDATE_ENRL_ELIG_CANNOT_BE_NULL = "NYHX:30572 : AEQ Unified. Eligibility cannot be null. User Profile Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_UPDATE_ENRL_APPLICATION_CANNOT_BE_NULL = "NYHX:30573 : AEQ Unified. Application cannot be null. User Profile Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_RETRO_ENRL_ELIG_CANNOT_BE_NULL = "NYHX:30574 : AEQ Unified. Eligibility cannot be null. User Profile Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_DISENROLL_DTO_POPULATE_ERROR_1 = "NYHX:30575 : AEQ Unified. Failed in AEQUnifiedServiceMapperImpl. aeqDto Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_DISENROLL_DTO_POPULATE_ERROR_2 = "NYHX:30576 : AEQ Unified. Failed in AEQUnifiedServiceMapperImpl. aeqDto Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_EVENT_GEN_DISENROLL_DTO_POPULATE_ERROR_3 = "NYHX:30577 : AEQ Unified. Failed in AEQUnifiedServiceMapperImpl. aeqDto Id : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_MORE_THAN_1_PLAN_FOUND = "NYHX:30578 : AEQ Unified. More than one plan found.  ";
	public static final String LOG_ERROR_AEQ_UNIFIED_NO_PLAN_EXISTS_FOR_GIVEN_PLAN_ID = "NYHX:30579 : AEQ Unified. No plan exists for given plan Id. PLan Id : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_RENEW_MEMBER_NOT_HAVING_ACTIVE_PLAN = "NYHX:30580 : AEQ Unified. Member does not have any active plan. Application ID : {} , Member HX_ID : {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_UPDATE_Q_WO_ELIG_ID = "NYHX:30581 : AEQ Unified. Renewal (Without Elig ID) cannot be processed. Q ID : ";
	public static final String LOG_ERROR_AEQ_UNIFIED_NO_CATEGORY_PROVIDED = "NYHX:30582 : AEQ Unified. No Category been provided for Auto Enrollment Queue Event. AEQ Id : {}, NYHX Id {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_NO_ACTION_PROVIDED = "NYHX:30583 : AEQ Unified. No Action been provided for Auto Enrollment Queue Event. AEQ Id : {}, NYHX Id {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_NO_PROGRAM_ID_PROVIDED = "NYHX:30584 : AEQ Unified. No Program ID been provided for Auto Enrollment Queue Event. AEQ Id : {}, NYHX Id {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_NO_DISENROLLMENT_REASON = "NYHX:30585 : AEQ Unified. No Disenrollment Reason provided for Auto Enrollment Queue Event. AEQ Id : {}, NYHX Id {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_DATE_HANDLING_ERROR = "NYHX:30586 : AEQ Unified. Date Exception";
	public static final String LOG_ERROR_AEQ_UNIFIED_UNBORN_IN_MMC_BUT_FFS_ADD_IN_Q = "NYHX:30587: AEQ Unified. Unborn in MMC but FFS ADD event found without Retro Indicator. AutoEnrollmentId  {}";
	public static final String LOG_ERROR_AEQ_UNIFIED_MMC_DIENRL_USR_NO_SHOW_MISSING_ARGS = "NYHX:30588: One or more argument is missing. userProfileId{}, nyhxMemberId{}, newEligibilityStartDate{}";
	public static final String LOG_ERROR_AEQ_UNIFIED_COV_END_DATE_NULL_FOR_MMC_DISENRL = "NYHX:30589: System is returning empty coverage end date for user no show MMC termination. Application Plan Id  {}";
	public static final String LOG_ERROR_AEQ_UNIFIED_NEW_BORN_IND_INVALID = "NYHX:30590: AEQ Unified. New Born indicator is invalid. AEQ Id : {}, NYHX Id {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_CHIP_ADD_ALONE_IND_INVALID = "NYHX:30591: AEQ Unified. CHIP ADD alone is not supported. AEQ Id : {}, NYHX Id {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_CHIP_DISENROLL_ADD_IND_INVALID = "NYHX:30592: AEQ Unified. CHIP UPDATE Action is generated from CHIP_TYPE_CHANGE DISENROLL, ADD events, so Suppressing the DISENROLL event. AEQ Id : {}, NYHX Id {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_CHIP_DISENROLL_ADD_WITH_MIXED_HH_IND_INVALID = "NYHX:30593: AEQ Unified. CHIP DISENROLL Action is honored when the HH is mixed of SUBSIDIZED and NON SUBSIDIZED, so Suppressing the ADD event. AEQ Id : {}, NYHX Id {} ";
	public static final String LOG_ERROR_AEQ_UNIFIED_RETRIEVING_APPLICATION_ERROR = "NYHX:30594: AEQ Unified. Error while retrieving application. ";
	public static final String LOG_ERROR_AEQ_UNIFIED_CHIP_ADD_EVENT_RCVD_WHEN_RENEWAL_NOT_ACTIVE = "NYHX:30595: AEQ Unified. CHIP ADD Event recieved when renewal is not active. AEQ Id : {}, NYHX Id {} ";
	
	public static final String LOG_ERROR_ENRL_REQ_AEQ_ELIG_NOT_FOUND = "NYHX:30600: Determined Eligibility not found. Account Id : {} ";
	public static final String LOG_ERROR_ENRL_REQ_DTO_IS_NULL = "NYHX:30601: Enrollment Request DTO is Null.";
	public static final String LOG_ERROR_ENRL_REQ_NO_MEMBER = "NYHX:30602: No member exists in Enrollment Request DTO. Account Id : {} ";
	public static final String LOG_ERROR_ENRL_REQ_AEQ_CATEG_NOT_IDENTIFIED = "NYHX:30603: Auto Disenroll Category not identified. Account Id : {} ";
	public static final String LOG_ERROR_ENRL_REQ_AEQ_CATEG_INCORRECT_ACTIVE_COV = "NYHX:30604: Incorrect Active Coverage. Coverage Start Date is greater than or equal to Active Coverage End Date. Account Id : {} ";
	public static final String LOG_ERROR_ENRL_REQ_AEQ_CATEG_ACTIVE_COV_OBJ_NULL = "NYHX:30605: Active Coverage Object is null. Account Id : {}, NYHX Member ID {} ";
	public static final String LOG_ERROR_ENRL_REQ_XML_EMPTY = "NYHX:30606: Generated Request XML is empty. Account Id : {}, NYHX Member ID {} ";
	public static final String LOG_ERROR_ENRL_REQ_SAVE_FAILED = "NYHX:30607: Generated Application Data Request could not be persisted. Account Id : {}, NyhxMemberId {} ";
	public static final String LOG_ERROR_ENRL_REQ_APP_REQ_DATA_NULL = "NYHX:30608: EnrlRequestData object is null. Account Id : {} ";
	public static final String LOG_ERROR_ENRL_REQ_APP_REQ_DATA_ID_NULL = "NYHX:30609: EnrlRequestData ID is null. Account Id : {} ";
	public static final String LOG_ERROR_ENRL_REQ_APP_REQ_DATA_COUNTY_NOT_FOUND = "NYHX:30610: EnrlRequestData County Not for given County Code. Account Id : {}, NyhxMemberId {} ";
	public static final String LOG_ERROR_ENRL_REQ_APP_REQ_DATA_UPSTATE_DNSTATE_IND_NULL = "NYHX:30611: EnrlRequestData Upstate Downstate Indicator is Null for given County Code. Account Id : {}, NyhxMemberId {}, County Code {} ";
	public static final String LOG_ERROR_ENRL_REQ_APP_REQ_DATA_CIN_NOT_FOUND = "NYHX:30612: EnrlRequestData - CIN Number could not be identified for the given member information . Account Id : {}, NyhxMemberId {} ";
		
	
	// The Below constants have been added as part of the CR 1227.
	
	/*public static final String LOG_ERROR_ENRL_REQ_AEQ_ELIG_NOT_FOUND = "NYHX:30600: Determined Eligibility not found. Account Id : {} ";
	public static final String LOG_ERROR_ENRL_REQ_DTO_IS_NULL = "NYHX:30601: Enrollment Request DTO is Null.";
	public static final String LOG_ERROR_ENRL_REQ_NO_MEMBER = "NYHX:30602: No member exists in Enrollment Request DTO. Account Id : {} ";
	public static final String LOG_ERROR_ENRL_REQ_AEQ_CATEG_NOT_IDENTIFIED = "NYHX:30603: Auto Disenroll Category not identified. Account Id : {} ";
	*/
	public static final String LOG_ERROR_ENRL_RETRO_REQ_CIN_MISSING="NYHX:30621: Retro Enrollment Request. Value for CIN Number is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_UP_DOWN_STATE_IND_MISSING = "NYHX:30622: Retro Enrollment Request. Value for Up or Down State Indicator is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_UP_DOWN_STATE_IND_INVALID = "NYHX:30623: Retro Enrollment Request. Value for Up or Down State Indicator is Invalid. Account Id {}, NYHX Id {}, Up or Down State Indicator {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_CITIZENSHIP_CD_MISSING="NYHX:30624: Retro Enrollment Request. Value for Citizenship Code is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_SSN_VERIFICATION_CD_MISSING = "NYHX:30625: Retro Enrollment Request. Value for SSN Verification Code is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_MARITAL_STATUS_CD_MISSING = "NYHX:30626: Retro Enrollment Request. Value for Marital Status Code is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_FIRST_NAME_MISSING="NYHX:30627: Retro Enrollment Request. Value for First Name is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_FIRST_NAME_INVALID = "NYHX:30628: Retro Enrollment Request. Value for First Name is Invalid. Account Id {}, NYHX Id {}, FirstName {}  ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_LAST_NAME_MISSING = "NYHX:30629: Retro Enrollment Request. Value for Last Name is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_LAST_NAME_INVALID="NYHX:30630: Retro Enrollment Request. Value for Last Name is Invalid. Account Id {}, NYHX Id {}, LastName {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_MIDDLE_NAME_INVALID = "NYHX:30631: Retro Enrollment Request. Value for Middle Name is Invalid. Account Id {}, NYHX Id {}, MiddleName {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_SUFFIX_INVALID = "NYHX:30632: Retro Enrollment Request. Value for Suffix is Invalid. Account Id {}, NYHX Id {}, suffix {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_GENDER_MISSING="NYHX:30633: Retro Enrollment Request. Value for Gender is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_GENDER_INVALID = "NYHX:30634: Retro Enrollment Request. Value for Gender is Invalid. Account Id {}, NYHX Id {}, Gender {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_DOB_NULL = "NYHX:30635: Retro Enrollment Request. Value for Date Of Birth is Null. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_DOB_INVALID="NYHX:30636: Retro Enrollment Request. Value for Date Of Birth is Invalid. Account Id {}, NYHX Id {}, DOB {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_SSN_INVALID = "NYHX:30637: Retro Enrollment Request. Value for SSN is Invalid. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_PLAN_HIOS_ID_INVALID = "NYHX:30638: Retro Enrollment Request. Value for Plan HiosID is Invalid. Account Id {}, NYHX Id {}, LastName {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_PLAN_HIOS_ID_MISSING="NYHX:30639: Retro Enrollment Request. Value for Plan HiosID is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_CD_INVALID = "NYHX:30640: Retro Enrollment Request. Value for Coverage Code is Invalid. Account Id {}, NYHX Id {}, CoverageCode {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_CD_MISSING = "NYHX:30641: Retro Enrollment Request. Value for Coverage Code is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_INVALID_PROGRAM="NYHX:30642: Retro Enrollment Request. Value for Program Id is Invalid. Account Id {}, NYHX Id {}, ProgramId {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_PROGRAM_ID_NULL = "NYHX:30643: Retro Enrollment Request. Value for Program Id is Null. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_NYHX_MEMBER_MISSING = "NYHX:30644: Retro Enrollment Request. Value for NYHX Member Id is Missing. Account Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_CHARGE_CD_MISSING="NYHX:30645: Retro Enrollment Request. Value for Charge Code is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_END_DT_MUST_BE_GREATER="NYHX:30646: Retro Enrollment Request. Value for Retro Coverage End Date must be greater than Start Date. Account Id {}, NYHX Id {}, RetroCoverageEndDate {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_START_DATE_NULL = "NYHX:30647: Retro Enrollment Request. Value for Coverage Start Date is Null. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_END_DATE_NULL = "NYHX:30648: Retro Enrollment Request. Value for Coverage End Date is Null. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_START_DT_MUST_BE_GREATER_OR_EQUAL_TO_DOB = "NYHX:30649: Retro Enrollment Request. Value for Retro Coverage Start Date must be greater than or equal to Date Of Birth. Account Id {}, NYHX Id {}, RetroCoverageStartDate {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_AID_CATEGORY_MISSING="NYHX:30650: Retro Enrollment Request. Value for Aid Category is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ERR_FIRSTNAME_LENGTH="NYHX:30651 : Retro Enrollment Request. Value for First name is too long. Account Id {}, NYHX Id {}, FirstName {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ERR_LASTNAME_LENGTH="NYHX:30652 : Retro Enrollment Request. Value for Last name is too long. Account Id {}, NYHX Id {}, LastName {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_MIDDLE_NAME_LENGTH="NYHX:30653 : Retro Enrollment Request. Value for  Middle name is too long. Account Id {}, NYHX Id {}, MiddleName {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_MARITAL_STATUS_CD_INVALID="NYHX:30654 : Retro Enrollment Request. Value for Marital Status Code is Invalid. Account Id {}, NYHX Id {}, MaritalStatus {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_NYHX_MEMBER_INVALID="NYHX:30655 : Retro Enrollment Request. Value for HXID Format is Invalid. Account Id {}, NYHX Id {}";
	public static final String LOG_ERROR_ENRL_USER_ACTIVE_COVERAGE_START_DATE_NULL = "NYHX:30656: Retro Enrollment Request. Value for  User Active Coverage Start Date is Null. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_USER_ACTIVE_COVERAGE_END_DATE_NULL = "NYHX:30657: Retro Enrollment Request. Value for User Active Coverage End Date is Null. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_USER_ACTIVE_COVERAGE_END_DATE_MUST_BE_GREATER_THAN_COVERAGE_START_DATE = "NYHX:30658: Retro Enrollment Request. Value for User Active Coverage End Date must be greater than User Active Coverage Start Date. Account Id {}, NYHX Id {}, CoverageStartDate {} ";
	public static final String LOG_ERROR_ENRL_USER_ACTIVE_COVERAGE_END_DATE_MUST_BE_GREATER_THAN_RETRO_COVERAGE_END_DATE = "NYHX:30659: Retro Enrollment Request. Value for User Active Coverage End Date must be greater than Retro Coverage End Date. Account Id {}, NYHX Id {}, UserActiveCoverageEndDate {} ";
	public static final String LOG_ERROR_ENRL_USER_ACTIVE_COVERAGE_END_DATE_IS_IN_PAST = "NYHX:30660: Retro Enrollment Request. Value for User Active Coverage End Date is in Past. Account Id {}, NYHX Id {}, UserActiveCoverageEndDate {} ";
	public static final String LOG_ERROR_ENRL_RETRO_DATE_HANDLING_ERROR = "NYHX:30661 : Retro Enrollment Request. Date Exception";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_NOT_PROVIDED="NYHX:30662: Retro Enrollment Request. Value for Address is Not Provided. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_LINE_ONE_MISSING="NYHX:30663: Retro Enrollment Request. Value for Address Line One is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_LINE_ONE_INVALID = "NYHX:30664: Retro Enrollment Request. Value for Address Line One is Invalid. Account Id {}, NYHX Id {}, AddressLineOne {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_LINE_ONE_LENGTH = "NYHX:30665: Retro Enrollment Request. Value for Address Line One is too long. Account Id {}, NYHX Id {}, AddressLineOne {}  ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_LINE_TWO_INVALID = "NYHX:30666: Retro Enrollment Request. Value for Address Line Two is Invalid. Account Id {}, NYHX Id {}, AddressLineTwo {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_LINE_TWO_LENGTH = "NYHX:30667: Retro Enrollment Request. Value for Address Line Two is too long. Account Id {}, NYHX Id {}, AddressLineTwo {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_CITY_MISSING="NYHX:30668: Retro Enrollment Request. Value for City is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_CITY_INVALID = "NYHX:30669: Retro Enrollment Request. Value for City is Invalid. Account Id {}, NYHX Id {}, City {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_CITY_LENGTH = "NYHX:30670: Retro Enrollment Request. Value for City is too long. Account Id {}, NYHX Id {}, City {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_APT_OR_SUITE_INVALID = "NYHX:30671: Retro Enrollment Request. Value for AptSuite is Invalid. Account Id {}, NYHX Id {}, AptSuite {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ADDRESS_APT_OR_SUITE_LENGTH = "NYHX:30672: Retro Enrollment Request. Value for AptSuite is too long. Account Id {}, NYHX Id {}, AptSuite {}    ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_DATA_ACCOUNT_DTL_NOT_PROVIDED="NYHX:30673: Retro Enrollment Request. Value for Account DTO is Not Provided. ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_DATA_ACCOUNT_ID_MISSING="NYHX:30674: Retro Enrollment Request. Value for Account is Missing. ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_CONTEXT_REFERENCE_ID_MISSING="NYHX:30675: Retro Enrollment Request. Value for Context Reference Id is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_DATA_MEMBER_LIST_MISSING="NYHX:30676: Retro Enrollment Request. Value for Member List is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_CONTEXT_REFERENCE_ID_INVALID="NYHX:30677: Retro Enrollment Request. Value for Context Reference Id is Invalid. Account Id {}, ContextReferenceId {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_STATE_MISSING="NYHX:30678: Retro Enrollment Request. Value for State is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_STATE_LENGTH = "NYHX:30679: Retro Enrollment Request. Value for State is Invalid. Account Id {}, NYHX Id {}, State {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_STATE_INVALID = "NYHX:30680: Retro Enrollment Request. Value for State is too long. Account Id {}, NYHX Id {}, State {}  ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ZIP_CODE_MISSING="NYHX:30681: Retro Enrollment Request. Value for Zip Code is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ZIP_CODE_INVALID = "NYHX:30682: Retro Enrollment Request. Value for Zip Code is Invalid. Account Id {}, NYHX Id {}, Zip {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ZIP_CODE_LENGTH = "NYHX:30683: Retro Enrollment Request. Value for Zip Code length is not correct. Account Id {}, NYHX Id {}, Zip {}  ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COUNTY_CODE_MISSING="NYHX:30684: Retro Enrollment Request. Value for County Code is Missing. Account Id {}, NYHX Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COUNTY_CODE_INVALID = "NYHX:30685: Retro Enrollment Request. Value for County Code is Invalid. Account Id {}, NYHX Id {}, County {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COUNTY_CODE_LENGTH = "NYHX:30686: Retro Enrollment Request. Value for County Code length is not correct. Account Id {}, NYHX Id {}, County {}  ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_ZIP_COUNTY_STATE_INVALID = "NYHX:30687: Retro Enrollment Request. Combination of County, Zip and State is not correct. Account Id {}, NYHX Id {}, zip{}, County {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_START_DT_MUST_BE_GREATER_THAN_POINTER_DATE="NYHX:30688: Retro Enrollment Request. Value for Coverage Start Date must be greater than Dec 31, 2013. Account Id {}, NYHX Id {}, CoverageStartDate {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_USER_PROFILE_NULL="NYHX:30689: Retro Enrollment Request. Value for User Profile Object is null ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_USER_PROFILE_ID_NULL="NYHX:30690: Retro Enrollment Request. Value for User Profile Id is null ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_ELIGIBILITY_RESEQUENCED="NYHX:30691: Retro Enrollment Request. Value for Eligibility Status is Resequenced. Account Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_AEQ_STATUS_FAILED="NYHX:30692: Retro Enrollment Request. Value for AEQ Status is Failed. Account Id {} ";
	public static final String LOG_ERROR_ENRL_RETRO_REQ_COVERAGE_AEQ_STATUS_IN_PROGRESS="NYHX:30693: Retro Enrollment Request. Value for AEQ Status is In Progress. Account Id {} ";
	
	public static final String LOG_ERROR_EE_ENRL_REQ_DATA_GEN_UNABLE_TO_GEN_CIN = "NYHX:30694 : Unable to generate/find CIN for Newborn Medicaid Retro Coverage. Nyhx Id {}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_REQ_DATA_GEN_MISSING_COUNTY = "NYHX:30695 : County Code not available for Newborn Medicaid Retro Coverage. Nyhx Id {}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_REQ_DATA_GEN_UNABLE_TO_MAP_COUNTY_FOR_COUNTY_CD = "NYHX:30696 : Unable to map county for county code. County Code {} ";
	
	public static final String LOG_ERROR_EE_USER_NOT_FOUND = "NYHX:31111 : EE. User not found. User Id or Account Id : {} ";
	public static final String LOG_ERROR_EE_MORE_THAN_ONE_ACTIVE_PLAN_FOR_SAME_PLAN_ID = "NYHX:31112 : EE. Subscriber has more than 1 active plan for same plan id. Member Id {}, Plan Id {} ";
	public static final String LOG_ERROR_EE_NO_ACTIVE_PLAN_FOR_PLAN_ID = "NYHX:31113 : EE. Subscriber has no active plan for given plan id. Member Id {}, Plan Id {} ";
	public static final String LOG_ERROR_EE_ELIGIBILITY_FOUND_NULL_FOR_APP_ID = "NYHX:31114 : EE. ELigibility found null for App Id : {} ";
	public static final String LOG_ERROR_EE_MORE_THAN_ONE_MEMBER_FOUND_FOR_MEDICAID_GROUP_ID = "NYHX:31115 : EE. More than one member found for Medicaid : {} ";
	public static final String LOG_ERROR_EE_MEMBER_ELIGIBILITY_CODES_IS_NULL = "NYHX:31116 : EE. Member Eligibility Codes is null for Application Member Id : {} ";
	public static final String LOG_ERROR_EE_PLAN_ID_LIST_EMPTY = "NYHX:31117 : EE. Plan Id list is empty for User Profile Id and Application Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_POST_MEDICAID_RETRO_COVERAGE_START_DATE_NULL = "NYHX:31118 : EE. Coverage Start Date is null for User Profile Id and Application Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_UPDATING_RATE_CODE_COPAYER = "NYHX:31119 : EE. Exception while updating rate code and Copyer for User Profile Id and Application Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_ISSUER_ID_IS_NULL = "NYHX:31120 : EE. Issuer Id is null for User Profile Id, Application Id and Plan Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_CURRENT_PLAN_MEMBER_HIX_ID_LIST_EMPTY = "NYHX:31121 : EE. Current Plan Member Hix Id list is empty while processing Application Id, Plan Id and Subscriber Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_GETTING_CANCELED_OR_TERMINATED_MEMBERS = "NYHX:31122 : EE. Exception while getting Canceled or Terminated Members for Application Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_PREVIOUS_APPLICATION_MEMBER_IS_NULL = "NYHX:31123 : EE. Previous Application Member is null for Application Id and Member Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_APPLICATION_PLAN_COUNT_EXCEEDED = "NYHX:31124 : EE. Application Plan count more than one for Application Id, Subscriber Id and Plan Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_MEMBER_ID_LIST_EMPTY = "NYHX:31125 : EE. Current Plan Member Hix Id list is empty while processing Application Id, Plan Id and Subscriber Id : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_FETCHING_CANCELED_OR_TERMINATED_ENROLLMENT = "NYHX:31126 : EE. Exception recieved while fetching Canceled or Terminated Enrollment : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_FETCHING_NEW_ENROLLMENT = "NYHX:31127 : EE. Exception recieved while fetching New Enrollment : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_FETCHING_UPDATED_MEMBERS = "NYHX:31128 : EE. Exception recieved while fetching Updated Members : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_PREVIOUS_PLANS_LIST_EMPTY = "NYHX:31129 : EE. Previous Plans list is empty : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_POPULATING_APPLICATION_PLAN_TRANSACTION_ACTIONS = "NYHX:31130 : EE. Exception while population Application Plan Transaction Actions : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_POPULATING_APPLICATION_PLAN_FOR_CANCELLED_OR_TERMINATED_MEMBERS = "NYHX:31131 : EE. Exception while population Application Plan For Cancelled or Terminated Members : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_SETTING_APPLICATION_DATA_FOR_CANCELLATION_OR_TERMINATION = "NYHX:31132 : EE. Exception while setting Application Data For Cancellation or Termination : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_FETCHING_APPLICATION_PLAN_TRANSACTION_ACTION_REASON = "NYHX:31133 : EE. Exception while fetching Application Plan Transaction Action Reason : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_POPULATING_ENROLLMENT_PLAN_ATTRIBUTES_FOR_CHANGED_ENROLLMENT = "NYHX:31134 : EE. Exception while population Enrollment Plan Attributes for change enrollment : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_GENERATING_ENROLLMENT_TRANSACTION_RECORDS = "NYHX:31135 : EE. Exception while generating enrollment transaction records : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_834_TRANSACTION_SAVE_FAILED_FOR_ENROLLMENT = "NYHX:31136 : EE. Exception while saving 834 transaction for enrollment : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_POPULATING_MEMBER_DETAILS_TYPE_ARRAY = "NYHX:31137 : EE. Exception while populating member details type array : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_MEMBER_DETAILS_TYPE_ARRAY_IS_EMPTY = "NYHX:31138 : EE. Member details type array is empty : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_EXCEPTION_WHILE_EXECUTING_POST_ENROLLMENT = "NYHX:31139 : EE. Exception while processing post enrollment : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_MORE_THAN_ONE_PLAN_FOR_SAME_SUBSCRIBERID_AND_APPLICATION_ID = "NYHX:31140 : EE. More than one Medicaid Plan for same Subscriber Id and Application Id : {} ";
	public static final String LOG_ERROR_EE_ERROR_IN_DECEASED_MEMBER_UPDATE = "NYHX:31141 : EE. Error in update of deceased member update. HX ID {}, Status : {} ";
	public static final String LOG_ERROR_EE_ERROR_IN_DECEASED_DATE_RETRIEVAL = "NYHX:31142 : EE. Error in retrieving deceased date for removed member. HX ID {} : ";
	public static final String LOG_ERROR_EE_USER_NOT_FOUND_WHEN_SEARCH_AUTO_ASSIGN_MMC_PLAN = "NYHX:31143 : EE. User not found when searching plans. User Id or Account Id : {} ";
	
	public static final String LOG_ERROR_EE_ENROLLMENT_CANCELLED_ENRL_CANNOT_BE_CANCELLED_AGAIN = "NYHX:30060 : Cancelled Enrollment cannot be cancelled again. For Application Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_CANCELLED_ENRL_CANNOT_BE_CANCELLED = "NYHX:30061 : Last submitted application is already cancelled. App Cannot be cancelled again. For User Id {} ";

	public static final String LOG_ERROR_EE_AUTO_DISENROLL_ENRL_MEMBER_LIST_EMPTY = "NYHX:30062 : Auto Disenrollment Member List is Empty. User Id {}, Eligibility Id {} ";
	public static final String LOG_ERROR_EE_AUTO_DISENROLL_PREV_APPLICATION_NOT_AVIALABLE = "NYHX:30063 : Auto Disenrollment Previous Application does not exist. User Id {}, Eligibility Id {} ";
	public static final String LOG_ERROR_EE_APPLICATION_OBJECT_IS_CANCELLED = "NYHX:30064 : Auto Disenrollment Previous Application is already cancelled. User Id {}, Eligibility Id {} ";
	public static final String LOG_ERROR_EE_AUTO_DISENROLLMENT_MEMBER_LIST_LACK_MEMBERS = "NYHX:30065: Auto Disenrollment Group Disenrollment not possible since Disenrollment Member List does not contain all members. Subscriber Id {}, User Id {}, Eligibility Id {} ";
	public static final String LOG_ERROR_EE_AUTO_DISENROLLMENT_NON_SUBSCRIBER_RESTRICTION = "NYHX:30066: Auto Disenrollment Group Disenrollment not possible for APTC/APTC Premium Pay/CSR group since disenrolled member is not a subscriber. Subscriber Id {}, User Id {}, Eligibility Id {} ";
	public static final String LOG_ERROR_BATCH_AUTO_DISENROLLMENT_834_MSG_POST_FAILED = "NYHX:30067: Auto Disenrollment's 834 Message Posting is failed. Status Marked as failed in Auto Enrollment Queue. User Id {}, Eligibility Id {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_ENRL_CANNOT_BE_CANCELLED = "NYHX:30068 : Employee cannot remove the plan from individual code logic. App Cannot be cancelled . For User Id {} ";
	public static final String LOG_ERROR_EE_AUTO_DISENROLL_PLAN_DISENROLL_REASON_LIST_EMPTY = "NYHX:30200 : Auto Disenrollment Plan Disenroll List is Empty. Enrollment Id {}, NyhxMember Id {}, Plan Id {} ";
	public static final String LOG_ERROR_EE_AUTO_QUEUE_REASON_LIST_EMPTY = "NYHX:30201 : Auto enrollment Plan reasons List is Empty. Enrollment Id {}, NyhxMember Id {}, Plan Id {} ";
	public static final String LOG_ERROR_EE_AUTO_QUEUE_PLAN_ASSIGNMENT_NO_GROUP_EXISTS = "NYHX:30203 : Auto Enrollment Processing. No group exists where person and program exists. NyhxMember Id {}, Program Id {} ";
	public static final String LOG_ERROR_EE_AUTO_QUEUE_PLAN_ASSIGNMENT_MULTIPLE_GROUP_EXISTS = "NYHX:30204 : Auto Enrollment Processing. Multiple group exists for same member. NyhxMember Id {} ";
	public static final String LOG_ERROR_EE_AUTO_QUEUE_PLAN_ASSIGNMENT_NO_MEMBER_EXISTS = "NYHX:30205 : Auto Enrollment Processing. No Member exists in Application Group. NyhxMember Id {} ";
	public static final String LOG_ERROR_EE_AUTO_QUEUE_PLAN_ASSIGNMENT_NO_MEMBER_RESULT_EXISTS = "NYHX:30206 : Auto Enrollment Processing. No Member ELigibility Result. NyhxMember Id {} ";
	public static final String LOG_ERROR_EE_AUTO_QUEUE_PLAN_ASSIGNMENT_NO_MEMBER_ELG_START_DATE = "NYHX:30207 : Auto Enrollment Processing. No Member Eligibility Start date. NyhxMember Id {} ";
	

	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_CURRENT_IN_PROGRESS_ID_NULL = "NYHX:30301 : Multiple Enrollment Txn : Current IN_PROGRESS Enrollment id is null. EnrollmentMultipleTxnId{}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_CURRENT_IN_PROGRESS_ENRL_GET_ERROR = "NYHX:30302 : Multiple Enrollment Txn : Error while retrieving Current IN_PROGRESS Enrollment. EnrollmentMultipleTxnId{}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_CURRENT_IN_PROGRESS_ENRL_NULL = "NYHX:30303 : Multiple Enrollment Txn : Current IN_PROGRESS Enrollment is null. EnrollmentMultipleTxnId{}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_CURRENT_IN_PROGRESS_ENRL_NOT_IN_PROG = "NYHX:30304 : Multiple Enrollment Txn : Current Enrollment is not IN_PROGRESS. EnrollmentMultipleTxnId{}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_MAX_NUMBER_OF_ENRL_REACHED = "NYHX:30305 : Multiple Enrollment Txn : Maximum Number of Enrollment Reached. EnrollmentMultipleTxnId{}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_NO_POLICY = "NYHX:30306 : Multiple Enrollment Txn : . EnrollmentMultipleTxnId{}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_NO_POLICY_WITH_MULTI_TXN = "NYHX:30307 : Multiple Enrollment Txn : No Policy with Multiple Txns. EnrollmentMultipleTxnId{}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_NO_POLICY_WITH_PENDING_EVENT = "NYHX:30308 : Multiple Enrollment Txn : No Policy with Multiple Txns. EnrollmentMultipleTxnId{}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_MAPPER_EXCEPTION_1 = "NYHX:30309 : Multiple Enrollment Txn : Exception in enrollmentMultipleTxnServiceMapper.populateDTO. EnrollmentMultipleTxnId{}, Account Id {}, key{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_MIN_DATE_IS_NULL = "NYHX:30310 : Multiple Enrollment Txn : Minimum Date for Multiple Transaction is null. EnrollmentMultipleTxnId{}, Account Id {}, key{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_EVENT_LIST_DTO_IS_EMPTY = "NYHX:30311 : Multiple Enrollment Txn : Event DTO List for a date is empty. EnrollmentMultipleTxnId{}, Account Id {}, key{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_APP_GET_ERROR = "NYHX:30312 : Multiple Enrollment Txn : Error while retrieving application. EnrollmentMultipleTxnId{}, Account Id {}, key{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_IN_PROG_APP_UPDT_ERR = "NYHX:30313 : Multiple Enrollment Txn : Error while updating IN_PROGRESS application to ABANDONED. EnrollmentMultipleTxnId{}, Account Id {}, key{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_APP_PROC_NAME_ENUM_NOT_AVAIL = "NYHX:30314 : Multiple Enrollment Txn : Application Process Type Enum is not found. EnrollmentMultipleTxnId{}, Account Id {}, Enumstring{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_POLICY_NOT_FOUND = "NYHX:30315 : Multiple Enrollment Txn : No policy found. Account Id {}, Policy Key {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_MEMBER_NOT_FOUND = "NYHX:30316 : Multiple Enrollment Txn : Member Not found. Account Id {}, Policy Key {}, NyhxMemberId {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_MULTIPLE_POLICY_FOUND = "NYHX:30317 : Multiple Enrollment Txn : More than one Policy record found. Account Id {}, Policy Key {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_MEMBER_EXISTS_WITH_SAME_PLAN_DIFF_SUB = "NYHX:30318 : Multiple Enrollment Txn : Same plan exists for same member but with different subscriber. Account Id {}, Policy Key {}, NYHX Member Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_NO_SUB_PROG_BUT_SUBSIDY_UPD_EVENT = "NYHX:30319 : Multiple Enrollment Txn : Program cannot have subsidy. Account Id {}, Policy Key {}, NYHX Member Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_DIFF_POLICY_FOR_SUBSIDY_UPD = "NYHX:30320 : Multiple Enrollment Txn : Different Policy (Subsiciber not matched) for Subsidy Update. Account Id {}, Policy Key {}, NYHX Member Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_NEW_MEMBER_FOR_SUBSIDY_UPD = "NYHX:30321 : Multiple Enrollment Txn : Member does not exists for Subsidy Update. Account Id {}, Policy Key {}, NYHX Member Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_PLAN_NOT_EXISTS_FOR_SUBSIDY_UPD = "NYHX:30322 : Multiple Enrollment Txn : Member does not have same plan for Subsidy Update. Account Id {}, Policy Key {}, NYHX Member Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_POLICY_EXISTS_BUT_WITH_DIFF_ST_DT = "NYHX:30323 : Multiple Enrollment Txn : Policy Exists but subscriber has different coverage start date. Account Id {}, Policy Key {}, NYHX Member Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_POLICY_ELIG_MEMBER_NOT_FOUND = "NYHX:30324 : Multiple Enrollment Txn : Policy member's eligibility member not found. Account Id {}, Policy Key {}";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_SUBSCRIBER_COUNTY_NOT_FOUND = "NYHX:30325 : Multiple Enrollment Txn : Subscriber County is not found. Account Id {}, Policy Key {}";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_APPLICATION_NOT_FOUND = "NYHX:30326 : Multiple Enrollment Txn : Application not found. Account Id {}, Policy Key {}";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_MAX_APTC_ERR = "NYHX:30327 : Multiple Enrollment Txn : Error while calculating max allowed APTC. Account Id {}, Policy Key {}";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_APPLICATION_ADJUSTMENT_ERR = "NYHX:30328 : Multiple Enrollment Txn : Error while adjusting Application. Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_POST_ENRL_ERR = "NYHX:30329 : Multiple Enrollment Txn : Error enrollmentMessageService.postEnrollmentMessage. Account Id {}, enrollmentMultipleTxn{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_APPLICATION_SEARCH_ERR = "NYHX:30330 : Multiple Enrollment Txn : Error while search application . Multi Txn Id {}, Account Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_ERROR_ADJUST_APP = "NYHX:30331 : Multiple Enrollment Txn : Error while adjusting application. Account Id {}, multiTxnApplicationOrg Id {} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_POST_FAILED = "NYHX:30332 : Multiple Enrollment Txn : Post Application Failed. Account Id {}, multiTxn Id {}, In Progess App Id{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_POST_ERROR = "NYHX:30333 : Multiple Enrollment Txn : Post Application Error. Account Id {}, multiTxn Id {}, In Progess App Id{} ";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_APP_GET_ERROR_2 = "NYHX:30313 : Multiple Enrollment Txn : Error while retrieving application. EnrollmentMultipleTxnId{}, Account Id {}";
	public static final String LOG_ERROR_EE_ENRL_MULTI_TXN_AUTO_UPDATE_PREV_APPLICATION_NOT_AVIALABLE = "NYHX:30314 : Multiple Enrollment Txn : Error while retrieving plan from previous application. Application Id {}";

	public static final String LOG_ERROR_BATCH_NO_FETCH_COUNT = "NYHX:30100 : No fetch count for job: {} ";
	public static final String LOG_ERROR_BATCH_NO_CONTEXT_FILE = "NYHX:30101 : No context file found for job: {} ";
	public static final String LOG_ERROR_BATCH_NO_JOB_PROCESSOR = "NYHX:30102 : No processor found for job: {} ";
	public static final String LOG_ERROR_BATCH_INVALID_QUERY = "NYHX:30103 : Invalid query type specified for job: {} ";
	public static final String LOG_ERROR_BATCH_JOB_WORKER = "NYHX:30104: Error Occured during processing for job {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_YEAR = "NYHX:30105 : Error while retriving the enrollment year ";
	public static final String LOG_ERROR_BATCH_VLPRC_INVALID_INPUT = "NYHX:30106: Invalid input record fetched for VLPRC {}";
	public static final String LOG_ERROR_EE_ENROLLMENT_CIN_MULTIPLE_ACTIVE_ENROLLMENTS = "NYHX:30107 : Multiple active enrollment found for CIN : {} ";
	public static final String LOG_ERROR_BATCH_OPT_LOCK_REATTEMP_LIMIT_REACHED = "NYHX:30108 : Exceeding Optimistric Lock EXception's reattempt counter limit hit.";
	public static final String LOG_ERROR_BATCH_OPT_LOCK_FOUND_001 = "NYHX:30109 : Optimistric Lock found. Error Code - 001. Reason : ";
	public static final String LOG_ERROR_BATCH_OPT_LOCK_FOUND_002 = "NYHX:30110 : Optimistric Lock found. Error Code - 002. Reason : ";
	public static final String LOG_ERROR_BATCH_OPT_LOCK_FOUND_003 = "NYHX:30111 : Optimistric Lock found. Error Code - 003. Reason : ";

	public static final String LOG_ERROR_TPLREE_SERVICE = "NYHX:30051 : Error Occured while calling TPLREE Service for eligibility {} ";
	public static final String LOG_ERROR_ELIG_DETER_ABANDONE_APP_ERR = "NYHX:30052 : Error Occured while marking in progress enrollment (applications) as abandon. User ID {}, Elig ID {} ";
	public static final String LOG_ERROR_ENROLLMENT_ABANDON_SYTEM_EVENT_PROC = "NYHX:30094 : Error Occured while marking in progress enrollment (applications) as abandon from system_event_processor. User ID {} ";
	public static final String LOG_ERROR_EE_ELIGIBILITY_ZERO_FPL = "NYHX:30056 : Zero or negative fpl found. For User Id {} ";

	public static final String LOG_ERROR_BATCH_VERIFICATION_IST = "NYHX:30057: Error occured during verification of Immigration Status Veteran for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_RSRLP = "NYHX:30058: Error occured during verification of Res SPL Rule Legal Perm for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_RSRWD = "NYHX:30059: Error occured during verification of Res SPL Rule Work Docs for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_RSRCSE = "NYHX:30060: Error occured during verification of Res SPL Rule Child Scl Enrl for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_RSRHO = "NYHX:30061: Error occured during verification of Res SPL Rule Home Owner for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_RSRHR = "NYHX:30062: Error occured during verification of Res SPL Rule Home Rental for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_SAP = "NYHX:30063: Error occured during verification of Res SPL Rule Absent Parent for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_ITPL = "NYHX:30064: Error occured during verification of TPL for member {}";
	public static final String LOG_ERROR_BATCH_VERIFICATION_RETRO = "NYHX:30076: Error occured during verification of Retro for member {}";

	public static final String LOG_ERROR_MEMBER_HXID_EMPTY = "NYHX:30065: Missing Member HXID {}";

	public static final String LOG_ERROR_EE_MEMBER_LIST_IS_EMPTY = "NYHX:30066 : Member List is empty.";

	// Error codes for Event Transaction Logging
	public static final String LOG_ERROR_EVENTLOGGER_ACCTID_MISSING = "NYHX:30067 : Account Id is missing or empty.";
	public static final String LOG_ERROR_EVENTLOGGER_EVT_ENTITY_NAME_MISSING = "NYHX:30068 : EvtEntityName field is missing or empty.";
	public static final String LOG_ERROR_EVENTLOGGER_EVT_BASE_EVENT_NAME_MISSING = "NYHX:30069 : EvtBaseEventName field is missing or empty.";
	public static final String LOG_ERROR_EVENTLOGGER_EVT_EVENT_NAME_MISSING = "NYHX:30070 : EvtEventName field is missing or empty.";
	public static final String LOG_ERROR_EVENTLOGGER_INVALID_PROCESSOR = "NYHX:30071 : Invalid EventsLoggingProcessor name provided to factory.";
	public static final String LOG_ERROR_EVENTLOGGER_SESSIONID_MISSING = "NYHX:30072 : Session Id is missing or empty.";
	public static final String LOG_ERROR_EVENTLOGGER_LOGINID_MISSING = "NYHX:30073 : Login Id is missing or empty.";
	public static final String LOG_ERROR_EVENTLOGGER_EVT_REFERENCE_TYPE_MISSING = "NYHX:30074 : Reference Type is missing or empty.";

	public static final String LOG_ERROR_NEWBORN_BATCH_UNPROCESSED_NB = "NYHX:30067 : New born unprocessed after processing is done {}";
	public static final String LOG_ERROR_NEWBORN_BATCH_NB_REL_MISSING = "NYHX:30068 : Relationship is missing {}";
	public static final String LOG_ERROR_NEWBORN_BATCH_NB_ERROR = "NYHX:30069 : Error received while processing Newborn record {}";
	public static final String LOG_ERROR_NEWBORN_BATCH_INVALID_NBCOUNT = "NYHX:30070 : Invalid count for the number of Newborns {}";
	public static final String LOG_ERROR_NEWBORN_BATCH_MULTIPLE_CIN_RECORD = "NYHX:30071 : Multiple records found in CIN Master for cin {}";
	public static final String LOG_ERROR_NEWBORN_BATCH_MULTIPLE_INPROGRESS_ELIGIBILITY = "NYHX:30076 : Multiple InProgress eligibility found {}";

	public static final String LOG_ERROR_FCDISENROLL_MULTIPLE_CIN_RECORD = "NYHX:30072 : Multiple records found in CIN Master for cin {}";
	public static final String LOG_ERROR_FCDISENROLL_NO_HIXID = "NYHX:30073 : No Hixid found for cin {}";
	public static final String LOG_ERROR_FCDISENROLL_FAILED = "NYHX:30074 : Failed while processing the forced closure disenroll {}";
	public static final String LOG_ERROR_FCDISENROLL_NO_CATEGORY = "NYHX:30075 : Could not determine category code for cin {}";
	
	public static final String LOG_ERROR_EMEDNY_FCDISENROLL_MULTIPLE_CIN_RECORD = "NYHX:30072 : eMedNY FC - Multiple records found in CIN Master for cin {}";
	public static final String LOG_ERROR_EMEDNY_FCDISENROLL_NO_HIXID = "NYHX:30073 : eMedNY FC - No Hixid found for cin {}";
	public static final String LOG_ERROR_EMEDNY_FCDISENROLL_FAILED = "NYHX:30074 : eMedNY FC - Failed while processing the forced closure disenroll {}";
	public static final String LOG_ERROR_EMEDNY_FCDISENROLL_NO_CATEGORY = "NYHX:30075 : eMedNY FC - Could not determine category code for cin {}";
	public static final String LOG_ERROR_EMEDNY_FCDISENROLL_NO_DISTRICT = "NYHX:30075 : could not determine District ";
	public static final String LOG_ERROR_EMEDNY_FCDISENROLL_NO_MADATE = "NYHX:30075 : Exclusion District or MA Dates missing in properties file ";
	
	public static final String LOG_ERROR_EE_CBIC_NULL_APPLICATION = "NYHX:40000 : Application null for Id {}";
	public static final String LOG_ERROR_EE_CBIC_NULL_ELG_MEMBER = "NYHX:40001 : Eligibility Member null for hixid {}";
	public static final String LOG_ERROR_EE_CBIC_NULL_USERPROFILE = "NYHX:40002 : Userprofile null for eligibility id {}";
	public static final String LOG_ERROR_EE_CBIC_INVALID_DATA = "NYHX:40003 : Invalid or Missing data hixid {}";

	public static final String LOG_ERROR_EE_EVENT_REQUEST_ELIGIBILITY_ID = "NYHX:50001 : Invalid or Missing data for eligibility_id: {}";
	public static final String LOG_ERROR_EE_EVENT_REQUEST_ID = "NYHX:50002 : Invalid or Missing data :: ";
	public static final String LOG_ERROR_EE_EVENT_REQUEST_EVENT_ID = "NYHX:50003 : Invalid or Missing data for event_request_id: {}";

	public static final String LOG_ERROR_EE_RESEND_834_INFO_CANNOT_BE_FOUND = "NYHX:60004 : Error in fetching EDI 834 Transaction Info for Transaction Id  {} ";

	public static final String LOG_ERROR_INCARCERATION_PROCESS_STATUS_DOCCSTYPE_MISSING = "NYHX:60100 : Invalid or missing doccs_type: {}";
	public static final String LOG_ERROR_INCARCERATION_PROCESS_STATUS_DIN_MISSING = "NYHX:60101 : Invalid or missing din value: {}";

	public static final String LOG_ERROR_SYSTEMEVENT_NYHXID_MISSING = "NYHX:60102 : System Events - Nyhx Id missing: {}";
	public static final String LOG_ERROR_SYSTEMEVENT_ACCOUNTID_MISSING = "NYHX:60103 : System Events - Account Id missing: {}";
	public static final String LOG_ERROR_SYSTEMEVENT_EVENTTYPE_MISSING = "NYHX:60104 : System Events - Event Type missing: {}";
	public static final String LOG_ERROR_SYSTEMEVENT_EVENTNAME_MISSING = "NYHX:60105 : System Events - Event Name missing: {}";

	public static final String LOG_ERROR_BATCH_SYSTEM_EVENT_PROCESSING = "NYHX:60200 : System Events - Error processing System Events: {}";

	public static final String LOG_ERROR_RRV_ACCOUNTID_MISSING = "NYHX:60300 : EE Renewals Verification - Account Id missing: {}";
	public static final String LOG_ERROR_RRV_ELIGIBILITYID_MISSING = "NYHX:60301 : EE Renewals Verification - Eligibility Id missing: {}";

	public static final String LOG_ERROR_RRV_CREATE_NYHX_REQUEST_DTL_ERROR = "NYHX:60302 : RRV Services - Error creating RRV_NYHX_REQUEST_DETAIL record: {}";
	public static final String LOG_ERROR_RRV_SERVICE_ERROR = "NYHX:60303 : RRV Services - Error invoking rrv services: {}";

	public static final String LOG_ERROR_EE_REINSTATEMENT_COVERAGE_END_DATES_DIFFERENT = "NYHX:60400 : Coverage End Dates selected for Reinstated Member is invalid. Enrollment Id, Subscriber Id, Plan Id, Coverage End Date : {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_COVERAGE_START_DATE_NOT_IN_BETWEEN_DATES = "NYHX:60401 : Reinstatement Coverage Start Date is not in between Plan Coverage Start Date and Plan Coverage End Date. Enrollment Id, Subscriber Id, Plan Id, Coverage Start Date, Coverage End Date : {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_RELATIONSHIP_SELECTED_WITHOUT_MEMBER_SELECTION = "NYHX:60402 : Relationship with subscriber is selected without reinstated member being selected. Enrollment Id, Subscriber Id, Relationship : {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_RELATIONSHIP_NOT_SELECTED_FOR_MEMBER = "NYHX:60403 : Relationship with subscriber is not selected for reinstated member. Enrollment Id, Subscriber Id, Relationship, First Name, Last Name : {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_TERMINATED_PLANS_RECIEVED_EMPTY = "NYHX:60405 : Terminated Plans list is empty. Terminated Enrollment Id, Subscriber Id : {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_MEMBER_NOT_SELECTED = "NYHX:60407 : No member selected for adding in plan.{} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_MEMBER_AGE_OUT = " Newly added dependent in the plan is aging out before their coverage end date.";
	public static final String LOG_ERROR_EE_REINSTATEMENT_MEMBER_UNDER_19_AGE_CANNOT_ADDED_IN_APTC = " A new member, less than 19 years of age, cannot be added into an APTC/APTC CSR terminated plan.";
	public static final String LOG_ERROR_EE_REINSTATEMENT_MEMBER_AGE_OUT_DENTAL = " In QHP Dental only plan, a newly added member should not age out before their coverage end date.";
	public static final String LOG_ERROR_EE_CHANGE_REINSTATEMENT_MEMBER_AGE_OUT_DENTAL = "In QHP Dental only plan, any of dependents on the plan should not age out prior to end date you have selected.";
	public static final String LOG_ERROR_EE_REINSTATEMENT_PLAN_NOT_AVAILABLE = " Plan is not available during this coverage period.";
	public static final String LOG_ERROR_EE_REINSTATEMENT_NOT_DEPENDENT = " RelationShip with Subscriber is not possible, Newly added member is not a dependent.";

	public static final String LOG_ERROR_EE_MEMBER_NOT_ISURABLE_RELATIONSHIP_WITH_SUBSCRIBER = "NYHX:60404 : Reinstated Member does not have insurable relationship with subscriber. Enrollment Id, Subscriber Id, Relationship, First Name, Last Name : {} ";
	public static final String LOG_ERROR_EE_CIN_ELEMENT_FAULT = "NYHX:60405 :  Marshalling Exception from CIN Service {}";
	public static final String LOG_ERROR_EE_MEMBER_APTC_INVALID_FPL = "NYHX:60406 : Fpl Percentage not found For APTC {}";

	// Error code renewal related
	public static final String LOG_ERROR_EE_RENEWAL_MISSING_RENEWAL_CONFIG = "NYHX:70011 : Missing RenewalConfig or RenewalConfig is null";
	public static final String LOG_ERROR_EE_RENEWAL_MASTER = "NYHX:70012 : Missing RenewalMASTER or RenewalMASTER is null";
	public static final String LOG_ERROR_EE_RENEWAL_MULTIPLE_RENEWAL_CONFIG = "NYHX:70013 : Multiple or No RenewalConfig found when expected is single item";
	public static final String LOG_ERROR_EE_RENEWAL_NO_EVENT_NAME = "NYHX:70014 : NO_RENWAL_EVENT_NAME_FOUND";
	public static final String LOG_ERROR_EE_RENEWAL_MULTIPLE_RENEWAL_STATES_RULES = "NYHX:70015 : Multiple or No RenewalStatesRule found when expected is single item";
	public static final String LOG_ERROR_EE_RENEWAL_MISSING_RENEWAL_ACCOUNT_DTO = "NYHX:70016 : No renewal account dto {} ";
	public static final String LOG_ERROR_EE_RENEWAL_MANUAL_NOTICE_TRIGGER = "NYHX:70017 : Error triggering manual renewal notice {} ";

	public static final String LOG_ERROR_EE_ELIGIBILITY_PROPOSED_APTC_AMOUNT_CALCULATION = "NYHX:70018 : Error Calculating aptc amount for proposed eligibility {} ";

	public static final String LOG_ERROR_EE_REINSTATEMENT_NO_ENROLLMENT_EXISTS_WITH_TERMINATION = "NYHX:70050 : No enrollment with terminations exists for User Profile {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_EMPTY_REINSTATABLE_MEMBERS_LIST = "NYHX:70051 : Reinstatable Members list is Empty {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_REINSTATEMENT_EXECUTION_EXCEPTION = "NYHX:70052 : EE. Exception while processing reinstatement : {} ";
	public static final String LOG_ERROR_EE_ENROLLMENT_REINSTATEMENT_GROUP_FORMATION_EXCEPTION = "NYHX:70053 : EE. Exception while processing reinstatement during Group formation : {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_PLANS_LIST_EMPTY = "NYHX:70054 : Reinstatements Plans list empty for Enrollment and Subscriber Id {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_PLAN_DETAILS_EMPTY = "NYHX:70055 : Reinstatements Plan Details list empty for Enrollment Id and Subscriber Id {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_PLAN_MEMBERS_LIST_EMPTY = "NYHX:70056 : Reinstatements Plan Members list empty for Enrollment Id and Subscriber Id {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_ELIGIBILITY_LIST_EMPTY_FOR_NYHX_ID = "NYHX:70057 : No Eligibility found associated to Member NyHxMember Id while processing reinstatements for Enrollment Id and Subscriber Id {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_ENROLLMENT_GROUP_NOT_AVAILABLE = "NYHX:70058 : No Enrollment Group available for corresponding Group Id {} ";
	public static final String LOG_ERROR_EE_REINSTATEMENT_FETCH_TERMINATION_DATA_FAILURE = "NYHX:70059 : Error in fetching Enrollment Id and Subscriber Id for User Profile Id  {} ";

	public static final String LOG_ERROR_EE_MEMBERCOUNT_MISMATCH = "NYHX:80001 : Request from Issuer doesn't have all the members in the Enrollment Plan  {} ";
	public static final String LOG_ERROR_EE_MULTI_ENRL_EVENT_FUNCTION_FAILED = "NYHX:80002 : Multi Enrollment Eevent Generation Function Failed. Exception detail : {} ";
	public static final String LOG_ERROR_EE_MULTI_ENRL_EVENT_POLICIES_NOTEXIST = "NYHX:80003 : Multi Enrollment Eevent Generation, Policies not exist : {} ";
	public static final String LOG_ERROR_EE_MULTI_ENRL_EVENT_TXN_NOTEXIST = "NYHX:80003 : Multi Enrollment Eevent Generation, Multi Enrollment Txn not exist : {} ";

	public static final String LOG_ERROR_EE_START_DT_GREATERTHAN_END_DATE = "NYHX:80002 : Eligibility Start Date is greater than End Date  {} ";
	
	public static final String LOG_ERROR_EPP_GENERATION = "NYHX:30077: Error occured while generating EPP Number";

	// Error message for Program conversion Batch Process
	public static final String LOG_ERROR_BATCH_PGM_CONVERSION = "NYHX:30083: Error Occured while fetching data from Program Conversion Query";
	
	public static final String LOG_ERROR_EE_USER_OPT_OUT_OF_AUTO_ENRL_PROCEED_WITH_PLAN_SELECTION = "User_Who_Opted_Out_Of_AutoEnrollment_Proceeded_With_Plan_Selection";
	public static final String LOG_ERROR_WMS_MIGRATION_INVITATION_CODE_IS_MISSING = "NYHX:9001: Error occured while generating notice for shell account. OriginalErrorMsg: Invitation code is missing";
	
	public static final String LOG_ERROR_MNT_NYHX_MEMBER_ID = "NYHX:90001: Tracker NYHX member id is null or Empty.";
	public static final String LOG_ERROR_MNT_ACCOUNT_ID = "NYHX:90002: Tracker Account Id is null or Empty.";
	public static final String LOG_ERROR_MNT_ACTIVE_IND = "NYHX:90003: Tracker Active Ind is null or Empty.";
	public static final String LOG_ERROR_MNT_CATEGORY_CD = "NYHX:90004: Tracker Category Code is null or Empty.";
	public static final String LOG_ERROR_MNT_RUN_FOR_DATE = "NYHX:90005: Tracker Member Run For Date is null or Invalid.";
	public static final String LOG_ERROR_MNT_NOTIFICATION_START_DATE = "NYHX:90006: Tracker Notification Start Date is null or Invalid.";
	public static final String LOG_ERROR_MNT_NOTIFICATION_END_DATE = "NYHX:90007: Tracker Notification End Date is null or Invalid.";
	public static final String LOG_ERROR_COMPOSITION_NOT_FOUND = "NYHX:90008: SubsidizedMemberComposition not found";
	
	//Defect 54641 - start
	public final static String LOG_ERROR_BO_OVERRIDE_ENRL_STATUS_OBSOLETE = "NYSOH:00001: Enrollment Status of Previous Enrollment is already OBSOLETE.";
	//Defect 54641 - end	
	// CR#544 - issuer reinstate
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_EXCEPTION = "NYHX:60600 : Exception received while processing...";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_NO_SUBMITTED_ENROLLMENT = "NYHX:60601 : No SUBMITTED enrollment for given account.";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_NO_USER_PROFILE = "NYHX:60602 : No user profile found for given account id.";
	public static final String NYHX_WS_REINSTATE_MEMBER_ENRL_834_RESPONSE_ELIGIBILITY_VALIDATION_EXCEPTION = "NYHX:60603 : Exception received while processing Eligibility Validation...";
	//CR1132
	public static final String LOG_ERROR_TENDAY_NOTICE_RULE_DAYS_NOT_FOUND = "NYHX:60604 : TENDAY_NOTICE_RULE_DAYS not found in config tables";
	
	// Defect : 55519
		public static final String LOG_ERROR_ELG_NOT_FOUND = "NYHX:99021: Eligibility/Enrollment not found or not in appropriate status to process BROKER_CHANGE for Account {}";
		public static final String LOG_ERROR_INSUFFICIENT_DATA = "NYHX:99022: Unable to process with BROKER_CHANGE due to improper data found for Account {}";
				
	//CR# 1361
	public static final String LOG_ERROR_NYSHIP_SERVICE = "NYHX:50051 : Error Occured while calling NYSHIP Service for eligibility {} ";
	public static final String LOG_ERROR_EE_NYSHIP_SERVICE_FAULT = "NYHX:50052 : Fault received from NYSHIP service{}";
	public static final String LOG_ERROR_EE_NYSHIP_EXCEPTION_FAULT = "NYHX:50053 : Exception while calling NYSHIP service {}";
	public static final String LOG_ERROR_EE_NYSHIP_ELEMENT_FAULT = "NYHX:50054 :  Marshalling Exception from NYSHIP Service {}";
	public static final String LOG_ERROR_EE_NYSHIP_SOAP_FAULT = "NYHX:50055 :  SOAP Fault received from from NYSHIP Service {}";
	public static final String LOG_ERROR_EE_NYSHIP_INCORRECT_DOB = "NYHX:50056 : Incorrect Date of Birth {}";
	public static final String LOG_ERROR_EE_NYSHIP_INCORRECT_COVERAGE_START_DATE = "NYHX:50057 : Incorrect Coverage Start Date {}";
	public static final String LOG_ERROR_EE_NYSHIP_INCORRECT_COVERAGE_END_DATE = "NYHX:50058 : Incorrect Coverage End Date {}";
	public static final String LOG_ERROR_EE_NYSHIP_CONFIG_OBJECT_NOT_FOUND = "NYHX:50059 : Error Occured while accessing config object : config not found for config version {} ";
	public static final String LOG_ERROR_EE_NYSHIP_CO_UTILITY_FUNCTION_FAILED = "NYHX:50060 : Utility Function Failed. Exception detail : {} ";
	public static final String LOG_ERROR_EE_INVALID_DATA_ARGS = "NYHX:50061 : Either null arguments or invalid derived values";
	
	//CR 1753
	public static final String LOG_ERROR_EE_MISSING_CONFIG_BEAN = "NYHX:97001 : Missing Config bean or Config bean is null";
}