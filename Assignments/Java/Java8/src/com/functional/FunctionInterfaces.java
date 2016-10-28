package com.functional;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfaces {

	public static void main(String[] args) {
		Supplier<Integer> supplier = () -> new Random().nextInt(10);

		Consumer<String> consumer = string -> {
			System.out.println("Consumer = " + string);
		};

		Predicate<String> predicate = string -> string.equals("predicate");

		Function<String, Integer> function = number -> Integer.parseInt(number);

		System.out.println("Supplier = " + supplier.get());
		consumer.accept("Java 8");
		System.out.println("Predicate = " + predicate.test("predicate"));
		System.out.println("Function = " + function.apply("74"));
	}

}
