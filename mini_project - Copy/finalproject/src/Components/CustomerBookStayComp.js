import {Link} from 'react-router-dom';

export default function CustomerBookStayComp() {

    return (
        <div>
<div className="nav navbar">
        
        <div className="nav-item">
            <Link to="/logout" className="nav-link">Logout</Link>
        </div>
     </div>
     <div><h3>Hotel list for booking</h3></div>
     <div><h3>Homestay list for booking</h3></div>

     </div>
            )
     }