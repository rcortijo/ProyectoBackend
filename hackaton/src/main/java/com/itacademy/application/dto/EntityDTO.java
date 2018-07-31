package com.itacademy.application.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Entity;
import com.itacademy.domain.Event;
import com.itacademy.domain.Profile;

public class EntityDTO{

	@Expose
	private int idEntity;
	@Expose
	private String businessName;
	private List<Event> events;
	
	@Expose
	private String name;
	@Expose
	private String lastName;
	@Expose
	private String email;
	@Expose
	private String password;
	@Expose
	private Profile profile;
	
	
	public EntityDTO(Entity entity) {
		
		this.idEntity = entity.getIdEntity();
		this.businessName = entity.getBusinessName();
		
		this.name = entity.getName();
		this.lastName = entity.getLastName();
		this.email = entity.getEmail();
		this.password = entity.getPassword();
		this.profile = entity.getProfile();
	}

	public int getIdEntity() {
		return idEntity;
	}

	public String getBusinessName() {
		return businessName;
	}

	public List<Event> getEvents() {
		return events;
	}
	
	
}
