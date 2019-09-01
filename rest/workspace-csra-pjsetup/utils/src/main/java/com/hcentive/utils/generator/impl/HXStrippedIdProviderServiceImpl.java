package com.hcentive.utils.generator.impl;

import com.hcentive.utils.ext.HXUtility;
import com.hcentive.utils.generator.HXStrippedIdProviderService;

public class HXStrippedIdProviderServiceImpl implements HXStrippedIdProviderService {
	public String getStrippedNYHXId(String NYHXId, int numChars) {
		String result = null;
		if (!HXUtility.isEmpty(NYHXId) && NYHXId.length() > numChars) {
			result = NYHXId.substring(numChars);
		}
		return result;
	}
}
