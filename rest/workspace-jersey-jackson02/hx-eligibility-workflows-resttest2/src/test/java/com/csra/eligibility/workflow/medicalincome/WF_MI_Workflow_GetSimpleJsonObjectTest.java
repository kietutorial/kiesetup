package com.csra.eligibility.workflow.medicalincome;

import static org.junit.Assert.fail;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WF_MI_Workflow_GetSimpleJsonObjectTest {
	private final static Logger LOG = LoggerFactory.getLogger(WF_MI_Workflow_GetSimpleJsonObjectTest.class);
	private String processid;

	@Test
	public void getContainers() {
		try {
			ClientResponse response = RestTestHelper.getClientRequest(RestTestHelper.BASE_URI);

			String output = response.getEntity(String.class);
			// LOG.info(output);
			Assert.assertTrue(output.contains("container hx-eligibility-workflows_1.0.2"));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getProcesses() {
		try {
			String uri = RestTestHelper.BASE_URI + "/processes";
			ClientResponse response = RestTestHelper.getClientRequest(uri);

			String output = response.getEntity(String.class);
			// LOG.info(output);
			Assert.assertNotNull(output);
			JSONObject object = new JSONObject(output);
			JSONArray arrays = object.optJSONArray("processes");
			Assert.assertEquals(8, arrays.length());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void startMIMainTask() {
		try {
			String uri = RestTestHelper.BASE_URI + "/processes/MI_Main/instances/";
			StringBuilder bldmemberfacts = new StringBuilder();
			bldmemberfacts.append("{\r\n");
			bldmemberfacts.append("\"memberFacts\": \r\n");
			bldmemberfacts.append("		{\r\n");
			bldmemberfacts.append("			\"com.csra.eligibility.domain.entity.member.MemberFacts\": {\r\n");
			bldmemberfacts.append("				\"houseHoldIncome\": \"55000\",\r\n");
			bldmemberfacts.append("				\"age\": \"55\"\r\n");
			bldmemberfacts.append("			}\r\n");
			bldmemberfacts.append("		}\r\n");
			bldmemberfacts.append("}\r\n");

			ClientResponse response = RestTestHelper.postClientRequest(uri, bldmemberfacts.toString());
			processid = response.getEntity(String.class);

			// LOG.info(processid);
			Assert.assertNotNull(processid);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getCompletedTaskVariables() {
		try {
			String uri = RestTestHelper.QUERY_URI + "processes/instances/" + RestTestHelper.getProcessid(processid)
					+ "/variables/instances";
			ClientResponse response = RestTestHelper.getClientRequest(uri);
			String output = response.getEntity(String.class);

			LOG.info(output);
			Assert.assertNotNull(output);
			Assert.assertTrue(output.contains("MemberFacts ["));
			Assert.assertTrue(output.contains("EligbilityResult ["));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getCompletedTask_Variable_MemberFacts() {
		try {
			String uri = RestTestHelper.QUERY_URI + "processes/instances/" + RestTestHelper.getProcessid(processid)
					+ "/variables/instances/memberFacts";
			ClientResponse response = RestTestHelper.getClientRequest(uri);

			String output = response.getEntity(String.class);
			// LOG.info(output);
			Assert.assertNotNull(output);
			Assert.assertTrue(output.contains("MemberFacts ["));
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
			Assert.assertTrue(output.contains("EligbilityResult ["));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
