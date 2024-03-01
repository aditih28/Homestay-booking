package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Booking;
import com.example.demo.entities.BookingDemo;
import com.example.demo.services.BookingService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.HotelService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookingController {

	@Autowired
	BookingService bservice;
	@Autowired
	CustomerService cservice;
	@Autowired 
	HotelService hservice;
	
	@GetMapping("/getallbooking")
	public List<Booking> getBooking()
	{
		return bservice.getBooking();
	}
	
	//http://localhost:8080/saveBooking{"custid":"10"hotelid":"38","startdate":"12/04/2023","enddate":"20/04/1998","noofrooms":"2"}
	/*@PostMapping("/saveBooking")
	public Booking saveBooking(@RequestBody Booking b)
	{
		Customer c=cservice.getone(b.getCustomer().getCustid());
		Hotel h=hservice.getone(b.getHotel().getHotelid());
		Date d1=new Date();
		Date d2=new Date();
		int rooms=b.getNoofrooms();
		Booking bk=new Booking(h,d1,d2,c,rooms);
		return bservice.saveBooking(bk);	
	}*/
	
	@PostMapping("/saveBookings")
	public BookingDemo saveBooking(@RequestBody BookingDemo b)
	{
		BookingDemo bd=bservice.createBookingResponse(b);
		 bservice.saveBookings(bd);
		if(bd.getBookingid() != 0) {
			bd.setStatus(HttpStatus.OK);
		}else {
			bd.setStatus(HttpStatus.UNAUTHORIZED);
		}
		return bd;
	}
	
	//http://localhost:8080/booking/2
	@GetMapping("/booking/{bookingid}")
	public Booking findbookingidById(@PathVariable int bookingid) {
	    return bservice.getbookingidById(bookingid);
	}
	
	//http://localhost:8080/delete/5
	@DeleteMapping("/delete/{bookingid}") 
    public String deletebooking(@PathVariable int bookingid) {
        return bservice.deleteBooking(bookingid);
    }
}
