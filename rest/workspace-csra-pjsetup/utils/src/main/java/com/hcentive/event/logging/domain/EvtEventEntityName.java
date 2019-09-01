package com.hcentive.event.logging.domain;

/**
 * This will define the NY-HX application name containing the various sections.
 */

public enum EvtEventEntityName {
	INDIVIDUAL("INDIVIDUAL"), EMPLOYER("EMPLOYER"), EMPLOYEE("EMPLOYEE"), BROKER("BROKER"),NAVIGATOR("NAVIGATOR"),APPLICATION_COUNSELOR("APPLICATION_COUNSELOR"),
	SYSTEM_EVENT("SYSTEM_EVENT");
	
	private String val;
	
	private EvtEventEntityName(String value) {
		val = value;
	}
	
	public static EvtEventEntityName getEnum(String value){
		for(EvtEventEntityName evtRefType : EvtEventEntityName.values()){
			if(evtRefType.name().equalsIgnoreCase(value)){
				return evtRefType;
			}
		}
		return null;
	}
	
	public static EvtEventEntityName getEnumbyValue(String value){
		for(EvtEventEntityName evtRefType : EvtEventEntityName.values()){
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