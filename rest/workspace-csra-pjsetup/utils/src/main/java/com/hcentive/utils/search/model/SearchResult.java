/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.model;

import java.io.Serializable;
import java.util.List;

/**
 * SearchResult contains the results which can be an object in any form (as
 * simple as Map or a specific model object).
 * 
 * @author ashish.jaiswal
 */
public class SearchResult<T> implements Serializable {

	protected List<T> results;

	public SearchResult(List<T> results) {
		this.results = results;
	}

	public long getSize() {
		return results == null ? 0 : results.size();
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
}
