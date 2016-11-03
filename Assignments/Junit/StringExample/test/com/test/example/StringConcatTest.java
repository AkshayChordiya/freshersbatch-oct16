package com.test.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringConcatTest {
	
	@Test
	public void test() {
		StringOperations stringOperations = new StringOperations();
		assertEquals("android", stringOperations.concat("and", "roid"));
	}
	
	@Test
	public void anotherTest() {
		StringOperations stringOperations = new StringOperations();
		assertEquals("aj", stringOperations.concat("a", "j"));
	}

}
