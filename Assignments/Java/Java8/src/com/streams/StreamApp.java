package com.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.model.Fruit;
import com.model.News;
import com.model.TestData;
import com.model.Trader;
import com.model.Transaction;

public class StreamApp {

	public static void main(String[] args) {
		// Assignment 1
		System.out.println("Assignment 1");
		List<Fruit> fruits = TestData.getAllFruits();
		List<String> caloriesFruit = fruits.stream()
				.filter(f -> f.calories < 100)
				.sorted(Comparator.comparingInt(Fruit::getCalories).reversed()).map(Fruit::getName)
				.collect(Collectors.toList());
		caloriesFruit.forEach(System.out::println);

		// Assignment 2
		System.out.println("\nAssignment 2");
		Map<String, List<Fruit>> colorMap = fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getColor));
		colorMap.forEach((key, value) -> {
		    System.out.println("C: " + key + " => Fruits : " + value);
		});

		// Assignment 3
		System.out.println("\nAssignment 3");
		List<Fruit> redFruits = fruits.stream()
			.filter(f -> f.color.equals("Red"))
			.sorted(Comparator.comparingInt(Fruit::getPrice))
			.collect(Collectors.toList());
		TestData.printFruits(redFruits);
		
		// Assignment 4
		System.out.println("\nAssignment 4");
		List<News> allNews = TestData.getAllNews();
		Optional<Entry<Integer, Long>> maxComments = allNews.stream()
				.collect(Collectors.groupingBy(News::getNewsId, Collectors.counting()))
				.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		if (maxComments.isPresent()) System.out.println("User = " + maxComments.get().getKey() + ", comments = " + maxComments.get().getValue());
		
		// Assignment 5
		System.out.println("\nAssignment 5");
		long budgetCount = allNews.stream()
				//.filter(f -> f.comment.contains("budget"))
				.flatMapToInt(news -> {
						String[] strings = news.comment.split(" ");
						int count = 0;
						for (int i = 0; i < strings.length; i++) {
							if (strings[i].equals("budget")) {
								count++;
							}
						}
						return IntStream.of(count);
					}
				)
				.sum();
		System.out.println(budgetCount);
		
		// Assignment 6
		System.out.println("\nAssignment 6");
		Map<String, Long> commentByUser = allNews.stream()
				.collect(Collectors.groupingBy(News::getCommentByUser, Collectors.counting()));
		commentByUser.forEach((key, value) -> System.out.println(key + " (" + value + ")"));
		
		// Assignment 7
		System.out.println("\nAssignment 7");
		List<Transaction> allTransactions = TestData.getAllTransactions();
		List<Transaction> yearTransactions = allTransactions.stream()
						.filter(t -> t.year == 2011)
						.sorted(Comparator.comparingInt(Transaction::getValue))
						.collect(Collectors.toList());
		TestData.printTransactions(yearTransactions);
		
		// Assignment 8
		System.out.println("\nAssignment 8");
		List<String> uniqueCities = allTransactions.stream()
				.map(t -> t.getTrader().getCity())
				.distinct()
				.collect(Collectors.toList());
		uniqueCities.forEach(System.out::println);
		
		// Assignment 9
		System.out.println("\nAssignment 9");
		List<Trader> traders = allTransactions.stream()
				.map(Transaction::getTrader)
				.filter(t -> t.city.equals("Pune"))
				.sorted(Comparator.comparing(t -> t.name))
				.collect(Collectors.toList());
		traders.forEach(System.out::println);
		
		// Assignment 10
		System.out.println("\nAssignment 10");
		List<String> allTraderNames = allTransactions.stream()
				.map(t -> t.getTrader().getName())
				.sorted()
				.collect(Collectors.toList());
		allTraderNames.forEach(System.out::println);
		
		// Assignment 11
		System.out.println("\nAssignment 11");
		boolean isAnyoneIndore = allTransactions.stream()
				.anyMatch(t -> t.getTrader().getCity().equals("Indore"));
		System.out.println(isAnyoneIndore);
		
		// Assignment 12
		System.out.println("\nAssignment 12");
		List<Integer> transactionsFromDelhi = allTransactions.stream()
						.filter(t -> t.getTrader().getCity().equals("Delhi"))
						.map(Transaction::getValue)
						.collect(Collectors.toList());
		transactionsFromDelhi.forEach(System.out::println);
		
		// Assignment 13
		System.out.println("\nAssignment 13");
		Optional<Integer> max = allTransactions.stream()
				.map(Transaction::getValue)
				.max(Comparator.naturalOrder());
		if (max.isPresent()) System.out.println(max.get());
		
		// Assignment 14
		System.out.println("\nAssignment 14");
		Optional<Transaction> min = allTransactions.stream()
				.min(Comparator.comparing(Transaction::getValue));
		if (min.isPresent()) System.out.println(min.get());
		
		// Assignment 15
		System.out.println("\nAssignment 15");
		Optional<String> user = allNews.stream()
				.collect(Collectors.groupingBy(News::getCommentByUser, Collectors.counting()))
				.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
				.flatMap(element -> Optional.of(element.getKey()));
		if (user.isPresent()) System.out.println(user.get());
	}

}
