package com.sample.reservation.exception;

public class RoomManagementException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public RoomManagementException() {
	}

	public RoomManagementException(String message) {
		super(message);
	}

	public RoomManagementException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoomManagementException(Throwable cause) {
		super(cause);
	}
}
