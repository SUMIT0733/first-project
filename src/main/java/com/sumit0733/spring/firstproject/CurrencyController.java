package com.sumit0733.spring.firstproject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
	
	@Autowired
	public CurrencyServiceConfiguration configuration; 

	@GetMapping("/currency")
	public CurrencyServiceConfiguration getCourses(){
		 return configuration;
	}

	
}
