package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentDummy {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int paymentid;
int custid;
int bookingid;
String transactionid;
String custname;
public PaymentDummy() {
	super();
}
public PaymentDummy(int custid, int bookingid,String transactionid) {
	super();
	this.custid = custid;
	this.bookingid = bookingid;
	this.transactionid = transactionid;
}


public PaymentDummy(int custid, int bookingid) {
	super();
	this.custid = custid;
	this.bookingid = bookingid;
}
public int getPaymentid() {
	return paymentid;
}
public void setPaymentid(int paymentid) {
	this.paymentid = paymentid;
}
public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public int getBookingid() {
	return bookingid;
}
public void setBookingid(int bookingid) {
	this.bookingid = bookingid;
}

public String getTransactionid() {
	return transactionid;
}
public void setTransactionid(String transactionid) {
	this.transactionid = transactionid;
}


}
