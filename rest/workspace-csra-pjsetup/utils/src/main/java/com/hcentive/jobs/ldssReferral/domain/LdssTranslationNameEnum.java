package com.hcentive.jobs.ldssReferral.domain;

public enum LdssTranslationNameEnum {
	ACI_CODE_TRANSLATION, CATEGORY_CODE_TRANSLATION, RELATIONSHIP_CODE_TRANSLATION, PID_TRANSLATION;
	
	public String toString(){
		switch(this){
			case ACI_CODE_TRANSLATION :
				return "IMMIGRATION";
			case CATEGORY_CODE_TRANSLATION :
				return "AIDCATEGORY";
			case RELATIONSHIP_CODE_TRANSLATION :
				return "RELATIONSHIP";
			case PID_TRANSLATION :
				return "PID";	
		}
		return null;
	}
	
	public static LdssTranslationNameEnum createLdssTranslationNameEnumFromString(String LdssTranslationName){
		if(null!=LdssTranslationName){
			for(LdssTranslationNameEnum v: LdssTranslationNameEnum.values()){
				if(v.toString().equalsIgnoreCase (LdssTranslationName)){
					return v;
				}
			}
		}
		return null;
	}
}
