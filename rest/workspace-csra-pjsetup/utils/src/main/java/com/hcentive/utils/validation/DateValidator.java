package com.hcentive.utils.validation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateValidator implements ConstraintValidator<DateComparison, Object> {

	private static Logger logger = LoggerFactory.getLogger(DateValidator.class);
	
	private String firstFieldName;

	private String secondFieldName;

	private TYPE type;

	@Override
	public void initialize(DateComparison dateComparisonAnnotation) {
		firstFieldName = dateComparisonAnnotation.first();
		secondFieldName = dateComparisonAnnotation.second();
		type = dateComparisonAnnotation.type();

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			Date firstDate = (Date) PropertyUtils.getProperty(value, firstFieldName);
			Date secondDate = (Date) PropertyUtils.getProperty(value, secondFieldName);
			if (firstDate != null && secondDate != null) {
				int comparison = firstDate.compareTo(secondDate);
				switch (type) {
				case EQUAL:
					return comparison == 0;
				case BEFORE:
					return comparison < 0;
				case AFTER:
					return comparison > 0;
				}
				return false;
			}
		} catch (Exception ignore) {
			logger.error("EXCEPTION", ignore);
		}

		return true;
	}

	public static enum TYPE {
		EQUAL, AFTER, BEFORE;
	}

}
