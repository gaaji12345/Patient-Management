package com.example.patientmanage.exception;/*  gaajiCode
    99
    28/09/2025
    */

import lombok.RequiredArgsConstructor;


public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(String message) {
        super(message);
    }
}
