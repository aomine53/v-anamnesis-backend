package com.vanammesis.patientservice.controller;

import com.vanammesis.patientservice.requests.PatientDetailsRequest;
import com.vanammesis.patientservice.responses.PatientDetailsResponse;
import com.vanammesis.patientservice.services.PatientDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class PatientDetailsController {

    @Autowired
    private PatientDetailsServiceImpl patientDetailsService;

    @PostMapping("/new")
    public PatientDetailsResponse createNewDetails(@RequestBody PatientDetailsRequest patientDetailRequest){
        return patientDetailsService.createNewDetails(patientDetailRequest);
    }

    @GetMapping()
    public List<PatientDetailsResponse> getAllPatientDetails(){
        return patientDetailsService.getAllPatientDetails();
    }

    @GetMapping("/id/{PatientDetailsId}")
    public PatientDetailsResponse getPatientDetailsById(@PathVariable("PatientDetailsId") long patientDetailsId){
        return patientDetailsService.getPatientDetailsById(patientDetailsId);
    }

    @GetMapping("/patient/{patientId}")
    public List<PatientDetailsResponse> getAllPatientDetailsByPatientId(@PathVariable("patientId") long patientId){
        return patientDetailsService.getPatientDetailsByPatientId(patientId);
    }
}
