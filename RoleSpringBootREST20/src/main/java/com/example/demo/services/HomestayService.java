package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CityRepository;
import com.example.demo.Repositories.HomestayRepository;
import com.example.demo.Repositories.HomestayResponseRepo;
import com.example.demo.Repositories.HotelRepository;
import com.example.demo.Repositories.StateRepository;
import com.example.demo.entities.City;
import com.example.demo.entities.Homestay;
import com.example.demo.entities.HomestayRegisterDummy;
import com.example.demo.entities.HomestayResponse;
import com.example.demo.entities.Hotel;
import com.example.demo.entities.HotelRegisterDummy;
import com.example.demo.entities.HotelResponse;
import com.example.demo.entities.Owner;
import com.example.demo.entities.State;

@Service
public class HomestayService {
	@Autowired
	HomestayRepository hrepo;
	@Autowired
	OwnerService oservice;
	@Autowired
	StateRepository srepo;
	@Autowired
	CityRepository crepo;
	@Autowired
	HomestayResponseRepo hrrepo;
	
	public List<Homestay> getAll()
	{
		return hrepo.findAll();
	}
	
	public Homestay getone(int homestayid)
	{
		Homestay h = null;
		Optional<Homestay> hp =  hrepo.findById(homestayid);
		try
		{
			h = hp.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return h;
	}

	public Homestay saveHomestay(Homestay h)
	{
		return hrepo.save(h);
	}
	
	public HomestayResponse saveHomestayResp(HomestayResponse h) 
	  {
		  return hrrepo.save(h); 
	  }
	
	 public HomestayResponse createHomestayResponse(HomestayRegisterDummy request){
		  	Owner owner =  oservice.getone(request.getOwnerid());
			State state = srepo.findByName(request.getState());
			City city = crepo.findByName(request.getCity());
			
			int stateId = state.getStateid();
			int cityId = city.getCityid();
			int ownerId = owner.getOwnerid();
			
			HomestayResponse response = new HomestayResponse(request.getName(),request.getAddress(),request.getEmailid(),request.getPhone(),request.getDescription(),ownerId,request.getCapacity(),stateId,cityId);
			return response;
			
	  }	

}

