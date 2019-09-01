/**
 * arajend - SHOP Merge Jan'13 Code
 * Extension Utility Class
 */
package com.hcentive.utils.utils.ext;

import com.hcentive.utils.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;

public class ValidateUtilsExt extends ValidateUtils {

	public static boolean validateZip(String zipcode) {
		Boolean isValidZip = true;
		
		if (StringUtils.isEmpty(zipcode) ||! ValidateUtils.validatePattern(ValidateUtils.ZIP_PATTERN, zipcode)) {
			isValidZip=false;
		}

		return isValidZip;

	}
}
