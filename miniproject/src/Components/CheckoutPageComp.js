import React, { useEffect, useState } from 'react';
import { dynamicBookingid, dynamicCustomerid, dynamicHotelid, dybamicCustomerName } from './BookingDetailsComp.js';
import { useNavigate } from 'react-router-dom';

export default function CheckoutPageComp() {
  const bookingId = dynamicBookingid();
  const customerId = dynamicCustomerid();
  //const hotelId = dynamicHotelid();
  const customerName = dybamicCustomerName();

  const [bookingID, setBookingId] = useState('');
  const [custID, setCustId] = useState('');
  const navigate=useNavigate();

  useEffect(() => {
    setBookingId(bookingId);
    setCustId(customerId);
  }, [bookingId, customerId]);

  const handleSubmit = (e) => {
    e.preventDefault();

    const paymentData = {
      bookingid: bookingID,
      custid: custID,
    };

    fetch('http://localhost:8080/savepayment', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(paymentData),
    })
    .then(response => {
      if ((response.ok)) {
        console.log("ok");
        alert("Booking successful!");
        navigate('/customer')
      } else {
        
     //   console.error('Something went wrong. Error:', data.error);
        alert('An error occurred. Please try again.');
      }
    })
    .catch((error) => {
      console.error('Error occurred:', error);
      alert('An error occurred. Please try again.');
    });
  };

  return (
    <div>
      <div>
        <h2>Thank you for booking with us {customerName}!</h2>
      </div>
      <div>
        <h2>Confirm checkout?</h2>
      </div>
      <div>
        <button
          type="submit"
          className="btn btn-primary"
          onClick={handleSubmit}
        >
          Checkout
        </button>
      </div>
    </div>
  );
}
