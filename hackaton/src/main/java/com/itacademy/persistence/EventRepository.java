package com.itacademy.persistence;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.domain.Event;

public class EventRepository {

	private static List<Event> listEvents = new ArrayList<>();
	
	public List<Event> getAllEvents(){
		return new ArrayList<>(listEvents);
	}	
	
	public void saveEvent(Event event) throws Exception{
		if(event==null) {
	        throw new Exception();
	    }
		listEvents.add(event);
	}

	public Event getEventByTitle(String title) {
		for(int i=0; i<listEvents.size();i++) {
			if(listEvents.get(i).getTitle().equals(title)) {
				return listEvents.get(i);
			}
		}
		return null;
	}
	
	public Event getEventById(int idEvent) {
		for(int i=0; i<listEvents.size();i++) {
			if(listEvents.get(i).getIdEvent() == idEvent) {
				return listEvents.get(i);
			}
		}
		return null;
	}
	
	public void removeEvent(Event event) throws Exception{
		if(event==null) {
		    throw new Exception();
		}
		listEvents.remove(event);
	}
}
