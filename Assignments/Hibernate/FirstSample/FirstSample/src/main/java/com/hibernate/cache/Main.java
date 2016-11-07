package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Product product = new Product("Laptop", 25000);
		session.persist(product);
		Product pr = session.get(Product.class, product.getId());
		Product pr_3 = session.get(Product.class, product.getId());
		t.commit();
		session.close();

		sessionFactory.getCache().evictEntity(Product.class, product.getId());

		Session session2 = sessionFactory.openSession();
		Product pr_2 = session2.get(Product.class, product.getId());
		session2.close();

		sessionFactory.close();
	}

}
