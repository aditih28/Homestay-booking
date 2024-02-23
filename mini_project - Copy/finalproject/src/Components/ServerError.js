import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const ServerError = () => {
  return (
    <div>
      <h2 classname="text-danger">500 - Internal Server Error</h2>
      <p >Oops! Something went wrong on our side.</p>
    </div>
  );
};

export default ServerError;