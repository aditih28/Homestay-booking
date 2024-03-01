package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.HotelDisplay;

public interface HotelDisplayRepository extends JpaRepository<HotelDisplay, Integer> {
	 @Query("SELECT h FROM HotelDisplay h JOIN FETCH h.state")
	 List<HotelDisplay> findAllWithState();
	 
	 @Query("SELECT h FROM HotelDisplay h WHERE h.ownerid = :ownerid")
	 List<HotelDisplay> findByOwner(int ownerid);
}
