import { Container } from "@mui/system";
import React from "react";
import { Input } from "reactstrap";

const NewConsultation = () => {
  return (
    <>
      <div className="container">
        <div className="row">
          <div className="col mt-5" >
            <Container>
              <div>
                <form>
                  <h5 className="mt-5 mb-5">Consult with the Doctor</h5>
                  <div className="mb-1 mt-1">
                    <label className="form-label">Patient Name</label>
                    <Input
                      type="text"
                      placeholder="Enter here"
                      id="patient name"
                    />
                  </div>

                  <div className="mb-3 mt-2">
                    <label className="form-label">Age</label>
                    <Input
                      type="text"
                      placeholder="Enter here"
                      id="firstname"
                    />
                  </div>

                  <div className="mb-3 mt-2">
                    <label className="form-label">Tell us about your symptomes</label>
                    <Input
                      type="text"
                      placeholder="Enter here"
                      id="firstname"
                    />
                  </div>

                  <div className="mb-3 mt-2">
                    <label className="form-label">Do you have any allergies?</label>
                    <Input
                      type="text"
                      placeholder="Enter here"
                      id="firstname"
                    />
                  </div>

                  <div className="mb-3 form-check">
                    <input
                      type="checkbox"
                      className="form-check-input"
                      id="exampleCheck1"
                    />
                    <label className="form-check-label" for="exampleCheck1">
                      Check me out
                    </label>
                  </div>

                  <div className="buttons">
                    <a href="/DoctorList" className="btn btn-primary mt-3">
                      Submit
                    </a>
                  </div>
                </form>
              </div>
            </Container>
          </div>
          <div className="col mt-5">
            <img
              src="/assets/bg1.jpg"
              className="d-block w-100"
              alt="Background"
              height="530px"
            />
          </div>
        </div>
      </div>
    </>
  );
};

export default NewConsultation;
