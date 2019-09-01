/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Anshu
 */
@Aspect
@Component
public class TraceAspect {

	@Value("${timetrace.enabled}")
	private Boolean isEnabled;

	@Around("@annotation(TraceTime)")
	public Object traceAdvice(ProceedingJoinPoint jp) throws Exception {

		Object result = null;
		final long startTime = System.currentTimeMillis();
		final long endTime;

		try {
			try {
				result = jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		} finally {
			endTime = System.currentTimeMillis();
			final long duration = endTime - startTime;
			if (isEnabled) {
				System.out.println("TraceAspect || Duration of method : " + jp.getSignature() + "::" + duration);
			}
		}
		return result;
	}
}
