package com.itacademy.persistence;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.domain.Entity;

public class EntityRepository {

	private static List<Entity> listEntities = new ArrayList<>();
	
	public List<Entity> getAllEntitys(){
		return new ArrayList<>(listEntities);
	}	
	
	public void saveEntity(Entity entity) throws Exception{
		if(entity==null) {
	        throw new Exception();
	    }
		listEntities.add(entity);
	}

	public Entity getEntityByName(String businessName) {
		for(int i=0; i<listEntities.size();i++) {
			if(listEntities.get(i).getBusinessName().equals(businessName)) {
				return listEntities.get(i);
			}
		}
		return null;
	}
	
	public Entity getEntityById(int idEntity) {
		for(int i=0; i<listEntities.size();i++) {
			if(listEntities.get(i).getIdEntity() == idEntity) {
				return listEntities.get(i);
			}
		}
		return null;
	}
	
	public void removeEntity(Entity entity) throws Exception{
		if(entity==null) {
		    throw new Exception();
		}
		listEntities.remove(entity);
	}

	public Entity login(String email, String password) {
		Entity entity=null;
    	for(int i=0;i<listEntities.size();i++) {
    		if(listEntities.get(i).getEmail().equals(email)) {
    			if(listEntities.get(i).getPassword().equals(password)) {
    				entity = listEntities.get(i);
    				return entity;
    			}
    		}
    	}
    	return entity;
	}
}
