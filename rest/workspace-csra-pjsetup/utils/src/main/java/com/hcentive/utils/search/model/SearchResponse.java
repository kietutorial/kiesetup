/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.model;

import java.io.Serializable;
import java.util.List;

public class SearchResponse implements Serializable {


	protected SearchRequest searchRequest;

	protected SearchResult<?> searchResult;

	protected long rowsAvailable;
	
	protected Double minimumTotalPremium;
	
	protected Double maximumTotalPremium;
	
	protected SearchResult<?> totalSearchResult;
	

	public SearchResponse(SearchRequest searchRequest) {
		this.searchRequest = searchRequest;
	}

	public SearchResponse(SearchRequest searchRequest, SearchResult<?> searchResult, long rowsAvailable) {
		this.searchRequest = searchRequest;
		this.searchResult = searchResult;
		this.rowsAvailable = rowsAvailable;
	}
	public SearchResponse(SearchRequest searchRequest, SearchResult<?> searchResult, long rowsAvailable, Double minimumTotalPremium, Double maximumTotalPremium) {
		this.searchRequest = searchRequest;
		this.searchResult = searchResult;
		this.rowsAvailable = rowsAvailable;
		this.minimumTotalPremium = minimumTotalPremium;
		this.maximumTotalPremium = maximumTotalPremium;
	}

	// Useful delegate methods
	public List<?> getResults() {
		return searchResult.getResults();
	}

	public SearchCriteria getSearchCriteria() {
		return this.searchRequest.getSearchCriteria();
	}

	public long getRowsAvailable() {
		return rowsAvailable;
	}

	public String getSortName() {
		return searchRequest.getSortCriterion().getName();
	}

	public String getSortOrder() {
		return searchRequest.getSortOrder();
	}

	public boolean isDoFullExtract() {
		return searchRequest.isDoFullExtract();
	}

	public long getOffset() {
		return searchRequest.getOffset();
	}

	public long getResultSize() {
		return searchRequest.getResultSize();
	}

	public long getRowsFetched() {
		return searchResult.getSize();
	}

	public Double getMinimumTotalPremium() {
		return minimumTotalPremium;
	}

	public Double getMaximumTotalPremium() {
		return maximumTotalPremium;
	}
	public void setMinimumTotalPremium(Double minimumTotalPremium) {
		this.minimumTotalPremium = minimumTotalPremium;
	}

	public void setMaximumTotalPremium(Double maximumTotalPremium) {
		this.maximumTotalPremium = maximumTotalPremium;
	}

	public SearchResult<?> getTotalSearchResult() {
		return totalSearchResult;
	}

	public void setTotalSearchResult(SearchResult<?> totalSearchResult) {
		this.totalSearchResult = totalSearchResult;
	}

	
	
}
