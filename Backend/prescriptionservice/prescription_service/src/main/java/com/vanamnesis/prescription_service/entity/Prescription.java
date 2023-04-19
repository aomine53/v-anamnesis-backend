package com.vanamnesis.prescription_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String medication;

    private String time;

    private String dosage;
    private String instructions;
    private LocalDate date;
    private long doctorId;
    private long patientId;
}
