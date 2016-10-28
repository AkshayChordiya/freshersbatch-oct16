package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class OrderFilter {

	public static void main(String[] args) {
		List<Order> orderList = new ArrayList<>();
		orderList.add(new Order("Pizza", 10001, Status.NEW)); 
		orderList.add(new Order("Burger", 20000, Status.ACCEPTED));
		orderList.add(new Order("Coke", 10, Status.COMPLETED));
		Predicate<Order> priceFilter = (Order order) -> {return order.getPrice() > 1000;};
		Predicate<Order> statusFilter = (Order order) -> {return order.getStatus() == Status.ACCEPTED || order.getStatus() == Status.COMPLETED;};
//		List<Order> filteredList = orderList.stream().filter(p -> p.getPrice() > 10000).collect(Collectors.toList());
		List<Order> filteredListByPrice = getFilteredList(orderList, priceFilter);
		List<Order> filteredListByStatus = getFilteredList(orderList, statusFilter);
		System.out.println(orderList);
		System.out.println(filteredListByPrice);
		System.out.println(filteredListByStatus);
	}

	private static List<Order> getFilteredList(List<Order> orderList, Predicate<Order> priceFilter) {
		List<Order> filteredList = new ArrayList<>();
		for (Order order : orderList) {
			if (priceFilter.test(order)) filteredList.add(order);
		}
		return filteredList;
	}

}
