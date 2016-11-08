package com.spring.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_aop.xml");
		CollectionOperation collectionOperation = context.getBean("collectBean", CollectionOperation.class);
		collectionOperation.addInVector();
		collectionOperation.addInList();
		context.close();
	}
}
