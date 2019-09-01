package com.csra.eligibility.workflow.processing;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.eligibility.EligibilityResult;
import com.csra.eligibility.domain.entity.member.MemberFacts;
import com.csra.eligibility.workflow.util.JsonHandler;
import com.csra.eligibility.workflow.util.JsonHandlerException;

public class WorkFlowProcessing {
	private final static Logger LOG = LoggerFactory.getLogger(WorkFlowProcessing.class);
	private String jsonArrayMemberFacts;
	private MemberFacts memberFacts;
	private String jsonArrayEligibility;
	private EligibilityResult eligibilityResult;

	public WorkFlowProcessing() {
	}

	public void process(String response) {
		// LOG.info(response);
		JSONObject jobject = new JSONObject(response);
		JSONArray arrays = jobject.optJSONArray("variable-instance");
		// LOG.info("" + arrays.length());

		try {
			jsonArrayMemberFacts = getMemberFactJasonArray(arrays);
			// LOG.info(jsonArrayMemberFacts);

			String result = JsonHandler.getMostRecentPojoFromJsonArray(jsonArrayMemberFacts);
			// LOG.info(result);

			memberFacts = JsonHandler.getMemberFacts(result);
			//LOG.info(memberFacts.toString());
		} catch (JsonHandlerException e) {
			e.printStackTrace();
		}

		try {
			jsonArrayEligibility = getEligibilityResultJasonArray(arrays);
			// LOG.info(jsonArrayEligibility);

			String result = JsonHandler.getMostRecentPojoFromJsonArray(jsonArrayEligibility);
			// LOG.info(result);

			eligibilityResult = JsonHandler.getEligibilityResult(result);
			//LOG.info(eligibilityResult.toString());
		} catch (JsonHandlerException e) {
			e.printStackTrace();
		}
	}

	private String getMemberFactJasonArray(JSONArray arrays) {
		List<String> listMemberFacts = new ArrayList<String>();
		for (Object obj : arrays) {
			String jdata = obj.toString();
			// LOG.info("" + jdata);
			if (jdata.contains("MemberFacts"))
				listMemberFacts.add(jdata);
		}

		StringBuilder jsonarray = new StringBuilder();
		jsonarray.append("{\"variable-instance\": [");
		for (String data : listMemberFacts)
			jsonarray.append(data);
		jsonarray.append("]}");

		return jsonarray.toString();
	}

	private String getEligibilityResultJasonArray(JSONArray arrays) {
		// Create a separate list for MemberFacts and EligibilitResult
		List<String> listEligibilityResult = new ArrayList<String>();
		for (Object obj : arrays) {
			String jdata = obj.toString();
			// LOG.info("" + jdata);
			if (jdata.contains("eligibilityResult"))
				listEligibilityResult.add(jdata);
		}

		StringBuilder jsonarray = new StringBuilder();
		jsonarray.append("{\"variable-instance\": [");
		for (String data : listEligibilityResult)
			jsonarray.append(data);
		jsonarray.append("]}");

		return jsonarray.toString();
	}

	public String getJsonArrayMemberFacts() {
		return jsonArrayMemberFacts;
	}

	public MemberFacts getMemberFacts() {
		return memberFacts;
	}

	public String getJsonArrayEligibility() {
		return jsonArrayEligibility;
	}

	public EligibilityResult getEligibilityResult() {
		return eligibilityResult;
	}

}
