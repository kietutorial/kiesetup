/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.orm.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hcentive.utils.orm.dao.GenericDAO;

/**
 * The Class CrudServiceImpl.
 */
@Transactional
public class CrudServiceImpl<T extends Serializable> implements CrudService<T> {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CrudServiceImpl.class);

	/** The generic dao. */
	protected GenericDAO<T> genericDao;

	/**
	 * Sets the generic dao.
	 * 
	 * @param genericDao
	 *            the new generic dao
	 */
	public void setGenericDao(GenericDAO<T> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public T create(T persistable) {
		if (persistable == null) {
			throw new IllegalArgumentException("Cannot persist a Null entity");
		}
		preCreate(persistable);
		genericDao.create(persistable);
		postCreate(persistable);
		return persistable;
	}

	@Override
	@Transactional(readOnly = true)
	public T retrieve(Class<T> klass, Serializable id) {
		if (logger.isDebugEnabled()) {
			logger.debug("CrudManagerImpl: retrieve Id is " + id);
		}
		if (id == null) {
			throw new IllegalArgumentException("ID should not be null for retrieving a persistable");
		}
		return genericDao.get(klass, id);
	}

	@Override
	public T update(T persistable) {
		if (persistable == null) {
			throw new IllegalArgumentException("Cannot update a Null entity");
		}
		preUpdate(persistable);
		persistable = genericDao.update(persistable);
		postUpdate(persistable);
		return persistable;
	}

	@Override
	public void remove(Class<T> klass, Serializable id) {
		genericDao.delete(klass, id);
	}

	/**
	 * Post update.
	 * 
	 * @param p
	 *            the p
	 */
	protected void postUpdate(T p) {
	}

	/**
	 * Pre update.
	 * 
	 * @param p
	 *            the p
	 */
	protected void preUpdate(T p) {
	}

	/**
	 * Pre create.
	 * 
	 * @param persistable
	 *            the persistable
	 */
	protected void preCreate(T persistable) {
	}

	/**
	 * Post create.
	 * 
	 * @param persistable
	 *            the persistable
	 */
	protected void postCreate(T persistable) {
	}
}
