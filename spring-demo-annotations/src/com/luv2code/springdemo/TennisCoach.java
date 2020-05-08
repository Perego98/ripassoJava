package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	//@Qualifier("randomFortuneService")
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach:  inside default constructor");
	}

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach:  inside doMyStartupStuff()");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanStuff() {
		System.out.println(">> TennisCoach:  inside doMyCleanStuff()");
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practise your backhand volley";
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
		return team;
	}

	
	//@Autowired
	//private void doSomeCrazyStuff(FortuneService fortuneService) {
	//	System.out.println(">> TennisCoach:  inside doSomeCrazyStuff() method");
	//	this.fortuneService = fortuneService;
	//}
	
	// define the setter method
	//@Autowired
	//private void setFortuneService(FortuneService fortuneService) {
	//	System.out.println(">> TennisCoach:  inside setFortuneService() method");
	//	this.fortuneService = fortuneService;
	//}

	
}
