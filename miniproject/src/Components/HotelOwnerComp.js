import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from "react-router-dom";
import { dynamicValue } from './LoginComp.js';        

export default function HotelOwnerComp() {
    const [hotels, setHotels] = useState([]);

    const value = dynamicValue();
        if(localStorage.getItem('myValue') == 0 || value >0 ){
          
          localStorage.setItem('myValue',+value);
          console.log('myvalue',+value);
        }else{
          localStorage.setItem('myValue', localStorage.getItem('myValue'));
          console.log('myvalue',+localStorage.getItem('myValue'));
        }


    useEffect(() => {
        const requestParameter = localStorage.getItem('myValue');

        fetch(`http://localhost:8080/findHotels?ownerid=${requestParameter}`)
            .then(response => response.json())
            .then(data => {
                setHotels(data);
                // Save data to local storage
                localStorage.setItem('hotels', JSON.stringify(data));
            })
            .catch(error => console.error('Error fetching hotels:', error));
    }, []);

    return (
        <div>
            <div className="nav navbar">
                <div className="nav-item">
                    <Link to="/addhotel" className="nav-link">Add Hotel</Link>
                </div>
                <div className="nav-item">
                    <Link to="/ownerUpdateAvailability" className="nav-link">Update room availability</Link>
                </div>
                <div className="nav-item">
                    <Link to="/updateOwnerDetails" className="nav-link">Profile</Link>
                </div>
                <div className="nav-item">
                    <Link to="/logout" className="nav-link">Logout</Link>
                </div>
            </div>
            <div><h3>Welcome to Hotel Owner Page</h3></div>
            <div className="container mt-5">
                 <div>
                    <ul>
                        {hotels.map(hotel => (
                            <li key={hotel.id}>
                                <h2 className="text-info">{hotel.hotelname}</h2>
                                <p>Location: {hotel.address}</p>
                                <p key={hotel.state.stateid}></p>
                                <p>State: {hotel.state.statename}</p>
                                <p key={hotel.city.cityid}></p>
                                <p>City: {hotel.city.cityname}</p>
                                <hr className="mt-3 mb-3"/>
                            </li>
                        ))}
                    </ul>
                        </div> 
            </div>
        </div>
    );
}
