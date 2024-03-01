package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.PaymentDummy;
@Repository
public interface PaymentDummyRepository extends JpaRepository<PaymentDummy, Integer> {

}
