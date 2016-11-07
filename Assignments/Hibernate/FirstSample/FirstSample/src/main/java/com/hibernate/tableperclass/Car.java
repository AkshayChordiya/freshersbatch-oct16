package com.hibernate.tableperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
@AttributeOverrides({  
    @AttributeOverride(name="vehicleId", column=@Column(name="id")),  
    @AttributeOverride(name="name", column=@Column(name="name")),  
    @AttributeOverride(name="price", column=@Column(name="price"))  
})
public class Car extends Vehicle {

	@Column(name="speed")
	private double speed;
	
	public Car() {
	}

	public Car(String name, double price, double speed) {
		super(name, price);
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return super.toString() + " Car [speed=" + speed + "]";
	}

	
}
