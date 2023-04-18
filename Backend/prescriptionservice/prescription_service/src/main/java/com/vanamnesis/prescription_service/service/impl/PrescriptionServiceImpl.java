package com.vanamnesis.prescription_service.service.impl;

import com.vanamnesis.prescription_service.entity.Prescription;
import com.vanamnesis.prescription_service.repository.PrescriptionRepsitory;
import com.vanamnesis.prescription_service.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    PrescriptionRepsitory prescriptionRepsitory;

    @Override
    public Prescription savePrescription(Prescription prescription) {
        prescription.setDate(LocalDate.now());
        return prescriptionRepsitory.save(prescription);
    }

    @Override
    public Prescription getPrescriptionById(long id) {
        return prescriptionRepsitory.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Prescription is not present");
                });
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepsitory.findAll();
    }
}
