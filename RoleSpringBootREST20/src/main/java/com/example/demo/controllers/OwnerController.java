package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.CustomerRegisterDummy;
import com.example.demo.entities.Owner;
import com.example.demo.entities.OwnerRegistrationDummy;
import com.example.demo.entities.OwnerUpdationDummy;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.services.OwnerService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UsersService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OwnerController {
	@Autowired
	OwnerService oservice;
	@Autowired
	RoleService roleservice;
	@Autowired
	UsersService userservice;
	
	//http://localhost:8080/getallowner
	@GetMapping("/getallowner")
	public List<Owner> getAll()
	{
		return oservice.getAll();
	}
	
	@GetMapping("/getallowners") 
	public ResponseEntity<List<Owner>> getAllOwner(){
		List<Owner> Owners=oservice.getAll();
		return ResponseEntity.ok().body(Owners);
	}
	
	//http://localhost:8080/getoneowner?ownerid=1
	@GetMapping("/getoneowner")
	public Owner getOne(@RequestParam("ownerid") int ownerid)
	{
		return oservice.getone(ownerid);
	}
	
	//http://localhost:8080/saveowner{"firstname": "Vishal","lastname": "Pawar","address":"Pune","phone":"+919876543211","emailid":"vishal@gmail.com ","property":{"propertyid":1,"propertytype":"villa"}}
	/*@PostMapping("/saveowner")
	public Owner saveOwner(@RequestBody Owner o)
	{
		return oservice.saveOwner(o);		
	}*/
	
	//http://localhost:8080/saveowner{"firstname":"Riya","lastname":"Choudhari","address":"Bangalore","phone":"9922588550","emailid":"riya@gmail.com","username":"Riya","password":"Riya@123","propertytype":"Hotel","adhar":"1231231234"}
	@PostMapping("/saveowner")
	public Owner saveOwner(@RequestBody OwnerRegistrationDummy ord)
	{
		Role r=roleservice.getone(2);
		User u=new User(ord.getUsername(),ord.getPassword(),r);
		
		User ur=userservice.save(u);
		Owner o=new Owner(ord.getFirstname(),ord.getLastname(),ord.getAddress(),ord.getPhone(),ord.getEmailid(),ord.getPropertytype(),ord.getAdhar(),ur);
		ord.setUserid(u.getuserid());
		return oservice.saveOwner(o);		
	}
	/*
	//http://localhost:8080/updateOwner/ownerid=17{"firstname":"Riya","lastname":"Choudhari","address":"Bangalore","phone":"9988778899","emailid":"riya@gmail.com","adhar":"123123445"}
	@PutMapping("/updateOwner")
    public OwnerUpdationDummy updateOwner(@RequestParam("ownerid") int ownerid,@RequestBody Owner o) {
		OwnerUpdationDummy updated = oservice.updateOwner(ownerid,o);
        return updated;
    }*/

}

