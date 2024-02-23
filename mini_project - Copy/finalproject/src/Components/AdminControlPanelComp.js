import {Link} from 'react-router-dom';

export default function AdminControlPanelComp() {

    return (
        
<div>       
<div className="nav navbar">
        
<div className="nav-item">
            <Link to="/logout" className="nav-link">Logout</Link>
 </div>
</div>
<div><h3>Admin control page for website</h3></div>
</div> 
            )
     }