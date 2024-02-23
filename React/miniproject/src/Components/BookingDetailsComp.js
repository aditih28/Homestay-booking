import React, { useEffect, useState, useReducer } from 'react';
import { useLocation } from 'react-router-dom';
import {Link,Navigate, useNavigate} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { dynamicCustId } from './CustomerBookHotelComp.js';        
import { dynamicVal } from './CustomerBookHotelComp.js';        

const init={
  startdate: { value: '', valid: false, error: 'Start date is required' },
enddate: { value: '', valid: false, error: 'End date is required' },
noofrooms: { value: '', valid: false, error: 'Number of rooms are required' },
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

const BookingDetails = () => {
  let navigate = useNavigate();

  const location = useLocation();
  const [hotelData, setHotelData] = useState({});
  const [startDate, setStartDate] = useState('');
  const [noOfRooms, setNoofrooms] = useState('');
  const [endDate, setEndDate] = useState('');
  const [isValid, setIsValid] = useState(true);

  useEffect(() => {
    const data = location.state?.hotelData;
    if (data) {
      setHotelData(data);
    }
  }, []);

  const handleStartDateChange = (event) => {
    setStartDate(event.target.value);
  };
  const handleNoofroomsChange = (event) => {
    setNoofrooms(event.target.value);
  };
  const handleEndDateChange = (event) => {
    setEndDate(event.target.value);
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

    const custid = dynamicCustId();
    console.log("value="+custid);

       {/*} if(localStorage.getItem('myValue') == 0 || value >0 ){
          
          localStorage.setItem('myValue',+value);
          console.log('myvalue',+value);
        }else{
          localStorage.setItem('myValue', localStorage.getItem('myValue'));
          console.log('myvalue',+localStorage.getItem('myValue'));
        } */}

        const hotelid = dynamicVal();
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
          noofrooms:noOfRooms,
          custid:localStorage.getItem('customerid'),
          hotelid:localStorage.getItem('hotelid'),

        };
        
    fetch('http://localhost:8080/saveBookings', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(bookingData),
  })
    .then((response) => {
      const value = dynamicCustId();
      const val=dynamicVal();
      if (response.ok) {
          console.log("ok")
          alert('Proceed to checkout?');
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

      <label for ="noOfRooms" class="form-control">Number of Rooms :</label>
      <input type="text" id="noOfRooms" class="form-control" value={noOfRooms} onChange={handleNoofroomsChange}/>

      <br/>
      </div>
      <button
      type="submit"
      className="btn btn-primary"
      onClick={handleSubmit}
      >Pay Now</button>

      </form>

    </div>
    <div className="text-danger">
    {!isValid && <p>Please enter valid dates!!</p>}
    </div>
    </div>
  );
};
export default BookingDetails;