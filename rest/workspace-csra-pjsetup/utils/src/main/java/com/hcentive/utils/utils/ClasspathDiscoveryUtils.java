/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.util.Hashtable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author ashish.jaiswal
 */
public class ClasspathDiscoveryUtils {

	private static Logger logger = LoggerFactory.getLogger(ClasspathDiscoveryUtils.class);

	protected static Map<String, Class<?>> discoveredClasses = new Hashtable<String, Class<?>>();

	public static String[] resolveResourceNames(String wildcard) throws Exception {
		Resource[] r = resolveResource(wildcard);
		String[] s = new String[r.length];
		int i = 0;
		String prefix = wildcard.substring(0, wildcard.indexOf("*"));
		for (Resource a : r) {
			String y = a.getURL().getFile();
			s[i++] = y.substring(y.lastIndexOf(prefix), y.length());
		}
		return s;
	}

	public static Resource[] resolveResource(String wildcard) throws Exception {
		PathMatchingResourcePatternResolver x = new PathMatchingResourcePatternResolver();
		return x.getResources("classpath*:" + wildcard);
	}

	public static Class<?> obtainFullyQualifiedClass(String classShortName, String basePackage) {
		String actualClassName = classShortName.substring(0, 1).toUpperCase() + classShortName.substring(1);
		if (!discoveredClasses.containsKey(actualClassName)) {
			String fullyQualifiedClassName = discoverClass(actualClassName, basePackage);
			if (fullyQualifiedClassName == null) {
				throw new RuntimeException("Cannot discover class " + classShortName + " in package " + basePackage);
			}
			try {
				discoveredClasses.put(actualClassName, Class.forName(fullyQualifiedClassName));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Class " + fullyQualifiedClassName + "not found.");
			}
		}
		return discoveredClasses.get(actualClassName);
	}

	public static String discoverClass(String unqualifiedName, String startFrom) {
		return discoverResource(unqualifiedName, startFrom, "class");
	}

	public static String discoverResource(String unqualifiedName, String startFrom) {
		return discoverResource(unqualifiedName, startFrom, "");
	}

	public static String discoverResource(String unqualifiedName, String startFrom, String extension) {
		try {
			extension = extension == null ? "" : "." + extension;
			startFrom = startFrom.replaceAll("\\.", "/");
			PathMatchingResourcePatternResolver x = new PathMatchingResourcePatternResolver();
			Resource[] r = x.getResources("classpath*:" + startFrom + "/**/" + unqualifiedName + extension);
			for (Resource a : r) {
				String y = a.getURL().getFile();
				y = y.substring(y.lastIndexOf(startFrom), y.length() - extension.length());
				return y.replaceAll("/", ".");
			}

		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return null;
	}
}
