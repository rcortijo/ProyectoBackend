package com.itacademy.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Profile {

	@Expose
	private int idProfile;
	@Expose
	private String name;
	private List<Menu> menus;
	private static int COUNT=1;
	
	public Profile(String name) {
		this.name = name;
		this.menus = new ArrayList<>();
		this.idProfile=COUNT;
		COUNT++;
	}
	
	public int getIdProfile() {
		return idProfile;
	}
	public String getName() {
		return name;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void addMenu(Menu menu) {
		menus.add(menu);
	}
	
}
