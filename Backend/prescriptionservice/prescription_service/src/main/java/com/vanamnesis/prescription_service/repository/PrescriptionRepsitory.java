package com.vanamnesis.prescription_service.repository;

import com.vanamnesis.prescription_service.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

public interface PrescriptionRepsitory extends JpaRepository<Prescription, Long>{
}
