package com.csra.eligibility.process.member;

import java.util.Calendar;

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

public class MBR_FPL_Level_DeterminationTest extends WFTestBase {
	private final static Logger LOG = LoggerFactory.getLogger(MBR_FPL_Level_DeterminationTest.class);

	protected void setKIERuntimeBuilder() {
		RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get().newEmptyBuilder()
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/member/MBR_FPL_Level_Determination.bpmn2"),
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

		runEligibility(engine, "MBR_FPL_Level_Determination");
	}

	@Test
	public void memberChipLowIncome() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.basicMember();
		// Go back 20 years
		Calendar date = Calendar.getInstance();
		int year = (365) * 20;
		date.add(Calendar.DAY_OF_YEAR, -year);

		member.setDob(date.getTime());
		member.setHouseHoldIncome(12000);
		member.setIncomeType("CHIP");

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(true, eligibilityMain.isFplComparedToMedicaidLevel());

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void memberChipMidIncome() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.basicMember();
		// Go back 20 years
		Calendar date = Calendar.getInstance();
		int year = (365) * 20;
		date.add(Calendar.DAY_OF_YEAR, -year);

		member.setDob(date.getTime());
		member.setHouseHoldIncome(15000);
		member.setIncomeType("CHIP");

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(false, eligibilityMain.isFplComparedToMedicaidLevel());

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void memberHighIncome() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.basicMember();
		// Go back 20 years
		Calendar date = Calendar.getInstance();
		int year = (365) * 20;
		date.add(Calendar.DAY_OF_YEAR, -year);

		member.setDob(date.getTime());
		member.setHouseHoldIncome(9000);

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(true, eligibilityMain.isFplComparedToMedicaidLevel());

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

}
