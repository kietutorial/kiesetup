package com.hcentive.event.logging.domain;

/**
 * This will define the NY-HX base event name representing the section name.
 */

public enum EvtBaseEventName {
	ACCOUNT("ACCOUNT"), APPEALS("APPEALS"), AGREEMENT("AGREEMENT"), ELIGIBILITY_DETERMINATION("ELIGIBILITY_DETERMINATION"),
	EXTERNAL_SERVICES("EXTERNAL_SERVICES"), HOUSE_HOLD("HOUSE_HOLD"), INCOME("INCOME"), PLANS("PLANS"), COVERAGE_INFO("COVERAGE_INFO"),
	ADDITIONAL_CONTACT("ADDITIONAL_CONTACT"), COMPANY_CONFIRM("COMPANY_CONFIRM"), ELIGIBILITY("ELIGIBILITY"), ENROLLMENT("ENROLLMENT"),
	APPLICATION("APPLICATION"),NOTICE("NOTICE");
	
	private String val;
	
	private EvtBaseEventName(String value) {
		val = value;
	}
	
	public static EvtBaseEventName getEnum(String value){
		for(EvtBaseEventName evtRefType : EvtBaseEventName.values()){
			if(evtRefType.name().equalsIgnoreCase(value)){
				return evtRefType;
			}
		}
		return null;
	}
	
	public static EvtBaseEventName getEnumbyValue(String value){
		for(EvtBaseEventName evtRefType : EvtBaseEventName.values()){
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