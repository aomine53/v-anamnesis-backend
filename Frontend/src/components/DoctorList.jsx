import React, { useState } from "react";
import DoctorsData from "./DoctorsData";
import "./Style.css";

const DoctorList = () => {
  const [data, setData] = useState(DoctorsData);


  return (
    <>
    <div className="row d-flex justify-content-center align-items-center">
      {data.map((ele, id) => {
        return (
          <>
            <div
              class="card"
              style={{ width: "25rem", border: "1px solid black" }}
              className=" mt-5 ml-5 card_style "
            >
              <div class="card-body">
                <h4 class="card-title" className="mt-2">
                  {ele.dname}
                </h4>
                <p class="card-text">Specialization: {ele.specialization}</p>
                <p class="card-text">Experience: {ele.experience}</p>
                <p class="card-text">Rating: {ele.rating}</p>

                <a class="btn btn-primary mb-3" href="/" role="button">Book your slot</a>

              </div>
            </div>
            
          </>
        );
        
      })}
      </div>
    </>
  );
};

export default DoctorList;
