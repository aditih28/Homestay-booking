import React, { useState, useEffect } from 'react';
import LogoutComp from './LogoutComp';



const AdminHomePage = () => {
  const [owners, setOwners] = useState([]);

  useEffect(() => {
    // Fetch owners from the API using GET method
    fetch('http://localhost:8080/getallowners')
      .then(response => response.json())
      .then(data => setOwners(data))
      .catch(error => console.error('Error fetching owners', error));
  }, []);

  const handleApprove = (ownerid) => {
    // Handle login approval using PUT method
   
    console.log( JSON.stringify(ownerid));
    console.log(`http://localhost:8080/${ownerid.user.userid}/approve`)
  fetch(`http://localhost:8080/${ownerid.user.userid}/approve`, {
    //fetch(`http://localhost:8080/16/approve`, {
      method: 'PUT'
    })
      .then(response => {
        if (response.ok) {
          // Handle success
          console.log('Login updated successfully!');
          // Optionally update the state or perform any other actions
        } else {
          // Handle error
          console.error('Error updating login:', response.statusText);
        }
      })
      .catch(error => console.error('Error updating login:', error));
  };

  const handleReject = (ownerid) => {
    if (!ownerid) {
      console.error('Owner ID is undefined or null');
      return;
    }
    console.log( JSON.stringify(ownerid));
    console.log(`http://localhost:8080/${ownerid.user.userid}/reject`)
    fetch(`http://localhost:8080/${ownerid.user.userid}/reject`, {
      method: 'PUT'
    })
      .then(response => {
        if (response.ok) {
          // Handle success
          console.log('Owner rejected successfully!');
          // Optionally update the state or perform any other actions
        } else {
          // Handle error
          console.error('Error rejecting owner:', response.statusText);
        }
      })
      .catch(error => console.error('Error rejecting owner:', error));
  };
  

  return (
    <div>
      {/* Navbar */}
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">Admin Dashboard</a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
        </div>
      </nav>

      {/* Owner List */}
      <div className="container mt-4">
        <h1>Owner List</h1>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Firstname</th>
              <th scope="col">Lastname</th>
              <th scope="col">Email</th>
              <th scope="col">Aadhar Number</th>
              <th scope="col">Approve Status</th>
              {/*<th scope="col">Actions</th>*/}
            </tr>
          </thead>
          <tbody>
            {owners.map((owner) => (
              <tr key={owner.ownerid}>
                <td>{owner.firstname}</td>
                <td>{owner.lastname}</td>
                <td>{owner.emailid}</td>
                <td>{owner.adhar}</td>
                <td>{owner.userid?.approvestatus ? 'Approved' : 'Rejected'}</td>
                {/*<td className={owner.Approvestatus? 'text-success':'text-danger'}>{owner.Approvestatus?'Approved':'Rejected'}*/}

                {/* <td className={owner.userid?Approvestatus === 1 ? 'text-success' : 'text-danger'}>
  {owner.userid?Approvestatus ===0 ? 'Approved' : 'Rejected'}
</td> */}
                <td>
                  <button className="btn btn-success" onClick={() => handleApprove(owner)}>Accept</button>
                  <button className="btn btn-danger ms-2" onClick={() => handleReject(owner)}>Reject</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default AdminHomePage;
