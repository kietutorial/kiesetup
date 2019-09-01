/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.exception;

import java.util.Locale;

/**
 * @author ashish.jaiswal
 * 
 */
public interface ExceptionHandler {

	public enum Level {
		FATAL, ERROR, WARN
	}

	public String handleException(Exception ex, Level level, Locale locale);
}
