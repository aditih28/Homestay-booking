package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Payment;
import com.example.demo.entities.PaymentDummy;
import com.example.demo.services.PaymentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PaymentController {

	@Autowired
	PaymentService pservice;
	@GetMapping("/getallpayment")
	public List<Payment> getAll()
	{
		return pservice.getAllPayments();
	}
	
	//http://localhost:8080/getonepayment?paymentid=1
	@GetMapping("/getonepayment")
	public Payment getOne(@RequestParam("paymentid") int paymentid)
	{
		return pservice.getone(paymentid);
	}
	
	//http://localhost:8080/savepayment{"custid":"5","bookingid":"15","amount":"1000","transactionid":"tran123"}
	@PostMapping("/savepayment")
	public PaymentDummy savePaymentDummy(@RequestBody PaymentDummy p)
	{
		return pservice.savePaymentDummy(p);		
	}
		
	
}
