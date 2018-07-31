package com.itacademy.domain;

public class Response {

	private int idResponse;
	private Entity entity;
	private Event event;
	private Participant participant;
	private Question question;
	private Option option;
	private String comment;
	private static int COUNT=1;
	
	public Response(Entity entity, Event event, Participant participant, Question question, Option option,
			String comment) {
		this.entity = entity;
		this.event = event;
		this.participant = participant;
		this.question = question;
		this.option = option;
		this.comment = comment;
		this.idResponse = COUNT;
		COUNT++;
	}

	public int getIdResponse() {
		return idResponse;
	}

	public Entity getEntity() {
		return entity;
	}

	public Event getEvent() {
		return event;
	}

	public Participant getParticipant() {
		return participant;
	}

	public Question getQuestion() {
		return question;
	}

	public Option getOption() {
		return option;
	}

	public String getComment() {
		return comment;
	}
	
	
	
}
