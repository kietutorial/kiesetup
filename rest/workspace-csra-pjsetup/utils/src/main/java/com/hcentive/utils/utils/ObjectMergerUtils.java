/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectMergerUtils {

	private static Logger logger = LoggerFactory.getLogger(ObjectMergerUtils.class);
	
	private static Map<Class<?>, PropertyDescriptor[]> descriptorsMap = new HashMap<Class<?>, PropertyDescriptor[]>();

	private static final HashSet<Class<?>> DECLARED_TYPES = getDeclaredTypes();

	public static boolean isDeclaredType(Class<?> clazz) {
		return DECLARED_TYPES.contains(clazz);
	}

	private static HashSet<Class<?>> getDeclaredTypes() {
		HashSet<Class<?>> classSet = new HashSet<Class<?>>();
		classSet.add(String.class);
		classSet.add(Boolean.class);
		classSet.add(Character.class);
		classSet.add(Byte.class);
		classSet.add(Short.class);
		classSet.add(Integer.class);
		classSet.add(Long.class);
		classSet.add(Float.class);
		classSet.add(Double.class);
		classSet.add(Void.class);
		classSet.add(List.class);
		classSet.add(Map.class);
		classSet.add(Set.class);
		classSet.add(Date.class);
		classSet.add(int.class);
		classSet.add(boolean.class);
		classSet.add(byte.class);
		classSet.add(char.class);
		classSet.add(short.class);
		classSet.add(long.class);
		classSet.add(float.class);
		classSet.add(double.class);
		classSet.add(void.class);
		return classSet;
	}

	public static void mergeObject(Object originalObject, Object updateObject) throws InvocationTargetException,
			IllegalAccessException, NoSuchMethodException {
		if (updateObject == null || originalObject == null) {
			throw new NullPointerException("A null paramter was passed into updateObject");
		}

		// Only go through the process if the objects are not the same reference
		if (originalObject != updateObject) {
			Class<?> orignalClass = originalObject.getClass();
			Class<?> updateClass = updateObject.getClass();
			// you may want to work this check if you need to handle polymorphic
			// relations
			if (!orignalClass.equals(updateClass)) {
				throw new IllegalArgumentException("Received parameters are not the same type of class, but must be");
			}

			PropertyDescriptor[] descriptors = descriptorsMap.get(orignalClass);
			if (descriptors == null) {
				descriptors = PropertyUtils.getPropertyDescriptors(orignalClass);
				descriptorsMap.put(orignalClass, descriptors);
			}

			for (PropertyDescriptor descriptor : descriptors) {
				if (PropertyUtils.isReadable(originalObject, descriptor.getName())
						&& PropertyUtils.isWriteable(originalObject, descriptor.getName())) {
					Method readMethod = descriptor.getReadMethod();
					Method writeMethod = descriptor.getWriteMethod();
					if (isDeclaredType(descriptor.getPropertyType())) {
						Object value = readMethod.invoke(updateObject);
						if (value != null) {
							writeMethod.invoke(originalObject, value);
						}
					} else {
						if (readMethod.invoke(updateObject) != null) {
							if (readMethod.invoke(originalObject) != null) {
								mergeObject(readMethod.invoke(originalObject), readMethod.invoke(updateObject));
							} else {
								writeMethod.invoke(originalObject, readMethod.invoke(updateObject));
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void createObjectCopy(Object targetObject, Object sourceObject) throws InvocationTargetException,
			IllegalAccessException, NoSuchMethodException {

		if (sourceObject == null || targetObject == null) {
			throw new NullPointerException("A null paramter was passed into updateObject");
		}

		// Only go through the process if the objects are not the same reference
		if (targetObject != sourceObject) {
			Class targetClass = targetObject.getClass();
			Class sourceClass = sourceObject.getClass();
			// you may want to work this check if you need to handle polymorphic
			// relations
			if (!targetClass.equals(sourceClass)) {
				throw new IllegalArgumentException("Received parameters are not the same type of class, but must be");
			}

			PropertyDescriptor[] descriptors = descriptorsMap.get(targetClass);
			if (descriptors == null) {
				descriptors = PropertyUtils.getPropertyDescriptors(targetClass);
				descriptorsMap.put(targetClass, descriptors);
			}

			for (PropertyDescriptor descriptor : descriptors) {
				if (PropertyUtils.isReadable(sourceObject, descriptor.getName())
						&& PropertyUtils.isWriteable(targetObject, descriptor.getName())) {
					Method readMethod = descriptor.getReadMethod();
					Method writeMethod = descriptor.getWriteMethod();
					if (isDeclaredType(descriptor.getPropertyType())) {
						Object value = readMethod.invoke(sourceObject);
						// copy source values to target only when target has
						// null values
						if (value != null) {
							if (readMethod.invoke(targetObject) == null) {
								writeMethod.invoke(targetObject, value);
							} else if (readMethod.invoke(targetObject) instanceof List
									|| readMethod.invoke(targetObject) instanceof Set) {
								Iterator itr = ((Collection) value).iterator();
								while (itr.hasNext()) {
									((Collection) readMethod.invoke(targetObject)).add(itr.next());
								}
							}

						}
					} else {
						if (readMethod.invoke(sourceObject) != null) {
							if (readMethod.invoke(targetObject) != null) {
								createObjectCopy(readMethod.invoke(targetObject), readMethod.invoke(sourceObject));
							} else {
								writeMethod.invoke(targetObject, readMethod.invoke(sourceObject));
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void copyDifferentObject(Object targetObject, Object sourceObject, String[] skipCopyForProperties)
			throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException,
			SecurityException {

		boolean copy = true;
		if (sourceObject == null || targetObject == null) {
			throw new NullPointerException("A null paramter was passed into argument objects");
		}

		// Only go through the process if the objects are not the same reference
		if (targetObject != sourceObject) {
			Class targetClass = targetObject.getClass();
			Class sourceClass = sourceObject.getClass();

			PropertyDescriptor[] descriptors = descriptorsMap.get(sourceClass);
			if (descriptors == null) {
				descriptors = PropertyUtils.getPropertyDescriptors(sourceClass);
				descriptorsMap.put(sourceClass, descriptors);
			}

			List<String> copyEscapeList = Arrays.asList(skipCopyForProperties);
			for (PropertyDescriptor descriptor : descriptors) {
				if ((!copyEscapeList.contains(descriptor.getName()))
						&& PropertyUtils.isReadable(sourceObject, descriptor.getName())
						&& PropertyUtils.isWriteable(targetObject, descriptor.getName())) {
					Method sourceReadMethod = descriptor.getReadMethod();
					Method sourceWriteMethod = descriptor.getWriteMethod();
					Method targetReadMethod = targetClass.getMethod(sourceReadMethod.getName(),
							sourceReadMethod.getParameterTypes());
					Method targetWriteMethod = targetClass.getMethod(sourceWriteMethod.getName(),
							sourceWriteMethod.getParameterTypes());

					copy = true;
					Annotation[] annotations = null;
					try {
						annotations = sourceClass.getDeclaredField(descriptor.getName()).getAnnotations();
						for (Annotation annotation : annotations) {
							if (annotation instanceof JoinColumn) {
								JoinColumn jc = (JoinColumn) annotation;
								if (!(jc.insertable() || jc.updatable())) {
									copy = false;
								} else {
									copy = true;
								}
							} else if (annotation instanceof Transient) {
								copy = false;
							}
						}
					} catch (NoSuchFieldException e) {
						// Ignore exception
						logger.error("EXCEPTION", e);
					}

					if (copy) {
						if (isDeclaredType(descriptor.getPropertyType())) {
							Object value = sourceReadMethod.invoke(sourceObject);
							// copy source values to target only when target has
							// null values
							if (value != null) {
								if (targetReadMethod.invoke(targetObject) == null) {
									targetWriteMethod.invoke(targetObject, value);
								} else if (targetReadMethod.invoke(targetObject) instanceof List
										|| targetReadMethod.invoke(targetObject) instanceof Set) {
									Iterator itr = ((Collection) value).iterator();
									Class targetTypeObj = (Class) ((ParameterizedType) targetReadMethod.getGenericReturnType())
											.getActualTypeArguments()[0];
									while (itr.hasNext()) {
										Object obj = itr.next();
										if (isDeclaredType(obj.getClass())) {
											((Collection) targetReadMethod.invoke(targetObject)).add(obj);
										} else {
											Object newInstance = targetTypeObj.newInstance();
											copyDifferentObject(newInstance, obj, skipCopyForProperties);
											((Collection) targetReadMethod.invoke(targetObject)).add(newInstance);
										}
									}
								}
							}
						} else {
							if (sourceReadMethod.invoke(sourceObject) != null) {
								if (targetReadMethod.invoke(targetObject) != null) {
									copyDifferentObject(targetReadMethod.invoke(targetObject),
											sourceReadMethod.invoke(sourceObject), skipCopyForProperties);
								} else {
									targetWriteMethod.invoke(targetObject, sourceReadMethod.invoke(sourceObject));
								}
							}
						}
					}
				}
			}
		}
	}
}
