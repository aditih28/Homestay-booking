package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.entities.Customer;
@Service
public class CustomerService {

	@Autowired
	CustomerRepository crepo;
	
	public List<Customer> getAll()
	{
		return crepo.findAll();
	}
	
	public Customer getone(int custid)
	{
		Customer c = null;
		Optional<Customer> op =  crepo.findById(custid);
		try
		{
			c = op.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}

	/*public Customer save(Customer c)
	{
		return crepo.save(c);
	}*/
	
	
	public Customer saveCustomer(Customer c)
	{
		return crepo.save(c);
	}
	
}
