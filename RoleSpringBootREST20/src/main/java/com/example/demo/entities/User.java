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
	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		System.out.println("I am here in set status");
		this.status = status;
	}

	@JsonIgnoreProperties("users")
	@ManyToOne
	@JoinColumn(name="roleid")
	Role role;
	
	@OneToOne(mappedBy="user")
	Owner owner;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(int userid, String username, String password, Role role) {
		super();
		this.userid =userid;
		this.username = username;
		this.password = password;
		//this.inactive = inactive;
		this.status = status;
		this.role = role;
	}

	
	public User(int userid, String username, String password, Boolean approvestatus, HttpStatus status, Role role,
			Owner owner) {
		super();
		userid =userid;
		this.username = username;
		this.password = password;
		this.approvestatus = approvestatus;
		System.out.println("I am here"+approvestatus);
		this.status = status;
		this.role = role;
		this.owner = owner;
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
	 * @return theuserid
	 */
	public int getuserid() {
		return userid;
	}

	/**
	 * @paramuserid theuserid to set
	 */
	public void setuserid(int userid) {
		userid =userid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	public Boolean getApprovestatus() {
		return approvestatus;
	}

	public void setApprovestatus(Boolean approvestatus) {
		this.approvestatus = approvestatus;
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

	@Override
	public String toString() {
		return "User [userid=" +userid + ", username=" + username + ", password=" + password
		+ ", role=" + role + "]";
	}
	
}
