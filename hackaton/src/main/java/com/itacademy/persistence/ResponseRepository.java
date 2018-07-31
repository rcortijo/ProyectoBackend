package com.itacademy.persistence;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.domain.Response;

public class ResponseRepository {

private static List<Response> listResponses = new ArrayList<>();
	
	public List<Response> getAllResponses(){
		return new ArrayList<>(listResponses);
	}	
	
	public void saveResponse(Response response) throws Exception{
		if(response==null) {
	        throw new Exception();
	    }
		listResponses.add(response);
	}
	
	public Response getResponseById(int idResponse) {
		for(Response resp : listResponses) {
			if(resp.getIdResponse() == idResponse) {
				return resp;
			}
		}
		return null;
	}
	
	public void removeResponse(Response response) throws Exception{
		if(response==null) {
		    throw new Exception();
		}
		listResponses.remove(response);
	}
	
	

}
