package com.zhangpeng.springbootrest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

	private static int userCount = 3;
	
	public static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Eva", new Date()));
		users.add(new User(2, "Adam", new Date()));
		users.add(new User(3, "Noha", new Date()));
		}

	public List<User> showAllUsers(){
		return users;
	}
	
	public User addUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id)
				return user;
		}
		return null;		
	}
	
	public User DeleteById(int id) {
		
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()){
			User user = iterator.next();
			if(user.getId()==id)
				iterator.remove();
				return user;
		}
		return null;		
	}
	
	
}
