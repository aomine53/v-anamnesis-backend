package com.vanammesis.patientservice.services;

import com.vanammesis.patientservice.responses.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PatientServiceImpl patientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        PatientResponse patientByEmail = patientService.getPatientByEmail(email);
        return new User(patientByEmail.getPatientEmail(),patientByEmail.getPatientPassword(), new ArrayList<>());
    }

}
