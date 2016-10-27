package com.collection;

public class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		int result = 1;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	public String toString() {
		return name;
	}
}