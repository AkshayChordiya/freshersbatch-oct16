package com.enumerate;

public class EnumMain {

	public static void main(String[] args) {
		Order pizza = new Order(1, "Pizza", 1, 10, Status.NEW); 
		Order burger = new Order(1, "Burger", 1, 10, Status.ACCEPTED);
		
		System.out.println(pizza);
		System.out.println(burger);
	}

}
