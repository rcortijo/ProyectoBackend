package com.itacademy.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Event {

	@Expose
	private int idEvent;
	@Expose
	private String title;
	@Expose
	private String description;
	@Expose
	private String logo;
	@Expose
	private String date;
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
	
	private static int COUNT=1;
	
	public Event(String title, String description, String date, TypeEvent typeEvent, Entity entity) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
		this.logo = "";
		this.typeEvent = typeEvent;
		this.entity = entity;
		this.toPost = false;
		this.closed = false;
		this.idEvent = COUNT;
		COUNT++;
		this.participants = new ArrayList<>();
		this.questions = new ArrayList<>();
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

	public void setTitle(String title) {
		this.title=title;
	}

	public void setDescription(String description) {
		this.description=description;
	}

	public String getDate() {
		return date;
	}

	public void setLogo(String logo) {
		this.logo=logo;
	}
	
	public void addParticipant(Participant participant) {
		participants.add(participant);
	}
	public void removeParticipant(Participant participant) {
		participants.remove(participant);
	}
	public void addQuestion(Question question) {
		questions.add(question);
	}
	public void removeQuestion(Question question) {
		questions.remove(question);
	}
	
}
