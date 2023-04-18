package com.vanammesis.patientservice.controller;

import com.vanammesis.patientservice.entities.Doctor;
import com.vanammesis.patientservice.entities.DoctorPatient;
import com.vanammesis.patientservice.entities.Patient;
import com.vanammesis.patientservice.services.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-patients")
public class DoctorPatientController {

    @Autowired
    private DoctorPatientService doctorPatientService;

    @PostMapping("/setDoctor/{doctorId}/setPatient/{patientId}")
    private DoctorPatient setAppointment(@PathVariable("doctorId") Long doctorId, @PathVariable("patientId") Long patientId){
        return doctorPatientService.setAppointmentById(doctorId,patientId);
    }

    @GetMapping("/getAllDoctorsByPatientId/{patientId}")
    private List<Doctor> getDoctorsByPatient(@PathVariable("patientId") long patientId){
        return doctorPatientService.getAllDoctorByPatientId(patientId);
    }

    @GetMapping("/getAllPatientByDoctorId/{doctorId}")
    private List<Patient> getAllPatientByDoctorId(@PathVariable("doctorId") long doctorId){
        return doctorPatientService.getAllPatientByDoctorId(doctorId);
    }
}
