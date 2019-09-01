/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.demographics;

public abstract class DemographicDataHandlerImpl implements DemographicDataHandler {

	protected int[] commaSeparatedStringToArray(String input) {
		if (input != null) {
			String[] arr = input.split(",");
			if (arr != null) {
				int[] result = new int[arr.length];
				for (int i = 0; i < arr.length; i++) {
					try {
						result[i] = Integer.parseInt(arr[i]);
					} catch (NumberFormatException e) {
						return null;
					}
				}
				return result;
			}
		}
		return null;
	}

	protected Integer stringToInteger(String input) {
		if (input != null) {
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;
	}
}
