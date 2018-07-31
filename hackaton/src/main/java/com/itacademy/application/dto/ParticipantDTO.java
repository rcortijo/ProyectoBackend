package com.itacademy.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Participant;
import com.itacademy.domain.User;

public class ParticipantDTO {

	@Expose
	private int idParticipant;
	@Expose
	private User user;
	@Expose
	private int assignedVotes;
	
	public ParticipantDTO(Participant participant) {
		this.idParticipant = participant.getIdParticipant();
		this.user = participant.getUser();
		this.assignedVotes = participant.getAssignedVotes();
	}

	public int getIdParticipant() {
		return idParticipant;
	}

	public User getUser() {
		return user;
	}

	public int getAssignedVotes() {
		return assignedVotes;
	}
	
	
}
