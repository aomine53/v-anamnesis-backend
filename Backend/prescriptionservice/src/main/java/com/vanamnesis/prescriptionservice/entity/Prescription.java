package com.vanamnesis.prescriptionservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "prescription")
public class Prescription {

    @Id
    @Column(name = "prescription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Medication medication;

    private String dosage;

    private String instructions;

    private String status;
}
