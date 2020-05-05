package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	//define a private field for dependency
	private FortuneService fortuneService;
	
	
	
	public TrackCoach() {
		super();
	}

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	// ad an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: insisde method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: insisde method doMyCleanupStuffYoYo");
	}
}
