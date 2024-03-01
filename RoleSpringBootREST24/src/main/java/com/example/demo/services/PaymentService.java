package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.PaymentDummyRepository;
import com.example.demo.Repositories.PaymentRepository;
import com.example.demo.entities.Booking;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Payment;
import com.example.demo.entities.PaymentDummy;
@Service
public class PaymentService {

	@Autowired
	PaymentRepository prepo;
	@Autowired
	PaymentDummyRepository pdrepo;
	@Autowired
	CustomerService cservice;
	@Autowired
	BookingService bservice;
	public List<Payment> getAllPayments()
	{
		return prepo.findAll();
	}
	public List<PaymentDummy> getAll()
	{
		return pdrepo.findAll();
	}
	
	public Payment getone(int paymentid)
	{
		Payment p = null;
		Optional<Payment> cp =  prepo.findById(paymentid);
		try
		{
			p = cp.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return p;
	}

	public Payment savePayment(Payment p)
	{
		return prepo.save(p);
	}
	
	public PaymentDummy savePaymentDummy(PaymentDummy p)
	{
		Customer customer=cservice.getone(p.getCustid());
		Booking booking=bservice.getbookingidById(p.getBookingid());
        UUID uuid = UUID.randomUUID();
		String trans=uuid.toString();
		//String trans=p.getTransactionid();
		int cust=customer.getCustid();
		int book=booking.getBookingid();
		
		PaymentDummy pd=new PaymentDummy(cust,book,trans);
		
		return pdrepo.save(pd);
	}
	
}
