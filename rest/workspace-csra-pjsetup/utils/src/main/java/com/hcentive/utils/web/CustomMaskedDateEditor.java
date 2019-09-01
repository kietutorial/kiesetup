/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web;

import java.text.DateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;

/*
 * This editor takes care of masked date strings like __/__/____.
 * Such strings are taken as empty strings
 * 
 * 
 */

public class CustomMaskedDateEditor extends CustomDateEditor {

	public CustomMaskedDateEditor(DateFormat dateFormat, boolean allowEmpty) {
		super(dateFormat, allowEmpty);

	}

	public CustomMaskedDateEditor(DateFormat dateFormat, boolean allowEmpty, int exactDateLength) {
		super(dateFormat, allowEmpty, exactDateLength);
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.hasText(text) && text.indexOf("_") != -1) {
			text = "";
		}
		super.setAsText(text);
	}

}
