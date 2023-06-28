package com.example.DoctorPatient.controller;
import com.example.DoctorPatient.model.Doctor;
import com.example.DoctorPatient.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor addedDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(addedDoctor, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable("id") Long doctorId) {
        doctorService.removeDoctor(doctorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/suggest/{patientId}")
    public ResponseEntity<List<Doctor>> suggestDoctors(@PathVariable("patientId") Long patientId) {
        List<Doctor> suggestedDoctors = doctorService.getSuggestedDoctors(patientId);
        return new ResponseEntity<>(suggestedDoctors, HttpStatus.OK);
    }
}

