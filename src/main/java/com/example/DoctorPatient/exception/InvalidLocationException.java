package com.example.DoctorPatient.exception;

public class InvalidLocationException extends RuntimeException {
    public InvalidLocationException(String message) {
        super(message);
    }
}
