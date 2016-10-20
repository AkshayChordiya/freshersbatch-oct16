package com.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Custom {
	private String something = "Something";
	private int dob = 74;
	
	@Getter
	public String getSomething() {
		return something;
	}
	
	@Getter
	public int getDateOfBirth() {
		return dob;
	}
}

public class CustomAnnotation {

	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class cls = Custom.class;
		Method[] methods = cls.getDeclaredMethods();
		String varName;
		for (Method method : methods) {
			if (method.getAnnotation(Getter.class) != null) {
				varName = method.getName();
				varName = varName.replace("get", "").toLowerCase();
				try {
				Field requiredField = cls.getDeclaredField(varName);
					if (requiredField != null) {
						System.out.println("Authorised Getter method");
					} else {
						System.out.println("Improper Getter method");
					}
				} catch (NoSuchFieldException e) {
					System.out.println("Improper Getter method");
				}
			}
		}
	}

}
