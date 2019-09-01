/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.model;

import java.io.Serializable;

public class SizeCriteria implements Serializable {

	protected Long offset;
	protected Long resultSize;
	protected Long maxResultsToRetrive;

	protected boolean doFullExtract = true;
	protected boolean getFoundRowsCount = false;

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Long getResultSize() {
		return resultSize;
	}

	public void setResultSize(Long resultSize) {
		this.resultSize = resultSize;
	}

	public boolean isDoFullExtract() {
		return doFullExtract;
	}

	public void setDoFullExtract(boolean doFullExtract) {
		this.doFullExtract = doFullExtract;
	}

	public Long getMaxResultsToRetrive() {
		return maxResultsToRetrive;
	}

	public void setMaxResultsToRetrive(Long maxResultsToRetrive) {
		this.maxResultsToRetrive = maxResultsToRetrive;
	}

	public boolean getGetFoundRowsCount() {
		return !doFullExtract && getFoundRowsCount; // Only get Count when not
													// performing a full extract
	}

	public void setGetFoundRowsCount(boolean getFoundRowsCount) {
		this.getFoundRowsCount = getFoundRowsCount;
	}
}
