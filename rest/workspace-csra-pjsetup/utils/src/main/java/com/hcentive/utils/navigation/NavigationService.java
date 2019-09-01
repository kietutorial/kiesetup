/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.navigation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * Abstract NavigationService
 * 
 * @author Anshu
 */
public class NavigationService implements InitializingBean {

	/**
	 * override the module name from the bean
	 */
	protected static final String NAV_MODULE = "defaultNavigationModule";

	protected List<String> navigationSections;
	protected Map<String, NavigationHandler> navigationHandlerMap;
	protected String navigationModule = NAV_MODULE;
	protected NavigationHandler defaultNavigationHandler;

	public List<String> getNavigationSections() {
		return navigationSections;
	}

	public void setNavigationSections(List<String> navigationSections) {
		this.navigationSections = navigationSections;
	}

	public Map<String, NavigationHandler> getNavigationHandlerMap() {
		return navigationHandlerMap;
	}

	public void setNavigationHandlerMap(Map<String, NavigationHandler> navigationHandlerMap) {
		this.navigationHandlerMap = navigationHandlerMap;
	}

	public String getNavigationModule() {
		return navigationModule;
	}

	public void setNavigationModule(String navigationModule) {
		this.navigationModule = navigationModule;
	}

	public NavigationHandler getDefaultNavigationHandler() {
		return defaultNavigationHandler;
	}

	public void setDefaultNavigationHandler(NavigationHandler defaultNavigationHandler) {
		this.defaultNavigationHandler = defaultNavigationHandler;
	}

	public void getNextSection(NavigationData navigationData) {
		String currentSection = navigationData.getCurrent_section();
		if (null == currentSection || currentSection.isEmpty()) {
			currentSection = navigationSections.get(0);
		}
		navigationData.setCurrent_section(currentSection);
		while (!navigationData.isNavigationCompleted()) {
			if (navigationHandlerMap != null && navigationHandlerMap.containsKey(navigationData.getCurrent_section())) {
				NavigationHandler navigationHandler = navigationHandlerMap.get(navigationData.getCurrent_section());
				navigationHandler.getNextNavigation(navigationData);
			} else {
				defaultNavigationHandler.getNextNavigation(navigationData);
			}
		}
		// return navigationData.getCurrent_page();
	}

	public void getPreviousSection(NavigationData navigationData) {
		// String currentSection = navigationData.getCurrent_section();
		while (!navigationData.isNavigationCompleted()) {
			if (navigationHandlerMap != null && navigationHandlerMap.containsKey(navigationData.getCurrent_section())) {
				NavigationHandler navigationHandler = navigationHandlerMap.get(navigationData.getCurrent_section());
				navigationHandler.getPreviousNavigation(navigationData);
			} else {
				defaultNavigationHandler.getPreviousNavigation(navigationData);
			}
		}
		// return navigationData.getCurrent_page();
	}

	public NavigationData initializeNavigation() {
		return defaultNavigationHandler.initializeNavigationData();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(navigationSections, "NavigationSections cannot be null");
	}
}
