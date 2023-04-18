package com.vanammesis.patientservice.repository;

import com.vanammesis.patientservice.entities.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {
    PatientDetails findAllByPatientId(long patientId);


}
