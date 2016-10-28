package com.functional;

import java.util.ArrayList;
import java.util.List;

public class UpperWord {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("abc");
		words.add("abcd");
		words.add("abcde");
		words.add("abcdef");
		words.replaceAll(w -> w.toUpperCase());
		System.out.println(words);
	}

}
