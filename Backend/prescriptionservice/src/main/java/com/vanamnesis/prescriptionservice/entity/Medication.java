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
@Entity(name = "medication")
public class Medication {

    @Id
    @Column(name = "medication_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicationName;


}
