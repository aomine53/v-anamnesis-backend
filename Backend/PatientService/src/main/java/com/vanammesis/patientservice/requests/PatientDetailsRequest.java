package com.vanammesis.patientservice.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PatientDetailsRequest implements Serializable {

    private long patientDetailId;

    @NotEmpty(message = "Patient id should not be null")
    @NotNull
    private int patientId;

    private List<String> patientSymptoms;

    @Max(value = 120, message = "Age must not be greater than 120.")
    @Min(value = 1, message = "Age must be greater than 1")
    @NotNull
    private int patientAge;

    @NotNull
    @NotEmpty(message = "Patients allergy details should not be null.")
    private String hasAllergy;

    @NotNull
    @NotEmpty(message = "Patient's phone number shouldn't be empty")
    @Length(max = 10)
    private String phoneNumber;

    private LocalDate creationDate;

    @NotEmpty(message = "Patient's gender cannot be empty")
    @NotNull
    private String patientGender;

    public PatientDetailsRequest(){
        this.creationDate = LocalDate.now();
    }
}
