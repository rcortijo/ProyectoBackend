package com.itacademy.domain;

import com.google.gson.annotations.Expose;

public class Entity extends User{

	@Expose
	private int idEntity;
	@Expose
	private String businessName;
	private static int COUNT=1;
	
	public Entity(String name, String lastName, String email, String password, Profile profile, String businessName) {
		super(name,lastName,email,password,profile);
		this.businessName = businessName;
		this.idEntity = COUNT;
		COUNT++;
	}

	public int getIdEntity() {
		return idEntity;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
}
