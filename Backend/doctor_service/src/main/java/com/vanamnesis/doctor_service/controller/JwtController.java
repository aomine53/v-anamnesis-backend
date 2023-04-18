package com.vanamnesis.doctor_service.controller;


import com.vanamnesis.doctor_service.model.JwtRequest;
import com.vanamnesis.doctor_service.model.JwtResponse;
import com.vanamnesis.doctor_service.service.CustomUserDetailsService;
import com.vanamnesis.doctor_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-doctor")
public class JwtController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    // To generate token
    @Autowired
    private JwtUtil jwtUtil;
    // To authenticate user.
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @PostMapping("/doctorLogin")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
        //Authenticate user.
        authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtRequest.getUsername(), jwtRequest.getPassword()));


        //If user gets authenticated. Gets the user details in the form of Spring User object.
        UserDetails userDetails = this.customUserDetailsService
                .loadUserByUsername(jwtRequest.getUsername());

        // Generates token
        String token = this.jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }





}
