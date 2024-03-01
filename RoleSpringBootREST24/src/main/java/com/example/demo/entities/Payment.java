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
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int paymentid;
	
	@JsonIgnoreProperties("Payment")
	@OneToOne
	@JoinColumn(name="custid")
	Customer customer;
	
	@JsonIgnoreProperties("Payment")
	@OneToOne
	@JoinColumn(name="bookingid")
	Booking bookings;
	
	
	
	@Column 
	String transactionid;
	@Column
	String custname;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Customer customer, Booking bookings, String transactionid) {
		super();
		this.customer = customer;
		this.bookings = bookings;
		this.transactionid = transactionid;
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Booking getBookings() {
		return bookings;
	}

	public void setBookings(Booking bookings) {
		this.bookings = bookings;
	}


	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", customer=" + customer + ", bookings=" + bookings
				 + ", transactionid=" + transactionid + "]";
	}
	
	
}
