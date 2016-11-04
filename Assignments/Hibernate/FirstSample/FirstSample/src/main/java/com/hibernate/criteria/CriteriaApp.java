package com.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class CriteriaApp {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// 1st
		System.out.println("\n1st");
		totalSalary(session);
		
		// 2nd
		System.out.println("\n2nd");
		orderSalaryUsingCriteria(session);
		orderSalaryUsingHQL(session);
		
		// 3rd
		System.out.println("\n3rd");
		Criteria criteria = session.createCriteria(Employee.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList
					  .add(Projections.sum("salary"))
					  .add(Projections.sum("commission"))
					  .add(Projections.count("name"))
					  .add(Projections.groupProperty("role"));
		criteria.setProjection(projectionList);
		List<Object[]> list = criteria.list();
		for (Object[] string : list) {
			System.out.println(string[3] + " (" + string[2] + ")" + " => " + string[0] + " (" + string[1] + ")");
		}
		
		// 4th
		averageSalary(session);
		
		// 5th
		greaterSalary(session);
		
		showAllEmployees(session);
		
		session.close();
		sessionFactory.close();
	}

	private static void greaterSalary(Session session) {
		System.out.println("\n5th");
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", 10000f));
		criteria.list().forEach(System.out::println);
	}

	private static void averageSalary(Session session) {
		System.out.println("\n4th");
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("salary"));
		System.out.println("Average Salary = " + criteria.uniqueResult());
	}

	private static void orderSalaryUsingHQL(Session session) {
		System.out.println("\nUsing HQL");
		Query query = session.createQuery("FROM Employee E ORDER BY E.salary DESC");
		List<Employee> list = query.list();
		list.forEach(System.out::println);
	}

	// 2nd
	private static void orderSalaryUsingCriteria(Session session) {
		System.out.println("\nUsing Criteria");
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("salary"));
		criteria.list().forEach(System.out::println);
	}

	// 1st
	private static void totalSalary(Session session) {
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.sum("salary"));
		System.out.println("Total Salary = " + criteria.uniqueResult());
	}
	
	private static void showAllEmployees(Session session) {
		System.out.println();
		Query query = session.getNamedQuery("getAllEmployee");
		List<Employee> list = query.list();
		list.forEach(System.out::println);
	}

}
