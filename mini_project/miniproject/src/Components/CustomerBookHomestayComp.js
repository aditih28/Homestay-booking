

    // HotelList.js - React Component
    import React, { useState, useEffect } from 'react';
    import 'bootstrap/dist/css/bootstrap.min.css';
    import {Link, Navigate, useNavigate } from "react-router-dom"
    
    
    export default function CustomerBookHomestayComp(){
        const [homestays, setHomestays] = useState([]);
    
        useEffect(() => {
            fetch('http://localhost:8080/getallhomestays')
                .then(response => response.json())
                .then(data => setHomestays(data))
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
                    {homestays.map(homestay => (
                        <li key={homestay.id}>
                            <h3 className="text-info">{homestay.name}</h3>
                            <p>Location: {homestay.address}</p>
                            <p key={homestay.stateid}></p>
                            <p>State: {homestay.statenamename}</p>
                            <p key={homestay.city.cityid}></p>
                                <p>City: {homestay.city.cityname}</p>
                            <p>Description: {homestay.description}</p>
                            <span>
                            <div className="nav navbar">
                            <Link to="" className="nav-link"></Link>
    
                            <Link to="/details" className="nav-link">Add room</Link>
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
    