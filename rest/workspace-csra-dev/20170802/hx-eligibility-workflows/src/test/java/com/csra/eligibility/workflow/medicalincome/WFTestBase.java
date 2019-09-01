package com.csra.eligibility.workflow.medicalincome;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jbpm.test.JbpmJUnitBaseTestCase;
import org.junit.Before;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;
import org.kie.api.runtime.process.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csra.eligibility.domain.entity.member.Member;
import com.csra.eligibility.domain.process.EligibilityMain;
import com.csra.eligibility.doman.rulefact.EligibilityResult;

/**
 * Base set up for testing workflows
 * 
 * @author pchauvet
 *
 * @param <T>
 *            Workflow type used while testing. Ex: EligibilityMain process
 *            flow.
 */
public class WFTestBase<T> extends JbpmJUnitBaseTestCase {
	private final static Logger LOG = LoggerFactory.getLogger(WFTestBase.class);
	protected RuntimeManager manager;
	protected RuntimeEngine engine;
	private Map<String, Object> params = new HashMap<String, Object>();
	protected ProcessInstance processInstance;

	@Before
	public void setUpKIERuntime() {
		setKIERuntimeBuilder();
		// setKIERuntimeMap();
	}

	protected void setKIERuntimeBuilder() {
		RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get().newEmptyBuilder()
				.addAsset(KieServices.Factory.get().getResources().newClassPathResource(
						"com/csra/eligibility/process/medicaidincome/MI_Main.bpmn2"), ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/MI_MainSub_Ineligibility.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/MI_MainSub_IncomeTypeDetermination.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/MI_MainSub_FPLLevelDetermination.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/MI_MainSub_DetermineCoverageCode.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/MI_MainSub_DetermineAidCategory.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/MI_MainSub_CheckIncomeReasonableCompatability.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/rules/eligibility_prechecks.drl"),
						ResourceType.DRL)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/rules/eligibility_incometype_determination.drl"),
						ResourceType.DRL)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/rules/eligibility_fpllevel_determination.drl"),
						ResourceType.DRL)
				.addAsset(
						KieServices.Factory.get().getResources().newClassPathResource(
								"com/csra/eligibility/process/medicaidincome/rules/eligibility_checkincomereasonablecompatability.drl"),
						ResourceType.DRL)
				.get();

		manager = RuntimeManagerFactory.Factory.get().newSingletonRuntimeManager(environment);

		engine = manager.getRuntimeEngine(null);
	}

	private void setFacts(String name, Object t) {
		if (name != null && t != null) {
			params.put(name, t);
			// LOG.info("Added fact (" + name + ")");
		}
	}

	public void runFactEligibilityMember(EligibilityMain eligibilityMain, Member member,
			EligibilityResult eligibilityResult) {
		setFacts("eligibilityMain", eligibilityMain);
		setFacts("member", member);
		setFacts("eligibilityResult", eligibilityResult);

		runEligibility(engine, "MI_Main");
	}

	public void runEligibility(RuntimeEngine engine, T t, String process) {
		KieSession ksession = engine.getKieSession();

		LOG.info("Fact: " + t.getClass().getSimpleName() + ": " + t);
		LOG.info("---------------------------------\n");

		ksession.startProcess(process, params);

		// System.out.println();
		// LOG.info("Completed Processing\n");
	}

	public void runEligibility(RuntimeEngine engine, String process) {
		KieSession ksession = engine.getKieSession();

		// showFacts();
		insertFacts(ksession);

		// Capture the JBPM Executing process model
		processInstance = ksession.startProcess(process, params);
		ksession.fireAllRules();

		// System.out.println();
		// LOG.info("Completed Processing\n");
	}

	/**
	 * Insert facts for rule process
	 * 
	 * Todo: This is how I can facts to the rules for now
	 */
	private void insertFacts(KieSession ksession) {
		Set<String> names = params.keySet();
		if (names.size() > 0) {
			for (String name : names) {
				Object t = params.get(name);

				ksession.insert(t);
			}
		}
	}

	private void showFacts() {
		Set<String> names = params.keySet();
		int j = 1;
		if (names.size() > 0) {
			LOG.info("Facts: ");
			for (String name : names) {
				Object t = params.get(name);
				LOG.info((j++) + ": " + t.getClass().getSimpleName() + ": " + t);
			}
		}
		LOG.info("---------------------------------\n");
	}

	protected RuntimeManager getManager() {
		return manager;
	}

	protected void setManager(RuntimeManager manager) {
		this.manager = manager;
	}

	protected RuntimeEngine getEngine() {
		return engine;
	}

	protected void setEngine(RuntimeEngine engine) {
		this.engine = engine;
	}

	protected ProcessInstance getProcessInstance() {
		return processInstance;
	}

}
