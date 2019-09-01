package com.hcentive.Deceased;

/**
 * @author Vgupta
 * @Need to use this file to add the constant used throughout the deceased data processing

 */
public class DeceasedErrorCodes {

	public static final String HBE_USR_NOT_AGREE = "HBE_USR_NO_AGREE"; //USER RESPONSE WITH NO USER AGREEMENT IND
	public static final String HBE_SSA_TRANS_DATE_MISSING = "HBE_SSA_TRANS_DATE_MISSING"; //SSA Data received With no transaction Date
	public static final String HBE_PVC_RCD_FOR_ACTIVE_DECEASED_DATA = "HBE_PVC_FOR_ACTIVE_DECESED_DATA"; //PVC Data received when active record available
	public static final String HBE_ACTIVE_FIND_AND_NO_MATCH_RCD_FOUND = "HBE_ACTIVE_FIND_AND_NO_MATCH_RCD_FOUND"; //Active Data found and no matching input data available to take actions
	public static final String HBE_MULTI_ACTIVE_CLOCK_FOUND = "HBE_MULTI_CLOCK_FOUND"; //More than one active clock found for DeceasedMasterId
	public static final String HBE_NO_OR_MULTI_DECEASED_FOUND = "HBE_NO_OR_MULTI_DECEASED"; //No deceased or multiple active records found for
	public static final String HBE_MULTI_ACTIVE_DECEASED_FOUND = "HBE_MULTI_ACTIVE_DECEASED_FOUND";  //Multiple active deceased records found for
	public static final String HBE_NO_OR_MULTI_CLOCK_FOUND = "HBE_NO_OR_MULTI_CLOCK_FOUND"; //No or Multiple clocks found for
	public static final String EE_ERROR_IN_DECEASED_DATE_RETRIEVAL = "EE_ERROR_IN_DECEASED_DATE_RETRIEVAL"; //LOG_ERROR_EE_ERROR_IN_DECEASED_DATE_RETRIEVAL
	public static final String EE_ERROR_IN_DECEASED_MEMBER_UPDATE = "EE_ERROR_IN_DECEASED_MEMBER_UPDATE"; //LOG_ERROR_EE_ERROR_IN_DECEASED_MEMBER_UPDATE 

}
