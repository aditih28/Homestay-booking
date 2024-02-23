import { useState, useReducer, useNavigate} from "react"
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link} from 'react-router-dom';


const init = {
    firstname: {value:"",valid: false, touched: false, error:""},
    lastname: {value:"",valid: false, touched: false, error:""},
    emailid: {value:"",valid: false, touched: false, error:""},
    //gender:  {value:"",valid: false, touched: false, error:""},
    phone:{value:"",valid: false, touched: false, error:""},
    address:{value:"",valid: false, touched: false, error:""},
    //role:{value:"",valid: false, touched: false, error:""},
    propertytype:{value:"",valid: false, error:""},
    adhar:{value:"",valid: false, touched: false, error:""},
    username:{value:"",valid: false, touched: false, error:""},
    password:{value:"",valid: false, touched: false, error:""},
    formValid: false

}

const reducer = (state,action) => {
    // switch(action.type)
    // {
    //     case 'update':
    //         //partial updation
    //         //get the current state and modify only the mentioned field
    //         return {...state,[action.fld]:action.val}
    //     case 'reset':
    //         return init;
    // }

    switch(action.type) {
        case 'update':
            return {...state, [action.data.key]: {...state[action.data.key], value: action.data.value, touched: action.data.touched, valid: action.data.valid, error: action.data.error}};
        case 'reset':
            return init;
        default:
            return state;
    }
}


export default function OwnerRegistration() {


    const [owner, dispatch] = useReducer(reducer, init);
  

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
      case 'adhar':
        valid = /^\d{12}$/.test(val);
        error = 'Invalid adhar number';
        break;
      case 'propertytype':
          valid = val.trim() !== '';
          error = 'propertytype is required';
          break;
        /*case 'role':
            valid = val.trim() !== '';
            error = 'Role is required';
            break;

            */
      case 'password':
        valid = val.trim() !== '';
        error = 'Password is required';
        break;
      default:
        break;
    }
  
    return { valid, error };
  };

  const handleChange = (key, value) => {
    const { valid, error } = validateData(key, value);
  
    let formValid = true;
    for (let k in owner) {
      if (k !== key && (owner[k].valid === false || owner[k].touched === false)) {
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
  const ownerData = {
    //customer_id: customer.customer_id.value,
    firstname: owner.firstname.value,
    lastname: owner.lastname.value,
    emailid: owner.emailid.value,
    phone: owner.phone.value,
    address: owner.address.value,
   // role:owner.role.value,
    propertytype:owner.propertytype.value,
    adhar:owner.adhar.value,
    username:owner.username.value, 
     password: owner.password.value, 
  };

  fetch('http://localhost:8080/saveowner', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(ownerData),
  })
    .then((response) => {
      if (response.ok) {
        alert('owner registered successfully!');
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
    <div className="container mt-5">
      <div className="nav navbar">
        <div className="nav-item">
            <Link to="/login" className="nav-link">Login</Link>
        </div>
      </div>
      <h3 className="text-center mb-4">Owner Registration</h3>
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

        {/* First Name */}
      <div className="mb-3">
        <label className="form-label">First Name:</label>
        <input
          type="text"
          className={`form-control ${owner.firstname.touched && !owner.firstname.valid ? 'is-invalid' : ''}`}
          value={owner.firstname.value}
          onChange={(e) => handleChange('firstname', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('firstname', e.target.value)} // Update to match state key
        />
        {owner.firstname.touched && !owner.firstname.valid && (
          <div className="invalid-feedback">{owner.firstname.error}</div>
        )}
      </div>

      {/* Last Name */}
      <div className="mb-3">
        <label className="form-label">Last Name:</label>
        <input
          type="text"
          className={`form-control ${owner.lastname.touched && !owner.lastname.valid ? 'is-invalid' : ''}`}
          value={owner.lastname.value}
          onChange={(e) => handleChange('lastname', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('lastname', e.target.value)} // Update to match state key
        />
        {owner.lastname.touched && !owner.lastname.valid && (
          <div className="invalid-feedback">{owner.lastname.error}</div>
        )}
      </div>

        {/* emailid */}
        <div className="mb-3">
          <label className="form-label">emailid:</label>
          <input
            type="text"
            className={`form-control ${owner.emailid.touched && !owner.emailid.valid ? 'is-invalid' : ''}`}
            value={owner.emailid.value}
            onChange={(e) => handleChange('emailid', e.target.value)}
            onBlur={(e) => handleChange('emailid', e.target.value)}
          />
          {owner.emailid.touched && !owner.emailid.valid && (
            <div className="invalid-feedback">{owner.emailid.error}</div>
          )}
        </div>

        {/* Phone Number */}
      <div className="mb-3">
        <label className="form-label">Mobile Number:</label>
        <input
          type="text"
          className={`form-control ${owner.phone.touched && !owner.phone.valid ? 'is-invalid' : ''}`}
          value={owner.phone.value}
          onChange={(e) => handleChange('phone', e.target.value)} // Update to match state key
          onBlur={(e) => handleChange('phone', e.target.value)} // Update to match state key
        />
        {owner.phone.touched && !owner.phone.valid && (
          <div className="invalid-feedback">{owner.phone.error}</div>
        )}
      </div>

      {/*  { Gender}
        <div className="mb-3">
        <label className="form-label">Gender:</label>
        <select
          name="dropdown"
          className={`form-control ${owner.gender.touched && !owner.gender.valid ? 'is-invalid' : ''}`}
          value={owner.gender.value}
          
          onChange={(e) => handleChange('gender', e.target.value)}
          onBlur={(e) => handleChange('gender', e.target.value)}
        >
            <option value="gender" >gender</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            
            </select>
        {owner.gender.touched && !owner.gender.valid && (
          <div className="invalid-feedback">{owner.gender.error}</div>
        )}
        

      </div>
      */}

        {/* Address */}
        <div className="mb-3">
          <label className="form-label">Address:</label>
          <input
            type="text"
            className={`form-control ${owner.address.touched && !owner.address.valid ? 'is-invalid' : ''}`}
            value={owner.address.value}
            onChange={(e) => handleChange('address', e.target.value)}
            onBlur={(e) => handleChange('address', e.target.value)}
          />
          {owner.address.touched && !owner.address.valid && (
            <div className="invalid-feedback">{owner.address.error}</div>
          )}
        </div>

        {/*Adhar */}  
        <div className="mb-3">
          <label className="form-label">Adhar number:</label>
          <input
            type="text"
            className={`form-control ${owner.emailid.touched && !owner.emailid.valid ? 'is-invalid' : ''}`}
            value={owner.adhar.value}
            onChange={(e) => handleChange('adhar', e.target.value)}
            onBlur={(e) => handleChange('adhar', e.target.value)}
          />
          {owner.adhar.touched && !owner.adhar.valid && (
            <div className="invalid-feedback">{owner.adhar.error}</div>
          )}
        </div>

        {/*propertytype */}
        <div className="mb-3">
        <label className="form-label">Property type:</label>
        <select
          name="dropdown"
          className={`form-control `}
          //${owner.properttype.touched && !owner.propertytype.valid ? 'is-invalid' : ''}
          value={owner.propertytype.value}
          
          onChange={(e) => handleChange('propertytype', e.target.value)}
          onBlur={(e) => handleChange('propertytype', e.target.value)}
        >
            <option value="hotel" id="hotel">Hotel</option>
            <option value="homestay" id="homestay">HomeStay</option>
            
            </select>
        {!owner.propertytype.valid && (
          <div className="invalid-feedback">{owner.propertytype.error}</div>
        )}
      </div>


        {/*username */}  
        <div className="mb-3">
          <label className="form-label">UserName:</label>
          <input
            type="text"
            className={`form-control ${owner.username.touched && !owner.username.valid ? 'is-invalid' : ''}`}
            value={owner.username.value}
            onChange={(e) => handleChange('username', e.target.value)}
            onBlur={(e) => handleChange('username', e.target.value)}
          />
          {owner.username.touched && !owner.username.valid && (
            <div className="invalid-feedback">{owner.username.error}</div>
          )}
        </div>

      {/* Password */}
      <div className="mb-3">
        <label className="form-label">Password:</label>
        <input
          type="password"
          className={`form-control ${owner.password.touched && !owner.password.valid ? 'is-invalid' : ''}`}
          value={owner.password.value}
          onChange={(e) => handleChange('password', e.target.value)}
          onBlur={(e) => handleChange('password', e.target.value)}
        />
        {owner.password.touched && !owner.password.valid && (
          <div className="invalid-feedback">{owner.password.error}</div>
        )}
      </div>
      <button
        type="submit"
        className="btn btn-primary"
        //disabled={!owner.formValid}
        onClick={submitData}
      >
        Submit
      </button>
      </form>
      </div>
    </div>
  );
};

