package com.hcentive.utils.ext;

public enum VerifiedDocumentsStatusEnum {
	ACTIVE, OBSOLETE, EXPIRED ;
	
	private String value;

	private VerifiedDocumentsStatusEnum() {
	}

	VerifiedDocumentsStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}


	public static VerifiedDocumentsStatusEnum getEnum(String value) {
		for (VerifiedDocumentsStatusEnum enumVal : VerifiedDocumentsStatusEnum.values()) {
			if (enumVal.toString().equals(value)) {
				return enumVal;
			}
		}
		return null;
	}
	

	public static VerifiedDocumentsStatusEnum getEnumByValue(String value) {
		for (VerifiedDocumentsStatusEnum enumVal : VerifiedDocumentsStatusEnum.values()) {
			if (enumVal.getValue().equals(value)) {
				return enumVal;
			}
		}
		return null;
	}
}

