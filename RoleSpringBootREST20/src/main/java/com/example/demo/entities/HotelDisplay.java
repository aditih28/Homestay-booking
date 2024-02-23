package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class HotelDisplay {
	@Id
	int hotelid;
@Column
 String hotelname;
@Column
 String address;
@Column
int cityid;
@Column
 String description;


public HotelDisplay() {
	super();
}
public HotelDisplay(String hotelname, String address,int cityid, String description) {
	super();
	this.hotelname = hotelname;
	this.address = address;
	this.cityid=cityid;
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
public int getCityid() {
	return cityid;
}
public void setCityid(int cityid) {
	this.cityid = cityid;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
 
 
 
}
