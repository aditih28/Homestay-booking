package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UsersService;


//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsersController {
	@Autowired
	UsersService uservice;
	
	//http://localhost:8080/getallUsers
	@GetMapping("/getallUsers")
	public List<User> getAll()
	{
		return uservice.getAll();
	}
	
	//http://localhost:8080/getoneuser?UserID=1
	@GetMapping("/getoneuser")
	public User getOne(@RequestParam("UserID") int UserID)
	{
		return uservice.getone(UserID);
	}
	
	//http://localhost:8080/saveuser{"username": "Shubham","password": "Shubham@123","inactive":0,"role":{"roleid":1,"rolename":"Admin"}}
	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User u)
	{
		return uservice.save(u);		
	}
	

}
