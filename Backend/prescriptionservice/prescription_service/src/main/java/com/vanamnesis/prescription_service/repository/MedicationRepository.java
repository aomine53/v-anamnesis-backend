package com.vanamnesis.prescription_service.repository;

import com.vanamnesis.prescription_service.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
