package com.collection;

public class Car {
	private String onwerName;
	private long owerMobileNo;
	private String onwerAddress;
	private String carModel;
	private String carNumber;
	
	public Car(String carNumber) {
		super();
		this.carNumber = carNumber;
	}
	
	public Car(String onwerName, long owerMobileNo, String onwerAddress, String carModel, String carNumber) {
		super();
		this.onwerName = onwerName;
		this.owerMobileNo = owerMobileNo;
		this.onwerAddress = onwerAddress;
		this.carModel = carModel;
		this.carNumber = carNumber;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [onwerName=" + onwerName + ", owerMobileNo=" + owerMobileNo + ", onwerAddress=" + onwerAddress
				+ ", carModel=" + carModel + ", carNumber=" + carNumber + "]";
	}
	
}
