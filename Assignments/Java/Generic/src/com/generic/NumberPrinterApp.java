package com.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumberPrinterApp {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(74, "J");
		map.put(24, "A");
		printMapKeyValues(map);
	}
	
	public static void printMapKeyValues(Map<? extends Number, ?> map) {
		Iterator<? extends Number> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Number number = iterator.next();
			System.out.println("K: " + number + " V: " + map.get(number));
		}
	}

}
