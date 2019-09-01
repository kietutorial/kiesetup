/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/*
 * Copyright 2011 hCentive Inc.
 */
package com.hcentive.utils.web.spring.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hcentive.utils.web.action.BaseController;

/**
 * The Class MethodInvokerInterceptor.
 */
public class MethodInvokerInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(MethodInvokerInterceptor.class);
	
	/** The methods to invoke. */
	private List<String> methodsToInvoke;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		Object controllerBean = ((HandlerMethod) handler).getBean();
		if (controllerBean instanceof BaseController) {
			BaseController controller = (BaseController) controllerBean;
			for (String method : methodsToInvoke) {
				try {
					Method methodToInvoke = null;
					try {
						methodToInvoke = controller.getClass().getMethod(method, new Class[] { HttpServletRequest.class });
					} catch (NoSuchMethodException e) {
						logger.info("EXCEPTION", e);
					}

					if (methodToInvoke != null) {
						methodToInvoke.invoke(controller, request);
					}
				} catch (RuntimeException e) {
					logger.error("EXCEPTION", e);
				}
			}
		}
		return true;
	}

	/**
	 * Gets the methods to invoke.
	 * 
	 * @return the methods to invoke
	 */
	public List<String> getMethodsToInvoke() {
		return methodsToInvoke;
	}

	/**
	 * Sets the methods to invoke.
	 * 
	 * @param methodsToInvoke
	 *            the new methods to invoke
	 */
	public void setMethodsToInvoke(List<String> methodsToInvoke) {
		this.methodsToInvoke = methodsToInvoke;
	}
}
