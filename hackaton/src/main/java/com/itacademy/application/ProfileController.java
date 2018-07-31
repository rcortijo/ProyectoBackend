package com.itacademy.application;


import java.util.ArrayList;
import java.util.List;

import com.itacademy.application.dto.ProfileDTO;
import com.itacademy.domain.Menu;
import com.itacademy.domain.Profile;
import com.itacademy.persistence.ProfileRepository;

public class ProfileController {

	private ProfileRepository repository;
	
	public ProfileController() {
		repository = new ProfileRepository();
	}
	
	public ProfileDTO createProfile(String name) throws Exception{
		Profile profile = null;
		if(repository.getProfileName(name) == null) {
			profile = new Profile(name);
			repository.saveProfile(profile);
		}else {
			throw new Exception();
		}
		return new ProfileDTO(profile);
	}
	
	public List<ProfileDTO> getAllProfiles(){
		List<ProfileDTO> lista = new ArrayList<>();
        for(Profile obj :repository.getAllProfiles()){
        	ProfileDTO dto = new ProfileDTO(obj);
        	lista.add(dto);
        }
        return lista;
	}
	
	public ProfileDTO addMenu(int idProfile, String name,String url, String icon) throws Exception{
		Profile profile = repository.getProfileId(idProfile);
		Menu menu = null;
		if(repository.getProfileName(name) == null) {
			menu = new Menu(name,url,icon);
			profile.addMenu(menu);
		}else {
			throw new Exception();
		}
		profile = repository.getProfileId(idProfile);
		return new ProfileDTO(profile);
	}
	
}
