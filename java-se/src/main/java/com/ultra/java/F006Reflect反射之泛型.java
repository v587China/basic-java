package com.ultra.java;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class F006Reflect反射之泛型 {

	@Test
	public void testGetGenericSuperclass() throws Exception {
		String className = "com.java高级.PersonDao";
		Class<?> clazz = Class.forName(className);
		// getGenericSuperclass():获取带泛型的父类
		Type type = clazz.getGenericSuperclass();
		// ParameterizedType:带有泛型得类型
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			if (parameterizedType != null) {
				Type[] types = parameterizedType.getActualTypeArguments();
				if (types.length != 0) {
					for (Type t : types) {
						Class<?> clazz2 = (Class<?>) t;
						System.out.println(clazz2.getName());
						System.out.println(clazz2.newInstance());
					}
				}
			}
		}
	}
}
