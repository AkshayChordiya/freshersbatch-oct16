package com.test.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringCharTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass Test");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass Test");
	}

	@Before
	public void before() {
		System.out.println("\tBefore Test");
	}

	@After
	public void after() {
		System.out.println("\tAfter Test");
	}

	@Test
	public void test() {
		System.out.println("\t\tTest");
		StringOperations stringOperations = new StringOperations();
		assertEquals('a', stringOperations.getCharacter("android", 0));
	}

	@Test
	public void wrongTest() {
		System.out.println("\t\tOther Test");
		StringOperations stringOperations = new StringOperations();
		assertEquals('d', stringOperations.getCharacter("android", 6));
	}

}
