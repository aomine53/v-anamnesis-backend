package com.vanammesis.patientservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.SequenceGenerators;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {

    private long id;

    private String doctorName;

    private String hospitalName;
    private String doctorEmail;

    private String doctorPassword;

    private String licenseNo;

    private String doctorGender;

    private List<Patient> patients;
}
