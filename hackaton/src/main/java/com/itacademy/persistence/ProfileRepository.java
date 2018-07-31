package com.itacademy.persistence;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.domain.Profile;



public class ProfileRepository {

	private static List<Profile> listProfile = new ArrayList<>();
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(listProfile);
	}	
	
	public void saveProfile(Profile profile) throws Exception{
		if(profile==null) {
	        throw new Exception();
	    }
		listProfile.add(profile);
	}

    public void removeProfile(Profile profile) throws Exception{
		if(profile==null) {
		    throw new Exception();
		}
		listProfile.remove(profile);
	}
    
    public Profile getProfileId(int idProfile) {
    	for(int i=0; i<listProfile.size();i++) {
    		if(listProfile.get(i).getIdProfile() == idProfile) {
    			return listProfile.get(i);
    		}
    	}
    	return null;
    }
    
    public Profile getProfileName(String name) {
    	for(int i=0; i<listProfile.size();i++) {
    		if(listProfile.get(i).getName().equals(name)) {
    			return listProfile.get(i);
    		}
    	}
    	return null;
    }
    
}
