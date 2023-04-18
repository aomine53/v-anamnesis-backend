package com.vanammesis.patientservice.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetailsResponse {

    private long patientDetailId;

    private int patientId;

    private List<String> patientSymptoms;

    private int patientAge;

    private String phoneNumber;

    private String hasAllergy;

    private LocalDate creationDate;

    private String patientGender;
}
