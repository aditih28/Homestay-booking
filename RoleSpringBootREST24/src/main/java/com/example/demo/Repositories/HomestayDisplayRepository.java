package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.HomestayDisplay;

@Repository
public interface HomestayDisplayRepository extends JpaRepository<HomestayDisplay, Integer> {
	 @Query("SELECT h FROM HomestayDisplay h JOIN FETCH h.state")
	 List<HomestayDisplay> findAllWithState();
	 
	 @Query("SELECT h FROM HomestayDisplay h WHERE h.ownerid = :ownerid")
	 List<HomestayDisplay> findByOwner(int ownerid);
}
