package com.itacademy.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Question {

	@Expose
	private int idQuestion;
	@Expose
	private String description;
	@Expose
	private List<Option> options;
	private static int COUNT=1;
	
	public Question(String description) {
		this.description = description;
		this.idQuestion = COUNT;
		COUNT++;
		options = new ArrayList<>();
	}
	
	public int getIdQuestion() {
		return idQuestion;
	}
	public String getDescription() {
		return description;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void addOption(Option option) {
		options.add(option);
	}
	public void removeOption(Option option) {
		options.remove(option);
	}
	
	
}

