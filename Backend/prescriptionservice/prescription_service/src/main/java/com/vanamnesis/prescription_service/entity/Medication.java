package com.vanamnesis.prescription_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long medicationId;

    private String medicineName;

    private String time;

    private String dosage;

    private String instructions;
}
