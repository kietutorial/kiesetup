package com.csra.eligibility.workflow.medicalincome;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.eligibility.EligibilityResult;
import com.csra.eligibility.domain.entity.member.MemberFacts;
import com.csra.eligibility.workflow.processing.WorkFlowProcessing;
import com.csra.eligibility.workflow.util.JsonHandler;
import com.csra.eligibility.workflow.util.JsonHandlerException;
import com.sun.jersey.api.client.ClientResponse;

public class WF_MI_WorkFlow_MostRecentPojoTest {
	private final static Logger LOG = LoggerFactory.getLogger(WF_MI_WorkFlow_MostRecentPojoTest.class);
	private static String processid;

	@Test
	public void getCompleted_TaskVariables_MemberFacts() {
		try {
			String uri = RestTestHelper.QUERY_URI + "processes/instances/" + RestTestHelper.getProcessid(processid)
					+ "/variables/instances/memberFacts";
			ClientResponse response = RestTestHelper.getClientRequest(uri);
			String output = response.getEntity(String.class);
			// LOG.info(output);
			Assert.assertNotNull(output);

			String result = JsonHandler.getMostRecentPojoFromJsonArray(output);
			// LOG.info(result);
			Assert.assertEquals(
					"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false]",
					result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getCompletedTask_Variable_EligibilityResult() {
		try {
			String uri = RestTestHelper.QUERY_URI + "processes/instances/" + RestTestHelper.getProcessid(processid)
					+ "/variables/instances/eligibilityResult";
			ClientResponse response = RestTestHelper.getClientRequest(uri);
			String output = response.getEntity(String.class);
			// LOG.info(output);
			Assert.assertNotNull(output);

			String result = JsonHandler.getMostRecentPojoFromJsonArray(output);
			// LOG.info(result);
			Assert.assertEquals("EligbilityResult [Indicators=1. INELIGIBLE:true, reasons=1:3]", result);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
