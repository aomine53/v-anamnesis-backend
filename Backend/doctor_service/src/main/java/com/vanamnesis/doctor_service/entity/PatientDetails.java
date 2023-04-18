package com.vanamnesis.doctor_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetails {


    private long patientDetailId;
    private String patientId;
    private List<String> patientSymptoms;
    private int patientAge;
    private String patientGender;

    private String hasAllergy;
    private String phoneNumber;
    private LocalDate creationDate;
}
