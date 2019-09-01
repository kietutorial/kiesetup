/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.search.model.CompositeSearchResponse;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchCriteria;
import com.hcentive.utils.search.model.SearchRequest;
import com.hcentive.utils.search.model.SearchResponse;

/**
 * DO NOT USE!!! UNTESTED...
 * 
 * @author ashish.jaiswal
 */
@Deprecated
public class CompositeSearchService implements SearchService {

	private ComponentConfig componentConfig;

	public CompositeSearchService() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hcentive.utils.search.service.SearchService#search(com.hcentive.utils
	 * .search. model.SearchRequest)
	 */
	@Override
	public SearchResponse search(SearchRequest searchRequest) throws HCException {

		if (!(searchRequest instanceof QuerySearchRequest)) {
			throw new IllegalArgumentException("CompositeComponentSearchService only accepts QuerySearchRequest as input");
		}
		QuerySearchRequest componentSR = (QuerySearchRequest) searchRequest;
		String componentId = componentSR.getQueryId();

		List<SimpleComponent> subComponentsList = componentConfig.getSubComponentsRequestMap(componentId,
				searchRequest.getSearchCriteria());
		if (subComponentsList == null) {
			throw new IllegalArgumentException("No configuration provided for Composite Component : " + componentId);
		}

		Map<String, List<?>> componentResults = new LinkedHashMap<String, List<?>>();
		for (SimpleComponent comp : subComponentsList) {
			String compName = comp.getName() != null ? comp.getName() : comp.getId();
			componentResults.put(compName, getSubcomponentResponse(comp.getId(), comp.getParams(), searchRequest));
		}
		return new CompositeSearchResponse(componentSR, componentResults);
	}

	private List<?> getSubcomponentResponse(String compId, Map<String, Object> searchParams, SearchRequest originalRequest)
			throws HCException {
		List<?> searchResult = new ArrayList<Object>();
		SearchService ss = findSearchService(compId);
		if (ss != null) {
			QuerySearchRequest compSearchRequest = new QuerySearchRequest();
			compSearchRequest.setQueryId(compId);
			compSearchRequest.setSearchCriteria(new SearchCriteria(searchParams));
			compSearchRequest.setSizeCriteria(originalRequest.getSizeCriteria());
			compSearchRequest.setSortCriteria(originalRequest.getSortCriteria());

			searchResult = ss.search(compSearchRequest).getResults();
		}
		return searchResult;
	}

	/**
	 * Default implementation is to look for spring bean defined with serviceKey
	 * as beanId
	 */
	private SearchService findSearchService(String componentId) {
		Object service = componentConfig.getComponentService(componentId);
		if (service != null && service instanceof SearchService) {
			return (SearchService) service;
		}
		return null;
	}

	/**
	 * @param componentConfig
	 *            the componentConfig to set
	 */
	public void setComponentConfig(ComponentConfig componentConfig) {
		this.componentConfig = componentConfig;
	}
}
