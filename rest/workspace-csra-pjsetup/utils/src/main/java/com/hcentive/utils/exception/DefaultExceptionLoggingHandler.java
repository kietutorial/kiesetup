/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.exception;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.hcentive.utils.utils.AjaxUtils;
import com.hcentive.utils.utils.Springi18nUtils;

public class DefaultExceptionLoggingHandler extends SimpleMappingExceptionResolver {

	private static Logger logger = LoggerFactory.getLogger(DefaultExceptionLoggingHandler.class);

	private String defaultAjaxView = "ajaxError";

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		String errorMessage = "";
		Locale locale = request.getLocale();
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
		logError(errorMessage == null ? "" : errorMessage, ex);
		return super.doResolveException(request, response, handler, ex);
	}

	@Override
	protected ModelAndView getModelAndView(String viewName, Exception ex, HttpServletRequest request) {
		String requestedWith = request.getHeader("X-Requested-With");
		boolean ajaxRequest = AjaxUtils.isAjaxRequest(requestedWith);
		if (ajaxRequest) {
			viewName = defaultAjaxView;
		}
		return getModelAndView(viewName, ex);
	}

	protected void logError(String errorMessage, Exception ex) {
		StringBuilder sBuilder = new StringBuilder(errorMessage);
		if (ex != null) {
			sBuilder.append("{Actual Message- ").append(ex.getMessage()).append("}");
		}
		logger.error(sBuilder.toString(), ex);
	}

	public String getI18nMessage(Locale locale, String defaultMessageCode, MessageCode messageCode, String... args) {
		String message;
		try {
			message = Springi18nUtils.getMessage(messageCode.getName(), args, messageCode.getDefaultMessage(), locale);
		} catch (Exception e) {
			if (StringUtils.isNotEmpty(messageCode.getDefaultMessage())) {
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

	public void setDefaultAjaxView(String defaultAjaxView) {
		this.defaultAjaxView = defaultAjaxView;
	}
}
