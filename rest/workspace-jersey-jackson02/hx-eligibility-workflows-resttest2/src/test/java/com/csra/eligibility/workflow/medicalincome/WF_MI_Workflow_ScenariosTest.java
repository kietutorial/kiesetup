package com.csra.eligibility.workflow.medicalincome;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.workflow.processing.WorkFlowProcessing;
import com.sun.jersey.api.client.ClientResponse;

public class WF_MI_Workflow_ScenariosTest {
	private final static Logger LOG = LoggerFactory.getLogger(WF_MI_Workflow_ScenariosTest.class);
	private static String processid;

	@Test
	public void staleMember() {
		try {
			String uri = RestTestHelper.BASE_URI + "/processes/MI_Main/instances/";
			StringBuilder bldmemberfacts = new StringBuilder();
			String requestbody = "{\r\n" + "	\"memberFacts\": \r\n" + "	{\r\n"
					+ "		\"com.csra.eligibility.domain.entity.member.MemberFacts\": {\r\n"
					+ "			\"stale\": \"true\",\r\n" + "			\"houseHoldIncome\": \"55000\",\r\n"
					+ "			\"age\": \"55\"\r\n" + "		}\r\n" + "	}\r\n" + "}";

			ClientResponse response = RestTestHelper.postClientRequest(uri, requestbody);
			processid = response.getEntity(String.class);

			String output = RestTestHelper.getProcessVariables(processid);
			// LOG.info(output);

			WorkFlowProcessing workFlowProcessing = RestTestHelper.getWorkFlowProcessing(LOG, output);
			Assert.assertNotNull(workFlowProcessing);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void notRequestingFinancialAssistance() {
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

			String output = RestTestHelper.getProcessVariables(processid);
			// LOG.info(output);

			WorkFlowProcessing workFlowProcessing = RestTestHelper.getWorkFlowProcessing(LOG, output);
			Assert.assertNotNull(workFlowProcessing);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void eligibleMember() {
		try {
			String uri = RestTestHelper.BASE_URI + "/processes/MI_Main/instances/";
			String requestbody = "{\r\n" + "	\"memberFacts\": \r\n" + "	{\r\n"
					+ "		\"com.csra.eligibility.domain.entity.member.MemberFacts\": {\r\n"
					+ "			\"houseHoldIncome\":\"15000\",\r\n" + "			\"age\":\"18\",\r\n"
					+ "			\"lif\":\" 25000\",\r\n" + "			\"pregnant\":\"true\",\r\n"
					+ "			\"requestingFinanceHelp\":\"true\",\r\n"
					+ "			\"proposedEligibility\":\"true\",\r\n"
					+ "			\"incomeVerificationComplete\":\"true\",\r\n"
					+ "			\"compitableIncomeSourcesAvailable\":\"true\",\r\n"
					+ "			\"useCurrentIncome\":\"true\",\r\n"
					+ "			\"currentIncomeVerificationNoticeSent\":\"true\"\r\n" + "		}\r\n" + "	}\r\n"
					+ "}";

			ClientResponse response = RestTestHelper.postClientRequest(uri, requestbody);
			processid = response.getEntity(String.class);

			String output = RestTestHelper.getProcessVariables(processid);
			// LOG.info(output);

			WorkFlowProcessing workFlowProcessing = RestTestHelper.getWorkFlowProcessing(LOG, output);
			Assert.assertNotNull(workFlowProcessing);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void pendingMember() {
		try {
			String uri = RestTestHelper.BASE_URI + "/processes/MI_Main/instances/";
			String requestbody = "{\r\n" + "	\"memberFacts\": \r\n" + "	{\r\n"
					+ "		\"com.csra.eligibility.domain.entity.member.MemberFacts\": {\r\n"
					+ "			\"houseHoldIncome\":\"15000\",\r\n" + "			\"age\":\"18\",\r\n"
					+ "			\"lif\":\" 25000\",\r\n" + "			\"requestingFinanceHelp\":\"true\",\r\n"
					+ "			\"proposedEligibility\":\"true\",\r\n"
					+ "			\"incomeVerificationComplete\":\"true\",\r\n"
					+ "			\"compitableIncomeSourcesAvailable\":\"true\",\r\n"
					+ "			\"useCurrentIncome\":\"true\",\r\n"
					+ "			\"currentIncomeVerificationNoticeSent\":\"true\"\r\n" + "		}\r\n" + "	}\r\n"
					+ "}		\r\n" + "";

			ClientResponse response = RestTestHelper.postClientRequest(uri, requestbody);
			processid = response.getEntity(String.class);

			String output = RestTestHelper.getProcessVariables(processid);
			// LOG.info(output);

			WorkFlowProcessing workFlowProcessing = RestTestHelper.getWorkFlowProcessing(LOG, output);
			Assert.assertNotNull(workFlowProcessing);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void inEligibleMember() {
		try {
			String uri = RestTestHelper.BASE_URI + "/processes/MI_Main/instances/";
			String requestbody = "{\r\n" + "	\"memberFacts\": \r\n" + "	{\r\n"
					+ "		\"com.csra.eligibility.domain.entity.member.MemberFacts\": {\r\n"
					+ "			\"houseHoldIncome\":\"15000\",\r\n" + "			\"age\":\"18\",\r\n"
					+ "			\"lif\":\" 25000\",\r\n" + "			\"requestingFinanceHelp\":\"true\",\r\n"
					+ "			\"proposedEligibility\":\"true\",\r\n"
					+ "			\"incomeVerificationComplete\":\"true\",\r\n"
					+ "			\"compitableIncomeSourcesAvailable\":\"true\",\r\n"
					+ "			\"currentIncomeVerificationNoticeSent\":\"true\"\r\n" + "		}\r\n" + "	}\r\n"
					+ "}";

			ClientResponse response = RestTestHelper.postClientRequest(uri, requestbody);
			processid = response.getEntity(String.class);

			String output = RestTestHelper.getProcessVariables(processid);
			// LOG.info(output);

			WorkFlowProcessing workFlowProcessing = RestTestHelper.getWorkFlowProcessing(LOG, output);
			Assert.assertNotNull(workFlowProcessing);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
