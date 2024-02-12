package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.UsersRepository;
import com.example.demo.entities.User;

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
	
	
	
}
