import logo from './logo.svg';
import { Redirect } from 'react-router-dom';
import './App.css';
import {Link,Routes,Route} from 'react-router-dom';
import RouteComp from './Components/RouteComp';
import { useSelector } from 'react-redux';
import LoginComp from './Components/LoginComp';
import LogoutComp from './Components/LoginComp';
import HomeComp from './Components/HomeComp';
import AdminComp from './Components/AdminComp';
import OwnerComp from './Components/HomestayOwnerComp';
import CustomerComp from './Components/CustomerComp';
import OwnerUpdateOffersComp from './Components/OwnerUpdateOffersComp';
import OwnerUpdateAvailabilityComp from './Components/OwnerUpdateAvailabilityComp';
import OwnerAddHomestayComp from './Components/OwnerAddHomestayComp';
import CustomerBookingHistoryComp from './Components/CustomerBookingHistoryComp';
import AdminControlPanelComp from './Components/AdminControlPanelComp';
import AdminManageOwnerComp from './Components/AdminManageOwnerComp';
import OwnerRegistration from './Components/OwnerRegistration';
import CustomerReg from './Components/CustomerRegistration';
import ServerError from './Components/ServerError';
import NotFound from './Components/NotFoundError';
import HotelOwnerComp from './Components/HotelOwnerComp';
import OwnerAddHotelComp from './Components/OwnerAddHotelComp';
import UpdateHotelOwnerDetails from './Components/UpdateOwnerDetails';
import CustomerBookHotelComp from './Components/CustomerBookHotelComp';
import CustomerBookHomestayComp from './Components/CustomerBookHomestayComp';
import BookingDetails from './Components/BookingDetailsComp';
import CheckoutPageComp from './Components/CheckoutPageComp';
import React from 'react';


function App() {
  const mystate = useSelector(state=> state.logged)
  return (
    <div className="App" >
      
      <header>
      <link href="bootstrap.min.css" rel="stylesheet" />
    <script src="bootstrap.bundle.min.js" ></script>


      <h1 className="text-success"><b>Online Homestay and Hotel Booking</b></h1>
      <hr className="mt-3 mb-3"/>

         {/* <ul className="nav navbar">
            <div>
        <li className="nav-item">
        <Link to="/RegistrationForm" className="nav-link">RegistrationForm</Link>
            </li>
        </div>
        <div>
        <li className="nav-item">
        <Link to="/" className="nav-link">Registartion</Link>
            </li>
        </div>
        </ul>*/}

        <Routes>
            <Route path="/" element={<LoginComp/>}/>
            <Route path="/login" element={<LoginComp />}  />
            <Route path="/home" element={ <HomeComp/> } />
            <Route path="logout" element={ <LogoutComp /> } />
            <Route path="/admin" element={ <AdminComp/> } />
            <Route path="/customer" element={ <CustomerComp/> } />
            <Route path="/homestayowner" element={ <OwnerComp/> } />
            <Route path="manageOwners" element={ <AdminManageOwnerComp/> } />
            <Route path="/adminControl" element={ <AdminControlPanelComp/> } />
            <Route path="/customerBookingHistory" element={ <CustomerBookingHistoryComp/> } />
            <Route path="/addHomestay" element={ <OwnerAddHomestayComp/> } />
            <Route path="/ownerUpdateAvailability" element={ <OwnerUpdateAvailabilityComp/> } />
            <Route path="/ownerUpdateOffers" element={ <OwnerUpdateOffersComp/> } />
            <Route path="/ownerregistration" element={ <OwnerRegistration/> } />
            <Route path="/hotelowner" element={ <HotelOwnerComp/> } />
            <Route path="/custreg" element={ <CustomerReg/> } />
            <Route path="/addhotel" element={ <OwnerAddHotelComp/> } />
            <Route path="/updateOwnerDetails" element={ <UpdateHotelOwnerDetails/> } />
            <Route path="/customerBookHotel" element={ <CustomerBookHotelComp/> } />
            <Route path="/customerBookHomestay" element={ <CustomerBookHomestayComp/> } />
            <Route path="/checkout" element={ <CheckoutPageComp/> } />
            <Route path="/details" element={ <BookingDetails/> } />
            <Route path="/500" element={ <ServerError/> } />
            <Route path="/404" element={ <NotFound/> } />
            <Route element={ <NotFound/> } />
            <Route path="*" element={<NotFound />} />
        </Routes>
      </header>
    </div>
  );
}
export default App;