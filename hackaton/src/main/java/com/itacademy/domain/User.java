package com.itacademy.domain;

import com.google.gson.annotations.Expose;

public class User {

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
	@Expose
	private Entity entity;
	private static int COUNT=1;
	
	public User(String name, String lastName, String email, String password, Profile profile) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.profile = profile;
		this.entity = null;
		this.idUser = COUNT;
		COUNT++;
	}
	public User(String name, String lastName, String email, String password, Profile profile, Entity entity) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.profile = profile;
		this.entity = entity;
		this.idUser = COUNT;
		COUNT++;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Entity getEntity() {
		return entity;
	}
	
	
	
}
