package com.vanamnesis.doctor_service.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {


    private long patientId;


    private String patientEmail;


    private String patientName;

    private String patientPassword;


    private List<PatientDetails> patientDetails;

}
