package com.itacademy.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.itacademy.application.EventController;
import com.itacademy.application.UserController;
import com.itacademy.application.dto.EntityDTO;
import com.itacademy.application.dto.EventDTO;
import com.itacademy.application.dto.UserDTO;

import org.json.simple.JSONObject;

@RestController
@RequestMapping("/hackaton")
public class UserRestController {

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String email=(String) json.get("email");
		String password=(String) json.get("password");
		int idProfile=(int) json.get("idProfile");
		
		UserDTO user = null;
		EntityDTO entity = null;
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		if(idProfile==1) {
			entity = new UserController().loginEntity(email, password);
			return gson.toJson(entity);
		}else {
			user = new UserController().loginUser(email, password);
			return gson.toJson(user);
		}
		
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public String createUser(@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String name=(String) json.get("name");
		String lastName=(String) json.get("lastName");
		String email=(String) json.get("email");
		String password=(String) json.get("password");
		int idProfile=(int) json.get("idProfile");
		int idEntity=(int) json.get("idEntity");
		
		UserDTO user = null;
		user = new UserController().createUser(name, lastName, email, password, idProfile, idEntity);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(user);
		
	}
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String listAllUsers() throws Exception, JsonSyntaxException {		
		
		List<UserDTO> users = new UserController().getAllUsers();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(users);
		
	}
	
	@RequestMapping(value="/users/{idUser}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable int idUser, @RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String name=(String) json.get("name");
		String lastName=(String) json.get("lastName");
		String email=(String) json.get("email");
		String password=(String) json.get("password");
		int idProfile=(int) json.get("idProfile");
		
		UserDTO user = null;
		user = new UserController().updateUser(idUser, name, lastName, email, password, idProfile);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(user);
		
	}
	
	@RequestMapping(value="/users/{idUser}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable int idUser) throws Exception, JsonSyntaxException {		

		UserDTO user = null;
		user = new UserController().removeUser(idUser);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(user);
		
	}
	
	@RequestMapping(value="/users/{idUser}/events",method=RequestMethod.GET)
	public String listAllEventsUser(@PathVariable int idUser) throws Exception, JsonSyntaxException {		
		
		List<EventDTO> events = new EventController().getAllEventsByUser(idUser);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(events);
		
	}
}
