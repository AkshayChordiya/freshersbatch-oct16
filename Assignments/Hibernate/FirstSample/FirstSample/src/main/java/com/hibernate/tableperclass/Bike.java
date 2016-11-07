package com.hibernate.tableperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BIKE")
@AttributeOverrides({  
    @AttributeOverride(name="vehicleId", column=@Column(name="id")),  
    @AttributeOverride(name="name", column=@Column(name="name")),  
    @AttributeOverride(name="price", column=@Column(name="price"))  
})
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
