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
import com.example.demo.entities.Hotel;
import com.example.demo.entities.HotelRegisterDummy;
import com.example.demo.entities.Owner;
import com.example.demo.entities.State;
import com.example.demo.services.CityService;
import com.example.demo.services.HotelService;
import com.example.demo.services.StateService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CityController {
	@Autowired
	CityService cservice;
	
	@Autowired
	StateService sservice;
	
	@GetMapping("/getallcities")
	public List<City> getAll()
	{
		return cservice.getAll();
	}
	
	//http://localhost:8080/getonecity?cityid=1
	@GetMapping("/getonecity")
	public City getOne(@RequestParam("cityid") int cityid)
	{
		return cservice.getone(cityid);
	}
	
	@PostMapping("/savecity")
	public City saveCity(@RequestBody City c)
	{
		return cservice.saveCity(c);		
	}

	

}

