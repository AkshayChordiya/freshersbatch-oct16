package com.hibernate.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
@PrimaryKeyJoinColumn(name="id")
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
