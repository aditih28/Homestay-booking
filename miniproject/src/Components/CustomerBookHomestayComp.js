


    // HotelList.js - React Component
    import React, { useState, useEffect } from 'react';
    import 'bootstrap/dist/css/bootstrap.min.css';
    import {Link, Navigate, useNavigate } from "react-router-dom"
    import { dynamic } from './LoginComp.js';  
    import { dynamicName } from './LoginComp.js'; 
    
    export let homestayid =0;

    export const dynamicVal = (value) => {
        // Compute or generate the dynamic value here
        homestayid = value;
        if(localStorage.getItem('homestayid') == 0 || value >0 ){
              
            localStorage.setItem('homestayid',+homestayid);
            console.log('homestayid',+homestayid);
          }else{
            localStorage.setItem('homestayid', localStorage.getItem('homestayid'));
            console.log('homestayid',+localStorage.getItem('homestayid'));
          }
          return localStorage.getItem('homestayid');
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

    export default function CustomerBookHomestayComp(){
        const [homestays, setHomestays] = useState([]);
        const [selectedValue, setSelectedValue] = useState('');

        useEffect(() => {
            fetch('http://localhost:8080/getallhomestays')
                .then(response => response.json())
                .then(data => setHomestays(data))
                .catch(error => console.error('Error fetching homestays:', error));
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
                            <p>Price: {homestay.price}</p>

                            <span>
                            <div className="nav navbar">
                            <Link to="" className="nav-link"></Link>
    
                            <Link to="/homestaybookDetails" className="nav-link">Add room</Link>
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
    