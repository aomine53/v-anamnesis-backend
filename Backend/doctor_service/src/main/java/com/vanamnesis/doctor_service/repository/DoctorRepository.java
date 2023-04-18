package com.vanamnesis.doctor_service.repository;

import com.vanamnesis.doctor_service.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByDoctorEmail(String email);
}
