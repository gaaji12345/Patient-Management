package com.example.patientmanage.model;/*  gaajiCode
    99
    26/09/2025
    */

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "patient")

@Data

public class Patinet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String address;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private LocalDate registerDate;
}
