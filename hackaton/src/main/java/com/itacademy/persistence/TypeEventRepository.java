package com.itacademy.persistence;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.domain.TypeEvent;

public class TypeEventRepository {

	private static List<TypeEvent> listTypeEvents = new ArrayList<>();
	
	public List<TypeEvent> getAllTypeEvents(){
		return new ArrayList<>(listTypeEvents);
	}	
	
	public void saveTypeEvent(TypeEvent typeEvent) throws Exception{
		if(typeEvent==null) {
	        throw new Exception();
	    }
		listTypeEvents.add(typeEvent);
	}

	public TypeEvent getTypeEventByDescription(String name) {
		TypeEvent typeEvent = null;
		for(int i=0; i<listTypeEvents.size();i++) {
			if(listTypeEvents.get(i).getDescription().equals(name)) {
				typeEvent = listTypeEvents.get(i);
				return typeEvent;
			}
		}
		return null;
	}
	
	public TypeEvent getTypeEventById(int idTypeEvent) {
		for(int i=0; i<listTypeEvents.size();i++) {
			if(listTypeEvents.get(i).getIdTypeEvent() == idTypeEvent) {
				return listTypeEvents.get(i);
			}
		}
		return null;
	}
	
	public void removeTypeEvent(TypeEvent typeEvent) throws Exception{
		if(typeEvent==null) {
		    throw new Exception();
		}
		listTypeEvents.remove(typeEvent);
	}
}
