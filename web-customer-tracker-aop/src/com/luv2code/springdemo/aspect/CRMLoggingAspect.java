package com.luv2code.springdemo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {}
	
	// add @before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method calling
		String theMetod = theJoinPoint.getSignature().toShortString();
//		myLogger.info("======>> in @Before: calling method: " + theMetod);
		System.out.println("======>> in @Before: calling method: " + theMetod);
		
		// display method argument
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for(Object tempArg : args) {
//			myLogger.info("=====>>> argumetn: " + tempArg);
			System.out.println("=====>>> argument: " + tempArg);
		}
		
	}
	
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method calling
		String theMetod = theJoinPoint.getSignature().toShortString();
		
		System.out.println("======>> in @afterReturning: calling method: " + theMetod);
		
		// display data return
		System.out.println("======>> result: " + theResult);
				
		
	}
}
