package com.sample.reservation.exception;

public class GuestManagementException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public GuestManagementException() {
	}

	public GuestManagementException(String message) {
		super(message);
	}

	public GuestManagementException(String message, Throwable cause) {
		super(message, cause);
	}

	public GuestManagementException(Throwable cause) {
		super(cause);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
