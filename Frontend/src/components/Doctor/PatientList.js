import React, { useState } from "react";
import { v4 as uuidv4 } from "uuid";
import { useNavigate } from "react-router-dom";
import "./PatientList.css"

// import PatientDetails from "./PatientDetails.js";

function PatientList() {
  const [names, setNames] = useState([
    { id: uuidv4(), first_name: "John", last_name: "Wick", age: 26, contact: 1234512345 },
    { id: uuidv4(), first_name: "Jane", last_name: "Frost", age: 23, contact: 2342342342 },
    { id: uuidv4(), first_name: "Bob", last_name: "Marley", age: 45, contact: 4545454545 },
  ]);

  const navigate = useNavigate();


  function handleButtonClick(id) {
    navigate(`/details/${id}`);
  }

  return (
    <div>
      <h1>Paitent List</h1>
      <ul>
  {names.map((name, index) => (
    <li className="pListItem" key={name.id}>
      <span id="serial">{index + 1}. </span>
      <span id="first_name">
        {name.first_name}
      </span>
      <span id="last_name">
        {name.last_name}
      </span>
      <span id="age">
        {name.age}
      </span>
      <span id="contact">
        {name.contact}
      </span>
      <button onClick={() => handleButtonClick(name.id)}>Click me</button>
    </li>
  ))}
</ul>




    </div>
  );
}

export default PatientList;
