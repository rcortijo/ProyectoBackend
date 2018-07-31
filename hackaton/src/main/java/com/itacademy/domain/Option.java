package com.itacademy.domain;

import com.google.gson.annotations.Expose;

public class Option {

	@Expose
	private int idOption;
	@Expose
	private String description;
	private static int COUNT=1;
	
	public Option(String description) {
		this.description = description;
		this.idOption = COUNT;
		COUNT++;
	}

	public int getIdOption() {
		return idOption;
	}

	public String getDescription() {
		return description;
	}
	
	
}
