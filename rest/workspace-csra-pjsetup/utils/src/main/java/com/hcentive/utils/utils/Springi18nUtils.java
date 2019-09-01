/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.junit.Assert;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Springi18nUtils supports the messageSource in Spring application contexts by
 * transparently providing access to i18n messages without requiring the handle
 * to the Spring application Context. Just define this bean in the spring
 * application context and use the static methods to obtain access to the
 * internationalized messages.
 * <p>
 * All the ResourceBundles which needs to be loaded must be placed in
 * /META-INF/*-bundle/ folder (can be configurd by spring injection) with bundle
 * property file following the naming convention of messages*.properties (ex.
 * messages.properties, messages_en_US.properties etc)
 * <p>
 * 
 * @author ashish.jaiswal
 */
public final class Springi18nUtils implements InitializingBean, ApplicationContextAware {

	public final String DEFAULT_MESSAGE_BUNDLE_WILDCARD = "META-INF/*-bundle/messages";

	private String messageBundle = DEFAULT_MESSAGE_BUNDLE_WILDCARD;

	private static ApplicationContext applicationContext;

	public static String getMessage(String code, Object[] args, Locale locale) {
		return getMessage(code, args, null, locale);
	}

	public static String getMessage(String code, Object[] args) {
		return getMessage(code, args, null, null);
	}

	public static String getMessage(String code, Object[] args, String defaultMessage) {
		return getMessage(code, args, defaultMessage, null);
	}

	public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		if (locale == null) {
			locale = Locale.getDefault();
		}
		return Springi18nUtils.applicationContext.getMessage(code, args, defaultMessage, locale);
	}

	public void setMessageBundle(String messageBundle) {
		this.messageBundle = messageBundle;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		Springi18nUtils.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.assertNotNull(Springi18nUtils.applicationContext);
		String[] baseNames = ClasspathDiscoveryUtils.resolveResourceNames(messageBundle + "*");
		// remove duplicates and collect all the basenames (without the trailing
		// underscores)
		Set<String> set = new HashSet<String>();
		for (String s : baseNames) {
			if (s.indexOf("_") != -1) {
				set.add(s.substring(0, s.indexOf("_")));
			} else {
				set.add(s);
			}
		}
		baseNames = set.toArray(new String[set.size()]);

		ResourceBundleMessageSource messageSource = (ResourceBundleMessageSource) Springi18nUtils.applicationContext
				.getBean("messageSource");
		messageSource.setBasenames(baseNames);
	}
}
