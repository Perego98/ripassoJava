package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
	
		try {
			
			// create obj mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file map/convert to Java POJO
			Student theStudent =
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			
			// print data
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			System.out.println(theStudent.getAddress());
			System.out.println("Languages = " + theStudent.getLanguages());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
