package com.csra.eligibility.process.member;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.runtime.manager.RuntimeManagerFactory;
import org.kie.api.runtime.process.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.entity.member.Member;
import com.csra.eligibility.domain.process.EligibilityMain;
import com.csra.eligibility.domain.rulefact.EligibilityResult;
import com.csra.eligibility.workflow.medicalincome.WFTestBase;
import com.csra.eligibility.workflow.medicalincome.WFTestData;

public class MBR_Income_Type_Determination extends WFTestBase {
	private final static Logger LOG = LoggerFactory.getLogger(MBR_Income_Type_Determination.class);

	protected void setKIERuntimeBuilder() {
		RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get().newEmptyBuilder()
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/member/MBR_Income_Type_Determination.bpmn2"),
						ResourceType.BPMN2)
				.get();

		manager = RuntimeManagerFactory.Factory.get().newSingletonRuntimeManager(environment);

		engine = manager.getRuntimeEngine(null);
	}

	protected void runFactEligibilityMember(EligibilityMain eligibilityMain, Member member,
			EligibilityResult eligibilityResult) {
		setFacts("eligibilityMain", eligibilityMain);
		setFacts("member", member);
		setFacts("eligibilityResult", eligibilityResult);

		runEligibility(engine, "MBR_Income_Type_Determination");
	}

	@Test
	public void newBornIsChip() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.getHouseHoldIncomeGreateThan50000();

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(member.isNewBorn(), true);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(member.getIncomeType(), "CHIP");

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void precheck_HouseHoldIncomeNotOverLimit() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.getHouseHoldIncomeZero();

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(eligibilityResult.getReason(), null);

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

}
