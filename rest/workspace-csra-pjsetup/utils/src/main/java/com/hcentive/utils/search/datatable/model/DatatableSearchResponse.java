package com.hcentive.utils.search.datatable.model;

import java.util.List;

public class DatatableSearchResponse {

	/**
	 * Information for DataTables to use for rendering. This value will be the
	 * same as that in DatatableSearchRequest.sEcho
	 */
	private Integer sEcho;
	/**
	 * Total records without limit
	 */
	private Long iTotalRecords;
	/**
	 * Total records without limit
	 */
	private Long iTotalDisplayRecords;

	/**
	 * Data in a list
	 */
	private List<?> aaData;
	
	private Long searchCriteriaId;
	
	private String resultMessage;
	
	private Integer nextResultSet;
	
	private Integer prevResultSet;
	
	private Integer maxResultCount;
	
	private String countOnSrchBtn;

	public Integer getsEcho() {
		return sEcho;
	}

	public void setsEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}

	public Long getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<?> getAaData() {
		return aaData;
	}

	public void setAaData(List<?> aaData) {
		this.aaData = aaData;
	}

	public Long getSearchCriteriaId() {
		return searchCriteriaId;
	}

	public void setSearchCriteriaId(Long searchCriteriaId) {
		this.searchCriteriaId = searchCriteriaId;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Integer getNextResultSet() {
		return nextResultSet;
	}

	public void setNextResultSet(Integer nextResultSet) {
		this.nextResultSet = nextResultSet;
	}

	public Integer getPrevResultSet() {
		return prevResultSet;
	}

	public void setPrevResultSet(Integer prevResultSet) {
		this.prevResultSet = prevResultSet;
	}

	public Integer getMaxResultCount() {
		return maxResultCount;
	}

	public void setMaxResultCount(Integer maxResultCount) {
		this.maxResultCount = maxResultCount;
	}

	/**
	 * @param countOnSrchBtn
	 */
	public void setCountOnSrchBtn(String countOnSrchBtn) {
		this.countOnSrchBtn = countOnSrchBtn;
	}
	/**
	 * @return countOnSrchBtn
	 */
	public String getCountOnSrchBtn() {
		return countOnSrchBtn;
	}
	

}
