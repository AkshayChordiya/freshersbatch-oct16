package com.hibernate.example;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session s1 = sessionFactory.openSession();
		
		// Create
		Product product = createProduct(s1);
		Long productId = product.getId();
		
		// Read
		showAllProducts(s1);
		
		// Update
		product = updateProduct(s1, productId);
		
		showAllProducts(s1);
		
		// Delete
		deleteProduct(s1, product);
		
		showAllProducts(s1);
		
		s1.close();
	}

	private static void deleteProduct(Session s1, Product product) {
		Transaction transaction = s1.beginTransaction();
		s1.delete(product);
		transaction.commit();
	}

	private static Product updateProduct(Session s1, Long productId) {
		Transaction transaction = s1.beginTransaction();
		Product updateProduct = s1.get(Product.class, productId);
		updateProduct.setPrice(20);
		s1.update(updateProduct);
		transaction.commit();
		return updateProduct;
	}

	private static Product createProduct(Session s1) {
		Transaction transaction = s1.beginTransaction();
		Product product = new Product("Xerox", 10);
		s1.save(product);
		transaction.commit();
		return product;
	}

	private static void showAllProducts(Session s1) {
		Query query = s1.createQuery("from Product");
		List<Product> list = query.list();
		System.out.println(list);
	}
}
