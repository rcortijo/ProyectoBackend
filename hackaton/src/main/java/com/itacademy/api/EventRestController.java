 package com.itacademy.api;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.itacademy.application.EventController;
import com.itacademy.application.dto.EventDTO;
import com.itacademy.application.dto.OptionDTO;
import com.itacademy.application.dto.ParticipantDTO;
import com.itacademy.application.dto.QuestionDTO;
import com.itacademy.application.dto.ResponseDTO;
import com.itacademy.utilities.CustomErrorType;

@RestController
@RequestMapping("/hackaton")
public class EventRestController {


	@RequestMapping(value="/entities/{idEntity}/events",method=RequestMethod.POST)
	public String createEvent(@PathVariable int idEntity,@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String title=(String) json.get("title");
		String description=(String) json.get("description");
		int idTypeEvent = (int) json.get("idTypeEvent");
		String dateEvent = (String) json.get("dateEvent"); 
		
		
		EventDTO event = null;
		event = new EventController().createEvent(idEntity, title, description, dateEvent, idTypeEvent);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(event);
		
	}
	
	
	@RequestMapping(value="/entities/{idEntity}/events",method=RequestMethod.GET)
	public String listAllEvents() throws Exception, JsonSyntaxException {		
		
		List<EventDTO> entitys = new EventController().getAllEvents();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(entitys);
		
	}
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}",method=RequestMethod.GET)
	public String getEvent(@PathVariable int idEntity, @PathVariable int idEvent) throws Exception, JsonSyntaxException {		
		
		EventDTO event = new EventController().getEvent(idEntity,idEvent);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(event);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}",method=RequestMethod.PUT)
	public String updateEvent(@PathVariable int idEntity, @PathVariable int idEvent, @RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		String title = (String) json.get("title");
		String description = (String) json.get("description");
		
		EventDTO event = null;
		event = new EventController().updateEvent(idEntity,idEvent, title, description);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(event);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}",method=RequestMethod.DELETE)
	public String deleteEvent(@PathVariable int idEntity, @PathVariable int idEvent) throws Exception, JsonSyntaxException {		
		
		EventDTO event = null;
		event = new EventController().removeEvent(idEvent);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(event);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/participants",method=RequestMethod.POST)
	public String createParticipant(@PathVariable int idEntity,@PathVariable int idEvent,@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		
		int assignedVotes=(int) json.get("assignedVotes");
		int idUser=(int) json.get("idUser");
		
		ParticipantDTO participant = null;
		participant = new EventController().createParticipant(idEvent, idUser, assignedVotes);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(participant);
		
	}
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/participants/{idParticipant}",method=RequestMethod.DELETE)
	public String deleteParticipant(@PathVariable int idEntity,@PathVariable int idEvent,@PathVariable int idParticipant,@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		ParticipantDTO participant = null;
		
		participant = new EventController().removeParticipant(idEvent, idParticipant);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(participant);
		
	} 
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/participants",method=RequestMethod.GET)
	public String getParticipantsEvent(@PathVariable int idEntity, @PathVariable int idEvent) throws Exception, JsonSyntaxException {		
		
		List<ParticipantDTO> participants = new EventController().getParticipants(idEntity, idEvent);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(participants);
		
	}
	
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/questions",method=RequestMethod.POST)
	public String createQuestion(@PathVariable int idEntity,@PathVariable int idEvent,@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		
		String description=(String) json.get("description");
		
		QuestionDTO question = null;
		question = new EventController().createQuestion(idEntity, idEvent, description);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(question);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/questions/{idQuestion}",method=RequestMethod.DELETE)
	public String deleteQuestion(@PathVariable int idEntity,@PathVariable int idEvent,@PathVariable int idQuestion,@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		QuestionDTO question = null;
		
		question = new EventController().removeQuestion(idEvent, idQuestion);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(question);
		
	} 
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/questions",method=RequestMethod.GET)
	public String getQuestionsEvent(@PathVariable int idEntity, @PathVariable int idEvent) throws Exception, JsonSyntaxException {		
		
		List<QuestionDTO> questions = new EventController().getQuestions(idEntity, idEvent);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(questions);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/questions/{idQuestion}/options",method=RequestMethod.POST)
	public String createOption(@PathVariable int idEntity,@PathVariable int idEvent,@PathVariable int idQuestion, @RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		
		String description=(String) json.get("description");
		
		OptionDTO option = null;
		option = new EventController().createOption(idEntity, idEvent, idQuestion, description);
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(option);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/questions/{idQuestion}/options/{idOption}",method=RequestMethod.DELETE)
	public String deleteOption(@PathVariable int idEntity,@PathVariable int idEvent,@PathVariable int idQuestion, @PathVariable int idOption,@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		OptionDTO option = null;
		
		option = new EventController().removeOption(idEvent, idQuestion, idOption);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(option);
		
	} 
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/questions/{idQuestion}/options",method=RequestMethod.GET)
	public String getOptionsQuestionEvent(@PathVariable int idEntity, @PathVariable int idEvent, @PathVariable int idQuestion) throws Exception, JsonSyntaxException {		
		
		List<OptionDTO> options = new EventController().getOptions(idEntity, idEvent, idQuestion);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(options);
		
	}
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/questions/{idQuestion}/options",method=RequestMethod.POST)
	public String answer(@PathVariable int idEntity, @PathVariable int idEvent, @PathVariable int idQuestion,@RequestBody JSONObject json) throws Exception, JsonSyntaxException {		
		int idOption = (int) json.get("idOption");
		int idParticipant = (int) json.get("idParticipant");
		String comment = (String) json.get("comment");
		
		ResponseDTO response = new EventController().answer(idEntity, idEvent, idQuestion, idOption, idParticipant, comment);
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(response);
		
	}
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/participants",method=RequestMethod.GET)
	public String getAllResponses() throws Exception, JsonSyntaxException {		
		
		List<ResponseDTO> responses = new EventController().getAllResponses();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(responses);
		
	}
	
	
	
	
	
	//POST IMAGE//**********************************************************************************************************************
	public static final String EVENT_UPLOADED_FOLDER ="images/events/";
	
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/image", method = RequestMethod.POST, headers=("content-type=multipart/form-data"))
	public ResponseEntity<byte[]> uploadEventImage(@PathVariable int idEntity, @PathVariable int idEvent, 
			@RequestParam("file") MultipartFile multipartFile, UriComponentsBuilder componentsBuilder){
		EventDTO event = new EventController().getEvent(idEntity, idEvent);
		
		if (!event.getLogo().isEmpty() || event.getLogo() != null) {
			String fileName = event.getLogo();
			Path path = Paths.get(fileName);
			File f = path.toFile();
			if (f.exists()) {
				f.delete();
			}
		}
		
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateName = dateFormat.format(date);
			
			String fileName = String.valueOf(idEvent) + "-pictureEvent-" + dateName + "." + multipartFile.getContentType().split("/")[1];
			new EventController().updateImage(idEntity, idEvent, EVENT_UPLOADED_FOLDER + fileName);
			
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(EVENT_UPLOADED_FOLDER + fileName);
			Files.write(path, bytes);
			
			//_teacherService.updateTeacher(teacher);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(new CustomErrorType("Error durante upload: " + multipartFile.getOriginalFilename()),HttpStatus.CONFLICT);
		}
	}
	
	//GET IMAGE
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/image", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getTeacherImage(@PathVariable("idEntity") int idEntity, @PathVariable("idEvent") int idEvent){
					
		EventDTO event = new EventController().getEvent(idEntity, idEvent);
		if (event == null) {
			return new ResponseEntity(new CustomErrorType("Event con idEvent: " + idEvent + " no encontrado"), HttpStatus.NOT_FOUND);
		}
		
		try {
			
			String fileName = event.getLogo();
			Path path = Paths.get(fileName);
			File f = path.toFile();
			if (!f.exists()) {
				return new ResponseEntity(new CustomErrorType("Imagen no encontrada"),HttpStatus.CONFLICT);
			}
			
			byte[] image = Files.readAllBytes(path);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(new CustomErrorType("Error al mostrar imagen"),HttpStatus.CONFLICT);
		}
	
	}
	
	//DELETE IMAGE
	@RequestMapping(value="/entities/{idEntity}/events/{idEvent}/image", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteTeacherImage(@PathVariable("idEntity") int idEntity, @PathVariable("idEvent") int idEvent){
		EventDTO event = new EventController().getEvent(idEntity, idEvent);
		
		String fileName = event.getLogo();
		Path path = Paths.get(fileName);
		File file = path.toFile();
		if (file.exists()) {
			file.delete();
		}
		
		try {
			new EventController().updateImage(idEntity, idEvent, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(event);
	}
	//***************************************************************************************************************************************************
	
}
