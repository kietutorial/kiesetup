package com.hcentive.cs.override;

public enum OverrideAttributes {
	EMAIL("EMAIL"),
	STATUS("STATUS"),
	MAILADDRID("MAILADDRID"),
	PERSONLIVINGSTATUS("PERSONLIVINGSTATUS"),
	LIVINGSTATUSVALIDTILL("LIVINGSTATUSVALIDTILL"),
	ACCOUNTSTATUSIND("ACCOUNTSTATUSIND"),
	RETRO_CVRG_START_DT("RETRO_CVRG_START_DT"),
	RETRO_CVRG_END_DT("RETRO_CVRG_END_DT"),
	RETRO_CVRG_CD("RETRO_CVRG_CD"),
	RETRO_AID_CTGRY("RETRO_AID_CTGRY"),
	RETRO_CHRG_CD("RETRO_CHRG_CD"),
	RETRO_NOTICE_SUPP_IND("RETRO_NOTICE_SUPP_IND"),
	VLP("VLP"),
	QNC("QNC"),
	FIVE_Y_BARAPP("5YBARAPP"),
	FIVE_Y_BARMET("5YBARMET"),
	COA("COA"),
	ELG_STMT_CODE("ELGCODE"),
	RESPRU("RESPRU"),
	PRIMARY_CONTACT_CHANGE("PRIMARYCONTACTCHANGE"),
	DATE_OF_DEATH("DATE_OF_DEATH"),
	INVALID_MAIL_REASON("INVALID_MAIL_REASON"),
	ELIGIBILITY_ID("ELIGIBILITY_ID"),
	ELG_MEMBER_ID("ELG_MEMBER_ID"),
	HX_FED_HUB_CITIZENSHIP_RESPONSE("HX_FED_HUB_CITIZENSHIP_RESPONSE"),
	RETRO_CVRG_ADDR_DETAIL_ID("RETRO_CVRG_ADDR_DETAIL_ID"),
	RETRO_CVRG_PLAN_ID("RETRO_CVRG_PLAN_ID"),
	RETRO_CVRG_PLAN_NAME("RETRO_CVRG_PLAN_NAME"),
	RETRO_CVRG_ISSUER_NAME("RETRO_CVRG_ISSUER_NAME"),
	IS_CITIZEN_VERIFICATIONREQUEST("IS_CITIZEN_VERIFICATIONREQUEST"),
	CBIC_REQUESTED("CBIC_REQUESTED"),
	CASE_NUMBER("CASE_NUMBER"),
	CIN("CIN"),
	GRANT_DATE("GRANT_DATE")
	;
	
	
	
	private String val;
	
	private OverrideAttributes(String value){
		val = value;
	}
	
	public static OverrideAttributes getEnum(String value){
		for(OverrideAttributes overrAttr : OverrideAttributes.values()){
			if(overrAttr.name().equalsIgnoreCase(value)){
				return overrAttr;
			}
		}
		return null;
	}
	
	public static OverrideAttributes getEnumbyValue(String value){
		for(OverrideAttributes overrAttr : OverrideAttributes.values()){
			if(overrAttr.getVal().equalsIgnoreCase(value)){
				return overrAttr;
			}
		}
		return null;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
}
