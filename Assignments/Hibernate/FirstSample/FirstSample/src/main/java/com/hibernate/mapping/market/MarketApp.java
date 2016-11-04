package com.hibernate.mapping.market;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MarketApp {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Market market = create(session);
		read(session);
		update(session, market.getMarketId());
		delete(session, market);
		
		session.close();
		sessionFactory.close();
	}
	
	private static void delete(Session session, Market market) {
		Transaction transaction = session.beginTransaction();
		session.delete(market);
		transaction.commit();
	}

	private static void update(Session session, Long marketId) {
		Transaction transaction = session.beginTransaction();
		Market market = session.load(Market.class, marketId);
		market.setName("I.T");
		
		Set<Stock> stocks = market.getStocks();
		stocks.forEach(stock -> stock.setPrice(stock.getPrice() + 100));
		
		market.setValue(Market.calulateMarketPrice(stocks));
		transaction.commit();
	}

	private static Market create(Session session) {
		Transaction transaction = session.beginTransaction();
		Market market = new Market("IT");
		
		Stock google = new Stock("Google", 10, market);
		Stock microsoft = new Stock("Microsoft", 5, market);
		
		HashSet<Stock> stocks = new HashSet<>();
		stocks.add(google);
		stocks.add(microsoft);
		
		market.setStocks(stocks);
		
		session.save(market);
		transaction.commit();
		return market;
	}

	@SuppressWarnings("unchecked")
	private static void read(Session session) {
		Query query = session.createQuery("from Market");
		query.list().forEach(market -> {
			System.out.println(market);
			((Market) market).getStocks().forEach(System.out::println);
		});
	}
	
	

}
