package com.functional;

public class Order {
	private String name;
	private int price;
	private Status status;

	public Order(String name, int price, Status status) {
		super();
		this.name = name;
		this.price = price;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [name=" + name + ", price=" + price + ", status=" + status + "]";
	}

	public int getPrice() {
		return price;
	}

	public Status getStatus() {
		return status;
	}

}
