package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.entities.CustomerRegisterDummy;
import com.example.demo.entities.User;
import com.example.demo.entities.Role;
import com.example.demo.services.CustomerService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UsersService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
	@Autowired
	CustomerService cservice;
	@Autowired
	RoleService roleservice;
	@Autowired
	UsersService userservice;
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
	
	//http://localhost:8080/savecustomer{"firstname": "Manish","lastname": "Sethi",	"address":"Mumbai",	"phone":"+919971122777",	"emailid":"manish@gmail.com ","adhar":"1123567890","username":"Manish","password":"manish@123"}
	
	@PostMapping("/savecustomer")
	public Customer saveCustomer(@RequestBody CustomerRegisterDummy crd)
	{
		Role r=roleservice.getone(3);
		User u=new User(crd.getUsername(),crd.getPassword(),r);
		//u.getRole().setRoleid(3);
		
		User ur=userservice.save(u);
		Customer c=new Customer(crd.getFirstname(),crd.getLastname(),crd.getAddress(),crd.getPhone(),crd.getEmailid(),crd.getAdhar(),ur);
		crd.setUserid(u.getuserid());
		//crd.setRoleid(3);
		return cservice.saveCustomer(c);		
	}
}
