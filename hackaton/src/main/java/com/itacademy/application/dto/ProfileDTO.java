package com.itacademy.application.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Menu;
import com.itacademy.domain.Profile;

public class ProfileDTO {

	@Expose
	private int id;
	@Expose
	private String name;

	private List<Menu> menus;
	
	public ProfileDTO(Profile profile) {
		this.id = profile.getIdProfile();
		this.name = profile.getName();
		this.menus = profile.getMenus();
	}
	
	public int getIdProfile() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	
}
