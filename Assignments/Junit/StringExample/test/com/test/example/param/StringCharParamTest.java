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
public class StringCharParamTest {
	
	@Parameter(value=0)
	public static String s;
	
	@Parameter(value=1)
	public static int index;

	@Parameter(value=2)
	public static char result;
	
	@Parameters
	public static Collection<Object []> data() {
		Object[][] data = {
				{"android", 0, 'a'},
				{"nougat", 1, 'o'},
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void test() {
		StringOperations stringOperations = new StringOperations();
		assertEquals(result, stringOperations.getCharacter(s, index));
	}

}
