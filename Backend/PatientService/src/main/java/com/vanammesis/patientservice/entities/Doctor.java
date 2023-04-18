package com.vanammesis.patientservice.entities;

import java.util.List;

public class Doctor {

    private long id;

    private String name;

    private String email;

    private String password;

    private String licenseNo;

    private String gender;

    private List<Patient> patients;
}
