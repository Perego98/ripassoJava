package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	private String[] fortuneArray = {"Today is your lucky day!", "Good Luck", 
			"folow the raindow and you will find a pot full of gold!"};
	
	@Override
	public String getFortune() {
		Random random = new Random();
		return fortuneArray[random.nextInt(fortuneArray.length)];
	}

}
