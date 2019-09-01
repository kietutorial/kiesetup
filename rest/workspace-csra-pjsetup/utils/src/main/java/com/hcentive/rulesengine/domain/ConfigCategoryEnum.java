package com.hcentive.rulesengine.domain;

public enum ConfigCategoryEnum {
	INDIVIDUAL("INDIVIDUAL"), SHOP("SHOP"), PLAN("PLAN"), 
	SERVICE_OFFLINE_FLOW("SERVICE_OFFLINE_FLOW"), 
	NOTICES("NOTICES"), 
	EDI834("EDI834"),
	
	//Categories related to program FPL tables	
	MEDICAID_FPL("MEDICAID_FPL"), CHIP_FPL("CHIP_FPL"), APTC_FPL("APTC_FPL"),
	DEFAULT_FPL("DEFAULT_FPL"), MEDICAID_LIF("DEFAULT_LIF"),
	DEFAULT_LIF("DEFAULT_LIF"),
	
	//ESI
	ESI_AFFORDABLE_PERCENT("ESI_AFFORDABLE_PERCENT"),
	APTC_MIN_MAX_PERCENT("APTC_MIN_MAX_PERCENT"), 
	IGNORE_INCOME_THRESHOLD("IGNORE_INCOME_THRESHOLD"),
	
	//CR111
	DECEASED_DATA("DECEASED_DATA"),
	
	//CR 1361
	NYSHIP_RECORD_DATA("NYSHIP_RECORD_DATA"),
	
	DOCCS_TYPE_WEIGHTAGE("DOCCS_TYPE_WEIGHTAGE"),
	//CR1454
	LDSS_REFERRAL_SUPRESSION("LDSS_REFERRAL_SUPRESSION"),
	
	//CR1753
	MOOPS_RECORD_DATA("MOOPS_RECORD_DATA");

	
	private final String categoryCode;
	
	ConfigCategoryEnum(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	public static ConfigCategoryEnum getCategoryEnum(String categoryCode) {
		
		for(ConfigCategoryEnum eachEnum : ConfigCategoryEnum.values()) {
			if(eachEnum.toString().equalsIgnoreCase(categoryCode))
				return eachEnum;
		}
		
		return null;
		
	}
}
