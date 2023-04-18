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
import { DSignUp } from "../components/services/patient-service";
import { toast } from "react-toastify";
const theme = createTheme();

export default function DoctorSignUp() {
  const [info, setInfo] = useState({
    doctorName: "",
    hospitalName: "",
    licenseNo: "",
    doctorEmail: "",
    doctorPassword: "",
    doctorGender: "",
  });

  const [error, setError] = useState({
    errors: {},
    isError: false,
  });

  //handle change, info
  const handleChange = (event, property) => {
    // console.log("Name changed");
    // console.log(event.target.value);

    //Dynamic setting the values
    setInfo({ ...info, [property]: event.target.value });
  };

  //submit the form
  const submitForm = (event) => {
    event.preventDefault();

    // if (error.isError) {
    //   toast.error("Form info is invalid, correct all details then submit");
    //   return;
    // }

    console.log(info);
    //info validate

    //call server api for sending dada
    DSignUp(info)
      .then((resp) => {
        console.log(resp);
        console.log("success log");
        toast.success("You've registered successfully");
        setInfo({
          doctorName: "",
          hospitalName: "",
          licenseNo: "",
          doctorEmail: "",
          doctorPassword: "",
          doctorGender: "",
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
  //   const info = new Forminfo(event.currentTarget);
  //   console.log({
  //     name: info.get("fullname"),
  //     hospitalName: info.get("hospital"),
  //     license: info.get("license"),
  //     email: info.get("email"),
  //     password: info.get("password"),
  //     gender: info.get("gender"),
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
              "url(https://img.freepik.com/premium-vector/health-professionals-hand-drawn-design_23-2148498873.jpg?size=626&ext=jpg&ga=GA1.2.916134240.1681288939&semt=ais)",
            backgroundRepeat: "no-repeat",
            backgroundSize: "80%",
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
            <Avatar sx={{ m: 1, bgcolor: "#1128bd" }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h4">
              Doctor Sign Up
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={submitForm}
              sx={{ mt: 1 }}
            >
              <Grid container spacing={2}>
                <Grid item xs={12} sm={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="fullname"
                    label="Full Name"
                    name="fullname"
                    inputProps={{ pattern: "[A-Za-z ]+" }}
                    autoComplete="fullname"
                    onChange={(e) => handleChange(e, "doctorName")}
                    value={info.doctorName}
                    invalid={
                      error.errors?.response?.info?.doctorName ? true : false
                    }
                    sx={{
                      textAlign: "center",
                      border: "2px black",
                    }}
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="hospital"
                    label="Hospital Name"
                    name="hospital"
                    autoComplete="hospital"
                    onChange={(e) => handleChange(e, "hospitalName")}
                    value={info.hospitalName}
                    invalid={
                      error.errors?.response?.info?.hospitalName ? true : false
                    }
                    sx={{
                      textAlign: "center",
                      border: "2px black",
                    }}
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="license"
                    label="License Number"
                    name="license"
                    autoComplete="license"
                    onChange={(e) => handleChange(e, "licenseNo")}
                    value={info.licenseNo}
                    invalid={
                      error.errors?.response?.info?.licenseNo ? true : false
                    }
                    sx={{
                      textAlign: "center",
                      border: "2px black",
                    }}
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="email"
                    label="Email"
                    type="email"
                    name="email"
                    autoComplete="email"
                    onChange={(e) => handleChange(e, "doctorEmail")}
                    value={info.doctorEmail}
                    invalid={
                      error.errors?.response?.info?.doctorEmail ? true : false
                    }
                    sx={{
                      textAlign: "center",
                      border: "2px black",
                    }}
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="password"
                    label="Password"
                    type="password"
                    name="password"
                    autoComplete="password"
                    onChange={(e) => handleChange(e, "doctorPassword")}
                    value={info.doctorPassword}
                    invalid={
                      error.errors?.response?.info?.doctorPassword ? true : false
                    }
                    sx={{
                      textAlign: "center",
                      border: "2px black",
                    }}
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="gender"
                    label="Gender"
                    name="gender"
                    autoComplete="gender"
                    onChange={(e) => handleChange(e, "doctorGender")}
                    value={info.doctorGender}
                    invalid={
                      error.errors?.response?.info?.doctorGender ? true : false
                    }
                    sx={{
                      textAlign: "center",
                      border: "2px black",
                    }}
                  />
                </Grid>
              </Grid>

              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
                style={{
                  borderRadius: 15,
                  backgroundColor: "#1128bd",
                  padding: "14px 20px",
                  fontSize: "14px",
                }}
              >
                Sign Up
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
