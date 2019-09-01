package com.hcentive.utils.web.ext;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcentive.utils.web.WebUtils;

/**
 * The Extended WebUtils class.
 * 
 * @author rohit
 */

public class WebUtilsExt extends WebUtils {

	private static Logger logger = LoggerFactory.getLogger(WebUtilsExt.class);

	/**
	 * Derive param.
	 * 
	 * @param paramName
	 *            the param name
	 * @param params
	 *            the params
	 * @return the string
	 */
	public static String deriveParamStr(String paramName, Map<String, String[]> params) {
		Object obj = params.get(paramName);
		if (obj == null)
			return null;
		if (obj instanceof String[]) {
			String[] obj1 = (String[]) obj;
			return obj1[0];
		}
		if (obj instanceof String) {
			return (String) obj;
		}
		return null;
	}

}
