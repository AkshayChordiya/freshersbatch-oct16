package com.test.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringLengthTest {
	
	@Test
	public void test() {
		StringOperations stringOperations = new StringOperations();
		assertEquals(7, stringOperations.getLength("android"));
	}
	
	@Test
	public void anotherTest() {
		StringOperations stringOperations = new StringOperations();
		assertEquals(1, stringOperations.getLength("j"));
	}

}
