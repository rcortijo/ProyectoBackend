package com.itacademy.application.dto;

import com.itacademy.domain.Entity;
import com.itacademy.domain.Event;
import com.itacademy.domain.Option;
import com.itacademy.domain.Participant;
import com.itacademy.domain.Question;
import com.itacademy.domain.Response;

public class ResponseDTO {

	private int idResponse;
	private Entity entity;
	private Event event;
	private Participant participant;
	private Question question;
	private Option option;
	private String comment;
	
	public ResponseDTO(Response response) {
		this.idResponse = response.getIdResponse();
		this.entity = response.getEntity();
		this.event = response.getEvent();
		this.participant = response.getParticipant();
		this.question = response.getQuestion();
		this.option = response.getOption();
		this.comment = response.getComment();
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
