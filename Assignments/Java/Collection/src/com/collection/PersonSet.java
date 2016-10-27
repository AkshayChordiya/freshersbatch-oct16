package com.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PersonSet {

	public static void main(String[] args) {
		Set<Person> personSet = new TreeSet<>();
		personSet.add(new Person("Akshay", 65.1, 68.2));
		personSet.add(new Person("Janhavi", 65.0, 54.4));
		personSet.add(new Person("Aditya", 70.0, 68.2));
		Iterator<Person> it = personSet.iterator();
		while (it.hasNext()) {
			Person person = it.next();
			System.out.println(person);
		}
	}

}
