package com.vanammesis.patientservice.services;


import com.vanammesis.patientservice.entities.PatientDetails;
import com.vanammesis.patientservice.requests.PatientDetailsRequest;
import com.vanammesis.patientservice.responses.PatientDetailsResponse;

import java.util.List;

public interface PatientDetailsService {

    public PatientDetailsResponse createNewDetails(PatientDetailsRequest patientDetailsRequest);

    public List<PatientDetailsResponse> getAllPatientDetails();

    public PatientDetailsResponse getPatientDetailsById(long patientDetailsId);

    public PatientDetails getPatientDetailsByPatientId(long patientId);



}
