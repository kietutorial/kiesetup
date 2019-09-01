/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.dms;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcentive.utils.utils.ExtendedPropertySourcesPlaceholderConfigurer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:com/hcentive/core/utils/ExtendedPropertySourcesPlaceholderConfigurer.xml" })
public class ExtendedPropertySourcesPlaceholderConfigurerTest {

	@Autowired
	protected ExtendedPropertySourcesPlaceholderConfigurer propertyConfigurator;

	@Value(value = "${property_1}")
	String sampleProperty1;

	@Value(value = "${property_2}")
	String sampleProperty2;

	@Test
	public void test() {
		Assert.assertEquals("a", sampleProperty1);
		Assert.assertEquals("b_old", sampleProperty2);
	}

}
