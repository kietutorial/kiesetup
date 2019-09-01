/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
/**
 * Copyright (c) 2009 - 2011 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.orm.service;

import java.io.Serializable;

/**
 * The Interface CrudService.
 */
public interface CrudService<T extends Serializable> {

	/**
	 * Retrieve the object from db given its ID.
	 * 
	 * @param id
	 *            the id
	 * @param klass
	 *            the klass
	 * @return the Persistable object
	 */
	public T retrieve(Class<T> klass, Serializable id);

	/**
	 * Creates a new Persistable in the system.
	 * 
	 * @param persistable
	 *            the persistable
	 * @return the persisted persistable (possibly with an ID)
	 */
	public T create(T persistable);

	/**
	 * Updates the persistable to db.
	 * 
	 * @param persistable
	 *            the persistable
	 * @return the T
	 */
	public T update(T persistable);

	/**
	 * Removes the.
	 * 
	 * @param klass
	 *            the klass
	 * @param id
	 *            the id
	 */
	public void remove(Class<T> klass, Serializable id);
}
