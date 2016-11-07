package com.hibernate.tableperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

//	DESC VEHICLE
//	Name  Null     Type          
//	----- -------- ------------- 
//	ID    NOT NULL NUMBER(19)    
//	NAME           VARCHAR2(255) 
//	PRICE          FLOAT(126)    
//
//	DESC CAR
//	Name  Null     Type          
//	----- -------- ------------- 
//	ID    NOT NULL NUMBER(19)    
//	NAME           VARCHAR2(255) 
//	PRICE          FLOAT(126)    
//	SPEED          FLOAT(126)    
//
//	DESC BIKE
//	Name   Null     Type          
//	------ -------- ------------- 
//	ID     NOT NULL NUMBER(19)    
//	NAME            VARCHAR2(255) 
//	PRICE           FLOAT(126)    
//	MILAGE          FLOAT(126)
	
	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Vehicle vehicle = new Vehicle("A", 1000);
		Bike bike = new Bike("B", 1000, 30);
		Car car = new Car("C", 20000, 15);
		Transaction tx = session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Vehicle, Bike & Car saved into separate tables!!");
	}

}
