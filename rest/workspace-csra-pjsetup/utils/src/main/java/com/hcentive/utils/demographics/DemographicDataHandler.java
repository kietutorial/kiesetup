/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.demographics;

import com.hcentive.utils.demographics.domain.DemographicRules;
import com.hcentive.utils.exception.HCException;

public interface DemographicDataHandler {

	public void modifyDemographicData(DemographicRules dr) throws HCException;

	public boolean checkPlanAvailability(String zip);

	public boolean checkPlanAvailability(String zip, String issuerCode) throws HCException;
}
