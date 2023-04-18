package com.vanamnesis.doctor_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrescriptionService {

    @Autowired
    private RestTemplate restTemplate;



}
