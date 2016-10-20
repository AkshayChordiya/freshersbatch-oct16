package com.exeption.res;

public class MyAutoCloseable implements AutoCloseable {
	
	@Override
	public void close() throws Exception {
		System.out.println("Closed()");
	}
}
