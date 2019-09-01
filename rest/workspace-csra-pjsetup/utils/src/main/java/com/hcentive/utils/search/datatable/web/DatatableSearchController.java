package com.hcentive.utils.search.datatable.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcentive.utils.exception.HCException;
import com.hcentive.utils.search.datatable.model.DatatableSearchRequest;
import com.hcentive.utils.search.datatable.model.DatatableSearchResponse;
import com.hcentive.utils.search.model.QuerySearchRequest;
import com.hcentive.utils.search.model.SearchResponse;
import com.hcentive.utils.search.util.DataTableSearchUtils;
import com.hcentive.utils.search.web.QuerySearchController;

@Component
public class DatatableSearchController {

	@Autowired
	private QuerySearchController querySearchController;

	public DatatableSearchResponse search(String queryId, HttpServletRequest request) throws HCException {
		return search(queryId, request, null);
	}

	public DatatableSearchResponse search(String queryId, HttpServletRequest request, Map<String, Object> additionalParams)
			throws HCException {
		DatatableSearchRequest datatableSearchRequest = DataTableSearchUtils.getDatatableSearchRequestFromRequest(request);
		QuerySearchRequest searchRequest = DataTableSearchUtils.getSearchRequest(queryId, datatableSearchRequest, additionalParams);

		SearchResponse response = querySearchController.search(searchRequest);
		DatatableSearchResponse datatableSearchResponse = DataTableSearchUtils.getDatatableSearchResponse(response);
		datatableSearchResponse.setsEcho(datatableSearchRequest.getsEcho());
		return datatableSearchResponse;

	}

	public void setQuerySearchController(QuerySearchController querySearchController) {
		this.querySearchController = querySearchController;
	}

}
