package com.luv2code.springdemo;

public class KarateSensei implements Coach {

	//define a private field for dependency
	private FortuneService fortuneService;
	
	public KarateSensei(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do 3 kata of your choice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
