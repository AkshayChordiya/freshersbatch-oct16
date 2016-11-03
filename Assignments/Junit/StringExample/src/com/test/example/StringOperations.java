package com.test.example;

public class StringOperations {
	
	public String concat(String s1, String s2) {
		return String.join("", s1, s2);
	}

	public char getCharacter(String s, int index) {
		return s.charAt(index);
	}
	
	public int getLength(String s) {
		return s.length();
	}

}
