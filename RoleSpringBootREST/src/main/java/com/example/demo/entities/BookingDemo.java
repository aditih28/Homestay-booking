package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class BookingDemo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
int bookingid;
int hotelid;
Date startdate;
Date enddate;
int custid;
int noofrooms;
public BookingDemo(int hotelid, Date startdate, Date enddate, int custid, int noofrooms) {
	super();
	this.hotelid = hotelid;
	this.startdate = startdate;
	this.enddate = enddate;
	this.custid = custid;
	this.noofrooms = noofrooms;
}
public int getBookingid() {
	return bookingid;
}
public void setBookingid(int bookingid) {
	this.bookingid = bookingid;
}
public int getHotelid() {
	return hotelid;
}
public void setHotelid(int hotelid) {
	this.hotelid = hotelid;
}
public Date getStartdate() {
	return startdate;
}
public void setStartdate(Date startdate) {
	this.startdate = startdate;
}
public Date getEnddate() {
	return enddate;
}
public void setEnddate(Date enddate) {
	this.enddate = enddate;
}
public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public int getNoofrooms() {
	return noofrooms;
}
public void setNoofrooms(int noofrooms) {
	this.noofrooms = noofrooms;
}



}
