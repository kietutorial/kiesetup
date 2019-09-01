package com.csra.eligibility.workflow.medicalincome;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.workflow.processing.WorkFlowProcessing;
import com.csra.eligibility.workflow.util.JsonHandlerException;

public class WorkFlowProcessingTest {
	private final static Logger LOG = LoggerFactory.getLogger(WorkFlowProcessingTest.class);
	private static String processid;

	@Test
	public void workFlowProcessing() {
		String response = "{\r\n" + "  \"variable-instance\" : [ {\r\n" + "    \"name\" : \"initiator\",\r\n"
				+ "    \"old-value\" : \"\",\r\n" + "    \"value\" : \"pchauvet\",\r\n"
				+ "    \"process-instance-id\" : 458,\r\n" + "    \"modification-date\" : 1507320406715\r\n"
				+ "  }, {\r\n" + "    \"name\" : \"memberFacts\",\r\n"
				+ "    \"old-value\" : \"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false, enrolledInMedcaidMEC=f\",\r\n"
				+ "    \"value\" : \"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false, enrolledInMedcaidMEC=f\",\r\n"
				+ "    \"process-instance-id\" : 458,\r\n" + "    \"modification-date\" : 1507320406736\r\n"
				+ "  }, {\r\n" + "    \"name\" : \"eligibilityResult\",\r\n" + "    \"old-value\" : \"\",\r\n"
				+ "    \"value\" : \"EligbilityResult [Indicators=1. INELIGIBLE:true, reasons=1:3, 2:3-STALE_MEM]\",\r\n"
				+ "    \"process-instance-id\" : 458,\r\n" + "    \"modification-date\" : 1507320406737\r\n"
				+ "  } ]\r\n" + "}";

		WorkFlowProcessing workFlowProcessing = new WorkFlowProcessing();
		workFlowProcessing.process(response);

		// LOG.info(workFlowProcessing.getJsonArrayMemberFacts());
		// LOG.info(workFlowProcessing.getJsonArrayEligibility());
		// LOG.info(workFlowProcessing.getEligibilityResult().toString());
		// LOG.info(workFlowProcessing.getMemberFacts().toString());

		Assert.assertEquals(
				"{\"variable-instance\": [{\"name\":\"memberFacts\",\"process-instance-id\":458,\"modification-date\":1507320406736,\"old-value\":\"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false, enrolledInMedcaidMEC=f\",\"value\":\"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false, enrolledInMedcaidMEC=f\"}]}",
				workFlowProcessing.getJsonArrayMemberFacts());
		Assert.assertEquals(
				"{\"variable-instance\": [{\"name\":\"eligibilityResult\",\"process-instance-id\":458,\"modification-date\":1507320406737,\"old-value\":\"\",\"value\":\"EligbilityResult [Indicators=1. INELIGIBLE:true, reasons=1:3, 2:3-STALE_MEM]\"}]}",
				workFlowProcessing.getJsonArrayEligibility());
		Assert.assertEquals("EligbilityResult [Indicators=1. INELIGIBLE:true, reasons=1:3]",
				workFlowProcessing.getEligibilityResult().toString());
		Assert.assertEquals(
				"MemberFacts [stale=true, requestingFinanceHelp=false, newbornNoShow=false, renewalPeriodPast=false, epAptcClockExpired=false, fpl=0.0, maFplLevelforThisMember=0.0, irsFPL=0.0, lif=0.0, parentCareTaker=false, careTakerRelative=false, enrolledInMedcaidMEC=false, allMECInfoEntered=false, proposedRun=false, proposedEligibility=false, lsc=false, lscInLastThreeMonths=false, standardIncomeInPrevElg=false, dtfIncomeInPrevElg=false, irsIncomeInPrevElg=false, noIncomeInPrevElg=false, pregnant=false, residualPrucolY=false, maDeemedNB=false, incomeVerifeid=false, compitableIncomeSourcesAvailable=false, incomeOnlyFromUIB=false, incomeReasonblyCompitable=false, incomeReasonblyCompitable10=false, dtfIncomeAtMALevel=false, zeroHHIncome=false, currentMonthIncomeToBeUsed=false, incomeVerificationNoticeSent=false, incomeClockExpired=false, incomeClockCode41=false, currentIncomeVerificationNoticeSent=false, currentIncomeClockExpired=false, ffsOnlyIndicator=false, undoc=false, hxRestrictedY=false, incomeClockSheduled=false, medicaidIncomeClockSheduled=false, medicaidAliessaInd=false, hasChildDependent=false, parent=false, livingWithParentOrCaretaker=false, currentlyInMedicaid=false, renewalDueUpcomingMonth=false, ineligible=false, eligible=false, pending=false, firstName=null, lastName=null, fullName=null, dob=null, age=0, incomeType=null, houseHoldIncome=0.0, previousStandard=false, previousDataSource=false, previousNoIncome=false, incomeVerificationComplete=false, dsIncomeAtMALevel=false, useCurrentIncome=false, nonCompilanceIndator=false, lifIndicator=false, lifDate=null]",
				workFlowProcessing.getMemberFacts().toString());
	}

	@Test
	public void queryProcessVariables() {
		String processid = "458";

		try {
			String response = RestTestHelper.getProcessVariables(processid);
			LOG.info(response);

			RestTestHelper.getWorkFlowProcessing(LOG, response);
		} catch (JsonHandlerException e) {
			fail(e.getMessage());
		}
	}

}
