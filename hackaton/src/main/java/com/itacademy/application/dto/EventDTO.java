package com.itacademy.application.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Entity;
import com.itacademy.domain.Event;
import com.itacademy.domain.Participant;
import com.itacademy.domain.Question;
import com.itacademy.domain.TypeEvent;

public class EventDTO {

	@Expose
	private int idEvent;
	@Expose
	private String title;
	@Expose
	private String description;
	@Expose
	private String date;
	@Expose
	private String logo;
	@Expose
	private boolean toPost;
	@Expose
	private boolean closed;
	@Expose
	private TypeEvent typeEvent;
	@Expose
	private List<Question> questions;
	@Expose
	private List<Participant> participants;  
	@Expose
	private Entity entity;
	
	public EventDTO(Event event) {
		this.idEvent = event.getIdEvent();
		this.title = event.getTitle();
		this.description = event.getDescription();
		this.date = event.getDate();
		this.logo = event.getLogo();
		this.toPost = event.isToPost();
		this.closed = event.isClosed();
		this.typeEvent = event.getTypeEvent();
		this.questions = event.getQuestions();
		this.participants = event.getParticipants();
		this.entity = event.getEntity();
	}

	public int getIdEvent() {
		return idEvent;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}
	
	public String getLogo() {
		return logo;
	}

	public boolean isToPost() {
		return toPost;
	}

	public boolean isClosed() {
		return closed;
	}

	public TypeEvent getTypeEvent() {
		return typeEvent;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public Entity getEntity() {
		return entity;
	}	
	
	
}
