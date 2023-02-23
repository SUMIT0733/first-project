package com.sumit0733.spring.firstproject.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	
	private static List<User> users = new ArrayList<>();
	public static int id = 0;
	static {
		users.add(new User(++id, "Sumit", LocalDate.now().minusYears(24)));
		users.add(new User(++id, "Parth", LocalDate.now().minusYears(22)));
		users.add(new User(++id, "Adam", LocalDate.now().minusYears(21)));
		users.add(new User(++id, "James", LocalDate.now().minusYears(25)));
	}
	
	public List<User> findall(){
		return users;
	}
	
	public User findByID(int id) {
		return users.stream().filter(user -> user.getID() == id).findFirst().orElse(null);
	}
	
	public User addUser(User user) {
		user.setID(++id);
		users.add(user);
		return user;
	}

	public void deleteByID(int id) {
		users.removeIf(user -> user.getID() == id);
	}
}
