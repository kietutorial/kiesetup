package com.hcentive.event.logging.domain;

/**
 * This will define the NY-HX base appeal notes types.
 */

public enum NotesTypes {
	PLAN_CANCELLATION("PLAN_CANCELLATION"),GENERAL("GENERAL"), APPEAL("APPEAL"), HEARINGOFFICER("HEARINGOFFICER"), ADMINISTRATION("ADMINISTRATION"),PLI_NOTES("PLI_NOTES"),BO_RETRO_FFS_OVERRIDE("BO_RETRO_FFS_OVERRIDE"),BO_RETRO_MMC_OVERRIDE("BO_RETRO_MMC_OVERRIDE"),
	ADDED_MEMBER_TERM_PLAN("ADDED_MEMBER_TERM_PLAN"),COVERAGE_END_DATE_CHANGED("COVERAGE_END_DATE_CHANGED"),SEP_OVERRIDE("SEP_OVERRIDE"),VERIFY_DOC("VERIFY_DOC"),INVALID_DOC("INVALID_DOC"),ELG_OVERRIDE("ELG_OVERRIDE"),
	ID_PROOFING("ID_PROOFING"),TPL_RRE_OVERRIDDEN("TPL_RRE_OVERRIDDEN"),COVERAGE_DATE_OVERRIDE("COVERAGE_DATE_OVERRIDE"),CBIC_REPLACEMENT_REQUEST("CBIC_REPLACEMENT_REQUEST");
		

	private String val;
	
	private NotesTypes(String value){
		val = value;
	}
	
	public static NotesTypes getEnum(String value){
		for(NotesTypes notesType : NotesTypes.values()){
			if(notesType.name().equalsIgnoreCase(value)){
				return notesType;
			}
		}
		return null;
	}
	
	public static NotesTypes getEnumbyValue(String value){
		for(NotesTypes notesType : NotesTypes.values()){
			if(notesType.getVal().equalsIgnoreCase(value)){
				return notesType;
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