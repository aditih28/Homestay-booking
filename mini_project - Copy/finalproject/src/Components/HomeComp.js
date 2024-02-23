import { useSelector } from "react-redux"
import { Link, Outlet } from "react-router-dom"
export default function HomeComp() {

    const mystate = useSelector(state=>state.logged)
    return (
        <div>
            <h1>Welcome</h1>
            
            <ul className="nav navbar">
                <li className="nav-item">
                    <Link to="/history" className="nav-link">Book a stay</Link>
                </li>
                <li className="nav-item">
                    <Link to="/Preference" className="nav-link">Check bookings</Link>
                </li>
                <li className="nav-item">
                    <Link to="/logout" className="nav-link">LOGOUT</Link>
                </li>
            </ul>
            

        <Outlet />
        </div>
    )

}