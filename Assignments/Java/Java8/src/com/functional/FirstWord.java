package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FirstWord {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("abc");
		words.add("abcd");
		words.add("abcde");
		words.add("abcdef");
		Consumer<String> consumer = word -> {System.out.print(word.charAt(0));}; 
		words = makeFirstLetters(words, consumer);
	}

	private static List<String> makeFirstLetters(List<String> words, Consumer<String> consumer) {
		for (String word : words) {
			consumer.accept(word);
		}
		return null;
	}

}
