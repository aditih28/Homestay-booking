package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.OwnerUpdationDummy;
@Repository
public interface OwnerUpdationDummyRepo extends JpaRepository<OwnerUpdationDummy, Integer> {
	//@Query("select o from OwnerUpdationDummyRepo o where ownerid=?1")
	//public OwnerUpdationDummy findOwnerUpdationDummy(int ownerid);
}
