package com.itacademy.application;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.application.dto.TypeEventDTO;
import com.itacademy.domain.TypeEvent;
import com.itacademy.persistence.TypeEventRepository;

public class TypeEventController {

	private TypeEventRepository repository;
	
	public TypeEventController() {
		repository = new TypeEventRepository();
	}
	
	public TypeEventDTO createTypeEvent(String description) throws Exception{
		TypeEvent typeEvent = null;
		if(repository.getTypeEventByDescription(description) == null) {
			
			typeEvent = new TypeEvent(description);
			repository.saveTypeEvent(typeEvent);
		}else {
			throw new Exception();
		}
		return new TypeEventDTO(typeEvent);
	}
	
	public List<TypeEventDTO> getAllTypeEvents(){
		List<TypeEventDTO> lista = new ArrayList<>();
        for(TypeEvent obj :repository.getAllTypeEvents()){
        	TypeEventDTO dto = new TypeEventDTO(obj);
        	lista.add(dto);
        }
        return lista;
	}
	
	public TypeEventDTO updateTypeEvent(int idTypeEvent, String description) throws Exception{
		
		if(!description.trim().equals("")) {
			for(int i=0;i<repository.getAllTypeEvents().size();i++) {
				if(repository.getAllTypeEvents().get(i).getIdTypeEvent() == idTypeEvent) {
					repository.getAllTypeEvents().get(i).setDescription(description);
				}
			}
		}else {
			throw new Exception();
		}
		TypeEvent typeEvent = repository.getTypeEventById(idTypeEvent);
		return new TypeEventDTO(typeEvent);
	}
	
	public TypeEventDTO removeTypeEvent(int idTypeEvent) throws Exception{
		if(idTypeEvent<=0) {
		    throw new Exception();
		}
		TypeEvent typeEvent = repository.getTypeEventById(idTypeEvent);
		repository.removeTypeEvent(typeEvent);
		return new TypeEventDTO(typeEvent);
	}
}
