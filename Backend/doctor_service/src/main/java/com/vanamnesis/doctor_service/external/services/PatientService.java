package com.vanamnesis.doctor_service.external.services;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientService {
}
