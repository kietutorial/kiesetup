/**
 * 
 */
package com.hcentive.utils.exception;

/**
 * @author vroddam
 *
 */
public class ActivityLogException extends HCException {

	/**
	 * @param messageCode
	 * @param th
	 */
	public ActivityLogException(MessageCode messageCode, Throwable th) {
		super(messageCode, th);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messageCode
	 * @param th
	 * @param args
	 */
	public ActivityLogException(MessageCode messageCode, Throwable th, String... args) {
		super(messageCode, th, args);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messageCode
	 */
	public ActivityLogException(MessageCode messageCode) {
		super(messageCode);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messageCode
	 * @param args
	 */
	public ActivityLogException(MessageCode messageCode, String... args) {
		super(messageCode, args);
		// TODO Auto-generated constructor stub
	}

}
