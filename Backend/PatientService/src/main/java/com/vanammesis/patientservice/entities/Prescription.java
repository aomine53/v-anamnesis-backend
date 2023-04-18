package com.vanammesis.patientservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {

    private long id;

    private List<Medication> medication;

    private LocalDate date;

    private long patientDoctorId;

}

