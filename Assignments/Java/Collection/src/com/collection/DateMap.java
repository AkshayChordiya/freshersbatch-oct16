package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DateMap {

	public static void main(String[] args) {
		Map<Date, String> dateMap = new HashMap<>();
		dateMap.put(new Date(15, 5, 1995),  "Janhavi");
		dateMap.put(new Date(15, 5, 1994),  "Akshay");
		dateMap.put(new Date(2, 1, 1994),  "Aditya");
		
		Iterator<Date> iterator = dateMap.keySet().iterator();
		while (iterator.hasNext()) {
			Date date = (Date) iterator.next();
			System.out.println("K: " + date + " V: " + dateMap.get(date));
		}
	}

}
