package com.test.example.param;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.test.example.StringOperations;

@RunWith(Parameterized.class)
public class StringConcatParamTest {
	
	@Parameter(value=0)
	public static String s1;
	
	@Parameter(value=1)
	public static String s2;

	@Parameter(value=2)
	public static String result;
	
	@Parameters
	public static Collection<Object []> data() {
		Object[][] data = {
				{"and", "roid", "android"},
				{"nou", "gat", "nougat"},
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void test() {
		StringOperations stringOperations = new StringOperations();
		assertEquals(result, stringOperations.concat(s1, s2));
	}
	
	@Test
	public void anotherTest() {
		StringOperations stringOperations = new StringOperations();
		assertEquals(result, stringOperations.concat(s1, s2));
	}

}
