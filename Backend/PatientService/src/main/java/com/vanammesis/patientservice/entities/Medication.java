package com.vanammesis.patientservice.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medication {

    private String medicineName;

    private String time;

    private String dosage;

    private String instructions;
}
