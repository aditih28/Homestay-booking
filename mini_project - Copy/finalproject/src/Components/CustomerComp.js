import {Link} from 'react-router-dom';

export default function CustomerComp() {

    return (
<div>
<div className="nav navbar">
        
<div className="nav-item">
    <Link to="/customerBookStay" className="nav-link">Book a stay</Link>
</div>
<div className="nav-item">
    <Link to="/customerBookingHistory" className="nav-link">Check bookings</Link>
</div>
<div className="nav-item">
            <Link to="/logout" className="nav-link">Logout</Link>
        </div>
</div>
<div><h3>Welcome to Customer Page</h3></div>
</div>
            )
     }