/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.exception;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.ObjectMapper;

public class ExceptionObjectMapper extends ObjectMapper {

	public ExceptionObjectMapper() {
		getSerializationConfig().addMixInAnnotations(Exception.class, ExceptionMixin.class);
	}

	@JsonIgnoreProperties({ "stackTrace", "cause" })
	private class ExceptionMixin extends Exception {

	}

}
