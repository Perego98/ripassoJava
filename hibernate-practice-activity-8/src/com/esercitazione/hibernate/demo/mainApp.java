package com.esercitazione.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.esercitazione.hibernate.demo.entity.Employee;



public class mainApp {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();
				
				// create the session
				Session session = factory.getCurrentSession();
				
				try {
					// create an obj
					System.out.println("Creating a new Employee Obj");
					Employee tempEmployee1 = new Employee("Daniele", "Perego", "Google");
					Employee tempEmployee2 = new Employee("Marco", "Aurelio", "Microsoft");
					Employee tempEmployee3 = new Employee("Giulio", "Cesare", "Activision");
					Employee tempEmployee4 = new Employee("Augusto", "Tiberio", "Origin");
					Employee tempEmployee5 = new Employee("Caio", "Calligola", "Google");
					
					// start a transaction
					session.beginTransaction();
					
					// save the obj
					System.out.println("Saving the Employees...");
					session.save(tempEmployee1);
					session.save(tempEmployee2);
					session.save(tempEmployee3);
					session.save(tempEmployee4);
					session.save(tempEmployee5);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Employees Saved");
					
					
					// retrieve employees by primary key
					
					//get a new session and start a transaction
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					// retrieve employee based on the id
					System.out.println("\nGetting employee with id: " + tempEmployee3.getId());
					
					Employee myEmployee = session.get(Employee.class, tempEmployee3.getId());
							
					System.out.println("Print myEmploytee: " + myEmployee +"\n\n");
					
					// Develop code to query objects to find employees for a given company.
					List<Employee> theEmployees = session.createQuery("from Employee e where e.company='google'").getResultList();
					
					// print the result
					System.out.println("Print theEmploytees with company name like google");
					
					for(Employee tempEmployee : theEmployees) {
						System.out.println(tempEmployee);
					}
					
					// commit transaction
					session.getTransaction().commit();
					
					// code to delete an object by primary key.
					// i delete any object by id 
					
					int idDelete = 3;
					
					//get a new session and start a transaction
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					System.out.println(">>>>>>>Deleting employees with id=" + idDelete);
					session.createQuery("delete from Employee where id=" + idDelete).executeUpdate();
					
					// commit transaction
					session.getTransaction().commit();
					
				}
				finally {
					factory.close();
				}

	}

}
