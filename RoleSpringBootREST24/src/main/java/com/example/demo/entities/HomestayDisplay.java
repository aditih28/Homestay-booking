package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="homestays")
public class HomestayDisplay {
	@Id
	int homestayid;
@Column
 String name;
@Column
 String address;
@Column
int ownerid;

@ManyToOne
@JoinColumn(name = "stateid", referencedColumnName = "stateid")
private State state;

@OneToOne
@JoinColumn(name="cityid")
City city;

@Column
 String description;

@Column
int price;
public HomestayDisplay() {
	super();
}
public HomestayDisplay(String name, String address, State state,City city, String description,int price) {
	super();
	this.name = name;
	this.address = address;
	this.state = state;
	this.city=city;
	this.description = description;
	this.price=price;
}


public HomestayDisplay(String name, String address, int ownerid, State state,City city, String description,int price) {
	super();
	this.name = name;
	this.address = address;
	this.ownerid = ownerid;
	this.state = state;
	this.city=city;
	this.description = description;
	this.price=price;
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
public State getState() {
	return state;
}
public void setState(State state) {
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
public City getCity() {
	return city;
}
public void setCity(City city) {
	this.city = city;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}



}
