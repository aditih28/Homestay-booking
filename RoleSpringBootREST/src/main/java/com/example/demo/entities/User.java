package com.example.demo.entities;


import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int UserID;
	
	@Column
	String username;	
	
	@Column
	String password;
	
	
	HttpStatus status;
	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@JsonIgnoreProperties("users")
	@ManyToOne
	@JoinColumn(name="roleid")
	Role role;
	
	@OneToOne(mappedBy="user")
	Owner owner;
	
	@OneToOne(mappedBy="user")
	Customer customer;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(int userID, String username, String password, Role role) {
		super();
		UserID = userID;
		this.username = username;
		this.password = password;
		//this.inactive = inactive;
		this.status = status;
		this.role = role;
	}

	
	public User(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return UserID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		UserID = userID;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the inactive
	 
	public int getInactive() {
		return inactive;
	}*/

	/**
	 * @param inactive the inactive to set
	 
	public void setInactive(int inactive) {
		this.inactive = inactive;
	}*/

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", username=" + username + ", password=" + password
		+ ", role=" + role + "]";
	}
	
}
