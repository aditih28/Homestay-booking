package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Owner;
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{
	
}
