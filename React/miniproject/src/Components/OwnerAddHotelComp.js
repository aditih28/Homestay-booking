import { useReducer,useState } from 'react';
import {Link} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import { dynamicValue } from './LoginComp.js';        
import { Container, Row, Col, Form } from 'react-bootstrap';


    const init = {
        hotelname: {value:"",valid: false, touched: false, error:""},
        address: {value:"",valid: false, touched: false, error:""},
        state: {value:"",valid: false, error:""},
        city: {value:"",valid: false, error:""},
        emailid: {value:"",valid: false, touched: false, error:""},
        phone:{value:"",valid: false, touched: false, error:""},
        description:{value:"",valid: false, touched: false, error:""},
        totalrooms:{value:"",valid: false, error:""},
    
    }
    
    const reducer = (state,action) => {
    
        switch(action.type) {
            case 'update':
                return {...state, [action.data.key]: {...state[action.data.key], value: action.data.value, touched: action.data.touched, valid: action.data.valid, error: action.data.error}};
            case 'reset':
                return init;
            default:
                return state;
        }
    }
    
    
    
    export default function OwnerAddHotelComp() {
        const [hotels, dispatch] = useReducer(reducer, init);
      
    
      const validateData = (key, val) => {
        let valid = true;
        let error = '';
      
        switch (key) {
          
          case 'hotelname': 
            valid = /^[A-Za-z]+$/.test(val);
            error = 'hotels hotelname is required';
            break;
          case 'emailid':
              valid = /^\S+@\S+\.\S+$/.test(val);
              error = 'Invalid emailid address';
              break;
          case 'phone': 
            valid = /^\d{10}$/.test(val);
            error = 'Invalid phone number';
            break;
          case 'address':
            valid = val.trim() !== '';
            error = 'Address is required';
            break;
       
        case 'totalrooms':
            valid = val.trim() !== '';
            error = 'totalrooms is required';
            break;
          default:
            break;
        }
      
        return { valid, error };
      };
    
      const [states] = useState([
        { id: 1, name: 'Maharashtra', cities: ['Yavatmal', 'Pune', 'Mumbai','Guhagar','Ganpatipule'] },
        { id: 2, name: 'Karnatak', cities: ['Hampi', 'Bangalore'] },
        { id: 3, name: 'Gujarat', cities: ['Ahmedabad', 'Bhavnagar'] },
        { id: 4, name: 'Keral', cities: ['Kochi', 'Kannur'] }
  
      ]);
    
      const [state, setSelectedState] = useState('');
      const [selectedCity, setSelectedCity] = useState('');
      const [cities, setCities] = useState([]);
    
      // Handle state selection
      const handleStateChange = (e) => {
        const stateName = e.target.value;
        const selectedStateObj = states.find(state => state.name === stateName);
        setSelectedState(stateName);
        setCities(selectedStateObj ? selectedStateObj.cities : []);
        setSelectedCity('');
        console.log("selected state",+stateName)
      };
    
      // Handle city selection
      const handleCityChange = (e) => {
        setSelectedCity(e.target.value);
      };
    
    
      const handleChange = (key, value) => {
        const { valid, error } = validateData(key, value);
      
        let formValid = true;
        for (let k in hotels) {
          if (k !== key && (hotels[k].valid === false || hotels[k].touched === false)) {
            formValid = false;
            break;
          }
        }
      
        dispatch({ type: 'update', data: { key, value, touched: true, valid, error, formValid } });
      };
      
    
      const submitData = (e) => {
        e.preventDefault();
        const value = dynamicValue();
        if(localStorage.getItem('myValue') == 0 || value >0 ){
          
          localStorage.setItem('myValue',+value);
          console.log('myvalue',+value);
        }else{
          localStorage.setItem('myValue', localStorage.getItem('myValue'));
          console.log('myvalue',+localStorage.getItem('myValue'));
        }
        
      const hotelsData = {
        //customer_id: customer.customer_id.value,
        hotelname: hotels.hotelname.value,
        address: hotels.address.value,
        state: state,
        city: selectedCity,
        emailid: hotels.emailid.value,
        phone: hotels.phone.value,
        description: hotels.description.value,
        totalrooms:hotels.totalrooms.value,
        ownerid:localStorage.getItem('myValue'),
      };
    
      fetch('http://localhost:8080/saveHotel', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(hotelsData),
      })
        .then((response) => {
          const value = dynamicValue();
          console.log("value="+value);
          if (response.ok) {
            alert('Hotel registered successfully!');
            dispatch({ type: 'reset' }); 
          } else {
            response.text().then((errorMessage) => {
              console.error('Registration failed. Error:', errorMessage);
              alert('Registration failed. Please try again.');
            });
          }
        })
        .catch((error) => {
          console.error('Error during registration:', error);
          alert('An error occurred during registration. Please try again.');
        });
      };
    

    return (
      <div className=" container mt-5">
      <div className="nav navbar">
          <div className="nav-item">
              <Link to="/logout" className="nav-link">Logout</Link>
          </div>
      </div>
       <h3 className="text-center mb-4 text-info">Hotel Registration</h3>
        <div className="row"> 
  
        <form className="form-outline w-25 col-md-6 mx-auto">
  
          {/*  hotelname */}
        <div className="mb-3">
          <label className="form-label">Hotel name:</label>
          <input
            type="text"
            className={`form-control ${hotels.hotelname.touched && !hotels.hotelname.valid ? 'is-invalid' : ''}`}
            value={hotels.hotelname.value}
            onChange={(e) => handleChange('hotelname', e.target.value)} // Update to match state key
            onBlur={(e) => handleChange('hotelname', e.target.value)} // Update to match state key
          />
          {hotels.hotelname.touched && !hotels.hotelname.valid && (
            <div className="invalid-feedback">{hotels.hotelname.error}</div>
          )}
        </div>
  
          {/* Address */}
          <div className="mb-3">
            <label className="form-label">Address:</label>
            <input
              type="text"
              className={`form-control ${hotels.address.touched && !hotels.address.valid ? 'is-invalid' : ''}`}
              value={hotels.address.value}
              onChange={(e) => handleChange('address', e.target.value)}
              onBlur={(e) => handleChange('address', e.target.value)}
            />

            
            {hotels.address.touched && !hotels.address.valid && (
              <div className="invalid-feedback">{hotels.address.error}</div>
            )}
          </div>
  
          {/* State */}
      <Form.Group controlId="stateSelect">
              <Form.Label>State:</Form.Label>
              <Form.Control as="select" onChange={handleStateChange} value={state}>
                <option value="">Select a state</option>
                {states.map(state => (
                  <option key={state.id} value={state.name}>{state.name}</option>
                ))}
                value={state.name}
            onChange={(e) => handleChange('state', e.target.value)} // Update to match state key
            onBlur={(e) => handleChange('state', e.target.value)} 
              </Form.Control>
            </Form.Group>

            {state && (
              <Form.Group controlId="citySelect">
                <Form.Label>City:</Form.Label>
                <Form.Control as="select" onChange={handleCityChange} value={selectedCity}>
                  <option value="">Select a city</option>
                  {cities.map(city => (
                    <option key={city} value={city}>{city}</option>
                  ))}
                </Form.Control>
              </Form.Group>
            )}

            {/* emailid */}
          <div className="mb-3">
            <label className="form-label">emailid:</label>
            <input
              type="text"
              className={`form-control ${hotels.emailid.touched && !hotels.emailid.valid ? 'is-invalid' : ''}`}
              value={hotels.emailid.value}
              onChange={(e) => handleChange('emailid', e.target.value)}
              onBlur={(e) => handleChange('emailid', e.target.value)}
            />
            {hotels.emailid.touched && !hotels.emailid.valid && (
              <div className="invalid-feedback">{hotels.emailid.error}</div>
            )}
          </div>
  
          {/* Phone Number */}
        <div className="mb-3">
          <label className="form-label">Mobile Number:</label>
          <input
            type="text"
            className={`form-control ${hotels.phone.touched && !hotels.phone.valid ? 'is-invalid' : ''}`}
            value={hotels.phone.value}
            onChange={(e) => handleChange('phone', e.target.value)} // Update to match state key
            onBlur={(e) => handleChange('phone', e.target.value)} // Update to match state key
          />
          {hotels.phone.touched && !hotels.phone.valid && (
            <div className="invalid-feedback">{hotels.phone.error}</div>
          )}
        </div>  
  
             {/*description*/}
        <div className="mb-3">
          <label className="form-label">Description:</label>
          <input
            type="text"
            className={`form-control ${hotels.description.touched && !hotels.description.valid ? 'is-invalid' : ''}`}
            value={hotels.description.value}
            onChange={(e) => handleChange('description', e.target.value)} // Update to match state key
            onBlur={(e) => handleChange('description', e.target.value)} // Update to match state key
          />
          {hotels.description.touched && !hotels.description.valid && (
            <div className="invalid-feedback">{hotels.description.error}</div>
          )}
        </div>  

          {/*totalrooms */}  
          <div className="mb-3">
            <label className="form-label">Total rooms:</label>
            <input
              type="text"
              className={`form-control ${hotels.totalrooms.touched && !hotels.totalrooms.valid ? 'is-invalid' : ''}`}
              value={hotels.totalrooms.value}
              onChange={(e) => handleChange('totalrooms', e.target.value)}
              onBlur={(e) => handleChange('totalrooms', e.target.value)}
            />
            {hotels.totalrooms.touched && !hotels.totalrooms.valid && (
              <div className="invalid-feedback">{hotels.totalrooms.error}</div>
            )}
          </div>
  
        <button
          type="submit"
          className="btn btn-primary"
          disabled={!hotels.formValid}
          onClick={submitData}
        >
          Submit
        </button>
        </form>
          </div>
       </div>
              );
    
     }