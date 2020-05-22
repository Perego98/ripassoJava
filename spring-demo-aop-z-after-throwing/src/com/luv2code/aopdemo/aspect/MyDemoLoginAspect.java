package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {

	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
	
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n==========>>> Execute @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n==========>>> The exception is: " + theExc);
	}
	
	
	
	// add a new advice for returning 
	@AfterReturning(
				pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
				returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n==========>>> Execute @AfterReturning on method: " + method);
		
		System.out.println("\n==========>>> result is: " + result);
		
		// let's post -process the data ... let's modify it
		
		// convert the account names to UPPERCASE
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n==========>>> result in uppercase is: " + result);
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
		System.out.println("\n====>>> Execution @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Mathod: " + methodSig);
		
		// display method argumetns
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				//  downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());				
			}
		}
		
	}
}



	
















