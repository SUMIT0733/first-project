package com.sumit0733.spring.firstproject.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//	@Autowired
	public UserDAO userDAO;
	
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	} 
	
	@GetMapping("/users")
	public List<User> findall(){
		return userDAO.findall();
	}
	
	@GetMapping("/users/{id}")
	public List<User> findOne(@PathVariable int id) {
		return userDAO.findall();
	}
}
