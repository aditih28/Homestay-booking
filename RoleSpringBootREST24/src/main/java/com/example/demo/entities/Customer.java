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
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int custid;
	
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
	
	
	@JsonIgnoreProperties("customer")
	@OneToOne
	@JoinColumn(name="userid")
	User user;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int custid, String firstname, String lastname, String address, String phone, String emailid,
			String adhar, int userid, User user) {
		super();
		this.custid = custid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.adhar = adhar;
		this.user = user;
	}
	

	public Customer(String firstname, String lastname, String address, String phone, String emailid, String adhar,
			User user) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.adhar = adhar;
		this.user = user;
	}

	public Customer(String firstname, String lastname, String address, String phone, String emailid, String adhar) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.adhar = adhar;
	}

	/**
	 * @return the custid
	 */
	public int getCustid() {
		return custid;
	}

	/**
	 * @param custid the custid to set
	 */
	public void setCustid(int custid) {
		this.custid = custid;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}

	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	/**
	 * @return the adhar
	 */
	public String getAdhar() {
		return adhar;
	}

	/**
	 * @param adhar the adhar to set
	 */
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	/**
	 * @return the userid
	 */
	
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + ", phone=" + phone + ", emailid=" + emailid + ", adhar=" + adhar + 
				 ", user=" + user + "]";
	}

	
	
}

