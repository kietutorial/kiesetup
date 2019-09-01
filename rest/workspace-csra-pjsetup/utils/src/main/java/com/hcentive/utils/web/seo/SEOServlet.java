/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web.seo;

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

import com.hcentive.utils.seo.PropertiesBasedSEOConfigLoader;
import com.hcentive.utils.seo.SEOCodeGenerator;

/**
 * Servlet implementation class SEOMetaTagServlet.
 */
@SuppressWarnings("serial")
public class SEOServlet extends HttpServlet {

	/** The Constant logger. */
	public static final Log logger = LogFactory.getLog(SEOServlet.class);

	/** The Constant SEO_APPLICATION_ID. */
	protected static final String SEO_APPLICATION_ID = "seoApplicationId";

	/** The Constant SEO_PROPERTIES_FILE. */
	protected static final String SEO_PROPERTIES_FILE = "seoPropertiesFile";

	/** The application id. */
	protected static String applicationId;

	/** The seo properties file. */
	protected static String seoPropertiesFile;

	/** The seo code generator. */
	private SEOCodeGenerator seoCodeGenerator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SEOServlet.applicationId = config.getInitParameter(SEOServlet.SEO_APPLICATION_ID);
		if (StringUtils.isEmpty(SEOServlet.applicationId)) {
			logger.error("ApplicationId not provided for SEO configuration. SEO Configuration will not be loaded");
			throw new ServletException("ApplicationId not provided for SEO configuration. SEO Configuration will not be loaded");
		}

		SEOServlet.seoPropertiesFile = config.getInitParameter(SEOServlet.SEO_PROPERTIES_FILE);
		if (StringUtils.isEmpty(SEOServlet.seoPropertiesFile)) {
			logger.warn("SEO properties file name not defined as servlet init parameter. Trying to load default properties file");
			SEOServlet.seoPropertiesFile = "seo.properties";
		}

		seoCodeGenerator = createSEOCodeGenerator();
		if (logger.isInfoEnabled()) {
			logger.info("SEOCodeGenerator initialized.");
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
		outputSEOCode(request, response);
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
		outputSEOCode(request, response);
	}

	/**
	 * Output seo code.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	private void outputSEOCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageId = (String) request.getAttribute("pageId");
		String pageInstanceId = (String) request.getAttribute("pageInstanceId");
		PrintWriter out = response.getWriter();

		try {
			Map<String, Object> attMap = new HashMap<String, Object>();
			Enumeration<String> en = request.getAttributeNames();
			while (en.hasMoreElements()) {
				String key = en.nextElement();
				attMap.put(key, request.getAttribute(key));
			}
			out.print(seoCodeGenerator.getSEOCode(SEOServlet.applicationId, pageId, pageInstanceId, attMap));
		} catch (Exception e) {
			logger.error("Error fetching SEO code for pageId: " + pageId, e);
		}
	}

	/**
	 * Creates the seo code generator.
	 * 
	 * @return the sEO code generator
	 */
	private SEOCodeGenerator createSEOCodeGenerator() {
		PropertiesBasedSEOConfigLoader propSEOConfigLoader = new PropertiesBasedSEOConfigLoader();
		try {
			propSEOConfigLoader.setConfigFile(SEOServlet.seoPropertiesFile);
		} catch (IOException e) {
			logger.error("Unable to create SEOConfigLoader", e);
			throw new RuntimeException(e);
		}
		return new SEOCodeGenerator(propSEOConfigLoader);
	}
}
