package com.vanammesis.patientservice.responses;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse{

    private long patientId;



    private String patientName;

    private String patientEmail;

    private String patientPassword;


}