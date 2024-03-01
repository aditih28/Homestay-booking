package com.example.demo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
	//@Query("select u from User u where username=?2 AND password=?3")
	//public User logincheck(UserLogin u);
	public User findByUsername(String username);

	@Query("Select u from User u where u.username = :username and u.password = :password")
	public Optional<User> UserDetail(@Param("username") String username, @Param("password") String password);
	
	
	 @Modifying
		@Query(value = "update Owner set approvestatus = 1 where userid = :id ",nativeQuery = true )
		public int approveOwner(int id );
		
		
		@Modifying
		@Query(value = "update Owner set approvestatus = 0 where userid = :id ",nativeQuery = true )
		public int rejectOwner(int id );
		

}