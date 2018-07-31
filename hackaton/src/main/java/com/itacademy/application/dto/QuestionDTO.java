package com.itacademy.application.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Option;
import com.itacademy.domain.Question;

public class QuestionDTO {

	@Expose
	private int idQuestion;
	@Expose
	private String description;
	@Expose
	private List<Option> options;
	
	public QuestionDTO(Question question) {
		this.idQuestion = question.getIdQuestion();
		this.description = question.getDescription();
		this.options = question.getOptions();
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
	
	
}
