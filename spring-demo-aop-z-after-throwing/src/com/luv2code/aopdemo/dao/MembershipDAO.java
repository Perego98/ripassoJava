package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSyllyMemeber() {
		
		System.out.println(getClass() + ": DOING addSyllyMemeber: addSyllyMemeber A addSyllyMemeber ACCOUNT");
		
		return true;
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": I'm going to spleep now");
		
	}
	
//	public void addSyllyMemeber() {
//		
//		System.out.println(getClass() + ": DOING addSyllyMemeber: addSyllyMemeber A addSyllyMemeber ACCOUNT");
//	} 
	
//	public void addAccount() {
//		
//		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
//	} 
}
