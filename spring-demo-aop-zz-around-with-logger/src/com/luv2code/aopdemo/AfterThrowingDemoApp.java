 package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the account
		List<Account> theAccounts = null;
		try {
			// simulate exception
			boolean tripWire = true;
			theAccountDAO.findAccount(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain program... caught exception: " + e);
		}
		
		
		// display the accounts
		System.out.println("\n\nMain porgram: AfterThrowingDemoApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();

	}

}
