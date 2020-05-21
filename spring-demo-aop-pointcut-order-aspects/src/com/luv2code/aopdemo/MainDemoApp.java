 package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ui.context.Theme;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// GET MEMEBERSHIP BEAN FROM SPRING CONTAINER
		MembershipDAO theMemebershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, false);
		theAccountDAO.doWork();
		
		// call the get/set
		theAccountDAO.setName("Daniele");
		theAccountDAO.setServiceCode("12643");
		System.out.println(theAccountDAO.getName());
		System.out.println(theAccountDAO.getServiceCode());
		
		// call the membership business method
		theMemebershipDAO.addSyllyMemeber();
		theMemebershipDAO.goToSleep();
		
		// close the context
		context.close();

	}

}
