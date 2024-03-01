package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CityRepository;
import com.example.demo.entities.City;

@Service
public class CityService {
	@Autowired
	CityRepository crepo;
	
	public List<City> getAll()
	{
		return crepo.findAll();
	}
	
	public City getone(int cityid)
	{
		City c = null;
		Optional<City> cp =  crepo.findById(cityid);
		try
		{
			c = cp.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}

	public City saveCity(City c)
	{
		return crepo.save(c);
	}
	
	//public List<City> findByStateid(int stateid)
	//{
	//	return crepo.findByStateid(stateid);
	//}

}
