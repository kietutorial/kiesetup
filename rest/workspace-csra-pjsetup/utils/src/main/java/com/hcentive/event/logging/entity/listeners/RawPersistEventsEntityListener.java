/**
 * 
 */
package com.hcentive.event.logging.entity.listeners;

/**
 * @author atraikos
 *
 */
public interface RawPersistEventsEntityListener<E> {
	/**
	 * onPostLoad - After an entity has been retrieved from the database.  Initial
	 * condition for a potential modify or delete event (the first half).
	 * 
	 * @param eventLoggingEntity
	 */
	//@PostLoad  
	public void onPostLoad(E eventPrevious);

	/**
	 * onPreUpdate - When an entity is identified as modified by the EntityManager
	 * 
	 * This persistence event update the record created by the @PostLoad persistence
	 * event.
	 * 
	 * @param eventLoggingEntity
	 */
	//@PostUpdate 
	public void onPostUpdate(E entityCurrent);
	
	/**
	 * onPostPersist - After an entity is persisted (record created in the database).
	 * 
	 * This persistence event is intercepted before an entity is created.
	 * This would occur for instances where a new entity is created.
	 * 
	 * @param eventLoggingEntity
	 */
	//@PostPersist
	public void onPostPersist(E entityCurrent);
	
	/**
	 * onPostRemove - After an entity is marked for removal in the EntityManager
	 * 
	 * This persistence event is intercepted before an entity is marked
	 * for removal.  This would occur for the cases where an entity is deleted
	 * completely.
	 * 
	 * @param eventLoggingEntity
	 * 
	 */
	//@PostRemove
	public void onPostRemove(E eventPrevious);
}