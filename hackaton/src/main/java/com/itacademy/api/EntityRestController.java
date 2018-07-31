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
import com.itacademy.application.EntityController;
import com.itacademy.application.UserController;
import com.itacademy.application.dto.EntityDTO;
import com.itacademy.application.dto.UserDTO;

@RestController
@RequestMapping("/hackaton")
public class EntityRestController {

	@RequestMapping(value="/entities",method=RequestMethod.POST)
	public String createEntity(@RequestBody JSONObject json) throws Exception, JsonSyntaxException {	
		String name=(String) json.get("name");
		String lastName=(String) json.get("lastName");
		String email=(String) json.get("email");
		String password=(String) json.get("password");
		int idProfile=(int) json.get("idProfile");
		String businessName=(String) json.get("businessName");
		
		EntityDTO entity = null;
		entity = new EntityController().createEntity(name,lastName,email,password,idProfile,businessName);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(entity);
		
	}
	
	
	@RequestMapping(value="/entities",method=RequestMethod.GET)
	public String listAllEntitys() throws Exception, JsonSyntaxException {		
		
		List<EntityDTO> entitys = new EntityController().getAllEntitys();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(entitys);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}",method=RequestMethod.GET)
	public String getEntity(@PathVariable int idEntity) throws Exception, JsonSyntaxException {		
		
		EntityDTO entity = new EntityController().getEntity(idEntity);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(entity);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}",method=RequestMethod.PUT)
	public String updateEntity(@PathVariable int idEntity, @RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String businessName = (String) json.get("businessName");
		
		EntityDTO entity = null;
		entity = new EntityController().updateEntity(idEntity, businessName);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(entity);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}",method=RequestMethod.DELETE)
	public String deleteEntity(@PathVariable int idEntity) throws Exception, JsonSyntaxException {		

		EntityDTO entity = null;
		entity = new EntityController().removeEntity(idEntity);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(entity);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}/users",method=RequestMethod.GET)
	public String listAllUsers(@PathVariable int idEntity) throws Exception, JsonSyntaxException {		
		
		List<UserDTO> users = new UserController().getAllUsersByEntity(idEntity);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(users);
		
	}
}
