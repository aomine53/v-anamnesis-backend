package com.vanamnesis.doctor_service.controller;

import com.vanamnesis.doctor_service.entity.Patient;
import com.vanamnesis.doctor_service.entity.PatientDetails;
import com.vanamnesis.doctor_service.external.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-doctor")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients/{doctorId}")
    public List<Patient> getPatientsFromDoctor(@PathVariable("doctorId") long doctorId){
        return patientService.getAllPatientByDoctorId(doctorId);
    }

    @GetMapping("/patientDetails/{patientId}")
    public PatientDetails getDetailsByPatient(@PathVariable("patientId") Long patientId){
        return patientService.getPatientDetailsByPatientId(patientId);
    }
}
