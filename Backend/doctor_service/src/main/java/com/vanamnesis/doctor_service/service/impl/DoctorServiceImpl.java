package com.vanamnesis.doctor_service.service.impl;

import com.vanamnesis.doctor_service.entity.Doctor;
import com.vanamnesis.doctor_service.repository.DoctorRepository;
import com.vanamnesis.doctor_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoderServiceImpl passwordEncoder;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        if(doctorRepository.findByDoctorEmail(doctor.getDoctorEmail()) != null)
            throw new RuntimeException("Doctor is already present");
        doctor.setDoctorPassword(passwordEncoder.encode(doctor.getDoctorPassword()));
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorByEmail(String email) {
        Doctor doctor = doctorRepository.findByDoctorEmail(email);
        if(doctor == null)
            throw new RuntimeException("Doctor is not present");
        return doctor;
    }

    @Override
    public Doctor getDoctorById(Long id){
        return doctorRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Doctor is not present");
                });
    }

    @Override
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        Doctor prevDoctor = doctorRepository.findByDoctorEmail(doctor.getDoctorEmail());
        if(prevDoctor == null)
            throw new RuntimeException("Invalid doctor details!");
        doctor.setId(prevDoctor.getId());
        doctor.setDoctorPassword(passwordEncoder.encode(doctor.getDoctorPassword()));
        return doctorRepository.save(doctor);
    }

    @Override
    public String deleteDoctor(String email) {
        Doctor doctor = doctorRepository.findByDoctorEmail(email);
        if(doctor == null)
            throw new RuntimeException("Invalid doctor details");
        long id = doctor.getId();
        doctorRepository.deleteById(id);
        return "Doctor with email "+ email + " is deleted!";
    }
}
