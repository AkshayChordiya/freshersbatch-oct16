package com.generic;

public class GenericApp {
	public static void main(String[] args) {
		GenericWrapper<String> wrapper = new GenericWrapper<>();
		wrapper.set("X");
		System.out.println(wrapper.get());
	}

}
