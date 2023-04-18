package com.vanammesis.patientservice.services;

import com.vanammesis.patientservice.entities.PatientDetails;
import com.vanammesis.patientservice.exceptions.ResourceNotFoundException;
import com.vanammesis.patientservice.repository.PatientDetailsRepository;
import com.vanammesis.patientservice.requests.PatientDetailsRequest;
import com.vanammesis.patientservice.responses.PatientDetailsResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

    @Autowired
    private PatientDetailsRepository patientDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDetailsResponse createNewDetails(PatientDetailsRequest patientDetailsRequest) {
        PatientDetails patientDetails = patientDetailsRepository.save(modelMapper.map(patientDetailsRequest, PatientDetails.class));
        return modelMapper.map(patientDetails, PatientDetailsResponse.class);
    }

    @Override
    public List<PatientDetailsResponse> getAllPatientDetails() {
        return modelMapper.map(
                patientDetailsRepository.findAll(),
                ArrayList.class
        );
    }

    @Override
    public PatientDetailsResponse getPatientDetailsById(long patientDetailsId) {
        PatientDetails patientDetails = patientDetailsRepository.findById(patientDetailsId).orElseThrow(() -> new ResourceNotFoundException("Patients details does not exist for given id"));
        return modelMapper.map(patientDetails,PatientDetailsResponse.class);
    }

    @Override
    public List<PatientDetailsResponse> getPatientDetailsByPatientId(long patientId) {
        PatientDetails allByPatientId = patientDetailsRepository.findAllByPatientId(patientId);
        if(allByPatientId == null){
            throw new ResourceNotFoundException("No details found for the given patient Id");
        }
        return modelMapper.map(allByPatientId,ArrayList.class);
    }


}
