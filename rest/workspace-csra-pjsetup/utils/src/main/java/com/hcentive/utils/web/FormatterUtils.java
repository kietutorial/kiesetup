/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class FormatterUtils.
 * 
 * @author ashishjaiswal
 */
public class FormatterUtils {

	private static Logger logger = LoggerFactory.getLogger(FormatterUtils.class);

	/** The Constant amountFormatterInDecimal. */
	private static final NumberFormat amountFormatterInDecimal = new DecimalFormat("$#,###,###.00");

	/** The Constant amountFormatterInDollars. */
	private static final NumberFormat amountFormatterInDollars = new DecimalFormat("$#,###,###");

	/** The Constant numberFormatter. */
	private static final NumberFormat numberFormatter = new DecimalFormat("#,###,###");

	/** The Constant perctFormatter. */
	private static final NumberFormat perctFormatter = new DecimalFormat("#'%'");

	/** The Constant twoDecimalFormatter. */
	private static final NumberFormat twoDecimalFormatter = new DecimalFormat("#.00");

	/**
	 * Format amount.
	 * 
	 * @param amount
	 *            the amount
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	public static String formatAmount(Double amount, Locale locale) {
		return amountFormatterInDollars.format(amount);
	}

	/**
	 * Round two decimals.
	 * 
	 * @param amount
	 *            the amount
	 * @param locale
	 *            the locale
	 * @return the double
	 */
	public static Double roundTwoDecimals(Double amount, Locale locale) {
		return Double.valueOf(twoDecimalFormatter.format(amount));
	}

	/**
	 * Format number.
	 * 
	 * @param amount
	 *            the amount
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	public static String formatNumber(Double amount, Locale locale) {
		return numberFormatter.format(amount);
	}

	/**
	 * Format amount in decimal.
	 * 
	 * @param amount
	 *            the amount
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	public static String formatAmountInDecimal(Double amount, Locale locale) {
		String result = amountFormatterInDecimal.format(amount);
		if (result.equals("$.00")) {
			result = "$0.00";
		}
		return result;
	}

	/**
	 * Format percentage.
	 * 
	 * @param amount
	 *            the amount
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	public static String formatPercentage(Double amount, Locale locale) {
		return perctFormatter.format(amount);
	}

	/**
	 * Gets the double from amount.
	 * 
	 * @param price
	 *            the price
	 * @param locale
	 *            the locale
	 * @return the double from amount
	 * @throws Exception
	 *             the exception
	 */
	public static Double getDoubleFromAmount(String price, Locale locale) throws Exception {
		NumberFormat format = null;
		if (locale == null) {
			format = NumberFormat.getCurrencyInstance();
		} else {
			format = NumberFormat.getCurrencyInstance(locale);
		}
		Number num = format.parse(price);
		return num.doubleValue();
	}

	/**
	 * Gets the double from string.
	 * 
	 * @param str
	 *            the str
	 * @param locale
	 *            the locale
	 * @return the double from string
	 * @throws Exception
	 *             the exception
	 */
	public static Double getDoubleFromString(String str, Locale locale) throws Exception {
		NumberFormat format = null;
		if (locale == null) {
			format = NumberFormat.getInstance();
		} else {
			format = NumberFormat.getInstance(locale);
		}
		Number num = format.parse(str);
		return num.doubleValue();
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the args
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		NumberFormat df = new DecimalFormat("#.00");
		logger.info(df.format(1043));
	}

	/**
	 * Round two decimals.
	 * 
	 * @param d
	 *            the d
	 * @return the double
	 */
	public static double roundTwoDecimals(double d) {
		return Double.valueOf(twoDecimalFormatter.format(d));
	}

	/**
	 * Round two decimals.
	 * 
	 * @param d
	 *            the d
	 * @return the double
	 * @throws Exception
	 */
	public static String roundTwoDecimals(String d) throws Exception {
		if (d != null && !"".equals(d)) {
			Double number = getDoubleFromString(d, null);
			String result = twoDecimalFormatter.format(number);
			if (result.equals(".00")) {
				result = "0.00";
			}
			return result;
		}
		return d;
	}
}
