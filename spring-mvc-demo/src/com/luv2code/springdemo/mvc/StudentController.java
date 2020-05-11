package com.luv2code.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

	//@Value("#{countryOptions}") 
	//private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a new student obj
		Student theStudent = new Student();
		
		// add student obj to the model
		theModel.addAttribute("student", theStudent);
		
		// add the country options to the model 
	    //theModel.addAttribute("theCountryOptions", countryOptions); 
		
		return "student-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() +
				" " + theStudent.getLastName() + 
				" Country: " + theStudent.getCountry() +
				" Favorite Language: " + theStudent.getFavoriteLanguage() +
				" Operative System: " + printOpertiveSystem(theStudent));
	
		return "student-confirmation";
	}
	
	private String printOpertiveSystem(Student student) {
		String result = "";
		
		for(int i = 0; i<student.getOperatingSystems().length; i++)
			result += student.getOperatingSystems()[i] + ", ";
		
		return result;
	}
	
}