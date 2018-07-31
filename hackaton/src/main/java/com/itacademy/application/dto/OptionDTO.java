package com.itacademy.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Option;

public class OptionDTO {

	@Expose
	private int idOption;
	@Expose
	private String description;
	
	public OptionDTO(Option option) {
		this.idOption = option.getIdOption();
		this.description = option.getDescription();
	}

	public int getIdOption() {
		return idOption;
	}

	public String getDescription() {
		return description;
	}
	
	
}
