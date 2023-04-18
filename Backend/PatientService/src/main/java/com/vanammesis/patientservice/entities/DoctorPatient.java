package com.vanammesis.patientservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "doctor_patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_patient_id")
    private long doctorPatientId;


    @Column(name = "doctor_id")
    private long doctorId;

    @Column(name = "patient_id")
    private long patientId;


}
