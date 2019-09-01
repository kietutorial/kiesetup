/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.model;

import java.io.Serializable;

public class SearchRequest implements Serializable {

	protected SortCriteria sortCriteria;

	protected SizeCriteria sizeCriteria;

	protected SearchCriteria searchCriteria;

	protected SearchCriteria systemCriteria;

	public SearchRequest() {
		init();
	}

	public void init() {
		sizeCriteria = new SizeCriteria();
		sortCriteria = new SortCriteria(new SortCriterion());
		searchCriteria = new SearchCriteria();
	}

	public SortCriteria getSortCriteria() {
		return sortCriteria;
	}

	public void setSortCriteria(SortCriteria sortCriteria) {
		this.sortCriteria = sortCriteria;
	}

	public SizeCriteria getSizeCriteria() {
		return sizeCriteria;
	}

	public void setSizeCriteria(SizeCriteria sizeCriteria) {
		this.sizeCriteria = sizeCriteria;
	}

	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public SearchCriteria getSystemCriteria() {
		return systemCriteria;
	}

	public void setSystemCriteria(SearchCriteria systemCriteria) {
		this.systemCriteria = systemCriteria;
	}

	public SortCriterion getSortCriterion() {
		return sortCriteria.get(0);
	}

	public String getSortName() {
		return getSortCriterion().getName();
	}

	public String getSortOrder() {
		return getSortCriterion().isAscendingOrder() ? SortCriterion.SORT_ORDER_ASC : SortCriterion.SORT_ORDER_DESC;
	}

	public boolean isDoFullExtract() {
		return sizeCriteria.isDoFullExtract();
	}

	public long getMaxResultsToRetrive() {
		return sizeCriteria.getMaxResultsToRetrive();
	}

	public long getOffset() {
		return sizeCriteria.getOffset();
	}

	public long getResultSize() {
		return sizeCriteria.getResultSize();
	}
}
