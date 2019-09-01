/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

/**
 * Factory to return a transformer corresponding to an XSL StyleSheet.
 * 
 * @author anshu
 */
public class XSLTransformerFactory {

	/** This method returns the Transformer corresonding to an XSL. */

	static TransformerFactory transFact;

	/**
	 * Gets the xSL transformer.
	 * 
	 * @param xslPath
	 *            the xsl path
	 * @return the xSL transformer
	 * @throws TransformerConfigurationException
	 *             the transformer configuration exception
	 */
	public static Transformer getXSLTransformer(String xslPath) throws TransformerConfigurationException {

		StreamSource stylesource = getXSLSource(xslPath);
		return transFact.newTransformer(stylesource);
	}

	/**
	 * Gets the xSL source.
	 * 
	 * @param xslPath
	 *            the xsl path
	 * @return the xSL source
	 */
	public static StreamSource getXSLSource(String xslPath) {
		if (xslPath == null || xslPath.equals("")) {
			return null;
		}
		transFact = TransformerFactory.newInstance();
		File stylesheet = new File(xslPath);
		StreamSource stylesource = new StreamSource(stylesheet);
		return stylesource;
	}
}
