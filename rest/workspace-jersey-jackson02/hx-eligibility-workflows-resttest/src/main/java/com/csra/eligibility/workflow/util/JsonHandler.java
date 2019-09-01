package com.csra.eligibility.workflow.util;

import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.eligibility.EligibilityResult;
import com.csra.eligibility.domain.entity.member.MemberFacts;

public class JsonHandler {
	private final static Logger LOG = LoggerFactory.getLogger(JsonHandler.class);

	/**
	 * Convert a pojo string representation to Json format<br>
	 * Provide pojo string format as: EligbilityResult [Indicators=1.
	 * INELIGIBLE:true, reasons=1:3, 2:3-STALE_MEM]<br>
	 * Return: {EligibilityResult: {"indicators":"1.
	 * INELIGIBLE:true","reasons":"1:FPLLEVEL-154, 2:3,
	 * 3:3-SCH_VERIFICATION_NOTICE"})
	 * 
	 * @param pojostr
	 * @param classname
	 * @return
	 * @throws JsonHandlerException
	 */
	public static String pojoToJson(String pojostr) throws JsonHandlerException {
		// Get pojo name
		String classname;

		StringBuilder bldel;
		try {
			classname = pojostr.substring(0, pojostr.indexOf("[")).trim();
			// Remove pojo name
			pojostr = pojostr.replace(classname, "");
			pojostr = pojostr.replace("[", "").replace("]", "");
			// Create json representation of elements
			String[] elements = pojostr.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			bldel = new StringBuilder();

			// We may have missed entries.
			// If so, combine entries with no = with prior value
			StringBuilder badentries = new StringBuilder();
			for (int k = elements.length - 1; k >= 0; k--) {
				if (!elements[k].contains("=")) {
					badentries.append(elements[k]);
					elements[k] = "";
				} else {
					if (badentries.length() > 0) {
						elements[k] = elements[k] + badentries.toString();
						badentries = new StringBuilder();
					}
				}
			}

			int j = 0;
			for (String el : elements) {
				if (el.trim().isEmpty())
					continue;

					//For pojo creation, first char shoul be lowercase
				StringBuffer strbuf = new StringBuffer(el.trim());
				char c1 = Character.toLowerCase(strbuf.charAt(0));
				strbuf.setCharAt(0, c1);
				el = strbuf.toString();
				
				if (el.contains("\"")) {
					el = "\"" + el.trim().replace("=", "\":");
				} else {
					el = "\"" + el.trim().replace("=", "\":\"") + "\"";
				}
			
				
				if (j < elements.length - 1)
					bldel.append(el + ",");
				else
					bldel.append(el);

				j++;
			}
		} catch (Exception e) {
			throw new JsonHandlerException(e.getMessage());
		}

		return "{\"" + classname + "\": {" + bldel.toString() + "}}";
	}

	public static EligibilityResult getEligibilityResult(String pojostr) throws JsonHandlerException {
		EligibilityResult eligibilityResult = null;

		try {
			String pojoname = pojostr.substring(0, pojostr.indexOf("[")).trim();
			String jstring = pojoToJson(pojostr);
			//LOG.info("jstring: " + jstring);

			// Get pojo json object string representation
			JSONObject jobject = new JSONObject(jstring);
			String pjson = jobject.get(pojoname).toString();

			ObjectMapper mapper = new ObjectMapper();
			eligibilityResult = mapper.readValue(pjson, EligibilityResult.class);
		} catch (Exception e) {
			throw new JsonHandlerException(e.getMessage());
		}

		return eligibilityResult;
	}

	public static MemberFacts getMemberFacts(String pojostr) throws JsonHandlerException {
		MemberFacts memberFacts = null;

		try {
			String pojoname = pojostr.substring(0, pojostr.indexOf("[")).trim();
			String jstring = pojoToJson(pojostr);

			// Get pojo json object string representation
			JSONObject jobject = new JSONObject(jstring);
			String pjson = jobject.get(pojoname).toString();
			//LOG.info("pjson: " + pjson);

			ObjectMapper mapper = new ObjectMapper();
			memberFacts = mapper.readValue(pjson, MemberFacts.class);
		} catch (Exception e) {
			throw new JsonHandlerException(e.getMessage());
		}

		return memberFacts;
	}
	
	public static String getPojoStringFromJsonResponse(String output) {
		JSONObject jobject = new JSONObject(output);
		JSONArray arrays = jobject.optJSONArray("variable-instance");
		//LOG.info("" + arrays.length());

		jobject = (JSONObject) arrays.get(0);
		//LOG.info(jobject.toString());

		String elgstr = (String) jobject.get("value");
		//LOG.info(elgstr);
		
		return elgstr;
	}


	/***
	 * The server returns variables with all changed values. Get the most recent.
	 * 
	 * @param response
	 */
	public static String getMostRecentPojoFromJsonArray(String response) {
		String recentPojo = null;
		
		JSONObject jobject = new JSONObject(response);
		JSONArray arrays = jobject.optJSONArray("variable-instance");
		//LOG.info("" + arrays.length());

		String maxpojo = null;
		long pmodate = 0;
		for (Object obj : arrays) {
			String jdata = obj.toString();
			//LOG.info("" + jdata);
			long imodate = 0;

			jobject = new JSONObject(jdata);
			Object moddate = jobject.get("modification-date");
			if (moddate != null) {
				try {
					imodate = Long.parseLong(moddate.toString());
					//LOG.info("" + imodate);
					if (imodate > pmodate) {
						maxpojo = jdata;
						pmodate = imodate;
					}
				} catch (Exception e) {
					//LOG.error(e.getMessage(), e);
				}
			}
		}

		if (maxpojo != null) {
			//LOG.info(pmodate + ": " + maxpojo);
			Object omdata = jobject.get("value");
			//LOG.info("" + omdata);
			
			recentPojo = omdata.toString();
			if(!recentPojo.endsWith(",")) {
				recentPojo =  recentPojo.substring(0, recentPojo.lastIndexOf(",")) + "]";
			}
			
			//LOG.info(recentPojo);
		}
		
		return recentPojo;
	}

}
