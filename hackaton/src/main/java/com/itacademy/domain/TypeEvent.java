package com.itacademy.domain;

import com.google.gson.annotations.Expose;

public class TypeEvent {

	@Expose
	private int idTypeEvent;
	@Expose
	private String description;
	private static int COUNT=1;
	
	public TypeEvent(String description) {
		this.description = description;
		this.idTypeEvent = COUNT;
		COUNT++;
	}

	public int getIdTypeEvent() {
		return idTypeEvent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
