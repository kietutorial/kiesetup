package com.hcentive.utils.generator;

public enum IDType {
	ACCOUNTID("ACCOUNTID", "AC",12), HIXID("HIXID", "HX",12), ELIGIBLITYID("ELIGIBLITYID", "EL"), ENROLLMENT_TRANSACTIONID(
			"ENROLLMENT_TRANSACTIONID", "ET"), INTERFACE_REQUESTID("INTERFACE_REQUESTID", "IR"), INCOME_INTERFACE_REQUESTID(
			"INCOME_INTERFACE_REQUESTID", "",11), DCNID("DCNID", "DC"), APPEALID("APPEALID", "AP"), DUMMY_INTERFACE_REQUESTID("INTERFACE_REQUESTID", "DM"),
			CHIPID("CHIPID", "",10), UNBORN_TRANSACTIONID("UNBORN_TRANSACTIONID", "EB"), RMREQUESTID("RMREQUESTID", "RM",12),
			EPPID("EPPID", "",8);

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public int getLength() {
		return length;
	}

	private IDType(String name, String code, int length) {

		this.name = name;
		this.code = code;
		this.length = length;
	}

	private IDType(String name, String code) {
		this(name, code, 14);
	}

	private String name;
	private String code;

	private int length;

}
