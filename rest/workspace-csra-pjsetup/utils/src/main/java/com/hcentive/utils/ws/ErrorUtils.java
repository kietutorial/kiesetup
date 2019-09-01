package com.hcentive.utils.ws;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.hcentive.utils.utils.Springi18nUtils;

public class ErrorUtils {

	public static String getErrorMessage(BindingResult bindingResult) {
		StringBuilder errorMsg = new StringBuilder();
		Locale locale = Locale.getDefault();
		for (Iterator<ObjectError> iterator = bindingResult.getAllErrors().iterator(); iterator.hasNext();) {
			ObjectError error = iterator.next();
			errorMsg.append(getErrorStr(locale, error));
			if (iterator.hasNext()) {
				errorMsg.append(", ");
			}
		}
		return errorMsg.toString();
	}

	protected static void addBindingResultsInList(BindingResult bindingResult, Collection<String> errors, Locale locale) {
		List<ObjectError> objectErrors = bindingResult.getAllErrors();
		for (ObjectError objectError : objectErrors) {
			String customMessage = getErrorStr(locale, objectError);
			errors.add(customMessage);
		}
	}

	private static String getErrorStr(Locale locale, ObjectError objectError) {
		String defaultMessage = objectError.getDefaultMessage(), customMessage = defaultMessage;
		for (String errorCode : objectError.getCodes()) {
			customMessage = Springi18nUtils.getMessage(errorCode, objectError.getArguments(), defaultMessage, locale);
			if (!defaultMessage.equals(customMessage))
				break;
		}
		return customMessage;
	}
}
