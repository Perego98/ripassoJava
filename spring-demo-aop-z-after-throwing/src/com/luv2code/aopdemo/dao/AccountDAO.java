package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	// add a new method: findAccounts()
	
	public List<Account> findAccount(boolean tripWire){
		
		// simualte a n exeption
		if(tripWire) {
			throw new RuntimeException("No soup for you!!");
		}
		
		
		List<Account> myAccount = new ArrayList<>();
		
		// create sample account
		Account temp1 = new Account("Daniele", "Silver");
		Account temp2 = new Account("Matteo", "Platinum");
		Account temp3 = new Account("Michele", "Gold");
		
		// add them to our account list
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);
		
		return myAccount;
	}
	
	
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	} 
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": getName");
		return name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode");
		return serviceCode;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName");
		this.name = name;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode");
		this.serviceCode = serviceCode;
	}

	
	
}
