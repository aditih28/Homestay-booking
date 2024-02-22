package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserLogin {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	@Id
	int UserID;
	@Column
	String username;
	@Column
	String password;
	public UserLogin() {
		super();
	}
	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	
}
