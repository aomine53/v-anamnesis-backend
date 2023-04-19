package com.vanamnesis.prescription_service.controller;

import com.vanamnesis.prescription_service.entity.Medication;
import com.vanamnesis.prescription_service.entity.Prescription;
import com.vanamnesis.prescription_service.repository.MedicationRepository;
import com.vanamnesis.prescription_service.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private MedicationRepository medicationRepository;

    @GetMapping("/getPrescription/{id}")
    public Prescription findPrescription(@PathVariable Long id){
        return prescriptionService.getPrescriptionById(id);
    }

    @GetMapping("/getAllPrescription")
    public List<Prescription> listofPrescription(){
        return prescriptionService.getAllPrescriptions();
    }

    @PostMapping("/addPrescription")
    public Prescription addPrescription(@RequestBody Prescription prescription){
        return prescriptionService.savePrescription(prescription);
    }

    @PostMapping("/add/doctor/{doctorId}/patientId/{patientId}")
    private Prescription addnewPrescription(@PathVariable("doctorId") Long doctorId, @PathVariable("patientId") Long patientId, @RequestBody Prescription prescription){
        prescription.setDoctorId(doctorId);
        prescription.setPatientId(patientId);
        List<Medication> medication = prescription.getMedication();
        for(Medication medication1: medication){
            medicationRepository.save(medication1);
        }
        return prescriptionService.savePrescription(prescription);
    }

    @GetMapping("/ByPatient/{patientId}")
    private List<Prescription> getPrescriptionByPatientId(@PathVariable("patientId") Long patientId){
        return prescriptionService.getAllPrescriptionsByPatientId(patientId);
    }

    @GetMapping("/ByDoctor/{doctorId}")
    private List<Prescription> getPrescriptionByDoctorId(@PathVariable("doctorId") long doctorId){
        return prescriptionService.getAllPrescriptionsByDoctor(doctorId);
    }


}
