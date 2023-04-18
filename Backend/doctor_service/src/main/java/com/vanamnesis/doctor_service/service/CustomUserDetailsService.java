package com.vanamnesis.doctor_service.service;

import com.vanamnesis.doctor_service.entity.Doctor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


//Get user details from User and pass it to Spring User model.
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    DoctorService doctorService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorService.getDoctorByEmail(username);
        return new User(doctor.getDoctorEmail(), doctor.getDoctorPassword(), new ArrayList<>());
    }

}
