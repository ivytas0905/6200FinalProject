package model;

import java.util.ArrayList;

public class UserDirectory {
	ArrayList<UserProfile> userProfilelist;
    
	public UserDirectory() {
		userProfilelist = new ArrayList<>();
	}
    public UserProfile newUserProfile(String um, String pw) {
    	UserProfile up = new UserProfile(um,pw);
    	userProfilelist.add(up);
    	return up;
    }
    public UserProfile AuthenticateUser(String um, String pw) {
    	for(UserProfile up:userProfilelist) {
    		if(up.isValidUser(um, pw)) {
    			return up;
    		}
    	}
        return null;
    }
}
