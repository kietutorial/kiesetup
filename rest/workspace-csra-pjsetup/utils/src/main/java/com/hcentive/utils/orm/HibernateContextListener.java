package com.hcentive.utils.orm;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernatePersistenceProviderResolver.register();

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
