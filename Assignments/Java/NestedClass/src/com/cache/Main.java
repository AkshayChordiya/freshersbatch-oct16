package com.cache;

public class Main {
	public static void main(String[] args) {
		App app = new App();
		app.add("Hello");
		app.add("World");
		System.out.println(app.get(1));
	}
}
