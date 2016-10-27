package com.generic;

import java.util.ArrayList;
import java.util.List;

public class MapPrinterApp {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(74);
		numbers.add(24);
		printNumber(numbers);
	}
	
	public static void printNumber(List<? extends Number> numbers) {
		for (Number number : numbers) {
			System.out.println(number);
		}
	}

}
