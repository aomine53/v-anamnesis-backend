import React from "react";

const Navbar = () => {
  return (
    <div>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="/">
            V-anamnesis
          </a>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link" href="/NewConsultation">
                  Video Consult
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/PatientDashboard">
                  Medicine History
                </a>
              </li>
            </ul>
          </div>

        </div>
      </nav>
    </div>
  );
};

export default Navbar;
