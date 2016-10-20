package com.enumerate;

public class Order {
	private int id;
	private String name;
	private int quantity;
	private int price;
	private Status status;

	public Order(int id, String name, int quantity, int price, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", status="
				+ status + "]";
	}
	
	
}
