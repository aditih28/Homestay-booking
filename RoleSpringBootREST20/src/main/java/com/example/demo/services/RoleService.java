package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.RoleRepository;
import com.example.demo.entities.Role;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository rrepo;
	
	public List<Role> getAll()
	{
		return rrepo.findAll();
	}
	
	public Role getone(int roleid)
	{
		Role r = null;
		Optional<Role> op =  rrepo.findById(roleid);
		try
		{
			r = op.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	
	
}
