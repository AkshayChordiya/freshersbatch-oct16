package com.collection;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ReverseArray {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Akshay", 65.1, 68.2));
		persons.add(new Person("Janhavi", 65.0, 54.4));
		persons.add(new Person("Aditya", 70.0, 68.2));
		ListIterator<Person> iterator = persons.listIterator(persons.size());
		System.out.println("Reverse list using ListIterator: ");
		while (iterator.hasPrevious()) {
			Person person = iterator.previous();
			System.out.println(person);
		}
		
	}

}
