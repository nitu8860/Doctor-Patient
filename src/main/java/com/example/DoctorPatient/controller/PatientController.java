package com.example.DoctorPatient.controller;
import com.example.DoctorPatient.model.Patient;
import com.example.DoctorPatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient addedPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(addedPatient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePatient(@PathVariable("id") Long patientId) {
        patientService.removePatient(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
