package com.example.demo.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int roleid;
		
		@Column
		String rolename;	
		
		@JsonIgnoreProperties("role")
		@OneToMany(mappedBy="role" ,cascade = CascadeType.ALL)
		Set<User> users;

		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Role(int roleid, String rolename, Set<User> users) {
			super();
			this.roleid = roleid;
			this.rolename = rolename;
			this.users = users;
		}


		/**
		 * @return the roleid
		 */
		public int getRoleid() {
			return roleid;
		}


		/**
		 * @param roleid the roleid to set
		 */
		public void setRoleid(int roleid) {
			this.roleid = roleid;
		}


		/**
		 * @return the rolename
		 */
		public String getRolename() {
			return rolename;
		}


		/**
		 * @param rolename the rolename to set
		 */
		public void setRolename(String rolename) {
			this.rolename = rolename;
		}


		/**
		 * @return the users
		 */
		public Set<User> getUsers() {
			return users;
		}


		/**
		 * @param users the users to set
		 */
		public void setUsers(Set<User> users) {
			this.users = users;
		}


		@Override
		public String toString() {
			return "Role [roleid=" + roleid + ", rolename=" + rolename + ", Users=" + users + "]";
		}
		
		
		
}
