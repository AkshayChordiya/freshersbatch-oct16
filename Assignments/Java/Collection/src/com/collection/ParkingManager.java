package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ParkingManager {
	
	private static ParkingManager sParkingManager;
	
	private List<Car> parkedCars;
	private Map<String, Location> carLocation;
	private List<Location> reservedLocations;
	
	private static final int MAX_FLOOR = 2;
	private static final int MAX_SECTION = 3;
	private static final int MAX_SPOTS = 19;
	
	private ParkingManager() {
		parkedCars = new ArrayList<>();
		carLocation = new HashMap<>();
		reservedLocations = new ArrayList<>();
	}
	
	public static ParkingManager getParkingManager() {
		if (sParkingManager == null) {
			sParkingManager = new ParkingManager();
		}
		return sParkingManager;
	}
	
	public void addCar(Car car) {
		Location location = getAvailableLocation();
		while (reservedLocations.contains(location)) {
			System.out.println("More random");
			location = getAvailableLocation();
		}
		parkedCars.add(car);
		reservedLocations.add(location);
		carLocation.put(car.getCarNumber(), location);
	}
	
	public String getCarLocation(String carNumber) {
		int car = parkedCars.indexOf(new Car(carNumber));
		return parkedCars.get(car) + " at " + carLocation.get(carNumber);
	}
	
	public void removeCar(Car car) {
		parkedCars.remove(car);
		Location location = carLocation.remove(car.getCarNumber());
		reservedLocations.remove(location);
	}

	private Location getAvailableLocation() {
		Random random = new Random();
		int floor = random.nextInt((MAX_FLOOR - 0 + 1) + 0);
		int section = random.nextInt((MAX_SECTION - 0 + 1) + 0);
		int spots = random.nextInt((MAX_SPOTS - 0 + 1) + 0);
		return new Location(floor, section, spots);
	}
}
