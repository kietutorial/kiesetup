package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ProcessMain {

	public static void main(String[] args) throws Exception {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession();
		Account account = new Account();

		kSession.insert(account);
		kSession.startProcess("demo.test");
		int fired = kSession.fireAllRules();
		System.out.println("Number of Rules executed = " + fired);
	}

}
