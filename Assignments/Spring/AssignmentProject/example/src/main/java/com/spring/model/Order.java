package com.spring.model;

public class Order {

	private String orderName;
	private Item item;
	
	public Order() {
	}

	public Order(String orderName, Item item) {
		super();
		this.orderName = orderName;
		this.item = item;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", item=" + item + "]";
	}

}
