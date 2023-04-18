package com.vanammesis.patientservice.repository;

import com.vanammesis.patientservice.entities.Patient;
import com.vanammesis.patientservice.responses.PatientDetailsResponse;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Long> {

    public Patient findPatientByPatientEmail(String email);
}
