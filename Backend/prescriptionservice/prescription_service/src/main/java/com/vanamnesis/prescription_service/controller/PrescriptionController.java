package com.vanamnesis.prescription_service.controller;

import com.vanamnesis.prescription_service.entity.Prescription;
import com.vanamnesis.prescription_service.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

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
}
