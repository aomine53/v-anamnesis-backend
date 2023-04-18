package com.vanammesis.patientservice.services;

import com.vanammesis.patientservice.entities.Patient;
import com.vanammesis.patientservice.exceptions.ResourceNotFoundException;
import com.vanammesis.patientservice.repository.PatientRepository;
import com.vanammesis.patientservice.requests.PatientRequest;
import com.vanammesis.patientservice.responses.PatientResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public PatientResponse createNewPatient(PatientResponse patientResponse) {
        patientResponse.setPatientPassword(passwordEncoder.encode(patientResponse.getPatientPassword()));
        Patient patients = modelMapper.map(patientResponse, Patient.class);
        return modelMapper.map(patientRepository.save(patients), PatientResponse.class);
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return modelMapper.map(patientRepository.findAll(), ArrayList.class);
    }

    @Override
    public PatientResponse getPatientById(long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> {
                    throw new ResourceNotFoundException("Patient with id does not exist.");
                }
        );
        return modelMapper.map(patient, PatientResponse.class);
    }

    @Override
    public String deletePatientById(long patientId) {
        if(patientRepository.findById(patientId)== null){
                throw new ResourceNotFoundException("Patient with given id does not exist.");
        }
        else{
            patientRepository.deleteById(patientId);
        }

      return "Patient with id: " + patientId + " has been deleted.";
    }

    @Override
    public PatientResponse getPatientByEmail(String email) {
        Patient patientByPatientEmail = patientRepository.findPatientByPatientEmail(email);
        if (patientByPatientEmail == null){
            throw new ResourceNotFoundException("Patient with given email id does not exist.");
        }
        return modelMapper.map(patientByPatientEmail,PatientResponse.class);

    }

    @Override
    public Iterable<Patient> saveAllPatients(List<Patient> patients) {
        for(Patient patient: patients){
            patient.setPatientPassword(passwordEncoder.encode(patient.getPatientPassword()));
        }
        return patientRepository.saveAll(patients);
    }


}
