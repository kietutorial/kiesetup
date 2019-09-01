/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.navigation;

/**
 * Default implementation of NavigationHandler
 * 
 * @author Anshu
 */
@Deprecated
public class DefaultNavigationHandler extends NavigationHandler {

	@Override
	public NavigationData getNextNavigation(NavigationData navigationData) {
		int currentIndex = navigationSections.indexOf(navigationData.getCurrent_section());
		if (currentIndex == navigationSections.size()) {

		} else {
			navigationSections.get(currentIndex + 1);
		}
		return navigationData;
	}

	@Override
	public NavigationData getPreviousNavigation(NavigationData navigationData) {
		int currentIndex = navigationSections.indexOf(navigationData.getCurrent_section());
		if (currentIndex == 0) {
			return null;
		}
		navigationSections.get(currentIndex - 1);
		return navigationData;
	}

	@Override
	public NavigationData initializeNavigationData() {
		return new NavigationData();
	}
}
