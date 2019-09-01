package com.hcentive.utils.ext;

import java.util.ArrayList;
import java.util.List;

/**
 * Task#9471 - bkumar - enrollment status refactoring
 */

public enum ApplicationTransactionStatusEnum {
	PENDING_CARRIER_SUBMISSION("Pending Carrier Submission", "3"), SUBMITTED_TO_CARRIER("Submitted to Carrier", "4"), ACCEPTED_BY_CARRIER(
			"Accepted by Carrier", "10"), RECEIVED_BY_CARRIER("Received By Carrier", "13"), REJECTED_BY_CARRIER("Rejected By Carrier", "14"),
			TERMINATED_BY_CARRIER("Terminated By Carrier", "15");

	private String value;

	private String code;

	ApplicationTransactionStatusEnum(String value, String code) {
		this.value = value;
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public String getCode() {
		return code;
	}

	public static ApplicationTransactionStatusEnum getEnum(String value) {
		for (ApplicationTransactionStatusEnum enumVal : ApplicationTransactionStatusEnum.values()) {
			if (enumVal.toString().equals(value)) {
				return enumVal;
			}
		}
		return null;
	}

	public static List<ApplicationTransactionStatusEnum> getApplicationTransactionStatusEnums(boolean active) {
		List<ApplicationTransactionStatusEnum> applicationTransactionStatusEnumsActive = new ArrayList<ApplicationTransactionStatusEnum>();
		if (active) {
			applicationTransactionStatusEnumsActive.add(ApplicationTransactionStatusEnum.SUBMITTED_TO_CARRIER);
			applicationTransactionStatusEnumsActive.add(ApplicationTransactionStatusEnum.ACCEPTED_BY_CARRIER);
			applicationTransactionStatusEnumsActive.add(ApplicationTransactionStatusEnum.RECEIVED_BY_CARRIER);
		} else {
			applicationTransactionStatusEnumsActive.add(ApplicationTransactionStatusEnum.PENDING_CARRIER_SUBMISSION);
		}
		return applicationTransactionStatusEnumsActive;
	}
}
