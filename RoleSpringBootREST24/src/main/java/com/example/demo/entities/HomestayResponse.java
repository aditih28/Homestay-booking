package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name="homestays")
	public class HomestayResponse {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int homestayid;
		@Column
		String name;
		@Column
		String address;
		@Column
		String emailid;
		@Column
		String phone;
		@Column
		String description;
		@Column
		int ownerid;
		@Column
		int capacity;
		@Column
		int stateid;
		@Column
		int cityid;
		@Column
		int price;
		public HomestayResponse(String name, String address, String emailid, String phone, String description,
				int ownerid, int capacity, int stateid, int cityid,int price) {
			super();
			this.name = name;
			this.address = address;
			this.emailid = emailid;
			this.phone = phone;
			this.description = description;
			this.ownerid = ownerid;
			this.capacity = capacity;
			this.stateid = stateid;
			this.cityid = cityid;
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
		public void setOwnerid(int ownerid) {
			this.ownerid = ownerid;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		public int getStateid() {
			return stateid;
		}
		public void setStateid(int stateid) {
			this.stateid = stateid;
		}
		public int getCityid() {
			return cityid;
		}
		public void setCityid(int cityid) {
			this.cityid = cityid;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
		
}
