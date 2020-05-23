package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {

	private static Logger myLogger = 
			Logger.getLogger(MyDemoLoginAspect.class.getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint)  throws Throwable{
		
		// print advising
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n==========>>> Execute @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// giver user a custom message
			result = "Accident!, NO PROBLEM...";
		}
		
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		//comupte duration and display it
		long duration = end - begin;
		myLogger.info("\n=======>>> Duration: " + duration/1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n==========>>> Execute @After (finally) on method: " + method);
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
	
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n==========>>> Execute @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n==========>>> The exception is: " + theExc);
	}
	
	
	
	// add a new advice for returning 
	@AfterReturning(
				pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
				returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n==========>>> Execute @AfterReturning on method: " + method);
		
		myLogger.info("\n==========>>> result is: " + result);
		
		// let's post -process the data ... let's modify it
		
		// convert the account names to UPPERCASE
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n==========>>> result in uppercase is: " + result);
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop throught accounts
		
		for(Account tempAccount : result) {
			
			// geet uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
			
		}
		
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Execution @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Mathod: " + methodSig);
		
		// display method argumetns
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				//  downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("Account name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());				
			}
		}
		
	}
}



	
















