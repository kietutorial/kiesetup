/**
 * 
 */
package com.hcentive.utils.exception;

import java.util.Locale;

import com.hcentive.utils.utils.Springi18nUtils;

/**
 * @author cmelam
 *
 */
public class RestServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public RestServiceException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public RestServiceException() {
		super();
	}

}
