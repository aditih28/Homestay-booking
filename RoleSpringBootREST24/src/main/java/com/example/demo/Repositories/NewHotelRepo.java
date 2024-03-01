package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.HotelResponse;

@Repository
public interface NewHotelRepo extends JpaRepository<HotelResponse, Integer>{

}
