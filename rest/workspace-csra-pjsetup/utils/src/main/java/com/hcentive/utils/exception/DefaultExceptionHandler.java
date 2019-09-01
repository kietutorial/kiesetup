/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.exception;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.util.StringUtils;

import com.hcentive.utils.utils.Springi18nUtils;

public class DefaultExceptionHandler implements ExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	@Override
	public String handleException(Exception ex, Level level, Locale locale) {
		String errorMessage = "";
		if (ex instanceof TransactionSystemException) {
			// this is needed to handle iBatis transaction exceptions
			ex = (Exception) ((TransactionSystemException) ex).getApplicationException();
		}
		if (ex instanceof HCException) {
			HCException ex1 = (HCException) ex;
			errorMessage = getI18nMessage(locale, MessageCode.GENERIC_ERROR.getName(), ex1.getMessageCode(), ex1.getArgs());
		} else if (ex instanceof HCRuntimeException) {
			HCRuntimeException ex1 = (HCRuntimeException) ex;
			errorMessage = getI18nMessage(locale, MessageCode.GENERIC_ERROR.getName(), ex1.getMessageCode(), ex1.getArgs());
		} else {
			errorMessage = getI18nMessage(locale, MessageCode.GENERIC_ERROR.getName(), MessageCode.GENERIC_ERROR);
		}
		logError(errorMessage == null ? "" : errorMessage, ex, level);
		return errorMessage;
	}

	protected void logError(String errorMessage, Exception ex, Level level) {
		if (level == null) {
			level = Level.ERROR;
		}
		StringBuilder sBuilder = new StringBuilder(errorMessage);
		sBuilder.append("{Actual Message- ").append(ex.getMessage()).append("}");
		if (level == Level.ERROR) {
			logger.error(sBuilder.toString(), ex);
		} else if (level == Level.WARN) {
			logger.warn(sBuilder.toString(), ex);
		} else if (level == Level.FATAL) {
			logger.error(sBuilder.toString(), ex);
		}
	}

	public String getI18nMessage(Locale locale, String defaultMessageCode, MessageCode messageCode, String... args) {
		String message;
		try {
			message = Springi18nUtils.getMessage(messageCode.getName(), args, messageCode.getDefaultMessage(), locale);
		} catch (Exception e) {
			if (StringUtils.hasText(messageCode.getDefaultMessage())) {
				message = messageCode.getDefaultMessage();
			} else {
				try {
					message = Springi18nUtils.getMessage(defaultMessageCode, null, locale);
				} catch (NoSuchMessageException ex) {
					message = defaultMessageCode;
				}
			}
		}
		return message;
	}
}
