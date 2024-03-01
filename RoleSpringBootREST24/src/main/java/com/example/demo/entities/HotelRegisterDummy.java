package com.example.demo.entities;

public class HotelRegisterDummy {
	int hotelid;
	int ownerid;
	int cityid;
	int stateid;
	String hotelname;
	String address;
	String state;
	String city;
	String emailid;
	String phone;
	String description;
	int totalrooms;
	int price;

	public HotelRegisterDummy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelRegisterDummy(int ownerid, String hotelname, String address, String state, String city, String emailid,
			String phone, String description, int totalrooms,int price) {
		super();
		this.ownerid = ownerid;
		this.hotelname = hotelname;
		this.address = address;
		this.state = state;
		this.city = city;
		this.emailid = emailid;
		this.phone = phone;
		this.description = description;
		this.totalrooms = totalrooms;
		this.price=price;
	}
	
	
	public HotelRegisterDummy(String hotelname, String address,  String state,String city, String emailid, String phone,
			String description, int totalrooms,int price) {
		super();
		this.hotelname = hotelname;
		this.address = address;
		this.state = state;
		this.city = city;
		this.emailid = emailid;
		this.phone = phone;
		this.description = description;
		this.totalrooms = totalrooms;
		this.price=price;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotalrooms() {
		return totalrooms;
	}
	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
