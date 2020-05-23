package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		// simulate a delay
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// return a fortune
		
		return "Heavy traffic this morning";
	}

	public String getFortune(boolean tripWire) {
		
		// simulate an exception
		if(tripWire) {
			throw new RuntimeException("Major accident! Problem!");
		}
		
		return getFortune();
	}
}