package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create the session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student obj
//			Instructor tempInstrucotr = 
//					new Instructor("Daniele", "Perego", "peregopr@gmail.com");
//			
//			InstructorDetail tempInstrucotrDetail = 
//					new InstructorDetail("http://www.peregoDaniele.com/youtube", "Karate");
			
			Instructor tempInstrucotr = 
					new Instructor("Davide", "Pisa", "pisaD@gmail.com");
			
			InstructorDetail tempInstrucotrDetail = 
					new InstructorDetail("http://www.pisaDavide.com/youtube", "Guitar");
			
			
			// associate the obj
			tempInstrucotr.setInstructionDeatail(tempInstrucotrDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of cascadeType.ALL
			//
			System.out.println("Saving instrucor:" + tempInstrucotr);
			session.save(tempInstrucotr);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
