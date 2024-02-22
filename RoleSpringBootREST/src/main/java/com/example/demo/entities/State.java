package com.example.demo.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="states")
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int stateid;
	
	@Column
	String statename;
	
	@JsonIgnoreProperties("state")
	@OneToMany(mappedBy="state" ,cascade = CascadeType.ALL)
	Set<City> cities;

	
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(String statename) {
		super();
		this.statename = statename;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}
	
}

