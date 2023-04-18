package com.vanammesis.patientservice.services;

import com.vanammesis.patientservice.entities.Doctor;
import com.vanammesis.patientservice.entities.DoctorPatient;
import com.vanammesis.patientservice.entities.Patient;
import com.vanammesis.patientservice.external.services.DoctorServiceImpl;
import com.vanammesis.patientservice.repository.DoctorPatientRepository;
import com.vanammesis.patientservice.responses.PatientResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorPatientService {

    @Autowired
    private DoctorServiceImpl doctorService;

    @Autowired
    private DoctorPatientRepository doctorPatientRepository;

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private ModelMapper modelMapper;
    public List<Doctor> getAllDoctorByPatientId(long patientId){
        List<DoctorPatient> allByPatientId = doctorPatientRepository.findAllByPatientId(patientId);
        List<Doctor> doctorList = new ArrayList<>();
        for(DoctorPatient doctorPatient:  allByPatientId){
            doctorList.add(doctorService.getDoctorById(doctorPatient.getDoctorId()));
        }

        return doctorList;
    }

    public DoctorPatient setAppointmentById(long doctorId, long patientId){
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setDoctorId(doctorId);
        doctorPatient.setPatientId(patientId);

        return doctorPatientRepository.save(doctorPatient);
    }

    public List<Patient> getAllPatientByDoctorId(long doctorId){
        List<Patient> patients = new ArrayList<>();
        List<DoctorPatient> allByDoctorId = doctorPatientRepository.findAllByDoctorId(doctorId);
        for(DoctorPatient doctorPatient: allByDoctorId){
            PatientResponse patientById = patientService.getPatientById(doctorPatient.getPatientId());
            patients.add( modelMapper.map(patientById, Patient.class));
        }
    return patients;
    }
}
