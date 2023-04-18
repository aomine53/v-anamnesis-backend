package com.vanammesis.patientservice.services;


import com.vanammesis.patientservice.entities.Patient;
import com.vanammesis.patientservice.requests.PatientRequest;
import com.vanammesis.patientservice.responses.PatientResponse;

import java.util.List;

public interface PatientService {

    public PatientResponse createNewPatient(PatientResponse patientResponse);

    public List<PatientResponse> getAllPatients();

    public PatientResponse getPatientById(long patientId);

    public String deletePatientById(long patientId);

    public PatientResponse getPatientByEmail(String email);

    public Iterable<Patient> saveAllPatients(List<Patient> patient);
}
