package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//Create session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating 3 more student object");
			Student tempStudent1 = new Student("Nur", "Bithi", "bithi@gmail.com");
			Student tempStudent2 = new Student("Priyo", "Bithi", "pbithi@gmail.com");
			Student tempStudent3 = new Student("Kamrul", "Priyo", "kamrulp@gmail.com");
			
			System.out.println("transacion started");
			session.beginTransaction();
	
			System.out.println("Saving student object");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
	
			session.getTransaction().commit();
			System.out.println("All done!");
		}
	
		finally {
			factory.close();
		}

	}

}
