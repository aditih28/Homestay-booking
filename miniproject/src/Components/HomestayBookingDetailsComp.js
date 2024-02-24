import React, { useEffect, useState, useReducer } from 'react';
import { useLocation } from 'react-router-dom';
import {Link,Navigate, useNavigate} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { dynamicCustId } from './CustomerBookHomestayComp.js';        
import { dynamicVal } from './CustomerBookHomestayComp.js';     
import { dynamicCustName } from './CustomerBookHomestayComp.js';     

export let bookingid =0;
export let custid=0;
export let homestayid=0;
export let custname = "";


const init={
  startdate: { value: '', valid: false, error: 'Start date is required' },
enddate: { value: '', valid: false, error: 'End date is required' },
}

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

export const dynamicBookingid = () => {
  // Compute or generate the dynamic value here
  return bookingid;
};

export const dynamicCustomerid = () => {
  custid = dynamicCustId();
  return custid;
}; 

export const dynamicHomestayid = () => {
   homestayid = dynamicVal();
  return homestayid;
}; 

export const dybamicCustomerName = () => {
  custname = dynamicCustName();
  return custname;
}

const HomestayBookingDetails = () => {
  let navigate = useNavigate();

  const location = useLocation();
  const [homestayData, setHomestayData] = useState({});
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [isValid, setIsValid] = useState(true);
  const [custname, setCustName] = useState('');

  useEffect(() => {
    const data = location.state?.homestayData;
    if (data) {
      setHomestayData(data);
    }
  }, []);

  const handleStartDateChange = (event) => {
    setStartDate(event.target.value);
  };
 
  const handleEndDateChange = (event) => {
    setEndDate(event.target.value);
  };
  const handleCustomerName = (event) => {
    setCustName(event.target.value);
  };

  const validateDates = () => {
    const startDateObj = new Date(startDate);
    const endDateObj = new Date(endDate);
    const currentDate = new Date();

    if (startDateObj > endDateObj || startDateObj<currentDate) {
      setIsValid(false);
      return;
    }

    setIsValid(true);
  };

  const [booking, dispatch] = useReducer(reducer, init);

  const handleSubmit = (e) => {
    e.preventDefault();
    validateDates();

       {/*} if(localStorage.getItem('myValue') == 0 || value >0 ){
          
          localStorage.setItem('myValue',+value);
          console.log('myvalue',+value);
        }else{
          localStorage.setItem('myValue', localStorage.getItem('myValue'));
          console.log('myvalue',+localStorage.getItem('myValue'));
        } */}

        
        {/* if(localStorage.getItem('myVal') == 0 || val >0 ){
          
          localStorage.setItem('myVal',+val);
          console.log('myval',+val);
        }else{
          localStorage.setItem('myVal', localStorage.getItem('myVal'));
          console.log('myval',+localStorage.getItem('myVal'));
        } */}

        const bookingData={
          startdate:startDate,
          enddate:endDate,
          custid:localStorage.getItem('customerid'),
          homestayid:localStorage.getItem('homestayid'),
          custname:localStorage.getItem('customername')
        };
        
    fetch('http://localhost:8080/saveHomeBookings', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(bookingData),
  })
  .then(resp => resp.text())
  .then(text => text.length ? JSON.parse(text):{})
  .then((response) => {
      const value = dynamicCustId();
      const val=dynamicVal();
      if (response.status === "OK") {
           bookingid = response.bookingid;
          console.log("ok")
          navigate('/checkout')
      } else {
        response.text().then((errorMessage) => {
          console.error('Something went wrong. Error:', errorMessage);
          dispatch({ type: 'reset' }); // Reset the form after successful registration

        });
      }
    })
    .catch((error) => {
      console.error('Error occured:', error);
      alert('An error occurred. Please try again.');
    });
  };
  


  return (
    <div className="row">
        <div className="nav navbar">
      <Link to="/logout" className="nav-link">Logout</Link>
      </div>
     <div className="form-outline w-25 col-md-6 mx-auto h-100 d-flex align-items-center justify-content-center" width="w-50" align="center">

    
      <form className="form-control-sm" align="center">
        <div className="mb-3">
      <h2>Confirm booking</h2>
      
      <label for ="checkin" class="form-control">Checkin :</label>
      <input type="date" id="checkin" class="form-control" value={startDate} onChange={handleStartDateChange}/>

      <label for ="checkout" class="form-control">Checkout :</label>
      <input type="date" id="checkout" class="form-control" value={endDate} onChange={handleEndDateChange}/>

      <br/>
      </div>
      <button
      type="submit"
      className="btn btn-primary"
      onClick={handleSubmit}
      >Confirm details</button>

      </form>

    </div>
    <div className="text-danger">
    {!isValid && <p>Please enter valid dates!!</p>}
    </div>
    </div>
  );
};
export default HomestayBookingDetails;