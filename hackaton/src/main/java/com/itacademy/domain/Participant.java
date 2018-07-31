package com.itacademy.domain;

import com.google.gson.annotations.Expose;

public class Participant {

	@Expose
	private int idParticipant;
	@Expose
	private User user;
	@Expose
	private int assignedVotes;
	private static int COUNT=1;
	
	public Participant(User user, int assignedVotes) {
		this.user = user;
		this.assignedVotes = assignedVotes;
		this.idParticipant = COUNT;
		COUNT++;
	}

	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAssignedVotes() {
		return assignedVotes;
	}

	public void setAssignedVotes(int assignedVotes) {
		this.assignedVotes = assignedVotes;
	}
	
	
	
	
}
