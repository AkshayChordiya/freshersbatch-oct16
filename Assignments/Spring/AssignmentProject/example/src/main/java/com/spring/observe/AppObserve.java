package com.spring.observe;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppObserve {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_observe.xml");
		context.close();
	}
}
