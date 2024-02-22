package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.BookingDemoRepository;
import com.example.demo.Repositories.BookingRepository;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.HotelRepository;

import com.example.demo.entities.Booking;
import com.example.demo.entities.BookingDemo;
import com.example.demo.entities.City;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Hotel;
import com.example.demo.entities.HotelRegisterDummy;
import com.example.demo.entities.HotelResponse;
import com.example.demo.entities.Owner;
import com.example.demo.entities.State;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingService {

	@Autowired
	BookingRepository brepo;
	@Autowired
	HotelService hservice;
	@Autowired
	BookingDemoRepository bdrepo;
	@Autowired
	CustomerService cservice;
	
	public List<Booking> getBooking() {
        return brepo.findAll();
    }
	
	public String deleteBooking(int bookingid) {
        brepo.deleteById(bookingid);
        return "Booking Deleted";
    }

	public Booking saveBooking(Booking b) {
		
		return brepo.save(b);
    }
	
	
	public Booking getbookingidById(int bookingid) {
        return brepo.findById(bookingid).orElseThrow(EntityNotFoundException::new);
    }
	
	public BookingDemo saveBookings(BookingDemo b) {
		
		return bdrepo.save(b);
    }
	
	 public BookingDemo createBookingResponse(BookingDemo request){
		  	Customer customer =  cservice.getone(request.getCustid());
		  	Hotel hotel =  hservice.getone(request.getHotelid());

			
			int custid = customer.getCustid();
			int hotelid = hotel.getHotelid();
			
			BookingDemo response = new BookingDemo(hotelid,request.getStartdate(),request.getEnddate(),custid,request.getNoofrooms());
			return response;
			
	  }
}

