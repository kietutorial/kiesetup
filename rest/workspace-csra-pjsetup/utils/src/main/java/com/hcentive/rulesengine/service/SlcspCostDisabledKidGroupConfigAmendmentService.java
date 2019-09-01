package com.hcentive.rulesengine.service;

import java.util.Date;

import com.hcentive.utils.exception.HCException;

public interface SlcspCostDisabledKidGroupConfigAmendmentService {

	boolean isSlcspEffective( Date effectiveDate ) throws HCException;
	
	boolean isDisabledKidAllowedInGroupConfig( Date effectiveDate ) throws HCException;
}