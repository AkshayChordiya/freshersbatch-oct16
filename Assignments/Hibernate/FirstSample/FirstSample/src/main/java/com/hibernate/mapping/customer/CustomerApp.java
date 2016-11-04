package com.hibernate.mapping.customer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.example.Product;

public class CustomerApp {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// Create
		Customer customer = create(session);
		
		// Read
		read(session);
		
		// Update 
		update(session, customer.getCustomerId());
		
		read(session);
		
		// Delete
		delete(session, customer);
		
		session.close();
		sessionFactory.close();
	}

	private static void delete(Session session, Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.delete(customer);
		transaction.commit();
	}

	private static void update(Session session, Long customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = session.load(Customer.class, customerId);
		Enquiry enquiry = customer.getEnquiry();
		enquiry.setIssue("I want IntelliJ");
		customer.setEnquiry(enquiry);
		transaction.commit();
	}

	private static Customer create(Session session) {
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer("Aditya", new Enquiry("IntelliJ"));
		session.save(customer);
		transaction.commit();
		return customer;
	}

	@SuppressWarnings("unchecked")
	private static void read(Session session) {
		Query query = session.createQuery("from Customer");
		List<Product> list = query.list();
		System.out.println(list);
	}

}
