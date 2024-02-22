package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;
import com.example.demo.entities.UserLogin;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
	//@Query("select u from User u where username=?2 AND password=?3")
	//public User logincheck(UserLogin u);
	public User findByUsername(String username);
}