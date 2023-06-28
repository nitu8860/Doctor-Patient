package com.example.DoctorPatient.service;

import com.example.DoctorPatient.exception.InvalidLocationException;
import com.example.DoctorPatient.exception.NoDoctorFoundException;
import com.example.DoctorPatient.exception.NotFoundException;
import com.example.DoctorPatient.model.Doctor;
import com.example.DoctorPatient.model.Patient;
import com.example.DoctorPatient.repository.DoctorRepository;
import com.example.DoctorPatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }


    public List<Doctor> getSuggestedDoctors(Long patientId) {
        // Retrieve the patient by ID
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new NotFoundException("Patient not found with ID: " + patientId));

        // Check if the patient's location is within Delhi, Noida, or Faridabad
        String patientCity = patient.getCity();
        if (!isValidCity(patientCity)) {
            throw new InvalidLocationException("We are still waiting to expand to your location");
        }

        // Retrieve the doctors with the matching speciality based on the patient's symptom
        String patientSymptom = patient.getSymptom();
        List<Doctor> doctors = doctorRepository.findBySpecialityAndCity(patientSymptom, patientCity);
        if (doctors.isEmpty()) {
            // If no doctors are found for the given symptom and location, fallback to doctors with the same speciality
            doctors = doctorRepository.findBySpeciality(patientSymptom);
            if (doctors.isEmpty()) {
                throw new NoDoctorFoundException("There isn't any doctor available for your symptom");
            }
        }

        return doctors;
    }


    private boolean isValidCity(String city) {
        return "Delhi".equalsIgnoreCase(city) || "Noida".equalsIgnoreCase(city)
                || "Faridabad".equalsIgnoreCase(city);
    }
}
