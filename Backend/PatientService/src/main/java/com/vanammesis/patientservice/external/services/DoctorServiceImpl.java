package com.vanammesis.patientservice.external.services;

import com.vanammesis.patientservice.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl {
        @Autowired
    private RestTemplate restTemplate;

    public List<Doctor> getAllDoctors(){
        return restTemplate.getForObject("http://localhost:8001/api-doctor/getAllDoctors",  ArrayList.class);
    }

    public Doctor getDoctorById(long doctorId){
        return restTemplate.getForObject("http://localhost:8001/api-doctor/getDoctor/"+ doctorId, Doctor.class);
    }


}
