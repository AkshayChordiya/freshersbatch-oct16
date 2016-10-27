package com.collection;

public class ParkingApp {

	public static void main(String[] args) {
		ParkingManager parkingManager = ParkingManager.getParkingManager();
		parkingManager.addCar(new Car("A", 9, "New York", "Lamborgini", "NY14"));
		parkingManager.addCar(new Car("B", 10, "California", "Porche", "CA15"));
		System.out.println(parkingManager.getCarLocation("NY14"));
		System.out.println(parkingManager.getCarLocation("CA15"));
	}

}
