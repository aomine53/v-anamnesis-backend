package com.vanammesis.patientservice.repository;

import com.vanammesis.patientservice.entities.Doctor;
import com.vanammesis.patientservice.entities.DoctorPatient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Long> {

    List<DoctorPatient> findAllByPatientId(long patientId);

    List<DoctorPatient> findAllByDoctorId(long doctorId);
}
