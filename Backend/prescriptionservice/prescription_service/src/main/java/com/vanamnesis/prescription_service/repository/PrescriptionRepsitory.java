package com.vanamnesis.prescription_service.repository;

import com.vanamnesis.prescription_service.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface PrescriptionRepsitory extends JpaRepository<Prescription, Long>{

    public List<Prescription> findAllByPatientId(long patientId);

    public List<Prescription> findAllByDoctorId(long doctorId);
}
