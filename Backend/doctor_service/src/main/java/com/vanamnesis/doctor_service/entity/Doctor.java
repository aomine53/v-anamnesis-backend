package com.vanamnesis.doctor_service.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name="doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String doctorName;
    @Column(nullable = false)
    private String hospitalName;
    @Column(name= "license_no",nullable = false)
    private String licenseNo;
    @Column(nullable = false, unique = true)
    private String doctorEmail;
    @Column(nullable = false)
    private String doctorPassword;
    @Column(nullable = false)
    private String doctorGender;
}
