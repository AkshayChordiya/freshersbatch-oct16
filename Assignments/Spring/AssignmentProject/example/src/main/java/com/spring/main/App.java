package com.spring.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Order;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_simple.xml");
		List<Order> orders = new ArrayList<>();
		Order foodOrderBean = (Order) context.getBean("foodOrderBean");
		Order clothesOrderBean = (Order) context.getBean("clothesOrderBean");
		orders.add(foodOrderBean);
		orders.add(clothesOrderBean);
		System.out.println(foodOrderBean);
		System.out.println(clothesOrderBean);
		System.out.println("Total = " + 
					orders.stream().collect(Collectors.summingDouble(value -> value.getItem().getPrice())));
		context.close();
	}
}
