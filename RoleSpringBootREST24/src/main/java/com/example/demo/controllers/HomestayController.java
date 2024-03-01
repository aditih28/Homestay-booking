package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Homestay;
import com.example.demo.entities.HomestayDisplay;
import com.example.demo.entities.HomestayRegisterDummy;
import com.example.demo.entities.HomestayResponse;
import com.example.demo.services.CityService;
import com.example.demo.services.HomestayService;
import com.example.demo.services.OwnerService;
import com.example.demo.services.StateService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomestayController {
	@Autowired
	HomestayService hservice;
	@Autowired
	OwnerService oservice;
	@Autowired
	StateService sservice;
	@Autowired
	CityService cservice;

	@GetMapping("/getallhome")
	public List<Homestay> getAll()
	{
		return hservice.getAll();
	}
	
	@GetMapping("/getallhomestays")
    public List<HomestayDisplay> getAllHotelsWithState() {
        return hservice.findAllHotelsWithState();
    }
	
	//http://localhost:8080/getoneHomestay?homestayid=1
	@GetMapping("/getonehomestay")
	public Homestay getOne(@RequestParam("homestayid") int homestayid)
	{
		return hservice.getone(homestayid);
	}
	
	@PostMapping("/savehomestay")
	 public HomestayResponse saveHomestay(@RequestBody HomestayRegisterDummy hrd)
	 {
		HomestayResponse homestayRes = hservice.createHomestayResponse(hrd);
		//Hotel h=new Hotel(hrd.getHotelname(),hrd.getAddress(),state,city,hrd.getEmailid(),hrd.getPhone(),hrd.getDescription(),owner,hrd.getTotalrooms());
	
		return hservice.saveHomestayResp(homestayRes);
	}

	@GetMapping("/findhomestays")
	 public List<HomestayDisplay> findAllHomestaysByOwnerId(@RequestParam("ownerid") int ownerid) {
		    
		    return hservice.findAllHomestaysByOwnerId(ownerid);
		  }
}

