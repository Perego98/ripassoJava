package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create the session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student obj
			System.out.println("Creating a new Student Obj");
			Student tempStudent = new Student("Daniele", "Perego", "peregopr@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the obj
			System.out.println("Saving the Student...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
