package com.itacademy.application;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.application.dto.EventDTO;
import com.itacademy.application.dto.OptionDTO;
import com.itacademy.application.dto.ParticipantDTO;
import com.itacademy.application.dto.QuestionDTO;
import com.itacademy.application.dto.ResponseDTO;
import com.itacademy.domain.Entity;
import com.itacademy.domain.Event;
import com.itacademy.domain.Option;
import com.itacademy.domain.Participant;
import com.itacademy.domain.Question;
import com.itacademy.domain.Response;
import com.itacademy.domain.TypeEvent;
import com.itacademy.domain.User;
import com.itacademy.persistence.EntityRepository;
import com.itacademy.persistence.EventRepository;
import com.itacademy.persistence.ResponseRepository;
import com.itacademy.persistence.TypeEventRepository;
import com.itacademy.persistence.UserRepository;

public class EventController {

	private EntityRepository repositoryEntity;
	private TypeEventRepository repositoryTypeEvent;
	private EventRepository repositoryEvent;
	private UserRepository repositoryUser;
	private ResponseRepository repositoryResponse;
	
	public EventController() {
		repositoryEntity = new EntityRepository();
		repositoryTypeEvent = new TypeEventRepository();
		repositoryEvent = new EventRepository();
		repositoryUser = new UserRepository();
		repositoryResponse = new ResponseRepository();
	}
	
	public EventDTO createEvent(int idEntity, String title, String description, String dateEvent, int idTypeEvent) throws Exception{
		Event event = null;
		Entity entity = repositoryEntity.getEntityById(idEntity);
		TypeEvent typeEvent = repositoryTypeEvent.getTypeEventById(idTypeEvent);
		event = new Event(title, description, dateEvent, typeEvent, entity);
		repositoryEvent.saveEvent(event);
		return new EventDTO(event);
	}
	
	public List<EventDTO> getAllEvents(){
		List<EventDTO> lista = new ArrayList<>();
        for(Event obj :repositoryEvent.getAllEvents()){
        	EventDTO dto = new EventDTO(obj);
        	lista.add(dto);
        }
        return lista;
	}
	public List<EventDTO> getAllEventsByUser(int idUser){
		List<EventDTO> lista = new ArrayList<>();
		
		for(Event event : repositoryEvent.getAllEvents()) {
			for(Participant participante : event.getParticipants()) {
				if(participante.getUser().getIdUser() == idUser) {
					//filtrar si ya respondio para que no aparezca nuevamente el evento
					//if()
					
					EventDTO dto = new EventDTO(event);
	            	lista.add(dto);
				}
			}			
		}
        return lista;
	}
	
	public EventDTO updateEvent(int idEntity, int idEvent, String title, String description) throws Exception{
		if(idEvent > 0) {
			for(Event event : repositoryEvent.getAllEvents()) {
				if(event.getEntity().getIdEntity() == idEntity && event.getIdEvent() == idEvent) {
					if(!title.trim().equals(""))
						event.setTitle(title);
					if(!description.trim().equals(""))
						event.setDescription(description);
				}
			}
		}else {
			throw new Exception();
		}
		Event event = repositoryEvent.getEventById(idEvent);
		return new EventDTO(event);
	}
	
	public EventDTO removeEvent(int idEvent) throws Exception{
		if(idEvent<=0) {
		    throw new Exception();
		}
		Event event = repositoryEvent.getEventById(idEvent);
		repositoryEvent.removeEvent(event);
		return new EventDTO(event);
	}

	public EventDTO getEvent(int idEntity, int idEvent) {
		for(Event event : repositoryEvent.getAllEvents()) {
			if(event.getEntity().getIdEntity() == idEntity && event.getIdEvent() == idEvent) {
				return new EventDTO(event);
			}
		}
		return null;
	}
	
	public ParticipantDTO createParticipant(int idEvent, int idUser, int assignedVotes) {
		Participant participant;
		Event event = repositoryEvent.getEventById(idEvent);
		User user = repositoryUser.getUserById(idUser);
		participant = new Participant(user, assignedVotes);
		
		event.addParticipant(participant);
		return new ParticipantDTO(participant);
	}
	
	public ParticipantDTO removeParticipant(int idEvent, int idParticipant) {
		Event event = repositoryEvent.getEventById(idEvent);		
		for(Participant obj :event.getParticipants()){
			if(obj.getIdParticipant() == idParticipant) {
				event.removeParticipant(obj);
				return new ParticipantDTO(obj);
			}
		}
		return null;
	}
	
	public List<ParticipantDTO> getParticipants(int idEntity, int idEvent){
		List<ParticipantDTO> lista = new ArrayList<>();
		Event event = repositoryEvent.getEventById(idEvent);
		if(event.getParticipants() != null) {
			for(Participant obj : event.getParticipants()){
	        	lista.add(new ParticipantDTO(obj));
	        }
		}
        
        return lista;
	}
	
	public QuestionDTO createQuestion(int idEntity, int idEvent, String description) {
		Question question;
		Event event = repositoryEvent.getEventById(idEvent);
		question = new Question(description);
		
		event.addQuestion(question);
		return new QuestionDTO(question);
	}
	
	public QuestionDTO removeQuestion(int idEvent, int idQuestion) {
		Event event = repositoryEvent.getEventById(idEvent);		
		for(Question obj :event.getQuestions()){
			if(obj.getIdQuestion() == idQuestion){
				event.removeQuestion(obj);
				return new QuestionDTO(obj);
			}
		}
		return null;
	}
	
	public List<QuestionDTO> getQuestions(int idEntity, int idEvent){
		List<QuestionDTO> lista = new ArrayList<>();
		Event event = repositoryEvent.getEventById(idEvent);
		if(event.getQuestions() != null) {
			for(Question obj : event.getQuestions()){
	        	lista.add(new QuestionDTO(obj));
	        }
		}
        
        return lista;
	}

	public OptionDTO createOption(int idEntity, int idEvent, int idQuestion, String description) {
		Option option;
		Event event = repositoryEvent.getEventById(idEvent);
		option = new Option(description);
		
		for(Question question : event.getQuestions()) {
			if(question.getIdQuestion() == idQuestion) {
				question.addOption(option);
			}
		}
		return new OptionDTO(option);
	}
	
	public OptionDTO removeOption(int idEvent, int idQuestion, int idOption) {
		Event event = repositoryEvent.getEventById(idEvent);		
		for(Question question : event.getQuestions()){
			if(question.getIdQuestion() == idQuestion){
				if(question.getOptions() != null) {
					for(Option opt : question.getOptions()) {
						if(opt.getIdOption() == idOption) {
							question.removeOption(opt);
						}
					}
				}	
			}
		}
		return null;
	}
	
	public List<OptionDTO> getOptions(int idEntity, int idEvent, int idQuestion){
		List<OptionDTO> lista = new ArrayList<>();
		Event event = repositoryEvent.getEventById(idEvent);
		if(event.getQuestions() != null) {
			for(Question obj : event.getQuestions()){
				if(obj.getIdQuestion() == idQuestion)
					if(obj.getOptions() != null) {
						for(Option opt : obj.getOptions()) {
							lista.add(new OptionDTO(opt));
						}
					}
	        }
		}
        
        return lista;
	}
	
	public ResponseDTO answer(int idEntity, int idEvent, int idQuestion, int idOption, int idParticipant, String comment) throws Exception {
		Entity entity = repositoryEntity.getEntityById(idEntity);
		Event event = repositoryEvent.getEventById(idEvent);
		Question question = null;
		Option option = null;
		Participant participant = null;
		
		for(Question obj : event.getQuestions()) {
			if(obj.getIdQuestion() == idQuestion) {
				question = obj;
				for(Option opt : obj.getOptions()) {
					if(opt.getIdOption() == idOption) {
						option = opt;
					}
				}
			}
		}
		for(Participant part : event.getParticipants()) {
			if(part.getIdParticipant() == idParticipant) {
				participant = part;
			}
		}
		
		Response response = new Response(entity, event, participant, question, option, comment);
		repositoryResponse.saveResponse(response);
		return new ResponseDTO(response);
	}
	
	public List<ResponseDTO> getAllResponses(){
		List<ResponseDTO> lista = new ArrayList<>();
        for(Response obj :repositoryResponse.getAllResponses()){
        	ResponseDTO dto = new ResponseDTO(obj);
        	lista.add(dto);
        }
        return lista;
	}
	
	public void updateImage(int idEntity, int idEvent, String logo) throws Exception {
		if(idEvent > 0) {
			for(Event event : repositoryEvent.getAllEvents()) {
				if(event.getEntity().getIdEntity() == idEntity && event.getIdEvent() == idEvent) {
					if(!logo.trim().equals(""))
						event.setLogo(logo);
				}
			}
		}else {
			throw new Exception();
		}
	}
}
