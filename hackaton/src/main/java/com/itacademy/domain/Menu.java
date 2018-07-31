package com.itacademy.domain;

import com.google.gson.annotations.Expose;

public class Menu {

	@Expose
	private int id;
	@Expose
	private String name;
	@Expose
	private String url;
	@Expose
	private String icon;
	@Expose
	private static int count=1;
	
	public Menu(String name, String url, String icon) {
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.id = count;
		count++;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getIcon() {
		return icon;
	}
	
	
}
