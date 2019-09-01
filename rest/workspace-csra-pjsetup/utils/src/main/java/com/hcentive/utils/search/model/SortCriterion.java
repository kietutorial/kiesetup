/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.model;

import java.io.Serializable;

public class SortCriterion implements Serializable {

	public static final String SORT_ORDER_ASC = "ASC";
	public static final String SORT_ORDER_DESC = "DESC";

	/**
	 * Name of the criterion. Typically the column name to sort by.
	 */
	private String name;

	/**
	 * Is this an ascending sort.
	 */
	private boolean ascendingOrder = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAscendingOrder() {
		return ascendingOrder;
	}

	public void setAscendingOrder(boolean ascendingOrder) {
		this.ascendingOrder = ascendingOrder;
	}
}
