package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Hotel;
import com.example.demo.entities.HotelDisplay;
import com.example.demo.entities.HotelRegisterDummy;
import com.example.demo.entities.HotelResponse;
import com.example.demo.services.CityService;
import com.example.demo.services.HotelService;
import com.example.demo.services.OwnerService;
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
	@Autowired
	HotelService hservice;

	//http://localhost:8080/getallHotels
	@GetMapping("/getallhotel")
	public List<Hotel> getAll()
	{
		return htservice.getAll();
	}
	
	@GetMapping("/getallhotels")
    public List<HotelDisplay> getAllHotelsWithState() {
        return htservice.findAllHotelsWithState();
    }
	
	//http://localhost:8080/getonehotel?hotelid=1
	@GetMapping("/getonehotel")
	public Hotel getOne(@RequestParam("hotelid") int hotelid)
	{
		return htservice.getone(hotelid);
	}

		
	 @PostMapping("/savehotel")
	 public HotelResponse saveHotel(@RequestBody HotelRegisterDummy hrd)
	 {
		HotelResponse hotelRes = htservice.createHotelResponse(hrd);
		return htservice.saveHotelResp(hotelRes);
	}
	 
	 @GetMapping("/findhotels")
	 public List<HotelDisplay> findAllHotelsByOwnerId(@RequestParam("ownerid") int ownerid) {
		    return hservice.findAllHotelsByOwnerId(ownerid);
		  }
	
}
