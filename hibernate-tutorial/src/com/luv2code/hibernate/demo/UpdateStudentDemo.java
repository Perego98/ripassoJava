package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create the session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id
			System.out.println("\n>>>>>>>Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println(">>>>>>>Updating student... ");
			myStudent.setFirstName("Scooby");
			
			// commit transaction
			session.getTransaction().commit();
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// updater email for all student
			System.out.println(">>>>>>>Updating email for all student");
			
			session.createQuery("update Student set email='foo@giambo.com'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println(">>>>>>>Done!");
		}
		finally {
			factory.close();
		}

	}

}
