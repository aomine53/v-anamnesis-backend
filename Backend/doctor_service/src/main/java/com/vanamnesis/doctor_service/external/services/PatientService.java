package com.vanamnesis.doctor_service.external.services;

import com.vanamnesis.doctor_service.entity.Patient;
import com.vanamnesis.doctor_service.entity.PatientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private RestTemplate restTemplate;


    public List<Patient> getAllPatientByDoctorId(long doctorId){
        return restTemplate.getForObject("http://localhost:8000/api-patients/getPatientByDoctorId/" + doctorId, ArrayList.class);
    }

    public PatientDetails getPatientDetailsByPatientId(long patientId){
        return restTemplate.getForObject("http://localhost:8000/details/patient/" + patientId, PatientDetails.class);
    }
}
