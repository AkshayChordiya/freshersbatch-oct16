package com.hibernate.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="BIKE")
public class Bike extends Vehicle {

	@Column(name="milage")
	private double milage;
	
	public Bike() {
	}

	public Bike(String name, double price, double milage) {
		super(name, price);
		this.milage = milage;
	}

	public double getMilage() {
		return milage;
	}

	public void setMilage(double milage) {
		this.milage = milage;
	}

	@Override
	public String toString() {
		return super.toString() + " Bike [milage=" + milage + "]";
	}
	
}
