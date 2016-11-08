package com.spring.model;

public class Item {

	private String itemName;
	private double price;
	
	public Item() {
	}

	public Item(String itemName, double price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", price=" + price + "]";
	}

}
