package com.sumit0733.spring.firstproject;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	

	@GetMapping("/courses")
	public List<Course> getCourses(){
		 return Arrays.asList(
				 new Course(1,"Java", "Sumit"),
				 new Course(2, "DevOps", "Sumit"),
				 new Course(3, "Azure", "Parth")
				 );
	}

	
}
