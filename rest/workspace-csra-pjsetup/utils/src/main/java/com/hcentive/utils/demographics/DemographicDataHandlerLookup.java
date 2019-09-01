/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.demographics;

import java.util.Map;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;

public class DemographicDataHandlerLookup {

	private Map<String, DemographicDataHandler> demographicDataHandlersMap;

	public Map<String, DemographicDataHandler> getDemographicDataHandlersMap() {
		return demographicDataHandlersMap;
	}

	public void setDemographicDataHandlersMap(Map<String, DemographicDataHandler> demographicDataHandlersMap) {
		this.demographicDataHandlersMap = demographicDataHandlersMap;
	}

	public DemographicDataHandler getDemographicDataHandler(String carrier) throws HCException {
		DemographicDataHandler ddhl = demographicDataHandlersMap.get(carrier);
		if (ddhl == null) {
			throw new HCException(new MessageCode("ddhl.ddhlLookUpFailed", "There is no handler configured for carrier " + carrier));
		}
		return ddhl;
	}
}
