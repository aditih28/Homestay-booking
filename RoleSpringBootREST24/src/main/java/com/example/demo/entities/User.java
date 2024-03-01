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
	int userid;
	
	@Column
	String username;	
	
	@Column
	String password;
	
	@Column
	Boolean approvestatus;

	HttpStatus status;

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

	public User(int userid, String username, String password, Boolean approvestatus, HttpStatus status, Role role,
			Owner owner) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.approvestatus = approvestatus;
		this.status = status;
		this.role = role;
		this.owner = owner;
	}

	
	public User(int userid, String username, String password, HttpStatus status, Role role) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
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
		this.password = password;;
	}
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public Boolean getApprovestatus() {
		return approvestatus;
	}

	public void setApprovestatus(Boolean approvestatus) {
		this.approvestatus = approvestatus;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

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
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", approvestatus="
				+ approvestatus + ", status=" + status + ", role=" + role + ", owner=" + owner + ", customer="
				+ customer + "]";
	}
	
	
	

}
