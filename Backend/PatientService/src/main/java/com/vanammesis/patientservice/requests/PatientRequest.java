package com.vanammesis.patientservice.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;
import java.util.Random;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest implements Serializable {

    private long patientId;

    @NotEmpty( message = "patient name should not be null")
    private String patientName;

    @NotEmpty( message = "patient email should not be null")
    private String patientEmail;

    @NotEmpty( message = "patient password should not be null")
    private String patientPassword;

}