import { useReducer,useState } from 'react';
import {Link} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from "react";
import { dynamicValue } from './LoginComp.js';        
import { Container, Row, Col, Form } from 'react-bootstrap';     


    const init = {
        name: {value:"",valid: false, touched: false, error:""},
        address: {value:"",valid: false, touched: false, error:""},
        state: {value:"",valid: false, error:""},
        city: {value:"",valid: false, error:""},
        emailid: {value:"",valid: false, touched: false, error:""},
        phone:{value:"",valid: false, touched: false, error:""},
        description:{value:"",valid: false, touched: false, error:""},
        capacity:{value:"",valid: false, error:""},
    
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
    
    
    export default function OwnerAddHomestaysComp() {
    
    
        const [homestays, dispatch] = useReducer(reducer, init);
      
    
      const validateData = (key, val) => {
        let valid = true;
        let error = '';
      
        switch (key) {
          
          case 'name': 
            valid = /^[A-Za-z]+$/.test(val);
            error = 'homestays Name is required';
            break;
          case 'emailid':
              valid = /^\S+@\S+\.\S+$/.test(val);
              error = 'Invalid emailid address';
              break;
          case 'phone': 
            valid = /^\d{10}$/.test(val);
            error = 'Invalid phone number';
            break;

          case 'capacity':
            valid = val.trim() !== '';
            error = 'capacity is required';
            break;
          default:
            break;
        }
      
        return { valid, error };
      };
    
      const handleChange = (key, value) => {
        const { valid, error } = validateData(key, value);
      
        let formValid = true;
        for (let k in homestays) {
          if (k !== key && (homestays[k].valid === false || homestays[k].touched === false)) {
            formValid = false;
            break;
          }
        }
      
        dispatch({ type: 'update', data: { key, value, touched: true, valid, error, formValid } });
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

      const homestaysData = {
        //customer_id: customer.customer_id.value,
        name: homestays.name.value,
        address: homestays.address.value,
        state: state,
        city: selectedCity,
        emailid: homestays.emailid.value,
        phone: homestays.phone.value,
        description: homestays.description.value,
        capacity:homestays.capacity.value,
        ownerid:localStorage.getItem('myValue'),

      };
    
      fetch('http://localhost:8080/saveHomestay', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(homestaysData),
      })
      .then((response) => {
        const value = dynamicValue();
        console.log("value="+value);
        if (response.ok) {
          alert('Homestay registered successfully!');
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
        <div>
<div className="nav navbar">
        
        <div className="nav-item">
            <Link to="/logout" className="nav-link">Logout</Link>
        </div>
     </div>
     <h3 className="text-center mb-4 text-info">Homestay Registration</h3>
      <div className="row"> 

      <form className="form-outline w-25 col-md-6 mx-auto">
        {/* Customer ID */}
        {/* <div className="mb-3">
          <label className="form-label">Customer ID:</label>
          <input
            type="text"
            className={`form-control ${customer.customer_id.touched && !customer.customer_id.valid ? 'is-invalid' : ''}`}
            value={customer.customer_id.value}
            onChange={(e) => handleChange('customer_id', e.target.value)}
            onBlur={(e) => handleChange('customer_id', e.target.value)}
          />
          {customer.customer_id.touched && !customer.customer_id.valid && (
            <div className="invalid-feedback">{customer.customer_id.error}</div>
          )}
        </div> */}

        {/*  Name */}
      <div className="mb-3">
        <label className="form-label">Homestay Name:</label>
        <input
          type="text"
          className={`form-control ${homestays.name.touched && !homestays.name.valid ? 'is-invalid' : ''}`}
          value={homestays.name.value}
          onChange={(e) => handleChange('name', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('name', e.target.value)} // Update to match state key
        />
        {homestays.name.touched && !homestays.name.valid && (
          <div className="invalid-feedback">{homestays.name.error}</div>
        )}
      </div>

{/* Address */}
<div className="mb-3">
          <label className="form-label">Address:</label>
          <input
            type="text"
            className={`form-control ${homestays.address.touched && !homestays.address.valid ? 'is-invalid' : ''}`}
            value={homestays.address.value}
            onChange={(e) => handleChange('address', e.target.value)}
            onBlur={(e) => handleChange('address', e.target.value)}
          />
          {homestays.address.touched && !homestays.address.valid && (
            <div className="invalid-feedback">{homestays.address.error}</div>
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
            className={`form-control ${homestays.emailid.touched && !homestays.emailid.valid ? 'is-invalid' : ''}`}
            value={homestays.emailid.value}
            onChange={(e) => handleChange('emailid', e.target.value)}
            onBlur={(e) => handleChange('emailid', e.target.value)}
          />
          {homestays.emailid.touched && !homestays.emailid.valid && (
            <div className="invalid-feedback">{homestays.emailid.error}</div>
          )}
        </div>

        {/* Phone Number */}
      <div className="mb-3">
        <label className="form-label">Mobile Number:</label>
        <input

          type="text"
          className={`form-control ${homestays.phone.touched && !homestays.phone.valid ? 'is-invalid' : ''}`}
          value={homestays.phone.value}
          onChange={(e) => handleChange('phone', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('phone', e.target.value)} // Update to match state key
        />
        {homestays.phone.touched && !homestays.phone.valid && (
          <div className="invalid-feedback">{homestays.phone.error}</div>
        )}
      </div> 

       {/* description */}
      <div className="mb-3">
        <label className="form-label">Description:</label>
        <input
          type="text"
          className={`form-control ${homestays.description.touched && !homestays.description.valid ? 'is-invalid' : ''}`}
          value={homestays.description.value}
          onChange={(e) => handleChange('description', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('description', e.target.value)} // Update to match state key
        />
        {homestays.description.touched && !homestays.description.valid && (
          <div className="invalid-feedback">{homestays.description.error}</div>
        )}
      </div>   

        {/*capacity */}  
        <div className="mb-3">
          <label className="form-label">Capacity:</label>
          <input
            type="text"
            className={`form-control ${homestays.capacity.touched && !homestays.capacity.valid ? 'is-invalid' : ''}`}
            value={homestays.capacity.value}
            onChange={(e) => handleChange('capacity', e.target.value)}
            onBlur={(e) => handleChange('capacity', e.target.value)}
          />
          {homestays.capacity.touched && !homestays.capacity.valid && (
            <div className="invalid-feedback">{homestays.capacity.error}</div>
          )}
        </div>

      <button
        type="submit"
        className="btn btn-primary"
        //disabled={!homestays.formValid}
        onClick={submitData}
      >
        Submit
      </button>
      </form>


        </div>
     </div>
            )
     }