package com.spring.aop.login;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_login.xml");
		try {
			UserHandler userHandler = context.getBean("userHandlerBean", UserHandler.class);
			userHandler.register("aky", "aky", "Aky", "IND");
			userHandler.login("aky", "aky");
			userHandler.logout();
		} catch (Exception e) {
		}
		context.close();
	}

}
