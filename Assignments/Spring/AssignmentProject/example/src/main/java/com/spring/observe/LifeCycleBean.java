package com.spring.observe;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {

	private String message = null;

	public LifeCycleBean() {
		System.out.println("LifeCycleBean created!!");
	}

	public void initBean() {
		System.out.println("Inside initBean()");
	}
	
	public void destroyBean() {
		System.out.println("Inside destroyBean()");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("setMessage(): " + message);
	}

	public void printMessage() {
		System.out.println(message);
	}

	public void setBeanName(String beanName) {
		System.out.println("Bean name is: " + beanName);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside afterPropertiesSet()");
	}
}
