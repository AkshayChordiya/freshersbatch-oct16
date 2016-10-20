package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person {
	public String getName(String name) {
		return name;
	}
}

class Middleware {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object invokeMethod(
			String className, 
			String methodName, 
			Class[] paramTypes,
			Object[] paramValues) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class classObject = Class.forName(className);
		Method method = classObject.getDeclaredMethod(methodName, paramTypes);
		method.setAccessible(true);
		return method.invoke(classObject.newInstance(), paramValues);
	}
}

public class InvokerMain {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class[] paramTypes = new Class[1];
		paramTypes[0] = String.class;
		
		Object[] paramValues = new Object[1];
		paramValues[0] = args[2];
		
		/*String result = (String) Middleware.invokeMethod(
				"com.reflect.Person", "getName", paramTypes, paramValues);*/
		String result = (String) Middleware.invokeMethod(
				args[0], args[1], paramTypes, paramValues);
		System.out.println(result);
	}

}
