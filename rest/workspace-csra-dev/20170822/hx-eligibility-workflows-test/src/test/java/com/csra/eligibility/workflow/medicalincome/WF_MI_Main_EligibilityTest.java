package com.csra.eligibility.workflow.medicalincome;

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

public class WF_MI_Main_EligibilityTest extends WFTestBase {
	private final static Logger LOG = LoggerFactory.getLogger(WF_MI_Main_EligibilityTest.class);

	protected RuntimeEnvironment getRuntimeEnvironment() {
		RuntimeEnvironmentBuilder runtimeEnvironmentBuilder = RuntimeEnvironmentBuilder.Factory.get().newEmptyBuilder();

		// **************************
		// Main Workflow Processes
		// **************************
		runtimeEnvironmentBuilder
				.addAsset(KieServices.Factory.get().getResources().newClassPathResource(
						"com/csra/eligibility/process/medicaidincome/MI_Main.bpmn2"), ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/MI_MainSub_DetermineCoverageCode.bpmn2"),
						ResourceType.BPMN2);

		// *************
		// Member Rules and Processes
		// *************
		runtimeEnvironmentBuilder
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/member/MBR_Precheck_Household_Income.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/member/MBR_Income_Type_Determination.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/member/MBR_Income_Type_Compatibility.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/member/MBR_FPL_Level_Determination.bpmn2"),
						ResourceType.BPMN2);

		RuntimeEnvironment environment = runtimeEnvironmentBuilder.get();

		return environment;
	}

	protected void setKIERuntimeBuilder() {
		RuntimeEnvironment environment = getRuntimeEnvironment();

		manager = RuntimeManagerFactory.Factory.get().newSingletonRuntimeManager(environment);

		engine = manager.getRuntimeEngine(null);
	}

	protected void runFactEligibilityMember(EligibilityMain eligibilityMain, Member member,
			EligibilityResult eligibilityResult) {
		setFacts("eligibilityMain", eligibilityMain);
		setFacts("member", member);
		setFacts("eligibilityResult", eligibilityResult);

		runEligibility(engine, "MI_Main");
	}

	@Test
	public void eligibilitIsStale() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		eligibilityMain.setPreCheckStale(true);
		EligibilityResult eligibilityResult = new EligibilityResult();

		// Processing did a pre-check to flag information is stale
		eligibilityMain.setPreCheckStale(true);

		Member member = WFTestData.basicMember();

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals("Is Stale", eligibilityResult.getReason());

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void preCheckIncomeExceeded() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.getHouseHoldIncomeGreateThan50000();

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals("HouseHold Income Over Limit", eligibilityResult.getReason());

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
		assertEquals(false, eligibilityResult.isEligibleStatus());

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void nonChipMemberIncome16000() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();

		Member member = WFTestData.basicMember();
		Calendar date = Calendar.getInstance();
		// Go back 50 years
		int year = (365) * 50;
		date.add(Calendar.DAY_OF_YEAR, -year);
		member.setDob(date.getTime());
		// Low income
		member.setHouseHoldIncome(16000);

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(false, eligibilityResult.isEligibleStatus());

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void eligibleMember() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();

		// Member is pregnant and clock
		eligibilityMain.setPregnant(true);
		eligibilityMain.setClockScheduled(true);

		Member member = WFTestData.basicMember();
		Calendar date = Calendar.getInstance();
		// Go back 5 years
		int year = (365) * 25;
		date.add(Calendar.DAY_OF_YEAR, -year);
		member.setDob(date.getTime());
		// Low income
		member.setHouseHoldIncome(12000);

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(false, eligibilityResult.isEligibleStatus());

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

}
