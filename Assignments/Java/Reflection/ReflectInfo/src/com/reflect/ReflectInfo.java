package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectInfo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Class stringClass = String.class;
		Constructor[] declaredConstructors = stringClass.getDeclaredConstructors();
		Method[] declaredMethods = stringClass.getDeclaredMethods();
		Field[] declaredFields = stringClass.getDeclaredFields();
		System.err.println("Constructors: ");
		for (Constructor constructor : declaredConstructors) {
			System.out.println(constructor);
		}
		System.err.println("\nMethods: ");
		for (Method method : declaredMethods) {
			System.out.println(method);
		}
		System.err.println("\nFields: ");
		for (Field field : declaredFields) {
			System.out.println(field);
		}
		
	}

}
