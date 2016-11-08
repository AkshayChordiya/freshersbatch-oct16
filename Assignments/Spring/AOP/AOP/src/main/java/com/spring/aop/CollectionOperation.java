package com.spring.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CollectionOperation {
	
	public void addInVector() {
		System.out.println("addInVector() called");
		List<Integer> numbers = new Vector<Integer>();
		for (int i = 0; i < 1000; i++) {
			numbers.add(i);
		}
		//return numbers;
	}
	
	public void addInList() {
		System.out.println("addInList() called");
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			numbers.add(i);
		}
		//return numbers;
	}

}
