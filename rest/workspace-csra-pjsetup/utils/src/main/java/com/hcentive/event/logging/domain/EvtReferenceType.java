package com.hcentive.event.logging.domain;

public enum EvtReferenceType {
	USER_PROFILE("USER_PROFILE"),
	ELIGIBILITY("ELIGIBILITY"),
	ENROLLMENT("ENROLLMENT"),
	PLAN("PLAN"),
	APPEAL("APPEAL"),
	DOCUMENT("DOCUMENT"),
	MARKET_PLACE_ID("MARKET_PLACE_ID"),
	SYSTEM("SYSTEM");
	
	private String val;
	
	private EvtReferenceType(String value){
		val = value;
	}
	
	public static EvtReferenceType getEnum(String value){
		for(EvtReferenceType evtRefType : EvtReferenceType.values()){
			if(evtRefType.name().equalsIgnoreCase(value)){
				return evtRefType;
			}
		}
		return null;
	}
	
	public static EvtReferenceType getEnumbyValue(String value){
		for(EvtReferenceType evtRefType : EvtReferenceType.values()){
			if(evtRefType.getVal().equalsIgnoreCase(value)){
				return evtRefType;
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
