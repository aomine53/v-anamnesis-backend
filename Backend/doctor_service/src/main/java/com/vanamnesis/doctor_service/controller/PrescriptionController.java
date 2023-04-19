package com.vanamnesis.doctor_service.controller;

import com.vanamnesis.doctor_service.entity.Prescription;
import com.vanamnesis.doctor_service.external.services.PrescriptionServiceImpl;
import com.vanamnesis.doctor_service.service.impl.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-doctor/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionServiceImpl prescriptionService;

    @PostMapping("/new/doctor/{doctorId}/patient/{patientId}")
    public Prescription newPrescription(@PathVariable("doctorId") long doctorId, @PathVariable("patientId") long patientId, @RequestBody Prescription prescription){
        return prescriptionService.newPrescription(patientId,doctorId,prescription);

    }

    @GetMapping("/byDoctor/{doctorId}")
    public List<Prescription> getByDoctor(@PathVariable("doctorId") long doctorId){
        return prescriptionService.getPrescriptionByDoctor(doctorId);
    }

    @GetMapping("/byPatient/{patientId}")
    public List<Prescription> getByPatient(@PathVariable("patientId") long patientId){
        return prescriptionService.getPrescriptionByPatient(patientId);
    }
}
