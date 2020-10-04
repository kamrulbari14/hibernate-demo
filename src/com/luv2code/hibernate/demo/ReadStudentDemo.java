package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

			System.out.println("transacion started");
			session.beginTransaction();

			System.out.println("Saving student object");
			System.out.println(tempStudent);
			session.save(tempStudent);

			session.getTransaction().commit();
			
			//new code for retrieve data to object
			System.out.println("Saved student primary key: " +tempStudent.getId());
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\ngetting Student with id: " +tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("get complete : " +myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("All done!");
		}

		finally {
			factory.close();
		}
	}

}
