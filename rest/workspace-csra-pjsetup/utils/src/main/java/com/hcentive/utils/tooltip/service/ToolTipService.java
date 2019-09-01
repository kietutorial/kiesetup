/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.tooltip.service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;

import com.hcentive.utils.exception.HCRuntimeException;
import com.hcentive.utils.exception.MessageCode;
import com.hcentive.utils.orm.dao.GenericDAO;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchResponse;
import com.hcentive.utils.search.service.SearchService;
import com.hcentive.utils.search.util.SearchUtils;

public class ToolTipService {

	private static Logger logger = LoggerFactory.getLogger(ToolTipService.class);

	@Autowired
	private SearchService searchService;

	@Value("${database}")
	private String database;

	@SuppressWarnings("unused")
	private GenericDAO genericDAO;

	@Cacheable(value = "tooltipCache")
	public ToolTip getToolTip(String identifier, String locale) {
		try {
			if (!StringUtils.hasText(locale)) {
				locale = Locale.ENGLISH.getLanguage();
			}

			Map<String, Object> queryParameters = new HashMap<String, Object>();
			queryParameters.put("identifier", identifier);
			queryParameters.put("locale", locale);

			// Platform#9618 - Conversion from mybatis to hibernate
			// QuerySearchRequest searchRequest =
			// SearchUtils.populateSearchRequest(database +
			// ".ToolTip.getToolTip", queryParameters);
			// SearchResponse response = searchService.search(searchRequest);
			//
			// @SuppressWarnings("unchecked")
			// List<ToolTip> tooltips = (List<ToolTip>) response.getResults();

			@SuppressWarnings("unchecked")
			List<ToolTip> tooltips = (List<ToolTip>) genericDAO.findByNamedQuery("tooltip.getToolTip", queryParameters);

			if (tooltips != null && !tooltips.isEmpty()) {
				if (tooltips.size() == 1) {
					return tooltips.get(0);
				}
				throw new HCRuntimeException(new MessageCode("appService.multipleValuesFoundWhenOneExpected",
						"Database lookup returned multiple values when only One was expected."));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new HCRuntimeException(MessageCode.GENERIC_ERROR, e);
		}
		return null;
	}

	public GenericDAO getGenericDAO() {
		return genericDAO;
	}

	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

}
