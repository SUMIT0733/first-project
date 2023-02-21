package com.sumit0733.spring.firstproject.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Sumit", LocalDate.now().minusYears(24)));
		users.add(new User(2, "Parth", LocalDate.now().minusYears(22)));
		users.add(new User(3, "Adam", LocalDate.now().minusYears(21)));
		users.add(new User(4, "James", LocalDate.now().minusYears(25)));
	}
	
	public List<User> findall(){
		return users;
	}
	
	
}
