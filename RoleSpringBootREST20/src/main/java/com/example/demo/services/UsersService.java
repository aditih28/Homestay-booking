package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.UsersRepository;
import com.example.demo.entities.User;


import jakarta.transaction.Transactional;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository urepo;
	
	public List<User> getAll()
	{
		return urepo.findAll();
	}
	
	public User getone(int userid)
	{
		User u = null;
		Optional<User> op =  urepo.findById(userid);
		try
		{
			u = op.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}

	public User save(User u)
	{
		return urepo.save(u);
	}
	
	
	  /*public User Usercheck(UserUser u) 
	  { 
		  return urepo.Usercheck(u); 
		  
	  }*/
	  
	 public Object authenticate(String username, String password) {
	        User user = urepo.findByUsername(username);
	        if (user != null && user.getPassword().equals(password)){
		        return user;
	        }else {
	        	User user1 = new User();
	        	return user1;
	        }
	    }	 
	 public User checkUser(String username, String password) {
			Optional<User> log = urepo.UserDetail(username, password);

			User res = null;

			try {
				res = log.get();
			} catch (Exception e) {
				res = null;
			}

			return res;
	 }
		
		
		
		@Transactional
	    public User saveUser(User user) {
	        try {
	            return urepo.save(user);
	        } catch (Exception e) {
	            e.printStackTrace(); // Log the exception stack trace
	            throw new RuntimeException("Error saving User information.", e);
	        }
		}
		//Rejection
		public void rejectOwner(int userid) 
		{
		// Fetch the User by ID
	        User user = urepo.findById(userid).get();
	               

	   // Perform any business logic related to rejecting the User
	        user.setApprovestatus(false);

	   // Save the updated User entity
	        urepo.save(user);
		}
		// Approval
		public void ApproveOwner(int userid) {
			urepo.findById(userid).ifPresent(user -> {
		// Perform the approval logic here
				// For example, set an approval status field on the Login entity
				user.setApprovestatus(true);
				urepo.save(user);
			});
		}

}
