import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import { useSelector } from 'react-redux';
import LoginComp from './Components/LoginComp';
import LogoutComp from './Components/LogoutComp';
import HomeComp from './Components/HomeComp';
import AdminComp from './Components/AdminComp';
import OwnerComp from './Components/HomestayOwnerComp';
import CustomerComp from './Components/CustomerComp';
import OwnerUpdateOffersComp from './Components/OwnerUpdateOffersComp';
import OwnerUpdateAvailabilityComp from './Components/OwnerUpdateAvailabilityComp';
import OwnerAddHomestayComp from './Components/OwnerAddHomestayComp';
import CustomerBookingHistoryComp from './Components/CustomerBookingHistoryComp';
import CustomerBookStayComp from './Components/CustomerBookStayComp';
import AdminControlPanelComp from './Components/AdminControlPanelComp';
import AdminManageOwnerComp from './Components/AdminManageOwnerComp';
import OwnerRegistration from './Components/OwnerRegistration';
import CustomerReg from './Components/CustomerRegistration';
import ServerError from './Components/ServerError';
import NotFound from './Components/NotFoundError';
import HotelOwnerComp from './Components/HotelOwnerComp';
import OwnerAddHotelComp from './Components/OwnerAddHotelComp';
import UpdateOwnerDetails from './Components/UpdateOwnerDetails';
import UpdatePasswordForm from './Components/UpdatePassword';

function App() {
  const mystate = useSelector(state => state.logged);

  return (
    <div className="App">
      <header>
        <h1 className="text-success"><b>Online Homestay And Hotel Booking</b></h1>
        <hr className="mt-3 mb-3" />
        
        <nav>
          <ul>
            <li><Link to="/login">Login</Link></li>
            {/* Add other navigation links here */}
          </ul>
        </nav>
        
        <Routes>
          <Route path="/" element={<LoginComp />} />
          <Route path="/login" element={<LoginComp />} />
          <Route path="/home" element={<HomeComp />} />
          <Route path="/logout" element={<LogoutComp />} />
          <Route path="/admin" element={<AdminComp />} />
          <Route path="/customer" element={<CustomerComp />} />
          <Route path="/homestayowner" element={<OwnerComp />} />
          <Route path="/manageOwners" element={<AdminManageOwnerComp />} />
          <Route path="/adminControl" element={<AdminControlPanelComp />} />
          <Route path="/customerBookStay" element={<CustomerBookStayComp />} />
          <Route path="/customerBookingHistory" element={<CustomerBookingHistoryComp />} />
          <Route path="/addHomestay" element={<OwnerAddHomestayComp />} />
          <Route path="/ownerUpdateAvailability" element={<OwnerUpdateAvailabilityComp />} />
          <Route path="/ownerUpdateOffers" element={<OwnerUpdateOffersComp />} />
          <Route path="/ownerregistration" element={<OwnerRegistration />} />
          <Route path="/hotelowner" element={<HotelOwnerComp />} />
          <Route path="/custreg" element={<CustomerReg />} />
          <Route path="/addhotel" element={<OwnerAddHotelComp />} />
          <Route path="/updateOwnerDetails" element={<UpdateOwnerDetails />} />
          <Route path="/500" element={<ServerError />} />
          <Route path="/404" element={<NotFound />} />
          <Route path="/updatepassword" element={<UpdatePasswordForm />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      
      </header>
    </div>
  );
}

export default App;
