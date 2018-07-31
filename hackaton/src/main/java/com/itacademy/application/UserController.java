package com.itacademy.application;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.application.dto.EntityDTO;
import com.itacademy.application.dto.UserDTO;
import com.itacademy.domain.Entity;
import com.itacademy.domain.Profile;
import com.itacademy.domain.User;
import com.itacademy.persistence.EntityRepository;
import com.itacademy.persistence.ProfileRepository;
import com.itacademy.persistence.UserRepository;

public class UserController {

	private UserRepository repositoryUser;
	private ProfileRepository repositoryProfile;
	private EntityRepository repositoryEntity;
	
	public UserController() {
		repositoryUser = new UserRepository();
		repositoryProfile = new ProfileRepository();
		repositoryEntity = new EntityRepository();
	}
	
	public UserDTO createUser(String name, String lastname, String email, String password, int idProfile, int idEntity) throws Exception{
		User user = null;
		if(repositoryUser.getUserByEmail(email) == null && idProfile > 0) {
			
			Profile profile = repositoryProfile.getProfileId(idProfile);
			Entity entity = repositoryEntity.getEntityById(idEntity);
			user = new User(name, lastname, email, password, profile,entity);
			repositoryUser.saveUser(user);
		}else {
			throw new Exception();
		}
		return new UserDTO(user);
	}
	
	public List<UserDTO> getAllUsers(){
		List<UserDTO> lista = new ArrayList<>();
        for(User obj :repositoryUser.getAllUsers()){
        	UserDTO dto = new UserDTO(obj);
        	lista.add(dto);
        }
        return lista;
	}
	
	public UserDTO updateUser(int idUser, String name, String lastname, String email, String password, int idProfile) throws Exception{
		
		if(idProfile > 0) {
			for(User user : repositoryUser.getAllUsers()) {
				if(user.getIdUser() == idUser) {
					if(!name.trim().equals(""))
						user.setName(name);
					if(!lastname.trim().equals(""))
						user.setLastName(lastname);
					if(!email.trim().equals(""))
						user.setEmail(email);
					if(!password.trim().equals(""))
						user.setPassword(password);
					if(idProfile > 0) {
						Profile profile = repositoryProfile.getProfileId(idProfile);
						user.setProfile(profile);
					}
				}
			}
		}else {
			throw new Exception();
		}
		User user = repositoryUser.getUserById(idUser);
		return new UserDTO(user);
	}
	
	public UserDTO removeUser(int idUser) throws Exception{
		if(idUser<=0) {
		    throw new Exception();
		}
		User user = repositoryUser.getUserById(idUser);
		repositoryUser.removeUser(user);
		return new UserDTO(user);
	}
	
	public UserDTO loginUser(String email, String password) throws Exception{
		if(email.trim().equals("") || password.trim().equals("")) {
		    throw new Exception();
		}
		User user = repositoryUser.login(email, password);
		return new UserDTO(user);
	}
	public EntityDTO loginEntity(String email, String password) throws Exception{
		if(email.trim().equals("") || password.trim().equals("")) {
		    throw new Exception();
		}
		Entity entity = repositoryEntity.login(email, password);
		return new EntityDTO(entity);
	}

	public List<UserDTO> getAllUsersByEntity(int idEntity) {
		List<UserDTO> lista = new ArrayList<>();
        for(User obj :repositoryUser.getAllUsers()){
        	if(obj.getEntity().getIdEntity() == idEntity) {
            	lista.add(new UserDTO(obj));
        	}
        }
        return lista;
	}

	
}
