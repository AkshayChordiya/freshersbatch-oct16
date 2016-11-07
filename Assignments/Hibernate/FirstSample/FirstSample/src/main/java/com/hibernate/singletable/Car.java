package com.hibernate.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CAR")
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
