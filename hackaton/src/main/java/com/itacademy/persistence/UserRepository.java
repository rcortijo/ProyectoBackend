package com.itacademy.persistence;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.domain.User;


public class UserRepository {

	private static List<User> listUsers = new ArrayList<>();
	
	public List<User> getAllUsers(){
		return new ArrayList<>(listUsers);
	}	
	
	public void saveUser(User user) throws Exception{
		if(user==null) {
	        throw new Exception();
	    }
		listUsers.add(user);
	}

	public void removeUser(User user) throws Exception{
		if(user==null) {
		    throw new Exception();
		}
		listUsers.remove(user);
	}
    
    public User getUserById(int id) {
    	for(int i=0; i<listUsers.size();i++) {
    		if(listUsers.get(i).getIdUser() == id) {
    			return listUsers.get(i);
    		}
    	}
    	return null;
    }
    
    public User getUserByEmail(String email) {
    	for(int i=0; i<listUsers.size();i++) {
    		if(listUsers.get(i).getEmail().equals(email)) {
    			return listUsers.get(i);
    		}
    	}
    	return null;
    }
    
    public User login(String email, String password) {
    	User user=null;
    	for(int i=0;i<listUsers.size();i++) {
    		if(listUsers.get(i).getEmail().equals(email)) {
    			if(listUsers.get(i).getPassword().equals(password)) {
    				user = listUsers.get(i);
    				return user;
    			}
    		}
    	}
    	return user;
    }
}
