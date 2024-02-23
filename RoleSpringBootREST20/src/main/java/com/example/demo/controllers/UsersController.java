package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/getallUsers")
    public List<User> getAll() {
        return uservice.getAll();
    }
    
    @GetMapping("/getoneuser")
    public User getOne(@RequestParam("userid") int userid) {
        return uservice.getone(userid);
    }
    
    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User u) {
    	System.out.println("I am here in controller");
        return uservice.save(u);      
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLogin loginRequest) {
        if (loginRequest.getUsername() != null && loginRequest.getPassword() != null) {
            // Assuming 'uservice.authenticate' returns a User object or null if authentication fails
            User user = (User)uservice.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            if (user != null) {
                user.setStatus(HttpStatus.OK);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>("Please provide valid credentials", HttpStatus.BAD_REQUEST);
        }
    }


    
    @PutMapping("/{ownerid}/approve")
    public ResponseEntity<Void> approveUser(@PathVariable("ownerid") int ownerid) {
        uservice.ApproveOwner(ownerid);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{ownerid}/reject")
    public ResponseEntity<Void> rejectUser(@PathVariable("ownerid") int ownerid) {
        uservice.rejectOwner(ownerid);
        return ResponseEntity.ok().build();
    }
}
