package com.hcentive.utils.ftl.service;

import java.io.IOException;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.notification.domain.FreeMarkerTemplate;

public interface FreeMarkerTemplateLookupService {

	public String doFreeMarkerTemplateLookUp(String templateName, String stateCode, Long issuerCode) throws HCException;

	public String doFreeMarkerTemplateLookUp(FreeMarkerTemplate template, String stateCode, Long issuerCode) throws HCException,
			IOException;

	public FreeMarkerTemplate getTemplateObjByName(String templateName) throws HCException;
}
