package com.example.patientmanage.controller;/*  gaajiCode
    99
    26/09/2025
    */

import com.example.patientmanage.dto.PatientResponseDTO;
import com.example.patientmanage.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        List<PatientResponseDTO> patients=patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }




}
