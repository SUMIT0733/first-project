package com.sumit0733.spring.firstproject.users;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.sound.midi.VoiceStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saved_user = userDAO.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saved_user.getID())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
