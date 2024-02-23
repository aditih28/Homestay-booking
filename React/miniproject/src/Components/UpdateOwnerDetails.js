import React, { useReducer } from 'react';

// Reducer function to manage state updates
const reducer = (state, action) => {
  switch (action.type) {
    case 'UPDATE_FIELD':
      return {
        ...state,
        data: state.data.map((row, index) => {
          if (index === action.payload.index) {
            return { ...row, [action.payload.field]: action.payload.value };
          }
          return row;
        })
      };
    default:
      return state;
  }
};

function UpdateHotelOwnerDetails() {
  const init = {
    firstname: {value:"",valid: false, touched: false, error:""},
    lastname: {value:"",valid: false, touched: false, error:""},
    emailid: {value:"",valid: false, touched: false, error:""},
    
    phone:{value:"",valid: false, touched: false, error:""},
    address:{value:"",valid: false, touched: false, error:""},
    adhar:{value:"",valid: false, touched: false, error:""},
    
    formValid:false

}


  const [state, dispatch] = useReducer(reducer, { data: init });

  const handleEdit = (index) => {
    // Here, you might set up some UI state to indicate that a row is being edited
    console.log('Editing row:', index);
  };

  const handleSave = (index) => {
    // Here, you would typically send a request to update data on the server
    console.log('Saving row:', index);
  };

  const handleInputChange = (event, index, field) => {
    dispatch({
      type: 'UPDATE_FIELD',
      payload: { index, field, value: event.target.value }
    });
  };

  return (
    <div>
      <h2>Update personal details</h2>
          </div>
  );
}

export default UpdateHotelOwnerDetails;