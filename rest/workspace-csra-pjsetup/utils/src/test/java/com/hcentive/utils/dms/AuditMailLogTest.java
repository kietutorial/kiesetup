/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.dms;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcentive.utils.notification.EmailMessage;
import com.hcentive.utils.notification.Notifier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/log-test.xml" })
public class AuditMailLogTest {

	// private static Logger log =
	// LoggerFactory.getLogger(AuditMailLogTest.class);

	public static final String Event_ResetAdminUser = "resetAdminUser";

	@Autowired
	private Notifier emailNotifierUtility;

	@Test
	public void testAuditLog() {
		System.out.println("Hello world");
		// System.out.println("emailNotifierUtility:"+ emailNotifierUtility);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subject", "test");
		paramMap.put("email", "rahul.niranjan.2010@gmail.com");
		paramMap.put("token", "test");

		EmailMessage email = new EmailMessage("rahul.niranjan.2010@gmail.com", paramMap);
		emailNotifierUtility.notify(Event_ResetAdminUser, email);
	}

	public void setEmailNotifierUtility(Notifier emailNotifierUtility) {
		this.emailNotifierUtility = emailNotifierUtility;
	}
}
