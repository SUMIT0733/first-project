package com.sumit0733.spring.firstproject.users;

import java.time.LocalDate;

public class User {
	private int ID;
	private String name;
	private LocalDate birthDate;
	
	
	public User(int iD, String name, LocalDate birthDate) {
		super();
		ID = iD;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
}
