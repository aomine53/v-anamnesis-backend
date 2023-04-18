package com.vanammesis.patientservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PatientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientDetailId;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "patient_symptoms")
    private List<String> patientSymptoms;

    @Column(name = "patient_age")
    private int patientAge;

    @Column(name = "patient_gender")
    private String patientGender;

    @Column(name = "patient_allergy")
    private String hasAllergy;

    @Column(name = "patient_phone")
    private String phoneNumber;

    private LocalDate creationDate;
}
