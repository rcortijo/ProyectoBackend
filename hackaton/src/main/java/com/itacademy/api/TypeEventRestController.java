package com.itacademy.api;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.itacademy.application.TypeEventController;
import com.itacademy.application.dto.TypeEventDTO;


@RestController
@RequestMapping("/hackaton")
public class TypeEventRestController {

	@RequestMapping(value="/typesEvent",method=RequestMethod.POST)
	public String createUser(@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String description=(String) json.get("description");
		
		TypeEventDTO typeEvent = null;
		typeEvent = new TypeEventController().createTypeEvent(description);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(typeEvent);
		
	}
	@RequestMapping(value="/typesEvent",method=RequestMethod.GET)
	public String listAllUsers() throws Exception, JsonSyntaxException {		
		
		List<TypeEventDTO> typeEvents = new TypeEventController().getAllTypeEvents();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(typeEvents);
		
	}
	
	@RequestMapping(value="/typesEvent/{idTypeEvent}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable int idTypeEvent, @RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String description=(String) json.get("description");
		
		
		TypeEventDTO typeEvent = null;
		typeEvent = new TypeEventController().updateTypeEvent(idTypeEvent, description);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(typeEvent);
		
	}
	
	@RequestMapping(value="/typesEvent/{idTypeEvent}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable int idTypeEvent) throws Exception, JsonSyntaxException {		

		TypeEventDTO typeEvent = null;
		typeEvent = new TypeEventController().removeTypeEvent(idTypeEvent);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(typeEvent);
		
	}
}
