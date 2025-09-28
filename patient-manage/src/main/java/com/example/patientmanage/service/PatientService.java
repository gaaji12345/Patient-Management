package com.example.patientmanage.service;/*  gaajiCode
    99
    26/09/2025
    */

import com.example.patientmanage.dto.PatientRequestDTO;
import com.example.patientmanage.dto.PatientResponseDTO;
import com.example.patientmanage.exception.EmailAlreadyExistsException;
import com.example.patientmanage.exception.PatientNotFoundException;
import com.example.patientmanage.model.Patinet;
import com.example.patientmanage.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
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

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email"
            + "already exists"+patientRequestDTO.getEmail());
        }
        // DTO -> Entity
        Patinet patient = modelMapper.map(patientRequestDTO, Patinet.class);

        // Save to DB
        Patinet savedPatient = patientRepository.save(patient);

        // Entity -> ResponseDTO
        return modelMapper.map(savedPatient, PatientResponseDTO.class);
    }

    public PatientResponseDTO updatePatient(UUID id,PatientRequestDTO patientRequestDTO){

        Patinet patient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with ID: " + id));

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email"
                    + "already exists"+patientRequestDTO.getEmail());
        }

        // Map only updated fields from DTO → entity
        modelMapper.map(patientRequestDTO, patient);

        // Save updated entity
        Patinet updatedPatient = patientRepository.save(patient);

        // Convert Entity → ResponseDTO
        return modelMapper.map(updatedPatient, PatientResponseDTO.class);





    }









}
