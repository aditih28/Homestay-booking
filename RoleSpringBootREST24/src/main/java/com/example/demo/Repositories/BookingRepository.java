package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	Booking save(Booking b);
	
	/*@Query("Select b FROM Booking b JOIN b.Hotel h JOIN h.Owner o JOIN b.Customer c WHERE h.hotelId = h.hotelId
	  AND o.ownerId = :ownerid
	  AND c.customerId = :customerIdCondition")
	public Booking displayBookings(int ownerid);*/

}
