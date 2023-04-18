package com.vanamnesis.prescription_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String medication;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String dosage;
    private String instructions;
    private LocalDate date;
    private long doctorId;
    private long patientId;
}
