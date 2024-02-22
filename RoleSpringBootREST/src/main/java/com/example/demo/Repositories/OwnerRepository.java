package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{

}
