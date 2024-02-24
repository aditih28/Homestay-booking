import React, { useState, useEffect } from "react";
import { Container, Row, Col } from "react-bootstrap"; // Import Row and Col
import 'bootstrap/dist/css/bootstrap.min.css';
import "../Style.css";
import { Link,useNavigate } from 'react-router-dom';

export default function GetBookings(){
    const [allBookings, setAllBookings] = useState([]);

    useEffect(() => {
        // Fetch owners from the API using GET method
        fetch('https://localhost:7192/api/Bookings')
          .then(response => response.json())
          .then(data => setAllBookings(data));
    }, []);

    const navigate = useNavigate();

    return (
        <div>
            <Container fluid>                       
                <Row>
                    <Col>
                        <h1>Bookings</h1>
                        <br></br>
                        <table className="c-disppackagetable">
                            
                                <tr>
                                  <th>bookingid </th>  
                                  <th>hotelid </th> 
                                  <th>startdate </th> 
                                  <th>enddate </th>  
                                  <th>bookingdate</th>
                                  <th>noofrooms</th>
                                </tr>
                            
                            
                                {
                                allBookings.map((allbkg, i) => {
                                    return  <tr>
                                            <td>{allbkg.bookingid}</td>
                                            <td>{allbkg.hotelid}</td>
                                            <td>{allbkg.startdate}</td>
                                            <td>{allbkg.enddate}</td>
                                            <td>{allbkg.bookingdate}</td>
                                            <td>{allbkg.noofrooms}</td>
                                        </tr>
                                })
                            }
                            
                            
                        </table>
                    </Col>
                </Row>
            </Container>
        </div>
    )
}
