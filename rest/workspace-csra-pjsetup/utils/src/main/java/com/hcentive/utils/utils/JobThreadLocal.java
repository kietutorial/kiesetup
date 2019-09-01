package com.hcentive.utils.utils;

import org.springframework.context.ApplicationContext;

public class JobThreadLocal {

	public static final ThreadLocal userThreadLocal = new ThreadLocal();

	public static void set(ApplicationContext applicationContext) {

		userThreadLocal.set(applicationContext);
	}

	public static ApplicationContext get() {
		return (ApplicationContext)userThreadLocal.get();
	}

}
