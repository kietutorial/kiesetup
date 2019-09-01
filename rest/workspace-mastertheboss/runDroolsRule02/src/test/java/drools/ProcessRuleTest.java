package drools;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;

import com.sample.Account;

public class ProcessRuleTest {

	@Test
	public void nullAccount() {
		RuntimeEngine engine = setKIERuntime();

		Map<String, Object> params = new HashMap<String, Object>();

		runProcess(engine, params);
	}

	@Test
	public void emptyAccount() {
		RuntimeEngine engine = setKIERuntime();

		Account account = new Account();
		Map<String, Object> params = setFacts(account);

		runProcess(engine, params);
	}

	@Test
	public void withAccount() {
		RuntimeEngine engine = setKIERuntime();

		Account account = new Account();
		account.setName("user1");
		
		Map<String, Object> params = setFacts(account);

		runRule(engine, params, account);
	}

	@Test
	public void withInvalidAccount() {
		RuntimeEngine engine = setKIERuntime();

		Account account = new Account();
		account.setName("userbad");
		
		Map<String, Object> params = setFacts(account);

		runRule(engine, params, account);
	}

	@Test
	public void updateAccount() {
		RuntimeEngine engine = setKIERuntime();

		Account account = new Account();
		account.setName("xudpate");
		account.setMoney(50);
		
		System.out.println("Bef: " + account);
		Map<String, Object> params = setFacts(account);

		runRule(engine, params, account);	
		System.out.println("After : " + account);
	}

	private void runProcess(RuntimeEngine engine, Map<String, Object> params) {
		KieSession kSession = engine.getKieSession();
		kSession.startProcess("demo.test", params);

		//int fired = kSession.fireAllRules();
		//System.out.println("Number of Rules executed = " + fired);
	}

	private void runRule(RuntimeEngine engine, Map<String, Object> params, Object fact) {
		KieSession kSession = engine.getKieSession();
		
			//Insert fact for rule processing
		kSession.insert(fact);

		kSession.startProcess("demo.test", params);
		
		int fired = kSession.fireAllRules();		
		System.out.println("Number of Rules executed = " + fired);
	}

	private Map<String, Object> setFacts(Account account) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", account);
		
		return params;
	}

	private RuntimeEngine setKIERuntime() {
		RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get().newEmptyBuilder()
				.addAsset(KieServices.Factory.get().getResources().newClassPathResource("com/sample/test.bpmn2"),
						ResourceType.BPMN2)
				.addAsset(KieServices.Factory.get().getResources().newClassPathResource("com/sample/rule.drl"),
						ResourceType.DRL)
				.get();
		RuntimeManager manager = RuntimeManagerFactory.Factory.get().newSingletonRuntimeManager(environment);
		RuntimeEngine engine = manager.getRuntimeEngine(null);
		return engine;
	}

}
