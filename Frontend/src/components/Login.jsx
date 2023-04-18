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
import { toast } from "react-toastify";
import { loginUser } from "./services/patient-service";
import { doLogin } from "../auth";
import { useState } from "react";

const theme = createTheme();

export default function Login() {
  const [loginDetail, setLoginDetail] = useState({
    email: "",
    password: "",
  });

  const handleChange = (event, field) => {
    let actualValue = event.target.value;
    setLoginDetail({
      ...loginDetail,
      [field]: actualValue,
    });
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();
    console.log(loginDetail);

    //validation
    if (loginDetail.email.trim() === "" || loginDetail.password.trim() === "") {
      toast.error("email or Password is required");
      return;
    }

    //submit the data to server to generate token
    loginUser(loginDetail)
      .then((data) => {
        console.log(data);

        //save the data to localstorage
        doLogin(data, () => {
          console.log("Login details are saved to localhost");

          //redirect user to dashboard page
        });

        toast.success("Login Success");
        setLoginDetail({
          email: "",
          password: "",
        });
      })
      .catch((error) => {
        console.log(error);
        if (
          error.response.status === 400 ||
          error.response.status === 404 ||
          error.response.status === 401
        ) {
          toast.error("Bad Credentials");
        } else {
          toast.error("Something went wrong");
        }
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
              "url(https://img.freepik.com/free-vector/hand-drawn-patient-taking-medical-examination_52683-56720.jpg?size=626&ext=jpg&ga=GA1.1.916134240.1681288939&semt=ais)", // replace with medical-related image
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
              mt: 20,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              marginRight: "140px",
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "#8400be" }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h4">
              Login
            </Typography>
            <Box component="form" onSubmit={handleFormSubmit} sx={{ mt: 1 }}>
              <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                type="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                value={loginDetail.email}
                onChange={(e) => handleChange(e, "email")}
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
                autoComplete="current-password"
                value={loginDetail.password}
                onChange={(e) => handleChange(e, "password")}
                sx={{
                  textAlign: "center",
                  border: "2px black",
                }}
              />
              <Grid container spacing={2}>
                <Grid item xs={6}>
                  <Button
                    href="/Consult"
                    type="submit"
                    fullWidth
                    color="secondary"
                    variant="contained"
                    sx={{ mt: 3, mb: 2 }}
                    style={{
                      borderRadius: 15,
                      backgroundColor: "#8400be",
                      padding: "14px 15px",
                      fontSize: "14px",
                    }}
                  >
                    Login as Patient
                  </Button>
                </Grid>
                <Grid item xs={6}>
                  <Button
                    type="submit"
                    fullWidth
                    color="secondary"
                    variant="contained"
                    sx={{ mt: 3, mb: 2 }}
                    style={{
                      borderRadius: 15,
                      backgroundColor: "#8400be",
                      padding: "14px 15px",
                      fontSize: "14px",
                    }}
                  >
                    Login as Doctor
                  </Button>
                </Grid>
              </Grid>
              <Grid container>
                <Grid item xs>
                  <Link href="/" variant="body2">
                    Forgot password?
                  </Link>
                </Grid>
                <Grid item>
                  <Link href="/" variant="body2">
                    {"Don't have an account? Sign Up"}
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
