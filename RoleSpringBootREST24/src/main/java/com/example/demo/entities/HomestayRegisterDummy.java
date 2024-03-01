package com.example.demo.entities;

public class HomestayRegisterDummy {
	int ownerid;
	String name;
	String address;
	String city;
	String state;
	String emailid;
	String phone;
	String description;
	int capacity;
	int price;

	public HomestayRegisterDummy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomestayRegisterDummy(int ownerid, String name, String address, String city, String state, String emailid,
			String phone, String description, int capacity,int price) {
		super();
		this.ownerid = ownerid;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.emailid = emailid;
		this.phone = phone;
		this.description = description;
		this.capacity = capacity;
		this.price=price;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

