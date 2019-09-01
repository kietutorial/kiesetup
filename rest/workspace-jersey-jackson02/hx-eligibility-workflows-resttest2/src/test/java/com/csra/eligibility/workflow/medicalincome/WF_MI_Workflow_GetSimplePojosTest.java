package com.csra.eligibility.workflow.medicalincome;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.eligibility.EligibilityResult;
import com.csra.eligibility.domain.entity.member.MemberFacts;
import com.csra.eligibility.workflow.util.JsonHandler;
import com.csra.eligibility.workflow.util.JsonHandlerException;
import com.sun.jersey.api.client.ClientResponse;

public class WF_MI_Workflow_GetSimplePojosTest {
	private final static Logger LOG = LoggerFactory.getLogger(WF_MI_Workflow_GetSimplePojosTest.class);

	@Test
	public void getCompletedTask_Variable_EligibilityResult() {
		try {
			String processid = "458";
			EligibilityResult eresult = RestTestHelper.getFinalEligibilityResult(processid);
			//LOG.info(eresult.toString());

			Assert.assertNotNull(eresult);
			Assert.assertEquals("1. INELIGIBLE:true", eresult.getIndicators());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void getCompletedTask_Variable_MemberFacts() {
		try {
			String processid = "458";
			MemberFacts mfacts = RestTestHelper.getFinalMemberFacts(processid);
			//LOG.info(mfacts.toString());
			
			Assert.assertNotNull(mfacts);
			Assert.assertEquals(true, mfacts.isStale());
			Assert.assertEquals(false, mfacts.isRequestingFinanceHelp());
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
