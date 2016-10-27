package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EmployeeMap {

	public static void main(String[] args) {
		Map<Employee, Integer> employeeMap = new HashMap<>();
		employeeMap.put(new Employee("Janhavi"), 1);
		employeeMap.put(new Employee("Akshay"), 1);
		employeeMap.put(new Employee("Aditya"), 2);
		
		Iterator<Employee> iterator = employeeMap.keySet().iterator();
		while (iterator.hasNext()) {
			Employee date = (Employee) iterator.next();
			System.out.println("K: " + date + " V: " + employeeMap.get(date));
		}
	}

}
