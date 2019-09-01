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

public class MBR_Income_Type_Compatibility extends WFTestBase {
	private final static Logger LOG = LoggerFactory.getLogger(MBR_Income_Type_Compatibility.class);

	protected void setKIERuntimeBuilder() {
		RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get().newEmptyBuilder()
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/member/MBR_Income_Type_Compatibility.bpmn2"),
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

		runEligibility(engine, "MBR_Income_Type_Compatibility");
	}

	@Test
	public void newBornHighIncome() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.getNewBornIncomeGreaterThan50000();

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(member.isNewBorn(), true);
		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(eligibilityResult.getReason(), "Newborn HouseHold Income Incompatability");

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void newBornLowIncome() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.getNewBornIncome10000();

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(member.isNewBorn(), true);
		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(eligibilityMain.isFplComparedToMedicaidLevel(), true);

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

	@Test
	public void AnyonelowIncome() {
		EligibilityMain eligibilityMain = new EligibilityMain();
		EligibilityResult eligibilityResult = new EligibilityResult();
		Member member = WFTestData.basicMember();
		// Go back 30 years
		Calendar date = Calendar.getInstance();
		int year = (365) * 30;
		date.add(Calendar.DAY_OF_YEAR, -year);

		// LOG.info("Date: " + date.getTime());

		member.setDob(date.getTime());
		// Low income
		member.setHouseHoldIncome(10000);

		runFactEligibilityMember(eligibilityMain, member, eligibilityResult);

		assertEquals(ProcessInstance.STATE_COMPLETED, processInstance.getState());
		assertEquals(eligibilityMain.isFplComparedToMedicaidLevel(), true);

		manager.disposeRuntimeEngine(engine);
		manager.close();
	}

}
