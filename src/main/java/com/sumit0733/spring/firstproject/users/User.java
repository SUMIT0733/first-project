package com.sumit0733.spring.firstproject.users;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@JsonFilter("User_Filter")
public class User {
	
	@JsonIgnore
	private int ID;
	
	@Size(min = 2, message = "Name size must be greater than 2 characters.")
	@JsonProperty("user_name")
	private String name;
	
	@Past(message = "Birthdate must be in past")
	@JsonProperty("Birth_date")
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
