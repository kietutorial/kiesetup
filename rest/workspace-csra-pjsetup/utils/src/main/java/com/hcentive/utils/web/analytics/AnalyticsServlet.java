/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.analytics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hcentive.utils.analytics.AnalyticsCodeGenerator;
import com.hcentive.utils.analytics.PropertiesBasedAnalyticsConfigLoader;

/**
 * Servlet implementation class AbstractAnalyticsServlet
 */
@SuppressWarnings("serial")
public class AnalyticsServlet extends HttpServlet {

	public static final Log logger = LogFactory.getLog(AnalyticsServlet.class);

	/** The Constant ANALYTICS_APPLICATION_ID. */
	protected static final String ANALYTICS_APPLICATION_ID = "analyticsApplicationId";

	/** The Constant ANALYTICS_PROPERTIES_FILE. */
	protected static final String ANALYTICS_PROPERTIES_FILE = "analyticsPropertiesFile";

	protected static String applicationId;

	protected static String analyticsPropertiesFile;

	private AnalyticsCodeGenerator analyticsCodeGenerator;

	private static final String ANALYTICS_TRACKER_ID = "trackerId";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		AnalyticsServlet.applicationId = "b2c-xchange";
		// applicationId = config.getInitParameter(ANALYTICS_APPLICATION_ID);
		if (StringUtils.isEmpty(AnalyticsServlet.applicationId)) {
			logger.error("ApplicationId not provided for Analytics configuration. Analytics Configuration will not be loaded");
			throw new ServletException(
					"ApplicationId not provided for Analytics configuration. Analytics Configuration will not be loaded");
		}

		AnalyticsServlet.analyticsPropertiesFile = config.getInitParameter(ANALYTICS_PROPERTIES_FILE);
		if (StringUtils.isEmpty(AnalyticsServlet.analyticsPropertiesFile)) {
			logger.warn("Analytics properties file name not defined as servlet init parameter. Trying to load default properties file");
			AnalyticsServlet.analyticsPropertiesFile = "analytics.properties";
		}

		analyticsCodeGenerator = createAnalyticsCodeGenerator();
		if (logger.isInfoEnabled()) {
			logger.info("AnalyticsCodeGenerator initialized.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		outputAnalyticsCode(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		outputAnalyticsCode(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private void outputAnalyticsCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageId = "Dummy";

		// String pageId = (String) request.getAttribute("pageId");
		/*
		 * if (StringUtils.isEmpty(pageId)) { if (logger.isInfoEnabled()) {
		 * logger .info(
		 * "PageId not provided for Analytics configuration. Analytics Configuration will not be loaded"
		 * ); } return; }
		 */

		PrintWriter out = response.getWriter();
		try {
			Map<String, Object> attMap = new HashMap<String, Object>();
			Enumeration<String> en = request.getAttributeNames();
			while (en.hasMoreElements()) {
				String key = en.nextElement();
				attMap.put(key, request.getAttribute(key).toString());
			}

			/*
			 * // Check if page is secure or not boolean isSecureAttributeSet =
			 * false; if (request.getAttribute("pageId.secure") != null) {
			 * isSecureAttributeSet = Boolean.valueOf((String) request
			 * .getAttribute("pageId.secure")); }
			 * 
			 * boolean isPageSecure = isSecureAttributeSet ||
			 * request.getScheme().matches(".*https.*");
			 */

			out.println(analyticsCodeGenerator.getAnalyticsCode(AnalyticsServlet.applicationId, pageId, attMap));
		} catch (Exception e) {
			logger.error("Error fetching Analytics code for pageId: " + pageId, e);
		}
	}

	/**
	 * Creates the Analytics config loader.
	 * 
	 * @param servletContext
	 *            the servlet context
	 * @return the Analytics config loader
	 */
	private AnalyticsCodeGenerator createAnalyticsCodeGenerator() {

		// get the trackerId from webConfigHolder
		String trackerId = (String) getServletContext().getAttribute(AnalyticsServlet.ANALYTICS_TRACKER_ID);
		logger.info("TrackerId from webConfig is: " + trackerId);

		PropertiesBasedAnalyticsConfigLoader propAnalyticsConfigLoader = new PropertiesBasedAnalyticsConfigLoader();
		try {
			propAnalyticsConfigLoader.setTrackerId(trackerId);
			propAnalyticsConfigLoader.setConfigFile(AnalyticsServlet.analyticsPropertiesFile);
		} catch (IOException e) {
			logger.error("Unable to create AnalyticsConfigLoader", e);
			throw new RuntimeException(e);
		}
		return new AnalyticsCodeGenerator(propAnalyticsConfigLoader);
	}
}
