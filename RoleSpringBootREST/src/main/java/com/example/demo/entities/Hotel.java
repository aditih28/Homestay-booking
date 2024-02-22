package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int hotelid;
	@Column
	String hotelname;
	
	@Column
	String address;
	
	@OneToOne
	@JoinColumn(name="stateid")
	State state;
	
	@OneToOne
	@JoinColumn(name="cityid")
	City city;
	
	@Column
	String emailid;
	
	@Column
	String phone;
	
	@Column
	String description;
	
	@JsonIgnoreProperties("hotels")
	@OneToOne
	@JoinColumn(name="ownerid")
	Owner owner;
	
	@Column
	int totalrooms;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(String hotelname, String address,State state,City city, String emailid, String phone,
			String description, Owner owner, int totalrooms) {
		super();
		this.hotelname = hotelname;
		this.address = address;
		this.state = state;
		this.city = city;
		this.emailid = emailid;
		this.phone = phone;
		this.description = description;
		this.owner = owner;
		this.totalrooms = totalrooms;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public int getTotalrooms() {
		return totalrooms;
	}

	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}
	
}
