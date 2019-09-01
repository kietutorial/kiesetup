package com.droolsexample.basicproject;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import com.droolsexample.util.KnowledgeSessionHelper;
import com.droolsexample.util.OutputDisplay;

public class FancyHelloRuleTest {
	static KieContainer kieContainer;
	StatelessKieSession sessionStateless = null;
	KieSession sessionStatefull = null;

	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	@Test
	public void sayHello() {
		try {
			sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
			OutputDisplay outputDisplay = new OutputDisplay();
			sessionStatefull.setGlobal("showResults", outputDisplay);
			
			FancyHello hello = new FancyHello();
			sessionStatefull.insert(hello);
			sessionStatefull.fireAllRules();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}