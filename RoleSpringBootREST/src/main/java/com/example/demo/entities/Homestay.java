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
@Table(name="homestays")
public class Homestay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int homestayid;
	@Column
	String name;
	
	@Column
	String address;
	
	@JsonIgnoreProperties("homestays")
	@OneToOne
	@JoinColumn(name="cityid")
	City city;
	
	@JsonIgnoreProperties("homestays")
	@OneToOne
	@JoinColumn(name="stateid")
	State state;
	
	@Column
	String emailid;
	
	@Column
	String phone;
	
	@Column
	String description;
	
	@JsonIgnoreProperties("homestays")
	@OneToOne
	@JoinColumn(name="ownerid")
	Owner ownerid;
	
	@Column
	int capacity;

	public Homestay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Homestay(String name, String address, City city, State stateid, String emailid, String phone,
			String description, Owner ownerid, int capacity) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.emailid = emailid;
		this.phone = phone;
		this.description = description;
		this.ownerid = ownerid;
		this.capacity = capacity;
	}

	public int getHomestayid() {
		return homestayid;
	}

	public void setHomestayid(int homestayid) {
		this.homestayid = homestayid;
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

	public Owner getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Owner ownerid) {
		this.ownerid = ownerid;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	

}

