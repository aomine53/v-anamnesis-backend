package com.vanamnesis.doctor_service.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderServiceImpl {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encode(String password){
        return passwordEncoder.encode(password);
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword){
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
