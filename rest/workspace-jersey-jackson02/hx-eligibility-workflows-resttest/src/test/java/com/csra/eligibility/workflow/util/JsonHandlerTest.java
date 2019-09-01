package com.csra.eligibility.workflow.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.eligibility.EligibilityResult;
import com.csra.eligibility.domain.entity.member.MemberFacts;

import junit.framework.Assert;

public class JsonHandlerTest {
	private final static Logger LOG = LoggerFactory.getLogger(JsonHandlerTest.class);

	@Test
	public void eligibilityResultToJson() {
		String datax = "EligibilityResult [indicators=\"1. INELIGIBLE:true\", reasons=\"1:FPLLEVEL-154, 2:3, 3:3-SCH_VERIFICATION_NOTICE\"]";

		String pjson = null;
		try {
			pjson = JsonHandler.pojoToJson(datax);
		} catch (JsonHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// LOG.info(pjson);
		Assert.assertEquals(pjson,
				"{\"EligibilityResult\": {\"indicators\":\"1. INELIGIBLE:true\",\"reasons\":\"1:FPLLEVEL-154, 2:3, 3:3-SCH_VERIFICATION_NOTICE\"}}");
	}

	@Test
	public void memberFactsResultToJson() {
		String datax = "MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false]";

		String pjson = null;
		try {
			pjson = JsonHandler.pojoToJson(datax);
		} catch (JsonHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// LOG.info(pjson);
		Assert.assertEquals(pjson,
				"{\"MemberFacts\": {\"stale\":\"true\",\"requestingFinanceHelp\":\"false\",\"newbornNoShow\":\"false\",\"renewalPeriodPast\":\"false\",\"epAptcClockExpired\":\"false\",\"fpl\":\"0.0\",\"maFplLevelforThisMember\":\"0.0\",\"irsFPL\":\"0.0\",\"lif\":\"0.0\",\"parentCareTaker\":\"false\",\"careTakerRelative\":\"false\"}}");
	}

	@Test
	public void getInvalidReasonFixed() {
		String datax = "EligbilityResult [Indicators=1. INELIGIBLE:true, reasons=1:3, 2:3-STALE_MEM]";

		String pjson = null;
		try {
			pjson = JsonHandler.pojoToJson(datax);
		} catch (JsonHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOG.info(pjson);
		Assert.assertEquals(pjson,
				"{\"EligbilityResult\": {\"indicators\":\"1. INELIGIBLE:true\",\"reasons\":\"1:3 2:3-STALE_MEM\",}}");
	}

	@Test
	public void getEligibilityResult() {
		String datax = "EligibilityResult [indicators=\"1. INELIGIBLE:true\", reasons=\"1:FPLLEVEL-154, 2:3, 3:3-SCH_VERIFICATION_NOTICE\"]";

		try {
			EligibilityResult eresult = JsonHandler.getEligibilityResult(datax);
			Assert.assertNotNull(eresult);
			Assert.assertEquals("1. INELIGIBLE:true", eresult.getIndicators());
		} catch (JsonHandlerException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void getMemberFacts() {
		String datax = "MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false]";

		try {
			MemberFacts mfacts = JsonHandler.getMemberFacts(datax);
			Assert.assertNotNull(mfacts);
			Assert.assertEquals(true, mfacts.isStale());
			Assert.assertEquals(false, mfacts.isRequestingFinanceHelp());
		} catch (JsonHandlerException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void getPojoStringFromJsonResponse() {
		String server_response = "{\"variable-instance\" : [ {\r\n" + "    \"name\" : \"memberFacts\",\r\n"
				+ "    \"old-value\" : \"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false, enrolledInMedcaidMEC=f\",\r\n"
				+ "    \"value\" : \"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false, enrolledInMedcaidMEC=f\",\r\n"
				+ "    \"process-instance-id\" : 458,\r\n" + "    \"modification-date\" : 1507320406736\r\n" + "  }\r\n]}";

		//LOG.info(server_response);
		String pjson = JsonHandler.getPojoStringFromJsonResponse(server_response);

		//LOG.info(pjson);
		Assert.assertEquals(pjson,
				"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false, enrolledInMedcaidMEC=f");
	}

}
