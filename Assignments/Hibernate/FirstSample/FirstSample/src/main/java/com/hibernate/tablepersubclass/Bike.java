package com.hibernate.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="BIKE")
@PrimaryKeyJoinColumn(name="id")
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
