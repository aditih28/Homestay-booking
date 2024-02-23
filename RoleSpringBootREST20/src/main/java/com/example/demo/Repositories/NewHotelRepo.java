package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Hotel;
import com.example.demo.entities.HotelResponse;

public interface NewHotelRepo extends JpaRepository<HotelResponse, Integer>{

}
