package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.OwnerRepository;
import com.example.demo.Repositories.OwnerUpdationDummyRepo;
import com.example.demo.entities.Owner;
import com.example.demo.entities.OwnerRegistrationDummy;
import com.example.demo.entities.OwnerUpdationDummy;

import jakarta.transaction.Transactional;

@Service
public class OwnerService {

	@Autowired
	OwnerRepository orepo;
	
	@Autowired
	OwnerUpdationDummyRepo ourepo;
	
	public List<Owner> getAll()
	{
		return orepo.findAll();
	}
	
	public Owner getone(int ownerid)
	{
		Owner o = null;
		Optional<Owner> op =  orepo.findById(ownerid);
		try
		{
			o = op.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return o;
	}

	public Owner saveOwner(Owner o)
	{
		return orepo.save(o);
	}
	
	/*public OwnerUpdationDummy updateOwner(OwnerUpdationDummy updatedOwner) {
		Owner o = null;
		
		Optional<Owner> existingOwner =  orepo.findById(updatedOwner.getOwnerid());
		try
		{
			o = existingOwner.get();
				
			 	o.setFirstname(updatedOwner.getFirstname());
		        o.setLastname(updatedOwner.getLastname());
		        o.setAddress(updatedOwner.getAddress());
		        o.setPhone(updatedOwner.getPhone());
		        o.setEmailid(updatedOwner.getEmailid());
		        o.setAdhar(updatedOwner.getAdhar());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		

			
        return orepo.save(o);*/
       /* 
        @Transactional
        public OwnerUpdationDummy updateOwner(int ownerid,Owner o) {
            // Retrieve the entity from the database
        	OwnerUpdationDummy obj = ourepo.findOwnerUpdationDummy(ownerid);

            // Update the owner
            obj.setFirstname(o.getFirstname());
	        obj.setLastname(o.getLastname());
	        obj.setAddress(o.getAddress());
	        obj.setPhone(o.getPhone());
	        obj.setEmailid(o.getEmailid());
	        obj.setAdhar(o.getAdhar());
            // Save the updated entity
            return ourepo.save(obj);
    }
	*/
}
