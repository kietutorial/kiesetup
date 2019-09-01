package com.csra.log;

import org.junit.Test;
import org.junit.runner.RunWith;
`import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/eligibilityRules-test-beans.xml" })
public class TestTest {
	private static Logger LOG = LoggerFactory.getLogger(TestTest.class);

	@Test
	public void logShow() {
		LOG.info("xxxxxxxxxxx");
		LOG.debug("xxxxxxxxxxx");
		LOG.warn("xxxxxxxxxxx");
		LOG.error("xxxxxxxxxxx");
	}

}
