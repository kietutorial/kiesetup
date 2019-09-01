/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * Configures PropertyPlaceholderConfigurer using a wildcard expression for all
 * config files packaged within the jar files and/or in the classpath. By
 * default loads all the properties file located in classpath at location
 * /META-INF/ and following a naming convention of *-config.properties. <br/>
 * <br/>
 * Also based on "environment" property it will additionally load all properties
 * file from the classpath from location <packagedConfigDir>/<environment> with
 * the same naming convention as specified by packagedConfigPath. These
 * environment properties will override default properties. Also there is a way
 * to specify a global property file which will override all properties (in case
 * of duplication) which practically should be located outside the application
 * at a file url or http-url.
 * 
 * @author ashish.jaiswal
 * @deprecated - Please use ExtendedPropertySourcesPlaceholderConfigurer
 */
@Deprecated
public final class PropertyConfigurator extends PropertyPlaceholderConfigurer implements InitializingBean {

	protected final static String DEFAULT_PACKAGED_CONFIG_PATH = "META-INF/*-config.properties";

	private String packagedConfigPath = DEFAULT_PACKAGED_CONFIG_PATH;

	private String environment;

	private Resource globalConfig;

	private Properties props = new Properties();

	@Override
	public void afterPropertiesSet() throws Exception {

		List<Resource> resources = new ArrayList<Resource>();

		Resource[] packagedResources = ClasspathDiscoveryUtils.resolveResource(packagedConfigPath);
		for (Resource res : packagedResources) {
			resources.add(res);
		}

		Resource[] envSpecificPackagedResources = null;
		if (StringUtils.isNotEmpty(environment)) {
			envSpecificPackagedResources = ClasspathDiscoveryUtils.resolveResource(getEnvConfigPath(environment));
			for (Resource res : envSpecificPackagedResources) {
				resources.add(res);
			}
		}

		if (globalConfig != null) {
			resources.add(globalConfig);
		}

		Resource[] locations = new Resource[resources.size()];
		locations = resources.toArray(locations);
		this.setLocations(locations);
		this.loadProperties(props);
	}

	private String getEnvConfigPath(String environment) {
		String configFolder = packagedConfigPath.substring(0, packagedConfigPath.lastIndexOf("/"));
		return configFolder + "/" + environment + packagedConfigPath.substring(packagedConfigPath.lastIndexOf("/"));
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public void setGlobalConfig(Resource globalConfig) {
		this.globalConfig = globalConfig;
	}

	public void setPackagedConfigPath(String packagedConfigPath) {
		this.packagedConfigPath = packagedConfigPath;
	}

	public String getPropertyValue(String key) {
		return props.getProperty(key);
	}
}
