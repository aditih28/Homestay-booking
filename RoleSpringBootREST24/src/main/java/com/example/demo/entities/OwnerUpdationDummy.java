package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="owner")
public class OwnerUpdationDummy {
	@Id
	int ownerid;
	@Column
	String firstname;
	@Column
	String lastname;
	@Column
	String address;
	@Column
	String phone;
	@Column
	String emailid;
	@Column
	String adhar;
	public OwnerUpdationDummy(int ownerid, String firstname, String lastname, String address, String phone,
			String emailid, String adhar) {
		super();
		this.ownerid = ownerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.adhar = adhar;
	}
	public OwnerUpdationDummy(String firstname, String lastname, String address, String phone, String emailid,
			String adhar) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.adhar = adhar;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	
	
}
