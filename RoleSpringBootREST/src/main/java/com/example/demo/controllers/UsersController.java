package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.entities.UserLogin;
import com.example.demo.services.UsersService;


@CrossOrigin(origins = "http://localhost:3000")
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
	
	//http://localhost:8080/saveuser{"username": "Shubham","password": "Shubham@123","role":{"roleid":1,"rolename":"Admin"}}
	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User u)
	{
		return uservice.save(u);		
	}
	
	
	/* public User loginCheck(@RequestBody UserLogin u) 
	 
	 { 
		 return uservice.logincheck(u); }*/
	/*
	 * @PostMapping("/login") public ResponseEntity<?> login(@RequestBody UserLogin
	 * loginRequest) { if (uservice.authenticate(loginRequest.getUsername(),
	 * loginRequest.getPassword())) { // Generate JWT token or session token return
	 * new ResponseEntity<>("success", HttpStatus.OK); } else { return new
	 * ResponseEntity<>("Please Enter Valid credentials", HttpStatus.UNAUTHORIZED);
	 * } }
	 */
	
	@PostMapping("/login")
	 public Object login(@RequestBody UserLogin loginRequest) {
		User user = new User();
	        if (loginRequest.getUsername()!=null && loginRequest.getPassword() != null) {
	            // Generate JWT token or session token
	            user = (User) uservice.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
	        	if(user.getUserID() != 0) {
	        		 user.setStatus(HttpStatus.OK);
	 	        	new ResponseEntity<>("success", HttpStatus.OK);
	 	        	return user;
	        	}else {
	        		return user;
	        	}
	        }
		    return new ResponseEntity<>("Please Enter Valid credentials", HttpStatus.UNAUTHORIZED);
	    }
	 
}
