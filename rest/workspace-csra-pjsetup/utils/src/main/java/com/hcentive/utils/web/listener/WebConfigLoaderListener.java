/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * The listener interface for receiving webConfigLoader events. The class that
 * is interested in processing a webConfigLoader event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's
 * <code>addWebConfigLoaderListener<code> method. When
 * the webConfigLoader event occurs, that object's appropriate
 * method is invoked.
 * 
 * @author ashish.jaiswal
 */
public class WebConfigLoaderListener implements ServletContextListener {

	/** The Constant CONFIG_PARAM_BEAN. */
	public static final String CONFIG_PARAM_BEAN = "webConfigParameters";

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(WebConfigLoaderListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		WebConfigParametersHolder configParameters = (WebConfigParametersHolder) ctx.getBean(CONFIG_PARAM_BEAN);
		if (configParameters == null) {
			logger.info("No bean named " + CONFIG_PARAM_BEAN + " is found in context");
			return;
		}
		Map<String, String> configParamMap = configParameters.getConfigParameterMap();
		for (String paramName : configParamMap.keySet()) {
			logger.info("Setting config parameter " + paramName + "=" + configParamMap.get(paramName));
			sce.getServletContext().setAttribute(paramName, configParamMap.get(paramName));
		}
	}
}
