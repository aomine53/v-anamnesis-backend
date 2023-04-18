import * as React from "react";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { Link } from "react-router-dom";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import { img } from "@mui/material";
import logo from "../assests/Anamnesis.png";

const theme = createTheme();

export default function LandingPage() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Grid item xs={12} sm={6} mt={4} mr={4} sx={{ display: "flex" }}>
        <Box
          sx={{
            display: "flex",
            ml: 6,
            alignItems: "center",
            justifyContent: "flex-start",
          }}
        >
          {/* <img src={logo} style={{ height: "50px", marginRight: "10px" }} /> */}
          <Typography
            variant="h3"
            sx={{
              fontFamily: "Kaushan Script",
              fontSize: "60px",
              color: "#004499",
              ml: "30px",
              mt: "3px",
            }}
          >
            V
          </Typography>
          <Typography
            variant="h3"
            sx={{
              fontFamily: "Great Vibes",
              fontSize: "55px",
              color: "#0072ca",
            }}
          >
            -anamnesis
          </Typography>
        </Box>
        <Box sx={{ display: "flex", justifyContent: "flex-end", flexGrow: 1 }}>
          <Button
            variant="contained"
            sx={{ mt: 3, mb: 2, mr: 2 }}
            style={{
              borderRadius: 15,
              backgroundColor: "#1128bd",
              padding: "12px 20px",
              fontSize: "14px",
            }}
            component={Link}
            to="/signup/doctor"
          >
            Doctor's Sign Up
          </Button>
          <Button
            variant="contained"
            sx={{ mt: 3, mb: 2, mr: 2 }}
            style={{
              borderRadius: 15,
              backgroundColor: "#c62624",
              padding: "12px 20px",
              fontSize: "14px",
            }}
            component={Link}
            to="/signup/patient"
          >
            Patient's Sign Up
          </Button>
          <Button
            variant="contained"
            sx={{ mt: 3, mb: 2, mr: 2 }}
            style={{
              borderRadius: 15,
              backgroundColor: "#8400be",
              padding: "12px 20px",
              fontSize: "14px",
            }}
            component={Link}
            to="/login"
          >
            Log In
          </Button>
        </Box>
      </Grid>
      {/* <Grid container justifyContent="left">
        <Grid item xs={12} sm={6}>
          <Card>
            <CardContent>
              This code uses the Grid component from a UI library, probably
              Material-UI, to render an image. The image is sourced from a URL
              and is related to the medical field. The image is displayed with a
              maximum width of 90%, a top margin of 3%, a width of 35%, and a
              right margin of 6%. The Grid component is styled with CSS-in-JS
              using the sx prop, which sets the display to flex and the
              justify-content to right. The xs, sm, and md props set the size of
              the Grid item on different screen sizes.
            </CardContent>
          </Card>
        </Grid>
      </Grid> */}
      <Grid
        item
        xs={false}
        sm={4}
        md={7}
        sx={{
          display: "flex",
          // alignItems: "center",
          justifyContent: "right",
        }}
      >
        <img
          src="https://img.freepik.com/free-vector/hand-drawn-doctors-nurses-illustration_23-2148903885.jpg?size=626&ext=jpg&ga=GA1.2.916134240.1681288939&semt=ais"
          alt="medical-related"
          style={{
            maxWidth: "90%",
            width: "35%",
            marginRight: "3%",
            marginTop: "3%",
          }}
        />
      </Grid>
    </ThemeProvider>
  );
}
