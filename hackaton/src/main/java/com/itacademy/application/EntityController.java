package com.itacademy.application;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.application.dto.EntityDTO;
import com.itacademy.domain.Entity;
import com.itacademy.domain.Profile;
import com.itacademy.persistence.EntityRepository;
import com.itacademy.persistence.ProfileRepository;


public class EntityController {

	private EntityRepository repository;
	private ProfileRepository repositoryProfile;
	
	public EntityController() {
		repository = new EntityRepository();
		repositoryProfile = new ProfileRepository();
	}
	
	public EntityDTO createEntity(String name, String lastName, String email, String password, int idProfile,String businessName) throws Exception{
		Entity entity = null;
		if(repository.getEntityByName(businessName) == null) {
			Profile profile = repositoryProfile.getProfileId(idProfile);
			entity = new Entity(name,lastName,email,password, profile, businessName);
			repository.saveEntity(entity);
		}else {
			throw new Exception();
		}
		return new EntityDTO(entity);
	}
	
	public EntityDTO updateEntity(int idEntity, String businessName) throws Exception{
		if(idEntity > 0) {
			if(!businessName.trim().equals("")) {
				for(Entity obj : repository.getAllEntitys()) {
					if(obj.getIdEntity() == idEntity) {
						obj.setBusinessName(businessName);
					}
				}
			}else {
				throw new Exception();
			}
		}
		Entity entity = repository.getEntityById(idEntity);
		return new EntityDTO(entity);
	}
	
	public EntityDTO getEntity(int idEntity) throws Exception{
		Entity entity = repository.getEntityById(idEntity);
		return new EntityDTO(entity);
	}
	
	public List<EntityDTO> getAllEntitys(){
		List<EntityDTO> lista = new ArrayList<>();
        for(Entity obj :repository.getAllEntitys()){
        	EntityDTO dto = new EntityDTO(obj);
        	lista.add(dto);
        }
        return lista;
	}

	public EntityDTO removeEntity(int idEntity) throws Exception{
		if(idEntity<=0) {
		    throw new Exception();
		}
		Entity entity = repository.getEntityById(idEntity);
		repository.removeEntity(entity);
		return new EntityDTO(entity);
	}
	
}
