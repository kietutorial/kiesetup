/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.navigation;

/**
 * NavigationData class can be extended to add specific information such as
 * members etc
 * 
 * @author Anshu
 * 
 */
public class NavigationData {
	protected String current_section;
	protected String current_page;
	boolean isNavigationCompleted;

	public NavigationData() {

	}

	public String getCurrent_section() {
		return current_section;
	}

	public void setCurrent_section(String current_section) {
		this.current_section = current_section;
	}

	public String getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(String current_page) {
		this.current_page = current_page;
	}

	public boolean isNavigationCompleted() {
		return isNavigationCompleted;
	}

	public void setNavigationCompleted(boolean isNavigationCompleted) {
		this.isNavigationCompleted = isNavigationCompleted;
	}

}
