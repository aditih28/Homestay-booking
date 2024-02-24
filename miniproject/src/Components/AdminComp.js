import {Link} from 'react-router-dom';

export default function AdminComp() {

    return (
        
<div>       
<div className="nav navbar">
        
<div className="nav-item">
    <Link to="/manageOwners" className="nav-link">Manage owners</Link>
</div>
<div className="nav-item">
    <Link to="/adminControl" className="nav-link">Admin control panel</Link>
</div>

<div className="nav-item">
    <Link to="/viewbookings" className="nav-link">View Bookings</Link>
</div>
<div className="nav-item">
            <Link to="/logout" className="nav-link">Logout</Link>
 </div>
</div>
<div><h3>Welcome to Admin Page</h3></div>
</div> 
            )
     }