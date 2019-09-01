/*
 * New York Health eXchange - 2013
 */

package com.hcentive.utils.ext;

/**
 * Class to maintain identification of all the DIV  IDs  to handle all of the
 * errors (Due to data validation) to be displayed on Front end.
 * 
 */
public class HXErrMsgConstants {

	public static final int STREET_MAX_LENGTH = 55;
	public static final int APT_MAX_LENGTH = 5;
	public static final int CITY_MIN_LENGTH = 2;
	public static final int CITY_MAX_LENGTH = 30;
	public static final int STATE_LENGTH = 2;
	public static final int ZIP_LENGTH = 5;
	public static final int COUNTY_CODE_MAX_LENGTH = 5;
	public static final int FIRST_NAME_MAX_LENGTH = 25;
	public static final int MIDDLE_NAME_MAX_LENGTH = 25;
	public static final int LAST_NAME_MAX_LENGTH = 40;
	public static final int SUFFIX_MAX_LENGTH = 15;
	public static final int DOCUMENT_NUMBER_MAX_LENGTH = 15;
	public static final int FIRST_NAME_MAX_LENGTH_OTHER = 100;
	/* START - Forgot Password Constants */
	public static final int USER_NAME_MAX_LENGTH = 20;
	public static final int USER_NAME_MIN_LENGTH = 6;
	/* END - Forgot Password Constants */

	/* START - Forgot Username Constants */
	public static final int EMAIL_MAX_LENGTH = 100;
	public static final int EMAIL_MIN_LENGTH = 5;
	/* END - Forgot Username Constants */

	/* START - Security Questions Page Constants */
	public static final int SECRET_ANSWER_MAX_LENGTH = 30;
	public static final int SECRET_ANSWER_MIN_LENGTH = 2;
	/* END - Security Questions Page Constants */

	/* START - Create New Password Page Constants */
	public static final int RESET_PASSWORD_MAX_LENGTH = 16;
	public static final int RESET_PASSWORD_MIN_LENGTH = 8;
	/* END - Create New Password Page Constants */

	/* Partial key used for Household member. The other part is the member index */
	public static final String MEMBERS = "members";

	/* Partial key used for UIB. The other part is the member index */
	public static final String UIBBeans = "hxIncomeUIBBeanlst";
	
	/* Partial key used for UIB. The other part is the member index */
	public static final String TITLEIIBeans = "hxIncomeTitleIIBeanlst";
	
	/* Partial key used for Household member. The other part is the member index */
	public static final String MEMBER = "member";
	
	/* Error Messages for Basic Info */
	public static final String ERR_FIRSTNAME_REQUIRED = "err_firstName_required";
	public static final String ERR_FIRSTNAME_INVALID = "err_firstName_invalid";
	public static final String ERR_FIRSTNAME_LENGTH = "err_firstName_length";
	public static final String ERR_MIDDLENAME_LENGTH = "err_middleName_length";
	public static final String ERR_LASTNAME_LENGTH = "err_lastName_length";
	public static final String ERR_LASTNAME_REQUIRED = "err_lastName_required";
	public static final String ERR_LASTNAME_INVALID = "err_lastName_invalid";
	public static final String ERR_SUFFIX_REQUIRED = "err_suffix_required";
	public static final String ERR_SUFFIX_INVALID = "err_suffix_invalid";
	public static final String ERR_MIDDLENAME_INVALID = "err_middleName_invalid";
	public static final String ERR_GENDER_REQUIRED = "err_gender_required";
	public static final String ERR_APPLYING_REQUIRED = "err_applying_required";
	public static final String ERR_APPLYING_INSU_REQUIRED ="err_apply_insu_required";
	public static final String ERR_ONLY_ONE_ACCOUNT_CONTACT = "err_same_account_contact";
	public static final String ERR_AGREETERMS_REQUIRED = "err_agreeterms_required";
	public static final String ERR_DAILY_FEDHUB_ATTEMPT_REACHED = "err_daily_fedhub_attempt_reached";
	public static final String ERR_SSA_RESPONSE_FAILED = "err_ssa_response_failed";
	public static final String ERR_CALL_CUSTOMER_SERVICE = "err_call_customer_service";
	public static final String ERR_DECEASED_MEMBERS = "err_deceased_members";
	public static final String ERR_DECEASED_MEMBER  ="err_deceased_member";
	
	public static final String ERR_FED_HUB_FAILED ="err_fed_hub_failed";
	public static final String ERR_NYHX_ID_MORE_THAN_ONE_FOUND = "err_more_than_one_nyhxid_found";
	public static final String ERR_NYHX_ID_COULD_NOT_CREATE = "err_could_not_create_nyhx_id";

	// 2014-09-26 def: 26905 For validating when public_program=null
	public static final String ERR_PUBLICPROGRAM_REQUIRED = "publicProgramError";
	
	/* Error Messages for Additional Info */
	public static final String ERR_AMERICANINDIAN_REQUIRED = "err_americanIndian_required";
	public static final String ERR_TRIBE_REQUIRED = "err_tribe_required";
	public static final String ERR_PREGNANCY_STATUS_REQUIRED = "err_preg_required";
	public static final String ERR_NO_DUE_DATE = "err_duedate_required";
	public static final String ERR_DUE_DATE_INVALID = "err_duedate_invalid";
	public static final String ERR_DUE_DATE_RANGE = "err_duedate_range";
	public static final String ERR_STUDENT_STATUS_REQUIRED = "err_studentstatus_required";
	public static final String ERR_OTHERTRIBE_REQUIRED = "err_othertribe_required";
	public static final String ERR_TRIBE_INVALID = "err_tribe_invalid";
	public static final String ERR_IHSELIGIBLE_REQUIRED = "err_ihseligible_required";
	public static final String ERR_NURSINGHOME_REQUIRED = "err_nursinghome_required";
	public static final String ERR_BLIND_REQUIRED = "err_blind_required";
	public static final String ERR_CERTBLIND_REQUIRED = "err_certblind_required";
	public static final String ERR_DISABILITY_REQUIRED = "err_disability_required";
	public static final String ERR_DISABILITYCODE_REQUIRED = "err_disabilitycode_required";
	public static final String ERR_DISABLEDSERVICES_REQUIRED = "err_selectedDS_required";
	public static final String ERR_DISABLEDSERVICE_INVALID = "err_disabledservices_invalid";
	public static final String ERR_MBIWPDPROG_REQUIRED = "err_mbiwpdprog_required";
	public static final String ERR_PAYINGOFFMEDICALBILLS_REQUIRED = "err_payingOffMedicalBills_required";
	public static final String ERR_PAYINGOFFMEDICALBILLS_MORE_THAN_TWO_YRS = "err_payingOffMedicalBills_more_than_two_yrs";
	public static final String ERR_PAYINGOFFMEDICALBILLS_MORE_THAN_THREE_MON = "err_payingOffMedicalBills_more_than_three_mons";
	public static final String ERR_PAYINGOFFMEDICALBILLS_MONTH_SELEC_REQUIRED= "err_payingOffMedicalBills_month_selec_required";
	
	public static final String ERR_WASEVERINFOSTERCARE_REQUIRED = "err_wasEverInFosterCare_required";
	public static final String ERR_CURRENTLYINFOSTERCARE_REQUIRED = "err_currentlyInFosterCare_required";
	public static final String ERR_FOSTERCAREINSTATE_REQUIRED = "err_fosterCareInState_required";
	public static final String ERR_AGEWHENLEFTFOSTERCARE_REQUIRED = "err_ageWhenLeftFosterCare_required";
	public static final String ERR_FAMILY_PLANNING_BENEFIT_PROGRAM_REQUIRED = "err_family_Planning_Benefit_Program_required";

	/* Error Messages for Residency */
	public static final String ERR_MARITALSTATUS_REQUIRED = "err_maritalstatus_required";
	public static final String ERR_DOB_REQUIRED = "err_dob_required";
	public static final String ERR_DOB_INVALID = "err_dob_invalid";
	public static final String ERR_DOB_YEAR_INVALID = "err_dob_year_invalid";
	public static final String ERR_SSN_REQUIRED = "err_ssn_required";
	public static final String ERR_SSN_INVALID = "err_ssn_invalid";
	public static final String ERR_ITIN_INVALID = "err_itin_invalid";
	public static final String ERR_ITIN_DUPLICATE = "err_itin_duplicate";
	public static final String ERR_SSN_DUPLICATE = "err_ssn_duplicate";
	public static final String ERR_NOSSNREASON_REQUIRED = "err_nossnreason_required";
	public static final String ERR_NOTELIGIBLEFORSSN_REQUIRED = "err_noteligibleforssn_required";
	public static final String ERR_CITIZENSHIP_REQUIRED = "err_citizenship_required";
	public static final String ERR_DOCUMENTDETAIL_REQUIRED = "err_documentdetail_required";
	public static final String ERR_DOCUMENTNUMBER_REQUIRED = "err_documentnumber_required";
	public static final String ERR_DOCUMENTDATE_REQUIRED = "err_documentdate_required";
	public static final String ERR_DOCUMENTDATE_INVALID = "err_documentdate_invalid";
	public static final String ERR_DOCUMENTTYPE_REQUIRED = "err_documenttype_required";
	public static final String ERR_RACE_OTHER_REQUIRED = "err_race_other_required";
	public static final String ERR_RACE_OTHER_INVALID = "err_race_other_invalid";
	public static final String ERR_ETHNICITY_OTHER_REQUIRED = "err_ethnicity_other_required";
	public static final String ERR_ALIENNUMBER_REQUIRED = "err_aliennumber_required";
	public static final String ERR_ALIENNUMBER_INVALID	= "err_aliennumber_invalid";
	public static final String ERR_ALIENNUMBER_OR_I94_REQUIRED	= "err_aliennumberori94_required";
	public static final String ERR_RECEIPTNUMBER_REQUIRED = "err_receiptnumber_required";
	public static final String ERR_SEVISIDNUMBER_REQUIRED = "err_sevisidnumber_required";
	public static final String ERR_CITIZENSHIPCERTIFICATE_REQUIRED="err_citizenshipcertificate_required";
	public static final String ERR_ALIENNUMBEREXPIRATIONDATE_REQUIRED="err_aliennumberexpirydate_required";
	public static final String ERR_I94NUMBER_REQUIRED="err_i94number_required";
	public static final String ERR_I94NUMBER_INVALID ="err_i94number_invalid";
	public static final String ERR_FOREIGNPASSPORTNUMBER_REQUIRED="err_foreignpassportnumber_required";
	public static final String ERR_FOREIGNPASSPORTEXPIRATIONDATE_REQUIRED="err_foreignpassportexipirationdate_required";
	public static final String ERR_NATURALIZATIONCERTIFICATE_REQUIRED="err_naturalizationcertificate_required";
	public static final String ERR_DOCUMENTDESCRIPTION_REQUIRED="err_documentdescription_required";
	public static final String ERR_VISANUMBER_INVALID="err_visanumber_invalid";
	public static final String ERR_SEVISIDNUMBER_INVALID="err_sevisidnumber_invalid";
	public static final String ERR_RECEIPTNUMBER_INVALID="err_receiptnumber_invalid";
	public static final String ERR_FOREIGNPASSPORTNUMBER_INVALID="err_foreignpassportnumber_invalid";
	public static final String ERR_NATURALIZATIONNUMBER_INVALID="err_naturalizationnumber_invalid";
	public static final String ERR_CITIZENSHIPNUMBER_INVALID="err_citizenshipnumber_invalid";
	public static final String ERR_DOCUMENTDESCRIPTIONNUMBER_INVALID="err_documentdescription_invalid";
	public static final String ERR_PASSPORTCOUNTRYOFISSUANCE_REQUIRED="err_passportcountryofissuance_required";
	public static final String ERR_ALIENEXPIRATIONDATE_INVALID="err_alienexpirationdate_invalid";
	public static final String ERR_I94EXPIRATIONDATE_INVALID="err_i94expirationdate_invalid";
	public static final String ERR_FOREIGNPASSPORTEXPIRATIONDATE_INVALID="err_foreignpassportexpirationdate_invalid";
	public static final String ERR_DUPLICATE_DOCUMENTTYPE	= "err_duplicate_documenttype";
	public static final String ERR_FOREIGNPASSPORT_SPECIALCHARACTERS = "err_foreignpassportnumber_specialCharacters";

	/* Error Messages for Mailing/Additional Address */
	public static final String ERR_MAILING_STREET1_REQUIRED = "err_mailing_street1_required";
	public static final String ERR_MAILING_STREET1_INVALID_LENGTH = "err_mailing_street1_invalid_length";
	public static final String ERR_MAILING_STREET2_INVALID_LENGTH = "err_mailing_street2_invalid_length";
	public static final String ERR_MAILING_CITY_REQUIRED = "err_mailing_city_required";
	public static final String ERR_MAILING_CITY_INVALID_LENGTH = "err_mailing_city_invalid_length";
	public static final String ERR_MAILING_CITY_INVALID = "err_mailing_city_invalid";
	public static final String ERR_MAILING_ZIP_REQUIRED = "err_mailing_zip_required";
	public static final String ERR_MAILING_ZIP_INVALID = "err_mailing_zip_invalid";
	public static final String ERR_MAILING_ZIP_INVALID_LENGTH = "err_mailing_zip_invalid_length";
	public static final String ERR_MAILING_STATE_REQUIRED = "err_mailing_state_required";
	public static final String ERR_MAILING_STATE_INVALID = "err_mailing_state_invalid";
	public static final String ERR_MAILING_STATE_INVALID_LENGTH = "err_mailing_state_invalid_length";

	public static final String ERR_ADDITIONAL_MAIL_STREET1_REQUIRED = "err_additional_mail_street1_required";
	public static final String ERR_ADDITIONAL_MAIL_STREET1_INVALID_LENGTH = "err_additional_mail_street1_invalid_length";
	public static final String ERR_ADDITIONAL_MAIL_STREET2_INVALID_LENGTH = "err_additional_mail_street2_invalid_length";
	public static final String ERR_ADDITIONAL_MAIL_CITY_REQUIRED = "err_additional_mail_city_required";
	public static final String ERR_ADDITIONAL_MAIL_CITY_INVALID_LENGTH = "err_additional_mail_city_invalid_length";
	public static final String ERR_ADDITIONAL_MAIL_CITY_INVALID = "err_additional_mail_city_invalid";
	public static final String ERR_ADDITIONAL_MAIL_ZIP_REQUIRED = "err_additional_mail_zip_required";
	public static final String ERR_ADDITIONAL_MAIL_ZIP_INVALID = "err_additional_mail_zip_invalid";
	public static final String ERR_ADDITIONAL_MAIL_ZIP_INVALID_LENGTH = "err_additional_mail_zip_invalid_length";
	public static final String ERR_ADDITIONAL_MAIL_STATE_REQUIRED = "err_additional_mail_state_required";
	public static final String ERR_ADDITIONAL_MAIL_STATE_INVALID = "err_additional_mail_state_invalid";
	public static final String ERR_ADDITIONAL_MAIL_STATE_INVALID_LENGTH = "err_additional_mail_state_invalid_length";

	/* START - Error Messages for Residence Address */
	public static final String ERR_RES_STREET1_REQUIRED = "err_res_street1_required";
	public static final String ERR_RES_STREET1_LENGTH = "err_res_street1_length";
	public static final String ERR_RES_STREET1_INVALID = "err_res_street1_invalid";
	
	public static final String ERR_RES_APT_SUITE_LENGTH = "err_res_aptSuite_length";
	public static final String ERR_RES_APT_SUITE_INVALID = "err_res_aptSuite_invalid";
	
	public static final String ERR_RES_STREET2_LENGTH = "err_res_street2_length";
	public static final String ERR_RES_STREET2_INVALID = "err_res_street2_invalid";

	public static final String ERR_RES_CITY_REQUIRED = "err_res_city_required";
	public static final String ERR_RES_CITY_LENGTH = "err_res_city_length";
	public static final String ERR_RES_CITY_INVALID = "err_res_city_invalid";

	public static final String ERR_RES_COUNTY_REQUIRED = "err_res_county_required";
	public static final String ERR_RES_COUNTY_LENGTH = "err_res_county_length";
	public static final String ERR_MAIL_ADDRESS_OUT_NY = "err_mailing_address_out_NY";
	
	public static final String ERR_RES_ZIP_REQUIRED = "err_res_zip_required";
	public static final String ERR_RES_ZIP_INVALID = "err_res_zip_invalid";
	public static final String ERR_RES_ZIP_LENGTH = "err_res_zip_length";

	public static final String ERR_RES_STATE_REQUIRED = "err_res_state_required";
	public static final String ERR_RES_STATE_INVALID = "err_res_state_invalid";
	public static final String ERR_RES_STATE_LENGTH = "err_res_state_length";

	public static final String ERR_RES_ZIPCOUNTYSTATE_INVALID = "err_res_zipcountystate_invalid";

	public static final String ERR_LEG_STREET1_REQUIRED = "err_leg_street1_required";
	public static final String ERR_LEG_STREET1_LENGTH = "err_leg_street1_length";
	public static final String ERR_LEG_STREET1_INVALID = "err_leg_street1_invalid";
	
	public static final String ERR_LEG_APT_SUITE_LENGTH = "err_leg_aptSuite_length";
	public static final String ERR_LEG_APT_SUITE_INVALID = "err_leg_aptSuite_invalid";

	public static final String ERR_LEG_STREET2_LENGTH = "err_leg_street2_length";
	public static final String ERR_LEG_STREET2_INVALID = "err_leg_street2_invalid";

	public static final String ERR_LEG_CITY_REQUIRED = "err_leg_city_required";
	public static final String ERR_LEG_CITY_LENGTH = "err_leg_city_length";
	public static final String ERR_LEG_CITY_INVALID = "err_leg_city_invalid";

	public static final String ERR_LEG_COUNTY_REQUIRED = "err_leg_county_required";
	public static final String ERR_LEG_COUNTY_LENGTH = "err_leg_county_length";
	
	public static final String ERR_LEG_ZIP_REQUIRED = "err_leg_zip_required";
	public static final String ERR_LEG_ZIP_INVALID = "err_leg_zip_invalid";
	public static final String ERR_LEG_ZIP_LENGTH = "err_leg_zip_length";

	public static final String ERR_LEG_STATE_REQUIRED = "err_leg_state_required";
	public static final String ERR_LEG_STATE_INVALID = "err_leg_state_invalid";
	public static final String ERR_LEG_STATE_LENGTH = "err_leg_state_length";

	public static final String ERR_LEG_ZIPCOUNTYSTATE_INVALID = "err_leg_zipcountystate_invalid";
	
	public static final String ERR_ISRESIDENTIALSAMEFORALL_REQUIRED = "err_isresidentialsameforall_required";
	public static final String ERR_ISLEGALADDRESSFORALL_REQUIRED = "err_islegaladdressforall_required";

	public static final String ERR_RES_ISMOVINGTONYS_REQUIRED = "err_ismovingtonys_required";

	public static final String ERR_RES_EXPECTEDCOUNTYOFRES_REQUIRED = "err_expectedcountyofres_required";
	public static final String ERR_RES_EXPECTEDCOUNTYOFRES_LENGTH = "err_expectedcountyofres_length";

	public static final String ERR_RES_EXPECTEDMOVINGDATE_REQUIRED = "err_expectedmovingdate_required";
	public static final String ERR_RES_EXPECTEDMOVINGDATE_INVALID = "err_expectedmovingdate_invalid";
	public static final String ERR_RES_EXPECTEDMOVINGDATE_PAST = "err_expectedmovingdate_past";
	public static final String ERR_RES_EXPECTEDMOVINGDATE_FUTURE = "err_expectedmovingdate_future";

	public static final String ERR_RELATION_REQUIRED = "err_relation_required";
	public static final String ERR_CARETAKER_REQUIRED = "err_caretaker_required";
	public static final String ERR_CARETAKER_INVALID = "err_caretaker_invalid";
	public static final String ERR_MSG_DUPLICATE_NYHX_MBR_IDS = "err_msg_duplicate_nyhx_mbr_ids";
	
	public static final String ERR_RELATION_SPOUSE_COUNT = "err_relation_spouse_count";
	public static final String ERR_RELATION_NON_MARRIED_SPOUSE = "err_relation_non_married_spouse";
	public static final String ERR_RELATION_DOMESTIC_PARTNER_COUNT = "err_relation_domestic_partner_count";
	public static final String ERR_RELATION_DOMESTIC_PARTNER_AND_SPOUSE = "err_relation_domestic_partner_and_spouse";
	public static final String ERR_RELATION_PARENT_COUNT = "err_relation_parent_count";
	public static final String ERR_RELATION_GRANDPARENT_COUNT = "err_relation_grandparent_count";
	public static final String ERR_RELATION_GUARDIAN_COUNT = "err_relation_guardian_count";
	public static final String ERR_RELATION_MOTHER_FATHER_IN_LAW_GENDER_ERR = "err_relation_mother_father_in_law_gender_err";
	public static final String ERR_RELATION_NOT_POSSIBLE = "err_relation_not_possible";
	public static final String ERR_RELATION_OLDER = "err_relation_OLDER";
	public static final String ERR_RELATION_YOUNGER = "err_relation_YOUNGER";
	public static final String ERR_RELATION_STEPPARENT_NOT_SPOUSE_PARENT = "err_relation_STEPPARENT_NOT_SPOUSE_PARENT";
	public static final String ERR_RELATION_PARENT_NOT_SPOUSE_STEPPARENT = "err_relation_PARENT_NOT_SPOUSE_STEPPARENT";
	public static final String ERR_RELATION_NEWBORN_MOTHER_INVALID_PREGNANCY_DUEDATE = "err_mother_to_newborn_invalid_pregnancy_duedate";
	
	/* END - Error Messages for Residence Address */

	/* Error Messages for FED HUB Integration */
	public static final String ERR_FED_HUB_NOT_AVAILABLE = "err_fedhub_not_available";
	public static final String ERR_FED_HUB_TXN_ERROR = "err_fedhub_txn_error";
	public static final String ERR_FED_HUB_CITIZENSHIP_FAILED = "err_fedhub_citizenship_failed";
	public static final String ERR_FED_HUB_CIT_NOT_VERIFIED_DUE_TO_SSN_FAILURE = "err_fedhub_citizenship_not_verified_due_to_ssn";
	public static final String ERR_FED_HUB_INCR_VERIFIED = "err_fedhub_incr_verified";
	public static final String ERR_FED_HUB_INCR_NOT_VERIFIED_DUE_TO_SSN_FAILURE = "err_fedhub_incr_not_verified_due_to_ssn";
	public static final String ERR_FED_HUB_SSN_NOT_VERIFIED = "err_fedhub_ssn_not_verified";
	public static final String ERR_FED_HUB_SSN_NOT_VERIFIED_B = "err_fedhub_ssn_not_verified_b";
	public static final String ERR_FED_HUB_SSN_NOT_VERIFIED_C = "err_fedhub_ssn_not_verified_c";
	public static final String ERR_FED_HUB_SSN_NOT_VERIFIED_D = "err_fedhub_ssn_not_verified_d";
	public static final String ERR_FED_HUB_SSN_NOT_VERIFIED_E = "err_fedhub_ssn_not_verified_e";

	/* START - Error Messages for Forgot Password */
	public static final String ERR_USERNAME_REQUIRED = "err_username_required";
	public static final String ERR_USERNAME_INVALID = "err_username_invalid";
	public static final String ERR_USERNAME_LENGTH = "err_username_length";

	/* END - Error Messages for Forgot Password */

	/* START - Error Messages for Forgot Username */
	public static final String ERR_EMAIL_REQUIRED = "err_email_required";
	public static final String ERR_EMAIL_INVALID = "err_email_invalid";
	public static final String ERR_EMAIL_LENGTH = "err_email_length";
	public static final String ERR_EMAIL_NOTFOUND = "err_email_notfound";

	/* END - Error Messages for Forgot Username */

	/* Start - Error Messages for Contact Prefs */
	public static final String ERR_ALERT_REQUIRED = "err_alert_required";
	public static final String ERR_PHONE_CONTACT_REQUIRED = "err_phone_contact_required";
	public static final String ERR_SMSALERT_MOBILEPHONE_REQUIRED = "err_smsalert_mobilephone_required";
	public static final String ERR_EMAILALERT_EMAIL_REQUIRED = "err_emailalert_email_required";
	public static final String ERR_EMAILALERT_EMAIL_INVALID = "err_emailalert_email_invalid";
	/* END - Error Messages for Contact Prefs */

	/* START - Error Messages for Security Questions */
	public static final String ERR_SECURITYQUESTIONONE_REQUIRED = "err_securityQuestionOne_required";
	public static final String ERR_SECURITYQUESTIONONE_INVALID = "err_securityQuestionOne_invalid";
	public static final String ERR_SECURITYQUESTIONONE_LENGTH = "err_securityQuestionOne_length";

	public static final String ERR_SECURITYQUESTIONTWO_REQUIRED = "err_securityQuestionTwo_required";
	public static final String ERR_SECURITYQUESTIONTWO_INVALID = "err_securityQuestionTwo_invalid";
	public static final String ERR_SECURITYQUESTIONTWO_LENGTH = "err_securityQuestionTwo_length";
	public static final String ERR_SECURITYQUESTION_INVALID = "err_securityQuestion_invalid";
	public static final String ERR_SECURITYQUESTION_NO_SAME_ANSWERS = "err_securityQuestion_no_same_answers";
	/* END - Error Messages for Security Questions */

	// #################### Lini Account Creation Common messages

	public static final String ERR_ACCOUNT_USERNAME_REQUIRED = "err_account_username_required";
	public static final String ERR_ACCOUNT_USERNAME_INVALID = "err_account_username_invalid";
	public static final String ERR_ACCOUNT_USERNAME_LENGTH = "err_account_username_length";

	public static final String ERR_ACCOUNT_PASSWORD_REQUIRED = "err_account_password_required";
	public static final String ERR_ACCOUNT_PASSWORD_INVALID = "err_account_password_invalid";
	public static final String ERR_ACCOUNT_PASSWORD_LENGTH = "err_account_password_length";

	public static final String ERR_ACCOUNT_CONFIRMPASSWORD_REQUIRED = "err_account_confirmPassword_required";

	public static final String ERR_ACCOUNT_EMAIL_REQUIRED = "err_account_email_required";
	public static final String ERR_ACCOUNT_EMAIL_INVALID = "err_account_email_invalid";

	public static final String ERR_ACCOUNT_CONFIRMEMAIL_REQUIRED = "err_account_confirmEmail_required";

	public static final String ERR_ACCOUNT_CONFIRMEMAIL_MUST_MATCH = "err_account_confirmEmail_mustmatch";
	public static final String ERR_ACCOUNT_CONFIRMPASSWORD_MUST_MATCH = "err_account_confirmPassword_mustmatch";

	public static final String ERR_ACCOUNT_USERPROFILETERMSIND_REQUIRED = "err_account_userProfileTermsInd_required";

	public static final String ERR_ACCOUNT_SECU_QUESTION_1_REQUIRED = "err_account_secu_question_1_required";

	public static final String ERR_ACCOUNT_SECU_ANSWER_1_REQUIRED = "err_account_secu_answer_1_required";
	public static final String ERR_ACCOUNT_SECU_ANSWER_1_INVALID = "err_account_secu_answer_1_invalid";
	public static final String ERR_ACCOUNT_SECU_ANSWER_1_LENGTH = "err_account_secu_answer_1_length";

	public static final String ERR_ACCOUNT_SECU_QUESTION_2_REQUIRED = "err_account_secu_question_2_required";

	public static final String ERR_ACCOUNT_SECU_ANSWER_2_REQUIRED = "err_account_secu_answer_2_required";
	public static final String ERR_ACCOUNT_SECU_ANSWER_2_INVALID = "err_account_secu_answer_2_invalid";
	public static final String ERR_ACCOUNT_SECU_ANSWER_2_LENGTH = "err_account_secu_answer_2_length";

	public static final String ERR_ACCOUNT_SECU_QUESTION_3_REQUIRED = "err_account_secu_question_3_required";

	public static final String ERR_ACCOUNT_SECU_ANSWER_3_REQUIRED = "err_account_secu_answer_3_required";
	public static final String ERR_ACCOUNT_SECU_ANSWER_3_INVALID = "err_account_secu_answer_3_invalid";
	public static final String ERR_ACCOUNT_SECU_ANSWER_3_LENGTH = "err_account_secu_answer_3_length";

	public static final String ERR_ACCOUNT_SECU_QUESTIONS_DUPLICATE = "err_account_secu_questions_duplicate";
	public static final String ERR_ACCOUNT_SECU_ANSWERS_DUPLICATE = "err_account_secu_answers_duplicate";
	public static final String ERR_ACCOUNT_PASSWD_UNAME_EMAIL_DUPLICATE = "err_account_passwd_uname_email_duplicate";

	public static final String ERR_ACCOUNT_USERNAME_ALREADY_EXISTS = "err_account_username_already_exists";

	// /////////////////////NEED to check////////////////////////
	public static final String ERR_ACCOUNT_USERNAME_SYSTEM_ERROR = "err_account_username_system_error";

	public static final String ERR_ACCOUNT_SECURITYQUESTION_INVALID = "err_account_securityQuestion_invalid";

	// #################### Lini Contact Information Common messages

	// Lini#####################
	public static final String ERR_CONTACT_FIRSTNAME_REQUIRED = "err_contact_firstName_required";
	public static final String ERR_CONTACT_FIRSTNAME_INVALID = "err_contact_firstName_invalid";
	public static final String ERR_CONTACT_LASTNAME_REQUIRED = "err_contact_lastName_required";
	public static final String ERR_CONTACT_LASTNAME_INVALID = "err_contact_lastName_invalid";
	public static final String ERR_CONTACT_MIDDLENAME_INVALID = "err_contact_middleName_invalid";
	public static final String ERR_CONTACT_SUFFIX_REQUIRED = "err_contact_suffix_required";
	public static final String ERR_CONTACT_SUFFIX_INVALID = "err_contact_suffix_invalid";
	// #######Mailing Address

	/* Error Messages for Mailing/Additional Address */
	public static final String ERR_HOME_CONTACT_STREET1_REQUIRED = "err_home_street1_required";
	public static final String ERR_HOME_CONTACT_STREET1_INVALID = "err_home_street1_invalid";
	public static final String ERR_HOME_CONTACT_STREET2_INVALID = "err_home_street2_invalid";
	public static final String ERR_HOME_CONTACT_APT_SUITE_INVALID = "err_home_aptSuite_invalid";
	public static final String ERR_HOME_CONTACT_STREET1_INVALID_LENGTH = "err_home_street1_invalid_length";
	public static final String ERR_HOME_CONTACT_STREET2_INVALID_LENGTH = "err_home_street2_invalid_length";
	public static final String ERR_HOME_CONTACT_APT_SUITE_INVALID_LENGTH = "err_home_aptSuite_invalid_length";
	public static final String ERR_HOME_CONTACT_CITY_REQUIRED = "err_home_city_required";
	public static final String ERR_HOME_CONTACT_CITY_INVALID_LENGTH = "err_home_city_invalid_length";
	public static final String ERR_HOME_CONTACT_CITY_INVALID = "err_home_city_invalid";
	public static final String ERR_HOME_CONTACT_ZIP_REQUIRED = "err_home_zip_required";
	public static final String ERR_HOME_CONTACT_ZIP_INVALID = "err_home_zip_invalid";
	public static final String ERR_HOME_CONTACT_ZIP_INVALID_LENGTH = "err_home_zip_invalid_length";
	public static final String ERR_HOME_CONTACT_STATE_REQUIRED = "err_home_state_required";
	public static final String ERR_HOME_CONTACT_STATE_INVALID = "err_home_state_invalid";
	public static final String ERR_HOME_CONTACT_STATE_INVALID_LENGTH = "err_home_state_invalid_length";
	public static final String ERR_HOME_CONTACT_COUNTY_REQUIRED = "err_home_county_required";
	
	
	public static final String ERR_CONTACT_MAILING_STREET1_REQUIRED = "err_contact_mailing_street1_required";
	public static final String ERR_CONTACT_MAILING_STREET1_INVALID = "err_contact_mailing_street1_invalid";
	public static final String ERR_CONTACT_MAILING_STREET2_INVALID = "err_contact_mailing_street2_invalid";
	public static final String ERR_CONTACT_MAILING_APT_SUITE_INVALID = "err_contact_mailing_aptSuite_invalid";
	public static final String ERR_CONTACT_MAILING_STREET1_INVALID_LENGTH = "err_contact_mailing_street1_invalid_length";
	public static final String ERR_CONTACT_MAILING_STREET2_INVALID_LENGTH = "err_contact_mailing_street2_invalid_length";
	public static final String ERR_CONTACT_MAILING_APT_SUITE_INVALID_LENGTH = "err_contact_mailing_aptSuite_invalid_length";
	public static final String ERR_CONTACT_MAILING_CITY_REQUIRED = "err_contact_mailing_city_required";
	public static final String ERR_CONTACT_MAILING_CITY_INVALID_LENGTH = "err_contact_mailing_city_invalid_length";
	public static final String ERR_CONTACT_MAILING_CITY_INVALID = "err_contact_mailing_city_invalid";
	public static final String ERR_CONTACT_MAILING_ZIP_REQUIRED = "err_contact_mailing_zip_required";
	public static final String ERR_CONTACT_MAILING_ZIP_INVALID = "err_contact_mailing_zip_invalid";
	public static final String ERR_CONTACT_MAILING_ZIP_INVALID_LENGTH = "err_contact_mailing_zip_invalid_length";
	public static final String ERR_CONTACT_MAILING_STATE_REQUIRED = "err_contact_mailing_state_required";
	public static final String ERR_CONTACT_MAILING_STATE_INVALID = "err_contact_mailing_state_invalid";
	public static final String ERR_CONTACT_MAILING_STATE_INVALID_LENGTH = "err_contact_mailing_state_invalid_length";
	public static final String ERR_CONTACT_MAILING_COUNTY_REQUIRED = "err_contact_mailing_county_required";
	
	public static final String ERR_ADDL_CONTACT_MAILING_STREET1_REQUIRED = "err_additional_contact_mailing_street1_required";
	public static final String ERR_ADDL_CONTACT_MAILING_STREET1_INVALID = "err_additional_contact_mailing_street1_invalid";
	public static final String ERR_ADDL_CONTACT_MAILING_STREET2_INVALID = "err_additional_contact_mailing_street2_invalid";
	public static final String ERR_ADDL_CONTACT_MAILING_APT_SUITE_INVALID = "err_additional_contact_mailing_aptSuite_invalid";
	public static final String ERR_ADDL_CONTACT_MAILING_STREET1_INVALID_LENGTH = "err_additional_contact_mailing_street1_invalid_length";
	public static final String ERR_ADDL_CONTACT_MAILING_STREET2_INVALID_LENGTH = "err_additional_contact_mailing_street2_invalid_length";
	public static final String ERR_ADDL_CONTACT_MAILING_APT_SUITE_INVALID_LENGTH = "err_additional_contact_mailing_aptSuite_invalid_length";
	public static final String ERR_ADDL_CONTACT_MAILING_CITY_REQUIRED = "err_additional_contact_mailing_city_required";
	public static final String ERR_ADDL_CONTACT_MAILING_CITY_INVALID_LENGTH = "err_additional_contact_mailing_city_invalid_length";
	public static final String ERR_ADDL_CONTACT_MAILING_CITY_INVALID = "err_additional_contact_mailing_city_invalid";
	public static final String ERR_ADDL_CONTACT_MAILING_ZIP_REQUIRED = "err_additional_contact_mailing_zip_required";
	public static final String ERR_ADDL_CONTACT_MAILING_ZIP_INVALID = "err_additional_contact_mailing_zip_invalid";
	public static final String ERR_ADDL_CONTACT_MAILING_ZIP_INVALID_LENGTH = "err_additional_contact_mailing_zip_invalid_length";
	public static final String ERR_ADDL_CONTACT_MAILING_STATE_REQUIRED = "err_additional_contact_mailing_state_required";
	public static final String ERR_ADDL_CONTACT_MAILING_STATE_INVALID = "err_additional_contact_mailing_state_invalid";
	public static final String ERR_ADDL_CONTACT_MAILING_STATE_INVALID_LENGTH = "err_additional_contact_mailing_state_invalid_length";
	public static final String ERR_ADDL_CONTACT_MAILING_COUNTY_REQUIRED = "err_additional_contact_mailing_county_required";
	
	// #######Phone Number
	public static final String ERR_CONTACT_PRIMARY_PHONE_NUMBER_REQUIRED = "err_contact_primary_phone_number_required";
	public static final String ERR_CONTACT_PRIMARY_PHONE_NUMBER_INVALID = "err_contact_primary_phone_number_invalid";
	public static final String ERR_CONTACT_PRIMARY_PHONE_TYPECD_REQUIRED = "err_contact_primary_phone_typeCd_required";
	public static final String ERR_CONTACT_PRIMARY_PHONE_TYPECD_INVALID = "err_contact_primary_phone_typeCd_invalid";
	public static final String ERR_CONTACT_PRIMARY_PHONE_EXT_INVALID = "err_contact_primary_phone_extension_invalid";

	public static final String ERR_CONTACT_ADDITIONAL_PHONE_NUMBER_INVALID = "err_contact_additional_phone_number_invalid";
	public static final String ERR_CONTACT_ADDITIONAL_PHONE_TYPECD_INVALID = "err_contact_additional_phone_typeCd_invalid";
	public static final String ERR_CONTACT_ADDITIONAL_PHONE_EXT_INVALID = "err_contact_additional_phone_extension_invalid";

	public static final String ERR_CONTACT_EMAIL_ADDRESS_REQUIRED = "err_email_address_required";
	public static final String ERR_CONTACT_EMAIL_ADDRESS_INVALID = "err_email_address_invalid";
	// #################### Lini Contact Information Common messages
	// #####################

	// Error Messages for Identifying info

	public static final String ERR_IDINFO_GENDER_REQUIRED = "err_gender_required";
	public static final String ERR_IDINFO_DOB_REQUIRED = "err_dob_required";
	public static final String ERR_IDINFO_DOB_INVALID = "err_dob_invalid";
	public static final String ERR_IDINFO_SSN_REQUIRED = "err_ssn_required";
	public static final String ERR_IDINFO_SSN_INVALID = "err_ssn_invalid";
	
	
	public static final String ERR_IDINFO_NOSSN_DRIVER_LICENSE_ID_INVALID ="err_driverslicense_invalid";
	public static final String ERR_IDINFO_NOSSN_NON_DRIVER_ID_INVALID = "err_nondriverid_invalid";
	public static final String ERR_IDINFO_NOSSN_USER_CIN_NUMBER_INVALID ="err_cinnumber_invalid";
	public static final String ERR_IDINFO_NOSSN_USER_HIX_NUMBER_INVALID ="err_userhix_invalid";
	
	public static final String ERR_IDINFO_NOSSNREASON_REQUIRED = "err_nossnreason_required";
	public static final String ERR_IDINFO_NOTELIGIBLEFORSSN_REQUIRED = "err_noteligibleforssn_required";
	public static final String ERR_IDINFO_NOSSNREASON_ADDTNL_INFO_REQUIRED = "err_nossnreasonaddtnl_required";
	public static final String ERR_IDINFO_NOSSNREASON_ADDTNL_INFO_DRIVER_LICENSE_ID_REQUIRED ="err_driverslicense_required";
	public static final String ERR_IDINFO_NOSSNREASON_ADDTNL_INFO_NON_DRIVER_ID_REQUIRED = "err_nondriverid_required";
	public static final String ERR_IDINFO_NOSSNREASON_ADDTNL_INFO_USER_CIN_NUMBER_REQUIRED="err_cinnumber_required";
	public static final String ERR_IDINFO_NOSSNREASON_ADDTNL_INFO_USER_HIX_NUMBER_REQUIRED="err_userhix_required";

	/* START - Error Messages for Create New Password */
	public static final String ERR_PASSWORD_REQUIRED = "err_password_required";
	public static final String ERR_PASSWORD_INVALID = "err_password_invalid";
	public static final String ERR_PASSWORD_LENGTH = "err_password_length";
	public static final String ERR_ACCOUNT_PASSWORD_USERNAME_SAME_INVALID="err_account_password_username_same_invalid";

	public static final String ERR_CONFIRMPASSWORD_REQUIRED = "err_confirmPassword_required";
	public static final String ERR_CONFIRMPASSWORD_INVALID = "err_confirmPassword_invalid";
	public static final String ERR_CONFIRMPASSWORD_LENGTH = "err_confirmPassword_length";
	public static final String ERR_CONFIRMPASSWORD_NOTMATCH = "err_confirmPassword_notmatch";
	public static final String ERR_CHANGING_PASSWORD_INVALID = "err_changing_password_invalid";
	/* END - Error Messages for Create New Password */

	/* Error Messages for Registration */
	public static final String FIELD_USERNAME = "username";
	public static final String FIELD_EMAIL = "userProfile.email";
	public static final String FIELD_CONFIRM_EMAIL = "confirmEmail";
	public static final String FIELD_PASSWORD = "password";
	public static final String FIELD_CONFIRM_PASSWORD = "confirmPassword";
	public static final String FIELD_SECURITY_QUESTIONS_Q0 = "userProfile.securityQuestions[0].question.id";
	public static final String FIELD_SECURITY_QUESTIONS_Q1 = "userProfile.securityQuestions[1].question.id";
	public static final String FIELD_SECURITY_QUESTIONS_Q2 = "userProfile.securityQuestions[2].question.id";
	public static final String FIELD_SECURITY_QUESTIONS_A0 = "userProfile.securityQuestions[0].answer";
	public static final String FIELD_SECURITY_QUESTIONS_A1 = "userProfile.securityQuestions[1].answer";
	public static final String FIELD_SECURITY_QUESTIONS_A2 = "userProfile.securityQuestions[2].answer";
	public static final String FIELD_TERMS = "userProfile.userProfileTermsInd";
	public static final String FIELD_AGREE_TERMS_NYS = "userProfile.agreeTermsFTEInd";
	public static final String FIELD_AGREE_TERMS_FTE = "userProfile.agreeTermsNYSInd";
	public static final String FIELD_AGREE_TERMS_COVERAGE = "userProfile.agreeTermsCoverageInd";

	/* Error Messages for Contact Preferences */
	public static final String FIELD_SPOKEN_LANGUAGE = "spokenLanguages";
	public static final String FIELD_WRITTEN_LANGUAGE = "writtenLanguages";

	public static final String ERR_SPOKEN_LANGUAGE_REQUIRED = "err_spokenLanguageRequired";
	public static final String ERR_WRITTEN_LANGUAGE_REQUIRED = "err_writtenLanguageRequired";
	/* END - Error Messages for Contact Preferences */
	/* Error Messages for Company Information */
	public static final String FIELD_COMPANYNAME = "companyName";
	public static final String FIELD_DBANAME = "dbaName";
	public static final String FIELD_EIN = "ein";
	public static final String FIELD_TAXID = "taxId";
	public static final String FIELD_BUSINESSTYPE = "selectedBusinessType";
	public static final String FIELD_PRIMARY_ADDRESS1 = "primaryAddress.addressLine1";
	public static final String FIELD_PRIMARY_ADDRESS2 = "primaryAddress.addressLine2";
	public static final String FIELD_PRIMARY_CITY = "primaryAddress.city";
	public static final String FIELD_PRIMARY_ZIP = "primaryAddress.zipCode";
	public static final String FIELD_PRIMARY_STATE = "primaryAddress.state";
	public static final String FIELD_PRIMARY_COUNTY = "primaryAddress.county";
	public static final String FIELD_BILLING_ADDRESS1 = "billingAddress.addressLine1";
	public static final String FIELD_BILLING_ADDRESS2 = "billingAddress.addressLine2";
	public static final String FIELD_BILLING_CITY = "billingAddress.city";
	public static final String FIELD_BILLING_ZIP = "billingAddress.zip";
	public static final String FIELD_BILLING_STATE = "billingAddress.state";
	public static final String FIELD_BILLING_COUNTY = "billingAddress.county";
	public static final String FIELD_MAILING_ADDRESS1 = "mailingAddress.addressLine1";
	public static final String FIELD_MAILING_ADDRESS2 = "mailingAddress.addressLine2";
	public static final String FIELD_MAILING_CITY = "mailingAddress.city";
	public static final String FIELD_MAILING_ZIP = "mailingAddress.zip";
	public static final String FIELD_MAILING_STATE = "mailingAddress.state";
	public static final String FIELD_MAILING_COUNTY = "mailingAddress.county";

	public static final String ERR_COMPANY_LEGALNAME_REQUIRED = "err_companyLegalNameRequired";
	public static final String ERR_COMPANY_LEGALNAME_ALREADY_EXISTS = "err_companyLegalNameExists";
	public static final String ERR_COMPANY_LEGALNAME_MAXLENGTH = "err_companyLegalNameMaxLength";
	public static final String ERR_COMPANY_LEGALNAME_NOTALPHANUM = "err_companyLegalNameNotAlphaNum";
	public static final String ERR_COMPANY_LEGALNAME_NOTALLNUM = "err_companyLegalNameNotAllNum";
	public static final String ERR_COMPANY_LEGALNAME_NOTALLSPECIALCHAR = "err_companyLegalNameNotAllSpecialChar";
	public static final String ERR_COMPANY_EIN_NAME_VALIDATION_FAILED = "err_companyEinNameValidationFailed";
	public static final String ERR_COMPANY_EIN_CMS_SERVICE_FAILURE = "err_companyEinCmsServiceFailure";
	public static final String ERR_COMPANY_DBANAME_MINLENGTH = "err_companyDbaNameMinLength";
	public static final String ERR_COMPANY_DBANAME_MAXLENGTH = "err_companyDbaNameMaxLength";
	public static final String ERR_COMPANY_DBANAME_NOTALLNUM = "err_companyDbaNameNotAllNum";
	public static final String ERR_COMPANY_DBANAME_NOTALLSPECIALCHAR = "err_companyDbaNameNotAllSpecialChar";
	public static final String ERR_COMPANY_BUSINESSTYPE_REQUIRED = "err_companyBusinessTypeRequired";
	public static final String ERR_COMPANY_EIN_REQUIRED = "err_companyEinRequired";
	public static final String ERR_COMPANY_EIN_INVALID = "err_companyEinInvalid";
	public static final String ERR_COMPANY_EIN_DIGITS = "err_companyEinDigitsOnly";
	public static final String ERR_COMPANY_EIN_ALREADY_EXISTS = "err_companyEinExists";
	public static final String ERR_MULTIPLE_COMPANY_FOUND_FOR_EIN = "err_multiplecompanyWithEinExists";
	public static final String ERR_COMPANY_FOUND_FOR_PRIMARY_ACCT_SWAP_NEED_PROOF = "err_companyFoundForPrimaryAccountSwapUploadProof";
	public static final String ERR_COMPANY_EIN_MINLENGTH = "err_companyEinMinLength";
	public static final String ERR_COMPANY_EIN_VALIDATION_FAILED = "err_companyEinValidationFailed";
	public static final String ERR_COMPANY_EIN_ADDRESS_VALIDATION_FAILED = "err_companyEinAddressValidationFailed";
	public static final String ERR_COMPANY_TAXID_REQUIRED = "err_companyTaxIdRequired";
	public static final String ERR_COMPANY_TAXID_INVALID = "err_companyTaxIdInvalid";
	public static final String ERR_COMPANY_TAXID_MINLENGTH = "err_companyTaxIdMinLength";
	public static final String ERR_COMPANY_TAXID_EXISTS = "err_companyTaxIdExists";
	public static final String ERR_COMPANY_PRIMARY_ADDRESS1_REQUIRED = "err_companyPrimaryAddress1Required";
	public static final String ERR_COMPANY_PRIMARY_ADDRESS1_MINLENGTH = "err_companyPrimaryAddress1MinLength";
	public static final String ERR_COMPANY_PRIMARY_ADDRESS1_NOT_ALPHANUM = "err_companyPrimaryAddress1NotAlphaNum";
	public static final String ERR_COMPANY_PRIMARY_ADDRESS2_MINLENGTH = "err_companyPrimaryAddress2MinLength";
	public static final String ERR_COMPANY_PRIMARY_ADDRESS2_NOT_ALPHANUM = "err_companyPrimaryAddress2NotAlphaNum";
	public static final String ERR_COMPANY_PRIMARY_CITY_REQUIRED = "err_companyPrimaryCityRequired";
	public static final String ERR_COMPANY_PRIMARY_CITY_MINLENGTH = "err_companyPrimaryCityMinLength";
	public static final String ERR_COMPANY_PRIMARY_CITY_NOTALLNUM = "err_companyPrimaryCityNotAllNum";
	public static final String ERR_COMPANY_PRIMARY_CITY_NOSPECIALCHAR = "err_companyPrimaryCityNoSpecialChar";
	public static final String ERR_COMPANY_PRIMARY_ZIPCODE_REQUIRED = "err_companyPrimaryZipRequired";
	public static final String ERR_COMPANY_PRIMARY_ZIPCODE_INVALID = "err_companyPrimaryZipInvalid";
	public static final String ERR_COMPANY_PRIMARY_ZIPCODE_MINLENGTH = "err_companyPrimaryZipMinLength";
	public static final String ERR_COMPANY_PRIMARY_STATE_REQUIRED = "err_companyPrimaryStateRequired";
	public static final String ERR_COMPANY_PRIMARY_COUNTY_REQUIRED = "err_companyPrimaryCountyRequired";
	public static final String ERR_COMPANY_PRIMARY_ZIP_COUNTY_INVALID = "err_invalidPrimaryZipCountyState";
	public static final String ERR_COMPANY_PRIMARY_STATE_INVALID = "err_companyPrimaryStateInvalid";
	public static final String ERR_COMPANY_PRIMARY_STATE_MINLENGTH = "err_companyPrimaryStateMinLength";
	public static final String ERR_COMPANY_PRIMARY_COUNTY_INVALID = "err_companyPrimaryCountyInvalid";
	public static final String ERR_COMPANY_BILLING_ADDRESS1_REQUIRED = "err_companyBillingAddress1Required";
	public static final String ERR_COMPANY_BILLING_ADDRESS1_MINLENGTH = "err_companyBillingAddress1MinLength";
	public static final String ERR_COMPANY_BILLING_ADDRESS1_NOT_ALPHANUM = "err_companyBillingAddress1NotAlphaNum";
	public static final String ERR_COMPANY_BILLING_ADDRESS2_MINLENGTH = "err_companyBillingAddress2MinLength";
	public static final String ERR_COMPANY_BILLING_ADDRESS2_NOT_ALPHANUM = "err_companyBillingAddress2NotAlphaNum";
	public static final String ERR_COMPANY_BILLING_CITY_REQUIRED = "err_companyBillingCityRequired";
	public static final String ERR_COMPANY_BILLING_CITY_MINLENGTH = "err_companyBillingCityMinLength";
	public static final String ERR_COMPANY_BILLING_CITY_NOTALLNUM = "err_companyBillingCityNotAllNum";
	public static final String ERR_COMPANY_BILLING_CITY_NOSPECIALCHAR = "err_companyBillingCityNoSpecialChar";
	public static final String ERR_COMPANY_BILLING_ZIPCODE_REQUIRED = "err_companyBillingZipRequired";
	public static final String ERR_COMPANY_BILLING_ZIPCODE_INVALID = "err_companyBillingZipInvalid";
	public static final String ERR_COMPANY_BILLING_ZIPCODE_MINLENGTH = "err_companyBillingZipMinLength";
	public static final String ERR_COMPANY_BILLING_STATE_REQUIRED = "err_companyBillingStateRequired";
	public static final String ERR_COMPANY_BILLING_COUNTY_REQUIRED = "err_companyBillingCountyRequired";
	public static final String ERR_COMPANY_BILLING_STATE_INVALID = "err_companyBillingStateInvalid";
	public static final String ERR_COMPANY_BILLING_STATE_MINLENGTH = "err_companyBillingStateMinLength";
	public static final String ERR_COMPANY_BILLING_COUNTY_INVALID = "err_companyBillingCountyInvalid";
	public static final String ERR_COMPANY_BILLING_ZIP_COUNTY_INVALID = "err_invalidBillingZipCountyState";
	//Added mailing address as a part of defect 65446
	public static final String ERR_COMPANY_MAILING_ADDRESS1_REQUIRED = "err_companyMailingAddress1Required";
	public static final String ERR_COMPANY_MAILING_ADDRESS1_MINLENGTH = "err_companyMailingAddress1MinLength";
	public static final String ERR_COMPANY_MAILING_ADDRESS1_NOT_ALPHANUM = "err_companyMailingAddress1NotAlphaNum";
	public static final String ERR_COMPANY_MAILING_ADDRESS2_MINLENGTH = "err_companyMailingAddress2MinLength";
	public static final String ERR_COMPANY_MAILING_ADDRESS2_NOT_ALPHANUM = "err_companyMailingAddress2NotAlphaNum";
	public static final String ERR_COMPANY_MAILING_CITY_REQUIRED = "err_companyMailingCityRequired";
	public static final String ERR_COMPANY_MAILING_CITY_MINLENGTH = "err_companyMailingCityMinLength";
	public static final String ERR_COMPANY_MAILING_CITY_NOTALLNUM = "err_companyMailingCityNotAllNum";
	public static final String ERR_COMPANY_MAILING_CITY_NOSPECIALCHAR = "err_companyMailingCityNoSpecialChar";
	public static final String ERR_COMPANY_MAILING_ZIPCODE_REQUIRED = "err_companyMailingZipRequired";
	public static final String ERR_COMPANY_MAILING_ZIPCODE_INVALID = "err_companyMailingZipInvalid";
	public static final String ERR_COMPANY_MAILING_ZIPCODE_MINLENGTH = "err_companyMailingZipMinLength";
	public static final String ERR_COMPANY_MAILING_STATE_REQUIRED = "err_companyMailingStateRequired";
	public static final String ERR_COMPANY_MAILING_COUNTY_REQUIRED = "err_companyMailingCountyRequired";
	public static final String ERR_COMPANY_MAILING_STATE_INVALID = "err_companyMailingStateInvalid";
	public static final String ERR_COMPANY_MAILING_STATE_MINLENGTH = "err_companyMailingStateMinLength";
	public static final String ERR_COMPANY_MAILING_COUNTY_INVALID = "err_companyMailingCountyInvalid";
	public static final String ERR_COMPANY_MAILING_ZIP_COUNTY_INVALID = "err_invalidMailingZipCountyState";
	/* End - Error Messages for Company Information */

	public static final String ERR_EMPLOYER_USERNAME_ALREADY_EXISTS = "err_employerUsernameAlreadyExists";
	public static final String ERR_EMPLOYER_EMAIL_ALREADY_EXISTS = "err_employerEmailAlreadyExists";
	public static final String ERR_EMPLOYER_USERNAME_REQUIRED = "err_employerUsernameRequired";
	public static final String ERR_EMPLOYER_USERNAME_INVALID = "err_employerUsernameInvalid";
	public static final String ERR_EMPLOYER_PASSWORD_REQUIRED = "err_employerPasswordRequired";
	public static final String ERR_EMPLOYER_PASSWORD_INVALID = "err_employerPasswordInvalid";
	public static final String ERR_USERPASSWORD_NOT_SAME = "err_userPasswordNotSame";
	public static final String ERR_EMPLOYER_CONFIRM_PASSWORD_REQUIRED = "err_employerConfirmPasswordRequired";
	public static final String ERR_EMPLOYER_CONFIRM_PASSWORD_MATCH = "err_employerConfirmPasswordMatch";
	public static final String ERR_EMPLOYER_EMAIL_REQUIRED = "err_employerEmailRequired";
	public static final String ERR_EMPLOYER_EMAIL_INVALID = "err_employerEmailInvalid";
	public static final String ERR_EMPLOYER_CONFIRM_EMAIL_REQUIRED = "err_employerConfirmEmailRequired";
	public static final String ERR_EMPLOYER_CONFIRM_EMAIL_INVALID = "err_employerConfirmEmailInvalid";
	public static final String ERR_EMPLOYER_CONFIRM_EMAIL_MATCH = "err_employerConfirmEmailMatch";
	public static final String ERR_EMPLOYER_SECURITY_QUESTION_SAME_0 = "err_employerSecurityQuestionSame_0";
	public static final String ERR_EMPLOYER_SECURITY_QUESTION_SAME_1 = "err_employerSecurityQuestionSame_1";
	public static final String ERR_EMPLOYER_SECURITY_QUESTION_SAME_2 = "err_employerSecurityQuestionSame_2";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_SAME_0 = "err_employerSecurityAnswersSame_0";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_SAME_1 = "err_employerSecurityAnswersSame_1";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_SAME_2 = "err_employerSecurityAnswersSame_2";
	public static final String ERR_EMPLOYER_SECURITY_QUESTION_REQUIRED_0 = "err_employerSecurityQuestionRequired_0";
	public static final String ERR_EMPLOYER_SECURITY_QUESTION_REQUIRED_1 = "err_employerSecurityQuestionRequired_1";
	public static final String ERR_EMPLOYER_SECURITY_QUESTION_REQUIRED_2 = "err_employerSecurityQuestionRequired_2";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_REQUIRED_0 = "err_employerSecurityAnswerRequired_0";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_REQUIRED_1 = "err_employerSecurityAnswerRequired_1";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_REQUIRED_2 = "err_employerSecurityAnswerRequired_2";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_INVALID_0 = "err_employerSecurityAnswerInvalid_0";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_INVALID_1 = "err_employerSecurityAnswerInvalid_1";
	public static final String ERR_EMPLOYER_SECURITY_ANSWER_INVALID_2 = "err_employerSecurityAnswerInvalid_2";

	public static final String ERR_EMPLOYER_TERMS_REQUIRED = "err_employerTermsRequired";
	public static final String ERR_EMPLOYER_AGREE_TERMS_NYS = "err_employerAgreeTermsNYSRequired";
	public static final String ERR_EMPLOYER_AGREE_TERMS_FTE = "err_employerAgreeTermsFTERequired";
	public static final String ERR_EMPLOYER_AGREE_TERMS_COVERAGE = "err_employerAgreeTermsCoverageRequired";
	/* END - Error Messages for Registration */

	// Error Messages for shop Identifying info
	public static final String ERR_IDINFO_FIRSTNAME_REQUIRED = "err_firstname_required";
	public static final String ERR_IDINFO_FIRSTNAME_INVALID = "err_firstname_invalid";
	public static final String ERR_IDINFO_LASTNAME_REQUIRED = "err_lastname_required";
	public static final String ERR_IDINFO_LASTNAME_INVALID = "err_lastname_invalid";
	public static final String ERR_IDINFO_MIDDLENAME_INVALID = "err_middlename_invalid";
	public static final String ERR_IDINFO_SUFFIX_REQUIRED = "err_suffix_required";
	public static final String ERR_IDINFO_ADDRESSLINE1_REQUIRED = "err_addressline1_required";
	public static final String ERR_IDINFO_CITY_REQUIRED = "err_city_required";
	public static final String ERR_IDINFO_ZIP_REQUIRED = "err_zip_required";
	public static final String ERR_IDINFO_ZIP_INVALID = "err_zip_invalid";
	public static final String ERR_IDINFO_STATE_REQUIRED = "err_state_required";

	// Error Messages for Identity Info Unconfirmed
	public static final String ERR_IDINFO_QUESTION1_REQUIRED = "err_question1_required";
	public static final String ERR_IDINFO_QUESTION2_REQUIRED = "err_question2_required";
	public static final String ERR_IDINFO_QUESTION3_REQUIRED = "err_question3_required";
	public static final String ERR_IDINFO_QUESTION4_REQUIRED = "err_question4_required";

	// Error Messages for Identifying info not found
	public static final String FIELD_IDENTITYFIRSTNAME = "firstNameTxt";
	public static final String FIELD_IDENTITYLASTNAME = "LastNameTxt";
	public static final String FIELD_IDENTITYADDRESSLINE1 = "addressLine1Txt";
	public static final String FIELD_IDENTITYCITY = "cityTxt";
	public static final String FIELD_IDENTITYZIP = "zipCodeTxt";
	public static final String FIELD_IDENTITYSTATE = "stateSel";
	public static final String FIELD_IDENTITYGENDER = "gender";
	public static final String FIELD_IDENTITYDOBMONTH = "dobMM";
	public static final String FIELD_IDENTITYDOBDATE = "dobDD";
	public static final String FIELD_IDENTITYDOBYEAR = "dobYYYY";
	public static final String FIELD_IDENTITYSSN1 = "SSN1";
	public static final String FIELD_IDENTITYSSN2 = "SSN2";
	public static final String FIELD_IDENTITYSSN3 = "SSN3";
	public static final String FIELD_IDENTITYNOSSN = "noSSN";
	public static final String FIELD_IDENTITYNOTELIGIBLESSNREASON = "notEligibleForSSNReason";
	public static final String ERR_IDENTITY_FIRSTNAME_REQUIRED = "err_identity_firstname_required";
	public static final String ERR_IDENTITY_FIRSTNAME_INVALID = "err_identity_firstname_invalid";
	public static final String ERR_IDENTITY_LASTNAME_REQUIRED = "err_identity_lastname_required";
	public static final String ERR_IDENTITY_LASTNAME_INVALID = "err_identity_lastname_invalid";
	public static final String ERR_IDENTITY_ADDRESSLINE1_REQUIRED = "err_identity_addressline1_required";
	public static final String ERR_IDENTITY_CITY_REQUIRED = "err_identity_city_required";
	public static final String ERR_IDENTITY_ZIP_REQUIRED = "err_identity_zip_required";
	public static final String ERR_IDENTITY_ZIP_INVALID = "err_identity_zip_invalid";
	public static final String ERR_IDENTITY_STATE_REQUIRED = "err_identity_state_required";
	public static final String ERR_IDENTITY_GENDER_REQUIRED = "err_identity_gender_required";
	public static final String ERR_IDENTITY_DOB_REQUIRED = "err_identity_dob_required";
	public static final String ERR_IDENTITY_DOB_INVALID = "err_identity_dob_invalid";
	public static final String ERR_IDENTITY_SSN_REQUIRED = "err_identity_ssn_required";
	public static final String ERR_IDENTITY_SSN_INVALID = "err_identity_ssn_invalid";
	public static final String ERR_IDENTITY_NOSSNREASON_REQUIRED = "err_identity_nossnreason_required";
	public static final String ERR_IDENTITY_NOTELIGIBLEFORSSN_REQUIRED = "err_identity_noteligibleforssn_required";
	public static final String ERR_IDENTITY_NOTIDENTITYSUCCESS = "err_identity_notidentitysuccess";
	// --------------------------------------------------------------------------------------------------------
	// Error Messages for Income

	public static final String ERR_TAX_FILING_STATUS_REQUIRED = "err_taxFilingStatus";
	public static final String ERR_JOINT_FILING_STATUS_REQUIRED = "err_taxFilingJointly";
	public static final String ERR_TAX_RELATIONSHIPS_REQUIRED = "err_taxRelationships";
	public static final String ERR_TAX_ADDITONAL_INCOME_OTHER_SOURCES_INCOME = "err_taxAdditionalIncomeOtherSourcesIncome_required";
	public static final String ERR_TAX_ADDITONAL_INCOME_AMOUNT = "err_taxAdditionalIncomeAmount_required";
	public static final String ERR_TAX_SPOUSE_IS_DEPENDENT_INVALID = "err_spouse_is_dependent";
	public static final String ERR_TAX_SPOUSE_INVALID = "err_someoneelse_spouse";
	public static final String ERR_TAX_DEPENDENT_INVALID = "err_someoneelse_dependent";
	public static final String ERR_ISDEPENDENTTOOUTSIDEHH_REQUIRED = "err_isdependenttooutsidehh_required";	
	public static final String ERR_TAX_DEPENDENT_IS_SPOUSE_INVALID = "err_dependentissomeonesspouse";
	public static final String ERR_TAX_SPOUSE_IS_OTHERDEPENDENT_INVALID ="err_spouseissomeonesdependent";
	public static final String ERR_TAX_DEPENDENTTAXSTATUS_INVALID   = "err_taxstatus_dependent";
	public static final String ERR_TAX_FILING_STATUS_OR_DEPENDENTLIST_REQUIRED = "error_tax_status_dependentlist";
	public static final String ERR_TAX_FILING_STATUS_OR_OUTSIDE_DEPENDENT_REQUIRED = "error_tax_status_outsidedependent";
	public static final String ERR_TAX_SPOUSETAXSTATUS_INVALID   = "err_taxstatus_spouse";
	public static final String ERR_TAX_FILING_STATUS_CARETAKERDEPENDENTCHECK = "err_taxFilingStatusCareTakerDependentNotChecked";
	
	// Income Deduction
	public static final String ERR_TAX_DEDUCTION_INCOME_OTHER_TYPE_REQUIRED = "err_taxDeductionIncomeOtherSourcesIncome_required";
	public static final String ERR_TAX_DEDUCTION_INCOME_OTHER_TYPE_INVALID = "err_taxDeductionIncomeOtherSourcesIncome_invalid";
	public static final String ERR_TAX_DEDUCTION_INCOME_AMOUNT_REQUIRED = "err_taxDeductionIncomeAmount_required";
	public static final String ERR_TAX_DEDUCTION_INCOME_AMOUNT_INVALID = "err_taxDeductionIncomeAmount_invalid";

	public static final String ERR_TAX_DEDUCTIONS_COMMON_INVALID_INVALID = "err_taxDeductions_invalid";
	public static final String ERR_TAX_DEDUCTION_INCOME_FREQUENCY_REQUIRED = "err_taxDeductionIncomeAmountFrequency_required";
	public static final String ERR_TAX_DEDUCTION_INCOME_DEDUCTION_TYPE_REQUIRED = "err_taxDeductionIncomeAmountDeductionType_required";
	public static final String ERR_TAX_DEDUCTION_INCOME_FOR_UPCOMING_YEAR_REQUIRED = "err_no_taxDeductions_upcoming_year_required";
	
	//Additional Income  
	public static final String ERR_TAX_ADDITIONAL_INCOME_OTHER_SOURCES_INCOME_REQUIRED = "err_taxAdditionalIncomeOtherSourcesIncome_required";
    ///
	public static final String ERR_TAX_ADDITIONAL_INCOME_OTHER_TYPE_REQUIRED = "err_taxAdditionalIncomeOtherSourcesIncome_required";
	public static final String ERR_TAX_ADDITIONAL_INCOME_OTHER_TYPE_INVALID = "err_taxAdditionalIncomeOtherSourcesIncome_invalid";
	public static final String ERR_TAX_ADDITIONAL_INCOME_AMOUNT_REQUIRED = "err_taxAdditionalIncomeAmount_required";
	public static final String ERR_TAX_ADDITIONAL_INCOME_AMOUNT_INVALID = "err_taxAdditionalIncomeAmount_invalid";
	
	public static final String ERR_TAX_ADDITIONAL_COMMON_INVALID_INVALID = "err_taxAdditionalIncome_invalid";
	public static final String ERR_TAX_ADDITIONAL_INCOME_FREQUENCY_REQUIRED = "err_taxAdditionalIncomeAmountFrequency_required";
	public static final String ERR_TAX_ADDITIONAL_INCOME_DEDUCTION_TYPE_REQUIRED = "err_taxAdditionalIncomeAmountDeductionType_required";
	public static final String ERR_TAX_ADDITIONAL_INCOME_FOR_UPCOMING_YEAR_CHECK_REQUIRED = "err_no_taxAdditionalIncome_upcoming_year_check_required";
	
	/* Error messages for Previous Income */
	public static final String ERR_IRS_DS_CORRECT_REQUIRED = "err_irs_ds_correct_required";
	public static final String ERR_IRS_PRIMARY_INCOME_REQUIRED = "err_primary_income_required";
	public static final String ERR_IRS_SPOUSE_INCOME_REQUIRED = "err_spouse_income_required";
	public static final String ERR_IRS_PRIMARY_INCOME_INVALID = "err_primary_income_invalid";
	public static final String ERR_IRS_SPOUSE_INCOME_INVALID = "err_spouse_income_invalid";
	public static final String ERR_IRS_PRIMARY_INCOME_INVALID_DIGITS = "err_primary_income_invalid_digits";
	public static final String ERR_IRS_SPOUSE_INCOME_INVALID_DIGITS = "err_spouse_income_invalid_digits";
	public static final String ERR_IRS_TOTAL_INCOME_LIMIT_EXCEEDED = "err_total_income_limit_exceeded";
	
	/* Error messages for Verified Income Summary*/
	public static final String ERR_VI_REASON_CODE_REQUIRED = "err_vi_reason_code_required";
	public static final String ERR_VI_OTHER_REASON_TEXT_REQUIRED = "err_vi_other_reason_text_required";
	public static final String ERR_VI_OTHER_REASON_TEXT_INVALID = "err_vi_other_reason_text_invalid";
	public static final String ERR_VI_UNEMPLOYMENT_STATUS_REQUIRED = "err_vi_unemployment_status_required";
	
	/* Error messages for Total Income Summary */
	public static final String ERR_TOTAL_INCOME_SUMMARY_AGREE_REQUIRED = "err_income_summary_agree_required";
	public static final String ERR_HOUSEINCOME_SAME_AS_IT_IS_TODAY_REQUIRED = "err_houseIncome_same_as_it_is_today_required";
	public static final String ERR_HOW_ARE_YOU_LIVING_REQUIRED = "err_how_you_are_living_required";
	public static final String ERR_HOW_ARE_YOU_LIVING_REQUIRED_OTHER_DERSCRIPTION_REQUIRED = "err_how_you_are_living_other_description_required";
	
	/*Error messages for UIB Income*/
	public static final String ERR_ELECTRONICSOURCEACCEPTED_REQUIRED = "err_electronicsourceaccepted_required";
	public static final String ERR_WEEKLYRATE_REQUIRED = "err_weeklyrate_required";
	public static final String ERR_NUMBEROFWEEKS_REQUIRED = "err_numberofweeks_required";
	public static final String ERR_WEEKLYRATE_INVALID = "err_weeklyrate_invalid";
	public static final String ERR_NUMBEROFWEEKS_INVALID = "err_numberofweeks_invalid";
	public static final String ERR_MONTHLYRATE_REQUIRED = "err_monthlyrate_required";
	public static final String ERR_NUMBEROFMONTHS_REQUIRED = "err_numberofmonths_required";
	public static final String ERR_MONTHLYRATE_INVALID = "err_monthlyrate_invalid";
	public static final String ERR_NUMBEROFMONTHS_INVALID = "err_numberofmonths_invalid";
	public static final String ERR_NOINCOME_REQUIRED = "err_noincome_required";
	
	/*Error Message for Earned Income */
	 
	public static final String ERR_COMPANYNAME_REQUIRED = "err_company_name_required";
	public static final String ERR_COMPANYNAME_INVALID = "err_company_name_invalid";
	public static final String ERR_DBANAME_INVALID = "err_dba_name_invalid";
	public static final String ERR_COMPANY_STREET1_REQUIRED = "err_company_street1_required";
	public static final String ERR_COMPANY_CITY_REQUIRED = "err_company_city_required";
	public static final String ERR_COMPANY_ZIP_REQUIRED = "err_company_zip_required";
	public static final String ERR_COMPANY_STATE_REQUIRED = "err_company_state_required";
	public static final String ERR_EARNED_NOINCOME_REQUIRED = "err_noincome_required";
	public static final String ERR_COMPANY_CITY_INVALID = "err_company_city_invalid";
	public static final String ERR_COMPANY_ZIP_INVALID = "err_company_zip_invalid";
	
	public static final String ERR_EI_INCOME_CONSISTENCY_REQUIRED = "err_income_consistency_required";
	public static final String ERR_EARNED_FREQUENCY_REQUIRED = "err_income_frequency_required";

	public static final String ERR_EI_NOOFHOURS_REQUIRED = "err_income_noofhours_required";
	public static final String ERR_EI_NOOFHOURS_INVALID = "err_income_noofhours_invalid";
	
	public static final String ERR_EARNED_AMOUNT_REQUIRED =	"err_income_amount_required";
	public static final String ERR_EARNED_AMOUNT_INVALID = "err_income_amount_invalid";
	public static final String ERR_EARNED_AMOUNT_INVALID_DIGITS = "err_income_amount_invalid_digits";
	public static final String ERR_EARNED_AMOUNT_INVALID_LIMIT = "err_income_amount_invalid_limit";
	
	public static final String ERR_EI_INCONSISTENT_AMOUNT_REQUIRED = "err_income_inconsistent_amount_required";
	public static final String ERR_EI_INCONSISTENT_AMOUNT_INVALID = "err_income_inconsistent_amount_invalid";
	public static final String ERR_EI_INCONSISTENT_AMOUNT_INVALID_DIGITS = "err_income_inconsistent_amount_invalid_digits";
	public static final String ERR_EI_INCONSISTENT_AMOUNT_INVALID_LIMIT = "err_income_inconsistent_amount_invalid_limit";
	
	public static final String ERR_EI_START_DATE_REQUIRED = "err_income_startDate_required";
	public static final String ERR_EI_END_DATE_REQUIRED = "err_income_endDate_required";
	public static final String ERR_EI_START_DATE_INVALID = "err_income_startDate_invalid";
	public static final String ERR_EI_END_DATE_INVALID = "err_income_endDate_invalid";
	public static final String ERR_EI_END_DATE_LESS_THAN_START_DATE = "err_income_endDate_lessthan_startdate";
	public static final String ERR_EI_INCOME_EXPENSE_REQUIRED = "err_se_income_expense_required";
	public static final String ERR_EI_FIRST_MONTH_REQUIRED = "err_firstmonth_required";
	public static final String ERR_EI_FIRST_MONTH_INVALID = "err_firstmonth_invalid";
	public static final String ERR_EI_SECOND_MONTH_REQUIRED = "err_secondmonth_required";
	public static final String ERR_EI_SECOND_MONTH_INVALID = "err_secondmonth_invalid";
	public static final String ERR_EI_THIRD_MONTH_REQUIRED = "err_thirdmonth_required";
	public static final String ERR_EI_THIRD_MONTH_INVALID = "err_thirdmonth_invalid";
	public static final String ERR_EI_BUSINESS_EXPENSE_TYPE_REQUIRED = "err_business_expense_type_required";
	public static final String ERR_EI_OTHER_DESCRIPTION_REQUIRED = "err_other_description_required";

	public static final String ERR_EI_FIRST_MONTH_INCOME_OR_EXPENSE_REQUIRED = "err_firstmonth_income_or_expense_required";
	public static final String ERR_EI_SECOND_MONTH_INCOME_OR_EXPENSE_REQUIRED = "err_secondmonth_income_or_expense_required";
	public static final String ERR_EI_THIRD_MONTH_INCOME_OR_EXPENSE_REQUIRED = "err_thirdmonth_income_or_expense_required";
	
	public static final String ERR_EI_FIRST_MONTH_GROSS_SALES_INVALID = "err_firstmonth_grosssales_invalid";
	public static final String ERR_EI_FIRST_MONTH_GROSS_SALES_INVALID_DIGITS = "err_firstmonth_grosssales_invalid_digits";
	public static final String ERR_EI_FIRST_MONTH_GROSS_SALES_INVALID_LIMIT = "err_firstmonth_grosssales_invalid_limit";
	
	public static final String ERR_EI_SECOND_MONTH_GROSS_SALES_INVALID = "err_secondmonth_grosssales_invalid";
	public static final String ERR_EI_SECOND_MONTH_GROSS_SALES_INVALID_DIGITS = "err_secondmonth_grosssales_invalid_digits";
	public static final String ERR_EI_SECOND_MONTH_GROSS_SALES_INVALID_LIMIT = "err_secondmonth_grosssales_invalid_limit";
	
	public static final String ERR_EI_THIRD_MONTH_GROSS_SALES_INVALID = "err_thirdmonth_grosssales_invalid";
	public static final String ERR_EI_THIRD_MONTH_GROSS_SALES_INVALID_DIGITS = "err_thirdmonth_grosssales_invalid_digits";
	public static final String ERR_EI_THIRD_MONTH_GROSS_SALES_INVALID_LIMIT = "err_thirdmonth_grosssales_invalid_limit";
	
	public static final String ERR_EI_FIRST_MONTH_RENTS_INVALID = "err_firstmonth_rents_invalid";
	public static final String ERR_EI_FIRST_MONTH_RENTS_INVALID_DIGITS = "err_firstmonth_rents_invalid_digits";
	public static final String ERR_EI_FIRST_MONTH_RENTS_INVALID_LIMIT = "err_firstmonth_rents_invalid_limit";
	
	public static final String ERR_EI_SECOND_MONTH_RENTS_INVALID = "err_secondmonth_rents_invalid";
	public static final String ERR_EI_SECOND_MONTH_RENTS_INVALID_DIGITS = "err_secondmonth_rents_invalid_digits";
	public static final String ERR_EI_SECOND_MONTH_RENTS_INVALID_LIMIT = "err_secondmonth_rents_invalid_limit";
	
	public static final String ERR_EI_THIRD_MONTH_RENTS_INVALID = "err_thirdmonth_rents_invalid";
	public static final String ERR_EI_THIRD_MONTH_RENTS_INVALID_DIGITS = "err_thirdmonth_rents_invalid_digits";
	public static final String ERR_EI_THIRD_MONTH_RENTS_INVALID_LIMIT = "err_thirdmonth_rents_invalid_limit";
	
	public static final String ERR_EI_FIRST_MONTH_ROYALTIES_INVALID = "err_firstmonth_royalties_invalid";
	public static final String ERR_EI_FIRST_MONTH_ROYALTIES_INVALID_DIGITS = "err_firstmonth_royalties_invalid_digits";
	public static final String ERR_EI_FIRST_MONTH_ROYALTIES_INVALID_LIMIT = "err_firstmonth_royalties_invalid_limit";
	
	public static final String ERR_EI_SECOND_MONTH_ROYALTIES_INVALID = "err_secondmonth_royalties_invalid";
	public static final String ERR_EI_SECOND_MONTH_ROYALTIES_INVALID_DIGITS = "err_secondmonth_royalties_invalid_digits";
	public static final String ERR_EI_SECOND_MONTH_ROYALTIES_INVALID_LIMIT = "err_secondmonth_royalties_invalid_limit";
	
	public static final String ERR_EI_THIRD_MONTH_ROYALTIES_INVALID = "err_thirdmonth_royalties_invalid";
	public static final String ERR_EI_THIRD_MONTH_ROYALTIES_INVALID_DIGITS = "err_thirdmonth_royalties_invalid_digits";
	public static final String ERR_EI_THIRD_MONTH_ROYALTIES_INVALID_LIMIT = "err_thirdmonth_royalties_invalid_limit";
	
	public static final String ERR_EI_FIRST_MONTH_INVENTORY_INVALID = "err_firstmonth_inventory_invalid";
	public static final String ERR_EI_FIRST_MONTH_INVENTORY_INVALID_DIGITS = "err_firstmonth_inventory_invalid_digits";
	public static final String ERR_EI_FIRST_MONTH_INVENTORY_INVALID_LIMIT = "err_firstmonth_inventory_invalid_limit";
	
	public static final String ERR_EI_SECOND_MONTH_INVENTORY_INVALID = "err_secondmonth_inventory_invalid";
	public static final String ERR_EI_SECOND_MONTH_INVENTORY_INVALID_DIGITS = "err_secondmonth_inventory_invalid_digits";
	public static final String ERR_EI_SECOND_MONTH_INVENTORY_INVALID_LIMIT = "err_secondmonth_inventory_invalid_limit";
	
	public static final String ERR_EI_THIRD_MONTH_INVENTORY_INVALID = "err_thirdmonth_inventory_invalid";
	public static final String ERR_EI_THIRD_MONTH_INVENTORY_INVALID_DIGITS = "err_thirdmonth_inventory_invalid_digits";
	public static final String ERR_EI_THIRD_MONTH_INVENTORY_INVALID_LIMIT = "err_thirdmonth_inventory_invalid_limit";
	
	public static final String ERR_EI_FIRST_MONTH_BIZEXPENSE_REQUIRED = "err_firstmonth_bizzexpense_required";
	public static final String ERR_EI_FIRST_MONTH_BIZEXPENSE_INVALID = "err_firstmonth_bizzexpense_invalid";
	public static final String ERR_EI_FIRST_MONTH_BIZEXPENSE_INVALID_DIGITS = "err_firstmonth_bizzexpense_invalid_digits";
	public static final String ERR_EI_FIRST_MONTH_BIZEXPENSE_INVALID_LIMIT = "err_firstmonth_bizzexpense_invalid_limit";
	
	public static final String ERR_EI_SECOND_MONTH_BIZEXPENSE_REQUIRED = "err_secondmonth_bizzexpense_required";
	public static final String ERR_EI_SECOND_MONTH_BIZEXPENSE_INVALID = "err_secondmonth_bizzexpense_invalid";
	public static final String ERR_EI_SECOND_MONTH_BIZEXPENSE_INVALID_DIGITS = "err_secondmonth_bizzexpense_invalid_digits";
	public static final String ERR_EI_SECOND_MONTH_BIZEXPENSE_INVALID_LIMIT = "err_secondmonth_bizzexpense_invalid_limit";
	
	public static final String ERR_EI_THIRD_MONTH_BIZEXPENSE_REQUIRED = "err_thirdmonth_bizzexpense_required";
	public static final String ERR_EI_THIRD_MONTH_BIZEXPENSE_INVALID = "err_thirdmonth_bizzexpense_invalid";
	public static final String ERR_EI_THIRD_MONTH_BIZEXPENSE_INVALID_DIGITS = "err_thirdmonth_bizzexpense_invalid_digits";
	public static final String ERR_EI_THIRD_MONTH_BIZEXPENSE_INVALID_LIMIT = "err_thirdmonth_bizzexpense_invalid_limit";
	public static final String ERR_SIGNATURE_REQUIRED = "err_signature_required";
	public static final String ERR_SIGNATURE_INVALID = "err_signature_invalid";
	public static final String ERR_TERMS_AND_CONDITION_REQUIRED = "err_terms_and_condition_required";
	public static final String ERR_EI_OTHER_DESCRIPTION_LENGTH = "err_other_description_length";
	public static final String ERR_RETRO_MONTHS_CHANGED = "err_retroMonths_changed";

	public static final int OUTSIDE_PARENT_FIRST_NAME_MAX_LENGTH = 100;
	public static final int OUTSIDE_PARENT_LAST_NAME_MAX_LENGTH = 100;
	public static final String ERR_MAXVALUELIMIT = "err_maxvalue_limit";
	
	/*Error Message for Earned Income */
	public static final String ERR_COVERAGE_CONFIG_GROUP_NO_INSURABLE_RELATIONSHIP = "err_no_insurable_relationship";
	 
	
	//LRR exception validation error message codes
	public static final String ERR_TAX_DEPENDENT_LRR_VALIDATION_INVALID_INSURABLE_RELATIONSHIP = "err_tax_dependent_lrr_validation_invalid_insurable_relationship";
	
	public static final String ERR_TAX_DEPENDENT_LRR_VALIDATION_GRANPARENT_NOTMINORCHILD_RELATIONSHIP = "err_tax_dependent_lrr_validation_grandparent_notminorchild_relationship";
	public static final String ERR_TAX_DEPENDENT_LRR_VALIDATION_GRANPARENT_PARENT_PRESENT_RELATIONSHIP = "err_tax_dependent_lrr_validation_grandparent_parent_present_relationship";
	
	public static final String ERR_TAX_DEPENDENT_LRR_VALIDATION_UNCLEAUNT_SUBSCRIBERUNDERAGED_RELATIONSHIP = "err_tax_dependent_lrr_validation_uncleaunt_subscriberunderaged_relationship";
	public static final String ERR_TAX_DEPENDENT_LRR_VALIDATION_UNCLEAUNT_PARENTPRESENT_RELATIONSHIP = "err_tax_dependent_lrr_validation_uncleaunt_parentpresent_relationship";
	public static final String ERR_TAX_DEPENDENT_LRR_VALIDATION_UNCLEAUNT_NOTMINORCHILD_RELATIONSHIP = "err_tax_dependent_lrr_validation_uncleaunt_notminorchild_relationship";

	// MEC Error Codes
	public static final String ERR_MEC_MEDICAID_REQUIRED  = "div_err_isAgreeMedicaid_required";	
	public static final String ERR_MEC_CHIP_REQUIRED  = "div_err_isAgreeChip_required";	
	public static final String ERR_MEC_REFUGEE_REQUIRED  = "div_err_isAgreeRefugee_required";	
	public static final String ERR_MEC_VHP_REQUIRED  = "div_err_agreeVHP_required";	
	public static final String ERR_MEC_MEDICARRE_REQUIRED  = "div_err_agreeMedicare_required";	
	public static final String ERR_MEC_TRICARE_REQUIRED  = "div_err_agreeTricare_required";
	public static final String ERR_MEC_PEACECORPS_REQUIRED  = "div_err_agreePeaceCorps_required";	
	public static final String ERR_MEC_AMERICORPS_REQUIRED  = "div_err_agreeAmeriCorps_required";
	public static final String ERR_MEC_BHPC_REQUIRED  = "div_err_isAgreeBhpc_required";	
	
	public static final String ERR_MEC_TRICARE_COVERAGE_REASON_REQUIRED  = "div_err_seekingCoverageReasonTricare_required";	
	public static final String ERR_MEC_TRICATE_TERMINATION_DATE_REQUIRED  = "div_err_terminationDateTricare_required ";	
	public static final String ERR_MEC_TRICARE_TERMINATION_DATE_INVALID  = "div_err_terminationDateTricare_invalid";	

	public static final String ERR_MEC_PEACECORPS_SEEKING_COVERAGE_REQUIRED  = "div_err_seekingCoverageReasonPeaceCorps_required";
	public static final String ERR_MEC_PEACECORPS_TERMINATION_DATE_REQUIRED  = "div_err_terminationDatePeaceCorps_required";
	public static final String ERR_MEC_PEACECORPS_TERMINATION_DATE_INVALID  = "div_err_terminationDatePeaceCorps_invalid";
	
	public static final String ERR_MEC_AMERICORPS_SEEKING_COVERAGE_REQUIRED  = "div_err_seekingCoverageReasonAmeriCorps_required";
	public static final String ERR_MEC_AMERICORPS_TERMINATION_DATE_REQUIRED = "div_err_terminationDateAmeriCorps_required";
	public static final String ERR_MEC_AMERICORPS_TERMINATION_DATE_INVALID= "div_err_terminationDateAmeriCorps_invalid";
	
	// APPEAL Error Codes
	public static final String ERR_APPEAL_MEMBER_REQUIRED  = "err_appeal_member_required";	
	public static final String ERR_APPEAL_REASON_REQUIRED = "err_appeal_reason_required";
	public static final String ERR_APPEAL_REASON_OTHER_REQUIRED = "err_appeal_other_required";
	public static final String ERR_APPEAL_REASON_OTHER_INVALID = "err_appeal_other_invalid";
	public static final String ERR_APPEAL_TIMES_REQUIRED = "err_appltime_required";
			
	public static final String ERR_APPEAL_FORMAT_REQUIRED = "err_applformat_required";
	public static final String ERR_APPEAL_SPECIAL_OTHER_REQUIRED= "err_special_other_required"; 
	public static final String ERR_APPEAL_SPECIAL_OTHER_INVALID= "err_special_other_invalid";
	
	
	public static final String ERR_APPEAL_REPCONTACT_FIRSTNAME_RQUIRED = "err_contact_firstName_required"; 
	public static final String ERR_APPEAL_REPCONTACT_FIRSTNAME_INVALID_= "err_contact_firstName_invalid";
	public static final String ERR_APPEAL_REPCONTACT_FIRSTNAME_INVALID_LENGTH= "err_contact_firstName_invalid_length";	
	
	public static final String ERR_APPEAL_REPCONTACT_LASTNAME_REQUIRED ="err_contact_lastName_required";
	public static final String ERR_APPEAL_REPCONTACT_LASTNAME_INVALID_= "err_contact_lastName_invalid";
	public static final String ERR_APPEAL_REPCONTACT_LASTNAME_INVALID_LENGTH= "err_contact_lastName_invalid_length";
	
	public static final String ERR_APPEAL_ATTORNEY_REQUIRED = "err_contact_attorney_required";
	public static final String ERR_APPEAL_MAILING_COUNTY_REQUIRED= "err_contact_mailing_county_required";
	public static final String ERR_APPEAL_MAILING_STATE_REQUIRED = "err_contact_mailing_state_required";
	public static final String ERR_APPEAL_MAILING_STATE_INVALID  =	"err_contact_mailing_state_invalid";
	public static final String ERR_APPEAL_MAILING_STATE_INVALID_LENGTH= "err_contact_mailing_state_invalid_length";
	
	public static final String ERR_APPEAL_MAILING_STREET1_REQUIRED= "err_mailing_street1_required";
	public static final String ERR_APPEAL_MAILING_STREET1_INVALID =	"err_mailing_street1_invalid";
	public static final String ERR_APPEAL_MAILING_STREEET1_INVALID_LENGTH= "err_mailing_street1_invalid_length";
	public static final String ERR_APPEAL_MAILING_STREEET2_INVALID_LENGTH= "err_mailing_street2_invalid_length";
	
	public static final String ERR_APPEAL_MAILING_CITY_REQUIRED= "err_mailing_city_required";
	public static final String ERR_APPEAL_CITY_INVALID_LTH= "err_mailing_city_invalid_length";
	public static final String ERR_APPEAL_MAILING_CITY_INVALID= "err_mailing_city_invalid";
	
	public static final String ERR_APPEAL_MAILING_ZIP_REQUIRED= "err_mailing_zip_required";
	public static final String ERR_APPEAL_MAILING_ZIP_INVALID= "err_mailing_zip_invalid";
	public static final String ERR_APPEAL_MAILING_ZIP_LENGTH= "err_mailing_zip_invalid_length ";	
	
	public static final String ERR_APPEAL_PRIMARY_PHONE_NUMBER_REQUIRED= "err_contact_primary_phone_number_required";
	public static final String ERR_APPEAL_PRIMARY_PHONE_NUMBER_INVALID= "err_contact_primary_phone_number_invalid";		 
	public static final String ERR_APPEAL_PRIMARY_PHONE_EXTN_INVALID = "err_contact_primary_phone_extension_invalid";
	public static final String ERR_APPEAL_PRIMARY_PHONE_TYPECD_REQUIRED = "err_contact_primary_phone_typeCd_required";
	public static final String ERR_APPEAL_PRIMARY_PHONE_TYPECD_INVALID = "err_contact_primary_phone_typeCd_invalid";
	
	public static final String ERR_APPEAL_LANGUAGE_REQUIRED = "err_contact_language_required";
	public static final String ERR_APPEAL_OTHER_LANGUAGE_REQUIRED = "err_contact_other_language_required";
	
	/* Partial key used for Household member documents. The other part is the document index */
	public static final String HOUSEHOLDMEMBERDOCUMENTS = "householdMemberDocuments";
	
	//Absent Parent Error Codes
	public static final String ERR_PARENT_ABSENT_REQUIRED = "err_parent_absent_required";
	public static final String ERR_WILLINGNESS_TO_COOPERATE_REQUIRED = "err_willing_to_cooperate_required";
	public static final String ERR_ABSENT_PARENT_FIRSTNAME_REQUIRED = "err_absent_parent_firstname_required";
	public static final String ERR_ABSENT_PARENT_LASTNAME_REQUIRED = "err_absent_parent_lastname_required";
	public static final String ERR_ABSENT_PARENT_DOB_REQUIRED = "err_absent_parent_dob_required";
	public static final String ERR_ABSENT_PARENT_SSN_REQUIRED = "err_absent_parent_ssn_required";
	public static final String ERR_ABSENT_PARENT_PHONENUMBER_REQUIRED ="err_absent_parent_phonenumber_required";
	public static final String ERR_ABSENT_PARENT_STREET1_REQUIRED = "err_absent_parent_street1_required";
	public static final String ERR_ABSENT_PARENT_CITY_REQUIRED = "err_absent_parent_city_required";
	public static final String ERR_ABSENT_PARENT_ZIP_REQUIRED = "err_absent_parent_zip_required";
	public static final String ERR_ABSENT_PARENT_STATE_REQUIRED ="err_absent_parent_state_required";
	public static final String ERR_EMPLOYER_NAME_REQUIRED = "err_employer_name_required";
	public static final String ERR_EMPLOYER_STREET1_REQUIRED = "err_employer_street1_required";
	public static final String ERR_EMPLOYER_CITY_REQUIRED = "err_employer_city_required";
	public static final String ERR_EMPLOYER_ZIP_REQUIRED = "err_employer_zip_required";
	public static final String ERR_EMPLOYER_STATE_REQUIRED = "err_employer_state_required";
	public static final String ERR_ABSENT_PARENT_FIRSTNAME_INVALID = "err_absent_parent_firstname_invalid";
	public static final String ERR_ABSENT_PARENT_FIRSTNAME_LENGTH = "err_absent_parent_firstname_length";
	public static final String ERR_ABSENT_PARENT_LASTNAME_INVALID = "err_absent_parent_lastname_invalid";
	public static final String ERR_ABSENT_PARENT_LASTNAME_LENGTH = "err_absent_parent_lastname_length";
	public static final String ERR_ABSENT_PARENT_DOB_INVALID = "err_absent_parent_dob_invalid";
	public static final String ERR_ABSENT_PARENT_FUTURE_DOB_INVALID = "err_absent_parent_futuredob_invalid";
	public static final String ERR_ABSENT_PARENT_OVERLIMIT_DOB_INVALID = "err_absent_parent_overlimitdob_invalid";
	public static final String ERR_ABSENT_PARENT_BELOWLIMIT_DOB_INVALID = "err_absent_parent_belowlimitdob_invalid";
	public static final String ERR_ABSENT_PARENT_SSN_INVALID = "err_absent_parent_ssn_invalid";
	public static final String ERR_ABSENT_PARENT_SSN_DUPLICATE = "err_absent_parent_ssn_duplicate";
	public static final String ERR_ABSENT_PARENT_PHONENUMBER_INVALID = "err_absent_parent_phonenumber_invalid";
	public static final String ERR_ABSENT_PARENT_STREET1_LENGTH = "err_absent_parent_street1_length";
	public static final String ERR_ABSENT_PARENT_STREET1_INVALID = "err_absent_parent_street1_invalid";
	public static final String ERR_ABSENT_PARENT_STREET2_LENGTH = "err_absent_parent_street2_length";
	public static final String ERR_ABSENT_PARENT_STREET2_INVALID = "err_absent_parent_street2_invalid";
	public static final String ERR_ABSENT_PARENT_CITY_LENGTH = "err_absent_parent_city_length";
	public static final String ERR_ABSENT_PARENT_CITY_INVALID = "err_absent_parent_city_invalid";
	public static final String ERR_ABSENT_PARENT_ZIP_INVALID = "err_absent_parent_zip_invalid";
	public static final String ERR_ABSENT_PARENT_ZIP_LENGTH = "err_absent_parent_zip_length";
	public static final String ERR_EMPLOYER_NAME_INVALID = "err_employer_name_invalid";
	public static final String ERR_EMPLOYER_NAME_LENGTH = "err_employer_name_length";
	public static final String ERR_EMPLOYER_STREET1_LENGTH = "err_employer_street1_length";
	public static final String ERR_EMPLOYER_STREET1_INVALID = "err_employer_street1_invalid";
	public static final String ERR_EMPLOYER_STREET2_LENGTH = "err_employer_street2_length";
	public static final String ERR_EMPLOYER_STREET2_INVALID = "err_employer_street2_invalid";
	public static final String ERR_EMPLOYER_CITY_LENGTH = "err_employer_city_length";
	public static final String ERR_EMPLOYER_CITY_INVALID = "err_employer_city_invalid";
	public static final String ERR_EMPLOYER_ZIP_INVALID = "err_employer_zip_invalid";
	public static final String ERR_EMPLOYER_ZIP_LENGTH = "err_employer_zip_length";
	public static final String ERR_RETIREMENT_BENEFIT_REQUIRED = "err_retirement_benefit_required";
	public static final String ERR_DISABILITY_BENEFIT_REQUIRED = "err_disability_benefit_required";
	
	//Insurance Benefits Common for Child and Adult
	public static final String ERR_HEALTHCARE_COVERAGE_REQUIRED = "err_healthcare_coverage_required";
	public static final String ERR_HEALTHCARE_COVERAGE_ENROLLED_REQUIRED = "err_healthcare_coverage_enrolled_required";
	public static final String ERR_NONE_INSURANCE_BENEFITS = "err_none_insurance_benefits";
	public static final String ERR_POLICY_HOLDER_REQUIRED = "err_policy_holder_required";
	public static final String ERR_CARRIER_NAME_REQUIRED = "err_carrier_name_required";
	public static final String ERR_POLICY_NUMBER_REQUIRED = "err_policy_number_required";
	public static final String ERR_ID_NUMBER_REQUIRED = "err_id_number_required";
	public static final String ERR_POLICY_AMOUNT_REQUIRED = "err_policy_amount_required";
	public static final String ERR_FREQUANCYTYPE_CODE_REQUIRED = "err_frequencytpe_code_required";
	public static final String ERR_COVERAGE_THRU_JOB_REQUIRED = "err_coverage_thru_job_required";
	public static final String ERR_QUALIFIED_TO_ENROLL_REQUIRED = "err_qualified_to_enroll_required";
	public static final String ERR_ENROLL_DATE_REQUIRED = "err_enroll_date_required";
	public static final String ERR_EMPLOYEE_FIRSTNAME_REQUIRED = "err_employee_firstname_required";
	public static final String ERR_EMPLOYEE_MIDDLENAME_REQUIRED = "err_employee_middlename_required";
	public static final String ERR_EMPLOYEE_LASTNAME_REQUIRED = "err_employee_lastname_required";
	public static final String ERR_EMPLOYEE_SSN_REQUIRED = "err_employee_ssn_required";
	public static final String ERR_EMPLOYEE_FULL_TIME_REQUIRED = "err_employee_full_time_required";
	public static final String ERR_EMPLOYER_EE_NAME_REQUIRED = "err_employer_ee_name_required";
	public static final String ERR_EMPLOYER_EE_EIN_REQUIRED = "err_employer_ee_ein_required";
	public static final String ERR_EMPLOYER_EE_STREET1_REQUIRED = "err_employer_ee_street1_required";
	public static final String ERR_EMPLOYER_EE_CITY_REQUIRED = "err_employer_ee_city_required";
	public static final String ERR_EMPLOYER_EE_ZIP_REQUIRED = "err_employer_ee_zip_required";
	public static final String ERR_EMPLOYER_EE_STATE_REQUIRED = "err_employer_ee_state_required";
	public static final String ERR_EMPLOYER_EE_PHONENUMBER_REQUIRED = "err_employer_ee_phonenumber_required";
	public static final String ERR_CONSUMER_EE_PHONENUMBER_REQUIRED = "err_consumer_ee_phonenumber_required";
	public static final String ERR_CONSUMER_EE_EMAIL_REQUIRED = "err_consumer_ee_email_required";
	public static final String ERR_EMPLOYER_EE_PLAN_MIN_VAL_REQUIRED = "err_employer_ee_plan_min_val_required";
	public static final String ERR_JOB_COVERAGE_PREMIUM_AMT_REQUIRED = "err_job_coverage_premium_amt_required";
	public static final String ERR_JOB_COVERAGE_FREQ_CD_REQUIRED = "err_job_coverage_freq_cd_required";
	public static final String ERR_EMPLOYER_START_OR_CHANGE_COVERAGE_REQUIRED="err_employer_start_or_change_coverage_required";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_AMT_REQUIRED = "err_employer_change_plan_amt_required";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_FREQ_CD_REQUIRED = "err_employer_change_freq_cd_required";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_DATE_REQUIRED ="err_employer_change_plan_date_required";
	public static final String ERR_WORKER_COMPENSATION_IND_REQUIRED = "err_worker_compensation_ind_required";
	public static final String ERR_NYSHIP_USER_AGREE_REQUIRED = "err_nyship_user_agree_required";
	public static final String ERR_PARENT_PUBLIC_EMPLOYEE_REQUIRED = "err_parent_public_employee_required";
	public static final String ERR_PARENT_HEALTH_PLAN_COST_PAID_IND_REQUIRED = "err_parent_health_plan_cost_paid_ind_required";
	public static final String ERR_LOST_EMPLOYMENT_IND_REQUIRED = "err_lost_employment_ind_required";
	public static final String ERR_LOST_EMPLOYMENT_REASON_CD_REQUIRED = "err_lost_employment_reason_cd_required";
	public static final String ERR_NO_EMPLOYMENT_REASON_CD_REQUIRED = "err_no_employment_reason_cd_required";
	public static final String ERR_LOST_EMPLOYMENT_DATE_REQUIRED = "err_lost_employment_date_required";
	public static final String ERR_ELIGIBILITY_INCARCERATION_IND_REQUIRED = "err_eligibility_incarceration_ind_required";
	public static final String ERR_POLICYHOLER_NAME_INVALID = "err_policy_holdername_invalidID";
	public static final String ERR_POLICYHOLER_NAME_LENGTH = "err_policy_holdername_lengthID";
	public static final String ERR_CARRIER_NAME_INVALID = "err_carrier_name_invalidID";
	public static final String ERR_CARRIER_NAME_LENGTH = "err_carrier_name_lengthID";
	public static final String ERR_POLICY_NUMBER_INVALID = "err_policy_number_invalidID";
	public static final String ERR_POLICY_NUMBER_LENGTH = "err_policy_number_lengthID";
	public static final String ERR_ID_NUMBER_INVALID = "err_id_number_invalidID";
	public static final String ERR_ID_NUMBER_LENGTH = "err_id_number_lengthID";
	public static final String ERR_POLICY_AMOUNT_INVALID = "err_policy_amount_invalidID";
	public static final String ERR_POLICY_AMOUNT_LENGTH = "err_policy_amount_lengthID";
	public static final String ERR_POLICY_AMOUNT__GREATERTHANMAX= "err_policy_amount_greaterthanmaxID";
	public static final String ERR_POLICY_AMOUNTCALCULATED_GREATERTHANMAX= "err_policy_amountcalculated_greaterthanmaxID";
	public static final String ERR_ENROLL_DATE_INVALID = "err_enroll_date_invalid";
	public static final String ERR_ENROLL_DATE_IS_IN_PAST = "err_enroll_date_is_in_past";
	public static final String ERR_EMPLOYEE_FIRSTNAME_INVALID = "err_employee_firstname_invalid";
	public static final String ERR_EMPLOYEE_FIRSTNAME_LENGTH = "err_employee_firstname_length";
	public static final String ERR_EMPLOYEE_LASTNAME_INVALID = "err_employee_lastname_invalid";
	public static final String ERR_EMPLOYEE_LASTNAME_LENGTH = "err_employee_lastname_length";
	public static final String ERR_EMPLOYEE_MIDDLENAME_INVALID = "err_employee_middlename_invalid";
	public static final String ERR_EMPLOYEE_MIDDLENAME_LENGTH = "err_employee_middlename_length";
	public static final String ERR_EMPLOYEE_SSN_INVALID = "err_employee_ssn_invalid";
	public static final String ERR_EMPLOYEE_SSN_DUPLICATE = "err_employee_ssn_duplicate";
	public static final String ERR_EMPLOYER_EE_NAME_INVALID = "err_employer_ee_name_invalid";
	public static final String ERR_EMPLOYER_EE_NAME_LENGTH = "err_employer_ee_name_length";
	public static final String ERR_EMPLOYER_EE_EIN_INVALID = "err_employer_ee_ein_invalid";
	public static final String ERR_EMPLOYER_EE_EIN_LENGTH = "err_employer_ee_ein_length";
	public static final String ERR_EMPLOYER_EE_STREET1_LENGTH = "err_employer_ee_street1_length";
	public static final String ERR_EMPLOYER_EE_STREET1_INVALID = "err_employer_ee_street1_invalid";
	public static final String ERR_EMPLOYER_EE_STREET2_LENGTH = "err_employer_ee_street2_length";
	public static final String ERR_EMPLOYER_EE_STREET2_INVALID = "err_employer_ee_street2_invalid";
	public static final String ERR_EMPLOYER_EE_CITY_LENGTH = "err_employer_ee_city_length";
	public static final String ERR_EMPLOYER_EE_CITY_INVALID = "err_employer_ee_city_invalid";
	public static final String ERR_EMPLOYER_EE_ZIP_INVALID = "err_employer_ee_zip_invalid";
	public static final String ERR_EMPLOYER_EE_ZIP_LENGTH = "err_employer_ee_zip_length";
	public static final String ERR_EMPLOYER_EE_PHONENUMBER_INVALID = "err_employer_ee_phonenumber_invalid";
	public static final String ERR_CONSUMER_EE_PHONENUMBER_INVALID = "err_consumer_ee_phonenumber_invalid";
	public static final String ERR_CONSUMER_EE_EMAIL_INVALID = "err_consumer_ee_email_invalid";
	public static final String ERR_COVERAGE_EE_AMOUNT_INVALID = "err_coverage_ee_amount_invalid";
	public static final String ERR_COVERAGE_EE_AMOUNT_LENGTH = "err_coverage_ee_amount_length";
	public static final String ERR_COVERAGE_EE_AMOUNT_GREATERTHANMAX = "err_coverage_ee_amount_greaterthanmax";
	public static final String ERR_COVERAGE_EE_AMOUNTCALCULATED_GREATERTHANMAX = "err_coverage_ee_amountcalculated_greaterthanmax";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_AMOUNT_INVALID = "err_employer_change_plan_amount_invalid";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_AMOUNT_LENGTH = "err_employer_change_plan_amount_length";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_AMOUNT_GREATERTHANMAX= "err_employer_change_plan_amount_greaterthanmax";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_AMOUNTCALCULATED_GREATERTHANMAX="err_employer_change_plan_amountcalculated_greaterthanmax";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_DATE_INVALID = "err_employer_change_plan_date_invalid";
	public static final String ERR_EMPLOYER_CHANGE_PLAN_DATE_INPAST = "err_employer_change_plan_date_in_past";
	public static final String ERR_LOST_EMPLOYMENT_DATE_INVALID = "err_lost_employment_date_invalid";
	public static final String ERR_LOST_EMPLOYMENT_DATE_INPAST = "err_lost_employment_date_in_past";
	public static final String ERR_COVERAGE_START_DATE_REQUIRED = "err_coverage_start_date_requiredID";
	public static final String ERR_COVERAGE_START_DATE_INVALID = "err_coverage_start_date_invalidID";
	public static final String ERR_COVERAGE_END_DATE_REQUIRED = "err_coverage_end_date_requiredID";
	public static final String ERR_COVERAGE_END_DATE_INVALID = "err_coverage_end_date_invalidID";
	public static final String ERR_END_DATE_SMALLER_THAN_START_DATE = "err_end_date_smaller_than_start_dateID";
	public static final String ERR_SERVICES_COVERED_DATE = "err_services_covered_requiredID";
	
	public static final String ERR_CORRECTIONAL_FACILITY_IND_REQUIRED = "err_correctionalFaclity_ind_required";
	public static final String ERR_INCARCERATION_IND_REQUIRED = "err_incarceration_ind_required";
	
	public static final String ERR_INCARCERATION_DATE_INVALID = "err_incarceration_date_invalid";
	public static final String ERR_INMATE_NUMBER_INVALID = "err_inmate_number_invalid";
	public static final String ERR_FACILITY_NAME_INVALID = "err_facility_name_invalid";
	public static final String ERR_INCARCERATION_DATE_MORE_THAN_99_YEARS = "err_incarceration_date_more_than_ninetynine_years";
	public static final String ERR_INCARCERATION_DATE_IN_FUTURE = "err_incarceration_date_in_future";
		
	public static final String FIELD_BROKER_ZIP = "zip";
	public static final String FIELD_BROKER_NAME = "brokerName";
	public static final String ERR_EMPLOYER_BROKER_ZIP_INVALID = "err_employer_broker_zip_invalid";
	public static final String ERR_EMPLOYER_BROKER_NAME_INVALID = "err_employer_broker_name_invalid";
	
	
	// SHOP APPEAL Error Codes
		public static final String ERR_SHOP_APPEAL_MEMBER_REQUIRED  = "err_appeal_member_required";	
		public static final String ERR_SHOP_APPEAL_REASON_REQUIRED = "err_appeal_reason_required";
		public static final String ERR_SHOP_APPEAL_REASON_OTHER_REQUIRED = "err_appeal_other_required";
		public static final String ERR_SHOP_APPEAL_REASON_OTHER_INVALID = "err_appeal_other_invalid";
		public static final String ERR_SHOP_APPEAL_TIMES_REQUIRED = "err_appltime_required";
				
		public static final String ERR_SHOP_APPEAL_FORMAT_REQUIRED = "err_applformat_required";
		public static final String ERR_SHOP_APPEAL_SPECIAL_OTHER_REQUIRED= "err_special_other_required"; 
		public static final String ERR_SHOP_APPEAL_SPECIAL_OTHER_INVALID= "err_special_other_invalid";
		
		
		public static final String ERR_SHOP_APPEAL_REPCONTACT_FIRSTNAME_RQUIRED = "err_shop_contact_firstName_required"; 
		public static final String ERR_SHOP_APPEAL_REPCONTACT_FIRSTNAME_INVALID_= "err_shop_contact_firstName_invalid";
		public static final String ERR_SHOP_APPEAL_REPCONTACT_FIRSTNAME_INVALID_LENGTH= "err_shop_contact_firstName_invalid_length";	
		
		public static final String ERR_SHOP_APPEAL_REPCONTACT_LASTNAME_REQUIRED ="err_shop_contact_lastName_required";
		public static final String ERR_SHOP_APPEAL_REPCONTACT_LASTNAME_INVALID_= "err_shop_contact_lastName_invalid";
		public static final String ERR_SHOP_APPEAL_REPCONTACT_LASTNAME_INVALID_LENGTH= "err_shop_contact_lastName_invalid_length";
		
		public static final String ERR_SHOP_APPEAL_ATTORNEY_REQUIRED = "err_shop_contact_attorney_required";
		public static final String ERR_SHOP_APPEAL_MAILING_COUNTY_REQUIRED= "err_shop_contact_mailing_county_required";
		public static final String ERR_SHOP_APPEAL_MAILING_STATE_REQUIRED = "err_shop_contact_mailing_state_required";
		public static final String ERR_SHOP_APPEAL_MAILING_STATE_INVALID  =	"err_shop_contact_mailing_state_invalid";
		public static final String ERR_SHOP_APPEAL_MAILING_STATE_INVALID_LENGTH= "err_shop_contact_mailing_state_invalid_length";
		
		public static final String ERR_SHOP_APPEAL_MAILING_STREET1_REQUIRED= "err_shop_mailing_street1_required";
		public static final String ERR_SHOP_APPEAL_MAILING_STREET1_INVALID =	"err_shop_mailing_street1_invalid";
		public static final String ERR_SHOP_APPEAL_MAILING_STREEET1_INVALID_LENGTH= "err_shop_mailing_street1_invalid_length";
		public static final String ERR_SHOP_APPEAL_MAILING_STREEET2_INVALID_LENGTH= "err_shop_mailing_street2_invalid_length";
		
		public static final String ERR_SHOP_APPEAL_MAILING_CITY_REQUIRED= "err_shop_mailing_city_required";
		public static final String ERR_SHOP_APPEAL_CITY_INVALID_LTH= "err_shop_mailing_city_invalid_length";
		public static final String ERR_SHOP_APPEAL_MAILING_CITY_INVALID= "err_shop_mailing_city_invalid";
		
		public static final String ERR_SHOP_APPEAL_MAILING_ZIP_REQUIRED= "err_shop_mailing_zip_required";
		public static final String ERR_SHOP_APPEAL_MAILING_ZIP_INVALID= "err_shop_mailing_zip_invalid";
		public static final String ERR_SHOP_APPEAL_MAILING_ZIP_LENGTH= "err_shop_mailing_zip_invalid_length ";	
		
		public static final String ERR_SHOP_APPEAL_PRIMARY_PHONE_NUMBER_REQUIRED= "err_shop_contact_primary_phone_number_required";
		public static final String ERR_SHOP_APPEAL_PRIMARY_PHONE_NUMBER_INVALID= "err_shop_contact_primary_phone_number_invalid";		 
		public static final String ERR_SHOP_APPEAL_PRIMARY_PHONE_EXTN_INVALID = "err_shop_contact_primary_phone_extension_invalid";
		public static final String ERR_SHOP_APPEAL_PRIMARY_PHONE_TYPECD_REQUIRED = "err_shop_contact_primary_phone_typeCd_required";
		public static final String ERR_SHOP_APPEAL_PRIMARY_PHONE_TYPECD_INVALID = "err_shop_contact_primary_phone_typeCd_invalid";

		//Residency Test
		public static final String ERR_LEGAL_PERMANENT_RESIDENT_REQUIRED = "err_legal_permanent_resident_required";
		public static final String ERR_VISA_EXPIRES_REQUIRED = "err_visa_expires_required";
		public static final String ERR_DO_YOU_WORK_REQUIRED = "err_do_you_work_required";
		public static final String ERR_YEARS_WORKING_REQUIRED = "err_years_working_required";
		public static final String ERR_YEARS_WORKING_INVALID = "err_years_working_invalid";
		public static final String ERR_YEARS_WORKING_LENGTH = "err_years_working_length";
		public static final String ERR_CHILDREN_GO_SCHOOL_REQUIRED = "err_children_go_school_required";
		public static final String ERR_OWN_HOUSE_REQUIRED = "err_own_house_required";
		public static final String ERR_RENT_HOUSE_REQUIRED = "err_rent_house_required";
		
		//RIDP Error messages
		public static final String LOG_ERROR_RIDP_SERVICE_FAULT = "err_ridp_service_fault";
		
		public static final String CAPTCHA_ERR_MSG = "hxerror_captcha.error.message";
		
		public static final String ERR_PRIMARY_ACCOUNT_HOLDER_EXISTS = "err_primary_account_holder_exists";
	
		/* Error messages for Current Income */
		public static final String ERR_CI_MONTHLY_INCOME_REQUIRED = "err_ci_monthly_income_required";
		public static final String ERR_CI_MONTHLY_INCOME_INVALID = "err_ci_monthly_income_invalid";
		public static final String ERR_CI_MONTHLY_INCOME_INVALID_DIGITS = "err_ci_monthly_income_invalid_digits";
		public static final String ERR_CI_MONTHLY_INCOME_EXCEEDS_LIMIT = "err_ci_monthly_income_exceeds_limit";
		public static final String ERR_CI_APPLY_REQUIRED = "err_ci_apply_required";
		public static final String ERR_CI_SAME_AS_PROJECTED_REQUIRED = "err_ci_same_as_projected_required";
		
		public static final String ERR_RETROINCOMEAGREEALL = "err_retroIncomeAgreeAll";
		public static final String ERR_RETROINCOMEENTERINCOME = "err_retroIncomeEnterIncome";
		public static final String ERR_RETRO_NO_INCOME_MONTHLY_PRESENT = "err_retronoIncomeMonthlyPresent";
		public static final String ERR_RETRO_INVALID_MONTHLY_AMT = "err_retroInvalidMonthlyAmt";
		public static final String ERR_ISDECEASED_REQUIRED = "err_isDeceased_required";
		public static final String ERR_DODDATE_REQUIRED = "err_dodDate_required";
		public static final String ERR_IRSINCOMEMATCHED = "err_irsincomematched";
		public static final String ERR_APPEAL_INTERPRETOR_REQUIRED = "err_appeal_interpretor_invalid";
		public static final String ERR_COVERAGEPREFERENCE_REQUIRED="err_coveragePreference_required";
		
		/*error messages for DAI information*/
		public static final String ERR_DAI_PAPERLESS_MUTUALLY_EXCLUSIVE = "err_dai_paperless_mutually_exclusive";
		public static final String ERR_DAI_INVALID_EFFECTIVE_DATE = "err_dai_invalid_effective_date";
	/* CR522 Change */
	public static final String ERR_IMMIGRATION_CHANGED = "err_immigration_changed";
	/* CR 1513 changes */
	public static final String ERR_CBIC_SERVICE_REQUEST = "err_cibc_service_request"; 
}       