/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.service;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.search.model.SearchRequest;
import com.hcentive.utils.search.model.SearchResponse;

public interface SearchService {

	public SearchResponse search(SearchRequest searchRequest) throws HCException;
}
