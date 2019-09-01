/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.navigation;

import java.util.List;

/**
 * Interface to handle custom navigation for any section, needs to be
 * implemented for custom Navigation services
 * 
 * @author Anshu
 * 
 */

public abstract class NavigationHandler {

	/**
	 * List to be provided by the navigationService
	 */
	protected List<String> navigationSections;

	public abstract NavigationData getNextNavigation(NavigationData navigationData);

	public abstract NavigationData getPreviousNavigation(NavigationData navigationData);

	public abstract NavigationData initializeNavigationData();

}
