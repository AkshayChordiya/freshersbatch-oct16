package com.collection;

public class Location {
	private int floor;
	private int section;
	private int parkingSpot;
	
	public Location(int floor, int section, int parkingSpot) {
		super();
		this.floor = floor;
		this.section = section;
		this.parkingSpot = parkingSpot;
	}
	
	@Override
	public String toString() {
		return "Location [floor=" + floor + ", section=" + section + ", parkingSpot=" + parkingSpot + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (floor != other.floor)
			return false;
		if (section != other.section)
			return false;
		if (parkingSpot != other.parkingSpot)
			return false;
		return true;
	}
	
	
	
}
