package com.sample;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;

public class ProcessMain {

	public static void main(String[] args) throws Exception {
		RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get().newEmptyBuilder()
				.addAsset(KieServices.Factory.get().getResources().newClassPathResource("com/sample/test.bpmn2"),
						ResourceType.BPMN2)
				.get();
		RuntimeManager manager = RuntimeManagerFactory.Factory.get().newSingletonRuntimeManager(environment);
		RuntimeEngine engine = manager.getRuntimeEngine(null);
		
		Map<String, Object> params = new HashMap<String, Object>();
		Account account = new Account();
		params.put("account", account);
		
		KieSession kSession = engine.getKieSession();
		kSession.startProcess("demo.test", params);
				
		int fired = kSession.fireAllRules();
		System.out.println("Number of Rules executed = " + fired);
	}

	private RuntimeEngine setKIERuntime() {
		RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory.get().newEmptyBuilder()
				.addAsset(KieServices.Factory.get().getResources().newClassPathResource("com/sample/test.bpmn2"),
						ResourceType.BPMN2)
				.get();
		RuntimeManager manager = RuntimeManagerFactory.Factory.get().newSingletonRuntimeManager(environment);
		RuntimeEngine engine = manager.getRuntimeEngine(null);
		return engine;
	}

}
