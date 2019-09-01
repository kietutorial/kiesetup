/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * 
 */
package com.hcentive.utils.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;

/**
 * @author ashishjaiswal
 */
public class ConversionUtils {

	private static Logger logger = LoggerFactory.getLogger(ConversionUtils.class);

	public static String dateFormat = "MM/dd/yyyy";

	public static String convertToString(Date date) {
		if (date != null) {
			DateFormat formatter = new SimpleDateFormat(dateFormat);
			formatter.setLenient(false);
			return formatter.format(date);
		}
		return "";
	}

	public static Date convertFromString(String dateString) throws Exception {
		if (StringUtils.isNotEmpty(dateString)) {
			DateFormat formatter = new SimpleDateFormat(dateFormat);
			formatter.setLenient(false);
			return formatter.parse(dateString);
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		logger.info("");
	}

	public static Date parse(String sdate) throws HCException {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(dateFormat);
			formatter.setLenient(false);
			date = formatter.parse(sdate);
		} catch (ParseException e) {
			throw new HCException(new MessageCode("Unable to parse the date"));
		}
		return date;
	}

	// public static <T extends Collection<Long>, V extends Collection<String>>
	// T convertStringToLong(V coll) {
	public static Collection<Long> convertStringToLong(Collection<String> coll) throws Exception {
		if (coll == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		Collection<Long> newColl = coll.getClass().getConstructor().newInstance();
		for (String str : coll) {
			newColl.add(Long.valueOf(str));
		}
		return newColl;
	}
}
