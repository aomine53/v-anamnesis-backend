import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { useState } from "react";
import { PSignUp } from "../components/services/patient-service";
import { toast } from "react-toastify";

const theme = createTheme();

export default function PatientSignUp() {
  const [data, setData] = useState({
    patientName: "",
    patientEmail: "",
    patientPassword: "",
  });

  const [error, setError] = useState({
    errors: {},
    isError: false,
  });

  //handle change, data
  const handleChange = (event, property) => {
    // console.log("Name changed");
    // console.log(event.target.value);

    //Dynamic setting the values
    setData({ ...data, [property]: event.target.value });
  };

  //submit the form
  const submitForm = (event) => {
    event.preventDefault();

    // if (error.isError) {
    //   toast.error("Form data is invalid, correct all details then submit");
    //   return;
    // }

    console.log(data);
    //data validate

    //call server api for sending dada
    PSignUp(data)
      .then((resp) => {
        console.log(resp);
        console.log("success log");
        toast.success("You've registered successfully");
        setData({
          patientName: "",
          patientEmail: "",
          patientPassword: "",
        });
      })
      .catch((error) => {
        console.log(error);
        console.log("Error log");

        //handle errors
        setError({
          errors: error,
          isError: true,
        });
      });
  };

  // const handleSubmit = (event) => {
  //   event.preventDefault();
  //   const data = new FormData(event.currentTarget);
  //   console.log({
  //     email: data.get("email"),
  //     password: data.get("password"),
  //   });
  // };

  return (
    <ThemeProvider theme={theme}>
      <Grid container component="main" sx={{ height: "100vh" }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage:
              "url(https://img.freepik.com/free-vector/flat-hand-drawn-patient-taking-medical-examination_52683-57829.jpg?w=1060&t=st=1681369209~exp=1681369809~hmac=fa93c6d92819d96adbc0946d9378ff073342fcdd67fcd65b156353094680971a)", // replace with medical-related image
            backgroundRepeat: "no-repeat",
            backgroundSize: "85%",
            backgroundPosition: "center",
          }}
        />
        <Grid item xs={12} sm={8} md={5} elevation={6} square>
          <Box
            sx={{
              my: 8,
              mx: 4,
              mt: 15,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              marginRight: "140px",
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "#c62624" }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h4">
              Patient SignUp
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={submitForm}
              sx={{ mt: 1 }}
            >
              <TextField
                margin="normal"
                required
                fullWidth
                id="name"
                type="text"
                label="Full Name"
                name="fullname"
                autoComplete="name"
                onChange={(e) => handleChange(e, "patientName")}
                value={data.patientName}
                invalid={
                  error.errors?.response?.data?.patientName ? true : false
                }
                autoFocus
                sx={{
                  textAlign: "center",
                  border: "2px black",
                }}
              />

              <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                type="text"
                label="Email Address"
                name="email"
                autoComplete="email"
                onChange={(e) => handleChange(e, "patientEmail")}
                value={data.patientEmail}
                invalid={
                  error.errors?.response?.data?.patientEmail ? true : false
                }
                autoFocus
                sx={{
                  textAlign: "center",
                  border: "2px black",
                }}
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                onChange={(e) => handleChange(e, "patientPassword")}
                value={data.patientPassword}
                invalid={
                  error.errors?.response?.data?.patientPassword ? true : false
                }
                autoComplete="current-password"
                sx={{
                  textAlign: "center",
                  border: "2px black",
                }}
              />
              <Button
                type="submit"
                fullWidth
                color="secondary"
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
                style={{
                  borderRadius: 15,
                  backgroundColor: "#c62624",
                  padding: "14px 20px",
                  fontSize: "14px",
                }}
              >
                SignUp
              </Button>
              <Grid container>
                <Grid item xs></Grid>
                <Grid item>
                  <Link href="/login" variant="body2">
                    {"Already have an account? Login."}
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
        </Grid>
      </Grid>
    </ThemeProvider>
  );
}
