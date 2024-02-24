
    // HotelList.js - React Component
    import React, { useState, useEffect } from 'react';
    import 'bootstrap/dist/css/bootstrap.min.css';
    import {Link, Navigate, useNavigate } from "react-router-dom"
    import { dynamic } from './LoginComp.js';  
    import { dynamicName } from './LoginComp.js'; 
    
    export let hotelid =0;
    //import { login } from "../loggedSlice";
    // module1.js
    export const dynamicVal = (value) => {
        // Compute or generate the dynamic value here
        hotelid = value;
        if(localStorage.getItem('hotelid') == 0 || value >0 ){
              
            localStorage.setItem('hotelid',+hotelid);
            console.log('hotelid',+hotelid);
          }else{
            localStorage.setItem('hotelid', localStorage.getItem('hotelid'));
            console.log('hotelid',+localStorage.getItem('hotelid'));
          }
          return localStorage.getItem('hotelid');
      };
      
      export const dynamicCustName = () => {
        // Compute or generate the dynamic value here
        const value = dynamicName();
        if(typeof value === 'string' || value instanceof String ){
              
            localStorage.setItem('customername',value);
            console.log('customername',+value);
          }else{
            localStorage.setItem('customername', localStorage.getItem('customername'));
            console.log('customername',+localStorage.getItem('customername'));
          }
        return localStorage.getItem('customername');
      }; 
    
      export const dynamicCustId = () => {
        // Compute or generate the dynamic value here
        const value = dynamic();
        if(localStorage.getItem('customerid') == 0 || value >0 ){
              
            localStorage.setItem('customerid',+value);
            console.log('customerid',+value);
          }else{
            localStorage.setItem('customerid', localStorage.getItem('customerid'));
            console.log('customerid',+localStorage.getItem('customerid'));
          }
        return localStorage.getItem('customerid');
      }; 
      
    export default function CustomerBookHotelComp(){
        const [hotels, setHotels] = useState([]);
        const [selectedValue, setSelectedValue] = useState('');
    
        useEffect(() => {
            fetch('http://localhost:8080/getallhotels')
                .then(response => response.json())
                .then(data => setHotels(data))
                .catch(error => console.error('Error fetching hotels:', error));
        }, []);
    
         
    
        return (
            <div>
            <div className="nav navbar">
          <Link to="/logout" className="nav-link">Logout</Link>
          </div>
             <div className="container mt-5">
                
                <div>
                <ul>
                    {hotels.map(hotel => (
                        <li key={hotel.id} onClick={() => dynamicVal(hotel.hotelid)}>
                            <h3 className="text-info">{hotel.hotelname}</h3>
                            <p>Location: {hotel.address}</p>
                            <p key={hotel.state.stateid}></p>
                            <p>State: {hotel.state.statename}</p>
                            <p key={hotel.city.cityid}></p>
                            <p>City: {hotel.city.cityname}</p>
                            <p>Description: {hotel.description}</p>
                            <p>Price: {hotel.price}</p>
    
                            <span>
                            <div className="nav navbar">
                            <Link to="" className="nav-link"></Link>
    
                            <Link to={'/details'} className="nav-link">Add room</Link>
                            <Link to="" className="nav-link"></Link>
    
                            </div>
                             </span>
                             <hr className="mt-3 mb-3"/>
                            </li>
    
                             ))}
                </ul>
                    
                </div>                  
                            
                   
            </div>
            </div>
            
        );
    }
    