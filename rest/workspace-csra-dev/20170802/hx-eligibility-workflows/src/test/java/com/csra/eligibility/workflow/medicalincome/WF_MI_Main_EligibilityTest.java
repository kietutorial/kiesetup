package com.csra.eligibility.workflow.medicalincome;

import org.junit.Test;
import org.kie.api.runtime.process.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.entity.member.Member;
import com.csra.eligibility.domain.process.EligibilityMain;
import com.csra.eligibility.doman.rulefact.EligibilityResult;

public class WF_MI_Main_EligibilityTest extends WFTestBase {
	private final static Logger LOG = LoggerFactory.getLogger(WF_MI_Main_EligibilityTest.class);

	@Test
	public void eligibilitIsStale() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		eligibilityMain.setPreCheckStale(true);

		EligibilityResult eligibilityResult = new EligibilityResult();

		runFactEligibilityMember(eligibilityMain, null, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(eligibilityResult.getReason(), "Is Stale");

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void preCheckIncomeExceeded() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		Member member = WFTestData.getHouseHoldIncomeGreateThan50000();
		EligibilityResult eligibilityResult = new EligibilityResult();

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(eligibilityResult.getReason(), "HouseHold Income Over Limit");

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void memberNewBorn() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		Member member = WFTestData.getNewBorn();
		EligibilityResult eligibilityResult = new EligibilityResult();

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

}
