package com.reflect;

import java.lang.reflect.InvocationTargetException;

class Construct {
	private String name;
	public Construct(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

public class ObjectMaker {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class constClass = Construct.class;
		Construct construct = (Construct) constClass.getDeclaredConstructor(String.class)
										.newInstance(args[0]);
		System.out.println(construct.getName());
	}

}
