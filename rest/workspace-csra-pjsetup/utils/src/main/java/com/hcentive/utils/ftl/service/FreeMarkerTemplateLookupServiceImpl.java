package com.hcentive.utils.ftl.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.hcentive.utils.dms.DMSService;
import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.notification.domain.FreeMarkerTemplate;
import com.hcentive.utils.orm.dao.GenericDAO;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchResponse;
import com.hcentive.utils.search.service.SearchService;
import com.hcentive.utils.search.util.SearchUtils;
import com.hcentive.utils.utils.UtilityFunctions;

public class FreeMarkerTemplateLookupServiceImpl implements FreeMarkerTemplateLookupService {

	private Logger logger = LoggerFactory.getLogger(FreeMarkerTemplateLookupServiceImpl.class);

	@SuppressWarnings("rawtypes")
	private GenericDAO genericDAO;

	@Value("${database}")
	private String database;

	@Value("${template.uploadLocation}")
	private String templateBaseFolder;

	@Autowired
	private DMSService dmsService;

	@Autowired
	private SearchService searchService;

	private static final String FILESEPARATOR = System.getProperty("file.separator");

	/**
	 * find the file at specified state code , issuer and if not found return
	 * default
	 */
	@Override
	public String doFreeMarkerTemplateLookUp(String templateName, String stateCode, Long issuerCode) throws HCException {
		FreeMarkerTemplate freeMarkerTemplate = null;
		try {
			freeMarkerTemplate = getTemplateObjByName(templateName);
		} catch (HCException hce) {
			logger.error(hce.getLocalizedMessage());
		}
		if (null == freeMarkerTemplate || null == freeMarkerTemplate.getId() || null == freeMarkerTemplate.getTemplateContent()) {
			return getdefaultTemplate(templateName); // Fallback case to get the
														// template content from
														// the file system.
		}

		return freeMarkerTemplate.getTemplateContent();

		// return doFreeMarkerTemplateLookUp(freeMarkerTemplate, stateCode,
		// issuerCode); // Commenting for PLATFORM-7388
	}

	private String getdefaultTemplate(String templateName) throws HCException {
		try {
			return UtilityFunctions.getStringFromInputStream(dmsService.getDocument(templateBaseFolder + FILESEPARATOR
					+ templateName));
		} catch (Exception e) {
			throw new HCException(new MessageCode("mail.template.notfound", "Unable to find the template '" + templateName
					+ "' at default location"));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public FreeMarkerTemplate getTemplateObjByName(String templateName) throws HCException {
		Map<String, Object> queryParameters = new HashMap<String, Object>();
		queryParameters.put("templateName", templateName);

		// QuerySearchRequest searchRequest =
		// SearchUtils.populateSearchRequest(database +
		// ".FreemarkerTemplate.getTemplateObjByName", queryParameters);
		// SearchResponse response = searchService.search(searchRequest);
		//
		// @SuppressWarnings("unchecked")
		// List<FreeMarkerTemplate> templates = (List<FreeMarkerTemplate>)
		// response.getResults();

		List<FreeMarkerTemplate> templates = genericDAO
				.findByNamedQuery("freemarkerTemplate.getTemplateObjByName", queryParameters);

		if (templates != null && templates.size() == 1) {
			return templates.get(0);
		} else if (templates != null && templates.size() > 0) {
			throw new HCException(new MessageCode("appService.multipleValuesFoundWhenOneExpected",
					"Database lookup returned multiple values when only One was expected."));
		}
		logger.info("No Template Entry in DB");
		return null;
	}

	/**
	 * find the template on the basis of specified detail if not found will load
	 * from default path
	 * 
	 * @throws IOException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String doFreeMarkerTemplateLookUp(FreeMarkerTemplate template, String stateCode, Long issuerCode) throws HCException {

		if (template == null) {
			logger.error("Template Cannot be null");
			throw new HCException(new MessageCode("template.error", "unexpected condition"));
		}
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("stateCode", stateCode);
		params.put("issuerId", issuerCode == null ? null : issuerCode.toString());
		params.put("freemarkerTemplateId", template.getId());

		if (StringUtils.hasText(stateCode)) {
			params.put("stateCodeNullFlag", 1);
		} else {
			params.put("stateCodeNullFlag", 0);
		}

		if (issuerCode == null) {
			params.put("issuerNullFlag", 1);
		} else {
			params.put("issuerNullFlag", 0);
		}

		List<String> results = genericDAO.findByNamedQuery("freeMarkerTemplateLookup.getFreeMarkerTemplateLookup", params);

		String pathToRetrieveTemplate = "";
		if (results == null || results.size() == 0 && stateCode != null) {// find
																			// by
																			// state
																			// code
			params.clear();
			params.put("stateCode", stateCode);
			params.put("issuerId", null);
			params.put("freemarkerTemplateId", template.getId());
			params.put("issuerNullFlag", 1);
			params.put("stateCodeNullFlag", 0);

			results = genericDAO.findByNamedQuery("freeMarkerTemplateLookup.getFreeMarkerTemplateLookup", params);

		}

		if (results != null && results.size() > 0) {
			pathToRetrieveTemplate = results.get(0);
		} else {
			pathToRetrieveTemplate = templateBaseFolder;
		}
		String fileSeparator = System.getProperty("file.separator");

		InputStream is = dmsService.getDocument(pathToRetrieveTemplate + fileSeparator + template.getTemplateName());
		if (is != null) {
			try {
				return UtilityFunctions.getStringFromInputStream(is);
			} catch (IOException e) {
				logger.error(e.getLocalizedMessage());
			}
		}
		return getdefaultTemplate(template.getTemplateName());
	}

	@SuppressWarnings("rawtypes")
	public GenericDAO getGenericDAO() {
		return genericDAO;
	}

	@SuppressWarnings("rawtypes")
	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

}
