package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortune = {"Today is a good day!", "Follow the rainbow!", "Is a Lucky day!"};
	
	@Override
	public String getFortune() {
		Random random = new Random();
		
		return fortune[random.nextInt(fortune.length)];
	}

}
