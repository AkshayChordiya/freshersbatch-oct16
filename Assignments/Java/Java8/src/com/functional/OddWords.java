package com.functional;

import java.util.ArrayList;
import java.util.List;

public class OddWords {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("abc");
		words.add("abcd");
		words.add("abcde");
		words.add("abcdef");
		words.removeIf(w -> w.length() % 2 == 1);
		System.out.println(words);
	}

}
