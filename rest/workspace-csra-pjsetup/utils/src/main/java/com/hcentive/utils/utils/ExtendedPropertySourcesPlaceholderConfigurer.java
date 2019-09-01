/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * Add a custom feature in PropertySourcesPlaceholderConfigurer to optionally
 * provide a ResourcePropertySource which takes precedence on locally defined
 * property sources.
 * 
 * @author ashishjaiswal
 * 
 */
public class ExtendedPropertySourcesPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer implements InitializingBean,
		ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	Logger logger = LoggerFactory.getLogger(ExtendedPropertySourcesPlaceholderConfigurer.class);

	private Resource overridingSource;

	public void setOverridingSource(Resource overridingSource) {
		this.overridingSource = overridingSource;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		MutablePropertySources sources = ((ConfigurableApplicationContext) applicationContext).getEnvironment()
				.getPropertySources();
		if (overridingSource == null) {
			return;
		}
		logger.debug("********************URL OF FILE RESOURCE******************\n");

		logger.debug(overridingSource.getURL().toString());
		logger.debug(overridingSource.getURI().toString());
		System.out.println(overridingSource.getURL().toString());
		System.out.println(overridingSource.getURI().toString());
		
		sources.addFirst(new ResourcePropertySource(overridingSource));
	}
}
