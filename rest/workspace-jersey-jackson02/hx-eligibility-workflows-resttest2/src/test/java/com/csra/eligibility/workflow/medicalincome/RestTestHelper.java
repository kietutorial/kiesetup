package com.csra.eligibility.workflow.medicalincome;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.eligibility.EligibilityResult;
import com.csra.eligibility.domain.entity.member.MemberFacts;
import com.csra.eligibility.workflow.processing.WorkFlowProcessing;
import com.csra.eligibility.workflow.util.JsonHandler;
import com.csra.eligibility.workflow.util.JsonHandlerException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class RestTestHelper {
	public static final String BASE_URI = "http://localhost:9080/kie-server/services/rest/server/containers/hx-eligibility-workflows_1.0.2";
	public static final String QUERY_URI = "http://localhost:9080/kie-server/services/rest/server/queries/";
	public static final HTTPBasicAuthFilter AUTHENTIFICATION = (new HTTPBasicAuthFilter("pchauvet", "pchauvet"));

	public static Client getClient(HTTPBasicAuthFilter authentif) {
		Client client = Client.create();
		client.addFilter(authentif);
		return client;
	}

	public static ClientResponse getClientRequest(String uri) {
		Client client = getClient(AUTHENTIFICATION);
		WebResource webResource = client.resource(uri);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		return response;
	}

	public static String getProcessid(String processid) {
		if (processid == null)
			processid = "458";

		return processid;
	}

	public static ClientResponse postClientRequest(String uri, String memberfacts) {
		Client client = getClient(AUTHENTIFICATION);
		WebResource webResource = client.resource(uri);
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, memberfacts);
		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		return response;
	}

	public static EligibilityResult getEligibilityResult(String processid) throws JsonHandlerException {
		String uri;
		ClientResponse response;
		uri = RestTestHelper.QUERY_URI + "processes/instances/" + processid + "/variables/instances/eligibilityResult";
		response = RestTestHelper.getClientRequest(uri);
		String output = response.getEntity(String.class);
		String elgstr = JsonHandler.getPojoStringFromJsonResponse(output);
		// LOG.info("elgstr : " + elgstr);

		EligibilityResult eresult = JsonHandler.getEligibilityResult(elgstr);

		return eresult;
	}

	public static EligibilityResult getFinalEligibilityResult(String processid) throws JsonHandlerException {
		String uri = RestTestHelper.QUERY_URI + "processes/instances/" + processid
				+ "/variables/instances/eligibilityResult";
		ClientResponse response = RestTestHelper.getClientRequest(uri);

		String output = response.getEntity(String.class);
		String elgstr = JsonHandler.getPojoStringFromJsonResponse(output);
		// LOG.info("elgstr : " + elgstr);

		EligibilityResult eresult = JsonHandler.getEligibilityResult(elgstr);

		return eresult;
	}

	public static MemberFacts getFinalMemberFacts(String processid) throws JsonHandlerException {
		String uri = RestTestHelper.QUERY_URI + "processes/instances/" + processid + "/variables/instances/memberFacts";
		ClientResponse response = RestTestHelper.getClientRequest(uri);

		String output = response.getEntity(String.class);
		// LOG.info(output);

		String elgstr = JsonHandler.getPojoStringFromJsonResponse(output);
		// LOG.info("elgstr: " + elgstr);

		String datga = elgstr;
		if (!datga.endsWith(",")) {
			datga = datga.substring(0, datga.lastIndexOf(",")) + "]";
		}
		// LOG.info(datga);

		MemberFacts mfacts = JsonHandler.getMemberFacts(datga);

		return mfacts;
	}

	public static String getProcessVariables(String processid) throws JsonHandlerException {
		String uri = RestTestHelper.QUERY_URI + "processes/instances/" + processid + "/variables/instances";
		ClientResponse response = RestTestHelper.getClientRequest(uri);
		String output = response.getEntity(String.class);

		return output;
	}

	public static WorkFlowProcessing getWorkFlowProcessing(Logger log, String response) throws JsonHandlerException {
		WorkFlowProcessing workFlowProcessing = new WorkFlowProcessing();
		workFlowProcessing.process(response);

		log.info(workFlowProcessing.getJsonArrayMemberFacts());
		log.info(workFlowProcessing.getJsonArrayEligibility());
		log.info(workFlowProcessing.getEligibilityResult().toString());
		log.info(workFlowProcessing.getMemberFacts().toString());

		return workFlowProcessing;
	}

}
