package com.hcentive.utils;

import java.text.MessageFormat;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcentive.utils.utils.JdbcMessageSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/spring-i18n-test.xml" })
public class JdbcMessageSourceTest {

	@Autowired
	private ApplicationContext applicationContext;

	JdbcMessageSource jdbcMessageResource;

	private static Logger logger = LoggerFactory.getLogger(JdbcMessageSourceTest.class);

	@Before
	public void setUp() {
		jdbcMessageResource = (JdbcMessageSource) applicationContext.getBean("messageSource");
	}

	@Test
	/**
	 * To retrieve message by key and locale - en_US,en_CA
	 */
	public void testGetMessageByKeyFromCache() {
		Locale locale = Locale.CANADA;
		String key = "label.addEmployer.yourEmployeeCode";
		MessageFormat msg;

		try {
			msg = jdbcMessageResource.resolveCode(key, locale);
			logger.info("Value returned is : " + msg.toPattern());
			Assert.assertEquals("Your Employee Code is:", msg.toPattern());

		} catch (Exception e) {
			logger.error("Exception: ", e);
			Assert.fail();
		}
	}

	@Test
	/**
	 * To retrieve message by key
	 */
	public void testGetMessageByKeyFromDB() {
		Locale locale = Locale.US;
		String key = "label.addEmployer.yourEmployeeCode111";
		MessageFormat msg;

		try {
			msg = jdbcMessageResource.resolveCode(key, locale);
			Assert.assertNull("Your Employee Code is:", msg);

		} catch (Exception e) {
			logger.error("Exception: ", e);
			Assert.fail();
		}
	}

	@Test
	/**
	 * To retrieve message by key and locale - en_US,en_CA
	 */
	public void testResolveCodeInternal() {
		Locale locale = Locale.CANADA;
		String key = "label.addEmployer.yourEmployeeCode123";
		MessageFormat msg;

		try {
			msg = jdbcMessageResource.resolveCodeInternal(key, locale);
			logger.info("Value returned is : " + msg.toPattern());
			Assert.assertEquals("Your Employee Code is:", msg.toPattern());

		} catch (Exception e) {
			logger.error("Exception: ", e);
			Assert.fail();
		}
	}

}