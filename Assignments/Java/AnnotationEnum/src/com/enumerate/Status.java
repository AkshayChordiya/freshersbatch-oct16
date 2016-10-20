package com.enumerate;

public enum Status {
	NEW(1), REJECTED(2), ACCEPTED(3), COMPLETED(4);
	
	private int value;
	
	Status(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return super.toString() + "(" + value + ")";
	}
}
