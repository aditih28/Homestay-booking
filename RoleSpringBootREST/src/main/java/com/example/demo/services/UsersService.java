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
import com.example.demo.entities.UserLogin;

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
	
	
	  /*public User logincheck(UserLogin u) 
	  { 
		  return urepo.logincheck(u); 
		  
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
	
}
