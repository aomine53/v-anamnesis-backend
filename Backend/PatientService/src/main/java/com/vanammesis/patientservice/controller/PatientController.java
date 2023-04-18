package com.vanammesis.patientservice.controller;


import com.vanammesis.patientservice.entities.Doctor;
import com.vanammesis.patientservice.entities.Patient;
import com.vanammesis.patientservice.external.services.DoctorService;
import com.vanammesis.patientservice.responses.PatientResponse;
import com.vanammesis.patientservice.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/api-patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/signUp")
    public PatientResponse createNewPatient(@RequestBody PatientResponse patientResponse){

        return patientService.createNewPatient(patientResponse);
    }

    @GetMapping()
    public List<PatientResponse> getAllPatient(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{patientId}")
    public PatientResponse getPatientById(@PathVariable("patientId") long patientId){
        return patientService.getPatientById(patientId);
    }

    @DeleteMapping("/delete/{patientId}")
    public String deletePatientById(@PathVariable("patientId") long patientId){
        return patientService.deletePatientById(patientId);
    }

    @PostMapping("/signUp/all")
    public Iterable<Patient> saveAllPatients(@RequestBody List<Patient> patients){

        return patientService.saveAllPatients(patients);
    }

    @GetMapping("/getDoctors")
    public List<Doctor> getDoctor(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/getDoctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") long doctorId){
        return doctorService.getDoctorById(doctorId);
    }


}
