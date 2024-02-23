import {Link} from 'react-router-dom';

export default function HotelOwnerComp() {

    return (
        <div>
<div className="nav navbar">
        <div className="nav-item">
            <Link to="/addhotel" className="nav-link">Add Hotel</Link>
        </div>
        <div className="nav-item">
            <Link to="/ownerUpdateAvailability" className="nav-link">Update room availability</Link>
        </div>
        <div className="nav-item">
            <Link to="/updateOwnerDetails" className="nav-link">Update owner details</Link>
        </div>
        <div className="nav-item">
            <Link to="/logout" className="nav-link">Logout</Link>
        </div>
     </div>
     <div><h3>Welcome to Hotel Owner Page</h3></div>
     </div>
            )
     }