package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

	// this is where we add all of our related advice for loggin
	
	// let's start with @Before advice
	
//	 molto restrittivo
//	@Before("execution(public void addAccount())")
	
//	 ancora piu restrittivo
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	
//	 qualsiasi metodo che iniza con add e che sia public con valore di ritorno void
//	@Before("execution(public void add*())")
	
//	 qualsiasi metodo con qualsiasi tipo di ritorno che inizi con add
//	@Before("execution(* add*())")
	
//	il metodo deve avere in ingresso un parametro di tipo Account
//	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	
//	il metodo deve avere in ingresso zero o poiù parametri
//	@Before("execution(* add*(..))")
	
//	Match any params in a pakage 
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Execution @Before advice on method");
	}
}



	
















