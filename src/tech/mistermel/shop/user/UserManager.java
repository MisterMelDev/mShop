package tech.mistermel.shop.user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

	private List<User> users = new ArrayList<User>();
	
	public void load() {
		//TODO: Load users from MySQL database
	}
	
	public void sync() {
		for(User u : users)
			u.sync();
	}
	
	public User getUser(String email) {
		for(User u : users) {
			if(u.getEmail().equalsIgnoreCase(email)) return u;
		}
		return null;
	}
	
}
