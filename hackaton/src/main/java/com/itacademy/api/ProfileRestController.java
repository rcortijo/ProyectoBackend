package com.itacademy.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.itacademy.application.ProfileController;
import com.itacademy.application.dto.ProfileDTO;

import org.json.simple.JSONObject;

@RestController
@RequestMapping("/hackaton")
public class ProfileRestController {

	@RequestMapping(value="/profiles",method=RequestMethod.POST)
	public String createPlayer(@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String name=(String) json.get("name");
		
		ProfileDTO player = null;
		player = new ProfileController().createProfile(name);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(player);
		
	}
	@RequestMapping(value="/profiles",method=RequestMethod.GET)
	public String listAllPlayers() throws Exception, JsonSyntaxException {		
		
		List<ProfileDTO> threws = new ProfileController().getAllProfiles();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(threws);
		
	}
}
