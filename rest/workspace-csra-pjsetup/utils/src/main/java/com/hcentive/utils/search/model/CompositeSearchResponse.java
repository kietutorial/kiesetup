/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ashish.jaiswal
 */
public class CompositeSearchResponse extends SearchResponse {

	private Map<String, List<?>> compositeResults;

	public CompositeSearchResponse(SearchRequest searchRequest, Map<String, List<?>> compositeResults) {
		super(searchRequest);
		if (compositeResults != null) {
			this.compositeResults = compositeResults;
		} else {
			this.compositeResults = new LinkedHashMap<String, List<?>>();
		}
	}

	public Map<String, List<?>> getResultMap() {
		return compositeResults;
	}

	@Override
	public long getRowsFetched() {
		return -1;
	}

	@Override
	public long getRowsAvailable() {
		return -1;
	}
}
