package com.functional;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiFunction;

public class MapCombiner {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		Map<String, String> map = new LinkedHashMap<>();
		map.put("Hello", "World");
		map.put("Welcome", "Java");
		BiFunction<String, String, String> combineKeyValue = (key, value) -> String.join(" ", key, value);
		Set<Entry<String,String>> set = map.entrySet();
		for (Entry<String, String> entry : set) {
			builder.append(combineKeyValue.apply(entry.getKey(), entry.getValue()));
			builder.append("\n");
		}
		System.out.println(builder);
	}

}
