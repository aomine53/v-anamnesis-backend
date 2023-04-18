package com.vanamnesis.doctor_service.external.services;

import com.vanamnesis.doctor_service.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
