package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Repositories.StateRepository;

import com.example.demo.entities.State;

@Service
public class StateService {
	@Autowired
	StateRepository srepo;
	
	public List<State> getAll()
	{
		return srepo.findAll();
	}
	
	public State getone(int stateid)
	{
		State s = null;
		Optional<State> sp =  srepo.findById(stateid);
		try
		{
			s = sp.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}

	public State saveState(State c)
	{
		return srepo.save(c);
	}

}
