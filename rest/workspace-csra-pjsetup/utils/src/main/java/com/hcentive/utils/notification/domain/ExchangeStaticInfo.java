package com.hcentive.utils.notification.domain;

public class ExchangeStaticInfo {

	private final String stateAdminContactNumber;

	private final String stateAdminEmail;

	private final String exchangeName;

	public ExchangeStaticInfo(String stateAdminContactNumber, String stateAdminEmail, String exchangeName) {
		super();
		this.stateAdminContactNumber = stateAdminContactNumber;
		this.stateAdminEmail = stateAdminEmail;
		this.exchangeName = exchangeName;
	}

	public String getStateAdminContactNumber() {
		return stateAdminContactNumber;
	}

	public String getStateAdminEmail() {
		return stateAdminEmail;
	}

	public String getExchangeName() {
		return exchangeName;
	}

}
