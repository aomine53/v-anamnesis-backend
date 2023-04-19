package com.vanammesis.patientservice.external.services;

import com.vanammesis.patientservice.entities.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
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


    public List<Prescription> getPrescriptionByPatient(long patientId){
        return restTemplate.getForObject("http://localhost:8002/api-prescription/ByPatient/" + patientId, ArrayList.class);
    }
}
