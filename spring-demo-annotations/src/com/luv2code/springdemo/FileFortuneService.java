package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "fortuneFile.txt";
	private List<String> fortune;
	
	public FileFortuneService() {

		File theFile = new File(fileName);
		
		System.out.println(">> eeading fortunes from file: " + theFile);
		System.out.println(">> the file exists: " + theFile.exists());
		
		fortune = new ArrayList<String>();
		
		// read fortunes from file
		try (
			BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				fortune.add(tempLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		Random random = new Random();
		return fortune.get(random.nextInt(fortune.size()));
	}

}
