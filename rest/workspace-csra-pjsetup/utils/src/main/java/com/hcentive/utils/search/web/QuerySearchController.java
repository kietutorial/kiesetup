package com.hcentive.utils.search.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchResponse;
import com.hcentive.utils.search.service.SearchService;

@Component
public class QuerySearchController {

	@Autowired
	protected SearchService searchService;

	public SearchResponse search(QuerySearchRequest searchRequest) throws HCException {
		SearchResponse response = searchService.search(searchRequest);
		return response;

	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

}
