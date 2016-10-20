package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BreakMe {
	private String name;
	
	public BreakMe() {
		name = "Let's Tango!";
	}
	
	private String getNamer() {
		return name;
	}
}

public class ReflectPolicy {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class breakClass = BreakMe.class;
		Object obj = breakClass.newInstance();
		Field field = breakClass.getDeclaredField("name");
		field.setAccessible(true);
		System.out.println(field.get(obj));
		Method method = breakClass.getDeclaredMethod("getNamer");
		method.setAccessible(true);
		System.out.println(method.invoke(obj));
	}

}
