package com.example.patientmanage.repository;/*  gaajiCode
    99
    26/09/2025
    */

import com.example.patientmanage.model.Patinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patinet, UUID> {

}
