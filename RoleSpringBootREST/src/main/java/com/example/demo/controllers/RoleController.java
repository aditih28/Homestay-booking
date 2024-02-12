package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Role;
import com.example.demo.services.RoleService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RoleController {
	
		@Autowired
		RoleService rservice;
		
		//http://localhost:8080/getallRole
		@GetMapping("/getallRole")
		public List<Role> getAll()
		{
			return rservice.getAll();
		}
		
		//http://localhost:8080/getoneRole?roleid=2
		@GetMapping("/getoneRole")
		public Role getOne(@RequestParam("roleid") int roleid)
		{
			return rservice.getone(roleid);
		}
}
