package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositories.HotelRepository;
import com.example.demo.entities.City;
import com.example.demo.entities.Hotel;
import com.example.demo.entities.HotelDisplay;
import com.example.demo.entities.HotelRegisterDummy;
import com.example.demo.entities.HotelResponse;
import com.example.demo.entities.Owner;
import com.example.demo.entities.OwnerRegistrationDummy;
import com.example.demo.entities.Role;
import com.example.demo.entities.State;
import com.example.demo.entities.User;
import com.example.demo.services.CityService;
import com.example.demo.services.HotelService;
import com.example.demo.services.OwnerService;
import com.example.demo.services.RoleService;
import com.example.demo.services.StateService;
import com.example.demo.services.UsersService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HotelController {
	@Autowired
	HotelService htservice;
	@Autowired
	OwnerService oservice;
	@Autowired
	StateService sservice;
	@Autowired
	CityService cservice;
	@Autowired
	UsersService uservice;
	//	http://localhost:8080/getallHotels

	@GetMapping("/getall")
	public List<Hotel> getAll()
	{
		return htservice.getAll();
	}
	
	@GetMapping("/getallHotels")
	public List<HotelDisplay> getAllHotels()
	{
		
		return htservice.getAllHotels();
	}
	
	//http://localhost:8080/getonehotel?hotelid=1
	@GetMapping("/getonehotel")
	public Hotel getOne(@RequestParam("hotelid") int hotelid)
	{
		return htservice.getone(hotelid);
	}
	
	//@GetMapping("/gethotels")
	//public List<Object[]> getHotelAndCityDetails() {
    //    return htservice.findHotelAndCity();
   // }
	
	//http://localhost:8080/savehotel{ "hotelname":"JWMarriot","address":"SB road","city":"Pune","state":"Maharashtra","emailid":"marriott@gmail.com","phone":"9988997065","description":"5 star hotel","totalroms":"20"}
	
	
		/*State state=new State(hrd.getState());
		sservice.saveState(state);
		
		System.out.println(state.getStateid());
		
		City city=new City(hrd.getCity(),state);
		cservice.saveCity(city);
		
		
		hrd.setStateid(state.getStateid());
		//hrd.setCityid(city.getCityid());
		//hrd.setOwnerid(hrd.getOwnerid());
		//hrd.setOwnerid(owner.getOwnerid());
		Hotel h=htservice.saveHotel(hrd);
				//hrd.getHotelname(),hrd.getAddress(),City city,state,hrd.getEmailid(),hrd.getPhone(),
				//hrd.getDescription(),owner,hrd.getTotalroms());
	
		htservice.saveHotel(h);	*/	
	
		/*
		 * @PostMapping("/saveHotel/{ownerId}") public Hotel saveHotel(@RequestBody
		 * HotelRegisterDummy hrd) {
		 * 
		 * //Owner owner = oservice.getone(ownerid); //sservice.saveState(state);
		 * 
		 * //cservice.saveCity(city); //int stateId = state.getStateid();
		 * 
		 * //Owner owner = oservice.getone(hrd.getOwnerid()); //State state =
		 * sservice.getone(hrd.getStateid()); //City city =
		 * cservice.getone(hrd.getCityid());
		 * 
		 * Owner owner = oservice.getone(hrd.getOwnerid()); State state = new
		 * State(hrd.getState()); City city = new City(hrd.getCity());
		 * hrd.setStateid(state.getStateid()); hrd.setCityid(city.getCityid()); Hotel
		 * h=new
		 * Hotel(hrd.getHotelname(),hrd.getAddress(),state,city,hrd.getEmailid(),hrd.
		 * getPhone(),hrd.getDescription(),owner,hrd.getTotalrooms());
		 * 
		 * return htservice.saveHotel(h); }
		 */
	
	 @PostMapping("/saveHotel")
	 public HotelResponse saveHotel(@RequestBody HotelRegisterDummy hrd)
	 {
		HotelResponse hotelRes = htservice.createHotelResponse(hrd);
		//Hotel h=new Hotel(hrd.getHotelname(),hrd.getAddress(),state,city,hrd.getEmailid(),hrd.getPhone(),hrd.getDescription(),owner,hrd.getTotalrooms());
	
		return htservice.saveHotelResp(hotelRes);
	}
	
}
