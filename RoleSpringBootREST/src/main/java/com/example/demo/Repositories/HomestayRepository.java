package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Homestay;

public interface HomestayRepository extends JpaRepository<Homestay, Integer> {

}
