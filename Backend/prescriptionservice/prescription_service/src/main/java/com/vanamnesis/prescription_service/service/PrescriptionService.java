package com.vanamnesis.prescription_service.service;

import com.vanamnesis.prescription_service.entity.Prescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrescriptionService {
    public Prescription savePrescription(Prescription prescription);
    public Prescription getPrescriptionById(long id);
    public List<Prescription> getAllPrescriptions();
}
