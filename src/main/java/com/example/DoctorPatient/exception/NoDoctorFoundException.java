package com.example.DoctorPatient.exception;

public class NoDoctorFoundException extends RuntimeException {
    public NoDoctorFoundException(String message) {
        super(message);
    }
}
