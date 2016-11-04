package com.hibernate.mapping.student;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentApp {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student student = create(session);
		read(session);
		update(session, student.getStudentId());
		delete(session, student);
		
		session.close();
		sessionFactory.close();
	}
	
	private static void delete(Session session, Student student) {
		Transaction transaction = session.beginTransaction();
		session.delete(student);
		transaction.commit();
	}

	private static void update(Session session, Long studentId) {
		Transaction transaction = session.beginTransaction();
		Student student = session.load(Student.class, studentId);
		student.setName("Aditya");
		
		Set<Course> courses = student.getCourses();
		courses.forEach(course -> course.setName(String.join("-", course.getName(), "dev")));
		
		transaction.commit();
	}

	private static Student create(Session session) {
		Transaction transaction = session.beginTransaction();
		Student student = new Student("Aditya");
		
		Course java = new Course("Java");
		Course django = new Course("Django");
		
		HashSet<Course> courses = new HashSet<>();
		courses.add(java);
		courses.add(django);
		
		student.setCourses(courses);
		
		session.save(student);
		transaction.commit();
		return student;
	}

	@SuppressWarnings("unchecked")
	private static void read(Session session) {
		Query query = session.createQuery("from Student");
		query.list().forEach(student -> {
			System.out.println(student);
			((Student) student).getCourses().forEach(System.out::println);
		});
	}
	
	

}
