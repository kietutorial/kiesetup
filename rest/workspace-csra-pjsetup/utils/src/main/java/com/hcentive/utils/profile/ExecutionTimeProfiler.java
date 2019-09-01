package com.hcentive.utils.profile;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Anshu
 * 
 */

@Aspect
public class ExecutionTimeProfiler {

	@Pointcut("execution(* com.hcentive.eligibility.service..*(..)) || execution(* com.hcentive.eligibility.prescreening..*(..)) ||  execution(* com.hcentive.eligibility.navigation..*(..))")
	public void businessMethods() {
	}

	private static Logger logger = LoggerFactory.getLogger(ExecutionTimeProfiler.class);

	@Around("businessMethods()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		logger.info("Method [" + pjp.getSignature().getClass() + ":" + ((MethodSignature) pjp.getSignature()).getMethod()
				+ "] execution time: " + elapsedTime + " milliseconds.");
		// System.out.println("Method [" + pjp.getSignature().getClass() + ":" +
		// ((MethodSignature) pjp.getSignature()).getMethod() +
		// "] execution time: " + elapsedTime + " milliseconds.");
		return output;
	}

}