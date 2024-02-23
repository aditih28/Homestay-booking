import {Link} from 'react-router-dom';

export default function CustomerBookingHistoryComp() {

    return (
        <div>
<div className="nav navbar">
        
        <div className="nav-item">
            <Link to="/logout" className="nav-link">Logout</Link>
        </div>
     </div>
     <div><h3>Booking history</h3></div>
     <div><h3>Upcoming bookings</h3></div>


     </div>
            )
     }