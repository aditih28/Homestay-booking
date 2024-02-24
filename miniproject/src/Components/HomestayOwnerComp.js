import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from "react-router-dom";
import { dynamicValue } from './LoginComp.js';        

export default function HomestayOwnerComp() {
    const [homestays, setHomestays] = useState([]);

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

        fetch(`http://localhost:8080/findHomestays?ownerid=${requestParameter}`)
            .then(response => response.json())
            .then(data => {
                setHomestays(data);
                // Save data to local storage
                localStorage.setItem('homestays', JSON.stringify(data));
            })
            .catch(error => console.error('Error fetching homestays:', error));
    }, []);

    return (
        <div>
            <div className="nav navbar">
                <div className="nav-item">
                    <Link to="/addHomestay" className="nav-link">Add Homestay</Link>
                </div>
                <div className="nav-item">
                    <Link to="/ownerUpdateAvailability" className="nav-link">Update homestay availability</Link>
                </div>
                <div className="nav-item">
                    <Link to="/updateOwnerDetails" className="nav-link">Update owner details</Link>
                </div>
                <div className="nav-item">
                    <Link to="/logout" className="nav-link">Logout</Link>
                </div>
            </div>
            <div><h3>Welcome to Homestay Owner Page</h3></div>
            <div className="container mt-5">
                 <div>
                    <ul>
                        {homestays.map(homestay => (
                            <li key={homestay.id}>
                                <h2 className="text-info">{homestay.name}</h2>
                                <p>Location: {homestay.address}</p>
                                <p key={homestay.state.stateid}></p>
                                <p>State: {homestay.state.statename}</p>
                                <p key={homestay.city.cityid}></p>
                                <p>City: {homestay.city.cityname}</p>
                                <hr className="mt-3 mb-3"/>
                            </li>
                        ))}
                    </ul>
                        </div> 
            </div>
        </div>
    );
}
