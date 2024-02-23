package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.City;
import com.example.demo.entities.State;
import com.example.demo.services.StateService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StateController {
	@Autowired
	StateService sservice;
	
	@GetMapping("/getallstates")
	public List<State> getAll()
	{
		return sservice.getAll();
	}
	
	//http://localhost:8080/getonecity?cityid=1
	@GetMapping("/getonestate")
	public State getOne(@RequestParam("stateid") int stateid)
	{
		return sservice.getone(stateid);
	}
	
	@PostMapping("/savestate")
	public State saveState(@RequestBody State s)
	{
		return sservice.saveState(s);		
	}



}

