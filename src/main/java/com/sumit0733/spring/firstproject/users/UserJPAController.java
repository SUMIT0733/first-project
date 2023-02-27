package com.sumit0733.spring.firstproject.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserJPAController {

	private UserJPARepository repository;
	private UserDAO userDAO;
	
	public UserJPAController(UserDAO userDAO, UserJPARepository repository) {
		this.userDAO = userDAO;
		this.repository = repository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> findall(){
		List<User> list = repository.findAll();
//		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("user_name","Birth_date","id");
//		FilterProvider FilterProvider = new SimpleFilterProvider().addFilter("User_Filter", filter );
//		mappingJacksonValue.setFilters(FilterProvider );
		return list;
	}
	
	@GetMapping("/jpa/users/{user_id}")
	public User findOne(@PathVariable int user_id) {
		Optional<User> user = repository.findById(user_id);
		
		if(user.isEmpty()) {
			System.out.println("USER NOT FOUND!!!");
			throw new UserNotFoundException("Id Not Found:"+user_id);
		}else {
			System.out.println(user.get());
			return user.get();
		}	
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteOne(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saved_user = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saved_user.getID())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
