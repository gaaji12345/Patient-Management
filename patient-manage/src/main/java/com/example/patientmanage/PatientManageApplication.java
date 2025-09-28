package com.example.patientmanage;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PatientManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientManageApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(ctx -> LocalDate.parse(ctx.getSource()), String.class, LocalDate.class);
        return modelMapper;
    }



}
