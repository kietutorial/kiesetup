package com.hcentive.utils.exception;

public class CBICServiceException extends HCException {

	private static final long serialVersionUID = 1L;
	
	public CBICServiceException(MessageCode messageCode) {
		super(messageCode);
	}

}
