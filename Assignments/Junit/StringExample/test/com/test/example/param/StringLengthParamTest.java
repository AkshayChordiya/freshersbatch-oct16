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
public class StringLengthParamTest {
	
	@Parameter(value=0)
	public static String s;
	
	@Parameter(value=1)
	public static int result;
	
	@Parameters
	public static Collection<Object []> data() {
		Object[][] data = {
				{"android", 7},
				{"nougat", 6},
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void test() {
		StringOperations stringOperations = new StringOperations();
		assertEquals(result, stringOperations.getLength(s));
	}

}
