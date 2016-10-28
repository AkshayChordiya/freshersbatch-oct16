package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ThreadConsumer {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		Consumer<Integer> consumer = number -> {
			System.out.println("Consumer = " + number);
		};
		
		Thread thread = new Thread(() -> {
			for (Integer integer : list) {
				consumer.accept(integer);
			}
		});
		thread.start();
	}

}
