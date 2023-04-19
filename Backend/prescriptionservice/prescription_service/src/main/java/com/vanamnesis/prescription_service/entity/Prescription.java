package com.vanamnesis.prescription_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "medication")
    @OneToMany
    private List<Medication> medication;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "doctorId1")
    private long doctorId;

}
