package com.example.demo.entities;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bookingid;
	
	@JsonIgnoreProperties("booking")
    @ManyToOne
    @JoinColumn(name = "hotelid")
	Hotel hotel;	
	
	@Column
	Date startdate;
	
	@Column
	Date enddate;
	
	@JsonIgnoreProperties("booking")
    @ManyToOne
    @JoinColumn(name = "custid")
    Customer customer;
	
	@Column
	int noofrooms;

	@Column
	HttpStatus status;
	@Column
	String name;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Booking(Hotel hotel, Date startdate, Date enddate, Customer customer, int noofrooms) {
		super();
		this.hotel = hotel;
		this.startdate = startdate;
		this.enddate = enddate;
		this.customer = customer;
		this.noofrooms = noofrooms;
	}

	public Booking(Date startdate, Date enddate, int noofrooms) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
		this.noofrooms = noofrooms;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotels) {
		this.hotel = hotels;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getNoofrooms() {
		return noofrooms;
	}


	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", hotels=" + hotel + ", startdate=" + startdate + ", enddate="
				+ enddate  + ", customer=" + customer + ", noofrooms=" + noofrooms
				+ "]";
	}	
	
}
