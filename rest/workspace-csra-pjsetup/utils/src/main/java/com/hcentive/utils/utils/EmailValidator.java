/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	public static boolean validateEmail(String email) {

		if (email == null) {
			return false;
		}
		// Set the email pattern string
		Pattern p = Pattern.compile("^[a-zA-Z0-9._%-]+@[a-zA-Z0-9._%-]+\\.[a-zA-Z]{2,6}$");

		// Match the given string with the pattern
		Matcher m = p.matcher(email);

		// check whether match is found
		boolean matchFound = m.matches();

		if (matchFound) {
			return true;
		}
		return false;
	}
}
