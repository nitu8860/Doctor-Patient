package com.example.DoctorPatient.service;
import com.example.DoctorPatient.model.Patient;
import com.example.DoctorPatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void removePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

}
