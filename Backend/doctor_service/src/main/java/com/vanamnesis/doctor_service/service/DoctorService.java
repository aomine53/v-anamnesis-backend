package com.vanamnesis.doctor_service.service;

import com.vanamnesis.doctor_service.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    Doctor getDoctorByEmail(String email);

    Doctor getDoctorById(Long id);

    List<Doctor> getAllDoctors();

    Doctor updateDoctor(Doctor doctor);
    String deleteDoctor(String email);

}
