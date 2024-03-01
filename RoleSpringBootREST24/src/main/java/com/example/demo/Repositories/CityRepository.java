package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.City;
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	@Query("select c from City c where cityname=?1")
	public City findByName(String cityName);
	
	//@Query("select c from city c where stateid=?1")
	//public List<City> findByStateid(int stateid);
}
