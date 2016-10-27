package com.collection;

/**
	Date Program
	@author Akshay Chordiya
*/
public class Date {
	
	private int year;
	private int month;
	private int day;
	
	/** Default Constructor **/
	public Date() {
		day = 15;
		month = 06;
		year = 1995;
	}
	
	public Date(int day, int month, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (this.day == other.day && month == other.month) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "DD/MM/YYYY = " + day + "/" + month + "/" + year;
	}

}