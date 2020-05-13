package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create the session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student obj
			System.out.println("Creating 3 new Student Obj");
			Student tempStudent1 = new Student("Daniele", "Perego", "perego@gmail.com");
			Student tempStudent2 = new Student("Stefano", "Public", "public@gmail.com");
			Student tempStudent3 = new Student("Michele", "Franco", "franco@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the obj
			System.out.println("Saving the Student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}


	}

}
