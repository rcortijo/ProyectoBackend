package com.itacademy.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Profile;
import com.itacademy.domain.User;

public class UserDTO {

	@Expose
	private int idUser;
	@Expose
	private String name;
	@Expose
	private String lastName;
	@Expose
	private String email;
	private String password;
	@Expose
	private Profile profile;
	
	
	public UserDTO(User user) {
		this.idUser = user.getIdUser();
		this.name = user.getName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.profile = user.getProfile();
	}
	
	public int getIdUser() {
		return idUser;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public Profile getProfile() {
		return profile;
	}
	
	
}
