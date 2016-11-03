package com.test.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.example.param.StringCharParamTest;
import com.test.example.param.StringConcatParamTest;
import com.test.example.param.StringLengthParamTest;

@RunWith(Suite.class)
@SuiteClasses({
		StringConcatTest.class,
		StringCharTest.class,
		StringLengthTest.class,
		StringConcatParamTest.class,
		StringCharParamTest.class,
		StringLengthParamTest.class,
	}
)
public class TestSuite {

}
