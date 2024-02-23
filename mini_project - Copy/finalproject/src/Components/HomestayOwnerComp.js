import {Link} from 'react-router-dom';

export default function OwnerComp() {

    return (
        <div>
<div className="nav navbar">
        <div className="nav-item">
            <Link to="/addHomestay" className="nav-link">Add Homestay</Link>
        </div>
        <div className="nav-item">
            <Link to="/ownerUpdateAvailability" className="nav-link">Update availability</Link>
        </div>
        <div className="nav-item">
            <Link to="/updateOwnerDetails" className="nav-link">Update owner details</Link>
        </div>
        <div className="nav-item">
            <Link to="/logout" className="nav-link">Logout</Link>
        </div>
     </div>
     <div><h3>Welcome to Homestay Owner Page</h3></div>
     </div>
            )
     }