package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class HotelDisplay {
	@Id
	int hotelid;
	@Column
	int ownerid;
@Column
 String hotelname;
@Column
 String address;
@ManyToOne
@JoinColumn(name = "stateid", referencedColumnName = "stateid")
private State state;

@OneToOne
@JoinColumn(name="cityid")
City city;

@Column
 String description;


public HotelDisplay() {
	super();
}
public HotelDisplay(String hotelname, String address,State state,City city, String description) {
	super();
	this.hotelname = hotelname;
	this.address = address;
	this.state=state;
	this.city=city;
	this.description = description;
}


public HotelDisplay(int ownerid, String hotelname, String address, State state,City city, String description) {
	super();
	this.ownerid = ownerid;
	this.hotelname = hotelname;
	this.address = address;
	this.state = state;
	this.city=city;
	this.description = description;
}
public int getHotelid() {
	return hotelid;
}
public void setHotelid(int hotelid) {
	this.hotelid = hotelid;
}
public String getHotelname() {
	return hotelname;
}
public void setHotelname(String hotelname) {
	this.hotelname = hotelname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public State getState() {
	return state;
}
public void setCity(State state) {
	this.state = state;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getOwnerid() {
	return ownerid;
}
public void setOwnerid(int ownerid) {
	this.ownerid = ownerid;
}
public void setState(State state) {
	this.state = state;
}
public City getCity() {
	return city;
}
public void setCity(City city) {
	this.city = city;
}
 
 
 
}
