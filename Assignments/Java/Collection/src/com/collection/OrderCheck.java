package com.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderCheck {

	public static void main(String[] args) {
		Set<Person> personHashSet = new HashSet<>();
		personHashSet.add(new Person("Akshay", 65.1, 68.2));
		personHashSet.add(new Person("Janhavi", 65.0, 54.4));
		personHashSet.add(new Person("Aditya", 70.0, 68.2));
		Iterator<Person> iterator = personHashSet.iterator();
		System.out.println("Unordered using HashSet: ");
		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person);
		}
		
		Set<Person> personSet = new LinkedHashSet<>();
		personSet.add(new Person("Akshay", 65.1, 68.2));
		personSet.add(new Person("Janhavi", 65.0, 54.4));
		personSet.add(new Person("Aditya", 70.0, 68.2));
		System.out.println("\nOrdered using LinkedHashSet: ");
		Iterator<Person> it = personSet.iterator();
		while (it.hasNext()) {
			Person person = it.next();
			System.out.println(person);
		}
	}

}
