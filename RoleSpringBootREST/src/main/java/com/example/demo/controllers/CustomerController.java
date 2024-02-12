package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
	@Autowired
	CustomerService cservice;
	
	//http://localhost:8080/getallcustomer
	@GetMapping("/getallcustomer")
	public List<Customer> getAll()
	{
		return cservice.getAll();
	}
	
	//http://localhost:8080/getonecustomer?custid=1
	@GetMapping("/getonecustomer")
	public Customer getOne(@RequestParam("custid") int custid)
	{
		return cservice.getone(custid);
	}
	
	//http://localhost:8080/savecustomer{"username": "Shubham","password": "Shubham@123","inactive":0,"role":{"roleid":1,"rolename":"Admin"}}
	@PostMapping("/savecustomer")
	public Customer saveCustomer(@RequestBody Customer c)
	{
		return cservice.save(c);		
	}
}
