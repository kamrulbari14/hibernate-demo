package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//Create session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating student object");
			Student tempStudent = new Student("Kamrul", "Bari", "pochachele@gmail.com");

			System.out.println("transacion started");
			session.beginTransaction();

			System.out.println("Saving student object");
			session.save(tempStudent);

			session.getTransaction().commit();
			System.out.println("All done!");
		}

		finally {
			factory.close();
		}
	}

}
