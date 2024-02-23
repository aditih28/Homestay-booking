package com.example.demo.entities;



public class CustomerRegisterDummy {
	int userid;
	String firstname;
	String lastname;
	String address;
	String phone;
	String emailid;
	String adhar;
	String username;
	String password;
	int roleid;
	
	public CustomerRegisterDummy() {
		super();
	}



	public CustomerRegisterDummy(String firstname, String lastname, String address, String phone,
			String emailid, String adhar,String username,String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.adhar = adhar;
		this.username=username;
		this.password=password;
	}
	
	

	public CustomerRegisterDummy(String firstname, String lastname, String address, String phone, String emailid,
			String adhar) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.emailid = emailid;
		this.adhar = adhar;
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

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public int getRoleid() {
		return roleid;
	}



	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
}
