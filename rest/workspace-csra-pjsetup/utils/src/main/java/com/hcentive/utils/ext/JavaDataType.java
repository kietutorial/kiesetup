package com.hcentive.utils.ext;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import javax.management.AttributeList;

public class JavaDataType {
	private static HashSet<Class<?>> getJavaDataTypes() {
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

	private static HashSet<Class<?>> getJavaCollectionTypes() {
		HashSet<Class<?>> classSet = new HashSet<Class<?>>();
		classSet.add(AbstractMap.class);
		classSet.add(ArrayList.class);
		classSet.add(AttributeList.class);
		classSet.add(ConcurrentHashMap.class);
		classSet.add(ConcurrentSkipListMap.class);
		classSet.add(EnumMap.class);
		classSet.add(HashMap.class);
		classSet.add(HashSet.class);
		classSet.add(Hashtable.class);
		classSet.add(IdentityHashMap.class);
		classSet.add(LinkedHashMap.class);
		classSet.add(LinkedList.class);
		classSet.add(List.class);
		classSet.add(Map.class);
		classSet.add(Set.class);
		classSet.add(TreeMap.class);
		classSet.add(Vector.class);
		classSet.add(WeakHashMap.class);
		return classSet;
	}

	private static final HashSet<Class<?>> DECLARED_TYPES = getJavaDataTypes();
	private static final HashSet<Class<?>> DECLARED_COLLECTIONS = getJavaCollectionTypes();

	public static boolean isJavaDataType(Class<?> clazz) {
		return DECLARED_TYPES.contains(clazz);
	}

	public static boolean isJavaCollectionType(Class<?> clazz) {
		return DECLARED_COLLECTIONS.contains(clazz);
	}

}
