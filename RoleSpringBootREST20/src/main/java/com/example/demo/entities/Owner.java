package com.example.demo.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	String propertytype;
	
	@Column
	String adhar;
	
	@JsonIgnoreProperties("owner")
	@OneToOne
	@JoinColumn(name="userid")
	User user;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Owner(String firstname, String lastname, String address, String phone, String emailid, String propertytype,
			String adhar, User user) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.propertytype = propertytype;
		this.adhar = adhar;
		this.user = user;
	}



	public Owner(String firstname, String lastname, String address, String phone, String emailid, String propertytype,
			String adhar) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.propertytype = propertytype;
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

	//public int getpropertytype() {
	//	return propertytype;
	//}

	//public void setpropertytype(int propertytype) {
	//	this.propertytype = propertytype;
	//}

	/*public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public User getUser() {
		return user;
	}*/

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getpropertytype() {
		return propertytype;
	}



	public void setpropertytype(String propertytype) {
		this.propertytype = propertytype;
	}



	public String getAdhar() {
		return adhar;
	}



	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}



	public User getUser() {
		return user;
	}



	@Override
	public String toString() {
		return "Owner [ownerid=" + ownerid + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + ", phone=" + phone + ", emailid=" + emailid  + " user=" + user+"]";
	}
	

}
