import { myAxios } from "./helperPatient";

export const PSignUp = (Patient) => {
  return myAxios
    .post("/api-patients/signUp", Patient)
    .then((response) => response.data);
};

export const DSignUp = (Doctor) => {
  return myAxios
    .post("/api-doctor/doctorSignUp", Doctor)
    .then((response) => response.info);
};

export const loginUser = (loginDetail) => {
  return myAxios
    .post("/api-patients/login", loginDetail)
    .then((response) => response.data);
};
