import React, { useReducer } from 'react';
import {Link} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';


const init = {
  //customer_id: { value: '', valid: false, touched: false, error: 'Customer ID is required' },
  firstname: { value: '', valid: false, touched: false, error: 'First Name is required' },
  lastname: { value: '', valid: false, touched: false, error: 'Last Name is required' },
  emailid: { value: '', valid: false, touched: false, error: 'emailid is required' },
  phone: { value: '', valid: false, touched: false, error: 'Phone Number is required' },
  address: { value: '', valid: false, touched: false, error: 'Address is required' },
  adhar: { value: '', valid: false, touched: false, error: 'adhar no is required' },
  username: { value: '', valid: false, touched: false, error: 'username is required' },
  password: { value: '', valid: false, touched: false, error: 'password is required' },
  
  roleid:3,//changed*************************************************************
  formValid: false,
};

const reducer = (state, action) => {
    switch (action.type) {
        case 'update':
          const { key, value, touched, valid, error, formValid } = action.data;
          return { ...state, [key]: { value, touched, valid, error }, formValid };
        case 'reset':
          return init;
        default:
          return state;
      }
};
export default function CustomerReg() {

  const [customer, dispatch] = useReducer(reducer, init);
  const navigate=useNavigate();

  const validateData = (key, val) => {
    let valid = true;
    let error = '';
  
    switch (key) {
      
      case 'firstname': 
        valid = /^[A-Za-z]+$/.test(val);
        error = 'First Name is required';
        break;

      case 'lastname': 
        valid = /^[A-Za-z]+$/.test(val);
        error = 'Last Name is required';
        break;

      case 'emailid':
          valid = /^\S+@\S+\.\S+$/.test(val);
          error = 'Invalid email address';
          break;
      case 'phone': 
        valid = /^\d{10}$/.test(val);
        error = 'Invalid phone number';
        break;
      case 'adhar':
        valid = /^\d{12}$/.test(val);
        error = 'Invalid aadhar number';
        break;
      case 'address':
            valid = val.trim() !== '';
            error = 'Address is required';
            break;
      
      
      default:
        break;
    }
  
    return { valid, error };
  };

  const handleChange = (key, value) => {
    const { valid, error } = validateData(key, value);
  
    let formValid = true;
    for (let k in customer) {
      if (k !== key && (customer[k].valid === false || customer[k].touched === false)) {
        formValid = false;
        break;
      }
    }
  
    dispatch({ type: 'update', data: { key, value, touched: true, valid, error, formValid } });
  };
  

  const submitData = (e) => {
    e.preventDefault();

  // Hardcoded role IDs
//   const adminRoleId = 1;
//   const customerRoleId = 2;
//   const vendorRoleId = 3;

  // Construct the customer data to send to the server
  const customerData = {
    //customer_id: customer.customer_id.value,
    firstname: customer.firstname.value,
    lastname: customer.lastname.value,
    emailid: customer.emailid.value,
    phone: customer.phone.value,
    adhar: customer.adhar.value,
    address: customer.address.value,
    username: customer.username.value, // Replace with actual username
     password: customer.password.value, // Replace with actual password
     //role_id: customerRoleId, // Use the hardcoded customer role ID
    // login_id: {
    //   username: customer.username.value, // Replace with actual username
    //   password_hash: customer.password_hash.value, // Replace with actual password
    //   role_id: customerRoleId, // Use the hardcoded customer role ID
    // },
  };

  fetch('http://localhost:8080/savecustomer', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(customerData),
  })
    .then((response) => {
      if (response.ok) {
        // Successful registration
        alert('Customer registered successfully!');
        dispatch({ type: 'reset' }); // Reset the form after successful registration

        // Navigate to the login page
        navigate('/login');
      } else {
        // Registration failed
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
    <div className="container mt-5">
      <div className="nav navbar">
        <div className="nav-item">
            <Link to="/login" className="nav-link">Login</Link>
        </div>
      </div>
      <h3 className="text-center mb-4 text-info">Customer Registration</h3>
      <div className="row"> 

      <form className="form-outline w-25 col-md-6 mx-auto ">
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

        {/* First Name */}
      <div className="mb-3">
        <label className="form-label">First Name:</label>
        <input
          type="text"
          className={`form-control ${customer.firstname.touched && !customer.firstname.valid ? 'is-invalid' : ''}`}
          value={customer.firstname.value}
          onChange={(e) => handleChange('firstname', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('firstname', e.target.value)} // Update to match state key
        />
        {customer.firstname.touched && !customer.firstname.valid && (
          <div className="invalid-feedback">{customer.firstname.error}</div>
        )}
      </div>

      {/* Last Name */}
      <div className="mb-3">
        <label className="form-label">Last Name:</label>
        <input
          type="text"
          className={`form-control ${customer.lastname.touched && !customer.lastname.valid ? 'is-invalid' : ''}`}
          value={customer.lastname.value}
          onChange={(e) => handleChange('lastname', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('lastname', e.target.value)} // Update to match state key
        />
        {customer.lastname.touched && !customer.lastname.valid && (
          <div className="invalid-feedback">{customer.lastname.error}</div>
        )}
      </div>

        {/* emailid */}
        <div className="mb-3">
          <label className="form-label">emailid:</label>
          <input
            type="text"
            className={`form-control ${customer.emailid.touched && !customer.emailid.valid ? 'is-invalid' : ''}`}
            value={customer.emailid.value}
            onChange={(e) => handleChange('emailid', e.target.value)}
            onBlur={(e) => handleChange('emailid', e.target.value)}
          />
          {customer.emailid.touched && !customer.emailid.valid && (
            <div className="invalid-feedback">{customer.emailid.error}</div>
          )}
        </div>

        {/* Phone Number */}
      <div className="mb-3">
        <label className="form-label">Phone Number:</label>
        <input
          type="text"
          className={`form-control ${customer.phone.touched && !customer.phone.valid ? 'is-invalid' : ''}`}
          value={customer.phone.value}
          onChange={(e) => handleChange('phone', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('phone', e.target.value)} // Update to match state key
        />
        {customer.phone.touched && !customer.phone.valid && (
          <div className="invalid-feedback">{customer.phone.error}</div>
        )}
      </div>

        {/* Address */}
        <div className="mb-3">
          <label className="form-label">Address:</label>
          <input
            type="text"
            className={`form-control ${customer.address.touched && !customer.address.valid ? 'is-invalid' : ''}`}
            value={customer.address.value}
            onChange={(e) => handleChange('address', e.target.value)}
            onBlur={(e) => handleChange('address', e.target.value)}
          />
          {customer.address.touched && !customer.address.valid && (
            <div className="invalid-feedback">{customer.address.error}</div>
          )}
        </div>

        {/* Adhar */}
      <div className="mb-3">
        <label className="form-label">Adhar number:</label>
        <input
          type="text"
          className={`form-control ${customer.lastname.touched && !customer.lastname.valid ? 'is-invalid' : ''}`}
          value={customer.adhar.value}
          onChange={(e) => handleChange('adhar', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('adhar', e.target.value)} // Update to match state key
        />
        {customer.adhar.touched && !customer.adhar.valid && (
          <div className="invalid-feedback">{customer.adhar.error}</div>
        )}
      </div>

        {/* Username */}
      <div className="mb-3">
        <label className="form-label">Username:</label>
        <input
          type="text"
          className={`form-control ${customer.username.touched && !customer.username.valid ? 'is-invalid' : ''}`}
          value={customer.username.value}
          onChange={(e) => handleChange('username', e.target.value)}
          onBlur={(e) => handleChange('username', e.target.value)}
        />
        {customer.username.touched && !customer.username.valid && (
          <div className="invalid-feedback">{customer.username.error}</div>
        )}
      </div>

      {/* Password */}
      <div className="mb-3">
        <label className="form-label">Password:</label>
        <input
          type="password"
          className={`form-control ${customer.password.touched && !customer.password.valid ? 'is-invalid' : ''}`}
          value={customer.password.value}
          onChange={(e) => handleChange('password', e.target.value)}
          onBlur={(e) => handleChange('password', e.target.value)}
        />
        {customer.password.touched && !customer.password.valid && (
          <div className="invalid-feedback">{customer.password.error}</div>
        )}
      </div>
      <button
        type="submit"
        className="btn btn-primary"
        //disabled={!customer.formValid}
        onClick={submitData}
      >
        Submit
      </button>
      </form>
      </div>
    </div>
  );
};

