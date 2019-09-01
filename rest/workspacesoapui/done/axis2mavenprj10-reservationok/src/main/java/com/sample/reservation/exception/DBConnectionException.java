package com.sample.reservation.exception;

public class DBConnectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public DBConnectionException() {
	}

	public DBConnectionException(String message) {
		super(message);
	}

	public DBConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBConnectionException(Throwable cause) {
		super(cause);
	}
}
