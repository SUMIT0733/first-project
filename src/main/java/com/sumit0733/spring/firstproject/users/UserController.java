package com.sumit0733.spring.firstproject.users;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import jakarta.validation.Valid;

@RestController
public class UserController {

//	@Autowired
	public UserDAO userDAO;
	
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	} 
	
	@GetMapping("/users")
	public MappingJacksonValue findall(){
		List<User> list = userDAO.findall();
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("user_name","Birth_date");
		FilterProvider FilterProvider = new SimpleFilterProvider().addFilter("User_Filter", filter );
		mappingJacksonValue.setFilters(FilterProvider );
		
		return mappingJacksonValue;
	}
	
	@GetMapping("/users/{id}")
	public User findOne(@PathVariable int id) {
		User user = userDAO.findByID(id);
		
		if(user==null)
			throw new UserNotFoundException("Id Not Found:"+id);
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteOne(@PathVariable int id) {
		userDAO.deleteByID(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saved_user = userDAO.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saved_user.getID())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
