package com.hcentive.shop.activity.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author arajaiah
 *
 */
public enum ActivityFieldEnum {
	OLD_VALUE,
	NEW_VALUE,
	COMMENTS,
	EMPLOYEE_NAME,
	EMPLOYER_NAME,
	BROKER_NAME,
	ISSUER_NAME,
	MEMBER_NAME,
	PLAN_NAME,
	CLASS_NAME,
	REASON_NAME,
	ACTION_DATE,
	ACTION_TYPE,
	TXN_ID,
	ACTION_NAME,
	EFFECTIVE_DATE,
	RELATION_TYPE,
	SPOUSE_NAME,
	BROKER_ACCOUNT_NUM,
	MODULE_NAME,
	ACTIVE_EMPLOYEE_NUM,
	COBRA_EMPLOYEE_NUM,
	RETIREE_EMPLOYEE_NUM,
	AGENCY_NAME,
	ACCOUNT_ID,
	INDIVIDUAL_NAME,
	NAVIGATOR_NAME,
	CAC_NAME,
	COMPANY_NAME,
	CLIENT_NAME;
	
	public static List<ActivityFieldEnum> getActivityFieldsList(){
		List<ActivityFieldEnum> activityFields = Arrays.asList(ActivityFieldEnum.values());
		return activityFields;
	}
	
	public static Map<String, String> getActivityFieldsMap(){
		Map<String, String> fieldsMap = new HashMap<String, String>();
		for (ActivityFieldEnum enumVal : ActivityFieldEnum.values()) {
			fieldsMap.put(enumVal.name(), "");
		}
		return fieldsMap;
	}
	
	public static boolean getEnum(String value) {
		for (ActivityFieldEnum enumVal : ActivityFieldEnum.values()) {
			if (enumVal.toString().equals(value)) {
				return true;
			}
		}
		return false;
	}
}
