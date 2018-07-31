package com.itacademy.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.TypeEvent;

public class TypeEventDTO {

	@Expose
	private int idTypeEvent;
	@Expose
	private String description;
	
	public TypeEventDTO(TypeEvent typeEvent) {
		this.idTypeEvent = typeEvent.getIdTypeEvent();
		this.description = typeEvent.getDescription();
	}

	public int getIdTypeEvent() {
		return idTypeEvent;
	}

	public String getDescription() {
		return description;
	}

	
	
}
