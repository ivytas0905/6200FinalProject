package model;

public class UserProfile {
	String userId;
	String userName;
	String password;
	
	public UserProfile(String um, String pw) {
		userName = um;
		password = pw;
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    public boolean isValidUser(String um,String pw) {
    	if(userName.equalsIgnoreCase(um) && password.equals(pw)) {
    		return true;
    	}else {
    		return false;
    	}
        
    }
}

