package com.collection;

class Person implements Comparable<Person> {
	private String name;
	private Double height;
	private Double weight;

	public Person(String name, Double height, Double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public int compareTo(Person person2) {
		int weightCompare = this.weight.compareTo(person2.weight);
		if (weightCompare == 0) return this.height.compareTo(person2.height);
		else return weightCompare;
	}

	public String toString() {
		return name + " - " + height + " inch " + weight + " kg";
	}
}