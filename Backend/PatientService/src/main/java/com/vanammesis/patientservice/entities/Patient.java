package com.vanammesis.patientservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties("hibernateLazyInitializer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "patients")
@Schema(name="PatientEntity", description="Entity class for patients ")
public class Patient {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long patientId;

    @Column(name = "patient_email")
    private String patientEmail;

    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "patient_password")
    private String patientPassword;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PatientDetails> patientDetails;

}
