package com.example.demo.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CityRepository;
import com.example.demo.Repositories.HotelDisplayRepository;
import com.example.demo.Repositories.HotelRepository;
import com.example.demo.Repositories.NewHotelRepo;
import com.example.demo.Repositories.OwnerRepository;
import com.example.demo.Repositories.StateRepository;
import com.example.demo.entities.City;
import com.example.demo.entities.Hotel;
import com.example.demo.entities.HotelDisplay;
import com.example.demo.entities.HotelRegisterDummy;
import com.example.demo.entities.HotelResponse;
import com.example.demo.entities.Owner;
import com.example.demo.entities.State;

@Service
public class HotelService {
	@Autowired
	HotelRepository hrepo;
	@Autowired
    CityRepository cityRepository;
	@Autowired
    StateRepository srepo;
	@Autowired
	OwnerRepository orepo;
	@Autowired
	OwnerService oservice;
	@Autowired
	StateService sservice;
	@Autowired
	CityService cservice;
	@Autowired
	NewHotelRepo nRepo;
	@Autowired
	HotelDisplayRepository hdrepo;
	
	public List<Hotel> getAll()
	{
		return hrepo.findAll();
	}
	
    //private final HotelDisplayRepository hotelDisplayRepository;

	 //@Autowired
	  //  public HotelService(HotelDisplayRepository hotelDisplayRepository)
	 	//{
	   //     this.hotelDisplayRepository = hotelDisplayRepository;
	   // }

	    public List<HotelDisplay> findAllHotelsWithState() {
	    	//HotelDisplay obj=new HotelDisplay();
	    	//State state=new State();
	    	//String statename=obj.getState().getStatename();
	    	return hdrepo.findAllWithState();
	    }
	
	public Hotel getone(int hotelid)
	{
		Hotel h = null;
		Optional<Hotel> hp =  hrepo.findById(hotelid);
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

	
	  public Hotel saveHotel(Hotel h) 
	  {
		  return hrepo.save(h); 
	  }
	  
	  public HotelResponse saveHotelResp(HotelResponse h) 
	  {
		  return nRepo.save(h); 

	  }
	 
	  
	  
	  //public List<Object[]> findHotelAndCity() {
	   //     return hrepo.findHotelAndCity();
	  //  }
		/* Ensure the City object is saved first
        City city = hotel.getHotelid();
        City savedCity = cityRepository.save(city);
        State state=hotel.getState();
        State savedState=srepo.save(state);
        Owner owner=hotel.getOwner();
        Owner savedOwner=orepo.save(owner);
       Set the saved City object back to the Hotel
		Hotel h=null;
        hotel.setState(savedState);
        hotel.setCity(savedCity);
        hotel.setOwner(savedOwner);
        Optional<Hotel> hp =  hrepo.findById(hotelid);
		try
		{
			h = hp.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return h;
         Save the Hotel
        hrepo.save(hotel);
	public Hotel saveHotel(HotelRegisterDummy hotel) {

		Hotel h=null;
		Optional<Owner> existingOwner =  orepo.findById(hotel.getOwnerid());
		Owner o = existingOwner.get();
		
		State state = new State(hotel.getState());
		City city = new City(hotel.getCity(),state);
		
		
		
		return hrepo.save(h);
    }	*/
	
	  public HotelResponse createHotelResponse(HotelRegisterDummy request){
		  	Owner owner =  oservice.getone(request.getOwnerid());
			State state = srepo.findByName(request.getState());
			City city = cityRepository.findByName(request.getCity());
			
			int stateId = state.getStateid();
			int cityId = city.getCityid();
			int ownerId = owner.getOwnerid();
			
			HotelResponse response = new HotelResponse(request.getHotelname(),request.getAddress(),stateId,cityId,request.getEmailid(),request.getPhone(),request.getDescription(),ownerId,request.getTotalrooms());
			return response;
			
	  }
	  
	  public List<HotelDisplay> findAllHotelsByOwnerId(int ownerid) {
		    
		    return hdrepo.findByOwner(ownerid);
		  }

}
