package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Hotel;
//@Transactional
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	// @Query("SELECT h.hotelname, h.address, c.city, h.description " +
	//           "FROM Hotel h, City c " +
	 //          "WHERE h.city.cityid = c.cityid")
	 //   public List<Object[]> findHotelAndCity();
	
	

	    }
