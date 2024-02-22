package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class HotelResponse{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int hotelid;
	
	@Column
	String hotelname;
	
	@Column
	String address;
	
	@Column
	int stateid;
	
	@Column
	int cityid;
	
	@Column
	String emailid;
	
	@Column
	String phone;
	
	@Column
	String description;
	
	@Column
	int ownerid;
	
	@Column
	int totalrooms;

	public HotelResponse() {
		super();
	}

	public HotelResponse(String hotelname, String address, int stateid, int cityid, String emailid, String phone,
			String description, int ownerid, int totalrooms) {
		super();
		this.hotelname = hotelname;
		this.address = address;
		this.stateid = stateid;
		this.cityid = cityid;
		this.emailid = emailid;
		this.phone = phone;
		this.description = description;
		this.ownerid = ownerid;
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

	public int getStateid() {
		return stateid;
	}

	public void setStateId(int stateid) {
		this.stateid = stateid;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
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

	public int getOwnerid() {
		return ownerid;
	}

	public void setHotelId(int ownerid) {
		this.ownerid = ownerid;
	}

	public int getTotalrooms() {
		return totalrooms;
	}

	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}

	@Override
	public String toString() {
		return "HotelResponse [hotelid=" + hotelid + ", hotelname=" + hotelname + ", address=" + address + ", stateid="
				+ stateid + ", cityid=" + cityid + ", emailid=" + emailid + ", phone=" + phone + ", description="
				+ description + ", ownerid=" + ownerid + ", totalrooms=" + totalrooms + "]";
	}

	
}
	
