package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;


public class SwimCoach implements Coach {

	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "swim 100 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getTeam() {
		// TODO Auto-generated method stub
		return team;
	}

}
