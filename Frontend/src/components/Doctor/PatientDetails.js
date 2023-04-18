import { render } from '@testing-library/react';
import React from 'react';
import { Link, useParams, useNavigate } from "react-router-dom";
import "./PatientDetails.css";


function PatientDetails (props){

  const navigate = useNavigate();

  const { id } = useParams();

  function handleButtonClick(id) {
    navigate(`/prescription/${id}`);
  }

    return (
        <div>

          <h3>Patient Details</h3>
          <button onClick={() => handleButtonClick(id)}>Prescribe</button>
        </div>

    );

};




export default PatientDetails;
