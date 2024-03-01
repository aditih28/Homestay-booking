package com.example.demo.entities;

import java.util.Date;

public class BookingListDisplayDemo {
int hotelid;
int customerid;
int ownerid;
String hotelname;
String firstname;
String secondname;
Date startdate;
Date enddate;

public BookingListDisplayDemo() {
	super();
}

public BookingListDisplayDemo(String hotelname, String firstname, String secondname, Date startdate, Date enddate, int hotelid, int customerid, int ownerid) {
	super();
	this.ownerid = ownerid;
	this.customerid=customerid;
	this.hotelid = hotelid;
	this.hotelname = hotelname;
	this.firstname = firstname;
	this.secondname = secondname;
	this.startdate = startdate;
	this.enddate = enddate;
}

public int getHotelid() {
	return hotelid;
}

public void setHotelid(int hotelid) {
	this.hotelid = hotelid;
}

public int getCustomerid() {
	return customerid;
}

public void setCustomerid(int customerid) {
	this.customerid = customerid;
}

public int getOwnerid() {
	return ownerid;
}

public void setOwnerid(int ownerid) {
	this.ownerid = ownerid;
}

public String getHotelname() {
	return hotelname;
}

public void setHotelname(String hotelname) {
	this.hotelname = hotelname;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getSecondname() {
	return secondname;
}

public void setSecondname(String secondname) {
	this.secondname = secondname;
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


}
