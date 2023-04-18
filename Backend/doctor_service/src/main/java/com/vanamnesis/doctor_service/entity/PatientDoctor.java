package com.vanamnesis.doctor_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "patient_doctor")
public class PatientDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patientDoctorId")
    private long patientDoctorId;
    @Column(name = "patient_id")
    private long patientID;
    @Column(name = "doctor_id")
    private long doctorId;
}
