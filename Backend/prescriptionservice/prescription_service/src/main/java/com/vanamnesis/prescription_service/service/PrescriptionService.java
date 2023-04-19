package com.vanamnesis.prescription_service.service;

import com.vanamnesis.prescription_service.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    public Prescription savePrescription(Prescription prescription);
    public Prescription getPrescriptionById(long id);
    public List<Prescription> getAllPrescriptions();

    public List<Prescription> getAllPrescriptionsByDoctor(long doctorId);

    public List<Prescription> getAllPrescriptionsByPatientId(long patientId);
}
