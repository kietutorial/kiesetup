/**
 * 
 */
package com.hcentive.utils.exception;

/**
 * @author jkadimi
 *
 */
public class MultiplePlansFoundException extends HCException {

	private static final long serialVersionUID = 1L;
	
	public MultiplePlansFoundException(MessageCode messageCode) {
		super(messageCode);
	}
}