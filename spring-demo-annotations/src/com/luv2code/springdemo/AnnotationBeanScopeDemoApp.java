package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring config file
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrive bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		// printing the result
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nPMemory location for theCoach: " + theCoach);
		
		System.out.println("\nPMemory location for alphaCoach: " + alphaCoach + "\n");
		
		// close the context
		context.close();
	}

}
