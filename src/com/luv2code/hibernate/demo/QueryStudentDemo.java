package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//Create session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("transacion started");
			session.beginTransaction();

			//query all students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			displayStudent(theStudents);
			
			//query student with last name bithi
			theStudents = session.createQuery("from Student s where s.lastName='Bithi'")
					.getResultList();
			
			System.out.println("\nWith lastname Bithi");
			displayStudent(theStudents);
			
			session.getTransaction().commit();
			System.out.println("All done!");
		}

		finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudents) {
		for(Student tempStudents : theStudents) {
			System.out.println(tempStudents);
		}
	}

}
