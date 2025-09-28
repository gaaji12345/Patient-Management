package com.example.patientmanage.service;/*  gaajiCode
    99
    26/09/2025
    */

import com.example.patientmanage.dto.PatientRequestDTO;
import com.example.patientmanage.dto.PatientResponseDTO;
import com.example.patientmanage.model.Patinet;
import com.example.patientmanage.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private ModelMapper modelMapper;

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }


//    public List<PatientResponseDTO> getPatients(){
//        List<Patinet> patients=patientRepository.findAll();
//
//    }

    public List<PatientResponseDTO> getPatients() {
        List<Patinet> patients = patientRepository.findAll();

        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDTO.class))
                .collect(Collectors.toList());
    }


//    public PatientRequestDTO createPatient(PatientRequestDTO patientRequestDTO){
//        Patinet patinet=patientRepository.save(PatientMapper.toModel(patientRequestDTO));
//
//        return PatinetMapper.toDTO(patinet);
//    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        // DTO -> Entity
        Patinet patient = modelMapper.map(patientRequestDTO, Patinet.class);

        // Save to DB
        Patinet savedPatient = patientRepository.save(patient);

        // Entity -> ResponseDTO
        return modelMapper.map(savedPatient, PatientResponseDTO.class);
    }







}
