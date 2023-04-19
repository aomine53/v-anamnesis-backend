package com.vanamnesis.doctor_service.external.services;

import com.vanamnesis.doctor_service.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PrescriptionServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<Prescription> createNewPrescription(Prescription prescription){
        return Collections.singletonList(restTemplateBuilder.build().postForObject("http://localhost:8002/api-prescription/addPrescription", prescription, Prescription.class));
    }

    public Prescription newPrescription(long patientId, long doctorId, Prescription prescription){
        return restTemplateBuilder.build().postForObject("http://localhost:8002/api-prescription/add/doctor/"+ doctorId +"/patientId/" + patientId , prescription, Prescription.class);
    }

    public List<Prescription> getPrescriptionByDoctor(long doctorId){
        return restTemplate.getForObject("http://localhost:8002/api-prescription/ByDoctor/" + doctorId, ArrayList.class);
    }

    public List<Prescription> getPrescriptionByPatient(long patientId){
        return restTemplate.getForObject("http://localhost:8002/api-prescription/ByPatient/" + patientId, ArrayList.class);
    }
}
