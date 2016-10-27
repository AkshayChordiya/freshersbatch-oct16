package com.generic;

public class GenericWrapper<T> {
	
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

}
