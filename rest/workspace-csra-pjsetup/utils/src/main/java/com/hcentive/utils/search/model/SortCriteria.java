/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.search.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SortCriteria implements Serializable {

	private List<SortCriterion> sortCriteria;

	public SortCriteria(SortCriterion sortCriterion) {
		if (sortCriteria == null) {
			sortCriteria = new ArrayList<SortCriterion>();
		}
		sortCriteria.add(sortCriterion);
	}

	public SortCriteria(List<SortCriterion> sortCriteria) {
		this.sortCriteria = sortCriteria;
	}

	public List<SortCriterion> getSortCriteria() {
		return sortCriteria;
	}

	public void setSortCriteria(List<SortCriterion> sortCriteria) {
		this.sortCriteria = sortCriteria;
	}

	// Convenience functions for quickly accessing a particular sort criterion.
	public int size() {
		return sortCriteria.size();
	}

	public SortCriterion get(int index) {
		return sortCriteria.get(index);
	}

	public String getName(int index) {
		return get(index).getName();
	}

	public boolean isAscendingOrder(int index) {
		return get(index).isAscendingOrder();
	}
}
