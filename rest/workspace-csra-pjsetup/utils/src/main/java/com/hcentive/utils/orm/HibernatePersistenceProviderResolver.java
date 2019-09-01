package com.hcentive.utils.orm;

import java.util.Collections;
import java.util.List;

import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolver;
import javax.persistence.spi.PersistenceProviderResolverHolder;

import org.hibernate.ejb.HibernatePersistence;

public class HibernatePersistenceProviderResolver implements PersistenceProviderResolver {

	private volatile PersistenceProvider persistenceProvider = new HibernatePersistence();

	public List<PersistenceProvider> getPersistenceProviders() {
		return Collections.singletonList(persistenceProvider);
	}

	public void clearCachedProviders() {
		persistenceProvider = new HibernatePersistence();
	}

	public static void register() {
		PersistenceProviderResolverHolder.setPersistenceProviderResolver(new HibernatePersistenceProviderResolver());
	}
}
