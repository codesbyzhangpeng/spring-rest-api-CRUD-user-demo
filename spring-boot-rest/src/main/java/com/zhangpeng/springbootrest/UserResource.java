package com.zhangpeng.springbootrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDAOService service;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return service.showAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getOneUser(@PathVariable int id) {
		return service.findOne(id);
	}
}
